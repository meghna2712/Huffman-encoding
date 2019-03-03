package hauffmanencoding;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.PriorityQueue;

public class client {

	public static void main(String[] args) throws Exception {
		
	/*	
		BitSet bits = new BitSet(coded.length());
		for(int i = 0; i < coded.length(); i++){
	if(coded.charAt(i) == '1'){
		bits.set(i);
	}
}*/

		FileOutputStream fileOut = new FileOutputStream("hncoder");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		String str= fileOut.toString();
		//out.writeObject(bits);
		

		out.close();
		fileOut.close();
		
		System.out.println(str);
		HEncoder hencoder = new HEncoder(str);
		
		String coded = hencoder.encode("abc");
		System.out.println(hencoder.encode("abc"));
		System.out.println(hencoder.decode(coded));

		
//		
//		FileInputStream fileIn = new FileInputStream("hncoder");
//		ObjectInputStream in = new ObjectInputStream(fileIn);
//		BitSet readData = (BitSet) in.readObject();
//		in.close();
//		fileIn.close();
//		
//		coded = "";
//		for(int i = 0; i < readData.length(); i++){
//			if(readData.get(i)){
//				coded += "1";
//			} else {
//				coded += "0";
//			}
//		}
//		System.out.println(coded);
		
		/*Integer[] arr = {10, 25, 2, 27, 35, 40, 1, 55};
		heapSort(arr);
		
		for(Integer val: arr){
					System.out.print(val + ", ");
		}
		System.out.println("END");
		}
		
	

	public static void heapSort(Integer[] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new MarksComparator());

		for (Integer val : arr) {
			pq.add(val);
		}

		int counter = 0;
		while (!pq.isEmpty()) {
			arr[counter] = pq.remove();
			counter++;
		}
	}

	public static class MarksComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2 - o1;
		}*/

	}

}