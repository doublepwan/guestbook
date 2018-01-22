package com.javaex.guestVO;

public class GuestBookVO {
	
	private int no;
	private String name;
	private String password;
	private String content;
	public GuestBookVO(int no, String name, String password, String content) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.content = content;
	}
	public GuestBookVO() {
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "GuestBookVO [no=" + no + ", name=" + name + ", password=" + password + ", content=" + content + "]";
	}
	

}
