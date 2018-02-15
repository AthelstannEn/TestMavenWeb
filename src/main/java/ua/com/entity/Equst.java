package ua.com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name = "EQUATIONS")
public class Equst implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "LEADING_COEFICIENT")
	private Double leadinCoefficient;
	@Column(name = "SECOND_COEFICIENT")
	private Double secondCoefficient;
	@Column(name = "FREEE_MEMBER")
	private Double freeMember;
	@Column(name = "FIRST_VARIABLE")
	private Double firstVariable;
	@Column(name = "SECOND_VARIABLE")
	private Double secondVariable;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLeadinCoefficient() {
		return leadinCoefficient;
	}

	public void setLeadinCoefficient(Double leadinCoefficient) {
		this.leadinCoefficient = leadinCoefficient;
	}

	public Double getSecondCoefficient() {
		return secondCoefficient;
	}

	public void setSecondCoefficient(Double secondCoefficient) {
		this.secondCoefficient = secondCoefficient;
	}

	public Double getFreeMember() {
		return freeMember;
	}

	public void setFreeMember(Double freeMember) {
		this.freeMember = freeMember;
	}

	public Double getFirstVariable() {
		return firstVariable;
	}

	public void setFirstVariable(Double firstVariable) {
		this.firstVariable = firstVariable;
	}

	public Double getSecondVariable() {
		return secondVariable;
	}

	public void setSecondVariable(Double secondVariable) {
		this.secondVariable = secondVariable;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	
	

}