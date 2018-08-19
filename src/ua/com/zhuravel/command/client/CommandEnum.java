package ua.com.zhuravel.command.client;

import ua.com.zhuravel.command.ActionCommand;
import ua.com.zhuravel.command.BrainFuckCommand;

/**
 * Contains the defined commands in the application
 *
 * @author  ArtemZhuravel
 * @version 19 August 2018
 */
public enum CommandEnum {

    BRAINFUCK {
        {
            this.command = new BrainFuckCommand();
        }
    };

    /**
     * Default command
     */
    ActionCommand command;

    /**
     * Getter
     *
     * @return defined command
     */
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
