import java.sql.*;

public class SQLServerExample {

    public static void main(String[] args) {
        // Database connection parameters
        String connectionString = "jdbc:sqlserver://DESKTOP-EPMS3PQ\\DBS;databaseName=ISAD;integratedSecurity=true";

        // SQL query to execute
        String query = "SELECT * FROM tbEmployee";

        // Initialize objects for database connection
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Connect to the database
            connection = DriverManager.getConnection(connectionString);

            // Create a statement
            statement = connection.createStatement();

            // Execute the query
            resultSet = statement.executeQuery(query);

            // Process the result set
            while (resultSet.next()) {
                // Example: retrieve data from the result set
                int id = resultSet.getInt(1); // Assuming the first column is an integer
                String name = resultSet.getString(2); // Assuming the second column is a string

                // Do something with the data retrieved
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close all resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
