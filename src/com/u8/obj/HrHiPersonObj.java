package com.u8.obj;

import java.sql.Timestamp;
import com.wuyg.common.dao.BaseDbObj;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.util.List;
import com.alibaba.fastjson.JSON;

public class HrHiPersonObj extends BaseDbObj
{
	private String cpsn_num;
	private String cpsn_name;
	private String cdept_num;
	private Long irecordid;
	private String rpersontype;
	private String rsex;
	private String dbirthdate;
	private String rnativeplace;
	private String rnational;
	private String rhealthstatus;
	private String rmarristatus;
	private String vidno;
	private String mpicture;
	private String rperresidence;
	private String valianame;
	private String djoinworkdate;
	private String denterdate;
	private String dregulardate;
	private String vssno;
	private String rworkattend;
	private String vcardno;
	private String rtbmrule;
	private String rcheckinflag;
	private String dlastdate;
	private String hrts;
	private String vstatus1;
	private Long nstatus2;
	private Boolean bpsnperson;
	private String cpsnmobilephone;
	private String cpsnfphone;
	private String cpsnophone;
	private String cpsninphone;
	private String cpsnemail;
	private String cpsnpostaddr;
	private String cpsnpostcode;
	private String cpsnfaddr;
	private String cpsnqqcode;
	private String cpsnurl;
	private String cpsnoseat;
	private String denterunitdate;
	private String cpsnproperty;
	private String cpsnbankcode;
	private String cpsnaccount;
	private String pk_hr_hi_person;
	private Boolean bprobation;
	private String cdutyclass;
	private Boolean btaketm;
	private String mpictureqpb;
	private String ridtype;
	private String rcountry;
	private String dleavedate;
	private String rfigure;
	private String rworkstatus;
	private String employmentform;
	private String rpersonparameters;
	private Boolean bdutylock;
	private Boolean bpsnshop;
	private String cardstate;
	private String firsthtbegindate;
	private String lasthtenddate;
	private String cpsn_nameen;
	private Double sysage;
	private Double syscompage;
	private Double sysworkage;
	private String cregion;
	private String natruetype;
	private String jobnumber;
	private String persondepart;
	private String cardeffectivebegintime;
	private String cardeffectiveendtime;
	private Boolean keyperson;
	private String cleavereson;
	private String shenfen;
	private String weishengjishu;
	private String gonglingqisuan;
	private String cpsnppt;
	private String cpsnjoblevel;
	private String cpsncom;
	private String cpsntopred;
	private String cpsncollege;
	private String cpsntopdegree;
	private String cpsncoll2;
	private String cpsnincumred;
	private String cpsnincumcoll;
	private String cpsnjoblvldate;
	private String cpsntopredft;
	private String cpsntopdegreeft;
	private String cpsncoll4;
	private String cpsncoll3;
	private String cpsndegreeft;
	private String cpsnredft;
	private String cpsnincred;
	private String cpsnincdegree;
	private String cpsntopredcode;
	private String cpsntopdegcode;
	private String cpsndut;
	private String cpsndutdate;
	private String cpsnjoblvldate2;
	private String cpsnparty;
	private String cpsnrdate;
	private String cpsnpartysec;
	private String cpsnpartythd;
	private String cpsndutname;
	private String cpsndegreedate;
	private String cpsndutdate2;
	private Long cpsndate;
	private Long cpsnyear;
	private String cpsnlvl;
	private String cpsntopredd;
	private String cpsnzyzt;
	private String cpsnzbzsbm;
	private String cpsnzyzbbm;
	private String cpsnysjb;
	private String cpsnzylb;
	private String cpsnzykm;
	private String cpsnpzdate;

	@Override
	public String findKeyColumnName()
	{
		return "cpsn_num";
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
		 // 只查 在职人员
		return "(select * from hr_hi_person where rpersontype like '10%') t";
	}

	@Override
	public String findDefaultOrderBy()
	{
//		return super.findDefaultOrderBy();
		return "cdept_num,cpsndutname desc,cpsnysjb desc,cpsn_name";
	}

	@Override
	public String getBasePath()
	{
		return "HrHiPerson";
	}

	@Override
	public String getCnName()
	{
		return "人事信息";
	}

	@Override
	public List<String> findUniqueIndexProperties()
	{
		return Arrays.asList(new String[]
		{});
	}

	@Override
	public List<String> findNotNullProperties()
	{
		return Arrays.asList(new String[]
		{});
	}

	@Override
	public boolean allowDelete() throws Exception
	{
		boolean allowDelete = false;
		return allowDelete;
	}

