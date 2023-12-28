import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        plusMinus(arr);

        bufferedReader.close();
    }

    public static void plusMinus(List<Integer> arr) {
        double positiveNumbers = 0, negativeNumbers = 0, zeroNumbers = 0;

        for (int number : arr) {
            if(number == 0) zeroNumbers++;
            else if(number > 0) positiveNumbers++;
            else negativeNumbers++;
        }

        System.out.println(positiveNumbers > 0 ? (positiveNumbers / arr.size()) : 0);
        System.out.println(negativeNumbers > 0 ? (negativeNumbers / arr.size()) : 0);
        System.out.println(zeroNumbers > 0 ? (zeroNumbers / arr.size()) : 0);
    }
}

