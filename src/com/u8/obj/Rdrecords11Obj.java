package com.u8.obj;

import java.sql.Timestamp;
import com.wuyg.common.dao.BaseDbObj;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.util.List;
import com.alibaba.fastjson.JSON;

public class Rdrecords11Obj extends BaseDbObj
{
	private Long autoid;
	private Long id;
	private String cinvcode;
	private Double inum;
	private Double iquantity;
	private Double iunitcost;
	private Double iprice;
	private Double iaprice;
	private Double ipunitcost;
	private Double ipprice;
	private String cbatch;
	private String cobjcode;
	private Long cvouchcode;
	private String cinvouchcode;
	private String cinvouchtype;
	private Double isoutquantity;
	private Double isoutnum;
	private Long coutvouchid;
	private String coutvouchtype;
	private Double isredoutquantity;
	private Double isredoutnum;
	private String cfree1;
	private String cfree2;
	private String iflag;
	private Double isquantity;
	private Double isnum;
	private Double ifnum;
	private Double ifquantity;
	private Timestamp dvdate;
	private Long itrids;
	private String cposition;
	private String cdefine22;
	private String cdefine23;
	private String cdefine24;
	private String cdefine25;
	private Double cdefine26;
	private Double cdefine27;
	private String citem_class;
	private String citemcode;
	private String cname;
	private String citemcname;
	private String cfree3;
	private String cfree4;
	private String cfree5;
	private String cfree6;
	private String cfree7;
	private String cfree8;
	private String cfree9;
	private String cfree10;
	private String cbarcode;
	private Double inquantity;
	private Double innum;
	private String cassunit;
	private Timestamp dmadedate;
	private Long imassdate;
	private String cdefine28;
	private String cdefine29;
	private String cdefine30;
	private String cdefine31;
	private String cdefine32;
	private String cdefine33;
	private Long cdefine34;
	private Long cdefine35;
	private Timestamp cdefine36;
	private Timestamp cdefine37;
	private Long impoids;
	private Long icheckids;
	private String cbvencode;
	private Boolean bgsp;
	private String cgspstate;
	private String ccheckcode;
	private Long icheckidbaks;
	private String crejectcode;
	private Long irejectids;
	private String ccheckpersoncode;
	private Timestamp dcheckdate;
	private Long cmassunit;
	private String cmolotcode;
	private Double imaterialfee;
	private Double iprocesscost;
	private Double iprocessfee;
	private Timestamp dmsdate;
	private Double ismaterialfee;
	private Double isprocessfee;
	private Long iomodid;
	private Long bfilled;
	private Boolean bchecked;
	private Long iomomid;
	private String cmworkcentercode;
	private Boolean blpusefree;
	private Long irsrowno;
	private Long ioritrackid;
	private String coritracktype;
	private String cbaccounter;
	private Timestamp dbkeepdate;
	private Boolean bcosting;
	private Boolean bvmiused;
	private Double ivmisettlequantity;
	private Double ivmisettlenum;
	private String cvmivencode;
	private Long iinvsncount;
	private String cwhpersoncode;
	private String cwhpersonname;
	private Long imaids;
	private String cserviceoid;
	private String cbserviceoid;
	private Double iinvexchrate;
	private String corufts;
	private String comcode;
	private String cmocode;
	private String invcode;
	private Long imoseq;
	private String iopseq;
	private String copdesc;
	private String strcontractguid;
	private Long iexpiratdatecalcu;
	private String cexpirationdate;
	private Timestamp dexpirationdate;
	private String cciqbookcode;
	private Double ibondedsumqty;
	private Long productinids;
	private Long iorderdid;
	private String iordertype;
	private String iordercode;
	private Long iorderseq;
	private String isodid;
	private String isotype;
	private String csocode;
	private Long isoseq;
	private String ipesodid;
	private String ipesotype;
	private String cpesocode;
	private Long ipesoseq;
	private Double cbatchproperty1;
	private Double cbatchproperty2;
	private Double cbatchproperty3;
	private Double cbatchproperty4;
	private Double cbatchproperty5;
	private String cbatchproperty6;
	private String cbatchproperty7;
	private String cbatchproperty8;
	private String cbatchproperty9;
	private Timestamp cbatchproperty10;
	private String cbmemo;
	private Long applydid;
	private String applycode;
	private Long irowno;
	private String strowguid;
	private String cservicecode;
	private String rowufts;
	private Double ipreuseqty;
	private Double ipreuseinum;
	private Long bsupersede;
	private Double isupersedeqty;
	private Long isupersedempoids;
	private String imoallocatesubid;
	private Long cinvoucherlineid;
	private String cinvouchercode;
	private String cinvouchertype;
	private String cbsysbarcode;
	private String csourcemocode;
	private Long isourcemodetailsid;
	private String cplanlotcode;
	private Long bcanreplace;
	private Long iposflag;

	private String ccode;
	private String cinvname;
	private String cinvstd;
	private String ccomunitname;
	private String cstcomunitname;

	@Override
	public String findKeyColumnName()
	{
		return "autoid";
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
		// 对内的对应rdrecord11
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
		sql.append(" rs.iunitcost, \n");
		sql.append(" rs.iprice \n");
		sql.append(" from Rdrecords11 rs  \n");
		sql.append(" left join Rdrecord11 rd on rs.id=rd.id  \n");
		sql.append(" left join inventory inv on rs.cinvcode=inv.cinvcode  \n");
		sql.append(" left join ComputationUnit cu on inv.cComUnitCode=cu.cComunitCode \n");
		sql.append(" left join ComputationUnit cua on rs.cAssUnit=cua.cComunitCode \n");
		sql.append(") t ");
		return sql.toString();
	}

