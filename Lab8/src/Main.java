import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Database database = new Database();
        database.createConnection();

        ArtistController artistController = new ArtistController();
        AlbumController albumController = new AlbumController();

        /*
        artistController.create("Eminem","USA");
        artistController.create("21 Savage", "UK");
        artistController.create("Booba", "France");

        albumController.create("Relapse",1,2009);
        albumController.create("Music To Be Murdered By",1,2020);
        albumController.create("Ouest Side",3,2006);
        */

        System.out.println(artistController.findByName("21 Savage"));
        System.out.println(albumController.findByArtist(1));

        database.closeConnection();
    }
}
