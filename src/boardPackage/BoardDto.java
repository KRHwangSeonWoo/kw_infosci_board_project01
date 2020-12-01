package boardPackage;

import java.sql.Timestamp;

public class BoardDto {
	int bKey;
	int bId;
	String id;
	String bTitle;
	String bContent;
	Timestamp bDate;
	int bHit;
	String reId;
	String reContent;
	int reKey;
	

	public int getReKey() {
		return reKey;
	}

	public void setReKey(int reKey) {
		this.reKey = reKey;
	}

	public BoardDto(int bKey, int bId, String id, String bTitle, String bContent, Timestamp bDate, int bHit) {
		// TODO Auto-generated constructor stub
	this.bKey=bKey;
	this.bId=bId;
	this.id=id;
	this.bTitle=bTitle;
	this.bContent=bContent;
	this.bDate=bDate;
	this.bHit=bHit;
	
	}
	
	
	public BoardDto(int reKey, int bKey, String reId, String reContent, Timestamp bDate) {
		this.reKey=reKey;
		this.bKey=bKey;
		this.reId=reId;
		this.reContent=reContent;
		this.bDate=bDate;

	}
	
	public BoardDto() {
		
	}
	
	
	public int getbKey() {
		return bKey;
	}
	public void setbKey(int bKey) {
		this.bKey=bKey;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public Timestamp getbDate() {
		return bDate;
	}
	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	
	public String getReId() {
		return reId;
	}

	public void setReId(String reId) {
		this.reId = reId;
	}

	public String getReContent() {
		return reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}
	
	
	
}
