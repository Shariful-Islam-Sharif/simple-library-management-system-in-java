package entity;

import java.lang.*;

public class Admin
{
	 String adminName;
	 String adminPass;
	
	public Admin(){}
	public Admin(String adminName, String adminPass)
	{
		this.adminName = adminName;
		this.adminPass = adminPass;
	}
	
	public void setAdminName(String adminName){this.adminName = adminName;}
	public void setAdminPass(String adminPass){this.adminPass = adminPass;}
	
	public String getAdminName() {return adminName;}
	public String getAdminPass() {return adminPass;}
}