import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class JesseAndCookies {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = cookies(k, A);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }

    public static int cookies(int k, List<Integer> A) {
        // PriorityQueue se ordena automaticamente
        PriorityQueue<Integer> queue = new PriorityQueue<>(A);
        int count = 0;
        while (queue.peek() < k && queue.size() > 1) {
            int firstCookie = queue.poll();
            int secondCookie = queue.poll();

            int newCookie = firstCookie + 2 * secondCookie;
            queue.offer(newCookie);
            count++;

            if (queue.size() < 2 && queue.peek() < k) {
                count = -1;
                break;
            }
        }
        return count;
        /*
        Collections.sort(A);
        int count = 0;
        while(A.get(0) < k && A.size() > 1){
            int newElement = A.get(0) + (2 * A.get(1));
            A.remove(0);
            A.remove(0);
            A.add(newElement);
            Collections.sort(A);
            count++;
            if(A.size() < 2)
                count = -1;
        }
        return count;

         */
    }
}