	public LinkedHashMap<String, String> findProperties()
	{
		LinkedHashMap<String, String> pros = new LinkedHashMap<String, String>();

//		pros.put("cpsn_num", "cpsn_num");
//		pros.put("cpsn_name", "cpsn_name");
//		pros.put("cdept_num", "cdept_num");
//		pros.put("irecordid", "irecordid");
//		pros.put("rpersontype", "rpersontype");
//		pros.put("rsex", "rsex");
//		pros.put("dbirthdate", "dbirthdate");
//		pros.put("rnativeplace", "rnativeplace");
//		pros.put("rnational", "rnational");
//		pros.put("rhealthstatus", "rhealthstatus");
//		pros.put("rmarristatus", "rmarristatus");
//		pros.put("vidno", "vidno");
//		pros.put("mpicture", "mpicture");
//		pros.put("rperresidence", "rperresidence");
//		pros.put("valianame", "valianame");
//		pros.put("djoinworkdate", "djoinworkdate");
//		pros.put("denterdate", "denterdate");
//		pros.put("dregulardate", "dregulardate");
//		pros.put("vssno", "vssno");
		pros.put("rworkattend", "rworkattend");
//		pros.put("vcardno", "vcardno");
//		pros.put("rtbmrule", "rtbmrule");
//		pros.put("rcheckinflag", "rcheckinflag");
		pros.put("dlastdate", "dlastdate");
//		pros.put("hrts", "hrts");
		pros.put("vstatus1", "vstatus1");
		pros.put("nstatus2", "nstatus2");
		pros.put("bpsnperson", "bpsnperson");
//		pros.put("cpsnmobilephone", "cpsnmobilephone");
//		pros.put("cpsnfphone", "cpsnfphone");
//		pros.put("cpsnophone", "cpsnophone");
//		pros.put("cpsninphone", "cpsninphone");
//		pros.put("cpsnemail", "cpsnemail");
//		pros.put("cpsnpostaddr", "cpsnpostaddr");
//		pros.put("cpsnpostcode", "cpsnpostcode");
//		pros.put("cpsnfaddr", "cpsnfaddr");
//		pros.put("cpsnqqcode", "cpsnqqcode");
//		pros.put("cpsnurl", "cpsnurl");
//		pros.put("cpsnoseat", "cpsnoseat");
//		pros.put("denterunitdate", "denterunitdate");
//		pros.put("cpsnproperty", "cpsnproperty");
//		pros.put("cpsnbankcode", "cpsnbankcode");
//		pros.put("cpsnaccount", "cpsnaccount");
//		pros.put("pk_hr_hi_person", "pk_hr_hi_person");
//		pros.put("bprobation", "bprobation");
//		pros.put("cdutyclass", "cdutyclass");
//		pros.put("btaketm", "btaketm");
//		pros.put("mpictureqpb", "mpictureqpb");
//		pros.put("ridtype", "ridtype");
//		pros.put("rcountry", "rcountry");
//		pros.put("dleavedate", "dleavedate");
//		pros.put("rfigure", "rfigure");
//		pros.put("rworkstatus", "rworkstatus");
//		pros.put("employmentform", "employmentform");
//		pros.put("rpersonparameters", "rpersonparameters");
		pros.put("bdutylock", "bdutylock");
		pros.put("bpsnshop", "bpsnshop");
//		pros.put("cardstate", "cardstate");
//		pros.put("firsthtbegindate", "firsthtbegindate");
//		pros.put("lasthtenddate", "lasthtenddate");
//		pros.put("cpsn_nameen", "cpsn_nameen");
//		pros.put("sysage", "sysage");
//		pros.put("syscompage", "syscompage");
//		pros.put("sysworkage", "sysworkage");
//		pros.put("cregion", "cregion");
//		pros.put("natruetype", "natruetype");
//		pros.put("jobnumber", "jobnumber");
//		pros.put("persondepart", "persondepart");
//		pros.put("cardeffectivebegintime", "cardeffectivebegintime");
//		pros.put("cardeffectiveendtime", "cardeffectiveendtime");
//		pros.put("keyperson", "keyperson");
//		pros.put("cleavereson", "cleavereson");
//		pros.put("shenfen", "shenfen");
//		pros.put("weishengjishu", "weishengjishu");
//		pros.put("gonglingqisuan", "gonglingqisuan");
//		pros.put("cpsnppt", "cpsnppt");
//		pros.put("cpsnjoblevel", "cpsnjoblevel");
//		pros.put("cpsncom", "cpsncom");
//		pros.put("cpsntopred", "cpsntopred");
//		pros.put("cpsncollege", "cpsncollege");
//		pros.put("cpsntopdegree", "cpsntopdegree");
//		pros.put("cpsncoll2", "cpsncoll2");
//		pros.put("cpsnincumred", "cpsnincumred");
//		pros.put("cpsnincumcoll", "cpsnincumcoll");
//		pros.put("cpsnjoblvldate", "cpsnjoblvldate");
//		pros.put("cpsntopredft", "cpsntopredft");
//		pros.put("cpsntopdegreeft", "cpsntopdegreeft");
//		pros.put("cpsncoll4", "cpsncoll4");
//		pros.put("cpsncoll3", "cpsncoll3");
//		pros.put("cpsndegreeft", "cpsndegreeft");
//		pros.put("cpsnredft", "cpsnredft");
//		pros.put("cpsnincred", "cpsnincred");
//		pros.put("cpsnincdegree", "cpsnincdegree");
//		pros.put("cpsntopredcode", "cpsntopredcode");
//		pros.put("cpsntopdegcode", "cpsntopdegcode");
//		pros.put("cpsndut", "cpsndut");
//		pros.put("cpsndutdate", "cpsndutdate");
//		pros.put("cpsnjoblvldate2", "cpsnjoblvldate2");
//		pros.put("cpsnparty", "cpsnparty");
//		pros.put("cpsnrdate", "cpsnrdate");
//		pros.put("cpsnpartysec", "cpsnpartysec");
//		pros.put("cpsnpartythd", "cpsnpartythd");
//		pros.put("cpsndutname", "cpsndutname");
//		pros.put("cpsndegreedate", "cpsndegreedate");
//		pros.put("cpsndutdate2", "cpsndutdate2");
//		pros.put("cpsndate", "cpsndate");
//		pros.put("cpsnyear", "cpsnyear");
//		pros.put("cpsnlvl", "cpsnlvl");
//		pros.put("cpsntopredd", "cpsntopredd");
//		pros.put("cpsnzyzt", "cpsnzyzt");
//		pros.put("cpsnzbzsbm", "cpsnzbzsbm");
//		pros.put("cpsnzyzbbm", "cpsnzyzbbm");
//		pros.put("cpsnysjb", "cpsnysjb");
//		pros.put("cpsnzylb", "cpsnzylb");
//		pros.put("cpsnzykm", "cpsnzykm");
//		pros.put("cpsnpzdate", "cpsnpzdate");
		
		pros.put("bprobation","是否是试用人员");
		pros.put("btaketm","是否考勤");
		pros.put("cardeffectivebegintime","证件期限开始时间");
		pros.put("cardeffectiveendtime","证件期限截止时间");
		pros.put("cardstate","发卡状态");
		pros.put("cdept_num","部门");
		pros.put("cdutyclass","班组");
		pros.put("cleavereson","离职原因");
		pros.put("cpsn_name","姓名");
		pros.put("cpsn_nameen","英文名");
		pros.put("cpsn_num","人员编码");
		pros.put("cpsnaccount","账号");
		pros.put("cpsnbankcode","银行");
		pros.put("cpsncoll2","院校系专业（最高全日制学位）");
		pros.put("cpsncoll3","院校系专业（最高学历）");
		pros.put("cpsncoll4","院校系专业（最高学位）");
		pros.put("cpsncollege","院校系专业（最高全日制学历）");
		pros.put("cpsncom","工作单位及职务");
		pros.put("cpsndate","聘任时间");
		pros.put("cpsndegreedate","毕业时间");
		pros.put("cpsndegreeft","全日制学位（代码）");
		pros.put("cpsndut","职务名称");
		pros.put("cpsndutdate","任职时间");
		pros.put("cpsndutdate2","取得时间");
		pros.put("cpsndutname","职称");
		pros.put("cpsnemail","Email");
		pros.put("cpsnfaddr","家庭住址");
		pros.put("cpsnfphone","家庭电话");
		pros.put("cpsnincdegree","在职学位（代码）");
		pros.put("cpsnincred","在职学历（代码）");
		pros.put("cpsnincumcoll","院校系专业（最高在职学历）");
		pros.put("cpsnincumred","最高在职学历");
		pros.put("cpsninphone","内线电话");
		pros.put("cpsnjoblevel","最高职务层次");
		pros.put("cpsnjoblvldate","职务层次批准日期");
		pros.put("cpsnjoblvldate2","职务层次时间");
		pros.put("cpsnlvl","工资级别");
		pros.put("cpsnmobilephone","手机");
		pros.put("cpsnophone","办公电话");
		pros.put("cpsnoseat","工位");
		pros.put("cpsnparty","政治面貌");
		pros.put("cpsnpartysec","第二党派");
		pros.put("cpsnpartythd","第三党派");
		pros.put("cpsnpostaddr","通讯地址");
		pros.put("cpsnpostcode","邮政编码");
		pros.put("cpsnppt","人员性质");
		pros.put("cpsnproperty","人员属性");
		pros.put("cpsnpzdate","批准日期");
		pros.put("cpsnqqcode","QQ");
		pros.put("cpsnrdate","入党时间");
		pros.put("cpsnredft","全日制学历（代码）");
		pros.put("cpsntopdegcode","最高学位（代码）");
		pros.put("cpsntopdegree","最高学位");
		pros.put("cpsntopdegreeft","最高全日制学位");
		pros.put("cpsntopred","最高学历停用");
		pros.put("cpsntopredcode","最高学历（代码）");
		pros.put("cpsntopredd","最高学历");
		pros.put("cpsntopredft","最高全日制学历");
		pros.put("cpsnurl","个人网址");
		pros.put("cpsnyear","聘任年限");
		pros.put("cpsnysjb","医师级别");
		pros.put("cpsnzbzsbm","资格证书编码");
		pros.put("cpsnzykm","执业科目");
		pros.put("cpsnzylb","执业类别");
		pros.put("cpsnzyzbbm","执业证书编码");
		pros.put("cpsnzyzt","执业状态");
		pros.put("cregion","福利地区");
		pros.put("dbirthdate","出生日期");
		pros.put("denterdate","来院时间");
		pros.put("denterunitdate","到职日期");
		pros.put("djoinworkdate","参加工作时间");
		pros.put("dleavedate","离职日期");
		pros.put("dregulardate","转正时间");
		pros.put("employmentform","用工形式");
		pros.put("firsthtbegindate","合同初签日期");
		pros.put("gonglingqisuan","连续工龄起算时间");
		pros.put("hrts","时间戳");
		pros.put("irecordid","显示序号");
		pros.put("jobnumber","工号");
		pros.put("keyperson","是否核心人才");
		pros.put("lasthtenddate","合同到期日期");
		pros.put("mpicture","照片");
		pros.put("mpictureqpb","照片类型");
		pros.put("natruetype","户口性质");
		pros.put("persondepart","签发机关");
		pros.put("rcheckinflag","审核标志");
		pros.put("rcountry","国家地区");
		pros.put("rfigure","职员身份");
		pros.put("rhealthstatus","健康状况");
		pros.put("ridtype","证件类型");
		pros.put("rmarristatus","婚姻状况");
		pros.put("rnational","民族");
		pros.put("rnativeplace","籍贯");
		pros.put("rperresidence","户籍");
		pros.put("rpersonparameters","考勤制度");
		pros.put("rpersontype","人员类别");
		pros.put("rsex","性别");
		pros.put("rtbmrule","考勤规则");
		pros.put("rworkstatus","从业状况");
		pros.put("shenfen","身份");
		pros.put("sysage","年龄");
		pros.put("syscompage","司龄");
		pros.put("sysworkage","工龄");
		pros.put("valianame","曾用名");
		pros.put("vcardno","考勤卡号");
		pros.put("vidno","证件号码");
		pros.put("vssno","社会保障号");
		pros.put("weishengjishu","是否卫生技术人员");

		return pros;
	}

