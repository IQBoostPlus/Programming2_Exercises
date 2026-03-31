
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string of brackets to check if they are properly matched:");
        String brackets = input.nextLine();
        if (areBracketsMatched(brackets)) {
            System.out.println("The brackets are properly matched.");
        } else {
            System.out.println("The brackets are not properly matched.");
        }
    }
    private static boolean areBracketsMatched(String s) {
        if(s.length()%2==1) return false;
        Stack<Character> str = new Stack<>();
        for(char c : s.toCharArray()){
            if((c==')'||c=='}'||c==']')&&str.empty()){
                return false;
            }
            if(c==')'&&str.peek()=='('){
                str.pop();
            }
            else if(c==']'&&str.peek()=='['){
                str.pop();
            }
            else if(c=='}'&&str.peek()=='{'){
                str.pop();
            }
            else str.push(c);
        }
        return str.empty();
    }
}
