package org.vitaly.audio.ui;

/**
 * Created by vitaly on 2017-02-24.
 */
public class SortByGenreCommand implements Command {
    @Override
    public void execute() {
        if (Gui.getDiskPlayer().getDisk() != null) {
            Gui.getDiskPlayer().sortSongsByGenre();
            System.out.println("Songs sorted by genre");
        } else {
            System.out.println("No disk inserted");
        }
    }
}
