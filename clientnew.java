package hauffmanencoding;

public class clientnew {


		public static void main(String[] args) throws Exception {
			String s = "aaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccccccddddddddddddddddddeeeeeeeeeeeeeffffgggggggghhhhhiiiijkllmmmmmmnnnoo";
			System.out.println(s.length());
			HEncoder hencoder = new HEncoder(s);
			
			String coded = hencoder.encode(s);
			System.out.println(coded.length());
			System.out.println(hencoder.decode(coded));

	}

}
