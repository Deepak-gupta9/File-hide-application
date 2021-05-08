package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetPasswordDialogAction {
	
	public static void setApplyButtonAction(ResetPasswordDialog resetPasswordDialog)
	{
		resetPasswordDialog.applyButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String currentPassword = resetPasswordDialog.currentPassTextField.getText();
				String newPassword = resetPasswordDialog.newPassTextField.getText();
				String confirmPassword = resetPasswordDialog.confirmPassTextField.getText();
				
				if(currentPassword == null  || newPassword == null || confirmPassword == null ||
						currentPassword.trim().isEmpty() || newPassword.trim().isEmpty() || confirmPassword.trim().isEmpty())
				{
					resetPasswordDialog.warnMessage.setText("Please do not leave any text field empty");
				}
				else if(!newPassword.equals(confirmPassword))
				{
					resetPasswordDialog.warnMessage.setText("New and confirm password does not match");
				}
				else  if(currentPassword.equals(newPassword))
				{
					resetPasswordDialog.warnMessage.setText("Current and New password can not be same");
				}
				else if (!currentPassword.equals(FileOperations.getPasswordFromFileForLogin()))
				{
					resetPasswordDialog.warnMessage.setText("Current password is incorrect");
				}
				else
				{
					FileOperations.setPasswordInFile(newPassword);
					resetPasswordDialog.warnMessage.setText("");
					resetPasswordDialog.dialog.dispose();
				}
				
			}
		});
	}

}
