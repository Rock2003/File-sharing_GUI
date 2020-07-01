import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class CheckID {
	
	private static HashMap<String, String> map;
	final static String ID_PATH = "C:\\\\Users\\\\Youssef\\\\eclipse-workspace\\\\Database and GUI\\\\src\\\\Logins";
	
	public CheckID() throws FileNotFoundException {
			map = new HashMap<String, String>();
			File f = new File(ID_PATH);
			Scanner scan = new Scanner(f);
			while(scan.hasNextLine()) {
				map.put(scan.next(), scan.next());
			}
			scan.close();
	}
	public boolean check(String user, String password) {
		if(!map.containsKey(user)) {
			return false;
		}
		if(map.get(user).equals(password)) {
			return true;
		}
		return false;
		
	}
}
