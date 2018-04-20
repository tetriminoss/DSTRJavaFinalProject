
package PrintPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    
    public OrderDAO(){
        
    }
    
    public OrderDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    
    public List<Order> listAllOrders() throws SQLException{
        List<Order> listOrders = new ArrayList<>();
        int id, flyerQTY, personalCopy;
        String flyerLayout, paymentInfo, comments, invoiceNum, flyerImg;
        boolean isFlyerArtApproved, isPaymentReceived;
        int agentID, clientID;
        
        String sql = "SELECT * FROM orders";
        
        connect();
        Statement stmt = jdbcConnection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        
        while (resultSet.next()) {
            id = resultSet.getInt("id");
            agentID = resultSet.getInt("agentId");
            clientID = resultSet.getInt("clientId");
            flyerQTY = resultSet.getInt("flyerQty");
            flyerLayout = resultSet.getString("flyerLayout");
            flyerImg = resultSet.getString("flyerImg");
            personalCopy = resultSet.getInt("personalCopy");
            paymentInfo = resultSet.getString("paymentInformation");
            invoiceNum = resultSet.getString("invoiceNumber");
            comments = resultSet.getString("comments");
            isFlyerArtApproved = resultSet.getBoolean("isFlyerArtApproved");
            isPaymentReceived = resultSet.getBoolean("isPaymentReceived");
            
            Order orderObj = new Order(id, flyerQTY, flyerLayout, flyerImg, personalCopy, 
                    paymentInfo, invoiceNum, comments, isFlyerArtApproved, isPaymentReceived, 
                    agentID, clientID);
            listOrders.add(orderObj);
        }
        
        resultSet.close();
        stmt.close();
        disconnect();
        
        return listOrders;
    }
}
