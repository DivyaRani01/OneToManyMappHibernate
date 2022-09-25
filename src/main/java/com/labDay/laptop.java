/* @Divya
 * Ilustrating one to many mapping in database using hibernate framework
 * One student -> Many laptop
 */


package com.labDay;
//importing required packages as per requirement
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class laptop {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lapId;
	private String lapName;
	private String lapOs;
	private int lapRAM;
	
	public int getLapId() {
		return lapId;
	}
	//generating getters and setters
	public void setLapId(int lapId) {
		this.lapId = lapId;
	}
	public String getLapName() {
		return lapName;
	}
	public void setLapName(String lapName) {
		this.lapName = lapName;
	}
	public String getLapOs() {
		return lapOs;
	}
	public void setLapOs(String lapOs) {
		this.lapOs = lapOs;
	}
	public int getLapRAM() {
		return lapRAM;
	}
	public void setLapRAM(int lapRAM) {
		this.lapRAM = lapRAM;
	}
	//creating a method to string
	@Override
	public String toString() {
		return "student [lapId=" + lapId + ", lapName=" + lapName + ", lapOs=" + lapOs + ", lapRAM=" + lapRAM + "]";
	}
	
	

}
