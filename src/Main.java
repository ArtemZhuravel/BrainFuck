import ua.com.zhuravel.command.ActionCommand;
import ua.com.zhuravel.command.factory.ActionFactory;

public class Main {

    public static void main(String[] args) {
        String code = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
        ActionFactory factory = new ActionFactory();
        ActionCommand command = factory.defineCommand("brainfuck");
        command.execute(code);
    }
}