	public String getCpsn_num()
	{
		return cpsn_num;
	}

	public void setCpsn_num(String cpsn_num)
	{
		this.cpsn_num = cpsn_num;
	}

	public String getCpsn_name()
	{
		return cpsn_name;
	}

	public void setCpsn_name(String cpsn_name)
	{
		this.cpsn_name = cpsn_name;
	}

	public String getCdept_num()
	{
		return cdept_num;
	}

	public void setCdept_num(String cdept_num)
	{
		this.cdept_num = cdept_num;
	}

	public Long getIrecordid()
	{
		return irecordid;
	}

	public void setIrecordid(Long irecordid)
	{
		this.irecordid = irecordid;
	}

	public String getRpersontype()
	{
		return rpersontype;
	}

	public void setRpersontype(String rpersontype)
	{
		this.rpersontype = rpersontype;
	}

	public String getRsex()
	{
		return rsex;
	}

	public void setRsex(String rsex)
	{
		this.rsex = rsex;
	}

	public String getDbirthdate()
	{
		return dbirthdate;
	}

	public void setDbirthdate(String dbirthdate)
	{
		this.dbirthdate = dbirthdate;
	}

	public String getRnativeplace()
	{
		return rnativeplace;
	}

	public void setRnativeplace(String rnativeplace)
	{
		this.rnativeplace = rnativeplace;
	}

