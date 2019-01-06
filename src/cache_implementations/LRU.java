package src.cache_implementations;

import java.util.HashMap;
import java.util.Map;

public class LRU {

    private Map<Integer, Node> map;
    private Node start;
    private Node end;
    private int maxCapacity;

    public LRU(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        map = new HashMap<>();
        start = null;
        end = null;
    }

    private static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addAtStart(node);
        } else {
            Node node = new Node(key, value);
            if (map.size() >= maxCapacity) {
                map.remove(end.key);
                removeNode(end);
                addAtStart(node);
            } else {
                addAtStart(node);
            }
            map.put(key, node);
        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            addAtStart(node);
            return node.value;
        }
        return -1;
    }

    public int getSize(){
        return map.size();
    }

    public void printContent(){
        for(int key : map.keySet()){
            System.out.println(key+", "+map.get(key).value);
        }
    }

    private void removeNode(Node node) {
        if(node.prev==null){
            start = node.next;
        }else{
            node.prev.next = node.next;
        }

        if(node.next == null){
            end = node.prev;
        }else{
            node.next.prev = node.prev;
        }
    }

    private void addAtStart(Node node) {
        node.next = start;
        node.prev = null;
        if (start != null) {
            start.prev = node;
        }
        start = node;
        if (end == null) {
            end = start;
        }
    }
}
