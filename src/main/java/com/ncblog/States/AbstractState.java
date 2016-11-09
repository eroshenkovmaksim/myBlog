package com.ncblog.States;

import com.ncblog.Controller.ConsoleView;
import com.ncblog.Controller.Controller;

/**
 * Created by Администратор on 09.11.2016.
 */
public abstract class AbstractState {

    //Template method pattern;
    final void analyseCommandsGlobal(Controller controller, String[] command){

        ConsoleView consoleView = controller.getConsoleView();

        switch(command.length){
            case 1:
                switch (command[0].toLowerCase()){
                    case "help":
                        printHelp(controller);
                        return;
                    case "close":
                        consoleView.println("Program has been closed");
                        System.exit(0);
                }
        }

        consoleView.println("Invalid command, type \"help\" to get list of commands");
    }

    void printHelp(Controller controller){
        ConsoleView consoleView = controller.getConsoleView();
        consoleView.println("Possible commands: ");
        consoleView.println("  help: prints list of current available commands");
        consoleView.println("  close: closes whole application");
    }


    public abstract void analyseCommands(Controller controller);
}