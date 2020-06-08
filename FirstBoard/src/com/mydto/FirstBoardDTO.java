package com.mydto;

public class FirstBoardDTO {
	private int no;
	private String title;
	private String content;
	private String date;
	private String writer;
	
	public FirstBoardDTO(int no, String title, String content, String date, String writer) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.date = date;
		this.writer = writer;
	}
	
	public FirstBoardDTO(String title, String content, String date, String writer) {
		this.title = title;
		this.content = content;
		this.date = date;
		this.writer = writer;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
}
