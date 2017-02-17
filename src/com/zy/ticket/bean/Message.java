package com.zy.ticket.bean;

public class Message {
	
	public boolean result;
	public String content;
	
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(boolean result, String content) {
		super();
		this.result = result;
		this.content = content;
	}
	public boolean isResult() {
		return result;
	}
	public String getcontent() {
		return content;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public void setcontent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Message [result=" + result + ", content=" + content + "]";
	}
	
}
