import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pairs {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int result = pairs(k, arr);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }

    public static int pairs(int k, List<Integer> arr) {
        Set<Integer> arrSet = new HashSet<>(arr);
        int pairs = 0;

        for(int num : arr){
            if(arrSet.contains(num + k))
                pairs++;
        }
        return pairs;
        // Los list son mas lentos para hacer busquedas
        /*
        int pairs = 0;
        for(int num : arr){
            if(arr.contains(num + k))
                pairs++;
        }
        return pairs;

         */
    }
}
