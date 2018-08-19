package ua.com.zhuravel.command;

public class EmptyCommand implements ActionCommand {

    @Override
    public void execute(String code) {
        System.out.println("No language set");
    }
}
