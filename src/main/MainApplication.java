package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainApplication {
	public static JFrame mainWindow;
	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		mainWindow = new JFrame("Protected Application");
		mainWindow.setSize(720,422);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = dimension.width/2 - mainWindow.getWidth()/2;
		int y = dimension.height/2 - mainWindow.getHeight()/2;
		mainWindow.setLocation(x,y);
		mainWindow.setResizable(false);
		mainWindow.setLayout(null);
		
		// Set Login Background
		LoginBackground.setMainBackground();
		
		// Set Main page										
		MainPage.setMainPage();
		
		// Check Application Directory
		FileOperations.checkApplicationDirectory();
		
		//Populate Recent File Data
		RecentDataList.populateRecentFileData();
		
		//Populate Locked Files Data into main page table
		LockedFileDataList.populateLockedFileData();
		
		
		//new FilePanelDialog();
		//new ResetPasswordDialog();
		
		mainWindow.setVisible(true);
	}
}
