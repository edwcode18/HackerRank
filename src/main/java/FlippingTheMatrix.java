import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FlippingTheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> matrix = new ArrayList<>();

                IntStream.range(0, 2 * n).forEach(i -> {
                    try {
                        matrix.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = flippingMatrix(matrix);

                System.out.println(String.valueOf(result));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int n = matrix.size() / 2; // Tamaño de la matriz dividido por 2
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Encuentra el máximo de cada conjunto de cuatro elementos
                int primero = matrix.get(i).get(j);
                int segundo = matrix.get(i).get(matrix.size() - 1 - j);
                int tercero = matrix.get(matrix.size() - 1 - i).get(j);
                int cuarto = matrix.get(matrix.size() - 1 - i).get(matrix.size() - 1 - j);
                int maxElement = Math.max(
                        Math.max(matrix.get(i).get(j), matrix.get(i).get(matrix.size() - 1 - j)),
                        Math.max(matrix.get(matrix.size() - 1 - i).get(j), matrix.get(matrix.size() - 1 - i).get(matrix.size() - 1 - j))
                );
                // Agrega el máximo al total de la suma
                sum += maxElement;
            }
        }
        return sum;
    }
}
