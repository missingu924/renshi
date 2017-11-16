package com.wuyg.system.obj;

import java.sql.Timestamp;
import com.wuyg.common.dao.BaseDbObj;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.util.List;
import com.alibaba.fastjson.JSON;

public class SystemDictObj extends BaseDbObj
{
	private Long id;
	private String c_dict_code;
	private String c_dict_name;

	@Override
	public String findKeyColumnName()
	{
		return "id";
	}

	@Override
	public String findParentKeyColumnName()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findTableName()
	{
		return "system_dict";
	}

	@Override
	public String findDefaultOrderBy()
	{
		return "id";
	}

	@Override
	public String getBasePath()
	{
		return "SystemDict";
	}

	@Override
	public String getCnName()
	{
		return "字典";
	}

	@Override
	public List<String> findUniqueIndexProperties()
	{
		return Arrays.asList(new String[]
		{ "c_dict_code" });
	}

	@Override
	public Class findChildClz()
	{
		return SystemDictDetailObj.class;
	}

	public LinkedHashMap<String, String> findProperties()
	{
		LinkedHashMap<String, String> pros = new LinkedHashMap<String, String>();

		pros.put("id", "id");
		pros.put("c_dict_code", "字典编码");
		pros.put("c_dict_name", "字典名称");
		return pros;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getC_dict_code()
	{
		return c_dict_code;
	}

	public void setC_dict_code(String c_dict_code)
	{
		this.c_dict_code = c_dict_code;
	}

	public String getC_dict_name()
	{
		return c_dict_name;
	}

	public void setC_dict_name(String c_dict_name)
	{
		this.c_dict_name = c_dict_name;
	}

	@Override
	public String toString()
	{
		return JSON.toJSONString(this);
	}
}
