import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CaesarCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = caesarCipher(s, k);

        System.out.println(result);

        bufferedReader.close();
    }

    public static String caesarCipher(String s, int k) {
        k %= 26;
        StringBuilder cipherString = new StringBuilder();
        for (char letter : s.toCharArray()) {
            if (Character.isLetter(letter)) {
                char base = Character.isUpperCase(letter) ? 'A' : 'a';
                letter = (char) (((letter - base + k) % 26) + base);
            }
            cipherString.append(letter);
        }

        return cipherString.toString();
        /*
        k %= k;
        List<Character> originalAlphabet = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            originalAlphabet.add(ch);
        }

        List<Character> alphabet = new ArrayList<>();
        for (int i = 0; i < originalAlphabet.size(); i++) {
            int numberLetter = i + k;
            int limitAlphabet = originalAlphabet.size() - 1;
            char letter = numberLetter <= limitAlphabet? originalAlphabet.get(numberLetter) : originalAlphabet.get(numberLetter - limitAlphabet - 1);
            alphabet.add(letter);
        }

        String cipherString = "";
        char[] letters = s.toCharArray();
        for(char letter : letters){
            if(Character.isAlphabetic(letter)){
                if(Character.isUpperCase(letter)){
                    char lowerLetter = Character.toLowerCase(letter);
                    lowerLetter = alphabet.get(originalAlphabet.indexOf(lowerLetter));
                    cipherString += Character.toUpperCase(lowerLetter);
                }else {
                    cipherString += alphabet.get(originalAlphabet.indexOf(letter));
                }
            }else
                cipherString += letter;
        }

        return  cipherString;
         */
    }
}
