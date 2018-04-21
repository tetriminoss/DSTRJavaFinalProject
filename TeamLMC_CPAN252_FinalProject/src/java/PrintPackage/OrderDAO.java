
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
    
    public boolean insertOrder(Order orderObj) throws SQLException {
        String sql = "INSERT INTO orders (agentId, clientId, flyerQty, flyerLayout, flyerImg, "
                + "paymentInformation, personalCopy, invoiceNumber, comments, isFlyerArtApproved, "
                + "isPaymentReceived) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        
        connect();
        PreparedStatement stmt = jdbcConnection.prepareStatement(sql);
        
        stmt.setInt(1, orderObj.getAgentID());
        stmt.setInt(2, orderObj.getClientID());
        stmt.setInt(3, orderObj.getFlyerQTY());
        stmt.setString(4, orderObj.getFlyerLayout());
        stmt.setString(5, orderObj.getFlyerImg());
        stmt.setString(6, orderObj.getPaymentInfo());
        stmt.setInt(7, orderObj.getPersonalCopy());
        stmt.setString(8, orderObj.getInvoiceNum());
        stmt.setString(9, orderObj.getComments());
        stmt.setBoolean(10, orderObj.isIsFlyerArtApproved());
        stmt.setBoolean(11, orderObj.isIsPaymentReceived());
        boolean rowsInserted = stmt.executeUpdate()>0;
        disconnect();
        return rowsInserted;
    }
    
    public Order getOrder(int id) throws SQLException {
        Order order = null;
        String sql = "SELECT * FROM orderes WHERE id = ?";
        
        connect();
        PreparedStatement stmt = jdbcConnection.prepareStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet resultSet = stmt.executeQuery();
        
        if(resultSet.next()){
            int agentID = resultSet.getInt("agentId");
            int clientID = resultSet.getInt("clientId");
            int flyerQTY = resultSet.getInt("flyerQty");
            String flyerLayout = resultSet.getString("flyerLayout");
            String flyerImg = resultSet.getString("flyerImg");
            int personalCopy = resultSet.getInt("personalCopy");
            String paymentInfo = resultSet.getString("paymentInformation");
            String invoiceNum = resultSet.getString("invoiceNumber");
            String comments = resultSet.getString("comments");
            boolean isFlyerArtApproved = resultSet.getBoolean("isFlyerArtApproved");
            boolean isPaymentReceived = resultSet.getBoolean("isPaymentReceived");
            
            order = new Order(id, flyerQTY, flyerLayout, flyerImg, personalCopy,
                    paymentInfo, invoiceNum, comments, isFlyerArtApproved, 
                    isPaymentReceived, agentID, clientID);
        }
        
        resultSet.close();
        stmt.close();
        
        return order;
    }
    
    public boolean updateOrder(Order orderObj) throws SQLException {
        String sql = "UPDATE orders SET clientId=?, flyerQty=?, flyerLayout=?, "
                + "flyerImg=?, personalCopy=?, paymentInformation=?, invoiceNumber=?, "
                + "comments=?, isFlyerArtApproved=?, isPaymentReceived=? "
                + "WHERE id=?";
        
        connect();
        
        PreparedStatement stmt = jdbcConnection.prepareStatement(sql);
        stmt.setInt(1, orderObj.getClientID());
        stmt.setInt(2, orderObj.getFlyerQTY());
        stmt.setString(3, orderObj.getFlyerLayout());
        stmt.setString(4, orderObj.getFlyerImg());
        stmt.setInt(5, orderObj.getPersonalCopy());
        stmt.setString(6, orderObj.getPaymentInfo());
        stmt.setString(7, orderObj.getInvoiceNum());
        stmt.setString(8, orderObj.getComments());
        stmt.setBoolean(9, orderObj.isIsFlyerArtApproved());
        stmt.setBoolean(10, orderObj.isIsPaymentReceived());
        stmt.setInt(11, orderObj.getId());
        
        boolean rowUpdated = stmt.executeUpdate()>0;
        stmt.close();
        disconnect();
        return rowUpdated;
    }
    
    public boolean deleteOrder(Order orderObj) throws SQLException {
        String sql = "DELETE FORM orders WHERE id = ?";
        
        connect();
        
        PreparedStatement stmt = jdbcConnection.prepareStatement(sql);
        stmt.setInt(1, orderObj.getId());
        
        boolean rowDeleted = stmt.executeUpdate()>0;
        stmt.close();
        disconnect();
        return rowDeleted;
    }
}
