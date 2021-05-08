package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class FilePanelDialogActions {
	public static void setAddButtonAction(FilePanelDialog dialogObject)
	{
		dialogObject.addButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			// Get Selected Files from Recent List
			int [] selectedRows = dialogObject.recentTable.getSelectedRows();
			for(int rowNumber : selectedRows)
			{
				String rowValue = (String)dialogObject.recentTable.getValueAt(rowNumber, 0);
				if(FileOperations.isValidFile(rowValue))
				{
					if(!isRowAlreadyExist(rowValue,dialogObject))
					{
						dialogObject.lockListTableModel.addRow(new Object[]{rowValue});
					}
				}
			}
			
			//Get Selected Files From FileExplorer
			String filePath = FileExplorer.getSelectedFile();
			if(FileOperations.isValidFile(filePath))
			{
				if(!isRowAlreadyExist(filePath,dialogObject))
				{
					dialogObject.lockListTableModel.addRow(new Object[]{filePath});
				}
			}
			}
	}); 
}
	public static Boolean isRowAlreadyExist(String rowValue, FilePanelDialog dialogObject)
	{
		Vector<Vector> data = dialogObject.lockListTableModel.getDataVector();
		for(Vector vectorValue : data)
		{
			if(vectorValue.get(0).equals(rowValue))
			{
				return true;
			}
		}
		return false;
	}
	
	public static void setRemoveButtonAction(FilePanelDialog dialogObject)
	{
		dialogObject.removeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				int [] rowIndexes = dialogObject.lockListTable.getSelectedRows();
				if(rowIndexes.length == 0)
					return ;
				reverseArrayOfInt(rowIndexes);
				for(int rowNumber : rowIndexes)
				{
					dialogObject.lockListTableModel.removeRow(rowNumber);
				}
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
	public static void setCancelButtonAction(FilePanelDialog dialogObject)
	{
		dialogObject.cancelButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				dialogObject.filePanelDialog.dispose();
			}
	}); 
}
	public static void setClearButtonAction(FilePanelDialog dialogObject)
	{
		dialogObject.clearButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				dialogObject.recentTable.clearSelection();
				dialogObject.lockListTable.clearSelection();
				if(dialogObject.fileSystemTree != null)
				{
					FileExplorer.clearSelection(dialogObject.fileSystemTree);
				}
			}
	}); 
}
	public static void setOkButtonAction(FilePanelDialog dialogObject)
	{
		dialogObject.okButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Vector<Vector> dataVector = dialogObject.lockListTableModel.getDataVector();
				List<String> files = new ArrayList<>();
				for(Vector data : dataVector)
				{
					String value = data.get(0).toString();
					if(!MainPageActions.isRowAlreadyExist(value))
					{
						if(FileOperations.hideFileFromSystem(value))
						{
						MainPage.tableModel.addRow(new Object[]{value,"Active"});
						files.add(value);
						}
					}
					
				}
				LockedFileDataList.appendLockedFiles(files);
				dialogObject.filePanelDialog.dispose();
			}
	}); 
}
	
	
}
