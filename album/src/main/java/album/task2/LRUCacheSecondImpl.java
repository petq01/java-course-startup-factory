package album.task2;

import java.util.HashMap;

public class LRUCacheSecondImpl {
	int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head = null;
	Node end = null;

	public LRUCacheSecondImpl(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		return -1;
	}

	private void setHead(Node n) {
		n.next = head;
		n.pre = null;
	}

	public void remove(Node n) {
		if (n.pre != null) {
			n.pre.next = n.next;
		} else {
			head = n.next;
		}
		if (n.next != null) {
			n.next.pre = n.pre;
		} else {
			end = n.pre;
		}
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		} else {
			Node created = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(end.key);
				remove(end);
				setHead(created);

			} else {
				setHead(created);
			}

			map.put(key, created);
		}
	}
}
