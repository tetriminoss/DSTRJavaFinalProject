package PrintPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class LocationDAO {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public LocationDAO() {
    }

    public LocationDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

    public List<Location> listAllLocations() throws SQLException {
        List<Location> listLocation = new ArrayList<>();
        int id;
        String locationName;
        int distributionCapacity;

        String sql = "SELECT * from location";

        connect();
        Statement stmt = jdbcConnection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        while (resultSet.next()) {
            id = resultSet.getInt("id");
            locationName = resultSet.getString("locationName");
            distributionCapacity = resultSet.getInt("distributionCapacity");

            Location locationObj = new Location(id, locationName, distributionCapacity);
            listLocation.add(locationObj);
        }

        resultSet.close();
        stmt.close();
        disconnect();

        return listLocation;
    }

    public boolean insertLocationRecord(Location locationObj) throws SQLException {
        String sql = "INSERT INTO location (locationName,distributionCapacity) VALUES(?,?)";
        connect();
        PreparedStatement stmt = jdbcConnection.prepareStatement(sql);
        stmt.setString(1, locationObj.getLocationName());
        stmt.setInt(2, locationObj.getDistributionCapacity());
        boolean rowsInserted = stmt.executeUpdate() > 0;
        disconnect();
        return rowsInserted;
    }

    public Location getLocation(int id) throws SQLException {
        Location location = null;
        String sql = "SELECT * FROM location WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String locationName = resultSet.getString("locationName");
            int distributionCapacity = resultSet.getInt("distributionCapacity");

            location = new Location(id, locationName, distributionCapacity);
        }

        resultSet.close();
        statement.close();

        return location;
    }

    public boolean updateLocation(Location location) throws SQLException {
        String sql = "UPDATE location SET locationName = ?, distributionCapacity = ?";
        sql += " WHERE id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, location.getLocationName());
        statement.setInt(2, location.getDistributionCapacity());
        statement.setInt(3, location.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public boolean deleteLocation(Location location) throws SQLException {
        String sql = "DELETE FROM location where id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, location.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }
}
