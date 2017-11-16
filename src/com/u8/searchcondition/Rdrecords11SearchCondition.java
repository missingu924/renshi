package com.u8.searchcondition;

import com.wuyg.common.obj.BaseSearchCondition;
import java.sql.Timestamp;

public class Rdrecords11SearchCondition extends BaseSearchCondition
{
	private Long id_min;
	private Long id_max;
	private Double inum_min;
	private Double inum_max;
	private Double iquantity_min;
	private Double iquantity_max;
	private Double iunitcost_min;
	private Double iunitcost_max;
	private Double iprice_min;
	private Double iprice_max;
	private Double iaprice_min;
	private Double iaprice_max;
	private Double ipunitcost_min;
	private Double ipunitcost_max;
	private Double ipprice_min;
	private Double ipprice_max;
	private Long cvouchcode_min;
	private Long cvouchcode_max;
	private Double isoutquantity_min;
	private Double isoutquantity_max;
	private Double isoutnum_min;
	private Double isoutnum_max;
	private Long coutvouchid_min;
	private Long coutvouchid_max;
	private Double isredoutquantity_min;
	private Double isredoutquantity_max;
	private Double isredoutnum_min;
	private Double isredoutnum_max;
	private Double isquantity_min;
	private Double isquantity_max;
	private Double isnum_min;
	private Double isnum_max;
	private Double ifnum_min;
	private Double ifnum_max;
	private Double ifquantity_min;
	private Double ifquantity_max;
	private Timestamp dvdate_min;
	private Timestamp dvdate_max;
	private Long itrids_min;
	private Long itrids_max;
	private Double cdefine26_min;
	private Double cdefine26_max;
	private Double cdefine27_min;
	private Double cdefine27_max;
	private Double inquantity_min;
	private Double inquantity_max;
	private Double innum_min;
	private Double innum_max;
	private Timestamp dmadedate_min;
	private Timestamp dmadedate_max;
	private Long imassdate_min;
	private Long imassdate_max;
	private Long cdefine34_min;
	private Long cdefine34_max;
	private Long cdefine35_min;
	private Long cdefine35_max;
	private Timestamp cdefine36_min;
	private Timestamp cdefine36_max;
	private Timestamp cdefine37_min;
	private Timestamp cdefine37_max;
	private Long impoids_min;
	private Long impoids_max;
	private Long icheckids_min;
	private Long icheckids_max;
	private Long icheckidbaks_min;
	private Long icheckidbaks_max;
	private Long irejectids_min;
	private Long irejectids_max;
	private Timestamp dcheckdate_min;
	private Timestamp dcheckdate_max;
	private Long cmassunit_min;
	private Long cmassunit_max;
	private Double imaterialfee_min;
	private Double imaterialfee_max;
	private Double iprocesscost_min;
	private Double iprocesscost_max;
	private Double iprocessfee_min;
	private Double iprocessfee_max;
	private Timestamp dmsdate_min;
	private Timestamp dmsdate_max;
	private Double ismaterialfee_min;
	private Double ismaterialfee_max;
	private Double isprocessfee_min;
	private Double isprocessfee_max;
	private Long iomodid_min;
	private Long iomodid_max;
	private Long bfilled_min;
	private Long bfilled_max;
	private Long iomomid_min;
	private Long iomomid_max;
	private Long irsrowno_min;
	private Long irsrowno_max;
	private Long ioritrackid_min;
	private Long ioritrackid_max;
	private Timestamp dbkeepdate_min;
	private Timestamp dbkeepdate_max;
	private Double ivmisettlequantity_min;
	private Double ivmisettlequantity_max;
	private Double ivmisettlenum_min;
	private Double ivmisettlenum_max;
	private Long iinvsncount_min;
	private Long iinvsncount_max;
	private Long imaids_min;
	private Long imaids_max;
	private Double iinvexchrate_min;
	private Double iinvexchrate_max;
	private Long imoseq_min;
	private Long imoseq_max;
	private Long iexpiratdatecalcu_min;
	private Long iexpiratdatecalcu_max;
	private Timestamp dexpirationdate_min;
	private Timestamp dexpirationdate_max;
	private Double ibondedsumqty_min;
	private Double ibondedsumqty_max;
	private Long productinids_min;
	private Long productinids_max;
	private Long iorderdid_min;
	private Long iorderdid_max;
	private Long iorderseq_min;
	private Long iorderseq_max;
	private Long isoseq_min;
	private Long isoseq_max;
	private Long ipesoseq_min;
	private Long ipesoseq_max;
	private Double cbatchproperty1_min;
	private Double cbatchproperty1_max;
	private Double cbatchproperty2_min;
	private Double cbatchproperty2_max;
	private Double cbatchproperty3_min;
	private Double cbatchproperty3_max;
	private Double cbatchproperty4_min;
	private Double cbatchproperty4_max;
	private Double cbatchproperty5_min;
	private Double cbatchproperty5_max;
	private Timestamp cbatchproperty10_min;
	private Timestamp cbatchproperty10_max;
	private Long applydid_min;
	private Long applydid_max;
	private Long irowno_min;
	private Long irowno_max;
	private Double ipreuseqty_min;
	private Double ipreuseqty_max;
	private Double ipreuseinum_min;
	private Double ipreuseinum_max;
	private Long bsupersede_min;
	private Long bsupersede_max;
	private Double isupersedeqty_min;
	private Double isupersedeqty_max;
	private Long isupersedempoids_min;
	private Long isupersedempoids_max;
	private Long cinvoucherlineid_min;
	private Long cinvoucherlineid_max;
	private Long isourcemodetailsid_min;
	private Long isourcemodetailsid_max;
	private Long bcanreplace_min;
	private Long bcanreplace_max;
	private Long iposflag_min;
	private Long iposflag_max;

