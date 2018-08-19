package ua.com.zhuravel.command.factory;

import ua.com.zhuravel.command.ActionCommand;
import ua.com.zhuravel.command.EmptyCommand;
import ua.com.zhuravel.command.client.CommandEnum;

/**
 * Defines the command of the input
 *
 * @author  ArtemZhuravel
 * @version 19 August 2018
 */
public class ActionFactory {

    /**
     * Defines a command of the input
     *
     * @param action    requested {@code action}
     * @return          defined command
     */
    public ActionCommand defineCommand(String action) {
        ActionCommand command = new EmptyCommand();
        if(action == null && action.isEmpty()) {
            return command;
        } try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            command = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.err.println("Wrong action!");
        }
        return command;
    }
}
