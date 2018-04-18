package PrintPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class LoginDAO {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public LoginDAO() {
    }

    public LoginDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public List<Login> listAllLogins() throws SQLException {
        List<Login> listLogin = new ArrayList<>();
        int id;
        String userName;
        String password;
        String role;
        int agentId;

        String sql = "SELECT * from login";

        connect();
        Statement stmt = jdbcConnection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        while (resultSet.next()) {
            id = resultSet.getInt("id");
            userName = resultSet.getString("userName");
            password = resultSet.getString("password");
            role = resultSet.getString("role");
            agentId = resultSet.getInt("agentId");

            Login loginObj = new Login(id, userName, password, role, agentId);
            listLogin.add(loginObj);
        }

        resultSet.close();
        stmt.close();
        disconnect();

        return listLogin;
    }

    public boolean insertLoginRecord(Login loginObj) throws SQLException {
        String sql = "INSERT INTO login (userName,password,role,agentId) VALUES(?,?,?,?)";
        connect();
        PreparedStatement stmt = jdbcConnection.prepareStatement(sql);
        stmt.setString(1, loginObj.getUserName());
        stmt.setString(2, loginObj.getPassword());
        stmt.setString(3, loginObj.getRole());
        stmt.setInt(4, loginObj.getAgentId());
        boolean rowsInserted = stmt.executeUpdate() > 0;
        disconnect();
        return rowsInserted;
    }

    public Login getLogin(int id) throws SQLException {
        Login login = null;
        String sql = "SELECT * FROM login WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String userName = resultSet.getString("userName");
            String password = resultSet.getString("password");
            String role = resultSet.getString("role");
            int agentId = resultSet.getInt("agentId");
            login = new Login(id, userName,password,role,agentId);
        }

        resultSet.close();
        statement.close();

        return login;
    }
    
    public Login doLogin(String userName, String password) throws SQLException{
        Login login = null;
        String sql = "SELECT * FROM login WHERE userName = ? and password = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, userName);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        
        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String role = resultSet.getString("role");
            int agentId = resultSet.getInt("agentId");
            login = new Login(id, userName, role, agentId);
        }

        resultSet.close();
        statement.close();
        
        return login;
    }

    public boolean updateLogin(Login login) throws SQLException {
        String sql = "UPDATE login SET userName = ?, password = ?";
        sql += " WHERE id = ?";
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, login.getUserName());
        statement.setString(2, login.getPassword());
        statement.setInt(3, login.getId());
        
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public boolean deleteLogin(Login login) throws SQLException {
        String sql = "DELETE FROM login where id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, login.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }
}
