package src.java_basics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModification {

    public static void failFast(){
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 3);
        map.put("Ball", 4);
        map.put("Cat", 5);

        Iterator<String> keys = map.keySet().iterator();

        while(keys.hasNext()){
            String key = keys.next();
            map.put("Dog", 6);
        }
    }

    public static void failSafe(){
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int i=4;
        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()){
            int num = itr.next();
            list.add(i++);
        }
    }
}
