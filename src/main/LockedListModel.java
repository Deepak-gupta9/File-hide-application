package main;

import java.util.List;
import java.io.Serializable;

public class LockedListModel implements Serializable
{
	private static final long serialVersionUID = 2L;
	List <String> lockedList;
	public LockedListModel()
	{
		
	}
	
	public LockedListModel(List<String> lockedList)
	{
		this.lockedList = lockedList;
	}
	public List<String> getLockedList(){
		return lockedList;
		
			}
	public void setLockedList(List<String> lockedList){
		this.lockedList = lockedList;
	}
	

}
