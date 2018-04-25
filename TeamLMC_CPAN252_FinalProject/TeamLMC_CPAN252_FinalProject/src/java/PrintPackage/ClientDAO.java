package PrintPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class ClientDAO {

    //declare these jdbc variables
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public ClientDAO() {
    }

    //our main constructor
    public ClientDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    //this code will be used to connect to our database
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

    //this will be used when everything is done, disconnect so that nothing wrong will happen at the end
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    //this is our method that returns a set of values from the database,
    //saving them to a list and returning them at the end
    public List<Client> listAllClients() throws SQLException {
        List<Client> listClient = new ArrayList<>();

        //declare for later use
        int id;
        int agentId;
        String firstName, lastName, streetNumber, streetName, city, province, postalCode, telOffice, telCell, email, company, companyType;

        //our select query
        String sql = "SELECT * from clients";

        connect();
        Statement stmt = jdbcConnection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        //this where the reading and setting part happens
        while (resultSet.next()) {
            id = resultSet.getInt("id");
            agentId = resultSet.getInt("agentId");
            firstName = resultSet.getString("firstName");
            lastName = resultSet.getString("lastName");
            streetNumber = resultSet.getString("streetNumber");
            streetName = resultSet.getString("streetName");
            city = resultSet.getString("city");
            province = resultSet.getString("province");
            postalCode = resultSet.getString("postalCode");
            telOffice = resultSet.getString("telOffice");
            telCell = resultSet.getString("telCell");
            email = resultSet.getString("email");
            company = resultSet.getString("company");
            companyType = resultSet.getString("companyType");
            Client clientObj = new Client(id, agentId, firstName, lastName, streetNumber, streetName, city, province, postalCode, telOffice, telCell, email, company, companyType);
            listClient.add(clientObj);
        }

        resultSet.close();
        stmt.close();
        disconnect();

        //return the list
        return listClient;
    }

    //this is our insert method 
    public boolean insertClientRecord(Client clientObj) throws SQLException {
        //our insert query
        String sql = "INSERT INTO clients (agentId, firstName, lastName, streetNumber, streetName, city, province, postalCode, telOffice, telCell, email, company, companyType) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        connect();
        
        //following codes will be for setting the parameter values for our insert query
        PreparedStatement stmt = jdbcConnection.prepareStatement(sql);
        stmt.setInt(1, clientObj.getAgentId());
        stmt.setString(2, clientObj.getFirstName());
        stmt.setString(3, clientObj.getLastName());
        stmt.setString(4, clientObj.getStreetNumber());
        stmt.setString(5, clientObj.getStreetName());
        stmt.setString(6, clientObj.getCity());
        stmt.setString(7, clientObj.getProvince());
        stmt.setString(8, clientObj.getPostalCode());
        stmt.setString(9, clientObj.getTelOffice());
        stmt.setString(10, clientObj.getTelCell());
        stmt.setString(11, clientObj.getEmail());
        stmt.setString(12, clientObj.getCompany());
        stmt.setString(13, clientObj.getCompanyType());
        boolean rowsInserted = stmt.executeUpdate() > 0;
        disconnect();
        
        //return if there was inserted or not
        return rowsInserted;
    }

    //this will get a specific client based on the id
    public Client getClient(int id) throws SQLException {
        Client client = null;
        
        //our string query
        String sql = "SELECT * FROM clients WHERE id = ?";

        connect();

        //setting the id to the query
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        //while reading, set the found data to the variables
        if (resultSet.next()) {
            int agentId = resultSet.getInt("agentId");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String streetNumber = resultSet.getString("streetNumber");
            String streetName = resultSet.getString("streetName");
            String city = resultSet.getString("city");
            String province = resultSet.getString("province");
            String postalCode = resultSet.getString("postalCode");
            String telOffice = resultSet.getString("telOffice");
            String telCell = resultSet.getString("telCell");
            String email = resultSet.getString("email");
            String company = resultSet.getString("company");
            String companyType = resultSet.getString("companyType");

            //make a new client then save it to premade client 
            client = new Client(id, agentId, firstName, lastName, streetNumber, streetName, city, province, postalCode, telOffice, telCell, email, company, companyType);

        }

        resultSet.close();
        statement.close();

        //return the client to whatever called this
        return client;
    }

    //this is our update method
    public boolean updateClient(Client client) throws SQLException {
        
        //our update query
        String sql = "UPDATE clients SET agentId = ?, firstName = ?, lastName = ?, streetNumber = ?, streetName = ?, city = ?, province = ?, postalCode = ?,"
                + " telOffice = ?, telCell = ?, email = ?, company = ?, companyType = ?";
        sql += " WHERE id = ?";
        connect();

        //set these values for our update query
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, client.getAgentId());
        statement.setString(2, client.getFirstName());
        statement.setString(3, client.getLastName());
        statement.setString(4, client.getStreetNumber());
        statement.setString(5, client.getStreetName());
        statement.setString(6, client.getCity());
        statement.setString(7, client.getProvince());
        statement.setString(8, client.getPostalCode());
        statement.setString(9, client.getTelOffice());
        statement.setString(10, client.getTelCell());
        statement.setString(11, client.getEmail());
        statement.setString(12, client.getCompany());
        statement.setString(13, client.getCompanyType());
        statement.setInt(14, client.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        
        //return if there was update or not
        return rowUpdated;
    }

    //this is our method for deleting
    public boolean deleteClient(Client client) throws SQLException {
        String sql = "DELETE FROM clients where id = ?";

        connect();

        //set the value to the query
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, client.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        
        //return if there was deleted row or not
        return rowDeleted;
    }
}
