package main;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class FilePanelDialog {
	public JDialog filePanelDialog;
	
	public JLabel recentPanelHeading;
	public JLabel recentFilePanel;
	public DefaultTableModel recentTableModel;
	public JTable recentTable;
	
	
	public JLabel lockListPanelHeading;
	public JLabel lockListPanel;
	public DefaultTableModel lockListTableModel;
	public JTable lockListTable;
	
	public JButton addButton;
	public JButton removeButton;
	public JButton clearButton;
	public JButton okButton;
	public JButton cancelButton;
	
	public JLabel fileExplorerPanel;
	public JLabel loaderLabel;
	
	public JTree fileSystemTree;
	
	public FilePanelDialog()
	{
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		filePanelDialog = new JDialog();
		filePanelDialog.setTitle("Add Files And Folders");
		filePanelDialog.setSize(720,435);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = dimension.width/2 - filePanelDialog.getWidth()/2;
		int y = dimension.height/2 - filePanelDialog.getHeight()/2;
		filePanelDialog.setLocation(x,y);
		filePanelDialog.setAlwaysOnTop(true);
		filePanelDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		filePanelDialog.setResizable(false);
		filePanelDialog.setLayout(null);
		
		setRecentPanelHeading();
		setRecentFilePanel();
		setRecentTable();
		populateRecentTable();
		
		 setLockListPanelHeading();
		 setLockListPanel();
		 setLockListTable();
		 
		 setAddButton();
		FilePanelDialogActions.setAddButtonAction(this);
		
		 setRemoveButton();
		 FilePanelDialogActions.setRemoveButtonAction(this);
		 
		 setClearButton();
		 FilePanelDialogActions.setClearButtonAction(this);
		 
		 setOkButton();
		 FilePanelDialogActions.setOkButtonAction(this);
		 
		 setCancelButton();
		 FilePanelDialogActions.setCancelButtonAction(this);
		 
		 setFileExplorerPanel();
		 setFileSystem();
		 setLoaderLabel();
		 
		filePanelDialog.setVisible(true);
	}
	public void  setRecentPanelHeading(){
		recentPanelHeading = new JLabel("Recent Unlocked Files");
		recentPanelHeading.setSize(200,30);
		recentPanelHeading.setLocation(10, 10);
		filePanelDialog.add(recentPanelHeading);
	}
	public void setRecentFilePanel()
	{
		recentFilePanel = new JLabel();
		recentFilePanel.setSize(250,100);
		recentFilePanel.setLocation(10,40);
		recentFilePanel.setBackground(new Color(250,255,255,255));
		recentFilePanel.setOpaque(true);
		recentFilePanel.setLayout(null);
		recentFilePanel.setBorder(new LineBorder(new Color(10,10,10),1));
		filePanelDialog.add(recentFilePanel);
		
	}
	public void setRecentTable()
	{
		recentTableModel = new DefaultTableModel();
		recentTableModel.addColumn("Recent Files");
		
		recentTable = new JTable(recentTableModel){
			@Override
			public boolean isCellEditable(int Row,int Column)
			{
				return false;
			}
		};
		JScrollPane scrollpane = new JScrollPane(recentTable);
		scrollpane.setSize(244,94);
		scrollpane.setLocation(3,3);
		scrollpane.getViewport().setBackground(new Color(250,255,255,255));
		recentFilePanel.add(scrollpane);
		recentTable.setBackground(new Color(250,255,255,255));
		recentTable.setRowHeight(20);
		recentTable.setShowVerticalLines(false);
		recentTable.setFocusable(false);
		
		recentTable.getTableHeader().setReorderingAllowed(false);
		recentTable.getTableHeader().setBackground(Color.GRAY);
		recentTable.getTableHeader().getColumnModel().getColumn(0).setResizable(false);
	}
	public void populateRecentTable()
	{
		for(String fileString : RecentDataList.getRecentFiles()){
			recentTableModel.addRow(new Object[]{fileString});
		}
	}
	
	public void  setLockListPanelHeading(){
		lockListPanelHeading = new JLabel("Lock File Path");
		lockListPanelHeading.setSize(200,30);
		lockListPanelHeading.setLocation(420, 10);
		filePanelDialog.add(lockListPanelHeading);
	}
	public void setLockListPanel()
	{
		lockListPanel = new JLabel();
		lockListPanel.setSize(283,310);
		lockListPanel.setLocation(420,40);
		lockListPanel.setBackground(new Color(250,255,255,255));
		lockListPanel.setOpaque(true);
		lockListPanel.setLayout(null);
		lockListPanel.setBorder(new LineBorder(new Color(10,10,10),2));
		filePanelDialog.add(lockListPanel);
	}
	public void setLockListTable()
	{
		lockListTableModel = new DefaultTableModel();
		lockListTableModel.addColumn("Lock Files");
		
		lockListTable = new JTable(lockListTableModel){
			@Override
			public boolean isCellEditable(int Row,int Column)
			{
				return false;
			}
		};
		JScrollPane scrollpane = new JScrollPane(lockListTable);
		scrollpane.setSize(277,304);
		scrollpane.setLocation(3,3);
		scrollpane.getViewport().setBackground(new Color(250,255,255,255));
		lockListPanel.add(scrollpane);
		lockListTable.setBackground(new Color(250,255,255,255));
		lockListTable.setRowHeight(30);
		lockListTable.setShowVerticalLines(false);
		lockListTable.setFocusable(false);
		
		lockListTable.getTableHeader().setReorderingAllowed(false);
		lockListTable.getTableHeader().setBackground(Color.GRAY);
		lockListTable.getTableHeader().getColumnModel().getColumn(0).setResizable(false);
	}
	
	public void setAddButton()
	{
		addButton = new JButton("Add >>");
		addButton.setSize(100, 35);
		addButton.setLocation(290, 160);
		addButton.setBackground(new Color(250,255,255,255));
		addButton.setFocusable(false);
		filePanelDialog.add(addButton);
	}
	
	public void setClearButton()
	{
		clearButton = new JButton("Clear");
		clearButton.setSize(100, 35);
		clearButton.setLocation(290, 260);
		clearButton.setBackground(new Color(250,255,255,255));
		clearButton.setFocusable(false);
		filePanelDialog.add(clearButton);
	}
	
	public void setRemoveButton()
	{
		removeButton = new JButton("Remove <<");
		removeButton.setSize(100, 35);
		removeButton.setLocation(290, 210);
		removeButton.setBackground(new Color(250,255,255,255));
		removeButton.setFocusable(false);
		filePanelDialog.add(removeButton);
	}
	public void setOkButton()
	{
		okButton = new JButton("Ok");
		okButton.setSize(100, 35);
		okButton.setLocation(495, 360);
		okButton.setBackground(new Color(250,255,255,255));
		okButton.setFocusable(false);
		filePanelDialog.add(okButton);
	}
	public void setCancelButton()
	{
		cancelButton = new JButton("Cancel");
		cancelButton.setSize(100, 35);
		cancelButton.setLocation(600, 360);
		cancelButton.setBackground(new Color(250,255,255,255));
		cancelButton.setFocusable(false);
		filePanelDialog.add(cancelButton);
	}
	
	public void setFileExplorerPanel()
	{
		fileExplorerPanel = new JLabel();
		fileExplorerPanel.setSize(250,200);
		fileExplorerPanel.setLocation(10,150);
		fileExplorerPanel.setBackground(new Color(250,255,255,255));
		fileExplorerPanel.setOpaque(true);
		fileExplorerPanel.setLayout(null);
		fileExplorerPanel.setBorder(new LineBorder(new Color(10,10,10),2));
		filePanelDialog.add(fileExplorerPanel);
	}
	public void setFileSystem()
	{
	
		FileExplorerThread fileExplorerThread = new FileExplorerThread(this);
		fileExplorerThread.start();
	}
	public void setLoaderLabel()
	{
		loaderLabel = new JLabel("Please Wait...");
		fileExplorerPanel.add(loaderLabel);
		loaderLabel.setSize(200,30);
		loaderLabel.setLocation(80,60);
		
	}
	
}
