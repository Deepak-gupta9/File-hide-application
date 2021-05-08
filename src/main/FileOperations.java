package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileOperations {
	public static String hideFileCommand = "attrib +R +A +S +H +O +I +X +P +U ";
	public static String unHideCommand = "attrib -R -A -S -H -O -I -X -P -U ";
	
	public static String getPasswordFromFileForLogin()
	{
		ObjectOutputStream outStream = null;
		ObjectInputStream inStream = null;
		try
		{
			File passwordFile = new File("C:/ProtectedFolderApp/password.log");
			if(passwordFile.exists())
			{
				inStream = new ObjectInputStream(new FileInputStream(passwordFile));
				PasswordModel passwordModel = (PasswordModel)inStream.readObject();
				return passwordModel.getPassword();
			}
			else
			{
				passwordFile.createNewFile();
				PasswordModel passwordModel = new PasswordModel("abc");
				outStream = new ObjectOutputStream(new FileOutputStream(passwordFile));
				outStream.writeObject(passwordModel);
				return passwordModel.getPassword();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			if(outStream != null)
			{
				try {
					outStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(inStream != null)
			{
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public static Boolean isValidFile(String filePath)
	{
		if(filePath == null || filePath.isEmpty())
		{
			return false;
		}
		File file = new File(filePath);
		if(file.exists() && !file.isDirectory())
		{
			return true;
		}
		return false;
	}
	public static void checkApplicationDirectory()
	{
		try
		{
			File appDir = new File("C:/ProtectedFolderApp");
			if(!appDir.exists())
			{
				appDir.mkdir();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void savedLockedListData(List<String> lockedList) throws IOException
	{
		ObjectOutputStream outStream = null;
		try
		{
			File lockedFile = new File("C:/ProtectedFolderApp/lockedFiles.log");
			if(lockedFile.exists())
			{
				LockedListModel lockedListModel = new LockedListModel(lockedList);
				outStream = new ObjectOutputStream(new FileOutputStream(lockedFile));
				outStream.writeObject(lockedListModel);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			if(outStream != null)
			{
				try{
					outStream.close();
					}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
		}
	}
	public static LockedListModel getLockedListData()
	{
		ObjectOutputStream outStream = null;
		ObjectInputStream inStream = null;
		try
		{
			File lockedFile = new File("C:/ProtectedFolderApp/lockedFiles.log");
			if(!lockedFile.exists())
			{
				lockedFile.createNewFile();
				LockedListModel lockedListModel = new LockedListModel();
				outStream = new ObjectOutputStream(new FileOutputStream(lockedFile));
				outStream.writeObject(lockedListModel);
				return lockedListModel;
			}
			else
			{
				inStream = new ObjectInputStream(new FileInputStream(lockedFile));
				LockedListModel lockedListModel = (LockedListModel)inStream.readObject();
				return lockedListModel;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			if(outStream != null)
			{
				try{
					outStream.close();
					}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
		}
		if(inStream!=null)
		{
			try{
				inStream.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}

	public static RecentListModel getRecentListData()
	{
		ObjectOutputStream outStream = null;
		ObjectInputStream inStream = null;
		try
		{
			File recentFile = new File("C:/ProtectedFolderApp/recentFiles.log");
			if(!recentFile.exists())
			{
				recentFile.createNewFile();
				RecentListModel recentListModel = new RecentListModel();
				outStream = new ObjectOutputStream(new FileOutputStream(recentFile));
				outStream.writeObject(recentListModel);
				return recentListModel;
			}
			else
			{
				inStream = new ObjectInputStream(new FileInputStream(recentFile));
				RecentListModel recentListModel = (RecentListModel)inStream.readObject();
				return recentListModel;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			if(outStream != null)
			{
				try{
					outStream.close();
					}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
		}
		if(inStream!=null)
		{
			try{
				inStream.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static void savedRecentListData(List<String> lockedList) throws IOException
	{
		ObjectOutputStream outStream = null;
		try
		{
			File recentFile = new File("C:/ProtectedFolderApp/recentFiles.log");
			if(recentFile.exists())
			{
				RecentListModel recentListModel = new RecentListModel(lockedList);
				outStream = new ObjectOutputStream(new FileOutputStream(recentFile));
				outStream.writeObject(recentListModel);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			if(outStream != null)
			{
				try{
					outStream.close(); 
					}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
		}
	}
	
	
	public static void setPasswordInFile(String newPassword)
	{
		ObjectOutputStream outStream = null;
		try
		{
			File passwordFile = new File("C:/ProtectedFolderApp/password.log");
			if(passwordFile.exists())
			{
				PasswordModel passwordModel = new PasswordModel(newPassword);
				outStream = new ObjectOutputStream(new FileOutputStream(passwordFile));
				outStream.writeObject(passwordModel);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			if(outStream != null)
			{
				try {
					outStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Boolean hideFileFromSystem(String filePath)
	{
		String newFilePath = hideFileCommand + "\""+filePath+"\"";
		try {
			Runtime.getRuntime().exec(newFilePath);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static Boolean unHideFileFromSystem(String filePath)
	{
		String newFilePath = unHideCommand + "\""+filePath+"\"";
		try {
			Runtime.getRuntime().exec(newFilePath);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}