	public Long getId_min()
	{
		return id_min;
	}

	public void setId_min(Long id_min)
	{
		this.id_min = id_min;
	}

	public Long getId_max()
	{
		return id_max;
	}

	public void setId_max(Long id_max)
	{
		this.id_max = id_max;
	}

	public Double getInum_min()
	{
		return inum_min;
	}

	public void setInum_min(Double inum_min)
	{
		this.inum_min = inum_min;
	}

	public Double getInum_max()
	{
		return inum_max;
	}

	public void setInum_max(Double inum_max)
	{
		this.inum_max = inum_max;
	}

	public Double getIquantity_min()
	{
		return iquantity_min;
	}

	public void setIquantity_min(Double iquantity_min)
	{
		this.iquantity_min = iquantity_min;
	}

	public Double getIquantity_max()
	{
		return iquantity_max;
	}

	public void setIquantity_max(Double iquantity_max)
	{
		this.iquantity_max = iquantity_max;
	}

	public Double getIunitcost_min()
	{
		return iunitcost_min;
	}

	public void setIunitcost_min(Double iunitcost_min)
	{
		this.iunitcost_min = iunitcost_min;
	}

	public Double getIunitcost_max()
	{
		return iunitcost_max;
	}

	public void setIunitcost_max(Double iunitcost_max)
	{
		this.iunitcost_max = iunitcost_max;
	}

	public Double getIprice_min()
	{
		return iprice_min;
	}

	public void setIprice_min(Double iprice_min)
	{
		this.iprice_min = iprice_min;
	}

	public Double getIprice_max()
	{
		return iprice_max;
	}

	public void setIprice_max(Double iprice_max)
	{
		this.iprice_max = iprice_max;
	}

	public Double getIaprice_min()
	{
		return iaprice_min;
	}

	public void setIaprice_min(Double iaprice_min)
	{
		this.iaprice_min = iaprice_min;
	}

	public Double getIaprice_max()
	{
		return iaprice_max;
	}

	public void setIaprice_max(Double iaprice_max)
	{
		this.iaprice_max = iaprice_max;
	}

	public Double getIpunitcost_min()
	{
		return ipunitcost_min;
	}

	public void setIpunitcost_min(Double ipunitcost_min)
	{
		this.ipunitcost_min = ipunitcost_min;
	}

	public Double getIpunitcost_max()
	{
		return ipunitcost_max;
	}

	public void setIpunitcost_max(Double ipunitcost_max)
	{
		this.ipunitcost_max = ipunitcost_max;
	}

	public Double getIpprice_min()
	{
		return ipprice_min;
	}

	public void setIpprice_min(Double ipprice_min)
	{
		this.ipprice_min = ipprice_min;
	}

	public Double getIpprice_max()
	{
		return ipprice_max;
	}

	public void setIpprice_max(Double ipprice_max)
	{
		this.ipprice_max = ipprice_max;
	}

	public Long getCvouchcode_min()
	{
		return cvouchcode_min;
	}

	public void setCvouchcode_min(Long cvouchcode_min)
	{
		this.cvouchcode_min = cvouchcode_min;
	}

	public Long getCvouchcode_max()
	{
		return cvouchcode_max;
	}

	public void setCvouchcode_max(Long cvouchcode_max)
	{
		this.cvouchcode_max = cvouchcode_max;
	}

	public Double getIsoutquantity_min()
	{
		return isoutquantity_min;
	}

	public void setIsoutquantity_min(Double isoutquantity_min)
	{
		this.isoutquantity_min = isoutquantity_min;
	}

	public Double getIsoutquantity_max()
	{
		return isoutquantity_max;
	}

	public void setIsoutquantity_max(Double isoutquantity_max)
	{
		this.isoutquantity_max = isoutquantity_max;
	}

	public Double getIsoutnum_min()
	{
		return isoutnum_min;
	}

	public void setIsoutnum_min(Double isoutnum_min)
	{
		this.isoutnum_min = isoutnum_min;
	}

