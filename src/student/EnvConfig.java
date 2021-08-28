package student;

public class EnvConfig {

	public static String varient = "staging";// dev, test, staging
	public static String flavour = "basic";// basic, kps
	public static String baseAppPackage = "in.securelearning.lil.android.app.multitenant.student.basic.staging";
	public static String button = "android.widget.Button";
	public static String view = "android.widget.TextView";

	public static String Institutecode = "SHRI2306";
	public static String username = "KPSU1962";
	public static String password = "Qaz123wsx";
	public static String Subject = "Physics";
	public static String LRPAXEND = "Apply";

	public static String getBaseIdentifier(String id) {
		return baseAppPackage + "." + flavour + "." + varient + ":id/" + id;
	}

}