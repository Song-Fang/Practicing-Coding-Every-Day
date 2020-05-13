package com.algorimthms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {

}


class EDSolution {
    //Union Find
    //Use two map to store directed graph and value
    private Map<String,String> root = new HashMap<String,String>();
    private Map<String,Double> value = new HashMap<String,Double>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double [] result = new double[queries.size()];
        int index = 0;
        for(List<String> equation:equations){
            union(equation.get(0),equation.get(1),values[index]);
            index++;
        }
        
        index= 0;
        for(List<String> query:queries){
            String x = query.get(0);
            String y = query.get(1);
            if(root.containsKey(x)&&root.containsKey(y)&&find(x)==find(y)){
                result[index] = value.get(x)/value.get(y);
            }else{
                result[index] = -1.0;
            }
            index++;
        }
        return result;
    }
    
    private void add(String x){
        if(root.containsKey(x)) return;
        root.put(x,x);
        value.put(x,1.0);
    }
    
    //path zip
    private String find(String x){
        if(x==root.get(x)) return x;
        
        String p = root.get(x);
        String pp = find(p);
        value.put(x,value.get(x)*value.get(p));
        root.put(x,pp);
        return root.get(x);
    }
    
    
    private void union(String x, String y,double v){
        add(x);
        add(y);
        String x_root = find(x);
        String y_root = find(y);
        
        root.put(x_root,y_root);
        value.put(x_root,v*value.get(y)/value.get(x));
    }
}