	public Double getIsoutnum_max()
	{
		return isoutnum_max;
	}

	public void setIsoutnum_max(Double isoutnum_max)
	{
		this.isoutnum_max = isoutnum_max;
	}

	public Long getCoutvouchid_min()
	{
		return coutvouchid_min;
	}

	public void setCoutvouchid_min(Long coutvouchid_min)
	{
		this.coutvouchid_min = coutvouchid_min;
	}

	public Long getCoutvouchid_max()
	{
		return coutvouchid_max;
	}

	public void setCoutvouchid_max(Long coutvouchid_max)
	{
		this.coutvouchid_max = coutvouchid_max;
	}

	public Double getIsredoutquantity_min()
	{
		return isredoutquantity_min;
	}

	public void setIsredoutquantity_min(Double isredoutquantity_min)
	{
		this.isredoutquantity_min = isredoutquantity_min;
	}

	public Double getIsredoutquantity_max()
	{
		return isredoutquantity_max;
	}

	public void setIsredoutquantity_max(Double isredoutquantity_max)
	{
		this.isredoutquantity_max = isredoutquantity_max;
	}

	public Double getIsredoutnum_min()
	{
		return isredoutnum_min;
	}

	public void setIsredoutnum_min(Double isredoutnum_min)
	{
		this.isredoutnum_min = isredoutnum_min;
	}

	public Double getIsredoutnum_max()
	{
		return isredoutnum_max;
	}

	public void setIsredoutnum_max(Double isredoutnum_max)
	{
		this.isredoutnum_max = isredoutnum_max;
	}

	public Double getIsquantity_min()
	{
		return isquantity_min;
	}

	public void setIsquantity_min(Double isquantity_min)
	{
		this.isquantity_min = isquantity_min;
	}

	public Double getIsquantity_max()
	{
		return isquantity_max;
	}

	public void setIsquantity_max(Double isquantity_max)
	{
		this.isquantity_max = isquantity_max;
	}

	public Double getIsnum_min()
	{
		return isnum_min;
	}

	public void setIsnum_min(Double isnum_min)
	{
		this.isnum_min = isnum_min;
	}

	public Double getIsnum_max()
	{
		return isnum_max;
	}

	public void setIsnum_max(Double isnum_max)
	{
		this.isnum_max = isnum_max;
	}

	public Double getIfnum_min()
	{
		return ifnum_min;
	}

	public void setIfnum_min(Double ifnum_min)
	{
		this.ifnum_min = ifnum_min;
	}

	public Double getIfnum_max()
	{
		return ifnum_max;
	}

	public void setIfnum_max(Double ifnum_max)
	{
		this.ifnum_max = ifnum_max;
	}

	public Double getIfquantity_min()
	{
		return ifquantity_min;
	}

	public void setIfquantity_min(Double ifquantity_min)
	{
		this.ifquantity_min = ifquantity_min;
	}

	public Double getIfquantity_max()
	{
		return ifquantity_max;
	}

	public void setIfquantity_max(Double ifquantity_max)
	{
		this.ifquantity_max = ifquantity_max;
	}

	public Timestamp getDvdate_min()
	{
		return dvdate_min;
	}

	public void setDvdate_min(Timestamp dvdate_min)
	{
		this.dvdate_min = dvdate_min;
	}

	public Timestamp getDvdate_max()
	{
		return dvdate_max;
	}

	public void setDvdate_max(Timestamp dvdate_max)
	{
		this.dvdate_max = dvdate_max;
	}

	public Long getItrids_min()
	{
		return itrids_min;
	}

	public void setItrids_min(Long itrids_min)
	{
		this.itrids_min = itrids_min;
	}

	public Long getItrids_max()
	{
		return itrids_max;
	}

	public void setItrids_max(Long itrids_max)
	{
		this.itrids_max = itrids_max;
	}

	public Double getCdefine26_min()
	{
		return cdefine26_min;
	}

	public void setCdefine26_min(Double cdefine26_min)
	{
		this.cdefine26_min = cdefine26_min;
	}

	public Double getCdefine26_max()
	{
		return cdefine26_max;
	}

	public void setCdefine26_max(Double cdefine26_max)
	{
		this.cdefine26_max = cdefine26_max;
	}

	public Double getCdefine27_min()
	{
		return cdefine27_min;
	}

	public void setCdefine27_min(Double cdefine27_min)
	{
		this.cdefine27_min = cdefine27_min;
	}

	public Double getCdefine27_max()
	{
		return cdefine27_max;
	}

	public void setCdefine27_max(Double cdefine27_max)
	{
		this.cdefine27_max = cdefine27_max;
	}

	public Double getInquantity_min()
	{
		return inquantity_min;
	}

	public void setInquantity_min(Double inquantity_min)
	{
		this.inquantity_min = inquantity_min;
	}

	public Double getInquantity_max()
	{
		return inquantity_max;
	}

