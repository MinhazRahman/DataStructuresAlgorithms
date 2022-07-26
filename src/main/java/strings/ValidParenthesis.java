package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        //create parenthesis map
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(stack.isEmpty()){
                stack.push(ch);
            }
            else if(map.containsKey(ch) && stack.peek() == map.get(ch)){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValidParenthesis(String s) {
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        //create parenthesis map
        map.put(')', '(');

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(stack.isEmpty()){
                stack.push(ch);
            }
            else if(map.containsKey(ch) && stack.peek() == map.get(ch)){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(isValidParenthesis("(()"));
        System.out.println(isValidParenthesis("("));
        System.out.println(isValidParenthesis(")"));
        System.out.println(isValidParenthesis("(())"));
        System.out.println(isValidParenthesis("(()))"));

    }
}
