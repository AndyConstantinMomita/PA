import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumController {
    public void create(String name, int artistId, int releaseYear)throws SQLException {
        Connection connection = Database.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO albums (name, artist_id, release_year) VALUES (?,?,?)");
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,artistId);
        preparedStatement.setInt(3,releaseYear);
        preparedStatement.executeUpdate();
    }

    public List<Integer> findByArtist(int artistId) throws SQLException{
        Connection connection = Database.getConnection();
        List<Integer> indexList = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id from albums WHERE artist_id = (?)");
        preparedStatement.setInt(1,artistId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            indexList.add(resultSet.getInt("id"));
        }

        return indexList;

    }
}