	public void setInquantity_max(Double inquantity_max)
	{
		this.inquantity_max = inquantity_max;
	}

	public Double getInnum_min()
	{
		return innum_min;
	}

	public void setInnum_min(Double innum_min)
	{
		this.innum_min = innum_min;
	}

	public Double getInnum_max()
	{
		return innum_max;
	}

	public void setInnum_max(Double innum_max)
	{
		this.innum_max = innum_max;
	}

	public Timestamp getDmadedate_min()
	{
		return dmadedate_min;
	}

	public void setDmadedate_min(Timestamp dmadedate_min)
	{
		this.dmadedate_min = dmadedate_min;
	}

	public Timestamp getDmadedate_max()
	{
		return dmadedate_max;
	}

	public void setDmadedate_max(Timestamp dmadedate_max)
	{
		this.dmadedate_max = dmadedate_max;
	}

	public Long getImassdate_min()
	{
		return imassdate_min;
	}

	public void setImassdate_min(Long imassdate_min)
	{
		this.imassdate_min = imassdate_min;
	}

	public Long getImassdate_max()
	{
		return imassdate_max;
	}

	public void setImassdate_max(Long imassdate_max)
	{
		this.imassdate_max = imassdate_max;
	}

	public Long getCdefine34_min()
	{
		return cdefine34_min;
	}

	public void setCdefine34_min(Long cdefine34_min)
	{
		this.cdefine34_min = cdefine34_min;
	}

	public Long getCdefine34_max()
	{
		return cdefine34_max;
	}

	public void setCdefine34_max(Long cdefine34_max)
	{
		this.cdefine34_max = cdefine34_max;
	}

	public Long getCdefine35_min()
	{
		return cdefine35_min;
	}

	public void setCdefine35_min(Long cdefine35_min)
	{
		this.cdefine35_min = cdefine35_min;
	}

	public Long getCdefine35_max()
	{
		return cdefine35_max;
	}

	public void setCdefine35_max(Long cdefine35_max)
	{
		this.cdefine35_max = cdefine35_max;
	}

	public Timestamp getCdefine36_min()
	{
		return cdefine36_min;
	}

	public void setCdefine36_min(Timestamp cdefine36_min)
	{
		this.cdefine36_min = cdefine36_min;
	}

	public Timestamp getCdefine36_max()
	{
		return cdefine36_max;
	}

	public void setCdefine36_max(Timestamp cdefine36_max)
	{
		this.cdefine36_max = cdefine36_max;
	}

	public Timestamp getCdefine37_min()
	{
		return cdefine37_min;
	}

	public void setCdefine37_min(Timestamp cdefine37_min)
	{
		this.cdefine37_min = cdefine37_min;
	}

	public Timestamp getCdefine37_max()
	{
		return cdefine37_max;
	}

	public void setCdefine37_max(Timestamp cdefine37_max)
	{
		this.cdefine37_max = cdefine37_max;
	}

	public Long getImpoids_min()
	{
		return impoids_min;
	}

	public void setImpoids_min(Long impoids_min)
	{
		this.impoids_min = impoids_min;
	}

	public Long getImpoids_max()
	{
		return impoids_max;
	}

	public void setImpoids_max(Long impoids_max)
	{
		this.impoids_max = impoids_max;
	}

	public Long getIcheckids_min()
	{
		return icheckids_min;
	}

	public void setIcheckids_min(Long icheckids_min)
	{
		this.icheckids_min = icheckids_min;
	}

	public Long getIcheckids_max()
	{
		return icheckids_max;
	}

	public void setIcheckids_max(Long icheckids_max)
	{
		this.icheckids_max = icheckids_max;
	}

	public Long getIcheckidbaks_min()
	{
		return icheckidbaks_min;
	}

	public void setIcheckidbaks_min(Long icheckidbaks_min)
	{
		this.icheckidbaks_min = icheckidbaks_min;
	}

	public Long getIcheckidbaks_max()
	{
		return icheckidbaks_max;
	}

	public void setIcheckidbaks_max(Long icheckidbaks_max)
	{
		this.icheckidbaks_max = icheckidbaks_max;
	}

	public Long getIrejectids_min()
	{
		return irejectids_min;
	}

	public void setIrejectids_min(Long irejectids_min)
	{
		this.irejectids_min = irejectids_min;
	}

	public Long getIrejectids_max()
	{
		return irejectids_max;
	}

	public void setIrejectids_max(Long irejectids_max)
	{
		this.irejectids_max = irejectids_max;
	}

	public Timestamp getDcheckdate_min()
	{
		return dcheckdate_min;
	}

	public void setDcheckdate_min(Timestamp dcheckdate_min)
	{
		this.dcheckdate_min = dcheckdate_min;
	}

	public Timestamp getDcheckdate_max()
	{
		return dcheckdate_max;
	}

	public void setDcheckdate_max(Timestamp dcheckdate_max)
	{
		this.dcheckdate_max = dcheckdate_max;
	}

