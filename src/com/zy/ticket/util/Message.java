package com.zy.ticket.util;

/***
 * 这是一个工具消息类，用来返回操作提示
 * result： 表示成功与否，返回true 或者 false
 * content： 表示返回消息内容
 * */
public class Message {
	
	public boolean result;
	public String content;
	
	
	public Message() {
		super();
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
