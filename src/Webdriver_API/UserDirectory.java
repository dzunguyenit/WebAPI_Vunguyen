package Webdriver_API;

public class UserDirectory {

	public static void main(String[] args) {
		String userPath = System.getProperty("user.dir");
		System.out.println("root = " + userPath);
		System.out.println("root = " + userPath.concat("/driver/chromedriver.exe"));
	}

}
