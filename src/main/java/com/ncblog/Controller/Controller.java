package com.ncblog.Controller;

import com.ncblog.States.AbstractState;
import com.ncblog.States.StartState;
import com.ncblog.dataaccess.repositories.*;
import com.ncblog.dataaccess.specifications.users.UserWhich;
import com.ncblog.domain.Comment;
import com.ncblog.domain.Post;
import com.ncblog.domain.User;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by Администратор on04.11.2016.
 */
public class Controller {

    private final ConsoleView consoleView;
    private AbstractState startState = new StartState();
    private AbstractState currentState;

    public Controller() {
        this.consoleView = new ConsoleView(System.in, System.out);
        this.currentState = startState;
    }

    public ConsoleView getConsoleView() {
        return consoleView;
    }

    public void setStartState() {
        this.currentState = this.startState;
    }

    public AbstractState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(AbstractState currentState) {
        this.currentState = currentState;
    }
    public void parseCommand() {
        this.currentState.analyseCommands(this);
    }
    public static void main(String[] args) {
        Controller cntr = new Controller();
        while (true) {
            cntr.parseCommand();
        }
    }
}
