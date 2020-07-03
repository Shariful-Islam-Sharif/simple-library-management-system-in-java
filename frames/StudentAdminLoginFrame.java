package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.sql.*;
//import repository.*;
import entity.*;


public class StudentAdminLoginFrame extends JFrame implements ActionListener
{
	private JLabel label,userNameLabel,passLabel;
	private JTextField tfld;
	private JPasswordField pfld;
	private JButton backBtn,loginBtn,exitBtn;
	private JPanel panel;
	
	public StudentAdminLoginFrame()
	{
		super("StudentAdminLoginFrame");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		//panel.setBackground(Color.white);
		
		label = new JLabel("AIUB Library");
		label.setBounds(350, 10, 350, 30);
		panel.add(label);
		
		userNameLabel = new JLabel("User Name/Id: ");
		userNameLabel.setBounds(270, 100, 100, 30);
		panel.add(userNameLabel);
		
		tfld = new JTextField();
		tfld.setBounds(370, 100, 100, 30);
		panel.add(tfld);
		
		passLabel = new JLabel("Password: ");
		passLabel.setBounds(270, 150, 100, 30);
		panel.add(passLabel);
		
		pfld = new JPasswordField();
		pfld.setBounds(370, 150, 100, 30);
		pfld.setEchoChar('*');
		panel.add(pfld);
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(80, 360, 100, 30);
		panel.add(backBtn);
		backBtn.addActionListener(this);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(380, 360, 100, 30);
		panel.add(loginBtn);
		loginBtn.addActionListener(this);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(680, 360, 100, 30);
		panel.add(exitBtn);
		exitBtn.addActionListener(this);
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
			
		if(command.equals(backBtn.getText()))       //For back$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		{
			HomePage hp = new HomePage();
			hp.setVisible(true);
			this.setVisible(false);
		}
		
		
		else if(command.equals(loginBtn.getText()))  //For admin login $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		{
			Admin ad = new Admin();       //admin object
			//ad.adminName= tfld.getText();
			//ad.adminPass = pfld.getText();
			
			Student s = new Student();  //student object
			//s.studentId = tfld.getText();
			//s.studentPass = pfld.getText();
			
			
			
			//System.out.println(s.studentId);
			//System.out.println(s.studentPass);
			//////////////////////////////
			if(tfld.getText().equals("admin"))  //Admin Checking @@@@@@@@@@
			{
				if(pfld.getText().equals("admin"))
				{
					JOptionPane.showMessageDialog(this,"Admin Login Successfully");
					AdminFrame af = new AdminFrame();
					af.setVisible(true);
					this.setVisible(false);
				}
				else if ( pfld.getText().equals(""))
				{
				   JOptionPane.showMessageDialog(this,"Password field can't be empty!!! ");
				   StudentAdminLoginFrame salf = new StudentAdminLoginFrame();
				   salf.setVisible(true);
				   this.setVisible(false);
				   
				   
				}
				else 
				{
					JOptionPane.showMessageDialog(this,"Wrong Password:( ");
					StudentAdminLoginFrame salf = new StudentAdminLoginFrame();
					salf.setVisible(true);
					this.setVisible(false);
				}
			}
			
			else //Student Checking
			{
				DatabaseConnection d= new DatabaseConnection();
				d.test();
				
				
				
			}	
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
		public void test()
		{
			String query = "SELECT * FROM `Student`;";     
			Connection con=null;//for connection
			Statement st = null;//for query execution
			ResultSet rs = null;//to get row by row result from DB
			//System.out.println(query);
			try
			{
				Class.forName("com.mysql.jdbc.Driver");//load driver
				//System.out.println("driver loaded");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
				//System.out.println("connection done");//connection with database established
				st = con.createStatement();//create statement
				//System.out.println("statement created");
				rs = st.executeQuery(query);//getting result
				//System.out.println("results received");
				ArrayList<String> idList = new ArrayList<String>();
				ArrayList<String> passList = new ArrayList<String>();
				
				while(rs.next())
				{
					String id = rs.getString("studentId");
					String pass = rs.getString("studentPass");
					idList.add(id);
					passList.add(pass);
					
					//System.out.println("id: " +id);
					//System.out.println("pass: " +pass);
				}
				for(String x : idList)
				{
					//System.out.println(x+" ");
					
						if(tfld.getText().equals(x)) //tFld equal to studentId
						{
							//System.out.println("tFld = x");
							
							
							
							for(String y : passList)
							{////////////
							
							
								if(pfld.getText().equals(y)) //pFld equal to studentPass
								{
									JOptionPane.showMessageDialog(null,"Student Login Successfully");
									StudentFrame sf = new StudentFrame();
									sf.setVisible(true);
									StudentAdminLoginFrame salf = new StudentAdminLoginFrame();
									salf.setVisible(false);
									break;
								}
								
								 /*
								else if ( pfld.getText().equals(""))  
								{
								   JOptionPane.showMessageDialog(null,"Password field can't be empty!!! ");
								   //StudentAdminLoginFrame salf = new StudentAdminLoginFrame();
								   //salf.setVisible(true);
								   //this.setVisible(false);
								   break;
								}
								else 
								{
									JOptionPane.showMessageDialog(null,"Wrong Password:( ");
									//StudentAdminLoginFrame salf = new StudentAdminLoginFrame();
									//salf.setVisible(true);
									//this.setVisible(false);
									break;
								}  
								*/
							
							}/////////////////
							
						}
						else
						{
							//System.out.println("tFld != x");
						   /*JOptionPane.showMessageDialog(null,"Wrong UserId");*/
						   StudentAdminLoginFrame salf = new StudentAdminLoginFrame();
						   salf.setVisible(true);
						   salf.setVisible(false);
						}
					
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

		
				
}		
	
