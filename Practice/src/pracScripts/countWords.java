package pracScripts;

public class countWords {

	public static void main(String[] args) {
		
		int count = 1;
		String data = "The quick brown fox jumps over the lazy dog.";
		char[] ch = data.toCharArray();
		for(int i=0;i<data.length();i++) {
			if(ch[i] == ' ') {
				count++;
			}
		}
		System.out.println(count);
	}
	
}
