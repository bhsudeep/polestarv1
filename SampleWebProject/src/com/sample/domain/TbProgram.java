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
 * TbProgram generated by hbm2java
 */
@Entity
@Table(name = "TB_PROGRAM", schema = "dbo", catalog = "STAB_DEV")
public class TbProgram implements java.io.Serializable {

	private long pgmIdPk;
	private TbUniversity tbUniversity;
	private String pgmStrName;
	private String pgmStrDescription;
	private Set<TbUserProgram> tbUserPrograms = new HashSet<TbUserProgram>(0);
	private Set<TbTravelPlan> tbTravelPlans = new HashSet<TbTravelPlan>(0);
	private Set<TbFaq> tbFaqs = new HashSet<TbFaq>(0);
	private Set<TbLocationImages> tbLocationImageses = new HashSet<TbLocationImages>(
			0);

	public TbProgram() {
	}

	public TbProgram(long pgmIdPk) {
		this.pgmIdPk = pgmIdPk;
	}

	public TbProgram(long pgmIdPk, TbUniversity tbUniversity,
			String pgmStrName, String pgmStrDescription,
			Set<TbUserProgram> tbUserPrograms, Set<TbTravelPlan> tbTravelPlans,
			Set<TbFaq> tbFaqs, Set<TbLocationImages> tbLocationImageses) {
		this.pgmIdPk = pgmIdPk;
		this.tbUniversity = tbUniversity;
		this.pgmStrName = pgmStrName;
		this.pgmStrDescription = pgmStrDescription;
		this.tbUserPrograms = tbUserPrograms;
		this.tbTravelPlans = tbTravelPlans;
		this.tbFaqs = tbFaqs;
		this.tbLocationImageses = tbLocationImageses;
	}

	@Id
	@Column(name = "PGM_ID_PK", unique = true, nullable = false)
	public long getPgmIdPk() {
		return this.pgmIdPk;
	}

	public void setPgmIdPk(long pgmIdPk) {
		this.pgmIdPk = pgmIdPk;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PMG_UNI_ID_FK")
	public TbUniversity getTbUniversity() {
		return this.tbUniversity;
	}

	public void setTbUniversity(TbUniversity tbUniversity) {
		this.tbUniversity = tbUniversity;
	}

	@Column(name = "PGM_STR_NAME", length = 100)
	public String getPgmStrName() {
		return this.pgmStrName;
	}

	public void setPgmStrName(String pgmStrName) {
		this.pgmStrName = pgmStrName;
	}

	@Column(name = "PGM_STR_DESCRIPTION", length = 200)
	public String getPgmStrDescription() {
		return this.pgmStrDescription;
	}

	public void setPgmStrDescription(String pgmStrDescription) {
		this.pgmStrDescription = pgmStrDescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbProgram")
	public Set<TbUserProgram> getTbUserPrograms() {
		return this.tbUserPrograms;
	}

	public void setTbUserPrograms(Set<TbUserProgram> tbUserPrograms) {
		this.tbUserPrograms = tbUserPrograms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbProgram")
	public Set<TbTravelPlan> getTbTravelPlans() {
		return this.tbTravelPlans;
	}

	public void setTbTravelPlans(Set<TbTravelPlan> tbTravelPlans) {
		this.tbTravelPlans = tbTravelPlans;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbProgram")
	public Set<TbFaq> getTbFaqs() {
		return this.tbFaqs;
	}

	public void setTbFaqs(Set<TbFaq> tbFaqs) {
		this.tbFaqs = tbFaqs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbProgram")
	public Set<TbLocationImages> getTbLocationImageses() {
		return this.tbLocationImageses;
	}

	public void setTbLocationImageses(Set<TbLocationImages> tbLocationImageses) {
		this.tbLocationImageses = tbLocationImageses;
	}

}
