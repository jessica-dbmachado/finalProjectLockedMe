package simplilearn.project.module.one;

public class LockedMeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserFileActions.createMainFolderIfNotPresent("main");
		
		UserMenu.initialInfo("LockedMe", "Jessica Machado");
		
		
		HandleUserOptions.handleInitialMenuInput();
		

	}

}
