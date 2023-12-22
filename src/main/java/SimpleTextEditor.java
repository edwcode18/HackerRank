import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        StringBuilder S = new StringBuilder();
        Stack<String> prevOperations = new Stack<>();
        int k = 0;
        for (int i = 0; i < Q; i++) {
            int operation = sc.nextInt();
            switch(operation){
                case 1:
                    String W = sc.next();
                    prevOperations.push(S.toString());
                    S.append(W);
                    break;
                case 2:
                    k = sc.nextInt();
                    prevOperations.push(S.toString());
                    int len = S.length();
                    String deleted = S.substring(len - k);
                    S.setLength(len - k);
                    break;
                case 3:
                    k = sc.nextInt();
                    System.out.println(S.charAt(k - 1));
                    break;
                case 4:
                    if(!prevOperations.isEmpty()){
                        S = new StringBuilder(prevOperations.pop());
                    }
                    break;
            }
        }
        sc.close();
    }
}
