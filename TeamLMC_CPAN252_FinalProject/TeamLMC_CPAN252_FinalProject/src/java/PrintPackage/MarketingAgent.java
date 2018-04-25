
package PrintPackage;

public class MarketingAgent {
        //this will be the same for other java classes (entities)
    //make variables
    //make a constructor, varies from what values are coming in then storing it.
    //afterwards, there will be a set of getters and setters that are used for servlet methods that need these values
    private int id;
    private String firstName, lastName, phoneNo, email;

    public MarketingAgent() {
    }

    public MarketingAgent(String firstName, String lastName, String phoneNo, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public MarketingAgent(int id, String firstName, String lastName, String phoneNo, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public MarketingAgent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
  
    
}
