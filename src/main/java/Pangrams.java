import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pangrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        String result = pangrams(s);

        System.out.println(result);

        bufferedReader.close();
    }

    public static String pangrams(String s) {
        s = s.toLowerCase();
        Set<Character> alphabet = new HashSet<>();
        for(Character ch : s.toCharArray()){
            if(Character.isAlphabetic(ch))
                alphabet.add(ch);
        }
        return alphabet.size() == 26 ? "pangram" : "not pangram";
        /*
        List<Character> originalAlphabet = new ArrayList<>();
        s = s.toLowerCase();
        boolean pangram = true;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            originalAlphabet.add(ch);
        }
        for(char ch : originalAlphabet){
            if(!s.contains(String.valueOf(ch))){
                pangram = false;
                break;
            }
        }
        return pangram ? "pangram" : "not pangram";

         */
    }
}
