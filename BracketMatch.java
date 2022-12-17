import java.util.*;

public class BracketMatch {

    public static boolean bracketsMatch(String inputStr) {

        // create stack
        Stack stack = new Stack();

        // convert inputString to char array
        char[] charArray = inputStr.toCharArray();


        for (int i = 0; i < charArray.length; i++) {
            char element = charArray[i];

            //check current is '(', '[' or '{'
            if (element == '{' || element == '[' || element == '(') {
                // push current to stack   
                stack.push(element);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }
            char popChar;
            switch (element) {
                case ')':
                    popChar = (char) stack.pop();
                    if (popChar == '{' || popChar == '[')
                        return false;
                    break;
                case '}':
                    popChar = (char) stack.pop();
                    if (popChar == '(' || popChar == '[')
                        return false;
                    break;
                case ']':
                    popChar = (char) stack.pop();
                    if (popChar == '(' || popChar == '{')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }
    public static void main(String[] args) {

        String inputStr;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter tring:");
        inputStr = sc.nextLine();

        //  check input string is balanced or not
        if (bracketsMatch(inputStr))
            System.out.println(inputStr+" is balanced.");
        else
            System.out.println(inputStr+" is not balanced.");
    }
}  
