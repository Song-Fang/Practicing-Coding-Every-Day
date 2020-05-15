package com.algorimthms;

import java.util.ArrayList;
import java.util.List;

public class WordSquare {
    /*
     * @param words: a set of words without duplicates
     * @return: all word squares
     */
     
     //implement TrieTree
     class TrieNode{
         char val;
         TrieNode [] children;
         boolean isWord;
         String str;
         
         public TrieNode(char val){
             this.val = val;
             children = new TrieNode[26];
             isWord = false;
         }
     }
     
     TrieNode root = new TrieNode(' ');
     
     private void insert(String word){
         TrieNode node = root;
         if(word==null||word.length()==0) return;
         for(int i =0;i<word.length();i++){
             int index = word.charAt(i)-'a';
             if(node.children[index]==null){
                 node.children[index] = new TrieNode(word.charAt(i));
             }
             node = node.children[index];
         }
         node.isWord = true;
         node.str = word;
     }
     
     
     private List<String> search(String prefix){
         List<String> result = new ArrayList<>();
         TrieNode node = root;
         if(prefix==null||prefix.length()==0) return result;
         for(int i =0;i<prefix.length();i++){
             int index = prefix.charAt(i)-'a';
             if(node.children[index]==null) return result;
             node = node.children[index];
         }
         dfs(node,result);
         return result;
     }
     
     private void dfs(TrieNode node, List<String> result){
         for(TrieNode child:node.children){
             if(child!=null&&child.isWord==true){
                 result.add(child.str);
             }
             if(child!=null){
                 dfs(child,result);
             }
         }
         return;
     }
     
    public List<List<String>> wordSquares(String[] words) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if(words==null||words.length==0) return result;
        
        for(String word:words){
            insert(word);
        }
        for(String word:words){
            List<String> curt = new ArrayList<>();
            curt.add(word);
            helper(curt,1,word.length(),result);
        }
        return result;
    }
    
    
    private void helper(List<String> curt,int k,int len,List<List<String>> result){
        if(k==len){
            result.add(curt);
            return;
        }
        String prefix = "";
        for(String s: curt){
            prefix +=s.charAt(k);
        }
        
        List<String> candidate = search(prefix);
        for(String s:candidate){
            List<String> next = new ArrayList<>(curt);
            next.add(s);
            helper(next,k+1,len,result);
        }
    }
}
