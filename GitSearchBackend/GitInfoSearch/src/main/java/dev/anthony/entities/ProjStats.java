package dev.anthony.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Stat")
public class ProjStats {

	
	// Fields Mapped to the Table Columns in the DataBase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="S_ID")
	private int sid;
	
	@Column(name ="Repo_ID")
	private int repoId;
	
	@Column(name ="Name")
	private String name;
	
	@Column( name ="url")
	private String url;
	
	@Column(name ="CREATEDdate")
	private String createdDate;
	
	@Column(name ="LASTPUSHdate")
	private String lastPushDate;
	
	@Column(name ="DESCRIPTION")
	private String description;
	
	@Column(name="NumOFstars")
	private int numOfStars;

	// Default Costructor
	public ProjStats() {
		super();
	}
	//Constructor
	public ProjStats(int sid, int repoId, String name, String url, String createdDate, String lastPushDate,
			String description, int numOfStars) {
		super();
		this.sid = sid;
		this.repoId = repoId;
		this.name = name;
		this.url = url;
		this.createdDate = createdDate;
		this.lastPushDate = lastPushDate;
		this.description = description;
		this.numOfStars = numOfStars;
	}
	
	//Getters and Setters
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getRepoId() {
		return repoId;
	}
	public void setRepoId(int repoId) {
		this.repoId = repoId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getLastPushDate() {
		return lastPushDate;
	}
	public void setLastPushDate(String lastPushDate) {
		this.lastPushDate = lastPushDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNumOfStars() {
		return numOfStars;
	}
	public void setNumOfStars(int numOfStars) {
		this.numOfStars = numOfStars;
	}
	
	@Override
	public String toString() {
		return "ProjStats [sid=" + sid + ", repoId=" + repoId + ", name=" + name + ", url=" + url + ", createdDate="
				+ createdDate + ", lastPushDate=" + lastPushDate + ", description=" + description + ", numOfStars="
				+ numOfStars + "]";
	}
	
	
	
	
	
	
}
