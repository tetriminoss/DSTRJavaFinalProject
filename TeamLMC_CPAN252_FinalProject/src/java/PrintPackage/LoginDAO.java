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
//declare these jdbc variables for later use
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public LoginDAO() {
    }
//constructor to get the values of jdbc from the servlet that called this
    public LoginDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
//connect to the database using the jdbc driver
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

        //disconnect to avoid bugs and errors, really preferred to disconnect the database after use
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    //a method used to list values that are needed from the database
    //these values from the database will be then store to the variables
    //and with these variables, we will make a list that we will return to the method caller
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

    //method to insert a record to a database
    //get needed values from the form that called this method
    //set these values as a parameter for our sql insert query
    //after that get how many rows are inserted
    //0 means no rows = false, >1 means >1 rows = true
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

    //method used to get a specific database value using the
    //id that you get from the form that called this method
    //after getting the values from the database,
    //save this as a specific object (object type can be seen by looking at the method name)
    //and return it to the method caller
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
    
    //method to login
    //this will select the role of the user using the username and the password
    //as the parameter for the selct query
    //after that we will then set the found information from the select query,
    //then return to the method caller
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

    //method used to update a specific object (object type can be seen by looking at the method name)
    //we will get the information needed from the form of method caller
    //we will then set these information as the parameter for our update query
    //after that, we will get how many rows are updated
    //0 = no rows = false, >1 = >1 rows = true
    //then return the boolean to see if there was update rows or not
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

    //method to delete a specific object(type of object can be seen by looking at the method name)
    //we will get the id from the form that called this method
    //which we will then use the id as a parameter for our delete query
    //after that, we will proceed to delete the object
    //after that, we will get how many rows are updated
    //0 = no rows = false, >1 = >1 rows = true
    //then return the boolean to see if there was update rows or not
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
