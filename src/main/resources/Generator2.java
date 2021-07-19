public class Generator2 {

	public static void main(String[] args) {
		
		//and use generate() where you want to get a new string with login\password
		System.out.println("Login : " + generate()); 
		System.out.println("Password : " + generate());
}
//take this code from here	
public static String generate() {
	
	byte[] a = new byte[10];
	for(int i=0; i < 10; i++) {
		
		byte rand = (byte)(Math.random() * 64);
		if(rand >= 0 && rand < 10) a[i] = (byte)('0' + rand);
		if(rand >= 10 && rand < 36) a[i] = (byte)('a' + rand - 10);
		if(rand >= 36 && rand < 62) a[i] = (byte)('A' + rand - 36);
		if(rand == 63) a[i] = (byte)'_';	
	}
	
	return new String(a);
	
}
//to here	
}