	@Override
	public String findDefaultOrderBy()
	{
		return super.findDefaultOrderBy();
	}

	@Override
	public String getBasePath()
	{
		return "Rdrecords11";
	}

	@Override
	public String getCnName()
	{
		return "材料出库单明细";
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

		pros.put("autoid", "autoid");
		pros.put("id", "id");
		pros.put("cinvcode", "材料编码");
		pros.put("inum", "件数");
		pros.put("iquantity", "数量");
		pros.put("iunitcost", "单价（元）");
		pros.put("iprice", "价格（元）");
		pros.put("ccode", "单据号");
		pros.put("cinvname", "材料名称");
		pros.put("cinvstd", "规格");
		pros.put("ccomunitname", "主计量单位");
		pros.put("cstcomunitname","辅计量单位");
		pros.put("iinvexchrate", "换算率");
		pros.put("iaprice", "iaprice");
		pros.put("ipunitcost", "ipunitcost");
		pros.put("ipprice", "ipprice");
		pros.put("cbatch", "cbatch");
		pros.put("cobjcode", "cobjcode");
		pros.put("cvouchcode", "cvouchcode");
		pros.put("cinvouchcode", "cinvouchcode");
		pros.put("cinvouchtype", "cinvouchtype");
		pros.put("isoutquantity", "isoutquantity");
		pros.put("isoutnum", "isoutnum");
		pros.put("coutvouchid", "coutvouchid");
		pros.put("coutvouchtype", "coutvouchtype");
		pros.put("isredoutquantity", "isredoutquantity");
		pros.put("isredoutnum", "isredoutnum");
		pros.put("cfree1", "cfree1");
		pros.put("cfree2", "cfree2");
		pros.put("iflag", "iflag");
		pros.put("isquantity", "isquantity");
		pros.put("isnum", "isnum");
		pros.put("ifnum", "ifnum");
		pros.put("ifquantity", "ifquantity");
		pros.put("dvdate", "dvdate");
		pros.put("itrids", "itrids");
		pros.put("cposition", "cposition");
		pros.put("cdefine22", "cdefine22");
		pros.put("cdefine23", "cdefine23");
		pros.put("cdefine24", "cdefine24");
		pros.put("cdefine25", "cdefine25");
		pros.put("cdefine26", "cdefine26");
		pros.put("cdefine27", "cdefine27");
		pros.put("citem_class", "citem_class");
		pros.put("citemcode", "citemcode");
		pros.put("cname", "cname");
		pros.put("citemcname", "citemcname");
		pros.put("cfree3", "cfree3");
		pros.put("cfree4", "cfree4");
		pros.put("cfree5", "cfree5");
		pros.put("cfree6", "cfree6");
		pros.put("cfree7", "cfree7");
		pros.put("cfree8", "cfree8");
		pros.put("cfree9", "cfree9");
		pros.put("cfree10", "cfree10");
		pros.put("cbarcode", "cbarcode");
		pros.put("inquantity", "inquantity");
		pros.put("innum", "innum");
		pros.put("cassunit", "cassunit");
		pros.put("dmadedate", "dmadedate");
		pros.put("imassdate", "imassdate");
		pros.put("cdefine28", "cdefine28");
		pros.put("cdefine29", "cdefine29");
		pros.put("cdefine30", "cdefine30");
		pros.put("cdefine31", "cdefine31");
		pros.put("cdefine32", "cdefine32");
		pros.put("cdefine33", "cdefine33");
		pros.put("cdefine34", "cdefine34");
		pros.put("cdefine35", "cdefine35");
		pros.put("cdefine36", "cdefine36");
		pros.put("cdefine37", "cdefine37");
		pros.put("impoids", "impoids");
		pros.put("icheckids", "icheckids");
		pros.put("cbvencode", "cbvencode");
		pros.put("bgsp", "bgsp");
		pros.put("cgspstate", "cgspstate");
		pros.put("ccheckcode", "ccheckcode");
		pros.put("icheckidbaks", "icheckidbaks");
		pros.put("crejectcode", "crejectcode");
		pros.put("irejectids", "irejectids");
		pros.put("ccheckpersoncode", "ccheckpersoncode");
		pros.put("dcheckdate", "dcheckdate");
		pros.put("cmassunit", "cmassunit");
		pros.put("cmolotcode", "cmolotcode");
		pros.put("imaterialfee", "imaterialfee");
		pros.put("iprocesscost", "iprocesscost");
		pros.put("iprocessfee", "iprocessfee");
		pros.put("dmsdate", "dmsdate");
		pros.put("ismaterialfee", "ismaterialfee");
		pros.put("isprocessfee", "isprocessfee");
		pros.put("iomodid", "iomodid");
		pros.put("bfilled", "bfilled");
		pros.put("bchecked", "bchecked");
		pros.put("iomomid", "iomomid");
		pros.put("cmworkcentercode", "cmworkcentercode");
		pros.put("blpusefree", "blpusefree");
		pros.put("irsrowno", "irsrowno");
		pros.put("ioritrackid", "ioritrackid");
		pros.put("coritracktype", "coritracktype");
		pros.put("cbaccounter", "cbaccounter");
		pros.put("dbkeepdate", "dbkeepdate");
		pros.put("bcosting", "bcosting");
		pros.put("bvmiused", "bvmiused");
		pros.put("ivmisettlequantity", "ivmisettlequantity");
		pros.put("ivmisettlenum", "ivmisettlenum");
		pros.put("cvmivencode", "cvmivencode");
		pros.put("iinvsncount", "iinvsncount");
		pros.put("cwhpersoncode", "cwhpersoncode");
		pros.put("cwhpersonname", "cwhpersonname");
		pros.put("imaids", "imaids");
		pros.put("cserviceoid", "cserviceoid");
		pros.put("cbserviceoid", "cbserviceoid");
		
		pros.put("corufts", "corufts");
		pros.put("comcode", "comcode");
		pros.put("cmocode", "cmocode");
		pros.put("invcode", "invcode");
		pros.put("imoseq", "imoseq");
		pros.put("iopseq", "iopseq");
		pros.put("copdesc", "copdesc");
		pros.put("strcontractguid", "strcontractguid");
		pros.put("iexpiratdatecalcu", "iexpiratdatecalcu");
		pros.put("cexpirationdate", "cexpirationdate");
		pros.put("dexpirationdate", "dexpirationdate");
		pros.put("cciqbookcode", "cciqbookcode");
		pros.put("ibondedsumqty", "ibondedsumqty");
		pros.put("productinids", "productinids");
		pros.put("iorderdid", "iorderdid");
		pros.put("iordertype", "iordertype");
		pros.put("iordercode", "iordercode");
		pros.put("iorderseq", "iorderseq");
		pros.put("isodid", "isodid");
		pros.put("isotype", "isotype");
		pros.put("csocode", "csocode");
		pros.put("isoseq", "isoseq");
		pros.put("ipesodid", "ipesodid");
		pros.put("ipesotype", "ipesotype");
		pros.put("cpesocode", "cpesocode");
		pros.put("ipesoseq", "ipesoseq");
		pros.put("cbatchproperty1", "cbatchproperty1");
		pros.put("cbatchproperty2", "cbatchproperty2");
		pros.put("cbatchproperty3", "cbatchproperty3");
		pros.put("cbatchproperty4", "cbatchproperty4");
		pros.put("cbatchproperty5", "cbatchproperty5");
		pros.put("cbatchproperty6", "cbatchproperty6");
		pros.put("cbatchproperty7", "cbatchproperty7");
		pros.put("cbatchproperty8", "cbatchproperty8");
		pros.put("cbatchproperty9", "cbatchproperty9");
		pros.put("cbatchproperty10", "cbatchproperty10");
		pros.put("cbmemo", "cbmemo");
		pros.put("applydid", "applydid");
		pros.put("applycode", "applycode");
		pros.put("irowno", "irowno");
		pros.put("strowguid", "strowguid");
		pros.put("cservicecode", "cservicecode");
		pros.put("rowufts", "rowufts");
		pros.put("ipreuseqty", "ipreuseqty");
		pros.put("ipreuseinum", "ipreuseinum");
		pros.put("bsupersede", "bsupersede");
		pros.put("isupersedeqty", "isupersedeqty");
		pros.put("isupersedempoids", "isupersedempoids");
		pros.put("imoallocatesubid", "imoallocatesubid");
		pros.put("cinvoucherlineid", "cinvoucherlineid");
		pros.put("cinvouchercode", "cinvouchercode");
		pros.put("cinvouchertype", "cinvouchertype");
		pros.put("cbsysbarcode", "cbsysbarcode");
		pros.put("csourcemocode", "csourcemocode");
		pros.put("isourcemodetailsid", "isourcemodetailsid");
		pros.put("cplanlotcode", "cplanlotcode");
		pros.put("bcanreplace", "bcanreplace");
		pros.put("iposflag", "iposflag");
		return pros;
	}

