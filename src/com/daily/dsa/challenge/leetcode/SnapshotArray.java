package src.com.daily.dsa.challenge.leetcode;

import java.util.*;

public class SnapshotArray {

    TreeMap<Integer, Integer>[] store;
    int snapId = 0;

    public SnapshotArray(int length) {
        store = new TreeMap[length];
        for (int x = 0; x< length; x++){
            store[x] = new TreeMap<>();
            store[x].put(snapId,0);
        }
    }

    public void set(int index, int val) {
        store[index].put(snapId,val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        return store[index].floorKey(snap_id);
    }

//    int[] array;
//    List<int[]> snaps = new ArrayList<>();
//
//    public SnapshotArray(int length) {
//        array = new int[length];
//    }
//
//    public void set(int index, int val) {
//        array[index] = val;
//    }
//
//    public int snap() {
//        snaps.add(Arrays.copyOf(array,array.length));
//        return snaps.size() - 1;
//    }
//
//    public int get(int index, int snap_id) {
//        return snaps.get(snap_id)[index];
//    }
}
