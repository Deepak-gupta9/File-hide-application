package main;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class ResetPasswordDialog {

	public JDialog dialog;
	public JLabel dialogBackground;
	public JLabel currentPassLabel;
	public JLabel newPassLabel;
	public JLabel confirmPassLabel;
	
	public JTextField currentPassTextField;
	public JTextField newPassTextField;
	public JTextField confirmPassTextField;
	
	public JButton applyButton;
	public JLabel warnMessage;
	
	public ResetPasswordDialog()
	{
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		dialog = new JDialog();
		dialog.setTitle("Reset Password");
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
		setPasswordLabels();
		setPasswordTextField();
		setApplyButton();
		setWarnMessage();
		ResetPasswordDialogAction.setApplyButtonAction(this);
		
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
	public void setPasswordLabels()
	{
		currentPassLabel = new JLabel("Current Password");
		currentPassLabel.setBounds(30, 20, 110, 30);
		dialogBackground.add(currentPassLabel);
		
		newPassLabel = new JLabel("New Password");
		newPassLabel.setBounds(30, 60, 110, 30);
		dialogBackground.add(newPassLabel);
		
		confirmPassLabel = new JLabel("Confirm Password");
		confirmPassLabel.setBounds(30, 100, 110, 30);
		dialogBackground.add(confirmPassLabel);
		
	}
	
	public void setPasswordTextField()
	{
		currentPassTextField = new JTextField();
		currentPassTextField.setBounds(150,20,200,30);
		currentPassTextField.setFont(new Font("Arial",Font.ITALIC,15));
		dialogBackground.add(currentPassTextField);
		
		newPassTextField = new JTextField();
		newPassTextField.setBounds(150,60,200,30);
		newPassTextField.setFont(new Font("Arial",Font.ITALIC,15));
		dialogBackground.add(newPassTextField);
		
		confirmPassTextField = new JTextField();
		confirmPassTextField.setBounds(150,100,200,30);
		confirmPassTextField.setFont(new Font("Arial",Font.ITALIC,15));
		dialogBackground.add(confirmPassTextField);
	}
	
	public void setApplyButton()
	{
		applyButton = new JButton("Apply");
		applyButton.setBounds(250,150,100,30);
		applyButton.setFont(new Font("Arial",Font.BOLD,15));
		applyButton.setFocusable(false);
		dialogBackground.add(applyButton);
	}
	public void setWarnMessage()
	{
		warnMessage = new JLabel();
		warnMessage.setBounds(150, 125, 300, 30);
		warnMessage.setForeground(Color.RED);
		warnMessage.setFont(new Font("Arial",Font.BOLD,10));
		dialogBackground.add(warnMessage);
	}
}
