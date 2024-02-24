package in.priya.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer sid;
	private String name;
	private String email;
	private String ph_no;
	private Integer courseId;
	private Integer courseFee;
	private Integer paidFee;
	private Integer pendingFee;
	@CreationTimestamp
	@Column(name="createdDate", updatable = false)
	private LocalDate createdDate;
	@UpdateTimestamp
	@Column(name="updatedDate",insertable = false)
	private LocalDate updatedDate;
	
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPh_no() {
		return ph_no;
	}
	public void setPh_no(String ph_no) {
		this.ph_no = ph_no;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(Integer courseFee) {
		this.courseFee = courseFee;
	}
	public Integer getPaidFee() {
		return paidFee;
	}
	public void setPaidFee(Integer paidFee) {
		this.paidFee = paidFee;
	}
	public Integer getPendingFee() {
		return pendingFee;
	}
	public void setPendingFee(Integer pendingFee) {
		this.pendingFee = pendingFee;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	
	
	

}
