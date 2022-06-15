package stacks;

import java.util.Stack;
// Reverse a string using stack
public class ReverseString {

    public static String reverse(String str){
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // push the character into the stack until there is a closing parenthesis ')'
        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if (ch != ')' && ch != ' '){
                stack.push(ch);
            }
        }

        // pop the characters from the stack until there is opening parenthesis
        while (!stack.isEmpty() && stack.peek() != '('){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static String removeParenthesis(String str){
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // push the character into the stack until there is a closing parenthesis ')'
        for (int i=str.length() -1; i >=0; i--){
            char ch = str.charAt(i);

            if (ch != '(' && ch != ')' && ch != ' '){
                stack.push(ch);
            }
        }

        // pop the characters from the stack until there is opening parenthesis
        while (!stack.isEmpty() && stack.peek() != '('){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String str = "( 7+ 8 -9)";

        System.out.println(reverse(str));
        System.out.println(removeParenthesis(str));

    }
}
