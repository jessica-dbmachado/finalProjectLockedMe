package simplilearn.project.module.one;

public class UserMenu {

	public static void initialInfo(String appName, String devName) {
		
		String companyDetails = String.format("*****************************************************\n"
				+ "** Welcome to %s.com.  Final project from Simpli Learn Java Module\n" + "** This application was developed by %s.\n"
				+ "*****************************************************\n", appName, devName);
		
		
		String appFunction = "You can use this application to:\n"
				+ " * Retrieve all file names in the \"main\" folder\n"
				+ " * Search, add, or delete files in \"main\" folder.\n";
		
		System.out.println(companyDetails);

		System.out.println(appFunction);
	}
	
	public static void displayInitialMenu() {
		String menu = "\n\n****** Select any option number from below and press Enter ******\n\n"
				+ "1) Retrieve all files inside \"main\" folder\n" + "2) Display menu for File operations\n"
				+ "3) Exit program\n";
		System.out.println(menu);

	}
	
	public static void displaySecondaryMenu() {
		String fileMenu = "\n\n****** Select any option number from below and press Enter ******\n\n"
				+ "1) Add a file to \"main\" folder\n" + "2) Delete a file from \"main\" folder\n"
				+ "3) Search for a file from \"main\" folder\n" + "4) Show Previous Menu\n" + "5) Exit program\n";

		System.out.println(fileMenu);
	}
	
}
