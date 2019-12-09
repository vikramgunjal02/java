package Diary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;

public class Nexpenses {

	private JFrame frame;
	private JTextField price;
	private JLabel lblPrice;
	private JComboBox category;
	private JTextField description;
	private JLabel lblCategory;
	private JLabel lblDate;
	private JLabel lblDescripation;
	private JComboBox payment;
	private JLabel lblPayment;
	private JButton btnNewButton;
	private JTextField Transaction;
	private JLabel tran;
	private JLabel cmmt;
	private JButton btnTrack;

	/**
	 * Launch the application.
	 */
	public static void home1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nexpenses window = new Nexpenses();
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
	public Nexpenses() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\vikram\\Desktop\\img\\profit.png"));

		frame.setTitle("Expenses");
		frame.getContentPane().setBackground(new Color(245, 245, 245));

		frame.setBounds(100, 100, 837, 574);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblExpenses = new JLabel("Expenses");
		lblExpenses.setBackground(Color.GREEN);
		lblExpenses.setHorizontalAlignment(SwingConstants.CENTER);
		lblExpenses.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblExpenses.setBounds(327, 11, 183, 29);
		frame.getContentPane().add(lblExpenses);
		
		price = new JTextField();
		price.setBounds(355, 207, 155, 29);
		frame.getContentPane().add(price);
		price.setColumns(10);
		
		lblPrice = new JLabel("Price");
		lblPrice.setBackground(Color.YELLOW);
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPrice.setBounds(208, 203, 117, 29);
		frame.getContentPane().add(lblPrice);
		
		category = new JComboBox();
		category.setFont(new Font("Tahoma", Font.BOLD, 12));
		category.setModel(new DefaultComboBoxModel(new String[] {"Clothing", "Drinks", "Education", "Food", "Fuel", "Fun", "Hospital", "Hotel", "Medical", "Other"}));
		category.setBounds(355, 89, 155, 29);
		frame.getContentPane().add(category);
		
		JDateChooser date1 = new JDateChooser();
		date1.setBounds(355, 268, 155, 29);
		frame.getContentPane().add(date1);
		
		description = new JTextField();
		description.setBounds(355, 136, 155, 41);
		frame.getContentPane().add(description);
		description.setColumns(10);
		
		lblCategory = new JLabel("Category");
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCategory.setBackground(Color.YELLOW);
		lblCategory.setBounds(208, 86, 117, 29);
		frame.getContentPane().add(lblCategory);
		
		lblDate = new JLabel("Date\r\n");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDate.setBackground(Color.YELLOW);
		lblDate.setBounds(208, 268, 117, 29);
		frame.getContentPane().add(lblDate);
		
		lblDescripation = new JLabel("Description");
		lblDescripation.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripation.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDescripation.setBackground(Color.YELLOW);
		lblDescripation.setBounds(192, 138, 137, 29);
		frame.getContentPane().add(lblDescripation);
		
		payment = new JComboBox();
		payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		payment.setFont(new Font("Tahoma", Font.BOLD, 13));
		payment.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Credit card", "Debit Card", "Net Banking"}));
		payment.setBounds(355, 326, 155, 29);
		frame.getContentPane().add(payment);
		
		lblPayment = new JLabel("Payment");
		lblPayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayment.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPayment.setBackground(Color.YELLOW);
		lblPayment.setBounds(208, 323, 117, 29);
		frame.getContentPane().add(lblPayment);
		
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				
				
				
				
try {
		        	
					String Driver = "com.mysql.jdbc.Driver";
			        String url = "jdbc:mysql://localhost:3307/diary";
			        String uName ="root";
			        String pwd = "@Root@111";
			        Connection conn=null;

		            Class.forName("com.mysql.jdbc.Driver");
		            conn = DriverManager.getConnection(url, uName, pwd);
		            
		            String sql = "insert into expenses values(?,?,?,?,?,?)";
		            PreparedStatement pstmt = conn.prepareStatement(sql);
		           
		                 String value=category.getSelectedItem().toString();
		                 pstmt.setString(1, value);
		            	 pstmt.setString(2, price.getText());
		            	 pstmt.setString(3, description.getText());
		            	 pstmt.setString(4,((JTextField)date1.getDateEditor().getUiComponent()).getText());
		            	 String value2=payment.getSelectedItem().toString();
			             pstmt.setString(5,value2);
			             pstmt.setString(6, Transaction.getText());
		                    pstmt.executeUpdate();
		                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
	                }
	                
