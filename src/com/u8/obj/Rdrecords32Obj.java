package com.u8.obj;

public class Rdrecords32Obj extends Rdrecords11Obj
{
	@Override
	public String findTableName()
	{
		// 对外的对应rdrecord32，表体的cdefine26、cdefine27对应销售单价和销售金额
		StringBuffer sql = new StringBuffer();
		sql.append("( \n");
		sql.append(" select  \n");
		sql.append(" rd.ccode, \n");
		sql.append(" inv.cinvcode, \n");
		sql.append(" inv.cinvname, \n");
		sql.append(" inv.cinvstd, \n");
		sql.append(" cu.ccomunitname, \n");
		sql.append(" rs.iNum, \n");
		sql.append(" rs.iinvexchrate, \n");
		sql.append(" rs.iquantity, \n");
		sql.append(" cua.cComUnitName cSTComUnitName, \n");
		sql.append(" rs.cdefine26 iunitcost, \n");
		sql.append(" rs.cdefine27 iprice \n");
		sql.append(" from Rdrecords32 rs  \n");
		sql.append(" left join Rdrecord32 rd on rs.id=rd.id  \n");
		sql.append(" left join inventory inv on rs.cinvcode=inv.cinvcode  \n");
		sql.append(" left join ComputationUnit cu on inv.cComUnitCode=cu.cComunitCode \n");
		sql.append(" left join ComputationUnit cua on rs.cAssUnit=cua.cComunitCode \n");
		sql.append(") t ");
		return sql.toString();	}
}
