package lab1;

import java.util.Stack;

public class lab11 {
    public boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '{' || c == '(' || c == '['){
                stack.push(c);
            }
            else if(c == '}' || c == ')' || c == ']'){
                if(stack.isEmpty()){
                    return false;

                }
                char topc = stack.pop();
                if(c == '}' && topc !='{' || c == ')' && topc != '(' || c == ']' && topc != '['){
                    return false;
                }
            }
        }

    return stack.isEmpty();
    }

}
