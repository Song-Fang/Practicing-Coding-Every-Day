package com.algorimthms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWordsIII {

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
      
      PriorityQueue<Map.Entry<String,Integer>> wordsSet = new PriorityQueue<>(Comparator.comparing(Map.Entry<String,Integer>::getValue).reversed().thenComparing(Map.Entry<String,Integer>::getKey));
      
      for(Map.Entry<String,Integer> item:map.entrySet()){
          wordsSet.offer(item);
      }
      
      for(int i =0;i<k;i++){
          results.add(wordsSet.poll().getKey());
      }
      return results;    
  }
}
