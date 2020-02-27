package src.questions;

import java.util.*;

public class KFreq{

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num:nums){
            if(freq.containsKey(num)){
                freq.put(num, freq.get(num)+1);

            }else{
                freq.put(num,1);
            }
        }
        Integer[] entries = new Integer[freq.size()];
        Integer[] heap = new Integer[k];
        int i=0;
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            entries[i]=entry.getKey();
            i++;
        }
        for(i=0;i<k;i++){
            heap[i]=entries[i];
        }

        for(int j=k/2-1;j>=0;j--){
            heapify(heap,j,k, freq);
        }

        for(i=k;i<entries.length;i++){
            if(freq.get(entries[i]) > freq.get(heap[0])){
                heap[0] = entries[i];
                heapify(heap,0,k, freq);
            }
        }

        return Arrays.asList(heap);
    }

    public void heapify(Integer[] arr, int j, int n, Map<Integer,Integer> map){
        int min=j;
        int l = 2*j+1;
        int r = 2*j+2;

        if(l<n && map.get(arr[min]) > map.get(arr[l])){
            min=l;
        }
        if(r<n && map.get(arr[min]) > map.get(arr[r])){
            min=r;
        }
        if(min!=j){
            int temp = arr[min];
            arr[min] = arr[j];
            arr[j] = temp;
            heapify(arr, min, n, map);
        }
    }
}