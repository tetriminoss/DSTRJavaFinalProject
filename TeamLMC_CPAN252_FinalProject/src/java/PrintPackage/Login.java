
package PrintPackage;


public class Login {
    
    int id;
    String userName, password, role;
    int agentId;;

    public Login() {
    }

    public Login(int id) {
        this.id = id;
    }
    
    public Login(int id, String userName, String password, String role, int agentId) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.agentId = agentId;
    }

    public Login(String userName, String password, String role, int agentId) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.agentId = agentId;
    }

    public Login(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public Login(int id, int agentId) {
        this.id = id;
        this.agentId = agentId;
    }

    public Login(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    /*public Login(int id, String userName, String password, int agentId) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.agentId = agentId;
    }*/
    
    public Login(int id, String userName, String role, int agentId) {
        this.id = id;
        this.userName = userName;
        this.role = role;
        this.agentId = agentId;
    }
    
    public Login(int id, String userName, String password, String role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }
    
    
    
    
}
