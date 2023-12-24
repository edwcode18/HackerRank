import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class GridChallenge {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                String result = gridChallenge(grid);

                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }

    public static String gridChallenge(List<String> grid) {
        int columns = grid.get(0).length();
        for (int i = 0; i < grid.size(); i++) {
            char[] wordArray = grid.get(i).toCharArray();
            Arrays.sort(wordArray);
            grid.set(i, new String(wordArray));
        }

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < grid.size() - 1; j++) {
                if(grid.get(j).charAt(i) > grid.get(j + 1).charAt(i)){
                    return "NO";
                }
            }
        }
        return "YES";
    }
}
