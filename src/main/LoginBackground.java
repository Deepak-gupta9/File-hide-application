package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class LoginBackground {
	public static JLabel loginBackground;
	public static JLabel lockCloseImage;
	public static JLabel loginImage;
	public static JButton loginButton;
	public static JButton cancelButton;
	public static JPasswordField passwordTextField;
	public static JLabel enterPasswordMessage;
	public static JLabel wrongPasswordMessage;
	
	public static void setMainBackground()
	{
		loginBackground = new JLabel();
		loginBackground.setSize(712,390);
		loginBackground.setLocation(0, 0);
		loginBackground.setLayout(null);
		//loginBackground.setBackground(Color.YELLOW);
		//loginBackground.setOpaque(true);
		MainApplication.mainWindow.add(loginBackground);
		
		ImageIcon loginBackgroundIcon = new ImageIcon(MainApplication.class.getResource("/resources/login.png"));
		loginBackground.setIcon(loginBackgroundIcon);
		
		setLockCloseImage();
		setMainLoginScreen();
		setLoginButton();
		setCancelButton();
		setPasswordTextField();
		setEnterPasswordMessage();
		enterPasswordMessageShowAndHide();
		LoginActions.setCancelButtonAction();
		LoginActions.setLoginButtonAction();
		setWrongPasswordMessage();
		loginByEnterKey();
		}
	public static void setLockCloseImage()
	{
		lockCloseImage = new JLabel();
		//lockCloseImage.setSize(712,390);
		lockCloseImage.setLocation(230,20);
		lockCloseImage.setLayout(null);
		loginBackground.add(lockCloseImage);
		//lockCloseImage.setBackground(Color.YELLOW);
		//lockCloseImage.setOpaque(true);
		ImageIcon loginBackgroundIcon = new ImageIcon(MainApplication.class.getResource("/resources/lockclose.png"));
		lockCloseImage.setSize(loginBackgroundIcon.getIconWidth(),loginBackgroundIcon.getIconHeight());
		lockCloseImage.setIcon(loginBackgroundIcon);
		}
	
	public static void setMainLoginScreen()
	{
		loginImage = new JLabel();
		//loginImage.setSize(712,390);
		loginImage.setLocation(107,206);
		loginImage.setLayout(null);
		loginBackground.add(loginImage);
		//loginImage.setBackground(Color.YELLOW);
		//loginImage.setOpaque(true);
		ImageIcon loginBackgroundIcon = new ImageIcon(MainApplication.class.getResource("/resources/login2.png"));
		loginImage.setSize(loginBackgroundIcon.getIconWidth(),loginBackgroundIcon.getIconHeight());
		loginImage.setIcon(loginBackgroundIcon);
		}
	public static void setLoginButton()
	{
		loginButton = new JButton("Login");
		loginButton.setSize(80,20);
		loginButton.setLocation(260,97);
		loginImage.add(loginButton);
	}
	
	public static void setCancelButton()
	{
		cancelButton = new JButton("Cancel");
		cancelButton.setSize(80,20);
		cancelButton.setLocation(350,97);
		loginImage.add(cancelButton);
	}
	public static void setPasswordTextField()
	{
		passwordTextField = new JPasswordField();
		passwordTextField.setSize(373,28);
		passwordTextField.setLocation(50,61);
		passwordTextField.setBorder(null);
		passwordTextField.setBackground(new Color(204,204,204,255));
		passwordTextField.setLayout(null);
		passwordTextField.setFont(new Font("Arial",Font.PLAIN,25));
		loginImage.add(passwordTextField);
	}
	public static void setEnterPasswordMessage()
	{
		enterPasswordMessage = new JLabel("Enter password here......");
		enterPasswordMessage.setSize(160,25);
		passwordTextField.add(enterPasswordMessage);
	}
	public static void enterPasswordMessageShowAndHide()
	{
		passwordTextField.addKeyListener(new KeyListener()
				{

					@Override
					public void keyPressed(KeyEvent arg0) {
						showAndHide();
					}
					@Override
					public void keyReleased(KeyEvent arg0) {
						showAndHide();
					}
					@Override
					public void keyTyped(KeyEvent arg0) {
						showAndHide();	
					}
			});
	}
	public static void showAndHide()
	{
		char pass[] = passwordTextField.getPassword();
		if(pass.length == 0)
		{
			enterPasswordMessage.setVisible(true);
		}
		else
		{
			enterPasswordMessage.setVisible(false);
		}
	}
	public static void setWrongPasswordMessage()
	{
		wrongPasswordMessage = new JLabel("Wrong Password");
		wrongPasswordMessage.setSize(120,28);
		wrongPasswordMessage.setOpaque(false);
		wrongPasswordMessage.setFont(new Font("Arial",Font.PLAIN,13) );
		wrongPasswordMessage.setForeground(Color.PINK);
		wrongPasswordMessage.setLocation(53,93);
		wrongPasswordMessage.setVisible(false);
		loginImage.add(wrongPasswordMessage);
	}
	public static void loginByEnterKey(){
		 passwordTextField.addKeyListener(new KeyListener()
				 {

					@Override
					public void keyPressed(KeyEvent e) {
					}
					@Override
					public void keyReleased(KeyEvent e) {
						int code = e.getKeyCode();
						if(code == KeyEvent.VK_ENTER)
						{
							loginButton.doClick();
						}
						}
					@Override
					public void keyTyped(KeyEvent e) {
					}
					});
		 }
}
