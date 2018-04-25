package PrintPackage;

public class Location {

    //this will be the same for other java classes (entities)
    //make variables
    //make a constructor, varies from what values are coming in then storing it.
    //afterwards, there will be a set of getters and setters that are used for servlet methods that need these values
    private int id;
    private String locationName;
    private int distributionCapacity;

    public Location() {
    }

    public Location(String locationName, int distributionCapacity) {
        this.locationName = locationName;
        this.distributionCapacity = distributionCapacity;
    }

    public Location(int id, String locationName, int distributionCapacity) {
        this.id = id;
        this.locationName = locationName;
        this.distributionCapacity = distributionCapacity;
    }

    public Location(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getDistributionCapacity() {
        return distributionCapacity;
    }

    public void setDistributionCapacity(int distributionCapacity) {
        this.distributionCapacity = distributionCapacity;
    }

}