	public String getRnational()
	{
		return rnational;
	}

	public void setRnational(String rnational)
	{
		this.rnational = rnational;
	}

	public String getRhealthstatus()
	{
		return rhealthstatus;
	}

	public void setRhealthstatus(String rhealthstatus)
	{
		this.rhealthstatus = rhealthstatus;
	}

	public String getRmarristatus()
	{
		return rmarristatus;
	}

	public void setRmarristatus(String rmarristatus)
	{
		this.rmarristatus = rmarristatus;
	}

	public String getVidno()
	{
		return vidno;
	}

	public void setVidno(String vidno)
	{
		this.vidno = vidno;
	}

	public String getMpicture()
	{
		return mpicture;
	}

	public void setMpicture(String mpicture)
	{
		this.mpicture = mpicture;
	}

	public String getRperresidence()
	{
		return rperresidence;
	}

	public void setRperresidence(String rperresidence)
	{
		this.rperresidence = rperresidence;
	}

	public String getValianame()
	{
		return valianame;
	}

	public void setValianame(String valianame)
	{
		this.valianame = valianame;
	}

	public String getDjoinworkdate()
	{
		return djoinworkdate;
	}

	public void setDjoinworkdate(String djoinworkdate)
	{
		this.djoinworkdate = djoinworkdate;
	}

