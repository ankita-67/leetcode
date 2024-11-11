import java.util.Arrays;

class TrieNode
{
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
}
public class WordDictionary {
    TrieNode root;
    public  WordDictionary()
    {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b.."));
    }

    private void addWord(String word) {
        TrieNode node = root;

        for(char ch: word.toCharArray())
        {

            if(node.children[ch -'a'] == null) {

                node.children[ch - 'a'] = new TrieNode();
            }

            node =node.children[ch -'a'];
            System.out.println("outside if:"+ Arrays.toString(node.children));
        }

        node.isEndOfWord =true;
        System.out.println("outside if:" +node.isEndOfWord);
    }

    public boolean search(String word) {
        return searchInNode(word, root);
    }

    private boolean searchInNode(String word, TrieNode node) {
        System.out.println(node.children);
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (c == '.') {
                // If it's a wildcard, we need to check all possible paths
                for (TrieNode child : node.children) {
                    if (child != null && searchInNode(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false; // If no paths find a match, return false
            } else {
                int index = c - 'a';
                // If the specific child TrieNode does not exist, the word does not exist
                if (node.children[index] == null) {
                    return false;
                }
                // Move to the next node
                node = node.children[index];
            }
        }
        // After processing all characters, check if it is the end of a word
        return node.isEndOfWord;
    }
}

