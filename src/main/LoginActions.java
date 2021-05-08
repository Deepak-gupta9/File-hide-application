package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginActions {
	public static void setCancelButtonAction()
	{
		LoginBackground.cancelButton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						System.exit(0);
					}
				});
	}  //  Cancel Button Method End Here
	
	public static void setLoginButtonAction()
	{
		LoginBackground.loginButton.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						char [] passwordArray = LoginBackground.passwordTextField.getPassword();
						String password = String.valueOf(passwordArray);
						if(password.equals(FileOperations.getPasswordFromFileForLogin()))
						{
							scrollLoginScreen();
							LoginBackground.wrongPasswordMessage.setVisible(false);
						}
						else
						{
							LoginBackground.wrongPasswordMessage.setVisible(true);
						}
					}
			});
	}  // Login Button Method Here
	public static void scrollLoginScreen()
	{
		LoginScreenOpenThread loginscreenopenthread = new LoginScreenOpenThread();
		loginscreenopenthread.start();
	}
	
}  // Class End Here