	public Long getAutoid()
	{
		return autoid;
	}

	public void setAutoid(Long autoid)
	{
		this.autoid = autoid;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getCinvcode()
	{
		return cinvcode;
	}

	public void setCinvcode(String cinvcode)
	{
		this.cinvcode = cinvcode;
	}

	public Double getInum()
	{
		return inum;
	}

	public void setInum(Double inum)
	{
		this.inum = inum;
	}

	public Double getIquantity()
	{
		return iquantity;
	}

	public void setIquantity(Double iquantity)
	{
		this.iquantity = iquantity;
	}

	public Double getIunitcost()
	{
		return iunitcost;
	}

	public void setIunitcost(Double iunitcost)
	{
		this.iunitcost = iunitcost;
	}

	public Double getIprice()
	{
		return iprice;
	}

	public void setIprice(Double iprice)
	{
		this.iprice = iprice;
	}

	public Double getIaprice()
	{
		return iaprice;
	}

	public void setIaprice(Double iaprice)
	{
		this.iaprice = iaprice;
	}

	public Double getIpunitcost()
	{
		return ipunitcost;
	}

	public void setIpunitcost(Double ipunitcost)
	{
		this.ipunitcost = ipunitcost;
	}

	public Double getIpprice()
	{
		return ipprice;
	}

	public void setIpprice(Double ipprice)
	{
		this.ipprice = ipprice;
	}

	public String getCbatch()
	{
		return cbatch;
	}

	public void setCbatch(String cbatch)
	{
		this.cbatch = cbatch;
	}

	public String getCobjcode()
	{
		return cobjcode;
	}

	public void setCobjcode(String cobjcode)
	{
		this.cobjcode = cobjcode;
	}

	public Long getCvouchcode()
	{
		return cvouchcode;
	}

	public void setCvouchcode(Long cvouchcode)
	{
		this.cvouchcode = cvouchcode;
	}

	public String getCinvouchcode()
	{
		return cinvouchcode;
	}

	public void setCinvouchcode(String cinvouchcode)
	{
		this.cinvouchcode = cinvouchcode;
	}

	public String getCinvouchtype()
	{
		return cinvouchtype;
	}

	public void setCinvouchtype(String cinvouchtype)
	{
		this.cinvouchtype = cinvouchtype;
	}

	public Double getIsoutquantity()
	{
		return isoutquantity;
	}

	public void setIsoutquantity(Double isoutquantity)
	{
		this.isoutquantity = isoutquantity;
	}

	public Double getIsoutnum()
	{
		return isoutnum;
	}

	public void setIsoutnum(Double isoutnum)
	{
		this.isoutnum = isoutnum;
	}

	public Long getCoutvouchid()
	{
		return coutvouchid;
	}

	public void setCoutvouchid(Long coutvouchid)
	{
		this.coutvouchid = coutvouchid;
	}

	public String getCoutvouchtype()
	{
		return coutvouchtype;
	}

	public void setCoutvouchtype(String coutvouchtype)
	{
		this.coutvouchtype = coutvouchtype;
	}

	public Double getIsredoutquantity()
	{
		return isredoutquantity;
	}

	public void setIsredoutquantity(Double isredoutquantity)
	{
		this.isredoutquantity = isredoutquantity;
	}

	public Double getIsredoutnum()
	{
		return isredoutnum;
	}

	public void setIsredoutnum(Double isredoutnum)
	{
		this.isredoutnum = isredoutnum;
	}

	public String getCfree1()
	{
		return cfree1;
	}

	public void setCfree1(String cfree1)
	{
		this.cfree1 = cfree1;
	}

	public String getCfree2()
	{
		return cfree2;
	}

	public void setCfree2(String cfree2)
	{
		this.cfree2 = cfree2;
	}

	public String getIflag()
	{
		return iflag;
	}

	public void setIflag(String iflag)
	{
		this.iflag = iflag;
	}

	public Double getIsquantity()
	{
		return isquantity;
	}

	public void setIsquantity(Double isquantity)
	{
		this.isquantity = isquantity;
	}

	public Double getIsnum()
	{
		return isnum;
	}

	public void setIsnum(Double isnum)
	{
		this.isnum = isnum;
	}

	public Double getIfnum()
	{
		return ifnum;
	}

	public void setIfnum(Double ifnum)
	{
		this.ifnum = ifnum;
	}

	public Double getIfquantity()
	{
		return ifquantity;
	}

	public void setIfquantity(Double ifquantity)
	{
		this.ifquantity = ifquantity;
	}

	public Timestamp getDvdate()
	{
		return dvdate;
	}

	public void setDvdate(Timestamp dvdate)
	{
		this.dvdate = dvdate;
	}

	public Long getItrids()
	{
		return itrids;
	}

	public void setItrids(Long itrids)
	{
		this.itrids = itrids;
	}

	public String getCposition()
	{
		return cposition;
	}

	public void setCposition(String cposition)
	{
		this.cposition = cposition;
	}

	public String getCdefine22()
	{
		return cdefine22;
	}

	public void setCdefine22(String cdefine22)
	{
		this.cdefine22 = cdefine22;
	}

	public String getCdefine23()
	{
		return cdefine23;
	}

	public void setCdefine23(String cdefine23)
	{
		this.cdefine23 = cdefine23;
	}

	public String getCdefine24()
	{
		return cdefine24;
	}

	public void setCdefine24(String cdefine24)
	{
		this.cdefine24 = cdefine24;
	}

	public String getCdefine25()
	{
		return cdefine25;
	}

	public void setCdefine25(String cdefine25)
	{
		this.cdefine25 = cdefine25;
	}

	public Double getCdefine26()
	{
		return cdefine26;
	}

	public void setCdefine26(Double cdefine26)
	{
		this.cdefine26 = cdefine26;
	}

	public Double getCdefine27()
	{
		return cdefine27;
	}

	public void setCdefine27(Double cdefine27)
	{
		this.cdefine27 = cdefine27;
	}

	public String getCitem_class()
	{
		return citem_class;
	}

	public void setCitem_class(String citem_class)
	{
		this.citem_class = citem_class;
	}

	public String getCitemcode()
	{
		return citemcode;
	}

	public void setCitemcode(String citemcode)
	{
		this.citemcode = citemcode;
	}

	public String getCname()
	{
		return cname;
	}

	public void setCname(String cname)
	{
		this.cname = cname;
	}

	public String getCitemcname()
	{
		return citemcname;
	}

	public void setCitemcname(String citemcname)
	{
		this.citemcname = citemcname;
	}

	public String getCfree3()
	{
		return cfree3;
	}

	public void setCfree3(String cfree3)
	{
		this.cfree3 = cfree3;
	}

	public String getCfree4()
	{
		return cfree4;
	}

	public void setCfree4(String cfree4)
	{
		this.cfree4 = cfree4;
	}

	public String getCfree5()
	{
		return cfree5;
	}

	public void setCfree5(String cfree5)
	{
		this.cfree5 = cfree5;
	}

	public String getCfree6()
	{
		return cfree6;
	}

	public void setCfree6(String cfree6)
	{
		this.cfree6 = cfree6;
	}

	public String getCfree7()
	{
		return cfree7;
	}

	public void setCfree7(String cfree7)
	{
		this.cfree7 = cfree7;
	}

	public String getCfree8()
	{
		return cfree8;
	}

	public void setCfree8(String cfree8)
	{
		this.cfree8 = cfree8;
	}

	public String getCfree9()
	{
		return cfree9;
	}

	public void setCfree9(String cfree9)
	{
		this.cfree9 = cfree9;
	}

	public String getCfree10()
	{
		return cfree10;
	}

	public void setCfree10(String cfree10)
	{
		this.cfree10 = cfree10;
	}

	public String getCbarcode()
	{
		return cbarcode;
	}

	public void setCbarcode(String cbarcode)
	{
		this.cbarcode = cbarcode;
	}

	public Double getInquantity()
	{
		return inquantity;
	}

	public void setInquantity(Double inquantity)
	{
		this.inquantity = inquantity;
	}

	public Double getInnum()
	{
		return innum;
	}

	public void setInnum(Double innum)
	{
		this.innum = innum;
	}

	public String getCassunit()
	{
		return cassunit;
	}

	public void setCassunit(String cassunit)
	{
		this.cassunit = cassunit;
	}

	public Timestamp getDmadedate()
	{
		return dmadedate;
	}

	public void setDmadedate(Timestamp dmadedate)
	{
		this.dmadedate = dmadedate;
	}

	public Long getImassdate()
	{
		return imassdate;
	}

	public void setImassdate(Long imassdate)
	{
		this.imassdate = imassdate;
	}

	public String getCdefine28()
	{
		return cdefine28;
	}

	public void setCdefine28(String cdefine28)
	{
		this.cdefine28 = cdefine28;
	}

	public String getCdefine29()
	{
		return cdefine29;
	}

	public void setCdefine29(String cdefine29)
	{
		this.cdefine29 = cdefine29;
	}

	public String getCdefine30()
	{
		return cdefine30;
	}

	public void setCdefine30(String cdefine30)
	{
		this.cdefine30 = cdefine30;
	}

	public String getCdefine31()
	{
		return cdefine31;
	}

	public void setCdefine31(String cdefine31)
	{
		this.cdefine31 = cdefine31;
	}

	public String getCdefine32()
	{
		return cdefine32;
	}

	public void setCdefine32(String cdefine32)
	{
		this.cdefine32 = cdefine32;
	}

	public String getCdefine33()
	{
		return cdefine33;
	}

	public void setCdefine33(String cdefine33)
	{
		this.cdefine33 = cdefine33;
	}

	public Long getCdefine34()
	{
		return cdefine34;
	}

	public void setCdefine34(Long cdefine34)
	{
		this.cdefine34 = cdefine34;
	}

	public Long getCdefine35()
	{
		return cdefine35;
	}

	public void setCdefine35(Long cdefine35)
	{
		this.cdefine35 = cdefine35;
	}

	public Timestamp getCdefine36()
	{
		return cdefine36;
	}

	public void setCdefine36(Timestamp cdefine36)
	{
		this.cdefine36 = cdefine36;
	}

	public Timestamp getCdefine37()
	{
		return cdefine37;
	}

	public void setCdefine37(Timestamp cdefine37)
	{
		this.cdefine37 = cdefine37;
	}

	public Long getImpoids()
	{
		return impoids;
	}

	public void setImpoids(Long impoids)
	{
		this.impoids = impoids;
	}

	public Long getIcheckids()
	{
		return icheckids;
	}

	public void setIcheckids(Long icheckids)
	{
		this.icheckids = icheckids;
	}

	public String getCbvencode()
	{
		return cbvencode;
	}

	public void setCbvencode(String cbvencode)
	{
		this.cbvencode = cbvencode;
	}

	public Boolean getBgsp()
	{
		return bgsp;
	}

	public void setBgsp(Boolean bgsp)
	{
		this.bgsp = bgsp;
	}

	public String getCgspstate()
	{
		return cgspstate;
	}

	public void setCgspstate(String cgspstate)
	{
		this.cgspstate = cgspstate;
	}

	public String getCcheckcode()
	{
		return ccheckcode;
	}

	public void setCcheckcode(String ccheckcode)
	{
		this.ccheckcode = ccheckcode;
	}

	public Long getIcheckidbaks()
	{
		return icheckidbaks;
	}

	public void setIcheckidbaks(Long icheckidbaks)
	{
		this.icheckidbaks = icheckidbaks;
	}

	public String getCrejectcode()
	{
		return crejectcode;
	}

	public void setCrejectcode(String crejectcode)
	{
		this.crejectcode = crejectcode;
	}

	public Long getIrejectids()
	{
		return irejectids;
	}

	public void setIrejectids(Long irejectids)
	{
		this.irejectids = irejectids;
	}

	public String getCcheckpersoncode()
	{
		return ccheckpersoncode;
	}

	public void setCcheckpersoncode(String ccheckpersoncode)
	{
		this.ccheckpersoncode = ccheckpersoncode;
	}

	public Timestamp getDcheckdate()
	{
		return dcheckdate;
	}

	public void setDcheckdate(Timestamp dcheckdate)
	{
		this.dcheckdate = dcheckdate;
	}

	public Long getCmassunit()
	{
		return cmassunit;
	}

	public void setCmassunit(Long cmassunit)
	{
		this.cmassunit = cmassunit;
	}

	public String getCmolotcode()
	{
		return cmolotcode;
	}

	public void setCmolotcode(String cmolotcode)
	{
		this.cmolotcode = cmolotcode;
	}

	public Double getImaterialfee()
	{
		return imaterialfee;
	}

	public void setImaterialfee(Double imaterialfee)
	{
		this.imaterialfee = imaterialfee;
	}

	public Double getIprocesscost()
	{
		return iprocesscost;
	}

	public void setIprocesscost(Double iprocesscost)
	{
		this.iprocesscost = iprocesscost;
	}

	public Double getIprocessfee()
	{
		return iprocessfee;
	}

	public void setIprocessfee(Double iprocessfee)
	{
		this.iprocessfee = iprocessfee;
	}

	public Timestamp getDmsdate()
	{
		return dmsdate;
	}

	public void setDmsdate(Timestamp dmsdate)
	{
		this.dmsdate = dmsdate;
	}

	public Double getIsmaterialfee()
	{
		return ismaterialfee;
	}

	public void setIsmaterialfee(Double ismaterialfee)
	{
		this.ismaterialfee = ismaterialfee;
	}

	public Double getIsprocessfee()
	{
		return isprocessfee;
	}

	public void setIsprocessfee(Double isprocessfee)
	{
		this.isprocessfee = isprocessfee;
	}

	public Long getIomodid()
	{
		return iomodid;
	}

	public void setIomodid(Long iomodid)
	{
		this.iomodid = iomodid;
	}

	public Long getBfilled()
	{
		return bfilled;
	}

	public void setBfilled(Long bfilled)
	{
		this.bfilled = bfilled;
	}

	public Boolean getBchecked()
	{
		return bchecked;
	}

	public void setBchecked(Boolean bchecked)
	{
		this.bchecked = bchecked;
	}

	public Long getIomomid()
	{
		return iomomid;
	}

	public void setIomomid(Long iomomid)
	{
		this.iomomid = iomomid;
	}

	public String getCmworkcentercode()
	{
		return cmworkcentercode;
	}

	public void setCmworkcentercode(String cmworkcentercode)
	{
		this.cmworkcentercode = cmworkcentercode;
	}

	public Boolean getBlpusefree()
	{
		return blpusefree;
	}

	public void setBlpusefree(Boolean blpusefree)
	{
		this.blpusefree = blpusefree;
	}

	public Long getIrsrowno()
	{
		return irsrowno;
	}

	public void setIrsrowno(Long irsrowno)
	{
		this.irsrowno = irsrowno;
	}

	public Long getIoritrackid()
	{
		return ioritrackid;
	}

	public void setIoritrackid(Long ioritrackid)
	{
		this.ioritrackid = ioritrackid;
	}

	public String getCoritracktype()
	{
		return coritracktype;
	}

	public void setCoritracktype(String coritracktype)
	{
		this.coritracktype = coritracktype;
	}

	public String getCbaccounter()
	{
		return cbaccounter;
	}

	public void setCbaccounter(String cbaccounter)
	{
		this.cbaccounter = cbaccounter;
	}

	public Timestamp getDbkeepdate()
	{
		return dbkeepdate;
	}

	public void setDbkeepdate(Timestamp dbkeepdate)
	{
		this.dbkeepdate = dbkeepdate;
	}

	public Boolean getBcosting()
	{
		return bcosting;
	}

	public void setBcosting(Boolean bcosting)
	{
		this.bcosting = bcosting;
	}

	public Boolean getBvmiused()
	{
		return bvmiused;
	}

	public void setBvmiused(Boolean bvmiused)
	{
		this.bvmiused = bvmiused;
	}

	public Double getIvmisettlequantity()
	{
		return ivmisettlequantity;
	}

	public void setIvmisettlequantity(Double ivmisettlequantity)
	{
		this.ivmisettlequantity = ivmisettlequantity;
	}

	public Double getIvmisettlenum()
	{
		return ivmisettlenum;
	}

	public void setIvmisettlenum(Double ivmisettlenum)
	{
		this.ivmisettlenum = ivmisettlenum;
	}

	public String getCvmivencode()
	{
		return cvmivencode;
	}

	public void setCvmivencode(String cvmivencode)
	{
		this.cvmivencode = cvmivencode;
	}

	public Long getIinvsncount()
	{
		return iinvsncount;
	}

	public void setIinvsncount(Long iinvsncount)
	{
		this.iinvsncount = iinvsncount;
	}

	public String getCwhpersoncode()
	{
		return cwhpersoncode;
	}

	public void setCwhpersoncode(String cwhpersoncode)
	{
		this.cwhpersoncode = cwhpersoncode;
	}

	public String getCwhpersonname()
	{
		return cwhpersonname;
	}

	public void setCwhpersonname(String cwhpersonname)
	{
		this.cwhpersonname = cwhpersonname;
	}

	public Long getImaids()
	{
		return imaids;
	}

	public void setImaids(Long imaids)
	{
		this.imaids = imaids;
	}

	public String getCserviceoid()
	{
		return cserviceoid;
	}

	public void setCserviceoid(String cserviceoid)
	{
		this.cserviceoid = cserviceoid;
	}

	public String getCbserviceoid()
	{
		return cbserviceoid;
	}

	public void setCbserviceoid(String cbserviceoid)
	{
		this.cbserviceoid = cbserviceoid;
	}

	public Double getIinvexchrate()
	{
		return iinvexchrate;
	}

	public void setIinvexchrate(Double iinvexchrate)
	{
		this.iinvexchrate = iinvexchrate;
	}

	public String getCorufts()
	{
		return corufts;
	}

	public void setCorufts(String corufts)
	{
		this.corufts = corufts;
	}

	public String getComcode()
	{
		return comcode;
	}

	public void setComcode(String comcode)
	{
		this.comcode = comcode;
	}

	public String getCmocode()
	{
		return cmocode;
	}

	public void setCmocode(String cmocode)
	{
		this.cmocode = cmocode;
	}

	public String getInvcode()
	{
		return invcode;
	}

	public void setInvcode(String invcode)
	{
		this.invcode = invcode;
	}

	public Long getImoseq()
	{
		return imoseq;
	}

	public void setImoseq(Long imoseq)
	{
		this.imoseq = imoseq;
	}

	public String getIopseq()
	{
		return iopseq;
	}

	public void setIopseq(String iopseq)
	{
		this.iopseq = iopseq;
	}

	public String getCopdesc()
	{
		return copdesc;
	}

	public void setCopdesc(String copdesc)
	{
		this.copdesc = copdesc;
	}

	public String getStrcontractguid()
	{
		return strcontractguid;
	}

	public void setStrcontractguid(String strcontractguid)
	{
		this.strcontractguid = strcontractguid;
	}

	public Long getIexpiratdatecalcu()
	{
		return iexpiratdatecalcu;
	}

	public void setIexpiratdatecalcu(Long iexpiratdatecalcu)
	{
		this.iexpiratdatecalcu = iexpiratdatecalcu;
	}

	public String getCexpirationdate()
	{
		return cexpirationdate;
	}

	public void setCexpirationdate(String cexpirationdate)
	{
		this.cexpirationdate = cexpirationdate;
	}

	public Timestamp getDexpirationdate()
	{
		return dexpirationdate;
	}

	public void setDexpirationdate(Timestamp dexpirationdate)
	{
		this.dexpirationdate = dexpirationdate;
	}

	public String getCciqbookcode()
	{
		return cciqbookcode;
	}

	public void setCciqbookcode(String cciqbookcode)
	{
		this.cciqbookcode = cciqbookcode;
	}

	public Double getIbondedsumqty()
	{
		return ibondedsumqty;
	}

	public void setIbondedsumqty(Double ibondedsumqty)
	{
		this.ibondedsumqty = ibondedsumqty;
	}

	public Long getProductinids()
	{
		return productinids;
	}

	public void setProductinids(Long productinids)
	{
		this.productinids = productinids;
	}

	public Long getIorderdid()
	{
		return iorderdid;
	}

	public void setIorderdid(Long iorderdid)
	{
		this.iorderdid = iorderdid;
	}

	public String getIordertype()
	{
		return iordertype;
	}

	public void setIordertype(String iordertype)
	{
		this.iordertype = iordertype;
	}

	public String getIordercode()
	{
		return iordercode;
	}

	public void setIordercode(String iordercode)
	{
		this.iordercode = iordercode;
	}

	public Long getIorderseq()
	{
		return iorderseq;
	}

	public void setIorderseq(Long iorderseq)
	{
		this.iorderseq = iorderseq;
	}

	public String getIsodid()
	{
		return isodid;
	}

	public void setIsodid(String isodid)
	{
		this.isodid = isodid;
	}

	public String getIsotype()
	{
		return isotype;
	}

	public void setIsotype(String isotype)
	{
		this.isotype = isotype;
	}

	public String getCsocode()
	{
		return csocode;
	}

	public void setCsocode(String csocode)
	{
		this.csocode = csocode;
	}

	public Long getIsoseq()
	{
		return isoseq;
	}

	public void setIsoseq(Long isoseq)
	{
		this.isoseq = isoseq;
	}

	public String getIpesodid()
	{
		return ipesodid;
	}

	public void setIpesodid(String ipesodid)
	{
		this.ipesodid = ipesodid;
	}

	public String getIpesotype()
	{
		return ipesotype;
	}

	public void setIpesotype(String ipesotype)
	{
		this.ipesotype = ipesotype;
	}

	public String getCpesocode()
	{
		return cpesocode;
	}

	public void setCpesocode(String cpesocode)
	{
		this.cpesocode = cpesocode;
	}

	public Long getIpesoseq()
	{
		return ipesoseq;
	}

	public void setIpesoseq(Long ipesoseq)
	{
		this.ipesoseq = ipesoseq;
	}

	public Double getCbatchproperty1()
	{
		return cbatchproperty1;
	}

	public void setCbatchproperty1(Double cbatchproperty1)
	{
		this.cbatchproperty1 = cbatchproperty1;
	}

	public Double getCbatchproperty2()
	{
		return cbatchproperty2;
	}

	public void setCbatchproperty2(Double cbatchproperty2)
	{
		this.cbatchproperty2 = cbatchproperty2;
	}

	public Double getCbatchproperty3()
	{
		return cbatchproperty3;
	}

	public void setCbatchproperty3(Double cbatchproperty3)
	{
		this.cbatchproperty3 = cbatchproperty3;
	}

	public Double getCbatchproperty4()
	{
		return cbatchproperty4;
	}

	public void setCbatchproperty4(Double cbatchproperty4)
	{
		this.cbatchproperty4 = cbatchproperty4;
	}

	public Double getCbatchproperty5()
	{
		return cbatchproperty5;
	}

	public void setCbatchproperty5(Double cbatchproperty5)
	{
		this.cbatchproperty5 = cbatchproperty5;
	}

	public String getCbatchproperty6()
	{
		return cbatchproperty6;
	}

	public void setCbatchproperty6(String cbatchproperty6)
	{
		this.cbatchproperty6 = cbatchproperty6;
	}

	public String getCbatchproperty7()
	{
		return cbatchproperty7;
	}

	public void setCbatchproperty7(String cbatchproperty7)
	{
		this.cbatchproperty7 = cbatchproperty7;
	}

	public String getCbatchproperty8()
	{
		return cbatchproperty8;
	}

	public void setCbatchproperty8(String cbatchproperty8)
	{
		this.cbatchproperty8 = cbatchproperty8;
	}

	public String getCbatchproperty9()
	{
		return cbatchproperty9;
	}

	public void setCbatchproperty9(String cbatchproperty9)
	{
		this.cbatchproperty9 = cbatchproperty9;
	}

	public Timestamp getCbatchproperty10()
	{
		return cbatchproperty10;
	}

	public void setCbatchproperty10(Timestamp cbatchproperty10)
	{
		this.cbatchproperty10 = cbatchproperty10;
	}

	public String getCbmemo()
	{
		return cbmemo;
	}

	public void setCbmemo(String cbmemo)
	{
		this.cbmemo = cbmemo;
	}

	public Long getApplydid()
	{
		return applydid;
	}

	public void setApplydid(Long applydid)
	{
		this.applydid = applydid;
	}

	public String getApplycode()
	{
		return applycode;
	}

	public void setApplycode(String applycode)
	{
		this.applycode = applycode;
	}

	public Long getIrowno()
	{
		return irowno;
	}

	public void setIrowno(Long irowno)
	{
		this.irowno = irowno;
	}

	public String getStrowguid()
	{
		return strowguid;
	}

	public void setStrowguid(String strowguid)
	{
		this.strowguid = strowguid;
	}

	public String getCservicecode()
	{
		return cservicecode;
	}

	public void setCservicecode(String cservicecode)
	{
		this.cservicecode = cservicecode;
	}

	public String getRowufts()
	{
		return rowufts;
	}

	public void setRowufts(String rowufts)
	{
		this.rowufts = rowufts;
	}

	public Double getIpreuseqty()
	{
		return ipreuseqty;
	}

	public void setIpreuseqty(Double ipreuseqty)
	{
		this.ipreuseqty = ipreuseqty;
	}

	public Double getIpreuseinum()
	{
		return ipreuseinum;
	}

	public void setIpreuseinum(Double ipreuseinum)
	{
		this.ipreuseinum = ipreuseinum;
	}

	public Long getBsupersede()
	{
		return bsupersede;
	}

	public void setBsupersede(Long bsupersede)
	{
		this.bsupersede = bsupersede;
	}

	public Double getIsupersedeqty()
	{
		return isupersedeqty;
	}

	public void setIsupersedeqty(Double isupersedeqty)
	{
		this.isupersedeqty = isupersedeqty;
	}

	public Long getIsupersedempoids()
	{
		return isupersedempoids;
	}

	public void setIsupersedempoids(Long isupersedempoids)
	{
		this.isupersedempoids = isupersedempoids;
	}

	public String getImoallocatesubid()
	{
		return imoallocatesubid;
	}

	public void setImoallocatesubid(String imoallocatesubid)
	{
		this.imoallocatesubid = imoallocatesubid;
	}

	public Long getCinvoucherlineid()
	{
		return cinvoucherlineid;
	}

	public void setCinvoucherlineid(Long cinvoucherlineid)
	{
		this.cinvoucherlineid = cinvoucherlineid;
	}

	public String getCinvouchercode()
	{
		return cinvouchercode;
	}

	public void setCinvouchercode(String cinvouchercode)
	{
		this.cinvouchercode = cinvouchercode;
	}

	public String getCinvouchertype()
	{
		return cinvouchertype;
	}

	public void setCinvouchertype(String cinvouchertype)
	{
		this.cinvouchertype = cinvouchertype;
	}

	public String getCbsysbarcode()
	{
		return cbsysbarcode;
	}

	public void setCbsysbarcode(String cbsysbarcode)
	{
		this.cbsysbarcode = cbsysbarcode;
	}

	public String getCsourcemocode()
	{
		return csourcemocode;
	}

	public void setCsourcemocode(String csourcemocode)
	{
		this.csourcemocode = csourcemocode;
	}

	public Long getIsourcemodetailsid()
	{
		return isourcemodetailsid;
	}

	public void setIsourcemodetailsid(Long isourcemodetailsid)
	{
		this.isourcemodetailsid = isourcemodetailsid;
	}

	public String getCplanlotcode()
	{
		return cplanlotcode;
	}

	public void setCplanlotcode(String cplanlotcode)
	{
		this.cplanlotcode = cplanlotcode;
	}

	public Long getBcanreplace()
	{
		return bcanreplace;
	}

	public void setBcanreplace(Long bcanreplace)
	{
		this.bcanreplace = bcanreplace;
	}

	public Long getIposflag()
	{
		return iposflag;
	}

	public void setIposflag(Long iposflag)
	{
		this.iposflag = iposflag;
	}

	public String getCinvname()
	{
		return cinvname;
	}

	public void setCinvname(String cinvname)
	{
		this.cinvname = cinvname;
	}

	public String getCinvstd()
	{
		return cinvstd;
	}

	public void setCinvstd(String cinvstd)
	{
		this.cinvstd = cinvstd;
	}

	public String getCcomunitname()
	{
		return ccomunitname;
	}

	public void setCcomunitname(String ccomunitname)
	{
		this.ccomunitname = ccomunitname;
	}

	public String getCcode()
	{
		return ccode;
	}

	public void setCcode(String ccode)
	{
		this.ccode = ccode;
	}

	public String getCstcomunitname()
	{
		return cstcomunitname;
	}

	public void setCstcomunitname(String cstcomunitname)
	{
		this.cstcomunitname = cstcomunitname;
	}

	@Override
	public String toString()
	{
		return JSON.toJSONString(this);
	}
}
