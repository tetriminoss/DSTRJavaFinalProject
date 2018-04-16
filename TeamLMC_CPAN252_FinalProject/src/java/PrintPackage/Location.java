package PrintPackage;

public class Location {

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