	public String getDenterdate()
	{
		return denterdate;
	}

	public void setDenterdate(String denterdate)
	{
		this.denterdate = denterdate;
	}

	public String getDregulardate()
	{
		return dregulardate;
	}

	public void setDregulardate(String dregulardate)
	{
		this.dregulardate = dregulardate;
	}

	public String getVssno()
	{
		return vssno;
	}

	public void setVssno(String vssno)
	{
		this.vssno = vssno;
	}

	public String getRworkattend()
	{
		return rworkattend;
	}

	public void setRworkattend(String rworkattend)
	{
		this.rworkattend = rworkattend;
	}

	public String getVcardno()
	{
		return vcardno;
	}

	public void setVcardno(String vcardno)
	{
		this.vcardno = vcardno;
	}

	public String getRtbmrule()
	{
		return rtbmrule;
	}

	public void setRtbmrule(String rtbmrule)
	{
		this.rtbmrule = rtbmrule;
	}

	public String getRcheckinflag()
	{
		return rcheckinflag;
	}

	public void setRcheckinflag(String rcheckinflag)
	{
		this.rcheckinflag = rcheckinflag;
	}

	public String getDlastdate()
	{
		return dlastdate;
	}

	public void setDlastdate(String dlastdate)
	{
		this.dlastdate = dlastdate;
	}

	public String getHrts()
	{
		return hrts;
	}

	public void setHrts(String hrts)
	{
		this.hrts = hrts;
	}

	public String getVstatus1()
	{
		return vstatus1;
	}

	public void setVstatus1(String vstatus1)
	{
		this.vstatus1 = vstatus1;
	}

	public Long getNstatus2()
	{
		return nstatus2;
	}

	public void setNstatus2(Long nstatus2)
	{
		this.nstatus2 = nstatus2;
	}

	public Boolean getBpsnperson()
	{
		return bpsnperson;
	}

	public void setBpsnperson(Boolean bpsnperson)
	{
		this.bpsnperson = bpsnperson;
	}

	public String getCpsnmobilephone()
	{
		return cpsnmobilephone;
	}

	public void setCpsnmobilephone(String cpsnmobilephone)
	{
		this.cpsnmobilephone = cpsnmobilephone;
	}

	public String getCpsnfphone()
	{
		return cpsnfphone;
	}

	public void setCpsnfphone(String cpsnfphone)
	{
		this.cpsnfphone = cpsnfphone;
	}

	public String getCpsnophone()
	{
		return cpsnophone;
	}

	public void setCpsnophone(String cpsnophone)
	{
		this.cpsnophone = cpsnophone;
	}

	public String getCpsninphone()
	{
		return cpsninphone;
	}

	public void setCpsninphone(String cpsninphone)
	{
		this.cpsninphone = cpsninphone;
	}

	public String getCpsnemail()
	{
		return cpsnemail;
	}

	public void setCpsnemail(String cpsnemail)
	{
		this.cpsnemail = cpsnemail;
	}

	public String getCpsnpostaddr()
	{
		return cpsnpostaddr;
	}

	public void setCpsnpostaddr(String cpsnpostaddr)
	{
		this.cpsnpostaddr = cpsnpostaddr;
	}

	public String getCpsnpostcode()
	{
		return cpsnpostcode;
	}

	public void setCpsnpostcode(String cpsnpostcode)
	{
		this.cpsnpostcode = cpsnpostcode;
	}

	public String getCpsnfaddr()
	{
		return cpsnfaddr;
	}

	public void setCpsnfaddr(String cpsnfaddr)
	{
		this.cpsnfaddr = cpsnfaddr;
	}

	public String getCpsnqqcode()
	{
		return cpsnqqcode;
	}

	public void setCpsnqqcode(String cpsnqqcode)
	{
		this.cpsnqqcode = cpsnqqcode;
	}

	public String getCpsnurl()
	{
		return cpsnurl;
	}

	public void setCpsnurl(String cpsnurl)
	{
		this.cpsnurl = cpsnurl;
	}

	public String getCpsnoseat()
	{
		return cpsnoseat;
	}

	public void setCpsnoseat(String cpsnoseat)
	{
		this.cpsnoseat = cpsnoseat;
	}

	public String getDenterunitdate()
	{
		return denterunitdate;
	}

	public void setDenterunitdate(String denterunitdate)
	{
		this.denterunitdate = denterunitdate;
	}

	public String getCpsnproperty()
	{
		return cpsnproperty;
	}

	public void setCpsnproperty(String cpsnproperty)
	{
		this.cpsnproperty = cpsnproperty;
	}

