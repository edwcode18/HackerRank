import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TruckTour {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                petrolpumps.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = truckTour(petrolpumps);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }

    public static int truckTour(List<List<Integer>> petrolpumps) {
        int indexFound = -1, counter = 0, sum = 0, complete = 0, totalStations = petrolpumps.size();
        while(complete != totalStations){
            for (int i = 0; i < totalStations; i++) {
                int index = (counter + i) % totalStations;
                if(i == 0)
                    indexFound = (counter + i) % totalStations;
                int litters = petrolpumps.get(index).get(0);
                int kilometers = petrolpumps.get(index).get(1);
                if((sum + litters) - kilometers < 0){
                    counter++;
                    sum = 0;
                    complete = 0;
                    break;
                }
                sum += litters - kilometers;
                complete++;
            }
        }
        return indexFound;
    }
}
