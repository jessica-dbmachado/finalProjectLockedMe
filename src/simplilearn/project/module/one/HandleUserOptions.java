package simplilearn.project.module.one;
import java.util.List;
import java.util.Scanner;

public class HandleUserOptions {
	
	public static void handleInitialMenuInput() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				UserMenu.displayInitialMenu();
				int input = sc.nextInt();

				switch (input) {
				case 1:
					UserFileActions.displayAllFiles("main");
					break;
				case 2:
					HandleUserOptions.handleSecondaryMenuInput();
					break;
				case 3:
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please select a valid option from below.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleInitialMenuInput();
			} 
		} while (running == true);
	}
	
	public static void handleSecondaryMenuInput() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				UserMenu.displaySecondaryMenu();
				UserFileActions.createMainFolderIfNotPresent("main");
				
				int input = sc.nextInt();
				switch (input) {
				case 1:
					// File Add
					System.out.println("Enter the name of the file to be added to the \"main\" folder");
					String fileToAdd = sc.next();
					
					UserFileActions.createFile(fileToAdd, sc);
					
					break;
				case 2:
					// File/Folder delete
					System.out.println("Enter the name of the file to be deleted from \"main\" folder");
					String fileToDelete = sc.next();
					
					UserFileActions.createMainFolderIfNotPresent("main");
					List<String> filesToDelete = UserFileActions.displayFileLocations(fileToDelete, "main");
					
					String deletionPrompt = "\nSelect index of which file to delete?"
							+ "\n(Enter 0 if you want to delete all elements)";
					System.out.println(deletionPrompt);
				
					int idx = sc.nextInt();
					
					if (idx != 0) {
						UserFileActions.deleteFileRecursively(filesToDelete.get(idx - 1));
					} else {
						
						// If idx == 0, delete all files displayed for the name
						for (String path : filesToDelete) {
							UserFileActions.deleteFileRecursively(path);
						}
					}
					

					break;
				case 3:
					// File/Folder Search
					System.out.println("Enter the name of the file to be searched from \"main\" folder");
					String fileName = sc.next();
					
					UserFileActions.createMainFolderIfNotPresent("main");
					UserFileActions.displayFileLocations(fileName, "main");

					
					break;
				case 4:
					// Go to Previous menu
					return;
				case 5:
					// Exit
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
				default:
					System.out.println("Please select a valid option from below.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleSecondaryMenuInput();
			}
		} while (running == true);
	}

}