		        catch(Exception Ex){
		        
		        }

			}

		});

		save.setFont(new Font("Tahoma", Font.BOLD, 17));
		save.setBackground(new Color(152, 251, 152));
		save.setBounds(165, 422, 345, 36);
		frame.getContentPane().add(save);
		
		btnNewButton = new JButton("Add Income");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Income inc = new Income();
				frame.hide();
				inc.addin();
				
				
			}
		});
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(642, 89, 125, 36);
		frame.getContentPane().add(btnNewButton);
		
		Transaction = new JTextField();
		Transaction.setColumns(10);
		Transaction.setBounds(355, 382, 155, 29);
		frame.getContentPane().add(Transaction);
		
		tran = new JLabel("* Transaction ID\r\n");
		tran.setHorizontalAlignment(SwingConstants.CENTER);
		tran.setFont(new Font("Tahoma", Font.BOLD, 20));
		tran.setBackground(Color.YELLOW);
		tran.setBounds(142, 382, 183, 29);
		frame.getContentPane().add(tran);
		
		cmmt = new JLabel("* It is the optional");
		cmmt.setHorizontalAlignment(SwingConstants.CENTER);
		cmmt.setFont(new Font("Tahoma", Font.ITALIC, 15));
		cmmt.setForeground(Color.red);
		cmmt.setBackground(Color.YELLOW);
		cmmt.setBounds(274, 469, 137, 29);
		frame.getContentPane().add(cmmt);
		
		JButton logout = new JButton("LogOut");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.hide();
				
				
				
				
			}
		});
		logout.setBackground(new Color(216, 191, 216));
		logout.setFont(new Font("Tahoma", Font.BOLD, 14));
		logout.setBounds(421, 469, 89, 29);
		frame.getContentPane().add(logout);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				price.setText("");
				description.setText("");
				Transaction.setText("");
				
				
			}
		});
		reset.setFont(new Font("Tahoma", Font.BOLD, 14));
		reset.setBackground(new Color(245, 245, 245));
		reset.setBounds(165, 469, 89, 29);
		frame.getContentPane().add(reset);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vikram\\Desktop\\img\\profit.png"));
		lblNewLabel.setBounds(274, 0, 63, 58);
		frame.getContentPane().add(lblNewLabel);
		
		JButton saving = new JButton("Saving");
		saving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				saving save=new saving();
				frame.hide();
				save.save1();
			}
		});
		saving.setFont(new Font("Tahoma", Font.BOLD, 14));
		saving.setBackground(new Color(255, 215, 0));
		saving.setBounds(642, 136, 125, 36);
		frame.getContentPane().add(saving);
		
		JButton transaction = new JButton("Transaction");
		transaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transaction exp=new Transaction();
				frame.hide();
				exp.trans();
				
				
			}
		});
		transaction.setFont(new Font("Tahoma", Font.BOLD, 14));
		transaction.setBackground(new Color(255, 215, 0));
		transaction.setBounds(642, 183, 125, 36);
		frame.getContentPane().add(transaction);
		
		btnTrack = new JButton("Track");
		btnTrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Track exp=new Track();
				frame.hide();
				exp.track1();
				
				
				
			}
		});
		btnTrack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTrack.setBackground(new Color(255, 215, 0));
		btnTrack.setBounds(642, 230, 125, 36);
		frame.getContentPane().add(btnTrack);
		
		
	}
}
