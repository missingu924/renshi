package com.u8.obj;

import java.sql.Timestamp;
import com.wuyg.common.dao.BaseDbObj;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.util.List;
import com.alibaba.fastjson.JSON;

public class Rdrecord11Obj extends BaseDbObj
{
	private Long id;
	private String brdflag;
	private String cvouchtype;
	private String cbustype;
	private String csource;
	private String cbuscode;
	private String cwhcode;
	private Timestamp ddate;
	private String ccode;
	private String crdcode;
	private String cdepcode;
	private String cpersoncode;
	private String cptcode;
	private String cstcode;
	private String ccuscode;
	private String cvencode;
	private String cordercode;
	private String carvcode;
	private Long cbillcode;
	private Long cdlcode;
	private String cprobatch;
	private String chandler;
	private String cmemo;
	private Boolean btransflag;
	private String caccounter;
	private String cmaker;
	private String cdefine1;
	private String cdefine2;
	private String cdefine3;
	private Timestamp cdefine4;
	private Long cdefine5;
	private Timestamp cdefine6;
	private Double cdefine7;
	private String cdefine8;
	private String cdefine9;
	private String cdefine10;
	private String dkeepdate;
	private Timestamp dveridate;
	private Boolean bpufirst;
	private Boolean biafirst;
	private Double imquantity;
	private Timestamp darvdate;
	private String cchkcode;
	private Timestamp dchkdate;
	private String cchkperson;
	private Long vt_id;
	private Boolean bisstqc;
	private String cdefine11;
	private String cdefine12;
	private String cdefine13;
	private String cdefine14;
	private Long cdefine15;
	private Double cdefine16;
	private String cpspcode;
	private String cmpocode;
	private String gspcheck;
	private Long ipurorderid;
	private Long iproorderid;
	private String ufts;
	private Double iexchrate;
	private String cexch_name;
	private Boolean bomfirst;
	private Boolean bfrompreyear;
	private Boolean bislsquery;
	private Long biscomplement;
	private String idiscounttaxtype;
	private Long ireturncount;
	private Long iverifystate;
	private Long iswfcontrolled;
	private String cmodifyperson;
	private Timestamp dmodifydate;
	private Timestamp dnmaketime;
	private Timestamp dnmodifytime;
	private Timestamp dnverifytime;
	private Long bredvouch;
	private String bmotran;
	private Long iflowid;
	private String cpzid;
	private String csourcels;
	private String csourcecodels;
	private Boolean bhyvouch;
	private Long iprintcount;
	private String csysbarcode;
	private String ccurrentauditor;

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
		return "rdrecord11";
	}

	@Override
	public String findDefaultOrderBy()
	{
		return super.findDefaultOrderBy();
	}

	@Override
	public String getBasePath()
	{
		return "Rdrecord11";
	}

	@Override
	public String getCnName()
	{
		return "材料出库单";
	}

	@Override
	public Class findChildClz()
	{
		return Rdrecords11Obj.class;
	}

	@Override
	public List<String> findUniqueIndexProperties()
	{
		return Arrays.asList(new String[]
		{});
	}

	public LinkedHashMap<String, String> findProperties()
	{
		LinkedHashMap<String, String> pros = new LinkedHashMap<String, String>();

		pros.put("id", "id");
		pros.put("brdflag", "brdflag");
		pros.put("cvouchtype", "cvouchtype");
		pros.put("cbustype", "cbustype");
		pros.put("csource", "csource");
		pros.put("cbuscode", "cbuscode");
		pros.put("cwhcode", "cwhcode");
		pros.put("ddate", "ddate");
		pros.put("ccode", "ccode");
		pros.put("crdcode", "crdcode");
		pros.put("cdepcode", "cdepcode");
		pros.put("cpersoncode", "cpersoncode");
		pros.put("cptcode", "cptcode");
		pros.put("cstcode", "cstcode");
		pros.put("ccuscode", "ccuscode");
		pros.put("cvencode", "cvencode");
		pros.put("cordercode", "cordercode");
		pros.put("carvcode", "carvcode");
		pros.put("cbillcode", "cbillcode");
		pros.put("cdlcode", "cdlcode");
		pros.put("cprobatch", "cprobatch");
		pros.put("chandler", "chandler");
		pros.put("cmemo", "cmemo");
		pros.put("btransflag", "btransflag");
		pros.put("caccounter", "caccounter");
		pros.put("cmaker", "cmaker");
		pros.put("cdefine1", "cdefine1");
		pros.put("cdefine2", "cdefine2");
		pros.put("cdefine3", "cdefine3");
		pros.put("cdefine4", "cdefine4");
		pros.put("cdefine5", "cdefine5");
		pros.put("cdefine6", "cdefine6");
		pros.put("cdefine7", "cdefine7");
		pros.put("cdefine8", "cdefine8");
		pros.put("cdefine9", "cdefine9");
		pros.put("cdefine10", "cdefine10");
		pros.put("dkeepdate", "dkeepdate");
		pros.put("dveridate", "dveridate");
		pros.put("bpufirst", "bpufirst");
		pros.put("biafirst", "biafirst");
		pros.put("imquantity", "imquantity");
		pros.put("darvdate", "darvdate");
		pros.put("cchkcode", "cchkcode");
		pros.put("dchkdate", "dchkdate");
		pros.put("cchkperson", "cchkperson");
		pros.put("vt_id", "vt_id");
		pros.put("bisstqc", "bisstqc");
		pros.put("cdefine11", "cdefine11");
		pros.put("cdefine12", "cdefine12");
		pros.put("cdefine13", "cdefine13");
		pros.put("cdefine14", "cdefine14");
		pros.put("cdefine15", "cdefine15");
		pros.put("cdefine16", "cdefine16");
		pros.put("cpspcode", "cpspcode");
		pros.put("cmpocode", "cmpocode");
		pros.put("gspcheck", "gspcheck");
		pros.put("ipurorderid", "ipurorderid");
		pros.put("iproorderid", "iproorderid");
		pros.put("ufts", "ufts");
		pros.put("iexchrate", "iexchrate");
		pros.put("cexch_name", "cexch_name");
		pros.put("bomfirst", "bomfirst");
		pros.put("bfrompreyear", "bfrompreyear");
		pros.put("bislsquery", "bislsquery");
		pros.put("biscomplement", "biscomplement");
		pros.put("idiscounttaxtype", "idiscounttaxtype");
		pros.put("ireturncount", "ireturncount");
		pros.put("iverifystate", "iverifystate");
		pros.put("iswfcontrolled", "iswfcontrolled");
		pros.put("cmodifyperson", "cmodifyperson");
		pros.put("dmodifydate", "dmodifydate");
		pros.put("dnmaketime", "dnmaketime");
		pros.put("dnmodifytime", "dnmodifytime");
		pros.put("dnverifytime", "dnverifytime");
		pros.put("bredvouch", "bredvouch");
		pros.put("bmotran", "bmotran");
		pros.put("iflowid", "iflowid");
		pros.put("cpzid", "cpzid");
		pros.put("csourcels", "csourcels");
		pros.put("csourcecodels", "csourcecodels");
		pros.put("bhyvouch", "bhyvouch");
		pros.put("iprintcount", "iprintcount");
		pros.put("csysbarcode", "csysbarcode");
		pros.put("ccurrentauditor", "ccurrentauditor");
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

	public String getBrdflag()
	{
		return brdflag;
	}

	public void setBrdflag(String brdflag)
	{
		this.brdflag = brdflag;
	}

	public String getCvouchtype()
	{
		return cvouchtype;
	}

	public void setCvouchtype(String cvouchtype)
	{
		this.cvouchtype = cvouchtype;
	}

	public String getCbustype()
	{
		return cbustype;
	}

	public void setCbustype(String cbustype)
	{
		this.cbustype = cbustype;
	}

	public String getCsource()
	{
		return csource;
	}

	public void setCsource(String csource)
	{
		this.csource = csource;
	}

	public String getCbuscode()
	{
		return cbuscode;
	}

	public void setCbuscode(String cbuscode)
	{
		this.cbuscode = cbuscode;
	}

	public String getCwhcode()
	{
		return cwhcode;
	}

	public void setCwhcode(String cwhcode)
	{
		this.cwhcode = cwhcode;
	}

	public Timestamp getDdate()
	{
		return ddate;
	}

	public void setDdate(Timestamp ddate)
	{
		this.ddate = ddate;
	}

	public String getCcode()
	{
		return ccode;
	}

	public void setCcode(String ccode)
	{
		this.ccode = ccode;
	}

	public String getCrdcode()
	{
		return crdcode;
	}

	public void setCrdcode(String crdcode)
	{
		this.crdcode = crdcode;
	}

	public String getCdepcode()
	{
		return cdepcode;
	}

	public void setCdepcode(String cdepcode)
	{
		this.cdepcode = cdepcode;
	}

	public String getCpersoncode()
	{
		return cpersoncode;
	}

	public void setCpersoncode(String cpersoncode)
	{
		this.cpersoncode = cpersoncode;
	}

	public String getCptcode()
	{
		return cptcode;
	}

	public void setCptcode(String cptcode)
	{
		this.cptcode = cptcode;
	}

	public String getCstcode()
	{
		return cstcode;
	}

	public void setCstcode(String cstcode)
	{
		this.cstcode = cstcode;
	}

	public String getCcuscode()
	{
		return ccuscode;
	}

	public void setCcuscode(String ccuscode)
	{
		this.ccuscode = ccuscode;
	}

	public String getCvencode()
	{
		return cvencode;
	}

	public void setCvencode(String cvencode)
	{
		this.cvencode = cvencode;
	}

	public String getCordercode()
	{
		return cordercode;
	}

	public void setCordercode(String cordercode)
	{
		this.cordercode = cordercode;
	}

	public String getCarvcode()
	{
		return carvcode;
	}

	public void setCarvcode(String carvcode)
	{
		this.carvcode = carvcode;
	}

	public Long getCbillcode()
	{
		return cbillcode;
	}

	public void setCbillcode(Long cbillcode)
	{
		this.cbillcode = cbillcode;
	}

	public Long getCdlcode()
	{
		return cdlcode;
	}

	public void setCdlcode(Long cdlcode)
	{
		this.cdlcode = cdlcode;
	}

	public String getCprobatch()
	{
		return cprobatch;
	}

	public void setCprobatch(String cprobatch)
	{
		this.cprobatch = cprobatch;
	}

	public String getChandler()
	{
		return chandler;
	}

	public void setChandler(String chandler)
	{
		this.chandler = chandler;
	}

	public String getCmemo()
	{
		return cmemo;
	}

	public void setCmemo(String cmemo)
	{
		this.cmemo = cmemo;
	}

	public Boolean getBtransflag()
	{
		return btransflag;
	}

	public void setBtransflag(Boolean btransflag)
	{
		this.btransflag = btransflag;
	}

	public String getCaccounter()
	{
		return caccounter;
	}

	public void setCaccounter(String caccounter)
	{
		this.caccounter = caccounter;
	}

	public String getCmaker()
	{
		return cmaker;
	}

	public void setCmaker(String cmaker)
	{
		this.cmaker = cmaker;
	}

	public String getCdefine1()
	{
		return cdefine1;
	}

	public void setCdefine1(String cdefine1)
	{
		this.cdefine1 = cdefine1;
	}

	public String getCdefine2()
	{
		return cdefine2;
	}

	public void setCdefine2(String cdefine2)
	{
		this.cdefine2 = cdefine2;
	}

	public String getCdefine3()
	{
		return cdefine3;
	}

	public void setCdefine3(String cdefine3)
	{
		this.cdefine3 = cdefine3;
	}

	public Timestamp getCdefine4()
	{
		return cdefine4;
	}

	public void setCdefine4(Timestamp cdefine4)
	{
		this.cdefine4 = cdefine4;
	}

	public Long getCdefine5()
	{
		return cdefine5;
	}

	public void setCdefine5(Long cdefine5)
	{
		this.cdefine5 = cdefine5;
	}

	public Timestamp getCdefine6()
	{
		return cdefine6;
	}

	public void setCdefine6(Timestamp cdefine6)
	{
		this.cdefine6 = cdefine6;
	}

	public Double getCdefine7()
	{
		return cdefine7;
	}

	public void setCdefine7(Double cdefine7)
	{
		this.cdefine7 = cdefine7;
	}

	public String getCdefine8()
	{
		return cdefine8;
	}

	public void setCdefine8(String cdefine8)
	{
		this.cdefine8 = cdefine8;
	}

	public String getCdefine9()
	{
		return cdefine9;
	}

	public void setCdefine9(String cdefine9)
	{
		this.cdefine9 = cdefine9;
	}

	public String getCdefine10()
	{
		return cdefine10;
	}

	public void setCdefine10(String cdefine10)
	{
		this.cdefine10 = cdefine10;
	}

	public String getDkeepdate()
	{
		return dkeepdate;
	}

	public void setDkeepdate(String dkeepdate)
	{
		this.dkeepdate = dkeepdate;
	}

	public Timestamp getDveridate()
	{
		return dveridate;
	}

	public void setDveridate(Timestamp dveridate)
	{
		this.dveridate = dveridate;
	}

	public Boolean getBpufirst()
	{
		return bpufirst;
	}

	public void setBpufirst(Boolean bpufirst)
	{
		this.bpufirst = bpufirst;
	}

	public Boolean getBiafirst()
	{
		return biafirst;
	}

	public void setBiafirst(Boolean biafirst)
	{
		this.biafirst = biafirst;
	}

	public Double getImquantity()
	{
		return imquantity;
	}

	public void setImquantity(Double imquantity)
	{
		this.imquantity = imquantity;
	}

	public Timestamp getDarvdate()
	{
		return darvdate;
	}

	public void setDarvdate(Timestamp darvdate)
	{
		this.darvdate = darvdate;
	}

	public String getCchkcode()
	{
		return cchkcode;
	}

	public void setCchkcode(String cchkcode)
	{
		this.cchkcode = cchkcode;
	}

	public Timestamp getDchkdate()
	{
		return dchkdate;
	}

	public void setDchkdate(Timestamp dchkdate)
	{
		this.dchkdate = dchkdate;
	}

	public String getCchkperson()
	{
		return cchkperson;
	}

	public void setCchkperson(String cchkperson)
	{
		this.cchkperson = cchkperson;
	}

	public Long getVt_id()
	{
		return vt_id;
	}

	public void setVt_id(Long vt_id)
	{
		this.vt_id = vt_id;
	}

	public Boolean getBisstqc()
	{
		return bisstqc;
	}

	public void setBisstqc(Boolean bisstqc)
	{
		this.bisstqc = bisstqc;
	}

	public String getCdefine11()
	{
		return cdefine11;
	}

	public void setCdefine11(String cdefine11)
	{
		this.cdefine11 = cdefine11;
	}

	public String getCdefine12()
	{
		return cdefine12;
	}

	public void setCdefine12(String cdefine12)
	{
		this.cdefine12 = cdefine12;
	}

	public String getCdefine13()
	{
		return cdefine13;
	}

	public void setCdefine13(String cdefine13)
	{
		this.cdefine13 = cdefine13;
	}

	public String getCdefine14()
	{
		return cdefine14;
	}

	public void setCdefine14(String cdefine14)
	{
		this.cdefine14 = cdefine14;
	}

	public Long getCdefine15()
	{
		return cdefine15;
	}

	public void setCdefine15(Long cdefine15)
	{
		this.cdefine15 = cdefine15;
	}

	public Double getCdefine16()
	{
		return cdefine16;
	}

	public void setCdefine16(Double cdefine16)
	{
		this.cdefine16 = cdefine16;
	}

	public String getCpspcode()
	{
		return cpspcode;
	}

	public void setCpspcode(String cpspcode)
	{
		this.cpspcode = cpspcode;
	}

	public String getCmpocode()
	{
		return cmpocode;
	}

	public void setCmpocode(String cmpocode)
	{
		this.cmpocode = cmpocode;
	}

	public String getGspcheck()
	{
		return gspcheck;
	}

	public void setGspcheck(String gspcheck)
	{
		this.gspcheck = gspcheck;
	}

	public Long getIpurorderid()
	{
		return ipurorderid;
	}

	public void setIpurorderid(Long ipurorderid)
	{
		this.ipurorderid = ipurorderid;
	}

	public Long getIproorderid()
	{
		return iproorderid;
	}

	public void setIproorderid(Long iproorderid)
	{
		this.iproorderid = iproorderid;
	}

	public String getUfts()
	{
		return ufts;
	}

	public void setUfts(String ufts)
	{
		this.ufts = ufts;
	}

	public Double getIexchrate()
	{
		return iexchrate;
	}

	public void setIexchrate(Double iexchrate)
	{
		this.iexchrate = iexchrate;
	}

	public String getCexch_name()
	{
		return cexch_name;
	}

	public void setCexch_name(String cexch_name)
	{
		this.cexch_name = cexch_name;
	}

	public Boolean getBomfirst()
	{
		return bomfirst;
	}

	public void setBomfirst(Boolean bomfirst)
	{
		this.bomfirst = bomfirst;
	}

	public Boolean getBfrompreyear()
	{
		return bfrompreyear;
	}

	public void setBfrompreyear(Boolean bfrompreyear)
	{
		this.bfrompreyear = bfrompreyear;
	}

	public Boolean getBislsquery()
	{
		return bislsquery;
	}

	public void setBislsquery(Boolean bislsquery)
	{
		this.bislsquery = bislsquery;
	}

	public Long getBiscomplement()
	{
		return biscomplement;
	}

	public void setBiscomplement(Long biscomplement)
	{
		this.biscomplement = biscomplement;
	}

	public String getIdiscounttaxtype()
	{
		return idiscounttaxtype;
	}

	public void setIdiscounttaxtype(String idiscounttaxtype)
	{
		this.idiscounttaxtype = idiscounttaxtype;
	}

	public Long getIreturncount()
	{
		return ireturncount;
	}

	public void setIreturncount(Long ireturncount)
	{
		this.ireturncount = ireturncount;
	}

	public Long getIverifystate()
	{
		return iverifystate;
	}

	public void setIverifystate(Long iverifystate)
	{
		this.iverifystate = iverifystate;
	}

	public Long getIswfcontrolled()
	{
		return iswfcontrolled;
	}

	public void setIswfcontrolled(Long iswfcontrolled)
	{
		this.iswfcontrolled = iswfcontrolled;
	}

	public String getCmodifyperson()
	{
		return cmodifyperson;
	}

	public void setCmodifyperson(String cmodifyperson)
	{
		this.cmodifyperson = cmodifyperson;
	}

	public Timestamp getDmodifydate()
	{
		return dmodifydate;
	}

	public void setDmodifydate(Timestamp dmodifydate)
	{
		this.dmodifydate = dmodifydate;
	}

	public Timestamp getDnmaketime()
	{
		return dnmaketime;
	}

	public void setDnmaketime(Timestamp dnmaketime)
	{
		this.dnmaketime = dnmaketime;
	}

	public Timestamp getDnmodifytime()
	{
		return dnmodifytime;
	}

	public void setDnmodifytime(Timestamp dnmodifytime)
	{
		this.dnmodifytime = dnmodifytime;
	}

	public Timestamp getDnverifytime()
	{
		return dnverifytime;
	}

	public void setDnverifytime(Timestamp dnverifytime)
	{
		this.dnverifytime = dnverifytime;
	}

	public Long getBredvouch()
	{
		return bredvouch;
	}

	public void setBredvouch(Long bredvouch)
	{
		this.bredvouch = bredvouch;
	}

	public String getBmotran()
	{
		return bmotran;
	}

	public void setBmotran(String bmotran)
	{
		this.bmotran = bmotran;
	}

	public Long getIflowid()
	{
		return iflowid;
	}

	public void setIflowid(Long iflowid)
	{
		this.iflowid = iflowid;
	}

	public String getCpzid()
	{
		return cpzid;
	}

	public void setCpzid(String cpzid)
	{
		this.cpzid = cpzid;
	}

	public String getCsourcels()
	{
		return csourcels;
	}

	public void setCsourcels(String csourcels)
	{
		this.csourcels = csourcels;
	}

	public String getCsourcecodels()
	{
		return csourcecodels;
	}

	public void setCsourcecodels(String csourcecodels)
	{
		this.csourcecodels = csourcecodels;
	}

	public Boolean getBhyvouch()
	{
		return bhyvouch;
	}

	public void setBhyvouch(Boolean bhyvouch)
	{
		this.bhyvouch = bhyvouch;
	}

	public Long getIprintcount()
	{
		return iprintcount;
	}

	public void setIprintcount(Long iprintcount)
	{
		this.iprintcount = iprintcount;
	}

	public String getCsysbarcode()
	{
		return csysbarcode;
	}

	public void setCsysbarcode(String csysbarcode)
	{
		this.csysbarcode = csysbarcode;
	}

	public String getCcurrentauditor()
	{
		return ccurrentauditor;
	}

	public void setCcurrentauditor(String ccurrentauditor)
	{
		this.ccurrentauditor = ccurrentauditor;
	}

	@Override
	public String toString()
	{
		return JSON.toJSONString(this);
	}
}
