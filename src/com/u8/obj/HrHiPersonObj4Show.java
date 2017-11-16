package com.u8.obj;

import java.util.LinkedHashMap;

public class HrHiPersonObj4Show extends HrHiPersonObj
{
	@Override 
	public String findTableName() 
	{ 
		StringBuffer sql = new StringBuffer(); 
 
		sql.append("( \n"); 
		sql.append("select * from " + super.findTableName() + "\n"); 
		sql.append(") t \n"); 
 
		return sql.toString(); 
	} 
 
	@Override 
	public LinkedHashMap<String, String> findProperties() 
	{ 
		LinkedHashMap<String, String> pros = super.findProperties(); 
		 
		 //pros.put("enName", "cnName"); 
		 
		return pros; 
	} 

}