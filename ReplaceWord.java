package com.algorimthms;

import java.util.List;

public class ReplaceWord {

}

class ReplaceWordSolution {
    class TrieNode{
        char val;
        TrieNode [] children;
        boolean isWord;
        public TrieNode(char val){
            this.val = val;
            isWord = false;
            children = new TrieNode[26];
        }
    }
    
    private TrieNode root;
    
    public String replaceWords(List<String> dict, String sentence) {
        if(dict==null||sentence==null) return null;
        root = new TrieNode(' ');
        for(String word:dict){
            //inset into our dictionary
            insert(word);
        }
        
        //find root
        String [] arr = sentence.split(" ");
        for(int i =0;i<arr.length;i++){
            arr[i] = findRoot(arr[i]);
        }
        
        String result = "";
        for(String ele:arr){
            result = result+ele+" ";
        }
        
        return result.trim();       
    }
    
    public void insert(String word){
        if(word==null||word.length()==0) return;
        TrieNode node = root;
        for(int i =0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(node.children[index]==null){
                node.children[index] = new TrieNode(word.charAt(i));
            }
            node = node.children[index];
        }
        node.isWord = true;
    }
    
    public String findRoot(String word){
        TrieNode node = root;
        for(int i =0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(node.children[index]==null){
                return word;
            }
            if(node.children[index].isWord){
                return word.substring(0,i+1);
            }
            node = node.children[index];
        }
        return word;
    }
}