	public String getCpsnbankcode()
	{
		return cpsnbankcode;
	}

	public void setCpsnbankcode(String cpsnbankcode)
	{
		this.cpsnbankcode = cpsnbankcode;
	}

	public String getCpsnaccount()
	{
		return cpsnaccount;
	}

	public void setCpsnaccount(String cpsnaccount)
	{
		this.cpsnaccount = cpsnaccount;
	}

	public String getPk_hr_hi_person()
	{
		return pk_hr_hi_person;
	}

	public void setPk_hr_hi_person(String pk_hr_hi_person)
	{
		this.pk_hr_hi_person = pk_hr_hi_person;
	}

	public Boolean getBprobation()
	{
		return bprobation;
	}

	public void setBprobation(Boolean bprobation)
	{
		this.bprobation = bprobation;
	}

	public String getCdutyclass()
	{
		return cdutyclass;
	}

	public void setCdutyclass(String cdutyclass)
	{
		this.cdutyclass = cdutyclass;
	}

	public Boolean getBtaketm()
	{
		return btaketm;
	}

	public void setBtaketm(Boolean btaketm)
	{
		this.btaketm = btaketm;
	}

	public String getMpictureqpb()
	{
		return mpictureqpb;
	}

	public void setMpictureqpb(String mpictureqpb)
	{
		this.mpictureqpb = mpictureqpb;
	}

	public String getRidtype()
	{
		return ridtype;
	}

	public void setRidtype(String ridtype)
	{
		this.ridtype = ridtype;
	}

	public String getRcountry()
	{
		return rcountry;
	}

	public void setRcountry(String rcountry)
	{
		this.rcountry = rcountry;
	}

	public String getDleavedate()
	{
		return dleavedate;
	}

	public void setDleavedate(String dleavedate)
	{
		this.dleavedate = dleavedate;
	}

	public String getRfigure()
	{
		return rfigure;
	}

	public void setRfigure(String rfigure)
	{
		this.rfigure = rfigure;
	}

	public String getRworkstatus()
	{
		return rworkstatus;
	}

	public void setRworkstatus(String rworkstatus)
	{
		this.rworkstatus = rworkstatus;
	}

	public String getEmploymentform()
	{
		return employmentform;
	}

	public void setEmploymentform(String employmentform)
	{
		this.employmentform = employmentform;
	}

	public String getRpersonparameters()
	{
		return rpersonparameters;
	}

	public void setRpersonparameters(String rpersonparameters)
	{
		this.rpersonparameters = rpersonparameters;
	}

	public Boolean getBdutylock()
	{
		return bdutylock;
	}

	public void setBdutylock(Boolean bdutylock)
	{
		this.bdutylock = bdutylock;
	}

	public Boolean getBpsnshop()
	{
		return bpsnshop;
	}

	public void setBpsnshop(Boolean bpsnshop)
	{
		this.bpsnshop = bpsnshop;
	}

	public String getCardstate()
	{
		return cardstate;
	}

	public void setCardstate(String cardstate)
	{
		this.cardstate = cardstate;
	}

	public String getFirsthtbegindate()
	{
		return firsthtbegindate;
	}

	public void setFirsthtbegindate(String firsthtbegindate)
	{
		this.firsthtbegindate = firsthtbegindate;
	}

	public String getLasthtenddate()
	{
		return lasthtenddate;
	}

	public void setLasthtenddate(String lasthtenddate)
	{
		this.lasthtenddate = lasthtenddate;
	}

	public String getCpsn_nameen()
	{
		return cpsn_nameen;
	}

	public void setCpsn_nameen(String cpsn_nameen)
	{
		this.cpsn_nameen = cpsn_nameen;
	}

	public Double getSysage()
	{
		return sysage;
	}

	public void setSysage(Double sysage)
	{
		this.sysage = sysage;
	}

	public Double getSyscompage()
	{
		return syscompage;
	}

	public void setSyscompage(Double syscompage)
	{
		this.syscompage = syscompage;
	}

	public Double getSysworkage()
	{
		return sysworkage;
	}

	public void setSysworkage(Double sysworkage)
	{
		this.sysworkage = sysworkage;
	}

	public String getCregion()
	{
		return cregion;
	}

	public void setCregion(String cregion)
	{
		this.cregion = cregion;
	}

	public String getNatruetype()
	{
		return natruetype;
	}

	public void setNatruetype(String natruetype)
	{
		this.natruetype = natruetype;
	}

	public String getJobnumber()
	{
		return jobnumber;
	}

	public void setJobnumber(String jobnumber)
	{
		this.jobnumber = jobnumber;
	}

	public String getPersondepart()
	{
		return persondepart;
	}

	public void setPersondepart(String persondepart)
	{
		this.persondepart = persondepart;
	}

	public String getCardeffectivebegintime()
	{
		return cardeffectivebegintime;
	}

