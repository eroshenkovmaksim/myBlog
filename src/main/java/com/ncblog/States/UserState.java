package com.ncblog.States;

import com.ncblog.Controller.ConsoleView;
import com.ncblog.Controller.Controller;

/**
 * Created by Администратор on 09.11.2016.
 */
public class UserState extends AbstractUserState {
    UserState() {
    }

    public void analyseCommands(Controller controller){

        ConsoleView consoleView = controller.getConsoleView();
        consoleView.print("User: ");
        String[] command = consoleView.readLine();

//        switch(command.length){
//            case 1:
//                switch (command[0].toLowerCase()){
//                    case "post":
//                        return;
//                    case "show":
//                        return;
//                }
//        }

        analyseCommandsUserCommon(controller, command);
    }

    void printHelp(Controller controller){
        super.printHelp(controller);
//        ConsoleView consoleView = controller.getConsoleView();
//        consoleView.println("  post: print the post on your personal page");
//        consoleView.println("  show: show your own posts");
    }

}
