
// User function Template for Java
class Trie {

    // Define a TrieNode class
    class TrieNode {
        TrieNode[] children = new TrieNode[26]; // for lowercase a-z
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a'; // calculate index based on char
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(); // create node if not exist
            }
            node = node.children[index];
        }
        node.isEndOfWord = true; // mark end of the word
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false; // if not found
            }
            node = node.children[index];
        }
        return node.isEndOfWord; // word must end here
    }

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false; // if any char not found
            }
            node = node.children[index];
        }
        return true; // prefix exists
    }
}
