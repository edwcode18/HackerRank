import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class NewYearChaos {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int bribes = 0;
        for (int i = 0; i < q.size(); i++) {
            int originalPosition = q.get(i) - 1;

            if(originalPosition - i > 2){
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(0, originalPosition - 1); j < i; j++) {
                if(q.get(j) > originalPosition + 1)
                    bribes++;
            }
        }
        System.out.println(bribes);
    }
}
