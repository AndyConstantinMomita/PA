import java.sql.*;

public class ArtistController {
    public void create(String name, String country) throws SQLException {
        Connection connection = Database.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO artists (name, country) VALUES (?,?)");

        preparedStatement.setString(2,country);
        preparedStatement.executeUpdate();
    }

    public int findByName(String name) throws SQLException{
        Connection connection = Database.getConnection();
        int index = 0;

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id from artists WHERE artists.name = (?)");
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
             index = resultSet.getInt("id");
        }

        return index;
    }
}