	public Long getCmassunit_min()
	{
		return cmassunit_min;
	}

	public void setCmassunit_min(Long cmassunit_min)
	{
		this.cmassunit_min = cmassunit_min;
	}

	public Long getCmassunit_max()
	{
		return cmassunit_max;
	}

	public void setCmassunit_max(Long cmassunit_max)
	{
		this.cmassunit_max = cmassunit_max;
	}

	public Double getImaterialfee_min()
	{
		return imaterialfee_min;
	}

	public void setImaterialfee_min(Double imaterialfee_min)
	{
		this.imaterialfee_min = imaterialfee_min;
	}

	public Double getImaterialfee_max()
	{
		return imaterialfee_max;
	}

	public void setImaterialfee_max(Double imaterialfee_max)
	{
		this.imaterialfee_max = imaterialfee_max;
	}

	public Double getIprocesscost_min()
	{
		return iprocesscost_min;
	}

	public void setIprocesscost_min(Double iprocesscost_min)
	{
		this.iprocesscost_min = iprocesscost_min;
	}

	public Double getIprocesscost_max()
	{
		return iprocesscost_max;
	}

	public void setIprocesscost_max(Double iprocesscost_max)
	{
		this.iprocesscost_max = iprocesscost_max;
	}

	public Double getIprocessfee_min()
	{
		return iprocessfee_min;
	}

	public void setIprocessfee_min(Double iprocessfee_min)
	{
		this.iprocessfee_min = iprocessfee_min;
	}

	public Double getIprocessfee_max()
	{
		return iprocessfee_max;
	}

	public void setIprocessfee_max(Double iprocessfee_max)
	{
		this.iprocessfee_max = iprocessfee_max;
	}

	public Timestamp getDmsdate_min()
	{
		return dmsdate_min;
	}

	public void setDmsdate_min(Timestamp dmsdate_min)
	{
		this.dmsdate_min = dmsdate_min;
	}

	public Timestamp getDmsdate_max()
	{
		return dmsdate_max;
	}

	public void setDmsdate_max(Timestamp dmsdate_max)
	{
		this.dmsdate_max = dmsdate_max;
	}

	public Double getIsmaterialfee_min()
	{
		return ismaterialfee_min;
	}

	public void setIsmaterialfee_min(Double ismaterialfee_min)
	{
		this.ismaterialfee_min = ismaterialfee_min;
	}

	public Double getIsmaterialfee_max()
	{
		return ismaterialfee_max;
	}

	public void setIsmaterialfee_max(Double ismaterialfee_max)
	{
		this.ismaterialfee_max = ismaterialfee_max;
	}

	public Double getIsprocessfee_min()
	{
		return isprocessfee_min;
	}

	public void setIsprocessfee_min(Double isprocessfee_min)
	{
		this.isprocessfee_min = isprocessfee_min;
	}

	public Double getIsprocessfee_max()
	{
		return isprocessfee_max;
	}

	public void setIsprocessfee_max(Double isprocessfee_max)
	{
		this.isprocessfee_max = isprocessfee_max;
	}

	public Long getIomodid_min()
	{
		return iomodid_min;
	}

	public void setIomodid_min(Long iomodid_min)
	{
		this.iomodid_min = iomodid_min;
	}

	public Long getIomodid_max()
	{
		return iomodid_max;
	}

	public void setIomodid_max(Long iomodid_max)
	{
		this.iomodid_max = iomodid_max;
	}

	public Long getBfilled_min()
	{
		return bfilled_min;
	}

	public void setBfilled_min(Long bfilled_min)
	{
		this.bfilled_min = bfilled_min;
	}

	public Long getBfilled_max()
	{
		return bfilled_max;
	}

	public void setBfilled_max(Long bfilled_max)
	{
		this.bfilled_max = bfilled_max;
	}

	public Long getIomomid_min()
	{
		return iomomid_min;
	}

	public void setIomomid_min(Long iomomid_min)
	{
		this.iomomid_min = iomomid_min;
	}

	public Long getIomomid_max()
	{
		return iomomid_max;
	}

	public void setIomomid_max(Long iomomid_max)
	{
		this.iomomid_max = iomomid_max;
	}

	public Long getIrsrowno_min()
	{
		return irsrowno_min;
	}

	public void setIrsrowno_min(Long irsrowno_min)
	{
		this.irsrowno_min = irsrowno_min;
	}

	public Long getIrsrowno_max()
	{
		return irsrowno_max;
	}

	public void setIrsrowno_max(Long irsrowno_max)
	{
		this.irsrowno_max = irsrowno_max;
	}

	public Long getIoritrackid_min()
	{
		return ioritrackid_min;
	}

	public void setIoritrackid_min(Long ioritrackid_min)
	{
		this.ioritrackid_min = ioritrackid_min;
	}

