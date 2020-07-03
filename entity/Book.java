package entity;

import java.lang.*;

public class Book
{
	private String bookId;
	private String bookName;
	private String authorName;
	private String publishYear;
	
	public Book(){}
	public Book(String bookId,String bookName, String authorName,String publishYear)
	{
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.publishYear = publishYear;
	}
	
	public void setBookId(String bookId){this.bookId = bookId;}
	public void setBookName(String bookName){this.bookName = bookName;}
	public void setAuthorName(String authorName){this.authorName = authorName;}
	public void setPublishYear(String publishYear){this.publishYear = publishYear;}
	
	public String getBookId(){return bookId;}
	public String getBookName(){return bookName;}
	public String getAuthorName(){return authorName;}
	public String getPublishYear(){return publishYear;}
}