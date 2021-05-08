package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class MainPage {
	public static JLabel mainGround;
	
	public static JLabel topGround;
	public static JLabel leftTopGroundImage;
	public static JButton topRight_topGround;
	public static JButton optionsButton;
	public static JButton supportButton;
	
	
	public static JLabel midGroundSupporter;
	public static JLabel midGround;
	public static DefaultTableModel tableModel;
	public static JTable table;
	
	public static JLabel bottomGround;
	public static JButton registerButton;
	public static JButton addButton;
	public static JButton unlockButton;
	public static JButton exitButton;
	//public static JButton addInnerButton;
	
	public static void setMainPage()
	{
		mainGround = new JLabel();
		mainGround.setSize(713,390);
		mainGround.setBackground(Color.PINK);
		mainGround.setOpaque(true);
		mainGround.setVisible(false);
		MainApplication.mainWindow.add(mainGround);
		setTopGround();
		setTopRightButton();
		setOptionsButton();
		setSupportButton();
		setLeftTopGroundImage();
		
		setMidGroundSupporter();
		setMidGround();
		setTable();
		
		setBottomGround();
		setRegisterButton();
		//setAddInnerButton();
		setAddButton();
		setUnlockButton();
		setExitButton();	
		
		MainPageActions.setAddButtonAction();
		MainPageActions.setUnlockButtonAction();
		MainPageActions.setExitButtonAction();
		MainPageActions.setOptionButtonAction();
		MainPageActions.setRegisterButtonAction();
	}
	public static void setTopGround()
	{
		topGround = new JLabel();
		topGround.setLayout(null);
		topGround.setSize(713,40);
		topGround.setLocation(0,0);
		topGround.setBackground(Color.GRAY);
		topGround.setOpaque(true);
		mainGround.add(topGround);
	}
	public static void setTopRightButton()
	{
		topRight_topGround = new JButton();
		topRight_topGround.setLayout(null);
		topRight_topGround.setSize(230,25);
		topRight_topGround.setLocation(450,7);
		topRight_topGround.setBackground(new Color(204,204,204,255));
		topRight_topGround.setEnabled(false);
		topGround.add(topRight_topGround);
	}
	public static void setOptionsButton()
	{
		ImageIcon optionIcon = new ImageIcon(MainApplication.class.getResource("/resources/options.png"));
		optionsButton = new JButton("Options",optionIcon);
		optionsButton.setSize(100,15);
		optionsButton.setLocation(10,5);
		optionsButton.setBackground(Color.white);
		optionsButton.setIconTextGap(10);
		optionsButton.setFocusPainted(false);
		optionsButton.setFont(new Font("Arial",Font.PLAIN,12));
		topRight_topGround.add(optionsButton);
	}
	public static void setSupportButton()
	{
		ImageIcon supportIcon = new ImageIcon(MainApplication.class.getResource("/resources/support.png"));
		supportButton = new JButton("Support",supportIcon);
		supportButton.setSize(100,15);
		supportButton.setLocation(120,5);
		supportButton.setBackground(Color.white);
		supportButton.setIconTextGap(10);
		supportButton.setFocusPainted(false);
		supportButton.setFont(new Font("Arial",Font.PLAIN,12));
		topRight_topGround.add(supportButton);
	}
	public static void setLeftTopGroundImage()
	{
		ImageIcon leftTopGroundImageIcon = new ImageIcon(MainApplication.class.getResource("/resources/lockopen.png"));
		leftTopGroundImage = new JLabel();
		leftTopGroundImage.setSize(leftTopGroundImageIcon.getIconWidth(),leftTopGroundImageIcon.getIconHeight());
		leftTopGroundImage.setLocation(10,4);
		leftTopGroundImage.setIcon(leftTopGroundImageIcon);
		topGround.add(leftTopGroundImage);
	}
	public static void setMidGroundSupporter()
	{
		midGroundSupporter = new JLabel();
		midGroundSupporter.setLocation(0,40);
		midGroundSupporter.setSize(713,350);
		midGroundSupporter.setLayout(null);
		midGroundSupporter.setBackground(new Color(233,239,236,255));
		midGroundSupporter.setOpaque(true);
		midGroundSupporter.setBorder(new LineBorder(new Color(10,10,10),3));
	    mainGround.add(midGroundSupporter);
	}
	public static void setMidGround()
	{
		midGround = new JLabel();
		midGround.setLocation(3,3);
		midGround.setSize(707,284);
		midGround.setLayout(null);
		midGround.setBackground(Color.WHITE);
		midGround.setOpaque(true);
		midGroundSupporter.add(midGround);
	}
	public static void setTable()
	{
		tableModel = new DefaultTableModel();
		tableModel.addColumn("File Path");
		tableModel.addColumn("Status");
		
		table = new JTable(tableModel){
			@Override
			public boolean isCellEditable(int Row,int Column)
			{
				return false;
			}
		};
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setSize(702,278);
		scrollpane.setLocation(3,3);
		scrollpane.getViewport().setBackground(new Color(233,239,236,255));
		midGround.add(scrollpane);
		table.setBackground(new Color(233,239,236,255));
		table.setRowHeight(38);
		table.setShowVerticalLines(false);
		table.setFocusable(false);
		table.setSelectionBackground(new Color(87,255,152,115));
		table.getColumnModel().getColumn(0).setPreferredWidth(480);
		
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setBackground(Color.LIGHT_GRAY);
	}
	public static void setBottomGround()
	{
		bottomGround = new JLabel();
		bottomGround.setLocation(3,287);
		bottomGround.setSize(707,60);
		bottomGround.setLayout(null);
		bottomGround.setBackground(Color.GRAY);
		bottomGround.setOpaque(true);
		midGroundSupporter.add(bottomGround);
	}
	public static void setRegisterButton()
	{
		registerButton = new JButton("Register");
		registerButton.setSize(100,30);
		registerButton.setLocation(10,17);
		registerButton.setForeground(Color.white);
		registerButton.setBackground(new Color(63,187,117,255));
		registerButton.setFont(new Font("Arial",Font.BOLD,12));
		registerButton.setFocusable(false);
		bottomGround.add(registerButton);
	}
	public static void setAddButton()
	{
		addButton = new JButton();
		addButton.setSize(105,32);
		addButton.setLocation(300,15);
		addButton.setFocusable(false);
		ImageIcon buttonImage = new ImageIcon(MainApplication.class.getResource("/resources/Add.png"));
		addButton.setIcon(buttonImage);
		addButton.setContentAreaFilled(false);
		bottomGround.add(addButton);
	}
	public static void setUnlockButton()
	{
		unlockButton = new JButton();
		unlockButton.setSize(105,32);
		unlockButton.setLocation(410,15);
		unlockButton.setFocusable(false);
		ImageIcon buttonImage = new ImageIcon(MainApplication.class.getResource("/resources/unlockImage.png"));
		unlockButton.setIcon(buttonImage);
		unlockButton.setContentAreaFilled(false);
		bottomGround.add(unlockButton);
	}
	public static void setExitButton()
	{
		exitButton = new JButton();
		exitButton.setSize(105,32);
		exitButton.setLocation(580,15);
		exitButton.setFocusable(false);
		ImageIcon buttonImage = new ImageIcon(MainApplication.class.getResource("/resources/lockexit.png"));
		exitButton.setIcon(buttonImage);
		exitButton.setContentAreaFilled(false);
		bottomGround.add(exitButton);
	}
	/*public static void setAddInnerButton()
	{
		addInnerButton = new JButton();
		addInnerButton.setSize(50,30);
		addInnerButton.setLocation(350,18);
		addInnerButton.setFocusable(false);
		ImageIcon buttonImage = new ImageIcon(MainApplication.class.getResource("/resources/combo.png"));
		addInnerButton.setIcon(buttonImage);
		addInnerButton.setContentAreaFilled(false);
		bottomGround.add(addInnerButton);
	}*/

}
