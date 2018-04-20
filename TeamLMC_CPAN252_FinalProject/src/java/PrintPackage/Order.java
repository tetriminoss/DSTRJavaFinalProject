/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrintPackage;

/**
 *
 * @author Jason
 */
public class Order {
    private int id, flyerQTY, personalCopy;
    private String flyerLayout, paymentInfo, comments, invoiceNum, flyerImg;
    private boolean isFlyerArtApproved, isPaymentReceived = false;
    private int agentID, clientID;
    
    public Order(){
        
    }
    
    public Order(int id){
        this.id = id;
    }
    
    public Order(int id, int flyerQTY, String flyerLayout, String flyerImg, int personalCopy, 
            String paymentInfo, String invoice, String comments, boolean flyerApproved, 
            boolean paymentReceived, int agentID, int clientID){
        this.id = id;
        this.flyerQTY = flyerQTY;
        this.flyerLayout = flyerLayout;
        this.flyerImg = flyerImg;
        this.personalCopy = personalCopy;
        this.paymentInfo = paymentInfo;
        this.invoiceNum = invoice;
        this.comments = comments;
        this.isFlyerArtApproved = flyerApproved;
        this.isPaymentReceived = paymentReceived;
        this.agentID = agentID;
        this.clientID = clientID;
    }
    
    public Order(int id, int agentID, int clientID){
        this.id = id;
        this.agentID = agentID;
        this.clientID = clientID;
    }
    
    public Order(int flyerQTY, String flyerLayout, String flyerImg, int personalCopy, 
            String paymentInfo, String invoice, String comments, boolean flyerApproved, 
            boolean paymentReceived){
        this.flyerQTY = flyerQTY;
        this.flyerLayout = flyerLayout;
        this.flyerImg = flyerImg;
        this.personalCopy = personalCopy;
        this.paymentInfo = paymentInfo;
        this.invoiceNum = invoice;
        this.comments = comments;
        this.isFlyerArtApproved = flyerApproved;
        this.isPaymentReceived = paymentReceived;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlyerQTY() {
        return flyerQTY;
    }

    public void setFlyerQTY(int flyerQTY) {
        this.flyerQTY = flyerQTY;
    }

    public int getPersonalCopy() {
        return personalCopy;
    }

    public void setPersonalCopy(int personalCopy) {
        this.personalCopy = personalCopy;
    }

    public String getFlyerLayout() {
        return flyerLayout;
    }

    public void setFlyerLayout(String flyerLayout) {
        this.flyerLayout = flyerLayout;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getFlyerImg() {
        return flyerImg;
    }

    public void setFlyerImg(String flyerImg) {
        this.flyerImg = flyerImg;
    }

    public boolean isIsFlyerArtApproved() {
        return isFlyerArtApproved;
    }

    public void setIsFlyerArtApproved(boolean isFlyerArtApproved) {
        this.isFlyerArtApproved = isFlyerArtApproved;
    }

    public boolean isIsPaymentReceived() {
        return isPaymentReceived;
    }

    public void setIsPaymentReceived(boolean isPaymentReceived) {
        this.isPaymentReceived = isPaymentReceived;
    }

    public int getAgentID() {
        return agentID;
    }

    public void setAgentID(int agentID) {
        this.agentID = agentID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
}
