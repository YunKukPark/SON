package com.DAO;

public class messageVO {

	private String num;
	private String send_name;
	private String receive_name;
	private String content;
	private String date;

	public messageVO(String num, String send_name, String receive_name, String content, String date) {
		super();
		this.num = num;
		this.send_name = send_name;
		this.receive_name = receive_name;
		this.content = content;
		this.date = date;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getSend_name() {
		return send_name;
	}

	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}

	public String getReceive_name() {
		return receive_name;
	}

	public void setReceive_name(String receive_name) {
		this.receive_name = receive_name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
