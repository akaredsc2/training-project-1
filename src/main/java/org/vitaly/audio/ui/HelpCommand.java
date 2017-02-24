package org.vitaly.audio.ui;

/**
 * Created by vitaly on 2017-02-24.
 */
public class HelpCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Available commands :");
        System.out.println("add_genre");
        System.out.println("list_genres");
        System.out.println("record_song");
        System.out.println("list_songs");
        System.out.println("add_to_compilation");
        System.out.println("reset_compilation");
        System.out.println("list_compilation");
        System.out.println("burn_disk");
        System.out.println("list_disks");
        System.out.println("show_length");
        System.out.println("insert_disk");
        System.out.println("sort_by_genre");
        System.out.println("play_next");
    }
}
