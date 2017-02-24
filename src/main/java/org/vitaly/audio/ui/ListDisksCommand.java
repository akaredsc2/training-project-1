package org.vitaly.audio.ui;

import org.vitaly.audio.Disk;

import java.util.ArrayList;

/**
 * Created by vitaly on 2017-02-24.
 */
public class ListDisksCommand implements Command {
    @Override
    public void execute() {
        ArrayList<Disk> disks = Gui.getDisks();
        for (int i = 0, songsSize = disks.size(); i < songsSize; i++) {
            Disk disk = disks.get(i);
            System.out.println(i + ". " + disk);
        }
    }
}
