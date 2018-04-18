package PrintPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class MarketingAgentDAO {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public MarketingAgentDAO() {
    }

    public MarketingAgentDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

    public List<MarketingAgent> listAllMarketingAgents() throws SQLException {
        List<MarketingAgent> listMarketingAgent = new ArrayList<>();
        int id;
        String firstName, lastName, phoneNo, email;

        String sql = "SELECT * from marketingagent";

        connect();
        Statement stmt = jdbcConnection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        while (resultSet.next()) {
            id = resultSet.getInt("id");
            firstName = resultSet.getString("firstName");
            lastName = resultSet.getString("lastName");
            phoneNo = resultSet.getString("phoneNo");
            email = resultSet.getString("email");
            MarketingAgent marketingAgentObj = new MarketingAgent(id, firstName, lastName, phoneNo, email);
            listMarketingAgent.add(marketingAgentObj);
        }

        resultSet.close();
        stmt.close();
        disconnect();

        return listMarketingAgent;
    }

    public boolean insertMarketingAgentRecord(MarketingAgent marketingAgentObj) throws SQLException {
        String sql = "INSERT INTO marketingagent (firstName, lastName, phoneNo, email) VALUES(?,?,?,?)";
        connect();
        PreparedStatement stmt = jdbcConnection.prepareStatement(sql);
        stmt.setString(1, marketingAgentObj.getFirstName());
        stmt.setString(2, marketingAgentObj.getLastName());
        stmt.setString(3, marketingAgentObj.getPhoneNo());
        stmt.setString(4, marketingAgentObj.getEmail());
        boolean rowsInserted = stmt.executeUpdate() > 0;
        disconnect();
        return rowsInserted;
    }

    public MarketingAgent getMarketingAgent(int id) throws SQLException {
        MarketingAgent marketingAgent = null;
        String sql = "SELECT * FROM marketingagent WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String phoneNo = resultSet.getString("phoneNo");
            String email = resultSet.getString("email");

            marketingAgent = new MarketingAgent(id, firstName, lastName, phoneNo, email);
        }

        resultSet.close();
        statement.close();

        return marketingAgent;
    }

    public boolean updateMarketingAgent(MarketingAgent marketingAgent) throws SQLException {
        String sql = "UPDATE marketingagent SET firstName = ?, lastName = ?, phoneNo = ?, email = ?";
        sql += " WHERE id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, marketingAgent.getFirstName());
        statement.setString(2, marketingAgent.getLastName());
        statement.setString(3, marketingAgent.getPhoneNo());
        statement.setString(4, marketingAgent.getEmail());
        statement.setInt(5, marketingAgent.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public boolean deleteMarketingAgent(MarketingAgent marketingAgent) throws SQLException {
        String sql = "DELETE FROM marketingagent where id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, marketingAgent.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }
}
