package org.vitaly.audio.ui;

import org.vitaly.audio.Disk;

import java.util.Scanner;

/**
 * Created by vitaly on 2017-02-24.
 */
public class BurnDiskCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter disk name : ");
        String diskName = scanner.nextLine();

        Gui.getDisks().add(Disk.doBurnDisk(diskName, Gui.getCompilation()));
        System.out.println("Disk burned");
    }
}
