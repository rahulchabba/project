import java.util.ArrayDeque;
import java.util.Deque;

public class BalanceBrackets {

    public   BalanceBrackets(){

    }

    public static void main(String[] args) {
        String exp = "([{}])";
        if (checkBalanced(exp)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }

    }

    public static boolean checkBalanced(String exp) {
        Deque<Character> stack
                = new ArrayDeque<Character>();
        for (int i = 0; i < exp.length(); i++) {
            char currChatAt = exp.charAt(i);

            if (currChatAt == '{' || currChatAt == '(' || currChatAt == '[') {
                stack.push(currChatAt);
            }

            if (stack.isEmpty())
                return false;
            char check;
            switch (currChatAt) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }

        return (stack.isEmpty());
    }


}
