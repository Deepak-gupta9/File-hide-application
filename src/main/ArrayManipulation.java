package main;

import java.util.ArrayList;
import java.util.List;

public class ArrayManipulation {
	public static List<String> listReverse(List<String> dataList)
	{
		List<String> temp = new ArrayList<>();
		for(int i=dataList.size()-1;i>=0;i--)
		{
			temp.add(dataList.get(i));
		}
		return temp;
	}

}
