package ua.com.zhuravel.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.com.zhuravel.command.ActionCommand;
import ua.com.zhuravel.command.factory.ActionFactory;

public class MainTest {

    @Test
    void brainFuckTest() {
        String code = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
        ActionFactory factory = new ActionFactory();
        ActionCommand command = factory.defineCommand("brainfuck");
        String result = command.execute(code);
        Assertions.assertArrayEquals("Hello World!\n".toCharArray(), result.toCharArray());
    }

    @Test
    void emptyTest() {
        ActionFactory factory = new ActionFactory();
        ActionCommand command = factory.defineCommand("");
        String result = command.execute(null);
        Assertions.assertArrayEquals("No language set".toCharArray(), result.toCharArray() );
    }
}
