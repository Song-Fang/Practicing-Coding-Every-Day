package com.algorimthms;

public class RemoveKDigitI {

}


class RemoveKDigitSolutionI{
	public String removeKdigits(String num, int k) {
        if(num==null||num.length()==0||k>=num.length()){
            return "0";
        }
        
        int count = 0;
        
        StringBuilder result = new StringBuilder();
        result.append(num.charAt(0));
        for(int i =1;i<num.length();i++){
            while(result.length()!=0&&count<k&&num.charAt(i)<result.charAt(result.length()-1)){
                result.deleteCharAt(result.length()-1);
                count++;
            }
            result.append(num.charAt(i));
            
        }
        
        while(count<k){
            result.deleteCharAt(result.length()-1);
            count++;
        }
        
        int index = 0;
        while(index<result.length()&&result.charAt(index)=='0'){
            result.deleteCharAt(index);
        }
        
        if(result.length()==0){
            return "0";
        }
        
        return result.toString();
        
        
    }
}
