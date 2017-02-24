package org.vitaly.audio.ui;

import java.util.Scanner;

/**
 * Created by vitaly on 2017-02-24.
 */
public class ShowLengthCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter disk number(use list_disks to see available) : ");
        String inputNumber = scanner.nextLine();
        if (inputNumber.matches("^-?\\d+$")) {
            Integer diskNumber = Integer.valueOf(inputNumber);
            if (diskNumber >= 0 && diskNumber < Gui.getSongs().size()) {
                System.out.println(Gui.getDisks().get(diskNumber).getDiskLength());
            } else {
                System.out.println("Disk number must be between zero inclusive and disk list size exclusive");
            }
        } else {
            System.out.println("Wrong number format");
        }
    }
}
