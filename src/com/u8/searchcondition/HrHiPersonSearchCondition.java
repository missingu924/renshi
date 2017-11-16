package com.u8.searchcondition;

import com.wuyg.common.obj.BaseSearchCondition;
import java.sql.Timestamp;

public class HrHiPersonSearchCondition extends BaseSearchCondition
{
private Long irecordid_min;
private Long irecordid_max;
private Long nstatus2_min;
private Long nstatus2_max;
private Double sysage_min;
private Double sysage_max;
private Double syscompage_min;
private Double syscompage_max;
private Double sysworkage_min;
private Double sysworkage_max;
private Long cpsndate_min;
private Long cpsndate_max;
private Long cpsnyear_min;
private Long cpsnyear_max;
public Long getIrecordid_min()
{
	return irecordid_min;
}
public void setIrecordid_min(Long irecordid_min)
{
	this.irecordid_min = irecordid_min;
}
public Long getIrecordid_max()
{
	return irecordid_max;
}
public void setIrecordid_max(Long irecordid_max)
{
	this.irecordid_max = irecordid_max;
}
public Long getNstatus2_min()
{
	return nstatus2_min;
}
public void setNstatus2_min(Long nstatus2_min)
{
	this.nstatus2_min = nstatus2_min;
}
public Long getNstatus2_max()
{
	return nstatus2_max;
}
public void setNstatus2_max(Long nstatus2_max)
{
	this.nstatus2_max = nstatus2_max;
}
public Double getSysage_min()
{
	return sysage_min;
}
public void setSysage_min(Double sysage_min)
{
	this.sysage_min = sysage_min;
}
public Double getSysage_max()
{
	return sysage_max;
}
public void setSysage_max(Double sysage_max)
{
	this.sysage_max = sysage_max;
}
public Double getSyscompage_min()
{
	return syscompage_min;
}
public void setSyscompage_min(Double syscompage_min)
{
	this.syscompage_min = syscompage_min;
}
public Double getSyscompage_max()
{
	return syscompage_max;
}
public void setSyscompage_max(Double syscompage_max)
{
	this.syscompage_max = syscompage_max;
}
public Double getSysworkage_min()
{
	return sysworkage_min;
}
public void setSysworkage_min(Double sysworkage_min)
{
	this.sysworkage_min = sysworkage_min;
}
public Double getSysworkage_max()
{
	return sysworkage_max;
}
public void setSysworkage_max(Double sysworkage_max)
{
	this.sysworkage_max = sysworkage_max;
}
public Long getCpsndate_min()
{
	return cpsndate_min;
}
public void setCpsndate_min(Long cpsndate_min)
{
	this.cpsndate_min = cpsndate_min;
}
public Long getCpsndate_max()
{
	return cpsndate_max;
}
public void setCpsndate_max(Long cpsndate_max)
{
	this.cpsndate_max = cpsndate_max;
}
public Long getCpsnyear_min()
{
	return cpsnyear_min;
}
public void setCpsnyear_min(Long cpsnyear_min)
{
	this.cpsnyear_min = cpsnyear_min;
}
public Long getCpsnyear_max()
{
	return cpsnyear_max;
}
public void setCpsnyear_max(Long cpsnyear_max)
{
	this.cpsnyear_max = cpsnyear_max;
}

}