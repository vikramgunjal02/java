package Diary;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.EventQueue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JButton;

public class Registration {

	private JFrame frame;
	private JTextField textField;
	private JTextField tuname;
	private JLabel name;
	private JTextField tname;
	private JLabel sname;
	private JTextField tsname;
	private JLabel city;
	private JTextField tcity;
	private JLabel pass;
	private JTextField tpass;
	private JLabel cpass;
	private JTextField tcpass;

	/**
	 * Launch the application.
	 * 
	 */
	
	public static void home() {
		//public static void home() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("Registration Form");
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 416, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel uname = new JLabel("User Name");
		uname.setFont(new Font("Tahoma", Font.BOLD, 12));
		uname.setBounds(28, 35, 70, 14);
		frame.getContentPane().add(uname);
		
		tuname = new JTextField();
		tuname.setBounds(137, 33, 163, 20);
		frame.getContentPane().add(tuname);
		tuname.setColumns(10);
		
		name = new JLabel("Name");
		name.setFont(new Font("Tahoma", Font.BOLD, 12));
		name.setBounds(28, 81, 70, 14);
		frame.getContentPane().add(name);
		
		tname = new JTextField();
		tname.setColumns(10);
		tname.setBounds(137, 81, 163, 20);
		frame.getContentPane().add(tname);
		
		sname = new JLabel("Surname");
		sname.setFont(new Font("Tahoma", Font.BOLD, 12));
		sname.setBounds(28, 131, 70, 14);
		frame.getContentPane().add(sname);
		
		tsname = new JTextField();
		tsname.setColumns(10);
		tsname.setBounds(137, 129, 163, 20);
		frame.getContentPane().add(tsname);
		
		city = new JLabel("City");
		city.setFont(new Font("Tahoma", Font.BOLD, 12));
		city.setBounds(28, 181, 70, 14);
		frame.getContentPane().add(city);
		
		tcity = new JTextField();
		tcity.setColumns(10);
		tcity.setBounds(137, 179, 163, 20);
		frame.getContentPane().add(tcity);
		
		pass = new JLabel("Password");
		pass.setFont(new Font("Tahoma", Font.BOLD, 12));
		pass.setBounds(28, 233, 70, 14);
		frame.getContentPane().add(pass);
		
		tpass = new JTextField();
		JPasswordField tpass = new JPasswordField(); 
		tpass.setColumns(10);
		tpass.setBounds(137, 231, 163, 20);
		frame.getContentPane().add(tpass);
		
		cpass = new JLabel("confirm pass");
		
		cpass.setFont(new Font("Tahoma", Font.BOLD, 12));
		cpass.setBounds(28, 289, 77, 14);
		frame.getContentPane().add(cpass);
		
		tcpass = new JTextField();
		JPasswordField tcpass = new JPasswordField(); 
		tcpass.setColumns(10);
		tcpass.setBounds(137, 287, 163, 20);
		frame.getContentPane().add(tcpass);
		
		JButton reg = new JButton("REGISTER");
		reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				try {
		        	
					String Driver = "com.mysql.jdbc.Driver";
			        String url = "jdbc:mysql://localhost:3307/dada";
			        String uName ="root";
			        String pwd = "@Root@111";
			        Connection conn=null;

		            Class.forName("com.mysql.jdbc.Driver");
		            conn = DriverManager.getConnection(url, uName, pwd);
		          
		            String sql = "insert into diary values(?,?,?,?,?,?)";
		            PreparedStatement pstmt = conn.prepareStatement(sql);
		           // String userName = tuname.getText();
		          //  String sql1 = "create table vikram(Id int,lit float,fat float,snf float,rate double)";
		           // PreparedStatement pstmt1 = conn.prepareStatement(sql1);
		            //pstmt.executeUpdate(sql1);
		           
		            pstmt.setString(1, tuname.getText());
		               pstmt.setString(2, tname.getText());
		               pstmt.setString(3, tsname.getText());
		               pstmt.setString(4, tcity.getText());
		               pstmt.setString(5, tpass.getText());
		               pstmt.setString(6, tcpass.getText());
		               
		             //  String sql1 = "create table"+tuname +"(Id int,lit float,fat float,snf float,rate double)";
		              // pstmt.executeUpdate(sql1);
		              // System.out.println("CreateTable sucessfully");
		               
		               
		               if(tpass.getText().equalsIgnoreCase(tcpass.getText()))
		                {
		                    //Executing query
		            	   
			              
		                    pstmt.executeUpdate();
		                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
		                    
		                }
		                else
		                {
		                    JOptionPane.showMessageDialog(null,"password did not match");
		                }
		             //  pstmt.execute();
		             //  JOptionPane.showMessageDialog(null,"DATA Insert sucessfully");
		        }
		        catch(Exception Ex){
		        	
		        	
		        	
		        }
			

				
				
				
			}
			
			

				
			
		});
		reg.setBounds(59, 375, 89, 23);
		frame.getContentPane().add(reg);
		//JButton button1 = new JButton("Button 1");
		reg.setBackground(Color.red);
		
		JButton reset = new JButton("RESET");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tuname.setText("");
				tname.setText("");
				tsname.setText("");
				tcity.setText("");
				tpass.setText("");
				tcpass.setText("");
				
				
			}
		});
		reset.setBounds(211, 375, 89, 23);
		frame.getContentPane().add(reset);
		reset.setBackground(Color.red);
		
	}

	
}