	public Long getIoritrackid_max()
	{
		return ioritrackid_max;
	}

	public void setIoritrackid_max(Long ioritrackid_max)
	{
		this.ioritrackid_max = ioritrackid_max;
	}

	public Timestamp getDbkeepdate_min()
	{
		return dbkeepdate_min;
	}

	public void setDbkeepdate_min(Timestamp dbkeepdate_min)
	{
		this.dbkeepdate_min = dbkeepdate_min;
	}

	public Timestamp getDbkeepdate_max()
	{
		return dbkeepdate_max;
	}

	public void setDbkeepdate_max(Timestamp dbkeepdate_max)
	{
		this.dbkeepdate_max = dbkeepdate_max;
	}

	public Double getIvmisettlequantity_min()
	{
		return ivmisettlequantity_min;
	}

	public void setIvmisettlequantity_min(Double ivmisettlequantity_min)
	{
		this.ivmisettlequantity_min = ivmisettlequantity_min;
	}

	public Double getIvmisettlequantity_max()
	{
		return ivmisettlequantity_max;
	}

	public void setIvmisettlequantity_max(Double ivmisettlequantity_max)
	{
		this.ivmisettlequantity_max = ivmisettlequantity_max;
	}

	public Double getIvmisettlenum_min()
	{
		return ivmisettlenum_min;
	}

	public void setIvmisettlenum_min(Double ivmisettlenum_min)
	{
		this.ivmisettlenum_min = ivmisettlenum_min;
	}

	public Double getIvmisettlenum_max()
	{
		return ivmisettlenum_max;
	}

	public void setIvmisettlenum_max(Double ivmisettlenum_max)
	{
		this.ivmisettlenum_max = ivmisettlenum_max;
	}

	public Long getIinvsncount_min()
	{
		return iinvsncount_min;
	}

	public void setIinvsncount_min(Long iinvsncount_min)
	{
		this.iinvsncount_min = iinvsncount_min;
	}

	public Long getIinvsncount_max()
	{
		return iinvsncount_max;
	}

	public void setIinvsncount_max(Long iinvsncount_max)
	{
		this.iinvsncount_max = iinvsncount_max;
	}

	public Long getImaids_min()
	{
		return imaids_min;
	}

	public void setImaids_min(Long imaids_min)
	{
		this.imaids_min = imaids_min;
	}

	public Long getImaids_max()
	{
		return imaids_max;
	}

	public void setImaids_max(Long imaids_max)
	{
		this.imaids_max = imaids_max;
	}

	public Double getIinvexchrate_min()
	{
		return iinvexchrate_min;
	}

	public void setIinvexchrate_min(Double iinvexchrate_min)
	{
		this.iinvexchrate_min = iinvexchrate_min;
	}

	public Double getIinvexchrate_max()
	{
		return iinvexchrate_max;
	}

	public void setIinvexchrate_max(Double iinvexchrate_max)
	{
		this.iinvexchrate_max = iinvexchrate_max;
	}

	public Long getImoseq_min()
	{
		return imoseq_min;
	}

	public void setImoseq_min(Long imoseq_min)
	{
		this.imoseq_min = imoseq_min;
	}

	public Long getImoseq_max()
	{
		return imoseq_max;
	}

	public void setImoseq_max(Long imoseq_max)
	{
		this.imoseq_max = imoseq_max;
	}

	public Long getIexpiratdatecalcu_min()
	{
		return iexpiratdatecalcu_min;
	}

	public void setIexpiratdatecalcu_min(Long iexpiratdatecalcu_min)
	{
		this.iexpiratdatecalcu_min = iexpiratdatecalcu_min;
	}

	public Long getIexpiratdatecalcu_max()
	{
		return iexpiratdatecalcu_max;
	}

	public void setIexpiratdatecalcu_max(Long iexpiratdatecalcu_max)
	{
		this.iexpiratdatecalcu_max = iexpiratdatecalcu_max;
	}

	public Timestamp getDexpirationdate_min()
	{
		return dexpirationdate_min;
	}

	public void setDexpirationdate_min(Timestamp dexpirationdate_min)
	{
		this.dexpirationdate_min = dexpirationdate_min;
	}

	public Timestamp getDexpirationdate_max()
	{
		return dexpirationdate_max;
	}

	public void setDexpirationdate_max(Timestamp dexpirationdate_max)
	{
		this.dexpirationdate_max = dexpirationdate_max;
	}

	public Double getIbondedsumqty_min()
	{
		return ibondedsumqty_min;
	}

	public void setIbondedsumqty_min(Double ibondedsumqty_min)
	{
		this.ibondedsumqty_min = ibondedsumqty_min;
	}

	public Double getIbondedsumqty_max()
	{
		return ibondedsumqty_max;
	}

	public void setIbondedsumqty_max(Double ibondedsumqty_max)
	{
		this.ibondedsumqty_max = ibondedsumqty_max;
	}

