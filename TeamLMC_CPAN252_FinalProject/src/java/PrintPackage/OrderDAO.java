
package PrintPackage;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    //declare these jdbc variables for later use
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    
    public OrderDAO(){
        
    }
    //constructor to get the values of jdbc from the servlet that called this
    public OrderDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    public List<Order> listAllOrders() throws SQLException{
        List<Order> listOrders = new ArrayList<>();
        int id, flyerQTY, personalCopy;
        String flyerLayout, paymentInfo, comments, invoiceNum, flyerImg;
        int isFlyerArtApproved, isPaymentReceived;
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
            Blob blob = resultSet.getBlob("flyerImg");
            personalCopy = resultSet.getInt("personalCopy");
            paymentInfo = resultSet.getString("paymentInformation");
            invoiceNum = resultSet.getString("invoiceNumber");
            comments = resultSet.getString("comments");
            isFlyerArtApproved = resultSet.getInt("isFlyerArtApproved");
            isPaymentReceived = resultSet.getInt("isPaymentReceived");
            
            byte[] bdata = blob.getBytes(1, (int) blob.length());
            flyerImg = new String(bdata);
            
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
    
    //same logic as above, but will return different list,
    //you wil be able to see the type of list by looking at the method name
   
    public List<Order> listApprovedOrders() throws SQLException{
        List<Order> listApprovedOrders = new ArrayList<>();
        int id, flyerQTY, personalCopy;
        String flyerLayout, paymentInfo, comments, invoiceNum, flyerImg;
        int isFlyerArtApproved, isPaymentReceived;
        int agentID, clientID;
        
        String sql = "SELECT * FROM orders ORDER BY isFlyerArtApproved DESC";
        
        connect();
        Statement stmt = jdbcConnection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        
        while (resultSet.next()) {
            id = resultSet.getInt("id");
            agentID = resultSet.getInt("agentId");
            clientID = resultSet.getInt("clientId");
            flyerQTY = resultSet.getInt("flyerQty");
            flyerLayout = resultSet.getString("flyerLayout");
            Blob blob = resultSet.getBlob("flyerImg");
            personalCopy = resultSet.getInt("personalCopy");
            paymentInfo = resultSet.getString("paymentInformation");
            invoiceNum = resultSet.getString("invoiceNumber");
            comments = resultSet.getString("comments");
            isFlyerArtApproved = resultSet.getInt("isFlyerArtApproved");
            isPaymentReceived = resultSet.getInt("isPaymentReceived");
            
            byte[] bdata = blob.getBytes(1, (int) blob.length());
            flyerImg = new String(bdata);
            
            Order orderObj = new Order(id, flyerQTY, flyerLayout, flyerImg, personalCopy, 
                    paymentInfo, invoiceNum, comments, isFlyerArtApproved, isPaymentReceived, 
                    agentID, clientID);
            listApprovedOrders.add(orderObj);
        }
        
        resultSet.close();
        stmt.close();
        disconnect();
        
        return listApprovedOrders;
    }
    
    //same logic as above, but will return different list,
    //you wil be able to see the type of list by looking at the method name
    public List<Order> listNoPayOrders() throws SQLException{
        List<Order> listNoPayOrders = new ArrayList<>();
        int id, flyerQTY, personalCopy;
        String flyerLayout, paymentInfo, comments, invoiceNum, flyerImg;
        int isFlyerArtApproved, isPaymentReceived;
        int agentID, clientID;
        
        String sql = "SELECT * FROM orders WHERE isPaymentReceived = 0";
        
        connect();
        Statement stmt = jdbcConnection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        
        while (resultSet.next()) {
            id = resultSet.getInt("id");
            agentID = resultSet.getInt("agentId");
            clientID = resultSet.getInt("clientId");
            flyerQTY = resultSet.getInt("flyerQty");
            flyerLayout = resultSet.getString("flyerLayout");
            Blob blob = resultSet.getBlob("flyerImg");
            personalCopy = resultSet.getInt("personalCopy");
            paymentInfo = resultSet.getString("paymentInformation");
            invoiceNum = resultSet.getString("invoiceNumber");
            comments = resultSet.getString("comments");
            isFlyerArtApproved = resultSet.getInt("isFlyerArtApproved");
            isPaymentReceived = resultSet.getInt("isPaymentReceived");
            
            byte[] bdata = blob.getBytes(1, (int) blob.length());
            flyerImg = new String(bdata);
            
            Order orderObj = new Order(id, flyerQTY, flyerLayout, flyerImg, personalCopy, 
                    paymentInfo, invoiceNum, comments, isFlyerArtApproved, isPaymentReceived, 
                    agentID, clientID);
            listNoPayOrders.add(orderObj);
        }
        
        resultSet.close();
        stmt.close();
        disconnect();
        
        return listNoPayOrders;
    }
    
    //method to insert a record to a database
    //get needed values from the form that called this method
    //set these values as a parameter for our sql insert query
    //after that get how many rows are inserted
    //0 means no rows = false, >1 means >1 rows = true
    public int insertOrder(Order orderObj) throws SQLException {
        String sql = "INSERT INTO orders (agentId, clientId, flyerQty, flyerLayout, flyerImg, "
                + "paymentInformation, personalCopy, invoiceNumber, comments, isFlyerArtApproved, "
                + "isPaymentReceived) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        String blobimg = orderObj.getFlyerImg();
        byte[] byteContent = blobimg.getBytes();
        connect();
        PreparedStatement stmt = jdbcConnection.prepareStatement(sql);
        Blob blob = jdbcConnection.createBlob();
        blob.setBytes(1, byteContent);
        
        stmt.setInt(1, orderObj.getAgentID());
        stmt.setInt(2, orderObj.getClientID());
        stmt.setInt(3, orderObj.getFlyerQTY());
        stmt.setString(4, orderObj.getFlyerLayout());
        stmt.setBlob(5, blob);
        stmt.setString(6, orderObj.getPaymentInfo());
        stmt.setInt(7, orderObj.getPersonalCopy());
        stmt.setString(8, orderObj.getInvoiceNum());
        stmt.setString(9, orderObj.getComments());
        stmt.setInt(10, orderObj.getIsFlyerArtApproved());
        stmt.setInt(11, orderObj.getIsPaymentReceived());
        boolean rowsInserted = stmt.executeUpdate()>0;
        sql = "SELECT MAX(id) FROM orders";
        Statement stm = jdbcConnection.createStatement();
        ResultSet resultSet = stm.executeQuery(sql);
        int id = 0;
        while(resultSet.next()){
            id = resultSet.getInt(1);
        }
        stmt.close();
        disconnect();
        return id;
    }
    
    //method used to get a specific database value using the
    //id that you get from the form that called this method
    //after getting the values from the database,
    //save this as a specific object (object type can be seen by looking at the method name)
    //and return it to the method caller
    public Order getOrder(int id) throws SQLException {
        Order order = null;
        String sql = "SELECT * FROM orders WHERE id = ?";
        
        connect();
        PreparedStatement stmt = jdbcConnection.prepareStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet resultSet = stmt.executeQuery();
        
        if(resultSet.next()){
            int agentID = resultSet.getInt("agentId");
            int clientID = resultSet.getInt("clientId");
            int flyerQTY = resultSet.getInt("flyerQty");
            String flyerLayout = resultSet.getString("flyerLayout");
            Blob blob = resultSet.getBlob("flyerImg");
            int personalCopy = resultSet.getInt("personalCopy");
            String paymentInfo = resultSet.getString("paymentInformation");
            String invoiceNum = resultSet.getString("invoiceNumber");
            String comments = resultSet.getString("comments");
            int isFlyerArtApproved = resultSet.getInt("isFlyerArtApproved");
            int isPaymentReceived = resultSet.getInt("isPaymentReceived");
            
            
            byte[] bdata = blob.getBytes(1, (int) blob.length());
            String flyerImg = new String(bdata);
            
            order = new Order(id, flyerQTY, flyerLayout, flyerImg, personalCopy,
                    paymentInfo, invoiceNum, comments, isFlyerArtApproved, 
                    isPaymentReceived, agentID, clientID);
        }
        
        resultSet.close();
        stmt.close();
        
        return order;
    }
    
    //method used to update a specific object (object type can be seen by looking at the method name)
    //we will get the information needed from the form of method caller
    //we will then set these information as the parameter for our update query
    //after that, we will get how many rows are updated
    //0 = no rows = false, >1 = >1 rows = true
    //then return the boolean to see if there was update rows or not
    public boolean updateOrder(Order orderObj) throws SQLException {
        String sql = "UPDATE orders SET clientId=?, flyerQty=?, flyerLayout=?, "
                + "flyerImg=?, personalCopy=?, paymentInformation=?, invoiceNumber=?, "
                + "comments=?, isFlyerArtApproved=?, isPaymentReceived=? "
                + "WHERE id=?";
        String blobimg = orderObj.getFlyerImg();
        byte[] byteContent = blobimg.getBytes();
        connect();
        PreparedStatement stmt = jdbcConnection.prepareStatement(sql);
        Blob blob = jdbcConnection.createBlob();
        blob.setBytes(1, byteContent);
        
        connect();
        
        stmt.setInt(1, orderObj.getClientID());
        stmt.setInt(2, orderObj.getFlyerQTY());
        stmt.setString(3, orderObj.getFlyerLayout());
        stmt.setBlob(4, blob);
        stmt.setInt(5, orderObj.getPersonalCopy());
        stmt.setString(6, orderObj.getPaymentInfo());
        stmt.setString(7, orderObj.getInvoiceNum());
        stmt.setString(8, orderObj.getComments());
        stmt.setInt(9, orderObj.getIsFlyerArtApproved());
        stmt.setInt(10, orderObj.getIsPaymentReceived());
        stmt.setInt(11, orderObj.getId());
        
        boolean rowUpdated = stmt.executeUpdate()>0;
        stmt.close();
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
    public boolean deleteOrder(int orderID) throws SQLException {
        String sql = "DELETE FROM orders WHERE id = ?";
        
        connect();
        
        PreparedStatement stmt = jdbcConnection.prepareStatement(sql);
        stmt.setInt(1, orderID);
        
        boolean rowDeleted = stmt.executeUpdate()>0;
        stmt.close();
        disconnect();
        return rowDeleted;
    }
    
    //method to delete a specific object(type of object can be seen by looking at the method name)
    //we will get the id from the form that called this method
    //which we will then use the id as a parameter for our delete query
    //after that, we will proceed to delete the object
    //after that, we will get how many rows are updated
    //0 = no rows = false, >1 = >1 rows = true
    //then return the boolean to see if there was update rows or not
    public boolean deleteLocationxOrder(int orderID) throws SQLException {
        String sql2 = "DELETE FROM locationxorders WHERE orderId = ?";
        
        connect();
        
        PreparedStatement stmt = jdbcConnection.prepareStatement(sql2);
        stmt.setInt(1, orderID);
        
        boolean rowDeleted = stmt.executeUpdate()>0;
        stmt.close();
        disconnect();
        return rowDeleted;
    }
    
    //method to insert a record to a database
    //get needed values from the form that called this method
    //set these values as a parameter for our sql insert query
    //after that get how many rows are inserted
    //0 means no rows = false, >1 means >1 rows = true
    public boolean insertLocationXOrder(int orderID, Location locationObj) 
            throws SQLException{
        String sql = "INSERT INTO locationxorders (orderId,locationId) VALUES (?,?)";
        
        connect();
        PreparedStatement stmt = jdbcConnection.prepareStatement(sql);
        
        stmt.setInt(1, orderID);
        stmt.setInt(2, locationObj.getId());
        boolean rowsInserted = stmt.executeUpdate()>0;
        disconnect();
        return rowsInserted;
    }
}
