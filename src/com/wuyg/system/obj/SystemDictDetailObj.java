package com.wuyg.system.obj;

import java.sql.Timestamp;
import com.wuyg.common.dao.BaseDbObj;
import com.wuyg.common.dao.DefaultBaseDAO;
import com.wuyg.common.dao.IBaseDAO;
import com.wuyg.common.util.MySqlUtil;
import com.wuyg.common.util.SystemConstant;

import java.util.LinkedHashMap;
import java.util.Arrays;
import java.util.List;
import com.alibaba.fastjson.JSON;

public class SystemDictDetailObj extends BaseDbObj
{
	private Long id;
	private Long i_dict_id;
	private String c_code;
	private String c_name;
	private String in_use;

	@Override
	public String findKeyColumnName()
	{
		return "id";
	}

	@Override
	public String findParentKeyColumnName()
	{
		return "i_dict_id";
	}

	@Override
	public String findTableName()
	{
		return "system_dict_detail";
	}

	@Override
	public String findDefaultOrderBy()
	{
		return super.findDefaultOrderBy();
	}

	@Override
	public String getBasePath()
	{
		return "SystemDictDetail";
	}

	@Override
	public String getCnName()
	{
		return "字典明细";
	}

	@Override
	public List<String> findUniqueIndexProperties()
	{
		return Arrays.asList(new String[]
		{ "i_dict_id", "c_code" });
	}

	public LinkedHashMap<String, String> findProperties()
	{
		LinkedHashMap<String, String> pros = new LinkedHashMap<String, String>();

		pros.put("id", "id");
		pros.put("i_dict_id", "字典ID");
		pros.put("c_code", "编码");
		pros.put("c_name", "名称");
		pros.put("in_use", "启用");
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

	public Long getI_dict_id()
	{
		return i_dict_id;
	}

	public void setI_dict_id(Long i_dict_id)
	{
		this.i_dict_id = i_dict_id;
	}

	public String getC_code()
	{
		return c_code;
	}

	public void setC_code(String c_code)
	{
		this.c_code = c_code;
	}

	public String getC_name()
	{
		return c_name;
	}

	public void setC_name(String c_name)
	{
		this.c_name = c_name;
	}

	public String getIn_use()
	{
		return in_use;
	}

	public void setIn_use(String in_use)
	{
		this.in_use = in_use;
	}

	@Override
	public boolean allowDelete() throws Exception
	{
		boolean inUse = false;

		SystemDictObj parent = new SystemDictObj();
		Object o = parent.searchBykey(i_dict_id + "");
		if (o != null)
		{
			parent = (SystemDictObj) o;
		}
		
		if ("车辆型号".equals(parent.getC_dict_code()))
		{
			inUse = MySqlUtil.executeCountSql(SystemConstant.DEFAULT_DB, "select count(1) from bus_base_info where bus_std='"+this.c_code+"'")>0;
		}
		
		if ("车辆类型".equals(parent.getC_dict_code()))
		{
			inUse = MySqlUtil.executeCountSql(SystemConstant.DEFAULT_DB, "select count(1) from bus_base_info where bus_type='"+this.c_code+"'")>0;
		}
		
		if ("车牌颜色".equals(parent.getC_dict_code()))
		{
			inUse = MySqlUtil.executeCountSql(SystemConstant.DEFAULT_DB, "select count(1) from bus_base_info where bus_card_color='"+this.c_code+"'")>0;
		}
		
		if ("准驾车型".equals(parent.getC_dict_code()))
		{
			inUse = MySqlUtil.executeCountSql(SystemConstant.DEFAULT_DB, "select count(1) from driver_info where driver_drive_type='"+this.c_code+"'")>0;
		}

		return !inUse;
	}

	@Override
	public String toString()
	{
		return JSON.toJSONString(this);
	}
}
