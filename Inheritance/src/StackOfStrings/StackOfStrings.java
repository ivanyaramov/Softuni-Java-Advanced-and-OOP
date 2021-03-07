package StackOfStrings;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class StackOfStrings extends ArrayDeque<String> {
    private ArrayList<String> data;
    @Override
    public void push(String item){
        data.add(item);
    }
    @Override
    public String pop(){
       String toReturn=data.remove(data.size()-1);
       return toReturn;
    }
    public String peek(){
        return data.get(data.size()-1);
    }
}
