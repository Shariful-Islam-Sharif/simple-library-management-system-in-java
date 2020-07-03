package entity;

import java.lang.*;

public class Student
{
	 String studentId;
	 String studentName;
	 String studentPass;
	 String studentDept;
	
	public Student(){}
	public Student(String studentId,String studentName, String studentPass,String studentDept)
	{
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentPass = studentPass;
		this.studentDept = studentDept;
	}
	
	public void setStudentId(String studentId){this.studentId = studentId;}
	public void setStudentName(String studentName){this.studentName = studentName;}
	public void setStudentPass(String studentPass){this.studentPass = studentPass;}
	public void setStudentDept(String studentDept){this.studentDept = studentDept;}
	
	public String getStudentId(){return studentId;}
	public String getStudentName(){return studentName;}
	public String getStudentPass(){return studentPass;}
	public String getStudentDept(){return studentDept;}
}