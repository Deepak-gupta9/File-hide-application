package main;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class UnderConstructionDialog  {
	
	public JDialog dialog;
	public JLabel dialogBackground;
	public JLabel message;
	public UnderConstructionDialog()
	{
	
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		dialog = new JDialog();
		dialog.setTitle("Message");
		dialog.setSize(450,250);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = dimension.width/2 - dialog.getWidth()/2;
		int y = dimension.height/2 - dialog.getHeight()/2;
		dialog.setLocation(x,y);
		dialog.setAlwaysOnTop(true);
		dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		dialog.setResizable(false);
		dialog.setLayout(null);
		
		setDialogBackground();
		setMessage();
		
		dialog.setVisible(true);
	}
	
	public void setDialogBackground()
	{
		dialogBackground = new JLabel();
		dialogBackground.setBounds(15, 15, 415, 190);
		dialogBackground.setBackground(Color.white);
		dialogBackground.setLayout(null);
		dialogBackground.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
		dialogBackground.setOpaque(true);
		dialog.add(dialogBackground);
	}
	
	public void setMessage()
	{
		message = new JLabel("Under Construction");
		dialogBackground.add(message);
		message.setBounds(130,60,210,30);
		message.setFont(new Font("Arial",Font.BOLD,15));
		
	}

}
