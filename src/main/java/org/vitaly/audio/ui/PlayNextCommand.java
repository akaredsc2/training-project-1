package org.vitaly.audio.ui;

/**
 * Created by vitaly on 24.02.17.
 */
public class PlayNextCommand implements Command {
    @Override
    public void execute() {
        if (Gui.getDiskPlayer().hasDisk()) {
            System.out.println(Gui.getDiskPlayer().playNext());
        } else {
            System.out.println("No disk to play");
        }
    }
}
