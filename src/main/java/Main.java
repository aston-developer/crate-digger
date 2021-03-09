import org.deepsymmetry.cratedigger.Database;
import org.deepsymmetry.cratedigger.pdb.RekordboxPdb;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            Database database = new Database(new File("export.pdb"));

            Map<Long, RekordboxPdb.TrackRow> tracks = database.trackIndex;
            // crate-digger project source level 1.6 (no lambda's)

            // Tracks
            for (Map.Entry<Long, RekordboxPdb.TrackRow> trackVal : database.trackIndex.entrySet()) {
                RekordboxPdb.TrackRow track = trackVal.getValue();
                RekordboxPdb.DeviceSqlShortAscii title = (RekordboxPdb.DeviceSqlShortAscii) track.title().body();
                System.out.println("TrackID: " +  track.id() + " \t\t ArtistID: " + track.artistId() + " \t\t Play Count: " + track.playCount() + " \t\t Title: " + title.text());
            }


//            database.trackIndex.forEach((k, v) -> {
//                System.out.println("key: " + k);
//                System.out.println(v.toString());
//            });

//            System.out.println(database.trackIndex.toString());
            System.out.println(database.playlistFolderIndex.toString());
            System.out.println(database.playlistIndex.toString());
        } catch (IOException ioEx) {
            System.out.println(ioEx);
        }

//        RekordboxPdb.TrackRow track = database.findTrack(1);
//        System.out.println(database.getText(track.title()));
    }
}