	public void setCardeffectivebegintime(String cardeffectivebegintime)
	{
		this.cardeffectivebegintime = cardeffectivebegintime;
	}

	public String getCardeffectiveendtime()
	{
		return cardeffectiveendtime;
	}

	public void setCardeffectiveendtime(String cardeffectiveendtime)
	{
		this.cardeffectiveendtime = cardeffectiveendtime;
	}

	public Boolean getKeyperson()
	{
		return keyperson;
	}

	public void setKeyperson(Boolean keyperson)
	{
		this.keyperson = keyperson;
	}

	public String getCleavereson()
	{
		return cleavereson;
	}

	public void setCleavereson(String cleavereson)
	{
		this.cleavereson = cleavereson;
	}

	public String getShenfen()
	{
		return shenfen;
	}

	public void setShenfen(String shenfen)
	{
		this.shenfen = shenfen;
	}

	public String getWeishengjishu()
	{
		return weishengjishu;
	}

	public void setWeishengjishu(String weishengjishu)
	{
		this.weishengjishu = weishengjishu;
	}

	public String getGonglingqisuan()
	{
		return gonglingqisuan;
	}

	public void setGonglingqisuan(String gonglingqisuan)
	{
		this.gonglingqisuan = gonglingqisuan;
	}

	public String getCpsnppt()
	{
		return cpsnppt;
	}

	public void setCpsnppt(String cpsnppt)
	{
		this.cpsnppt = cpsnppt;
	}

	public String getCpsnjoblevel()
	{
		return cpsnjoblevel;
	}

	public void setCpsnjoblevel(String cpsnjoblevel)
	{
		this.cpsnjoblevel = cpsnjoblevel;
	}

	public String getCpsncom()
	{
		return cpsncom;
	}

	public void setCpsncom(String cpsncom)
	{
		this.cpsncom = cpsncom;
	}

	public String getCpsntopred()
	{
		return cpsntopred;
	}

	public void setCpsntopred(String cpsntopred)
	{
		this.cpsntopred = cpsntopred;
	}

	public String getCpsncollege()
	{
		return cpsncollege;
	}

	public void setCpsncollege(String cpsncollege)
	{
		this.cpsncollege = cpsncollege;
	}

	public String getCpsntopdegree()
	{
		return cpsntopdegree;
	}

	public void setCpsntopdegree(String cpsntopdegree)
	{
		this.cpsntopdegree = cpsntopdegree;
	}

	public String getCpsncoll2()
	{
		return cpsncoll2;
	}

	public void setCpsncoll2(String cpsncoll2)
	{
		this.cpsncoll2 = cpsncoll2;
	}

	public String getCpsnincumred()
	{
		return cpsnincumred;
	}

	public void setCpsnincumred(String cpsnincumred)
	{
		this.cpsnincumred = cpsnincumred;
	}

	public String getCpsnincumcoll()
	{
		return cpsnincumcoll;
	}

	public void setCpsnincumcoll(String cpsnincumcoll)
	{
		this.cpsnincumcoll = cpsnincumcoll;
	}

	public String getCpsnjoblvldate()
	{
		return cpsnjoblvldate;
	}

	public void setCpsnjoblvldate(String cpsnjoblvldate)
	{
		this.cpsnjoblvldate = cpsnjoblvldate;
	}

	public String getCpsntopredft()
	{
		return cpsntopredft;
	}

	public void setCpsntopredft(String cpsntopredft)
	{
		this.cpsntopredft = cpsntopredft;
	}

	public String getCpsntopdegreeft()
	{
		return cpsntopdegreeft;
	}

	public void setCpsntopdegreeft(String cpsntopdegreeft)
	{
		this.cpsntopdegreeft = cpsntopdegreeft;
	}

	public String getCpsncoll4()
	{
		return cpsncoll4;
	}

	public void setCpsncoll4(String cpsncoll4)
	{
		this.cpsncoll4 = cpsncoll4;
	}

	public String getCpsncoll3()
	{
		return cpsncoll3;
	}

	public void setCpsncoll3(String cpsncoll3)
	{
		this.cpsncoll3 = cpsncoll3;
	}

	public String getCpsndegreeft()
	{
		return cpsndegreeft;
	}

	public void setCpsndegreeft(String cpsndegreeft)
	{
		this.cpsndegreeft = cpsndegreeft;
	}

	public String getCpsnredft()
	{
		return cpsnredft;
	}

	public void setCpsnredft(String cpsnredft)
	{
		this.cpsnredft = cpsnredft;
	}

	public String getCpsnincred()
	{
		return cpsnincred;
	}

	public void setCpsnincred(String cpsnincred)
	{
		this.cpsnincred = cpsnincred;
	}

	public String getCpsnincdegree()
	{
		return cpsnincdegree;
	}

	public void setCpsnincdegree(String cpsnincdegree)
	{
		this.cpsnincdegree = cpsnincdegree;
	}

