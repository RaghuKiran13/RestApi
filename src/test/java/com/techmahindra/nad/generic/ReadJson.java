package com.techmahindra.nad.generic;



import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReadJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}
	
	public static String readJsons(String value)
	{
		String jsonValue = null;
		JSONParser parser = new JSONParser();
		 Object obj = null;
		try {
			obj = parser.parse(new FileReader("F:\\POC\\POC\\test.json"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 JSONObject jsonObject = (JSONObject) obj;
	        try {
	        	 String name = (String) jsonObject.get(value);
	            // System.out.println(name);
	        	 jsonValue = name;
	        
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	        
	        return jsonValue;
	}
	public static String getValues(ArrayList<String> values)
	{
		String value = null;
		
		for(int i=0;i<values.size();i++)
		{
			//System.out.println(values.get(i));
			
			value = readJsons(values.get(i).toString());
			
		}
		
		return value;
	}

	
	public static String readJsons_new(String value)
	{
		String jsonValue = null;
		JSONParser parser = new JSONParser();
		 Object obj = null;
		try {
			obj = parser.parse(new FileReader("F:\\POC\\POC\\test.json"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 JSONObject jsonObject = (JSONObject) obj;
	        try {
	        	 String name = (String) jsonObject.get(value);
	            // System.out.println(name);
	        	 jsonValue = name;
	        
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	        
	        return jsonValue;
	}
}
