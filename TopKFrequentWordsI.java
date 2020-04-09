package com.algorimthms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWordsI {

}

//using map entry
class TopKFrequentWordsISolution {
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
      
      List<Map.Entry<String,Integer>> wordsSet = new ArrayList<>();
      for(Map.Entry<String,Integer> item:map.entrySet()){
          wordsSet.add(item);
      }
      
      Collections.sort(wordsSet,new Comparator<Map.Entry<String,Integer>>(){
          @Override
          public int compare(Map.Entry<String,Integer> entry1, Map.Entry<String,Integer> entry2){
      if(entry1.getValue()==entry2.getValue()){
          return entry1.getKey().compareTo(entry2.getKey());
          }else{
              return entry2.getValue()-entry1.getValue();
          }
      }});
      
      
      for(int i =0;i<k;i++){
          results.add(wordsSet.get(i).getKey());
      }
      return results;    
  }
}
