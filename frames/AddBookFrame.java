package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import entity.*;
//import repository.*;
import java.sql.*;



public class AddBookFrame extends JFrame implements ActionListener
{
	private JLabel label,idLabel,nameLabel,authorNameLabel,publishYearLabel;
	private JButton registerBtn,backBtn,logOutBtn,exitBtn;
	private JTextField idFld,nameFld,authorNameFld,publishYearFld;
	
	private JTextField deptFld;
	private JPanel panel;
	
	public AddBookFrame()
	{
		super("AddBookFrame");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		label = new JLabel("AIUB Library");
		label.setBounds(350, 10, 350, 30);
		panel.add(label);
		//,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
		idLabel = new JLabel("Book/ID: ");
		idLabel.setBounds(90, 100, 120, 30);
		panel.add(idLabel);
		
		idFld = new JTextField();
		idFld.setBounds(190, 100, 80, 30);
		panel.add(idFld);
		
		nameLabel = new JLabel("Book Name: ");
		nameLabel.setBounds(90, 140, 120, 30);
		panel.add(nameLabel);
		
		nameFld = new JTextField();
		nameFld.setBounds(190, 140, 80, 30);
		panel.add(nameFld);
		
		
		
		
		
	
		authorNameLabel = new JLabel("authorName: ");
		authorNameLabel.setBounds(90, 180, 120, 30);
		panel.add(authorNameLabel);
		
		authorNameFld = new JTextField();
		authorNameFld.setBounds(190, 180, 80, 30);
		panel.add(authorNameFld);
		
		//
		
		publishYearLabel = new JLabel("publishYear: ");
		publishYearLabel.setBounds(90, 220, 120, 30);
		panel.add(publishYearLabel);
		
		publishYearFld = new JTextField();
		publishYearFld.setBounds(190, 220, 80, 30);
		panel.add(publishYearFld);
		
		
		//
		
		
		backBtn = new JButton("Back");
		backBtn.setBounds(80, 360, 100, 30);
		panel.add(backBtn);
		backBtn.addActionListener(this);
		
		logOutBtn = new JButton("Log Out");
		logOutBtn.setBounds(280, 360, 100, 30);
		panel.add(logOutBtn);
		logOutBtn.addActionListener(this);
		
		registerBtn = new JButton("Register");
		registerBtn.setBounds(480, 360, 100, 30);
		panel.add(registerBtn);
		registerBtn.addActionListener(this);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(680, 360, 80, 30);
		panel.add(exitBtn);
		exitBtn.addActionListener(this);
		
		
		
		
		this.add(panel);
	}
	/*
	public void actionPerformed(ActionEvent ae)
   {
	   String idFld=idFld.getText();
	   String passFld=passFld.getText();
	   
	   if (idFld.equals("admin") && passFld.equals("admin")) 
	   {
		   AdminFrame af = new AdminFrame();
		   af.setVisible(true);
		   this.setVisible(false);
		   
		   //JLabel label = new JLabel("Welcome:"+idFld);
		   //page.getContentPane().add(label);
	   }
	   else
	   {
		   System.out.println("enter the valid username and password");
		   JOptionPane.showMessageDialog(this,"Incorrect login or password",
		   "Error",JOptionPane.ERROR_MESSAGE);
	   }
	}
	*/
	
	
	
	public void actionPerformed(ActionEvent ae)
		{
			String command = ae.getActionCommand();
			
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
			else if(command.equals(registerBtn.getText())) 
			{
				
				/*
				Student st = new Student();
				
				st.studentId = idFld.getText();
				st.studentName = nameFld.getText();
				st.studentPass = passFld.getText();
				st.studentDept = deptFld.getText();
				
				
				
				System.out.println(st.studentId);
				System.out.println(st.studentName);
				System.out.println(st.studentPass);
				System.out.println(st.studentDept);     
				
				
				
				//JLabel label = new JLabel("Welcome:");
				//af.getContentPane().add(label);
				
				//DatabaseConnection d = new DatabaseConnection();    */
				
				DatabaseConnection dbc = new DatabaseConnection();
				String query = "INSERT INTO `book`(`bookId`, `bookName`, `authorName`, `publishYear`) VALUES ('"+idFld.getText()+"', '"+nameFld.getText()+"', '"+authorNameFld.getText()+"', '"+publishYearFld.getText()+"');";
				
				try
				{
					dbc.openConnection();
					dbc.st.execute(query);
					dbc.closeConnection();
				}
				catch(Exception ex){System.out.println(ex.getMessage());
						
					}
				JOptionPane.showMessageDialog(this,"Book Added");
				
				AddBookFrame abf = new AddBookFrame();
				abf.setVisible(true);
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