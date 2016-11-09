package com.ncblog.States;

import com.ncblog.Controller.ConsoleView;
import com.ncblog.Controller.Controller;
import sun.tools.jar.CommandLine;

/**
 * Created by Администратор on 09.11.2016.
 */
public class StartState extends AbstractState {

    private CommandLine cl = null;

    private ConsoleView consoleView;

    public StartState() {
    }

    @Override
    public String toString() {
        return "Starting state";
    }

    public void analyseCommands(Controller controller) {

        ConsoleView consoleView = controller.getConsoleView();
        consoleView.print("Guest: ");
        String[] command = consoleView.readLine();

        switch(command.length){
            case 1:
                switch (command[0].toLowerCase()){
                    case "enter":
                        enterNewState(controller);
                        return;
                }
        }

        analyseCommandsGlobal(controller, command);
    }

    void printHelp(Controller controller){
        super.printHelp(controller);
        ConsoleView consoleView = controller.getConsoleView();
        consoleView.println("  enter: enters into your personal account");
    }

    private void enterNewState(Controller controller) {

        ConsoleView consoleView = controller.getConsoleView();

        consoleView.print("Login: ");
        String login = consoleView.readLogin();
        consoleView.print("Password: ");
        String password = consoleView.readPassword();
        consoleView.print("role: ");
        String role = consoleView.readLogin();
        System.out.println(controller.getCurrentState().toString());
        if (login.equals("maxim") && password.equals("dino")) {
            AbstractState newState = this.createNewState(role);
            controller.setCurrentState(newState);
        } else {
            System.out.println("wrong login or password, try again");
        }
    }
    private AbstractState createNewState(String role){
        AbstractState newState;
        if(role =="user") {
            newState = new UserState();
        }else{
            newState = new UserState();
        }
        return newState;
    }

}