	public Long getProductinids_min()
	{
		return productinids_min;
	}

	public void setProductinids_min(Long productinids_min)
	{
		this.productinids_min = productinids_min;
	}

	public Long getProductinids_max()
	{
		return productinids_max;
	}

	public void setProductinids_max(Long productinids_max)
	{
		this.productinids_max = productinids_max;
	}

	public Long getIorderdid_min()
	{
		return iorderdid_min;
	}

	public void setIorderdid_min(Long iorderdid_min)
	{
		this.iorderdid_min = iorderdid_min;
	}

	public Long getIorderdid_max()
	{
		return iorderdid_max;
	}

	public void setIorderdid_max(Long iorderdid_max)
	{
		this.iorderdid_max = iorderdid_max;
	}

	public Long getIorderseq_min()
	{
		return iorderseq_min;
	}

	public void setIorderseq_min(Long iorderseq_min)
	{
		this.iorderseq_min = iorderseq_min;
	}

	public Long getIorderseq_max()
	{
		return iorderseq_max;
	}

	public void setIorderseq_max(Long iorderseq_max)
	{
		this.iorderseq_max = iorderseq_max;
	}

	public Long getIsoseq_min()
	{
		return isoseq_min;
	}

	public void setIsoseq_min(Long isoseq_min)
	{
		this.isoseq_min = isoseq_min;
	}

	public Long getIsoseq_max()
	{
		return isoseq_max;
	}

	public void setIsoseq_max(Long isoseq_max)
	{
		this.isoseq_max = isoseq_max;
	}

	public Long getIpesoseq_min()
	{
		return ipesoseq_min;
	}

	public void setIpesoseq_min(Long ipesoseq_min)
	{
		this.ipesoseq_min = ipesoseq_min;
	}

	public Long getIpesoseq_max()
	{
		return ipesoseq_max;
	}

	public void setIpesoseq_max(Long ipesoseq_max)
	{
		this.ipesoseq_max = ipesoseq_max;
	}

	public Double getCbatchproperty1_min()
	{
		return cbatchproperty1_min;
	}

	public void setCbatchproperty1_min(Double cbatchproperty1_min)
	{
		this.cbatchproperty1_min = cbatchproperty1_min;
	}

	public Double getCbatchproperty1_max()
	{
		return cbatchproperty1_max;
	}

	public void setCbatchproperty1_max(Double cbatchproperty1_max)
	{
		this.cbatchproperty1_max = cbatchproperty1_max;
	}

	public Double getCbatchproperty2_min()
	{
		return cbatchproperty2_min;
	}

	public void setCbatchproperty2_min(Double cbatchproperty2_min)
	{
		this.cbatchproperty2_min = cbatchproperty2_min;
	}

	public Double getCbatchproperty2_max()
	{
		return cbatchproperty2_max;
	}

	public void setCbatchproperty2_max(Double cbatchproperty2_max)
	{
		this.cbatchproperty2_max = cbatchproperty2_max;
	}

	public Double getCbatchproperty3_min()
	{
		return cbatchproperty3_min;
	}

	public void setCbatchproperty3_min(Double cbatchproperty3_min)
	{
		this.cbatchproperty3_min = cbatchproperty3_min;
	}

	public Double getCbatchproperty3_max()
	{
		return cbatchproperty3_max;
	}

	public void setCbatchproperty3_max(Double cbatchproperty3_max)
	{
		this.cbatchproperty3_max = cbatchproperty3_max;
	}

	public Double getCbatchproperty4_min()
	{
		return cbatchproperty4_min;
	}

	public void setCbatchproperty4_min(Double cbatchproperty4_min)
	{
		this.cbatchproperty4_min = cbatchproperty4_min;
	}

	public Double getCbatchproperty4_max()
	{
		return cbatchproperty4_max;
	}

	public void setCbatchproperty4_max(Double cbatchproperty4_max)
	{
		this.cbatchproperty4_max = cbatchproperty4_max;
	}

	public Double getCbatchproperty5_min()
	{
		return cbatchproperty5_min;
	}

	public void setCbatchproperty5_min(Double cbatchproperty5_min)
	{
		this.cbatchproperty5_min = cbatchproperty5_min;
	}

	public Double getCbatchproperty5_max()
	{
		return cbatchproperty5_max;
	}

	public void setCbatchproperty5_max(Double cbatchproperty5_max)
	{
		this.cbatchproperty5_max = cbatchproperty5_max;
	}

	public Timestamp getCbatchproperty10_min()
	{
		return cbatchproperty10_min;
	}

	public void setCbatchproperty10_min(Timestamp cbatchproperty10_min)
	{
		this.cbatchproperty10_min = cbatchproperty10_min;
	}

	public Timestamp getCbatchproperty10_max()
	{
		return cbatchproperty10_max;
	}

	public void setCbatchproperty10_max(Timestamp cbatchproperty10_max)
	{
		this.cbatchproperty10_max = cbatchproperty10_max;
	}

