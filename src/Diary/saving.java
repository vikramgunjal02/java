package Diary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class saving {

	private Double totalExpense = 0.0;
	private Double totalIncome = 0.0;
	private JFrame frame;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JButton getexp;
	private JButton btnCalculation;
	private JButton btnReset;
	private JTextField expenseTextField;
	private JTextField incomeTextField;
	private JTextField balanceTextField;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void save1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					saving window = new saving();
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
	public saving() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\vikram\\Desktop\\ALL\\1.png"));
		frame.setTitle("Saving");
		frame.getContentPane().setBackground(new Color(240, 255, 255));
		frame.setBounds(100, 100, 805, 483);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTotalExpenses = new JLabel("Total Expenses");
		lblTotalExpenses.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblTotalExpenses.setBounds(114, 120, 167, 42);
		frame.getContentPane().add(lblTotalExpenses);
		
		btnNewButton = new JButton("Home");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Nexpenses exp=new Nexpenses();
				frame.hide();
				exp.home1();
				
				
				
				
			}
		});
		btnNewButton.setBackground(new Color(255, 215, 0));
		btnNewButton.setBounds(52, 404, 95, 33);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("Saving");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 31));
		lblNewLabel.setBounds(396, 26, 130, 39);
		frame.getContentPane().add(lblNewLabel);
		
		getexp = new JButton("Get");
		getexp.setForeground(new Color(0, 0, 0));
		getexp.addActionListener(new ActionListener() {
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
		            ResultSet rs=stmt.executeQuery("select sum(price) from expenses");
		            
		            rs.next();
		            totalExpense = Double.parseDouble(rs.getString(1));
		          
		            expenseTextField.setText(""+totalExpense);
		            
                    ResultSet rs1=stmt.executeQuery("select sum(ammount) from income");
		            
		            rs1.next();
		            totalIncome = Double.parseDouble(rs1.getString(1));
		            incomeTextField.setText(""+totalIncome);
		            //System.out.print("INCOME "+totalIncome);
		        }
		        catch(Exception Ex){	
		        }
			}
		});
		getexp.setFont(new Font("Tahoma", Font.BOLD, 12));
		getexp.setBounds(605, 164, 106, 33);
		frame.getContentPane().add(getexp);
		JLabel lblTotalIncome = new JLabel("Total Income");
		lblTotalIncome.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblTotalIncome.setBounds(114, 213, 167, 42);
		frame.getContentPane().add(lblTotalIncome);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setForeground(new Color(255, 0, 0));
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblBalance.setBounds(114, 307, 167, 42);
		frame.getContentPane().add(lblBalance);
		
		btnCalculation = new JButton("Calculation");
		btnCalculation.setBackground(new Color(210, 180, 140));
		btnCalculation.setForeground(new Color(0, 0, 0));
		btnCalculation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				balanceTextField.setText(""+(totalIncome-totalExpense));
			}
		});		btnCalculation.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCalculation.setBounds(605, 312, 106, 33);
		frame.getContentPane().add(btnCalculation);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expenseTextField.setText("");
				incomeTextField.setText("");
				balanceTextField.setText("");
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBackground(new Color(255, 215, 0));
		btnReset.setBounds(616, 404, 95, 33);
		frame.getContentPane().add(btnReset);
		
		expenseTextField = new JTextField();
		expenseTextField.setFont(new Font("Tahoma", Font.BOLD, 22));
		expenseTextField.setBackground(new Color(255, 228, 225));
		expenseTextField.setBounds(332, 116, 210, 50);
		frame.getContentPane().add(expenseTextField);
		expenseTextField.setColumns(10);
		
		incomeTextField = new JTextField();
		incomeTextField.setFont(new Font("Tahoma", Font.BOLD, 22));
		incomeTextField.setBackground(new Color(152, 251, 152));
		incomeTextField.setBounds(332, 209, 210, 50);
		frame.getContentPane().add(incomeTextField);
		incomeTextField.setColumns(10);
		
		balanceTextField = new JTextField();
		balanceTextField.setFont(new Font("Tahoma", Font.BOLD, 22));
		balanceTextField.setBackground(new Color(245, 245, 245));
		balanceTextField.setBounds(335, 303, 207, 50);
		frame.getContentPane().add(balanceTextField);
		balanceTextField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\vikram\\Desktop\\img\\save-money.png"));
		lblNewLabel_1.setBounds(345, 17, 46, 48);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
