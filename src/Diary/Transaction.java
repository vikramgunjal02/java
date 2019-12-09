package Diary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Transaction {

	private JFrame frmTransaction;
	private JTable table;
	private JTable spend;

	/**
	 * Launch the application.
	 */
	public static void trans() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transaction window = new Transaction();
					window.frmTransaction.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Transaction() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTransaction = new JFrame();
		frmTransaction.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\vikram\\Desktop\\img\\transaction.png"));
		frmTransaction.setTitle("Transaction");
		frmTransaction.setBounds(100, 100, 926, 560);
		frmTransaction.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTransaction.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setForeground(new Color(148, 0, 211));
		table.setSurrendersFocusOnKeystroke(true);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new LineBorder(new Color(169, 169, 169), 3));
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setBackground(new Color(245, 222, 179));
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setBounds(40, 100, 806, 307);
		frmTransaction.getContentPane().add(table);
		
		JButton Clothing = new JButton("Clothing");
		Clothing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		        	
					 String Driver = "com.mysql.jdbc.Driver";
				        String url = "jdbc:mysql://localhost:3307/diary";
				        String uName ="root";
				        String pwd = "@Root@111";
				        Connection conn=null;
		            Class.forName("com.mysql.jdbc.Driver");
		            conn = DriverManager.getConnection(url, uName, pwd);
		            Statement stmt = conn.createStatement();
		            ResultSet rs=stmt.executeQuery("select price,description,date1,payment,Transaction from expenses where category='Clothing'");
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		            
		            ResultSet rs1=stmt.executeQuery("select sum(price) from expenses where category='Clothing'");
		            spend.setModel(DbUtils.resultSetToTableModel(rs1));
		            
		        }
		        catch(Exception Ex){	
		        }
			}
		});
		Clothing.setBackground(new Color(211, 211, 211));
		Clothing.setFont(new Font("Tahoma", Font.BOLD, 13));
		Clothing.setBounds(10, 418, 105, 36);
		frmTransaction.getContentPane().add(Clothing);
		
		JButton btnDrinks = new JButton("Drinks");
		btnDrinks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		        	
					 String Driver = "com.mysql.jdbc.Driver";
				        String url = "jdbc:mysql://localhost:3307/diary";
				        String uName ="root";
				        String pwd = "@Root@111";
				        Connection conn=null;
		            Class.forName("com.mysql.jdbc.Driver");
		            conn = DriverManager.getConnection(url, uName, pwd);
		            Statement stmt = conn.createStatement();
		            ResultSet rs=stmt.executeQuery("select price,description,date1,payment,Transaction from expenses where category='Drinks'");
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		            ResultSet rs1=stmt.executeQuery("select sum(price) from expenses where category='Drinks'");
		            spend.setModel(DbUtils.resultSetToTableModel(rs1));
		        }
		        catch(Exception Ex){	
		        }
			}
		});
		btnDrinks.setBackground(new Color(240, 255, 240));
		btnDrinks.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDrinks.setBounds(136, 418, 89, 36);
		frmTransaction.getContentPane().add(btnDrinks);
		
		JButton btnEducation = new JButton("Education");
		btnEducation.setBackground(new Color(250, 240, 230));
		btnEducation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		        	
					 String Driver = "com.mysql.jdbc.Driver";
				        String url = "jdbc:mysql://localhost:3307/diary";
				        String uName ="root";
				        String pwd = "@Root@111";
				        Connection conn=null;
		            Class.forName("com.mysql.jdbc.Driver");
		            conn = DriverManager.getConnection(url, uName, pwd);
		            Statement stmt = conn.createStatement();
		            ResultSet rs=stmt.executeQuery("select price,description,date1,payment,Transaction from expenses where category='Education'");
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		            ResultSet rs1=stmt.executeQuery("select sum(price) from expenses where category='Education'");
		            spend.setModel(DbUtils.resultSetToTableModel(rs1));
		        }
		        catch(Exception Ex){	
		        }
			}
		});		btnEducation.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEducation.setBounds(246, 418, 104, 36);
		frmTransaction.getContentPane().add(btnEducation);
		
		JButton btnFood = new JButton("Food");
		btnFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		        	
					 String Driver = "com.mysql.jdbc.Driver";
				        String url = "jdbc:mysql://localhost:3307/diary";
				        String uName ="root";
				        String pwd = "@Root@111";
				        Connection conn=null;
		            Class.forName("com.mysql.jdbc.Driver");
		            conn = DriverManager.getConnection(url, uName, pwd);
		            Statement stmt = conn.createStatement();
		            ResultSet rs=stmt.executeQuery("select price,description,date1,payment,Transaction from expenses where category='Food'");
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		            ResultSet rs1=stmt.executeQuery("select sum(price) from expenses where category='Food'");
		            spend.setModel(DbUtils.resultSetToTableModel(rs1));
		        }
		        catch(Exception Ex){	
		        }
			}
		});		
		btnFood.setBackground(new Color(245, 222, 179));
		btnFood.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFood.setBounds(370, 418, 89, 36);
		frmTransaction.getContentPane().add(btnFood);
		
		JButton btnFuel = new JButton("Fuel");
		btnFuel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		        	
					 String Driver = "com.mysql.jdbc.Driver";
				        String url = "jdbc:mysql://localhost:3307/diary";
				        String uName ="root";
				        String pwd = "@Root@111";
				        Connection conn=null;
		            Class.forName("com.mysql.jdbc.Driver");
		            conn = DriverManager.getConnection(url, uName, pwd);
		            Statement stmt = conn.createStatement();
		            ResultSet rs=stmt.executeQuery("select price,description,date1,payment,Transaction from expenses where category='Fuel'");
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		            ResultSet rs1=stmt.executeQuery("select sum(price) from expenses where category='Fuel'");
		            spend.setModel(DbUtils.resultSetToTableModel(rs1));
		        }
		        catch(Exception Ex){	
		        }
			}
		});		
		btnFuel.setBackground(new Color(245, 245, 245));
		btnFuel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFuel.setBounds(481, 418, 89, 36);
		frmTransaction.getContentPane().add(btnFuel);
		
		JButton btnFun = new JButton("Fun");
		btnFun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		        	
					 String Driver = "com.mysql.jdbc.Driver";
				        String url = "jdbc:mysql://localhost:3307/diary";
				        String uName ="root";
				        String pwd = "@Root@111";
				        Connection conn=null;
		            Class.forName("com.mysql.jdbc.Driver");
		            conn = DriverManager.getConnection(url, uName, pwd);
		            Statement stmt = conn.createStatement();
		            ResultSet rs=stmt.executeQuery("select price,description,date1,payment,Transaction from expenses where category='Fun'");
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		            ResultSet rs1=stmt.executeQuery("select sum(price) from expenses where category='Fun'");
		            spend.setModel(DbUtils.resultSetToTableModel(rs1));
		        }
		        catch(Exception Ex){	
		        }
			}
		});		
		btnFun.setBackground(new Color(255, 240, 245));
		btnFun.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFun.setBounds(591, 418, 89, 36);
		frmTransaction.getContentPane().add(btnFun);
		
		JButton btnHospital = new JButton("Hospital");
		btnHospital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		        	
					 String Driver = "com.mysql.jdbc.Driver";
				        String url = "jdbc:mysql://localhost:3307/diary";
				        String uName ="root";
				        String pwd = "@Root@111";
				        Connection conn=null;
		            Class.forName("com.mysql.jdbc.Driver");
		            conn = DriverManager.getConnection(url, uName, pwd);
		            Statement stmt = conn.createStatement();
		            ResultSet rs=stmt.executeQuery("select price,description,date1,payment,Transaction from expenses where category='Hospital'");
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		            ResultSet rs1=stmt.executeQuery("select sum(price) from expenses where category='Hospital'");
		            spend.setModel(DbUtils.resultSetToTableModel(rs1));
		        }
		        catch(Exception Ex){	
		        }
			}
		});		
		btnHospital.setBackground(new Color(238, 232, 170));
		btnHospital.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHospital.setBounds(713, 418, 89, 36);
		frmTransaction.getContentPane().add(btnHospital);
		
		JLabel lblNewLabel = new JLabel("Transactions");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(360, 0, 174, 51);
		frmTransaction.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Price");
		lblNewLabel_1.setForeground(Color.MAGENTA);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(72, 75, 55, 14);
		frmTransaction.getContentPane().add(lblNewLabel_1);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setForeground(Color.MAGENTA);
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescription.setBounds(205, 75, 98, 14);
		frmTransaction.getContentPane().add(lblDescription);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.MAGENTA);
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDate.setBounds(404, 75, 55, 14);
		frmTransaction.getContentPane().add(lblDate);
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setForeground(Color.MAGENTA);
		lblPayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayment.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPayment.setBounds(580, 75, 81, 14);
		frmTransaction.getContentPane().add(lblPayment);
		
		JLabel lblName = new JLabel("Name\r\n");
		lblName.setForeground(Color.MAGENTA);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(747, 75, 55, 14);
		frmTransaction.getContentPane().add(lblName);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Nexpenses exp=new Nexpenses();
				frmTransaction.hide();
				exp.home1();
			
				
				
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(787, 15, 89, 36);
		frmTransaction.getContentPane().add(btnNewButton);
		
		JLabel lblTotalSpend = new JLabel("Total Spend");
		lblTotalSpend.setForeground(Color.RED);
		lblTotalSpend.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalSpend.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTotalSpend.setBackground(new Color(240, 240, 240));
		lblTotalSpend.setBounds(239, 474, 175, 40);
		frmTransaction.getContentPane().add(lblTotalSpend);
		
		spend = new JTable();
		spend.setFont(new Font("Tahoma", Font.BOLD, 16));
		spend.setShowVerticalLines(false);
		spend.setShowHorizontalLines(false);
		spend.setShowGrid(false);
		spend.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		spend.setEnabled(false);
		spend.setBorder(null);
		spend.setBackground(new Color(255, 255, 255));
		spend.setForeground(Color.RED);
		spend.setRowSelectionAllowed(false);
		spend.setBounds(440, 478, 211, 36);
		frmTransaction.getContentPane().add(spend);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("C:\\Users\\vikram\\Desktop\\img\\transaction.png"));
		label.setBounds(298, 0, 72, 62);
		frmTransaction.getContentPane().add(label);
	}
}
