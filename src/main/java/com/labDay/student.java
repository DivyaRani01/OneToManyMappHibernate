/* @Divya
 * Ilustrating one to many mapping in database using hibernate framework
 * One student -> Many laptop
 */

package com.labDay;
import java.util.List;

//importing required packages that is needed in our project.
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sdtId;
	private String sdtName;
	private String sdtDomain;
	private String sdtEmail;
	private String sdtContact;
	
	@OneToMany
	@JoinColumn(name="sdtId")
	private List<laptop> sdtLaptop;
	/**
	 * @return the sdtId
	 */
	public int getSdtId() {
		return sdtId;
	}
	/**
	 * @param sdtId the sdtId to set
	 */
	public void setSdtId(int sdtId) {
		this.sdtId = sdtId;
	}
	/**
	 * @return the sdtName
	 */
	public String getSdtName() {
		return sdtName;
	}
	/**
	 * @param sdtName the sdtName to set
	 */
	public void setSdtName(String sdtName) {
		this.sdtName = sdtName;
	}
	/**
	 * @return the sdtDoamin
	 */
	public String getSdtDomain() {
		return sdtDomain;
	}
	/**
	 * @param sdtDoamin the sdtDoamin to set
	 */
	public void setSdtDomain(String sdtDomain) {
		this.sdtDomain = sdtDomain;
	}
	/**
	 * @return the sdtEmail
	 */
	public String getSdtEmail() {
		return sdtEmail;
	}
	/**
	 * @param sdtEmail the sdtEmail to set
	 */
	public void  setSdtEmail(String sdtEmail) {
		this.sdtEmail = sdtEmail;
	}
	/**
	 * @return the sdtContact
	 */
	public String getSdtContact() {
		return sdtContact;
	}
	/**
	 * @param sdtContact the sdtContact to set
	 */
	public void setSdtContact(String sdtContact) {
		this.sdtContact = sdtContact;
	}
	public List<laptop> getSdtLaptop() {
		return sdtLaptop;
	}
	public void setSdtLaptop(List<laptop> sdtLaptop) {
		this.sdtLaptop = sdtLaptop;
	}
	@Override
	public String toString() {
		return "student [sdtId=" + sdtId + ", sdtName=" + sdtName + ", sdtDomain=" + sdtDomain + ", sdtEmail="
				+ sdtEmail + ", sdtContact=" + sdtContact + ",sdtLaptop ="+sdtLaptop+"]";
	}
	
}
