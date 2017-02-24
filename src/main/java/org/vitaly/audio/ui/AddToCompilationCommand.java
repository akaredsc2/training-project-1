package org.vitaly.audio.ui;

import java.util.Scanner;

/**
 * Created by vitaly on 2017-02-24.
 */
public class AddToCompilationCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter song number(use list_songs to see available) : ");
        String inputNumber = scanner.nextLine();
        if (inputNumber.matches("^-?\\d+$")) {
            Integer songNumber = Integer.valueOf(inputNumber);
            if (songNumber >= 0 && songNumber < Gui.getSongs().size()) {
                Gui.getCompilation().add(Gui.getSongs().get(songNumber));
            } else {
                System.out.println("Song number must be between zero inclusive and song list size exclusive");
            }
        } else {
            System.out.println("Wrong number format");
        }
    }
}
