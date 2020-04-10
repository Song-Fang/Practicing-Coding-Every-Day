package com.algorimthms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWordsIV {

}

//using map entry
class TopKFrequentWordsIISolution {
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
      Comparator<Map.Entry<String, Integer>> comparator = Comparator.comparing(Map.Entry<String,Integer>::getValue).reversed().thenComparing(Map.Entry<String,Integer>::getValue);
      PriorityQueue<Map.Entry<String,Integer>> wordsSet = new PriorityQueue<>(k,comparator.reversed());
      Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
      
      while(wordsSet.size()<k) {
    	  wordsSet.offer(iterator.next());
      }
      for(int i =k;i<map.size();i++) {
    	  Map.Entry<String, Integer> entry = iterator.next();
    	  if(comparator.compare(entry, wordsSet.peek())<0){
    		  wordsSet.poll();
    		  wordsSet.offer(entry);
    	  }
      }
      
      
      for(int i =0;i<k;i++){
          results.add(wordsSet.poll().getKey());
      }
      Collections.reverse(results);
      return results;
  }
}
