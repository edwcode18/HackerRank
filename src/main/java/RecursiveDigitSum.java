import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveDigitSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = superDigit(n, k);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }

    public static int superDigit(String n, int k) {
        if(n.length() > 1){
            long sum = 0;
            for (int i = 0; i < n.length(); i++) {
                sum += n.charAt(i) - '0';
            }
            return superDigit("" + (sum * k), 1);
        }else
            return Integer.parseInt(n);
    }
}
