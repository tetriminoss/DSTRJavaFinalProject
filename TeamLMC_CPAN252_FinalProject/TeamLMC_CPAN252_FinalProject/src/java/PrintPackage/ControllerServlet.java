package PrintPackage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControllerServlet extends HttpServlet {

    //declare these variable for later use
    LocationDAO locationDAO;
    MarketingAgentDAO marketingAgentDAO;
    LoginDAO loginDAO;
    OrderDAO orderDAO;
    ClientDAO clientDAO;
    HttpSession session = null;

    //init method, always runs at the start
    public void init() {
        
        //set these values to the jdbc variables
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        //set these DAOs to the variables
        locationDAO = new LocationDAO(jdbcURL, jdbcUsername, jdbcPassword);
        marketingAgentDAO = new MarketingAgentDAO(jdbcURL, jdbcUsername, jdbcPassword);
        loginDAO = new LoginDAO(jdbcURL, jdbcUsername, jdbcPassword);
        orderDAO = new OrderDAO(jdbcURL, jdbcUsername, jdbcPassword);
        clientDAO = new ClientDAO(jdbcURL, jdbcUsername, jdbcPassword);

    }

    //nothing, just redirect to the doPost
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        //request.getSession().isNew();
        //the switch cases, will redirect to different JSPs based on the action
        try {
            switch (action) {
                case "/new":
                    session = request.getSession(false);
                    if (session != null) {
                        showNewLocationForm(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/insert":
                    session = request.getSession(false);
                    if (session != null) {
                        insertLocationRecord(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/delete":
                    session = request.getSession(false);
                    if (session != null) {
                        deleteLocation(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/edit":
                    session = request.getSession(false);
                    if (session != null) {
                        showEditForm(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/update":
                    session = request.getSession(false);
                    if (session != null) {
                        updateLocation(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/updateLogin":
                    session = request.getSession(false);
                    if (session != null) {
                        updateLogin(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/newLogin":
                    session = request.getSession(false);
                    if (session != null) {
                        showNewLoginForm(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/newAgent":
                    session = request.getSession(false);
                    if (session != null) {
                        showNewMarketingAgentForm(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/insertAgent":
                    session = request.getSession(false);
                    if (session != null) {
                        insertMarketingAgentRecord(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/insertLogin":
                    session = request.getSession(false);
                    if (session != null) {
                        insertLoginRecord(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/deleteAgent":
                    session = request.getSession(false);
                    if (session != null) {
                        deleteMarketingAgent(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/deleteLogin":
                    session = request.getSession(false);
                    if (session != null) {
                        deleteLogin(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/editAgent":
                    session = request.getSession(false);
                    if (session != null) {
                        showMarketingAgentEditForm(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/editLogin":
                    session = request.getSession(false);
                    if (session != null) {
                        showLoginEditForm(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/updateAgent":
                    session = request.getSession(false);
                    if (session != null) {
                        updateMarketingAgent(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/list":
                    session = request.getSession(false);
                    if (session != null) {
                        listAllLocations(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/listAgents":
                    session = request.getSession(false);
                    if (session != null) {
                        listAllMarketingAgents(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/login":
                    login(request, response);
                    break;
                case "/listLogins":
                    session = request.getSession(false);
                    if (session != null) {
                        listAllLogins(request, response);
                        //Login newLogin = (Login)session.getAttribute("newLogin");
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/newOrder":
                    session = request.getSession(false);
                    if (session != null) {
                        showNewOrderForm(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/listOrder":
                    session = request.getSession(false);
                    if (session != null) {
                        listAllOrders(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/approvedOrdersList":
                    session = request.getSession(false);
                    if (session != null) {
                        listApprovedOrders(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/noPayOrdersList":
                    session = request.getSession(false);
                    if (session != null) {
                        listNoPayOrders(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;    
                case "/insertOrder":
                    session = request.getSession(false);
                    if (session != null) {
                        insertOrderRecord(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/newClient":
                    session = request.getSession(false);
                    if (session != null) {
                        showNewClientForm(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/newClientAdmin":
                    session = request.getSession(false);
                    if (session != null) {
                        showNewClientFormAdmin(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/insertClient":
                    session = request.getSession(false);
                    if (session != null) {
                        insertClientRecord(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/insertClientAdmin":
                    session = request.getSession(false);
                    if (session != null) {
                        insertClientRecordAdmin(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/editClient":
                    session = request.getSession(false);
                    if (session != null) {
                        showClientEditForm(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/updateClient":
                    session = request.getSession(false);
                    if (session != null) {
                        updateClient(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/agentList":
                    session = request.getSession(false);
                    if (session != null) {
                        listAllClientsForAgent(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/adminList":
                    session = request.getSession(false);
                    if (session != null) {
                        listAllClientsForAdmin(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/deleteClient":
                    session = request.getSession(false);
                    if (session != null) {
                        deleteClient(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/deleteOrder":
                    session = request.getSession(false);
                    if (session != null) {
                        deleteOrder(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/editOrder":
                    session = request.getSession(false);
                    if (session != null) {
                        showOrderEditForm(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                case "/updateOrder":
                    session = request.getSession(false);
                    if (session != null) {
                        updateOrder(request, response);
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    break;
                default:
                    request.getSession().invalidate();
                    response.sendRedirect("/TeamLMC_CPAN252_FinalProject/login.jsp");
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    //method to list all locations
    private void listAllLocations(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<Location> listLocation = locationDAO.listAllLocations();
        request.setAttribute("listLocation", listLocation);
        RequestDispatcher dispatcher = request.getRequestDispatcher("locationList.jsp");
        dispatcher.forward(request, response);
    }

    //method to list all logins
    private void listAllLogins(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<Login> listLogin = loginDAO.listAllLogins();
        request.setAttribute("listLogin", listLogin);
        RequestDispatcher dispatcher = request.getRequestDispatcher("loginList.jsp");
        dispatcher.forward(request, response);
    }

    private void listAllMarketingAgents(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<MarketingAgent> listMarketingAgent = marketingAgentDAO.listAllMarketingAgents();
        request.setAttribute("listMarketingAgent", listMarketingAgent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("marketingAgentList.jsp");
        dispatcher.forward(request, response);
    }

    //method to list all orders
    private void listAllOrders(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Order> listOrder = orderDAO.listAllOrders();
        request.setAttribute("listOrder", listOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("orderList.jsp");
        dispatcher.forward(request, response);
    }
    
    //method to list all approvedOrders
    private void listApprovedOrders(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Order> listApprovedOrder = orderDAO.listApprovedOrders();
        request.setAttribute("listApprovedOrder", listApprovedOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("approvedOrderList.jsp");
        dispatcher.forward(request, response);
    }
    
    //method to list all unpaid orders
    private void listNoPayOrders(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Order> listNoPaydOrder = orderDAO.listNoPayOrders();
        request.setAttribute("listNoPaydOrder", listNoPaydOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("noPayOrderList.jsp");
        dispatcher.forward(request, response);
    }

    //method to list all clients for agent
    private void listAllClientsForAgent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<Client> listClient = clientDAO.listAllClients();
        request.setAttribute("listClient", listClient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("agentList.jsp");
        dispatcher.forward(request, response);
    }

    //method to list all admin
    private void listAllClientsForAdmin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<Client> listClient = clientDAO.listAllClients();
        request.setAttribute("listClient", listClient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("adminList.jsp");
        dispatcher.forward(request, response);
    }

    //method to show the new location frm
    private void showNewLocationForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("locationForm.jsp");
        dispatcher.forward(request, response);
    }

    //method to sho new login form
    private void showNewLoginForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("loginForm.jsp");
        List<MarketingAgent> listMarketingAgent = marketingAgentDAO.listAllMarketingAgents();
        request.setAttribute("listMarketingAgent", listMarketingAgent);
        dispatcher.forward(request, response);
    }

    //method to show new marketing agent form
    private void showNewMarketingAgentForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("marketingAgentForm.jsp");
        dispatcher.forward(request, response);
    }

    //show new order form
    private void showNewOrderForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, SQLException {
        
        //get the list of all, and set to the request.setAttribute so the orderForm can use these lists
        List<Location> listLocation = locationDAO.listAllLocations();
        request.setAttribute("listLocation", listLocation);
        List<MarketingAgent> listMarketingAgent = marketingAgentDAO.listAllMarketingAgents();
        request.setAttribute("listMarketingAgent", listMarketingAgent);
        List<Client> listClient = clientDAO.listAllClients();
        request.setAttribute("listClients", listClient);
        Order o = new Order();
        RequestDispatcher dispatcher = request.getRequestDispatcher("orderForm.jsp");
        dispatcher.forward(request, response);
    }

    //show new client form
    private void showNewClientForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("newClientForm.jsp");
        dispatcher.forward(request, response);
    }

    //show new client form for admin
    private void showNewClientFormAdmin(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("newClientFormAdmin.jsp");
        dispatcher.forward(request, response);
    }

    //method to insert location record
    private void insertLocationRecord(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int distributionCapacity;
        String locationName = request.getParameter("locationName");
        
        //following set of ifs and try catchs are for validation, not allowing invalid inputs
        try {
            distributionCapacity = Integer.parseInt(request.getParameter("distributionCapacity"));
        } catch (Exception e) {
            distributionCapacity = 0;
        }
        if (locationName == null || locationName.equals("")/*|| distributionCapacity != (int)distributionCapacity*/) {
            String message = "please enter a location name";
            RequestDispatcher rd = request.getRequestDispatcher("locationForm.jsp");
            request.setAttribute("message", message);
            rd.forward(request, response);
        } else {
            Location locationObj = new Location(locationName, distributionCapacity);
            locationDAO.insertLocationRecord(locationObj);
            response.sendRedirect("list");
        }
    }

    //method to inser new marketing agent record
    private void insertMarketingAgentRecord(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        //get parameters from last form that called this method
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNo = request.getParameter("phoneNo");
        String email = request.getParameter("email");

        //these sets of ifs are for validation, not allowing null
        if (firstName == null || firstName.equals("") || lastName == null || lastName.equals("") || phoneNo == null || phoneNo.equals("")
                || email == null || email.equals("")) {
            String message = "please fully complete form";
            RequestDispatcher rd = request.getRequestDispatcher("marketingAgentForm.jsp");
            request.setAttribute("message", message);
            rd.forward(request, response);
        } else {
            //if evverything is fine, go on
            MarketingAgent marketingAgentObj = new MarketingAgent(firstName, lastName, phoneNo, email);
            marketingAgentDAO.insertMarketingAgentRecord(marketingAgentObj);
            response.sendRedirect("listAgents");
        }
    }

    //method to insert login record
    private void insertLoginRecord(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        //declare these variables
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordConfirm");
        String agentIdStr = request.getParameter("agentId");

        //this sets of ifs are for validation, not allowing null
        if (agentIdStr.equals("Choose...") || agentIdStr == null || agentIdStr.equals("")) {
            String messageAgentId = "please select an agent ID";
            RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
            List<MarketingAgent> listMarketingAgent = marketingAgentDAO.listAllMarketingAgents();
            request.setAttribute("listMarketingAgent", listMarketingAgent);
            request.setAttribute("messageAgentId", messageAgentId);
            rd.forward(request, response);
        }

        //check if password is identical or not
        int agentId = Integer.parseInt(request.getParameter("agentId"));

        if (!password.equals(passwordConfirm)) {
            String messageConfirm = "please enter identical passwords";
            RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
            List<MarketingAgent> listMarketingAgent = marketingAgentDAO.listAllMarketingAgents();
            request.setAttribute("listMarketingAgent", listMarketingAgent);
            request.setAttribute("messageConfirm", messageConfirm);
            rd.forward(request, response);
        }

        if (userName == null || userName.equals("") || password == null || password.equals("")) {
            String message = "please enter User Name";
            RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
            List<MarketingAgent> listMarketingAgent = marketingAgentDAO.listAllMarketingAgents();
            request.setAttribute("listMarketingAgent", listMarketingAgent);
            request.setAttribute("message", message);
            rd.forward(request, response);
        } else {
            try {
                //try this
                Login login = new Login(userName, password, "agent", agentId);
                loginDAO.insertLoginRecord(login);
                response.sendRedirect("listLogins");
            } catch (SQLException e) {
                //if failed do this
                String errorMessage = "That user name is already taken, please choose another";
                List<MarketingAgent> listMarketingAgent = marketingAgentDAO.listAllMarketingAgents();
                request.setAttribute("listMarketingAgent", listMarketingAgent);
                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
                rd.forward(request, response);
            }
        }
    }

    //method to insert order record
    private void insertOrderRecord(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        //get these values from the form that called this method
        String flyerQtyStr = request.getParameter("flyerQty");
        String flyerLayout = request.getParameter("flyerLayout");
        String locationIDStr = request.getParameter("locationID");
        String flyerImg = request.getParameter("flyerImg");
        String paymentInfo = request.getParameter("creditNum") + " " + request.getParameter("creditExp")
                + " " + request.getParameter("creditCVV");
        String personalCopyStr = request.getParameter("personalCopies");
        String clientIDStr = request.getParameter("clientID");
        String invoice = request.getParameter("invoiceNum");
        String comments = request.getParameter("comments");
        int agentID = Integer.parseInt(request.getParameter("agentID"));

        //validation, not allowing null
        if (flyerQtyStr.equals("") || flyerLayout.equals("") || locationIDStr.equals("")
                || flyerImg.equals("") || paymentInfo.equals("") || personalCopyStr.equals("")
                || clientIDStr.equals("") || invoice.equals("") || comments.equals("")) {
            //say these things to the user
            String message = "Form is blank...";
            RequestDispatcher rd = request.getRequestDispatcher("orderForm.jsp");
            List<Location> listLocation = locationDAO.listAllLocations();
            request.setAttribute("listLocation", listLocation);
            List<MarketingAgent> listMarketingAgent = marketingAgentDAO.listAllMarketingAgents();
            request.setAttribute("listMarketingAgent", listMarketingAgent);
            List<Client> listClient = clientDAO.listAllClients();
            request.setAttribute("listClients", listClient);
            request.setAttribute("message", message);
            rd.forward(request, response);
        }

        //same as above, not allowing nulls
        if (clientIDStr.equals("Select Client...") || clientIDStr == null || clientIDStr.equals("")) {
            String message = "Please select a Client...";
            RequestDispatcher rd = request.getRequestDispatcher("orderForm.jsp");
            List<Location> listLocation = locationDAO.listAllLocations();
            request.setAttribute("listLocation", listLocation);
            List<MarketingAgent> listMarketingAgent = marketingAgentDAO.listAllMarketingAgents();
            request.setAttribute("listMarketingAgent", listMarketingAgent);
            List<Client> listClient = clientDAO.listAllClients();
            request.setAttribute("listClients", listClient);
            request.setAttribute("message", message);
            rd.forward(request, response);
        }
        int clientID = Integer.parseInt(clientIDStr);
        //same as above not allowing nulls
        if (flyerLayout.equals("Select Layout...") || flyerLayout == null || flyerLayout.equals("")) {
            String message = "Please select a Layout...";
            RequestDispatcher rd = request.getRequestDispatcher("orderForm.jsp");
            List<Location> listLocation = locationDAO.listAllLocations();
            request.setAttribute("listLocation", listLocation);
            List<MarketingAgent> listMarketingAgent = marketingAgentDAO.listAllMarketingAgents();
            request.setAttribute("listMarketingAgent", listMarketingAgent);
            List<Client> listClient = clientDAO.listAllClients();
            request.setAttribute("listClients", listClient);
            request.setAttribute("message", message);
            rd.forward(request, response);
        }
        //same as above not allowing nulls
        if (flyerQtyStr.equals("") || locationIDStr.equals("") || flyerImg.equals("")
                || paymentInfo.equals("") || personalCopyStr.equals("") || invoice == null || comments.equals("")) {
            String message = "Field has been left empty";
            RequestDispatcher rd = request.getRequestDispatcher("orderForm.jsp");
            List<Location> listLocation = locationDAO.listAllLocations();
            request.setAttribute("listLocation", listLocation);
            List<MarketingAgent> listMarketingAgent = marketingAgentDAO.listAllMarketingAgents();
            request.setAttribute("listMarketingAgent", listMarketingAgent);
            List<Client> listClient = clientDAO.listAllClients();
            request.setAttribute("listClients", listClient);
            request.setAttribute("message", message);
            rd.forward(request, response);
        }
        //same as above not allowing nulls
        if (flyerImg.equals("")) {
            String message = "No Image has been uploaded";
            RequestDispatcher rd = request.getRequestDispatcher("orderForm.jsp");
            List<Location> listLocation = locationDAO.listAllLocations();
            request.setAttribute("listLocation", listLocation);
            List<MarketingAgent> listMarketingAgent = marketingAgentDAO.listAllMarketingAgents();
            request.setAttribute("listMarketingAgent", listMarketingAgent);
            List<Client> listClient = clientDAO.listAllClients();
            request.setAttribute("listClients", listClient);
            request.setAttribute("message", message);
            rd.forward(request, response);
        } else {
            //if everything is going as intended proceed
            //store these values to a variable
            int flyerQty = Integer.parseInt(flyerQtyStr);
            int personalCopy = Integer.parseInt(personalCopyStr);
            int locationID = Integer.parseInt(locationIDStr);
            //make a new order
            Order order = new Order(agentID, clientID, flyerQty, flyerLayout, flyerImg, personalCopy,
                    paymentInfo, invoice, comments);
            //store these, then set to the listOrder
            int id = orderDAO.insertOrder(order);
            System.out.println("orderid=" + id);
            Location location = new Location(locationID);
            location.setId(locationID);
            orderDAO.insertLocationXOrder(id, location);
            response.sendRedirect("listOrder");
        }

    }

    //method to update order
    private void updateOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        //store these variable from the form that called this method
        int ID = Integer.parseInt(request.getParameter("orderID"));
        String flyerQtyStr = request.getParameter("flyerQty");
        String flyerLayout = request.getParameter("flyerLayout");
        String locationIDStr = request.getParameter("locationID");
        String flyerImg = request.getParameter("flyerImg");
        String paymentInfo = request.getParameter("creditNum") + " " + request.getParameter("creditExp")
                + " " + request.getParameter("creditCVV");
        String personalCopyStr = request.getParameter("personalCopies");
        String clientIDStr = request.getParameter("clientID");
        String invoice = request.getParameter("invoiceNum");
        String comments = request.getParameter("comments");
        int agentID = Integer.parseInt(request.getParameter("agentID"));
        int isFlyerApproved = Integer.parseInt(request.getParameter("isFlyerArtApproved"));
        int isPaid = Integer.parseInt(request.getParameter("isPaymentReceived"));

        //validation, not allowing null
        if (clientIDStr.equals("Select Client...") || clientIDStr == null || clientIDStr.equals("")) {
            String message = "Please select a Client...";
            RequestDispatcher rd = request.getRequestDispatcher("orderForm.jsp");
            List<Location> listLocation = locationDAO.listAllLocations();
            request.setAttribute("listLocation", listLocation);
            List<MarketingAgent> listMarketingAgent = marketingAgentDAO.listAllMarketingAgents();
            request.setAttribute("listMarketingAgent", listMarketingAgent);
            List<Client> listClient = clientDAO.listAllClients();
            request.setAttribute("listClients", listClient);
            request.setAttribute("message", message);
            rd.forward(request, response);
        }
        int clientID = Integer.parseInt(clientIDStr);

        //same as above, not allowing nulls
        if (flyerLayout.equals("Select Layout...") || flyerLayout == null || flyerLayout.equals("")) {
            String message = "Please select a Layout...";
            RequestDispatcher rd = request.getRequestDispatcher("orderForm.jsp");
            List<Location> listLocation = locationDAO.listAllLocations();
            request.setAttribute("listLocation", listLocation);
            List<MarketingAgent> listMarketingAgent = marketingAgentDAO.listAllMarketingAgents();
            request.setAttribute("listMarketingAgent", listMarketingAgent);
            List<Client> listClient = clientDAO.listAllClients();
            request.setAttribute("listClients", listClient);
            request.setAttribute("message", message);
            rd.forward(request, response);
        }
        //same as above, not allowing nulls
        if (flyerQtyStr.equals("") || locationIDStr.equals("") || flyerImg.equals("")
                || paymentInfo.equals("") || personalCopyStr.equals("") || invoice == null || comments.equals("")) {
            String message = "Field has been left empty";
            RequestDispatcher rd = request.getRequestDispatcher("orderForm.jsp");
            List<Location> listLocation = locationDAO.listAllLocations();
            request.setAttribute("listLocation", listLocation);
            List<MarketingAgent> listMarketingAgent = marketingAgentDAO.listAllMarketingAgents();
            request.setAttribute("listMarketingAgent", listMarketingAgent);
            List<Client> listClient = clientDAO.listAllClients();
            request.setAttribute("listClients", listClient);
            request.setAttribute("message", message);
            rd.forward(request, response);
        }
        //same as above, not allowing nulls
        if (flyerImg.equals("")) {
            String message = "No Image has been uploaded";
            RequestDispatcher rd = request.getRequestDispatcher("orderForm.jsp");
            List<Location> listLocation = locationDAO.listAllLocations();
            request.setAttribute("listLocation", listLocation);
            List<MarketingAgent> listMarketingAgent = marketingAgentDAO.listAllMarketingAgents();
            request.setAttribute("listMarketingAgent", listMarketingAgent);
            List<Client> listClient = clientDAO.listAllClients();
            request.setAttribute("listClients", listClient);
            request.setAttribute("message", message);
            rd.forward(request, response);
        } else {
            //if everything has proceed as intended, do these
            
            //store these values to a variable
            int flyerQty = Integer.parseInt(flyerQtyStr);
            int personalCopy = Integer.parseInt(personalCopyStr);
            int locationID = Integer.parseInt(locationIDStr);
            //make new order
            Order order = new Order(agentID, clientID, flyerQty, flyerLayout, flyerImg, personalCopy,
                    paymentInfo, invoice, comments, isFlyerApproved, isPaid);
            order.setId(ID);
            
            //delete old location x order
            orderDAO.deleteLocationxOrder(ID);
            
            //make new location
            Location location = new Location(locationID);
            location.setId(locationID);
            
            //set a new location x order
            orderDAO.insertLocationXOrder(ID, location);
            orderDAO.updateOrder(order);
            
            //redirect to listOrder
            response.sendRedirect("listOrder");
        }
    }

    //method to insert a new client order
    private void insertClientRecord(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        //store these values from the form that called this method
        String agentId = request.getParameter("agentId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String streetNumber = request.getParameter("streetNumber");
        String streetName = request.getParameter("streetName");
        String city = request.getParameter("city");
        String province = request.getParameter("province");
        String postalCode = request.getParameter("postalCode");
        String telOffice = request.getParameter("telOffice");
        String telCell = request.getParameter("telCell");
        String email = request.getParameter("email");
        String company = request.getParameter("company");
        String companyType = request.getParameter("companyType");

        //validation, not allowing nulls
        if (agentId == null || agentId.equals("") || firstName == null || firstName.equals("") || lastName == null || lastName.equals("")
                || streetNumber == null || streetNumber.equals("") || streetName == null || streetName.equals("")
                || city == null || city.equals("") || province == null || province.equals("") || postalCode == null || postalCode.equals("")
                || telOffice == null || telOffice.equals("") || telCell == null || telCell.equals("") || email == null || email.equals("")
                || company == null || company.equals("") || companyType == null || companyType.equals("")) {
            String message = "please fully complete form";
            RequestDispatcher rd = request.getRequestDispatcher("newClientForm.jsp");
            request.setAttribute("message", message);
            rd.forward(request, response);
        } else {
            //if everything is proceeding as inteded, do this
            int agentIdd = Integer.parseInt(agentId);
            //make new client
            Client clientObj = new Client(agentIdd, firstName, lastName, streetNumber, streetName, city, province, postalCode, telOffice, telCell, email, company, companyType);
           //insert the new client
            clientDAO.insertClientRecord(clientObj);
            
            //redirect to agentList
            response.sendRedirect("agentList");
        }
    }

    //method to insert client record for admin
    private void insertClientRecordAdmin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        //store these values from the form that called this method
        String agentId = request.getParameter("agentId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String streetNumber = request.getParameter("streetNumber");
        String streetName = request.getParameter("streetName");
        String city = request.getParameter("city");
        String province = request.getParameter("province");
        String postalCode = request.getParameter("postalCode");
        String telOffice = request.getParameter("telOffice");
        String telCell = request.getParameter("telCell");
        String email = request.getParameter("email");
        String company = request.getParameter("company");
        String companyType = request.getParameter("companyType");

        //validation, not allowing nulls
        if (agentId == null || agentId.equals("") || firstName == null || firstName.equals("") || lastName == null || lastName.equals("")
                || streetNumber == null || streetNumber.equals("") || streetName == null || streetName.equals("")
                || city == null || city.equals("") || province == null || province.equals("") || postalCode == null || postalCode.equals("")
                || telOffice == null || telOffice.equals("") || telCell == null || telCell.equals("") || email == null || email.equals("")
                || company == null || company.equals("") || companyType == null || companyType.equals("")) {
            String message = "please fully complete form";
            RequestDispatcher rd = request.getRequestDispatcher("newClientForm.jsp");
            request.setAttribute("message", message);
            rd.forward(request, response);
        } else {
            //if everything has proceeded as intended, do this
            int agentIdd = Integer.parseInt(agentId);
            
            //make new clientobj
            Client clientObj = new Client(agentIdd, firstName, lastName, streetNumber, streetName, city, province, postalCode, telOffice, telCell, email, company, companyType);
            clientDAO.insertClientRecord(clientObj);
            
            //redirect to adminList
            response.sendRedirect("adminList");
        }
    }

    //method to show edit form
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

       
        int id = Integer.parseInt(request.getParameter("id"));
        
        //store location that has been selected
        Location existinglocation = locationDAO.getLocation(id);
        //send the form with the location's values on it
        RequestDispatcher dispatcher = request.getRequestDispatcher("locationForm.jsp");
        request.setAttribute("location", existinglocation);
        dispatcher.forward(request, response);
    }

    //show the client edit form
    private void showClientEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        //get the existing client with the use of id
        int id = Integer.parseInt(request.getParameter("id"));
        Client existingClient = clientDAO.getClient(id);
        
        //send the values from the client and send to the form
        RequestDispatcher dispatcher = request.getRequestDispatcher("newClientFormAdmin.jsp");
        request.setAttribute("client", existingClient);
        dispatcher.forward(request, response);
    }

    //the method of loggin in
    private void login(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        //get the information from the login.jsp
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        String message = "";
        
        //get the username and password from the login.jsp
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Login newLogin = loginDAO.doLogin(userName, password);
        
        //validation not allowing null
        if (newLogin == null) {
            message = "Incorrect Username and/or Password entered";
            request.setAttribute("message", message);
            rd.forward(request, response);
            //check the roles of the user, show different JSPs dependin on the role
            //set the session, as to validate the user for proceeding
            //then send to the JSP
        } else if (newLogin.role.equalsIgnoreCase("admin")) {
            session = request.getSession();
            session.setAttribute("newLogin", newLogin);
            rd = request.getRequestDispatcher("admin.jsp");
            request.setAttribute("login", newLogin);
            rd.forward(request, response);
        } else if (newLogin.role.equalsIgnoreCase("agent")) {
            session = request.getSession();
            session.setAttribute("newLogin", newLogin);
            rd = request.getRequestDispatcher("agent.jsp");
            request.setAttribute("login", newLogin);
            rd.forward(request, response);
        } else {
            message = "Incorrect Username and/or Password entered";
            request.setAttribute("message", message);
            rd.forward(request, response);
        }
    }

    //show the marketing agent edit form
    private void showMarketingAgentEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        //get the existing agent and store it to a variable
        int id = Integer.parseInt(request.getParameter("id"));
        MarketingAgent existingMarketingAgent = marketingAgentDAO.getMarketingAgent(id);
        //get the values and send it to the form
        RequestDispatcher dispatcher = request.getRequestDispatcher("marketingAgentForm.jsp");
        request.setAttribute("marketingAgent", existingMarketingAgent);
        dispatcher.forward(request, response);
    }

    //show login edit form
    private void showLoginEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        //get the existing login value using the id
        int id = Integer.parseInt(request.getParameter("id"));
        Login existingLogin = loginDAO.getLogin(id);
        
        //send the value from the login and send it to the form
        RequestDispatcher dispatcher = request.getRequestDispatcher("loginForm.jsp");
        request.setAttribute("login", existingLogin);
        dispatcher.forward(request, response);
    }

    //show the order edit for
    private void showOrderEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        //get lists of different things using the id and send it to the next form
        int id = Integer.parseInt(request.getParameter("id"));
        List<Location> listLocation = locationDAO.listAllLocations();
        request.setAttribute("listLocation", listLocation);
        List<MarketingAgent> listMarketingAgent = marketingAgentDAO.listAllMarketingAgents();
        request.setAttribute("listMarketingAgent", listMarketingAgent);
        List<Client> listClient = clientDAO.listAllClients();
        request.setAttribute("listClients", listClient);
        Order existingOrder = orderDAO.getOrder(id);
        
        //store the values from the existing order
        String paymentInfo = existingOrder.getPaymentInfo();
        String creditNum = paymentInfo.substring(0, 16);
        String creditExp = paymentInfo.substring(17, 22);
        String creditCVV = paymentInfo.substring(23, 26);
        
        //send everything that has been store to the next form
        RequestDispatcher rd = request.getRequestDispatcher("orderForm.jsp");
        request.setAttribute("creditNum", creditNum);
        request.setAttribute("creditExp", creditExp);
        request.setAttribute("creditCVV", creditCVV);
        request.setAttribute("order", existingOrder);
        rd.forward(request, response);
    }

    //method to update location
    private void updateLocation(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int distributionCapacity;
        String locationName = request.getParameter("locationName");
        
        //some try catch to check if there really is an distribution capacity
        try {
            distributionCapacity = Integer.parseInt(request.getParameter("distributionCapacity"));
        } catch (Exception e) {
            //set 0 if nothing has been set
            distributionCapacity = 0;
        }
        
        //validation, not allowing nulls
        if (locationName == null || locationName.equals("")/*|| distributionCapacity != (int)distributionCapacity*/) {
            String message = "please enter a location name";
            RequestDispatcher rd = request.getRequestDispatcher("locationForm.jsp");
            Location existinglocation = locationDAO.getLocation(id);
            request.setAttribute("message", message);
            request.setAttribute("location", existinglocation);
            rd.forward(request, response);
        } else {
            //if everything has proceeded as intended, go to the list
            Location location = new Location(id, locationName, distributionCapacity);
            locationDAO.updateLocation(location);
            response.sendRedirect("list");
        }
    }

    //method to update login
    private void updateLogin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        
        //
        int id = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        
        //String role = request.getParameter("role");
        //int agentId = Integer.parseInt(request.getParameter("agentId"));
        String passwordConfirm = request.getParameter("passwordConfirm");

        //validation, checking if the password is correctly identical
        if (!password.equals(passwordConfirm)) {
            String messageConfirm = "please enter identical passwords";
            Login existingLogin = loginDAO.getLogin(id);
            RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
            request.setAttribute("login", existingLogin);
            request.setAttribute("messageConfirm", messageConfirm);
            rd.forward(request, response);
            //validation, not allowing nulls
        } else if (userName == null || userName.equals("") || password == null || password.equals("")) {
            String message = "please fully complete form";
            RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
            Login existingLogin = loginDAO.getLogin(id);
            request.setAttribute("message", message);
            request.setAttribute("login", existingLogin);
            rd.forward(request, response);
        } else {
            //if everything is correct
            try {
                //make a new login object and update the existing one,
                //then send to the lst of logins
                Login loginObj = new Login(id, userName, password, "agent");
                loginDAO.updateLogin(loginObj);
                response.sendRedirect("listLogins");
            } catch (SQLException e) {
                //errors, pretty self explanatory
                String errorMessage = "That user name is already taken, please choose another";
                request.setAttribute("errorMessage", errorMessage);
                Login existingLogin = loginDAO.getLogin(id);
                request.setAttribute("login", existingLogin);
                RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
                rd.forward(request, response);
            }

        }
    }

    //method to update marketing agent
    private void updateMarketingAgent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        //store these values from the form that called this method
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNo = request.getParameter("phoneNo");
        String email = request.getParameter("email");

        //validation, not allowing nulls
        if (firstName == null || firstName.equals("") || lastName == null || lastName.equals("") || phoneNo == null || phoneNo.equals("")
                || email == null || email.equals("")) {
            String message = "please fully complete form";
            RequestDispatcher rd = request.getRequestDispatcher("marketingAgentForm.jsp");
            MarketingAgent marketingAgent = marketingAgentDAO.getMarketingAgent(id);
            request.setAttribute("message", message);
            request.setAttribute("marketingAgent", marketingAgent);
            rd.forward(request, response);
        } else {
            
            //if everything has proceeded, make a new agent obj, then update with the new object,
            //after that go to listAgents
            MarketingAgent marketingAgentObj = new MarketingAgent(id, firstName, lastName, phoneNo, email);
            marketingAgentDAO.updateMarketingAgent(marketingAgentObj);
            response.sendRedirect("listAgents");
        }
    }

    //methos to update client
    private void updateClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        //get these values from the form that called this method
        int id = Integer.parseInt(request.getParameter("id"));
        String agentId = request.getParameter("agentId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String streetNumber = request.getParameter("streetNumber");
        String streetName = request.getParameter("streetName");
        String city = request.getParameter("city");
        String province = request.getParameter("province");
        String postalCode = request.getParameter("postalCode");
        String telOffice = request.getParameter("telOffice");
        String telCell = request.getParameter("telCell");
        String email = request.getParameter("email");
        String company = request.getParameter("company");
        String companyType = request.getParameter("companyType");

        ///validation, not allowing nulls
        if (agentId == null || agentId.equals("") || firstName == null || firstName.equals("") || lastName == null || lastName.equals("")
                || streetNumber == null || streetNumber.equals("") || streetName == null || streetName.equals("")
                || city == null || city.equals("") || province == null || province.equals("") || postalCode == null || postalCode.equals("")
                || telOffice == null || telOffice.equals("") || telCell == null || telCell.equals("") || email == null || email.equals("")
                || company == null || company.equals("") || companyType == null || companyType.equals("")) {
            //error messages
            String message = "please fully complete form";
            RequestDispatcher rd = request.getRequestDispatcher("newClientFormAdmin.jsp");
            Client client = clientDAO.getClient(id);
            request.setAttribute("message", message);
            request.setAttribute("client", client);
            rd.forward(request, response);
        } else {
            //if everything is fine, proceed
            //get the existing clintObj
            int agentIdd = Integer.parseInt(agentId);
            
            //update client with newly made client obj
            Client clientObj = new Client(id, agentIdd, firstName, lastName, streetNumber, streetName, city, province, postalCode, telOffice, telCell, email, company, companyType);
            clientDAO.updateClient(clientObj);
            
            //send to adminList
            response.sendRedirect("adminList");
        }
    }

    //method to delete location
    private void deleteLocation(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        //get the location and store that to variable using the sent id
        int id = Integer.parseInt(request.getParameter("id"));
        Location location = new Location(id);
        //delete the location
        locationDAO.deleteLocation(location);
        response.sendRedirect("list");
    }

    //method to delete login
    private void deleteLogin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        //get the id, get the loginObj with the id, then delete that obj
        int id = Integer.parseInt(request.getParameter("id"));
        Login loginObj = new Login(id);
        loginDAO.deleteLogin(loginObj);
        response.sendRedirect("listLogins");
    }

    //following methos will be identical, jsut like methods before this
    //get the id from the form
    //make an object of something you want to delete using your id
    //then delete it, afterwards show the refreshed list of that object
    private void deleteMarketingAgent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        MarketingAgent marketAgentObj = new MarketingAgent(id);
        marketingAgentDAO.deleteMarketingAgent(marketAgentObj);
        response.sendRedirect("listAgents");
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Client clientObj = new Client(id);
            clientDAO.deleteClient(clientObj);
            response.sendRedirect("adminList");
        } catch (SQLException e) {
            String errorMessage = e.getMessage();
            List<Client> listClient = clientDAO.listAllClients();
            RequestDispatcher rd = request.getRequestDispatcher("adminList.jsp");
            request.setAttribute("listClient", listClient);
            request.setAttribute("errorMessage", errorMessage);
            rd.forward(request, response);
        }
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        orderDAO.deleteLocationxOrder(id);
        orderDAO.deleteOrder(id);

        response.sendRedirect("listOrder");
    }
}
