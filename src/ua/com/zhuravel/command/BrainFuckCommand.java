package ua.com.zhuravel.command;

import java.util.Deque;
import java.util.LinkedList;

/**
 * An implementation of the
 */
public class BrainFuckCommand implements ActionCommand {

    private static char[] array = { 0, 0, 0, 0, 0, 0, 0};

    /**
     A pointer
     */
    private static int count = 0;

    /**
     * A collection contains the indexes of open brackets
     */
    private static Deque<Integer> indexesOfOpenBracket = new LinkedList<>();

    @Override
    public String execute(String code) {
        if(code == null && code.isEmpty()) {
            return "";
        }
        String result = "";
        //  We're iterating trough the commands and executing them
        for(int i = 0; i < code.length(); i++) {
            switch (code.charAt(i)) {
                case '>':
                    more();
                    break;
                case '<':
                    less();
                    break;
                case '+':
                    plus();
                    break;
                case '-':
                    minus();
                    break;
                case '.':
                    result += point();
                    break;
                case '[':
                    //  while we're starting a loop we should be convinced
                    //  that a number is not a zero otherwise we skipping
                    //  a loop
                    if(checkIfZero()) {
                        int tempoBracket = 1;
                        while(tempoBracket != 0) {
                            i++;
                            //  after skipping all nested loops we have to
                            //  get to the last bracket
//                            if(tempoBracket == 0) {
//                                tempoBracket++;
//                            }

                            //  during skipping a loop there is a chance of existing another loop
                            //  that is why we count a number of nested loops and skip them
                            if(code.charAt(i) == '[') {
                                tempoBracket++;
                            }
                            if(code.charAt(i) == ']') {
                                tempoBracket--;
                            }
                        }
                        break;
                    }
                    openBracket(i);
                    break;
                case ']':
                    if(checkIfZero()) {
                        closeBracket();
                        break;
                    }
                    i = indexesOfOpenBracket.getLast();
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    private static void more() {
        count++;
    }

    private static void less() {
        count--;
    }

    private static void plus() {
        array[count]++;
    }

    private static void minus() {
        array[count]--;
    }

    private static String point() {
        System.out.print(array[count]);
        return String.valueOf(array[count]);
    }

    private static void openBracket(int i) {
        indexesOfOpenBracket.addLast(i);
    }

    private static void closeBracket() {
        indexesOfOpenBracket.removeLast();
    }

    private static boolean checkIfZero() {
        return array[count] == 0;
    }
}
