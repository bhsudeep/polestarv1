package com.sample.domain;
// default package
// Generated Feb 9, 2014 3:05:22 AM by Hibernate Tools 3.2.4.GA

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TbTravelPlan generated by hbm2java
 */
@Entity
@Table(name = "TB_TRAVEL_PLAN", schema = "dbo", catalog = "STAB_DEV")
public class TbTravelPlan implements java.io.Serializable {

	private long trpTravelId;
	private TbProgram tbProgram;
	private TbWeekend tbWeekend;
	private TbUser tbUser;
	private String trpStrMode;
	private String trpStrDeparture;
	private String trpStrReturn;
	private String trpStrNotes;
	private Set<TbTravelExpense> tbTravelExpenses = new HashSet<TbTravelExpense>(
			0);

	public TbTravelPlan() {
	}

	public TbTravelPlan(long trpTravelId) {
		this.trpTravelId = trpTravelId;
	}

	public TbTravelPlan(long trpTravelId, TbProgram tbProgram,
			TbWeekend tbWeekend, TbUser tbUser, String trpStrMode,
			String trpStrDeparture, String trpStrReturn, String trpStrNotes,
			Set<TbTravelExpense> tbTravelExpenses) {
		this.trpTravelId = trpTravelId;
		this.tbProgram = tbProgram;
		this.tbWeekend = tbWeekend;
		this.tbUser = tbUser;
		this.trpStrMode = trpStrMode;
		this.trpStrDeparture = trpStrDeparture;
		this.trpStrReturn = trpStrReturn;
		this.trpStrNotes = trpStrNotes;
		this.tbTravelExpenses = tbTravelExpenses;
	}

	@Id
	@Column(name = "TRP_TRAVEL_ID", unique = true, nullable = false)
	public long getTrpTravelId() {
		return this.trpTravelId;
	}

	public void setTrpTravelId(long trpTravelId) {
		this.trpTravelId = trpTravelId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRP_PGM_ID_FK")
	public TbProgram getTbProgram() {
		return this.tbProgram;
	}

	public void setTbProgram(TbProgram tbProgram) {
		this.tbProgram = tbProgram;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRP_WEEKEND_ID_FK")
	public TbWeekend getTbWeekend() {
		return this.tbWeekend;
	}

	public void setTbWeekend(TbWeekend tbWeekend) {
		this.tbWeekend = tbWeekend;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRP_USER_ID_FK")
	public TbUser getTbUser() {
		return this.tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	@Column(name = "TRP_STR_MODE", length = 100)
	public String getTrpStrMode() {
		return this.trpStrMode;
	}

	public void setTrpStrMode(String trpStrMode) {
		this.trpStrMode = trpStrMode;
	}

	@Column(name = "TRP_STR_DEPARTURE", length = 500)
	public String getTrpStrDeparture() {
		return this.trpStrDeparture;
	}

	public void setTrpStrDeparture(String trpStrDeparture) {
		this.trpStrDeparture = trpStrDeparture;
	}

	@Column(name = "TRP_STR_RETURN", length = 500)
	public String getTrpStrReturn() {
		return this.trpStrReturn;
	}

	public void setTrpStrReturn(String trpStrReturn) {
		this.trpStrReturn = trpStrReturn;
	}

	@Column(name = "TRP_STR_NOTES", length = 500)
	public String getTrpStrNotes() {
		return this.trpStrNotes;
	}

	public void setTrpStrNotes(String trpStrNotes) {
		this.trpStrNotes = trpStrNotes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbTravelPlan")
	public Set<TbTravelExpense> getTbTravelExpenses() {
		return this.tbTravelExpenses;
	}

	public void setTbTravelExpenses(Set<TbTravelExpense> tbTravelExpenses) {
		this.tbTravelExpenses = tbTravelExpenses;
	}

}
