package org.vitaly.audio.ui;

import org.vitaly.audio.Genre;

import java.util.Scanner;

/**
 * Created by vitaly on 2017-02-24.
 */
public class AddGenreCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter genre name : ");
        String genreName = scanner.nextLine();
        Genre.addGenre(genreName);
    }
}
