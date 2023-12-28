import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NoPrefixSet {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String wordsItem = bufferedReader.readLine();
            words.add(wordsItem);
        }

        noPrefix(words);

        bufferedReader.close();
    }

    static boolean addWord(TrieNode root, String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            if (current.children.containsKey(ch)) {
                // Si se encuentra una palabra completa en un prefijo, devuelve verdadero
                if (current.children.get(ch).isEndOfWord) {
                    return true;
                }
                current = current.children.get(ch);
            } else {
                TrieNode newNode = new TrieNode();
                current.children.put(ch, newNode);
                current = newNode;
            }
        }

        current.isEndOfWord = true;

        // Si una palabra completa es un prefijo de otra palabra, devuelve verdadero
        return !current.children.isEmpty();
    }

    public static void noPrefix(List<String> words) {
        TrieNode root = new TrieNode();
        boolean prefixFound = false;

        for (String word : words) {
            if (!prefixFound && addWord(root, word)) {
                prefixFound = true;
                System.out.println("BAD SET");
                System.out.println(word);
                return;
            }
        }

        if (!prefixFound) {
            System.out.println("GOOD SET");
        }
    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}