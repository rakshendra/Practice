package src.questions;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static List<List<String>> powerSet(List<String> set){
        List<List<String>> ans = new ArrayList<>();
        powerSetRec(ans, set, 0, new ArrayList<>());
        return ans;
    }

    public static void powerSetRec(List<List<String>> powerSet, List<String> set, int index, List<String> currSet){

        if(index == set.size()){
            powerSet.add(new ArrayList<>(currSet));
            return;
        }

        currSet.add(set.get(index));
        powerSetRec(powerSet, set, index+1, currSet);
        currSet.remove(currSet.size()-1);
        powerSetRec(powerSet, set, index+1, currSet);
    }
}
