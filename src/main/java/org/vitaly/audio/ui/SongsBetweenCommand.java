package org.vitaly.audio.ui;

import org.vitaly.audio.Song;

import java.util.Scanner;

/**
 * Created by vitaly on 24.02.17.
 */
public class SongsBetweenCommand implements Command {
    @Override
    public void execute() {
        if (Gui.getDiskPlayer().hasDisk()) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Enter min song length(milliseconds) : ");
                Long minSongLength = Long.valueOf(scanner.nextLine());
                if (minSongLength <= 0) {
                    System.out.println("Song length must be positive!");
                    return;
                }

                System.out.println("Enter max song length(milliseconds) : ");
                Long maxSongLength = Long.valueOf(scanner.nextLine());
                if (maxSongLength <= 0) {
                    System.out.println("Song length must be positive!");
                    return;
                }

                System.out.println(Gui.getDiskPlayer().getSongWithLengthBetween(minSongLength, maxSongLength));
            } catch (NumberFormatException e) {
                System.out.println("Wrong number format");
            }
        } else {
            System.out.println("Player has no disk in!");
        }
    }
}
