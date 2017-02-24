package org.vitaly.audio.ui;

/**
 * Created by vitaly on 2017-02-24.
 */
public class ResetCompilationCommand implements Command {
    @Override
    public void execute() {
        Gui.getCompilation().clear();
        System.out.println("Compilation cleared");
    }
}
