package repository;

import java.lang.*;
import java.sql.*;
import entity.*;
import interfaces.*;


public Class Student implements IStudent
{
	DatabaseConnection dbc;
	
	public Student()
	{
		dbc = new DatabaseConnection();
	}
	public void test()
	{
        String query = "SELECT * FROM `Student`;";     
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
        try
		{
			
			
			while(rs.next())
			{
                String name = rs.getString("studentName");
				String id = rs.getInt("studentId");
				
				System.out.println("Name: " +name);
				System.out.println("ID: " +id);
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
    }
}