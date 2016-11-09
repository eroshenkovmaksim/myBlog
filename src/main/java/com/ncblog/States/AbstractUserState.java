package com.ncblog.States;

import com.ncblog.Controller.ConsoleView;
import com.ncblog.Controller.Controller;

/**
 * Created by Администратор on 09.11.2016.
 */
public abstract class AbstractUserState extends AbstractState {

//    private AbstractUser currentUser;
//
//    AbstractUserState() {
//    }
//
//    AbstractUser getCurrentUser() {
//        if(currentUser == null){
//            throw new IllegalStateException("User was not set");
//        }
//        return currentUser;
//    }
//
//    void setCurrentUser(AbstractUser currentUser) {
//        this.currentUser = currentUser;
//    }

    //Template method pattern
    final void analyseCommandsUserCommon(Controller controller, String[] command){

        switch(command.length){
            case 1:
                switch (command[0].toLowerCase()){
                    case "info":
                        printInfo(controller);
                        return;
                    case "exit":
                        exitCurrentState(controller);
                        return;
                    case "show":
                        return;
                    case "delete":
                        return;
                    case "post":
                        return;
                }
        }

        analyseCommandsGlobal(controller, command);
    }

    void printHelp(Controller controller){
        super.printHelp(controller);
        ConsoleView consoleView = controller.getConsoleView();
        consoleView.println("  info: prints information about current account;");
        consoleView.println("  exit: exits current account;");
        consoleView.println("  show: shows your own posts;");
        consoleView.println("  delete: deletes your own post;");
        consoleView.println("  post: prints new post on your personal page;");
    }

    void printInfo(Controller controller){
        controller.getConsoleView().println("maxim");
    }

    void exitCurrentState(Controller controller){
        controller.setStartState();
    }

    boolean isAbort(String line){
        return line.toLowerCase().equals("abort");
    }

    boolean isValidName(String name){
        return ((name != null) && (name.length() > 0));
    }
}
