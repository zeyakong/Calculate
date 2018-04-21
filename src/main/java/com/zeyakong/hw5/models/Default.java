package com.zeyakong.hw5.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Zeya Kong
 * On 4/5/2018 10:06 PM.
 */
public class Default {
    private HashMap<String,String> defaultMap;

    public Default(){
        defaultMap = new HashMap<>();
        defaultMap.put("add","0 0");
        defaultMap.put("sub","1 0");
        defaultMap.put("mul","2 3");
        defaultMap.put("div","4 1");
        defaultMap.put("pow","8 2");
    }

    public List<Integer> getDefaultByOp(String operation){
        if(defaultMap.containsKey(operation)){
            String[] temp = defaultMap.get(operation).split(" ");
            List<Integer> result = new ArrayList<>();
            result.add(Integer.parseInt(temp[0]));
            result.add(Integer.parseInt(temp[1]));
            return result;
        }else{
//            throw new OperationException();
            return null;
        }
    }

    public void setDefault(String operation,int x, int y){
        if(defaultMap.containsKey(operation)){
            defaultMap.put(operation,x+" "+y);
        }else{
//            throw new OperationException();
            return;
        }
    }
}
