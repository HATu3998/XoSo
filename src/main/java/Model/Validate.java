package Model;

public class Validate {

	public static boolean check(String str) {
	    if (str.equals("")||str.equals("0")) {
            return true;
        }
        return false;
	}
	
}
