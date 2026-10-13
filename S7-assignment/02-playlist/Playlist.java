/**
 * Week 7 · S7 assignment · Problem 2 The Playlist
 *
 * getSongs returns a new array. Editing that copy cannot change the playlist.
 */
import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int count;

    public Playlist(int capacity) {
        this.songs = new String[capacity];
        this.count = 0;
    }

    public void addSong(String title) {
        if (count < songs.length) {
            songs[count] = title;
            count++;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist(10);
        playlist.addSong("Song A");
        playlist.addSong("Song B");
        String[] copy = playlist.getSongs();
        copy[0] = "Hacked";
        System.out.println(Arrays.toString(playlist.getSongs()));
        if (!playlist.getSongs()[0].equals("Song A") || playlist.getSongCount() != 2) {
            throw new AssertionError("Defensive copy failed");
        }
        System.out.println("Sample checks passed.");
    }
}
