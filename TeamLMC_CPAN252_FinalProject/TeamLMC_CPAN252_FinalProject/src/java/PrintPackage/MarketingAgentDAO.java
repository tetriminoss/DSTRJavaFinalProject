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
//declare these jdbc variables for later use
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public MarketingAgentDAO() {
    }
//constructor to get the values of jdbc from the servlet that called this
    public MarketingAgentDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

    //method to insert a record to a database
    //get needed values from the form that called this method
    //set these values as a parameter for our sql insert query
    //after that get how many rows are inserted
    //0 means no rows = false, >1 means >1 rows = true
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

    //method used to get a specific database value using the
    //id that you get from the form that called this method
    //after getting the values from the database,
    //save this as a specific object (object type can be seen by looking at the method name)
    //and return it to the method caller
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

    //method used to update a specific object (object type can be seen by looking at the method name)
    //we will get the information needed from the form of method caller
    //we will then set these information as the parameter for our update query
    //after that, we will get how many rows are updated
    //0 = no rows = false, >1 = >1 rows = true
    //then return the boolean to see if there was update rows or not
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

    //method to delete a specific object(type of object can be seen by looking at the method name)
    //we will get the id from the form that called this method
    //which we will then use the id as a parameter for our delete query
    //after that, we will proceed to delete the object
    //after that, we will get how many rows are updated
    //0 = no rows = false, >1 = >1 rows = true
    //then return the boolean to see if there was update rows or not
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
