package org.vitaly.audio.ui;

import org.vitaly.audio.Disk;
import org.vitaly.audio.DiskPlayer;
import org.vitaly.audio.Song;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by vitaly on 2017-02-24.
 */
public class Gui {
    private static final ArrayList<Song> songs = new ArrayList<>();
    private static final ArrayList<Song> compilation = new ArrayList<>();
    private static final ArrayList<Disk> disks = new ArrayList<>();
    private static final DiskPlayer diskPlayer = new DiskPlayer();

    private Gui() {
    }

    public static ArrayList<Song> getSongs() {
        return songs;
    }

    public static ArrayList<Song> getCompilation() {
        return compilation;
    }

    public static ArrayList<Disk> getDisks() {
        return disks;
    }

    public static DiskPlayer getDiskPlayer() {
        return diskPlayer;
    }

    public static void main(String[] args) {
        CommandFactory commandFactory = CommandFactory.getInstance();
        Scanner scanner = new Scanner(System.in);
        String inputCommand;
        do {
            System.out.println("Enter command: ");
            inputCommand = scanner.nextLine().toUpperCase().trim();

            Command command;
            if (commandExist(inputCommand)) {
                command = commandFactory.getCommand(CommandEnum.valueOf(inputCommand));
                command.execute();
            } else if (!inputCommand.equals("EXIT")){
                command = commandFactory.getCommand(CommandEnum.INCORRECT_COMMAND);
                command.execute();
            }
        } while (!"EXIT".equals(inputCommand));
    }

    private static boolean commandExist(String command) {
        CommandEnum[] values = CommandEnum.values();

        for (CommandEnum value: values) {
            if (value.toString().equals(command)) {
                return true;
            }
        }
        return false;
    }
}
