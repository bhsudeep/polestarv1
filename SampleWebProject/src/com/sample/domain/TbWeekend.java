package com.sample.domain;
// default package
// Generated Feb 9, 2014 3:05:22 AM by Hibernate Tools 3.2.4.GA

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TbWeekend generated by hbm2java
 */
@Entity
@Table(name = "TB_WEEKEND", schema = "dbo", catalog = "STAB_DEV")
public class TbWeekend implements java.io.Serializable {

	private long wkdIdPk;
	private String wkdStrDesc;
	private String wkdDtStartDate;
	private String wkdDtEndDate;
	private Long wkdPrmIdFk;
	private Set<TbTravelPlan> tbTravelPlans = new HashSet<TbTravelPlan>(0);

	public TbWeekend() {
	}

	public TbWeekend(long wkdIdPk) {
		this.wkdIdPk = wkdIdPk;
	}

	public TbWeekend(long wkdIdPk, String wkdStrDesc, String wkdDtStartDate,
			String wkdDtEndDate, Long wkdPrmIdFk,
			Set<TbTravelPlan> tbTravelPlans) {
		this.wkdIdPk = wkdIdPk;
		this.wkdStrDesc = wkdStrDesc;
		this.wkdDtStartDate = wkdDtStartDate;
		this.wkdDtEndDate = wkdDtEndDate;
		this.wkdPrmIdFk = wkdPrmIdFk;
		this.tbTravelPlans = tbTravelPlans;
	}

	@Id
	@Column(name = "WKD_ID_PK", unique = true, nullable = false)
	public long getWkdIdPk() {
		return this.wkdIdPk;
	}

	public void setWkdIdPk(long wkdIdPk) {
		this.wkdIdPk = wkdIdPk;
	}

	@Column(name = "WKD_STR_DESC", length = 50)
	public String getWkdStrDesc() {
		return this.wkdStrDesc;
	}

	public void setWkdStrDesc(String wkdStrDesc) {
		this.wkdStrDesc = wkdStrDesc;
	}

	@Column(name = "WKD_DT_START_DATE", length = 10)
	public String getWkdDtStartDate() {
		return this.wkdDtStartDate;
	}

	public void setWkdDtStartDate(String wkdDtStartDate) {
		this.wkdDtStartDate = wkdDtStartDate;
	}

	@Column(name = "WKD_DT_END_DATE", length = 10)
	public String getWkdDtEndDate() {
		return this.wkdDtEndDate;
	}

	public void setWkdDtEndDate(String wkdDtEndDate) {
		this.wkdDtEndDate = wkdDtEndDate;
	}

	@Column(name = "WKD_PRM_ID_FK")
	public Long getWkdPrmIdFk() {
		return this.wkdPrmIdFk;
	}

	public void setWkdPrmIdFk(Long wkdPrmIdFk) {
		this.wkdPrmIdFk = wkdPrmIdFk;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbWeekend")
	public Set<TbTravelPlan> getTbTravelPlans() {
		return this.tbTravelPlans;
	}

	public void setTbTravelPlans(Set<TbTravelPlan> tbTravelPlans) {
		this.tbTravelPlans = tbTravelPlans;
	}

}