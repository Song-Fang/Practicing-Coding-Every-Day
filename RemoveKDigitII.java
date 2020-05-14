package com.algorimthms;

import java.util.Stack;

public class RemoveKDigitII {

}

class RemoveKDigitIISolution{
	public String removeKdigits(String num, int k) {
        if(num==null||num.length()==0||k>=num.length()){
            return "0";
        }
        
        int count = 0;
        
        //push pop top
        Stack<Character> stack = new Stack<Character>();
        stack.push(num.charAt(0));
        for(int i =1;i<num.length();i++){
            char ele = num.charAt(i);
            while(!stack.isEmpty()&&count<k&&stack.peek()>ele){
                stack.pop();
                count++;
            }
            stack.push(ele);
        }
        
        while(count<k){
            stack.pop();
            count++;
        }
        
        StringBuilder result = new StringBuilder();
        System.out.println(stack);
        
        for(Character c :stack){
            result.append(c);
        }
        
        int index = 0;
        while(index<result.length()&&result.charAt(index)=='0'){
            //delete element in StringBuilder
            //There is no method in String to delete Character
            //index has changed
            result.deleteCharAt(index);
        }
        
        String finalResult = result.toString();
        if(finalResult.equals("")){
            return "0";
        }
        
        return finalResult;
        
        
    }
}
