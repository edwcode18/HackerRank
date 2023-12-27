import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;

public class BalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = isBalanced(s);

                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }

    public static String isBalanced(String s) {
        Map<Character, Character> bracketsPairs = Map.of('{','}','[',']','(',')');
        Stack<Character> brackets = new Stack<>();
        for (char bracket : s.toCharArray()){
            if (bracketsPairs.containsKey(bracket)) brackets.push(bracketsPairs.get(bracket));
            else if (brackets.isEmpty() || bracket != brackets.pop()) return "NO";
        }
        return brackets.isEmpty() ? "YES" : "NO";
        /*
        Stack<Character> brackets = new Stack<>();
        char[] arrayBrackets = s.toCharArray();
        for (char bracket : arrayBrackets) {
            if (bracket == '{') brackets.push('}');
            else if (bracket == '[') brackets.push(']');
            else if (bracket == '(') brackets.push(')');
            else if (brackets.isEmpty()) return "NO";
            else if (bracket == brackets.peek()) brackets.pop();
            else break;
        }
        return brackets.isEmpty() ? "YES" : "NO";
         */
    }
}
