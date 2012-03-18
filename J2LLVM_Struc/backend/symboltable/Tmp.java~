package backend.symboltable;

	public class Tmp {
	  static int var = 0;
	  static int label = 0;
	  static int str = 0;

	  public static String nv() {
		String s = "%tmp"+var;
		var++;
		return s;
	  }

	  public static String nl() {
		String s = "label_"+label;
		label++;
		return s;
	  }

	  public static String ns() {
		String s = "@.str"+str;
		str++;
		return s;
	  }

	  public static String lv() {
		String s = "%tmp"+(var-1);
		return s;
	  }

	  public static String ll() {
		String s = "label_"+(label-1);
		return s;
	  }
	}
