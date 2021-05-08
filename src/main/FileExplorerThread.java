package main;

import javax.swing.JScrollPane;
import javax.swing.JTree;

public class FileExplorerThread extends Thread {
	public FilePanelDialog filePanelDialog;
	public FileExplorerThread(FilePanelDialog filePanelDialog)
	{
		this.filePanelDialog = filePanelDialog;
	}

	@Override
	public void run()
	{
		setFileSystem();
	}
	public void setFileSystem()
	{
		JScrollPane fileScrollPane = FileExplorer.getFileExplorerScrollPanel();
		filePanelDialog.fileExplorerPanel.add(fileScrollPane); 
		fileScrollPane.setSize(250,200);
		fileScrollPane.setLocation(0,0);
		filePanelDialog.fileExplorerPanel.validate();
		filePanelDialog.loaderLabel.setVisible(false);
		
		JTree tree = (JTree)fileScrollPane.getViewport().getView();
		filePanelDialog.fileSystemTree = tree;
		FileExplorer.clearSelection(filePanelDialog.fileSystemTree);
	}
}
