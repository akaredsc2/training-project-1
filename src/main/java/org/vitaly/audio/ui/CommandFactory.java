package org.vitaly.audio.ui;

/**
 * Created by vitaly on 2017-02-24.
 */

public class CommandFactory {
    private static CommandFactory instance = new CommandFactory();

    private Command helpCommand = new HelpCommand();
    private Command incorrectCommand = new IncorrectCommand();
    private Command addGenreCommand = new AddGenreCommand();
    private Command listGenresCommand = new ListGenresCommand();
    private Command recordSongCommand = new RecordSongCommand();
    private Command listSongsCommand = new ListSongsCommand();
    private Command addToCompilationCommand = new AddToCompilationCommand();
    private Command listCompilationCommand = new ListCompilationCommand();
    private Command resetCompilationCommand = new ResetCompilationCommand();
    private Command burnDiskCommand = new BurnDiskCommand();
    private Command listDisksCommand = new ListDisksCommand();
    private Command showLengthCommand = new ShowLengthCommand();
    private Command insertDiskCommand = new InsertDiskCommand();
    private Command sortByGenreCommand = new SortByGenreCommand();

    private CommandFactory() {
    }

    public static CommandFactory getInstance() {
        return instance;
    }

    public Command getCommand(CommandEnum commandEnum) {
        switch (commandEnum) {
            case HELP:
                return helpCommand;
            case ADD_GENRE:
                return addGenreCommand;
            case LIST_GENRES:
                return listGenresCommand;
            case RECORD_SONG:
                return recordSongCommand;
            case LIST_SONGS:
                return listSongsCommand;
            case ADD_TO_COMPILATION:
                return addToCompilationCommand;
            case LIST_COMPILATION:
                return listCompilationCommand;
            case RESET_COMPILATION:
                return resetCompilationCommand;
            case BURN_DISK:
                return burnDiskCommand;
            case LIST_DISKS:
                return listDisksCommand;
            case SHOW_LENGTH:
                return showLengthCommand;
            case INSERT_DISK:
                return insertDiskCommand;
            case SORT_BY_GENRE:
                return sortByGenreCommand;
            default:
                return incorrectCommand;
        }
    }
}
