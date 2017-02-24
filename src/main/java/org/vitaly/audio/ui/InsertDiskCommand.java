package org.vitaly.audio.ui;

import java.util.Scanner;

/**
 * Created by vitaly on 2017-02-24.
 */
public class InsertDiskCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter disk number(use list_disks to see available) : ");
        String inputNumber = scanner.nextLine();
        if (inputNumber.matches("^-?\\d+$")) {
            Integer diskNumber = Integer.valueOf(inputNumber);
            if (diskNumber >= 0 && diskNumber < Gui.getDisks().size()) {
                Gui.getDiskPlayer().changeDisk(Gui.getDisks().get(diskNumber));
                System.out.println("Disk inserted");
            } else {
                System.out.println("Disk number must be between zero inclusive and disk list size exclusive");
            }
        } else {
            System.out.println("Wrong number format");
        }
    }
}
