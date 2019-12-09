package Diary;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Income {

	private JFrame frmIncome;
	private JTextField amount;
	private JTextField description;

	/**
	 * Launch the application.
	 */
	public static void addin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Income window = new Income();
					window.frmIncome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Income() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIncome = new JFrame();
		frmIncome.setTitle("Income");
		frmIncome.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\vikram\\Desktop\\ALL\\1.png"));
		frmIncome.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		frmIncome.setBounds(100, 100, 829, 519);
		frmIncome.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmIncome.getContentPane().setLayout(null);		
		
		
		JLabel income = new JLabel("Income");
		income.setBackground(Color.GREEN);
		income.setHorizontalAlignment(SwingConstants.CENTER);
		income.setFont(new Font("Tahoma", Font.BOLD, 24));
		income.setBounds(331, 28, 183, 29);
		frmIncome.getContentPane().add(income);
		
		amount = new JTextField();
		amount.setBounds(381, 92, 133, 29);
		frmIncome.getContentPane().add(amount);
		amount.setColumns(10);
		
		JLabel lblAmmount = new JLabel("Amount");
		lblAmmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmmount.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblAmmount.setBackground(Color.GREEN);
		lblAmmount.setBounds(174, 92, 183, 29);
		frmIncome.getContentPane().add(lblAmmount);
		
		JComboBox source = new JComboBox();
		source.setFont(new Font("Tahoma", Font.BOLD, 16));
		source.setModel(new DefaultComboBoxModel(new String[] {"Business", "Salary", "Farm", "Other"}));
		source.setBounds(381, 155, 133, 29);
		frmIncome.getContentPane().add(source);
		
		JLabel lblSource = new JLabel("Source");
		lblSource.setHorizontalAlignment(SwingConstants.CENTER);
		lblSource.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblSource.setBackground(Color.GREEN);
		lblSource.setBounds(174, 155, 183, 29);
		frmIncome.getContentPane().add(lblSource);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblDate.setBackground(Color.GREEN);
		lblDate.setBounds(174, 221, 183, 29);
		frmIncome.getContentPane().add(lblDate);
		
		JDateChooser date1 = new JDateChooser();
		date1.setBounds(381, 221, 133, 29);
		frmIncome.getContentPane().add(date1);
		
		JLabel lblDescripation = new JLabel("Description");
		lblDescripation.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripation.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblDescripation.setBackground(Color.GREEN);
		lblDescripation.setBounds(174, 287, 183, 29);
		frmIncome.getContentPane().add(lblDescripation);
		
		description = new JTextField();
		description.setColumns(10);
		description.setBounds(381, 291, 133, 29);
		frmIncome.getContentPane().add(description);
		
		JComboBox method = new JComboBox();
		method.setFont(new Font("Tahoma", Font.BOLD, 16));
		method.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Credit Card", "Debit Card", "Net Banking"}));
		method.setBounds(381, 360, 133, 29);
		frmIncome.getContentPane().add(method);
		
		JLabel lblMethod = new JLabel("Method");
		lblMethod.setHorizontalAlignment(SwingConstants.CENTER);
		lblMethod.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblMethod.setBackground(Color.GREEN);
		lblMethod.setBounds(174, 360, 183, 29);
		frmIncome.getContentPane().add(lblMethod);
		
		JButton btnAddIncome = new JButton("Add Income");
		btnAddIncome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {try {
	        	
				String Driver = "com.mysql.jdbc.Driver";
		        String url = "jdbc:mysql://localhost:3307/diary";
		        String uName ="root";
		        String pwd = "@Root@111";
		        Connection conn=null;

	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(url, uName, pwd);
	            
	            String sql = "insert into income values(?,?,?,?,?)";
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	           
	                 
	            	 pstmt.setString(1, amount.getText());
	            	 String value=source.getSelectedItem().toString();
	                 pstmt.setString(2, value);
	                 pstmt.setString(3,((JTextField)date1.getDateEditor().getUiComponent()).getText());
	            	 pstmt.setString(4, description.getText());
	            	
	            	 String value2=method.getSelectedItem().toString();
		             pstmt.setString(5,value2);
		             
	                    pstmt.executeUpdate();
	                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                }
                
	        catch(Exception Ex){
	        
	        }

		}

	});		btnAddIncome.setBackground(Color.GREEN);
		btnAddIncome.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnAddIncome.setBounds(193, 416, 321, 43);
		frmIncome.getContentPane().add(btnAddIncome);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Nexpenses exp=new Nexpenses();
				frmIncome.hide();
				exp.home1();
			
			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(675, 113, 101, 29);
		frmIncome.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\vikram\\Desktop\\img\\profit.png"));
		label.setBounds(310, 11, 59, 56);
		frmIncome.getContentPane().add(label);
		
		
		
		
		
		
	}
}
