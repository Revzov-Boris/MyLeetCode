import java.util.Map;
import java.util.Stack;

public class Task20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = Map.of('{', '}', '[', ']', '(', ')');
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.add(c);
            } else if (!stack.isEmpty() && map.get(stack.peek()) == c) {
                stack.pop();
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