	public Long getApplydid_min()
	{
		return applydid_min;
	}

	public void setApplydid_min(Long applydid_min)
	{
		this.applydid_min = applydid_min;
	}

	public Long getApplydid_max()
	{
		return applydid_max;
	}

	public void setApplydid_max(Long applydid_max)
	{
		this.applydid_max = applydid_max;
	}

	public Long getIrowno_min()
	{
		return irowno_min;
	}

	public void setIrowno_min(Long irowno_min)
	{
		this.irowno_min = irowno_min;
	}

	public Long getIrowno_max()
	{
		return irowno_max;
	}

	public void setIrowno_max(Long irowno_max)
	{
		this.irowno_max = irowno_max;
	}

	public Double getIpreuseqty_min()
	{
		return ipreuseqty_min;
	}

	public void setIpreuseqty_min(Double ipreuseqty_min)
	{
		this.ipreuseqty_min = ipreuseqty_min;
	}

	public Double getIpreuseqty_max()
	{
		return ipreuseqty_max;
	}

	public void setIpreuseqty_max(Double ipreuseqty_max)
	{
		this.ipreuseqty_max = ipreuseqty_max;
	}

	public Double getIpreuseinum_min()
	{
		return ipreuseinum_min;
	}

	public void setIpreuseinum_min(Double ipreuseinum_min)
	{
		this.ipreuseinum_min = ipreuseinum_min;
	}

	public Double getIpreuseinum_max()
	{
		return ipreuseinum_max;
	}

	public void setIpreuseinum_max(Double ipreuseinum_max)
	{
		this.ipreuseinum_max = ipreuseinum_max;
	}

	public Long getBsupersede_min()
	{
		return bsupersede_min;
	}

	public void setBsupersede_min(Long bsupersede_min)
	{
		this.bsupersede_min = bsupersede_min;
	}

	public Long getBsupersede_max()
	{
		return bsupersede_max;
	}

	public void setBsupersede_max(Long bsupersede_max)
	{
		this.bsupersede_max = bsupersede_max;
	}

	public Double getIsupersedeqty_min()
	{
		return isupersedeqty_min;
	}

	public void setIsupersedeqty_min(Double isupersedeqty_min)
	{
		this.isupersedeqty_min = isupersedeqty_min;
	}

	public Double getIsupersedeqty_max()
	{
		return isupersedeqty_max;
	}

	public void setIsupersedeqty_max(Double isupersedeqty_max)
	{
		this.isupersedeqty_max = isupersedeqty_max;
	}

	public Long getIsupersedempoids_min()
	{
		return isupersedempoids_min;
	}

	public void setIsupersedempoids_min(Long isupersedempoids_min)
	{
		this.isupersedempoids_min = isupersedempoids_min;
	}

	public Long getIsupersedempoids_max()
	{
		return isupersedempoids_max;
	}

	public void setIsupersedempoids_max(Long isupersedempoids_max)
	{
		this.isupersedempoids_max = isupersedempoids_max;
	}

	public Long getCinvoucherlineid_min()
	{
		return cinvoucherlineid_min;
	}

	public void setCinvoucherlineid_min(Long cinvoucherlineid_min)
	{
		this.cinvoucherlineid_min = cinvoucherlineid_min;
	}

	public Long getCinvoucherlineid_max()
	{
		return cinvoucherlineid_max;
	}

	public void setCinvoucherlineid_max(Long cinvoucherlineid_max)
	{
		this.cinvoucherlineid_max = cinvoucherlineid_max;
	}

	public Long getIsourcemodetailsid_min()
	{
		return isourcemodetailsid_min;
	}

	public void setIsourcemodetailsid_min(Long isourcemodetailsid_min)
	{
		this.isourcemodetailsid_min = isourcemodetailsid_min;
	}

	public Long getIsourcemodetailsid_max()
	{
		return isourcemodetailsid_max;
	}

	public void setIsourcemodetailsid_max(Long isourcemodetailsid_max)
	{
		this.isourcemodetailsid_max = isourcemodetailsid_max;
	}

	public Long getBcanreplace_min()
	{
		return bcanreplace_min;
	}

	public void setBcanreplace_min(Long bcanreplace_min)
	{
		this.bcanreplace_min = bcanreplace_min;
	}

	public Long getBcanreplace_max()
	{
		return bcanreplace_max;
	}

	public void setBcanreplace_max(Long bcanreplace_max)
	{
		this.bcanreplace_max = bcanreplace_max;
	}

	public Long getIposflag_min()
	{
		return iposflag_min;
	}

	public void setIposflag_min(Long iposflag_min)
	{
		this.iposflag_min = iposflag_min;
	}

	public Long getIposflag_max()
	{
		return iposflag_max;
	}

	public void setIposflag_max(Long iposflag_max)
	{
		this.iposflag_max = iposflag_max;
	}

}