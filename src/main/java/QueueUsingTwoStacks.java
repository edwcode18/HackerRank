import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        while(sc.hasNext()){
            int queries = sc.nextInt();
            for (int i = 0; i < queries; i++) {
                int query = sc.nextInt();
                switch(query){
                    case 1:
                        int number = sc.nextInt();
                        numbers.add(number);
                        break;
                    case 2:
                        numbers.remove(0);
                        break;
                    case 3:
                        System.out.println(numbers.get(0));
                        break;
                }
            }
        }
        sc.close();
    }
}
