package com.algorimthms;

class MagicDictionary {

    class TrieNode{
        char val;
        TrieNode [] children;
        boolean isWord;
        
        public TrieNode(char val){
            this.val = val;
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode(' ');
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        if(dict==null||dict.length==0) return;
        
        for(String str:dict){
            TrieNode node = root;
            for(int i =0;i<str.length();i++){
                int index = str.charAt(i)-'a';
                if(node.children[index]==null){
                    node.children[index] = new TrieNode(str.charAt(i));
                }
                node = node.children[index];
            }
            node.isWord = true;
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if(word==null||word.length()==0) return false;
        char [] wordArray = word.toCharArray();
        
        for(int i =0;i<wordArray.length;i++){
            
            for(char c = 'a';c<='z';c++){
                if(c==wordArray[i]) continue;
                char temp = wordArray[i];
                wordArray[i] = c;
                if(help(wordArray)) return true;   
                wordArray[i] = temp;
            }
            
        }
        return false;
    }

private boolean help(char [] wordArray){
    TrieNode node = root;
    for(int i =0;i<wordArray.length;i++){
        int index = wordArray[i]-'a';
        if(node.children[index]==null) return false;
        node = node.children[index];
    }
    return node.isWord;
}
}
