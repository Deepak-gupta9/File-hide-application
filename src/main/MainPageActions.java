package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MainPageActions {
	public static void setAddButtonAction()
	{
		MainPage.addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				new FilePanelDialog();
			}
		});
	}
	public static Boolean isRowAlreadyExist(String rowValue)
	{
		Vector<Vector> data = MainPage.tableModel.getDataVector();
		for(Vector vectorValue : data)
		{
			if(vectorValue.get(0).equals(rowValue))
			{
				return true;
			}
		}
		return false;
	}

	public static void setUnlockButtonAction()
	{
		MainPage.unlockButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int [] rowIndexes = MainPage.table.getSelectedRows();
				if(rowIndexes.length == 0)
					return ;
				reverseArrayOfInt(rowIndexes);
				List<String> dataList = new ArrayList<>();
				for(int rowNumber : rowIndexes)
				{
					String value = (String)MainPage.table.getValueAt(rowNumber, 0);
					if(FileOperations.unHideFileFromSystem(value))
					{
					dataList.add(value);
					MainPage.tableModel.removeRow(rowNumber);
					}
				}
				RecentDataList.appendRecentFiles(dataList);
				LockedFileDataList.removedLockedFiles(dataList);
			}
		});
	}  
	public static void reverseArrayOfInt(int [] rowIndexes)
	{
		for(int i=0;i<rowIndexes.length/2;i++)
		{
			int temp = rowIndexes[i];
			rowIndexes[i] = rowIndexes[rowIndexes.length-1-i];
			rowIndexes[rowIndexes.length-1-i] = temp;
		}
	}
	
	public static void setExitButtonAction()
	{
		MainPage.exitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				LoginScreenCloseThread loginScreenCloseThread = new LoginScreenCloseThread();
				loginScreenCloseThread.start();
			}
		});
	}
	
	public static void setOptionButtonAction()
	{
		MainPage.optionsButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ResetPasswordDialog();
			}
		});
	}
	
	public static void setRegisterButtonAction()
	{
		MainPage.registerButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				new UnderConstructionDialog();
			}
		});
	}
}