	public String getCpsntopredcode()
	{
		return cpsntopredcode;
	}

	public void setCpsntopredcode(String cpsntopredcode)
	{
		this.cpsntopredcode = cpsntopredcode;
	}

	public String getCpsntopdegcode()
	{
		return cpsntopdegcode;
	}

	public void setCpsntopdegcode(String cpsntopdegcode)
	{
		this.cpsntopdegcode = cpsntopdegcode;
	}

	public String getCpsndut()
	{
		return cpsndut;
	}

	public void setCpsndut(String cpsndut)
	{
		this.cpsndut = cpsndut;
	}

	public String getCpsndutdate()
	{
		return cpsndutdate;
	}

	public void setCpsndutdate(String cpsndutdate)
	{
		this.cpsndutdate = cpsndutdate;
	}

	public String getCpsnjoblvldate2()
	{
		return cpsnjoblvldate2;
	}

	public void setCpsnjoblvldate2(String cpsnjoblvldate2)
	{
		this.cpsnjoblvldate2 = cpsnjoblvldate2;
	}

	public String getCpsnparty()
	{
		return cpsnparty;
	}

	public void setCpsnparty(String cpsnparty)
	{
		this.cpsnparty = cpsnparty;
	}

	public String getCpsnrdate()
	{
		return cpsnrdate;
	}

	public void setCpsnrdate(String cpsnrdate)
	{
		this.cpsnrdate = cpsnrdate;
	}

	public String getCpsnpartysec()
	{
		return cpsnpartysec;
	}

	public void setCpsnpartysec(String cpsnpartysec)
	{
		this.cpsnpartysec = cpsnpartysec;
	}

	public String getCpsnpartythd()
	{
		return cpsnpartythd;
	}

	public void setCpsnpartythd(String cpsnpartythd)
	{
		this.cpsnpartythd = cpsnpartythd;
	}

	public String getCpsndutname()
	{
		return cpsndutname;
	}

	public void setCpsndutname(String cpsndutname)
	{
		this.cpsndutname = cpsndutname;
	}

	public String getCpsndegreedate()
	{
		return cpsndegreedate;
	}

	public void setCpsndegreedate(String cpsndegreedate)
	{
		this.cpsndegreedate = cpsndegreedate;
	}

	public String getCpsndutdate2()
	{
		return cpsndutdate2;
	}

	public void setCpsndutdate2(String cpsndutdate2)
	{
		this.cpsndutdate2 = cpsndutdate2;
	}

	public Long getCpsndate()
	{
		return cpsndate;
	}

	public void setCpsndate(Long cpsndate)
	{
		this.cpsndate = cpsndate;
	}

	public Long getCpsnyear()
	{
		return cpsnyear;
	}

	public void setCpsnyear(Long cpsnyear)
	{
		this.cpsnyear = cpsnyear;
	}

	public String getCpsnlvl()
	{
		return cpsnlvl;
	}

	public void setCpsnlvl(String cpsnlvl)
	{
		this.cpsnlvl = cpsnlvl;
	}

	public String getCpsntopredd()
	{
		return cpsntopredd;
	}

	public void setCpsntopredd(String cpsntopredd)
	{
		this.cpsntopredd = cpsntopredd;
	}

	public String getCpsnzyzt()
	{
		return cpsnzyzt;
	}

	public void setCpsnzyzt(String cpsnzyzt)
	{
		this.cpsnzyzt = cpsnzyzt;
	}

	public String getCpsnzbzsbm()
	{
		return cpsnzbzsbm;
	}

	public void setCpsnzbzsbm(String cpsnzbzsbm)
	{
		this.cpsnzbzsbm = cpsnzbzsbm;
	}

	public String getCpsnzyzbbm()
	{
		return cpsnzyzbbm;
	}

	public void setCpsnzyzbbm(String cpsnzyzbbm)
	{
		this.cpsnzyzbbm = cpsnzyzbbm;
	}

	public String getCpsnysjb()
	{
		return cpsnysjb;
	}

	public void setCpsnysjb(String cpsnysjb)
	{
		this.cpsnysjb = cpsnysjb;
	}

	public String getCpsnzylb()
	{
		return cpsnzylb;
	}

	public void setCpsnzylb(String cpsnzylb)
	{
		this.cpsnzylb = cpsnzylb;
	}

	public String getCpsnzykm()
	{
		return cpsnzykm;
	}

	public void setCpsnzykm(String cpsnzykm)
	{
		this.cpsnzykm = cpsnzykm;
	}

	public String getCpsnpzdate()
	{
		return cpsnpzdate;
	}

	public void setCpsnpzdate(String cpsnpzdate)
	{
		this.cpsnpzdate = cpsnpzdate;
	}

	@Override
	public String toString()
	{
		return JSON.toJSONString(this);
	}
}
