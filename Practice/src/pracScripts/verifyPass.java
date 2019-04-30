package pracScripts;

import java.util.ArrayList;
import java.util.Scanner;

public class verifyPass {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1. A password must have at least eight characters.");
		System.out.println("2. A password consists of only letters and digits.");
		System.out.println("3. A password must contain at least two digits");
		String pass = sc.next();
		verify(pass);
		sc.close();
	}
	
	public static void verify(CharSequence pass) {
		if(pass.length()<9&&pass.length()>1&&arr((String) pass)) {
			System.out.println("Your Password is Valid: "+pass);
		}else {
			System.out.println("Your Password is Invalid");
		}
	}
	
	public static boolean arr(String pass) {
		
		String data = "qwertyuiopasdfghjklzxcvbnm0987654321";
		ArrayList<Character> al = new ArrayList<Character>();
		for(int i=0;i<data.length();i++) {al.add((data.toCharArray())[i]);}
		char[] ch = pass.toCharArray();
		for(int i=0;i<ch.length;i++) {
			if(!al.contains(ch[i])) {
				return false;
			}
		}
		return true;
	}
	
}
