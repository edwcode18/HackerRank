import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class FlippingBits {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                long result = flippingBits(n);

                System.out.println(String.valueOf(result));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }

    public static long flippingBits(long n) {
        String binaryNumber32 = String.format("%32s", Long.toBinaryString(n)).replace(' ', '0');
        StringBuilder newNumber = new StringBuilder();
        for(char number : binaryNumber32.toCharArray()){
            newNumber.append(number == '0' ? "1" : "0");
        }
        return Long.parseLong(newNumber.toString(), 2);
    }
}
