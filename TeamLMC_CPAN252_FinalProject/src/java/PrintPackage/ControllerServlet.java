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

    LocationDAO locationDAO;
    MarketingAgentDAO marketingAgentDAO;
    LoginDAO loginDAO;
    HttpSession session;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        locationDAO = new LocationDAO(jdbcURL, jdbcUsername, jdbcPassword);
        marketingAgentDAO = new MarketingAgentDAO(jdbcURL, jdbcUsername, jdbcPassword);
        loginDAO = new LoginDAO(jdbcURL, jdbcUsername, jdbcPassword);

    }

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
                default:
                    request.getSession().invalidate();
                    response.sendRedirect("/TeamLMC_CPAN252_FinalProject/login.jsp");
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listAllLocations(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<Location> listLocation = locationDAO.listAllLocations();
        request.setAttribute("listLocation", listLocation);
        RequestDispatcher dispatcher = request.getRequestDispatcher("locationList.jsp");
        dispatcher.forward(request, response);
    }

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

    private void showNewLocationForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("locationForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewLoginForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("loginForm.jsp");
        List<MarketingAgent> listMarketingAgent = marketingAgentDAO.listAllMarketingAgents();
        request.setAttribute("listMarketingAgent", listMarketingAgent);
        dispatcher.forward(request, response);
    }

    private void showNewMarketingAgentForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("marketingAgentForm.jsp");
        dispatcher.forward(request, response);
    }

    private void insertLocationRecord(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int distributionCapacity;
        String locationName = request.getParameter("locationName");
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

    private void insertMarketingAgentRecord(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNo = request.getParameter("phoneNo");
        String email = request.getParameter("email");

        if (firstName == null || firstName.equals("") || lastName == null || lastName.equals("") || phoneNo == null || phoneNo.equals("")
                || email == null || email.equals("")) {
            String message = "please fully complete form";
            RequestDispatcher rd = request.getRequestDispatcher("marketingAgentForm.jsp");
            request.setAttribute("message", message);
            rd.forward(request, response);
        } else {
            MarketingAgent marketingAgentObj = new MarketingAgent(firstName, lastName, phoneNo, email);
            marketingAgentDAO.insertMarketingAgentRecord(marketingAgentObj);
            response.sendRedirect("listAgents");
        }
    }

    private void insertLoginRecord(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordConfirm");
        String agentIdStr = request.getParameter("agentId");
        
        if (agentIdStr.equals("Choose...") || agentIdStr == null || agentIdStr.equals("")) {
            String messageAgentId = "please select an agent ID";
            RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
            List<MarketingAgent> listMarketingAgent = marketingAgentDAO.listAllMarketingAgents();
            request.setAttribute("listMarketingAgent", listMarketingAgent);
            request.setAttribute("messageAgentId", messageAgentId);
            rd.forward(request, response);
        }
                
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
            Login login = new Login(userName, password, "agent", agentId);
            loginDAO.insertLoginRecord(login);
            response.sendRedirect("listLogins");
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Location existinglocation = locationDAO.getLocation(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("locationForm.jsp");
        request.setAttribute("location", existinglocation);
        dispatcher.forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        String message = "";
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Login newLogin = loginDAO.doLogin(userName, password);
        HttpSession session = request.getSession();
        session.setAttribute("newLogin", newLogin);
        /*session = request.getSession();
        session.setAttribute("user", newLogin);
        if(session.getAttribute("user") == null){
	response.sendRedirect("x");
        }*/
        if (newLogin == null) {
            message = "Incorrect Username and/or Password entered";
            request.setAttribute("message", message);
            rd.forward(request, response);
        } else if (newLogin.role.equalsIgnoreCase("admin")) {
            rd = request.getRequestDispatcher("admin.jsp");
            request.setAttribute("login", newLogin);
            rd.forward(request, response);
        } else if (newLogin.role.equalsIgnoreCase("agent")) {
            rd = request.getRequestDispatcher("agent.jsp");
            request.setAttribute("login", newLogin);
            rd.forward(request, response);
        } else {
            message = "Incorrect Username and/or Password entered";
            request.setAttribute("message", message);
            rd.forward(request, response);
        }
    }

    private void showMarketingAgentEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        MarketingAgent existingMarketingAgent = marketingAgentDAO.getMarketingAgent(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("marketingAgentForm.jsp");
        request.setAttribute("marketingAgent", existingMarketingAgent);
        dispatcher.forward(request, response);
    }

    private void showLoginEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Login existingLogin = loginDAO.getLogin(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("loginForm.jsp");
        request.setAttribute("login", existingLogin);
        dispatcher.forward(request, response);
    }

    private void updateLocation(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int distributionCapacity;
        String locationName = request.getParameter("locationName");
        try {
            distributionCapacity = Integer.parseInt(request.getParameter("distributionCapacity"));
        } catch (Exception e) {
            distributionCapacity = 0;
        }
        if (locationName == null || locationName.equals("")/*|| distributionCapacity != (int)distributionCapacity*/) {
            String message = "please enter a location name";
            RequestDispatcher rd = request.getRequestDispatcher("locationForm.jsp");
            Location existinglocation = locationDAO.getLocation(id);
            request.setAttribute("message", message);
            request.setAttribute("location", existinglocation);
            rd.forward(request, response);
        } else {
            Location location = new Location(id, locationName, distributionCapacity);
            locationDAO.updateLocation(location);
            response.sendRedirect("list");
        }
    }

    private void updateLogin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        //String role = request.getParameter("role");
        //int agentId = Integer.parseInt(request.getParameter("agentId"));
        String passwordConfirm = request.getParameter("passwordConfirm");

        if (!password.equals(passwordConfirm)) {
            String messageConfirm = "please enter identical passwords";
            Login existingLogin = loginDAO.getLogin(id);     
            RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
            request.setAttribute("login", existingLogin);
            request.setAttribute("messageConfirm", messageConfirm);
            rd.forward(request, response);
        }else if (userName == null || userName.equals("") || password == null || password.equals("")) {
            String message = "please fully complete form";
            RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
            Login existingLogin = loginDAO.getLogin(id);
            request.setAttribute("message", message);
            request.setAttribute("login", existingLogin);
            rd.forward(request, response);
        }else{
        Login loginObj = new Login(id, userName, password, "agent");
        loginDAO.updateLogin(loginObj);
        response.sendRedirect("listLogins");
        }
    }

    private void updateMarketingAgent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNo = request.getParameter("phoneNo");
        String email = request.getParameter("email");

        if (firstName == null || firstName.equals("") || lastName == null || lastName.equals("") || phoneNo == null || phoneNo.equals("")
                || email == null || email.equals("")) {
            String message = "please fully complete form";
            RequestDispatcher rd = request.getRequestDispatcher("marketingAgentForm.jsp");
            MarketingAgent marketingAgent = marketingAgentDAO.getMarketingAgent(id);
            request.setAttribute("message", message);
            request.setAttribute("marketingAgent", marketingAgent);
            rd.forward(request, response);
        }else{
        MarketingAgent marketingAgentObj = new MarketingAgent(id, firstName, lastName, phoneNo, email);
        marketingAgentDAO.updateMarketingAgent(marketingAgentObj);
        response.sendRedirect("listAgents");
        }
    }

    private void deleteLocation(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Location location = new Location(id);
        locationDAO.deleteLocation(location);
        response.sendRedirect("list");
    }

    private void deleteLogin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Login loginObj = new Login(id);
        loginDAO.deleteLogin(loginObj);
        response.sendRedirect("listLogins");
    }

    private void deleteMarketingAgent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        MarketingAgent marketAgentObj = new MarketingAgent(id);
        marketingAgentDAO.deleteMarketingAgent(marketAgentObj);
        response.sendRedirect("listAgents");
    }
}
