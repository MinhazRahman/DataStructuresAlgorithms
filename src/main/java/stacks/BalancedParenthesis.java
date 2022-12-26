package stacks;

import java.util.Stack;

public class BalancedParenthesis {

    public static boolean isBalanced(String str){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            // only push the opening parenthesis onto the stack
            if (ch == '(') stack.push(ch);
            // if there is a closing parenthesis then pop an item from the stack if
            // the stack is not empty, otherwise return false
            if (ch == ')'){
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static boolean isBalancedParenthesis(String str){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            // only push the opening parenthesis onto the stack
            if (ch == '(') stack.push(ch);
            // if there is a closing parenthesis then pop an item from the stack if
            // the stack is not empty, otherwise return false
            if (ch == ')'){
                if (!stack.isEmpty()) stack.pop();
                else return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String str = "((a+b)*(b-c))";
        System.out.println(isBalanced(str));
        System.out.println(isBalanced("((a+b)*(b-c)))"));
        System.out.println(isBalanced("((a+b)))*(b-c)"));
    }
}
