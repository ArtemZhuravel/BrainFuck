package ua.com.zhuravel.command;

/**
 * An interface which declares a behaviour of all commands
 *
 * @author  ArtemZhuravel
 * @version 19 August 2018
 */
public interface ActionCommand {

    /**
     * Execution of the command
     *
     * @param   code  required resource of data
     */
    void execute(String code);
}
