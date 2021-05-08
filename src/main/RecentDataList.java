 package main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecentDataList {

	private static List<String> recentFiles = new ArrayList<>();
	
	public static List<String> getRecentFiles(){
		return ArrayManipulation.listReverse(recentFiles);
		}
	public static void populateRecentFileData()
	{
		RecentListModel recentListModel = FileOperations.getRecentListData();
		if(recentListModel == null || recentListModel.getRecentList()==null || recentListModel.getRecentList().size()==0){
			return;
		}
		recentFiles.addAll(recentListModel.getRecentList());
	}
	public static void appendRecentFiles(List<String> files)
	{
		if(files.size() == 0)
		{
			return;
		}
		recentFiles.removeAll(files);
		recentFiles.addAll(files);
		if(recentFiles.size()>4)
		{
			List<String> temp = recentFiles.subList(0, recentFiles.size()-4);
			recentFiles.removeAll(temp);
		}
		try {
			FileOperations.savedRecentListData(recentFiles);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
}
