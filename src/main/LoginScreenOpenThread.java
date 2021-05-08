package main;

public class LoginScreenOpenThread  extends Thread
{
	@Override
	public void run()
	{
		for(int i=1;i<=715;i++)
		{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			LoginBackground.loginBackground.setLocation(i,0);
		}
		MainPage.mainGround.setVisible(true);
	}
}
