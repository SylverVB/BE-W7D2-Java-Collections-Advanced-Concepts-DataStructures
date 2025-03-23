// Exercise

// Create a text-based Java program that simulates a music playlist application where the user can do the following:
// - Add a song to the list
// - Remove a song from the list
// - Re-arrange the songs on the list
// - Mark a song as their favorite and move it to the top of the list
// - Mark a song as their least favorite and move it to the bottom of the list

package ArrayListLinkedLIst.MusicPlaylistApp;

import java.util.LinkedList;
import java.util.Scanner;

public class MusicPlaylistApp {

    // LinkedList to store songs in the playlist
    private LinkedList<String> playlist;

    // Constructor to initialize the playlist
    public MusicPlaylistApp() {
        playlist = new LinkedList<>();
    }

    // Method to display the playlist
    private void displayPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("The playlist is empty.");
        } else {
            System.out.println("Current Playlist:");
            for (int i = 0; i < playlist.size(); i++) {
                System.out.println((i + 1) + ". " + playlist.get(i));
            }
        }
    }

    // Method to add a song to the playlist
    private void addSong(String song) {
        playlist.add(song);
        System.out.println("\"" + song + "\" has been added to the playlist.");
    }

    // Method to remove a song from the playlist
    private void removeSong(String song) {
        if (playlist.remove(song)) {
            System.out.println("\"" + song + "\" has been removed from the playlist.");
        } else {
            System.out.println("Song not found in the playlist.");
        }
    }

    // Method to rearrange songs in the playlist
    private void rearrangeSongs(int fromIndex, int toIndex) {
        if (fromIndex >= 0 && fromIndex < playlist.size() && toIndex >= 0 && toIndex < playlist.size()) {
            String song = playlist.remove(fromIndex);
            playlist.add(toIndex, song);
            System.out.println("Song has been moved.");
        } else {
            System.out.println("Invalid indices. Please try again.");
        }
    }

    // Method to mark a song as favorite and move it to the top
    private void markAsFavorite(String song) {
        if (playlist.contains(song)) {
            playlist.remove(song);
            playlist.addFirst(song);
            System.out.println("\"" + song + "\" has been marked as your favorite and moved to the top.");
        } else {
            System.out.println("Song not found in the playlist.");
        }
    }

    // Method to mark a song as least favorite and move it to the bottom
    private void markAsLeastFavorite(String song) {
        if (playlist.contains(song)) {
            playlist.remove(song);
            playlist.addLast(song);
            System.out.println("\"" + song + "\" has been marked as your least favorite and moved to the bottom.");
        } else {
            System.out.println("Song not found in the playlist.");
        }
    }

    public static void main(String[] args) {
        MusicPlaylistApp app = new MusicPlaylistApp();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n===== Music Playlist Menu =====");
            System.out.println("1. Add a song");
            System.out.println("2. Remove a song");
            System.out.println("3. Rearrange songs");
            System.out.println("4. Mark a song as favorite (move to top)");
            System.out.println("5. Mark a song as least favorite (move to bottom)");
            System.out.println("6. Display playlist");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter song name to add: ");
                    String songToAdd = scanner.nextLine();
                    app.addSong(songToAdd);
                    break;

                case 2:
                    System.out.print("Enter song name to remove: ");
                    String songToRemove = scanner.nextLine();
                    app.removeSong(songToRemove);
                    break;

                case 3:
                    System.out.print("Enter index of song to move (from): ");
                    int fromIndex = scanner.nextInt();
                    System.out.print("Enter index of destination to move (to): ");
                    int toIndex = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline
                    app.rearrangeSongs(fromIndex - 1, toIndex - 1);
                    break;

                case 4:
                    System.out.print("Enter song name to mark as favorite: ");
                    String songToFavorite = scanner.nextLine();
                    app.markAsFavorite(songToFavorite);
                    break;

                case 5:
                    System.out.print("Enter song name to mark as least favorite: ");
                    String songToLeastFavorite = scanner.nextLine();
                    app.markAsLeastFavorite(songToLeastFavorite);
                    break;

                case 6:
                    app.displayPlaylist();
                    break;

                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
