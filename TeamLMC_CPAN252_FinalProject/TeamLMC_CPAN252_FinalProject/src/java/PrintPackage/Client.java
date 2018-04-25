package PrintPackage;

public class Client {
    //declare these variables for later use
    private int id;
    private int agentId;
    private String firstName, lastName, streetNumber, streetName, city, province, postalCode, telOffice, telCell, email, company, companyType;

    public Client() {
    }

    //our set of constructors, saves data to the declared variables
    public Client(String firstName, String lastName, String streetNumber, String streetName, String city, String province, String postalCode,
            String telOffice, String telCell, String email, String company, String companyType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.telOffice = telOffice;
        this.telCell = telCell;
        this.email = email;
        this.company = company;
        this.companyType = companyType;
    }

    public Client(int agentId, String firstName, String lastName, String streetNumber, String streetName, String city, String province, String postalCode,
            String telOffice, String telCell, String email, String company, String companyType) {
        this.agentId = agentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.telOffice = telOffice;
        this.telCell = telCell;
        this.email = email;
        this.company = company;
        this.companyType = companyType;
    }

    public Client(int id, int agentId, String firstName, String lastName, String streetNumber, String streetName, String city, String province, String postalCode, String telOffice, String telCell, String email, String company, String companyType) {
        this.id = id;
        this.agentId = agentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.telOffice = telOffice;
        this.telCell = telCell;
        this.email = email;
        this.company = company;
        this.companyType = companyType;
    }
    
    //following set of codes will be the getters and setters for our variables.
    public Client(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
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

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTelOffice() {
        return telOffice;
    }

    public void setTelOffice(String telOffice) {
        this.telOffice = telOffice;
    }

    public String getTelCell() {
        return telCell;
    }

    public void setTelCell(String telCell) {
        this.telCell = telCell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

}
