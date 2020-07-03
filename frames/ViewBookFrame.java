package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.sql.*;
//import repository.*;
import entity.*;


public class ViewBookFrame extends JFrame implements ActionListener
{
	private JLabel label,adminLabel;
	private JButton backBtn,logOutBtn, exitBtn;
	private JPanel panel;
	
	public ViewBookFrame()
	{
		super("ViewBookFrame");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		label = new JLabel("AIUB Library");
		label.setBounds(350, 10, 350, 30);
		panel.add(label);
		
		//for table
		DatabaseConnection dbc = new DatabaseConnection();
		JFrame table=new JFrame();
		String data[][]={ {"101","At","a","1000"},    
						  {"102","Ji","j","2000"},    
						  {"101","Sn","s","3000"}
						};   
						
		String column[]={"BOOKID","BOOKNAME","AUTHORNAME","PUBLISHYEAR"};         
		JTable jt=new JTable(data,column);    
		jt.setBounds(30,40,200,300);          
		panel.add(label);
		
		JScrollPane sp=new JScrollPane(jt);    
		table.add(sp);          
		table.setSize(300,400);
		this.setVisible(false);
		table.setVisible(true);
		
		
		
		
		/*
		adminBtn = new JButton("Admin");
		adminBtn.setBounds(100, 80, 100, 30);
		panel.add(adminBtn);
		adminBtn.addActionListener(this);
		
		
		
		studentBtn = new JButton("Student");
		studentBtn.setBounds(100, 120, 100, 30);
		panel.add(studentBtn);
		studentBtn.addActionListener(this);*/
		
		backBtn = new JButton("Back");
		backBtn.setBounds(80, 360, 100, 30);
		panel.add(backBtn);
		backBtn.addActionListener(this);
		
		logOutBtn = new JButton("LogOut");
		logOutBtn.setBounds(380, 360, 100, 30);
		panel.add(logOutBtn);
		logOutBtn.addActionListener(this);
		
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(680, 360, 80, 30);
		panel.add(exitBtn);
		exitBtn.addActionListener(this);
		
		
		
		this.add(panel);
	}
	
		
		
		public void actionPerformed(ActionEvent ae)
		{
			String command = ae.getActionCommand();
			
			/*
			if(command.equals(adminBtn.getText()))
			{
				AdminLoginFrame alf = new AdminLoginFrame();
				alf.setVisible(true);
				this.setVisible(false);
			}
			else if(command.equals(studentBtn.getText()))
			{
				StudentLoginFrame slf = new StudentLoginFrame();
				slf.setVisible(true);
				this.setVisible(false);
			}
			*/
			if(command.equals(backBtn.getText()))
			{
				StudentFrame sf = new StudentFrame();
				sf.setVisible(true);
				this.setVisible(false);
			}
			else if(command.equals(logOutBtn.getText()))
			{
				HomePage hp = new HomePage();
				hp.setVisible(true);
				this.setVisible(false);
			}
			else if(command.equals(exitBtn.getText()))
			{
				System.exit(0);
			}
			else{}
		}
		
		
		
		//database
		
		public class DatabaseConnection
		{
			Connection con;
			Statement st;
			ResultSet result;
			
			public DatabaseConnection()
			{
				
			}

			public void openConnection()
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "");
					st = con.createStatement();
				}
				catch(Exception e){System.out.println(e.getMessage());}
			}
			public void closeConnection()
			{
				try
				{
					if(con!=null){con.close();}
					if(st!=null){st.close();}
					if(result!=null){result.close();}
				}
				catch(Exception e){}
			}
			
		}
		
}