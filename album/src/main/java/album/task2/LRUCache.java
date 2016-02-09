package album.task2;

import java.util.*;

public class LRUCache<K,V> extends LinkedHashMap<K, V> {


	private static final long serialVersionUID = 3234371387157176107L;
	private int size;
	public LRUCache(int size) {
		super(size,0.75f,true);
		this.size=size;
	}
	public static <K,V> LRUCache<K, V> newInstance(int size){
		return new LRUCache<K,V>(size);
	}
	public void setMaxSize(int size){
		this.size=size;
	}
	@Override
	/**
	 * every page entry has a counter; 
	 * every time page is referenced through this entry, copy the clock into the counter
	 * when a page needs to be changed, look at the counters to determine which are to change
	 */
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		// TODO Auto-generated method stub
		return size()>size;
	}
	public static void main(String[] args) {
		LRUCache<Integer, String> lruCache=LRUCache.newInstance(4);
		lruCache.put(1, "Object1");
	      lruCache.put(2, "Object2");
	      lruCache.put(3, "Object3");
	      lruCache.get(1);
	      lruCache.put(4, "Object4");
	      System.out.println(lruCache);
	      lruCache.put(5, "Object5");
	      lruCache.get(3);
	      lruCache.put(6, "Object6");
	      System.out.println(lruCache);
	      lruCache.get(4);
	      lruCache.put(7, "Object7");
	      lruCache.put(8, "Object8");
	      //1_
	      //1, 2_
	      //1, 2, 3_
	      //1_, 2, 3
	      //1, 4_, 3
	      
	      //1, 4, 5_
	      //3_, 4, 5
	      //3, 6_, 5
	      
	      //3, 6, 4_
	      //7_, 6, 4
	      //7, 8_, 4
		System.out.println(lruCache);
	}

}
