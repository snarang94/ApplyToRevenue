package com.a2r.model;

import java.util.Date; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "arc_data")
@EntityListeners(AuditingEntityListener.class)
public class A2rEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ARC_Id")
	private long arcId;
	
	@Column(name = "Partner_Id", nullable = false)
	private String partnerId;
	
	@Column(name = "Solution_Id", nullable = false)
	private String solutionId;
	
	@Column(name = "Solution_Descr", nullable = false)
	private String solutionDescr;
	
	@Column(name = "ARC_Status", nullable = false)
	private String arcStatus;
	
	@Column(name = "created_at")
	@CreatedDate
	private Date createdAt;
	
	@Column(name = "created_by", nullable = false)
	@CreatedBy
	private String createdBy;
	
	@Column(name = "updated_at")
	@LastModifiedDate
	private Date updatedAt;
	
	@Column(name = "updated_by", nullable = false)
	@LastModifiedBy
	private String updatedBy;


	public long getId() {
		return arcId;
	}

	public void setId(long arcId) {
		this.arcId = arcId;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getSolutionId() {
		return solutionId;
	}

	public void setSolutionId(String solutionId) {
		this.solutionId = solutionId;
	}

	public String getSolutionDescr() {
		return solutionDescr;
	}

	public void setSolutionDescr(String solutionDescr) {
		this.solutionDescr = solutionDescr;
	}

	public String getArcStatus() {
		return arcStatus;
	}

	public void setArcStatus(String arcStatus) {
		this.arcStatus = arcStatus;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
	

}
