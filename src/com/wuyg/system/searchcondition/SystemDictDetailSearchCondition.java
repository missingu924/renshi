package com.wuyg.system.searchcondition;

import com.wuyg.common.obj.BaseSearchCondition;
import java.sql.Timestamp;

public class SystemDictDetailSearchCondition extends BaseSearchCondition
{
	private Long i_dict_id_min;
	private Long i_dict_id_max;

	public Long getI_dict_id_min()
	{
		return i_dict_id_min;
	}

	public void setI_dict_id_min(Long i_dict_id_min)
	{
		this.i_dict_id_min = i_dict_id_min;
	}

	public Long getI_dict_id_max()
	{
		return i_dict_id_max;
	}

	public void setI_dict_id_max(Long i_dict_id_max)
	{
		this.i_dict_id_max = i_dict_id_max;
	}

}