package trie;

/**
 * Created by kewang on 11/11/18.
 */
public class WordDictionary {
    class TrieNode{
        boolean isWord;
        TrieNode[] childrens;
        TrieNode(boolean isWord) {
            this.isWord = isWord;
            this.childrens = new TrieNode[26];
        }
    }

    TrieNode root = null;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(false);
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word == null) {
            return;
        }
        char[] wordChars = word.toCharArray();
        TrieNode current = root;
        for(int i = 0; i < wordChars.length; i++){
            int pos = wordChars[i] - 'a';
            if (current.childrens[pos] == null) {
                current.childrens[pos] = new TrieNode(false);
            }
            current = current.childrens[pos];
        }
        current.isWord = true;
    }
    // a 0 root
    private boolean searchDFS(char[] wordChars, int level, TrieNode root) {
        if(wordChars.length == level) {
            return root.isWord;
        }

        if(wordChars[level] == '.') {
            for(TrieNode children : root.childrens) {
                if(children != null && searchDFS(wordChars, level + 1, children)) {
                    return true;
                }
            }
            return false;
        } else {
            int pos = wordChars[level] - 'a';
            if(root.childrens[pos] == null) {
                return false;
            } else {
                return searchDFS(wordChars, level + 1, root.childrens[pos]);
            }
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null) {
            return true;
        }

        return searchDFS(word.toCharArray(), 0, this.root);
    }
}
