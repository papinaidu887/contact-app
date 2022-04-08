package com.ashokit;

public class StringTest {
	
	public static void main(String[] args) {
		
		 String str1 = "BC";
		 
		 String str2 = "BANGALORE";
		 
		 System.out.println(printStrOutput1_Output2(str1,str2));
		 
	}
	
	private static String printStrOutput1_Output2(String str1, String str2) {
		
		String tempStr1 = str1;
		
		for(int i=0;i<str1.length();i++)
		{
			for(int j=0;j<str2.length();j++)
			{
				if(str1.charAt(i)==str2.charAt(j))
				{
					str1 = str1.replace(str1.charAt(i), '\u0000');
				}
			}
		}
		
		for(int i=0;i<str2.length();i++)
		{
			for(int j=0;j<str1.length();j++)
			{
				if(str2.charAt(i)==tempStr1.charAt(j))
				{
					str2 = str2.replace(str2.charAt(i), '\u0000');
				}
			}
		}
		
		return " Output1: " +str1+ " Output2: "+str2;
		
	}


	
}
