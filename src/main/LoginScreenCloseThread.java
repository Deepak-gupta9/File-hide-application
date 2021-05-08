package main;

public class LoginScreenCloseThread  extends Thread
{
	public void run()
	{
		MainPage.mainGround.setVisible(false);
		for(int i=715;i>=1;i--)
		{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			LoginBackground.loginBackground.setLocation(i,0);
		}
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
		
	}
}
