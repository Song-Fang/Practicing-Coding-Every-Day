package com.algorimthms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

}


class WordSearchIISolution {
    class TrieNode {
        char val;
        TrieNode [] children;
        boolean isWord;
        
        public TrieNode(char val){
            this.val = val;
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    TrieNode root = new TrieNode(' ');
    boolean [][] flag;
    int [] dx = {1,-1,0,0};
    int [] dy = {0,0,1,-1};
    
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        if(board==null||board.length==0||board[0].length==0||words==null||words.length==0) return new ArrayList<String>(result);
        flag = new boolean[board.length][board[0].length];
        for(String word:words){
            insert(word);
        }
        
        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                search(board,i,j,result,root,"");
            }
        }
        
        return new ArrayList<String>(result);
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
    
    public void search(char [][] board,int i,int j,Set<String> result,TrieNode node,String word){
        if(i<0||j<0||i>=board.length||j>=board[0].length||flag[i][j]==true){
            return;
        }
        
        if(node.children[board[i][j]-'a']==null){
            return;
        }
        
        flag[i][j] = true;
        node = node.children[board[i][j]-'a'];
        word = word+board[i][j];
        if(node.isWord){
            result.add(word);
        }
        
        for(int k = 0;k<dx.length;k++){
            int x = i+dx[k];
            int y = j+dy[k];
            search(board,x,y,result,node,word);
        }
        flag[i][j] = false;
        
    }
}
