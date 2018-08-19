package ua.com.zhuravel.command;

public class EmptyCommand implements ActionCommand {

    @Override
    public String execute(String code) {
        return "No language set";
    }
}
