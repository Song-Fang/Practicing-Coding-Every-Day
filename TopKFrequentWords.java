package com.algorimthms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords {
 
}
//Using Comparable
//Creating a new class To contain instance
class TopKFrequentWordsSolution{
	public List<String> topKFrequent(String[] words, int k) {
        List<String> results = new ArrayList<String>();
        if(words==null||words.length==0||k<=0||k>words.length){
            return results;
        }
        
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(String str:words){
            if(!map.containsKey(str)){
                map.put(str,1);
            }else{
                map.put(str,map.get(str)+1);
            }
        }
        
        List<WordsSet> wordsSet = new ArrayList<WordsSet>();
        for(String item:map.keySet()){
            WordsSet word = new WordsSet(item,map.get(item));
            wordsSet.add(word);
        }
        
        Collections.sort(wordsSet);
        for(int i =0;i<k;i++){
            results.add(wordsSet.get(i).word);
        }
        return results;    
    }
}

class WordsSet implements Comparable{
    
    String word;
    int count;
    
    public WordsSet(String word, int count){
        this.word = word;
        this.count = count;
    }
    
    @Override
    public int compareTo(Object obj){
        WordsSet item = (WordsSet)obj;
        if(this.count== item.count){
            return this.word.compareTo(item.word);
        }else{
            return item.count-this.count;
        }
    }
    
}
