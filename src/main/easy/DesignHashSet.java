package main.easy;

import java.util.HashSet;

public class DesignHashSet {

}

class MyHashSet {

    HashSet<Integer> set;
	
    public MyHashSet() {
    	set = new HashSet<Integer>();
    }
    
    public void add(int key) {
    	set.add(key);
    }
    
    public void remove(int key) {
    	set.remove(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	return set.contains(key);
    }
}