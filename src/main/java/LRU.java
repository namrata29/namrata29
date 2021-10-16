import java.util.HashMap;
import java.util.Map;

//least used - remove
//map - for efficiency
//double linkedlist for performance and alway add at begining
//or
//extend linked hashmap


//add - at head
//remove
//get
//moveTohead

class Node{
	//what is this key/val for sentinal;
	Integer value;
	Integer key;
	Node next;
	Node prev;
	
	Node(Integer key, Integer value){
		this.value = value;
		this.key = key;
			
	}
	
}

public class LRU {
	
	Map<Integer,Node> cache;
	Node head;
	Node tail;
	int capacity;
	int size =0;
	
	
	LRU(int capacity){
		cache = new HashMap<Integer,Node>();
		head = new Node(null,null);
		tail = new Node(null,null);
		head.next = tail;
		tail.prev = head;
		this.capacity = capacity;
	}
	
	public void put(Integer key, Integer value) {
		
		Node node = cache.get(key);
		//create and add
		if(node == null) {
			node = new Node(key, value);
			cache.put(key, node);
			addNodeToHead(node);
			size++;
		}else {
			node.value = value;
			moveTohead(node);
			
		}
		if(size>capacity) {
			System.out.println(size);
			Node remove = popLastNode();
			cache.remove(remove.key);
			
		}
		
	}

	public Integer get(Integer key) {
		Node node = cache.get(key);
		if(node==null) {
			return -1;
		}
		moveTohead(node);;
		return node.value;
		
	}
	
	private Node popLastNode() {
		Node last = tail.prev.prev;
		Node remove = tail.prev;
		last.next = tail;
		tail.prev = last;
		size--;
		return remove;
	}

	private void moveTohead(Node node) {
		removeNode(node);
		addNodeToHead(node);
		
	}

	private void removeNode(Node node) {
		Node prev = node.prev;
		Node next = node.next;
		prev.next = next;
		next.prev = prev;
		
	}

	private void addNodeToHead(Node node) {
		Node next = head.next;
		head.next = node;
		node.prev = head;
		node.next = next;
		next.prev = node;
		
	}
	private void print() {
		cache.entrySet().forEach(e -> System.out.println(e.getKey()+" "+e.getKey()));
		
	}
	
	
	public static void main(String[] args) {
		LRU lru = new LRU(5);
		lru.put(1, 1);
		lru.put(2, 1);
		lru.put(3, 1);
		lru.put(4, 1);
		lru.put(5, 1);
		lru.print();
		lru.put(6, 1);
		lru.print();
		
	}
	
}
