package org.vitaly.audio.ui;

/**
 * Created by vitaly on 2017-02-24.
 */
public class IncorrectCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Incorrect command");
        System.out.println("Use help command to see all available commands");
    }
}
