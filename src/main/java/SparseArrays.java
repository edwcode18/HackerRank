import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SparseArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = new ArrayList<>();

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = bufferedReader.readLine();
            strings.add(stringsItem);
        }

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = new ArrayList<>();

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = bufferedReader.readLine();
            queries.add(queriesItem);
        }

        List<Integer> res = matchingStrings(strings, queries);

        for (int i = 0; i < res.size(); i++) {
            System.out.println(String.valueOf(res.get(i)));

            if (i != res.size() - 1) {
                System.out.print("\n");
            }
        }

        bufferedReader.close();
    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> results = new ArrayList<>(Collections.nCopies(queries.size(), 0));
        for (int i = 0; i < queries.size(); i++) {
            for (int j = 0; j < strings.size(); j++) {
                if(queries.get(i).equals(strings.get(j)))
                    results.set(i, results.get(i) + 1);
            }
        }
        return results;
    }
}
