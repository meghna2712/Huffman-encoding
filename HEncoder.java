package hauffmanencoding;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class HEncoder {
	private HashMap<Character, String> encoder = new HashMap<>();
	private HashMap<String, Character> decoder = new HashMap<>();

	public HEncoder(String feeder) {
		// Step 1 - Prepare the fmap
		HashMap<Character, Integer> fmap = new HashMap<>();

		for (int i = 0; i < feeder.length(); i++) {
			Character ch = feeder.charAt(i);

			if (fmap.containsKey(ch)) {
				int ov = fmap.get(ch);
				int nv = ov + 1;
				fmap.put(ch, nv);
			} else {
				fmap.put(ch, 1);
			}
		}

		// Step 2
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Set<Character> chars = fmap.keySet();
		for(Character ch: chars){
			Node node = new Node();
			
			node.data = ch;
			node.cost = fmap.get(ch);
			node.left = null;
			node.right = null;
			
			pq.add(node);
		}
		
		// Step 3
		while(pq.size() != 1){
			Node one = pq.remove();
			Node two = pq.remove();
			
			Node combined = new Node();
			
			combined.data = '\0';
			combined.cost = one.cost + two.cost;
			combined.left = one;
			combined.right = two;
			
			pq.add(combined);
		}
		
		// Step 4 -> Get final node
		Node finalNode = pq.remove();
		
		// Step 5 -> traverse the node to fill encoder and decoder
		this.traverse(finalNode, "");
	}
	
	private void traverse(Node node, String osf){
		if(node.left == null && node.right == null){
			this.encoder.put(node.data, osf);
			this.decoder.put(osf, node.data);
			return;
		}
		
		this.traverse(node.left, osf + "0");
		this.traverse(node.right, osf + "1");
	}

	private class Node implements Comparable<Node> {
		Character data;
		int cost;
		Node left;
		Node right;

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}

	public String encode(String str){
		String rv = "";
		
		for(int i = 0; i < str.length(); i++){
			Character ch = str.charAt(i);
			String code = this.encoder.get(ch);
			rv = rv + code;
		}
		
		return rv;
	}
	
	public String decode(String str){
		String rv = "";
		
		String key = "";
		for(int i = 0; i < str.length(); i++){
			key += str.charAt(i);
			if(decoder.containsKey(key)){
				rv = rv + decoder.get(key);
				key = "";
			}
		}
		
		return rv;
	}
}
