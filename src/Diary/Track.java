package Diary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class Track {

	private JFrame frmTracking;
	private JTable table;
	private JTable table2;

	/**
	 * Launch the application.
	 */
	public static void track1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Track window = new Track();
					window.frmTracking.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Track() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTracking = new JFrame();
		frmTracking.setTitle("Tracking");
		frmTracking.setBackground(new Color(255, 250, 250));
		frmTracking.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\vikram\\Desktop\\ALL\\1.png"));
		frmTracking.getContentPane().setForeground(new Color(165, 42, 42));
		frmTracking.setBounds(100, 100, 910, 602);
		frmTracking.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmTracking.getContentPane().setLayout(null);
		
		JDateChooser date21 = new JDateChooser();
		date21.setBackground(Color.GRAY);
		date21.setBounds(180, 40, 161, 32);
		frmTracking.getContentPane().add(date21);
		
		JLabel lblNewLabel = new JLabel("To");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(418, 40, 46, 32);
		frmTracking.getContentPane().add(lblNewLabel);
		
		JDateChooser date22 = new JDateChooser();
		date22.setBounds(528, 40, 167, 32);
		frmTracking.getContentPane().add(date22);
		
		JButton btnNewButton = new JButton("GET");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//	String userName = date21.String();
				//String date2=date21.getDateEditor().getUiComponent();
                String date11 = ((JTextField)date21.getDateEditor().getUiComponent()).getText();
                String date12 = ((JTextField)date22.getDateEditor().getUiComponent()).getText();
                //Date date11 = date21.getDate();
               // Date date12 = date22.getDate();
				//String date11=(null,((JTextField)date21.getDateEditor().getUiComponent()).getText());
				//String date11 = ((table)date21.getDateEditor().getUiComponent()).getText();
				try {
		        	
					 String Driver = "com.mysql.jdbc.Driver";
				        String url = "jdbc:mysql://localhost:3307/diary";
				        String uName ="root";
				        String pwd = "@Root@111";
				        Connection conn=null;
		            Class.forName("com.mysql.jdbc.Driver");
		            conn = DriverManager.getConnection(url, uName, pwd);
		            Statement stmt = conn.createStatement();
		          Statement stmt1 = conn.createStatement();
		            
		            ResultSet rs=stmt.executeQuery("select price,description,payment,date1 from expenses where date1 between '"+date11+"' and '"+date12+"'");
ResultSet rs1=stmt1.executeQuery("select sum(price) from expenses where date1 between'"+date11+"' and '"+date12+"'");
		            
		           // rs.updateString(1, date);
		          //  rs.updateString(2, date1);

		            table.setModel(DbUtils.resultSetToTableModel(rs));
		            table2.setModel(DbUtils.resultSetToTableModel(rs1));
		        }
		        catch(Exception Ex){	
		        }
			}
		});		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.setBounds(745, 40, 89, 32);
		frmTracking.getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setBackground(new Color(176, 196, 222));
		table.setBounds(47, 110, 805, 388);
		frmTracking.getContentPane().add(table);
		
		table2 = new JTable();
		table2.setEnabled(false);
		table2.setShowVerticalLines(false);
		table2.setShowHorizontalLines(false);
		table2.setShowGrid(false);
		table2.setRowSelectionAllowed(false);
		table2.setFont(new Font("Tahoma", Font.BOLD, 17));
		table2.setBackground(new Color(255, 127, 80));
		table2.setBounds(587, 509, 202, 39);
		frmTracking.getContentPane().add(table2);
		
		JLabel lblNewLabel_1 = new JLabel("Total Expenses");
		lblNewLabel_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(400, 516, 146, 32);
		frmTracking.getContentPane().add(lblNewLabel_1);
		
		JButton Home = new JButton("Home");
		Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Nexpenses exp=new Nexpenses();
				frmTracking.hide();
				exp.home1();
			
				
				
			}
		});
		Home.setBackground(new Color(255, 0, 0));
		Home.setFont(new Font("Tahoma", Font.BOLD, 18));
		Home.setBounds(157, 512, 105, 39);
		frmTracking.getContentPane().add(Home);
		
		JLabel lblTrackTraction = new JLabel("Track Transaction");
		lblTrackTraction.setForeground(Color.RED);
		lblTrackTraction.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblTrackTraction.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrackTraction.setBounds(351, 0, 255, 32);
		frmTracking.getContentPane().add(lblTrackTraction);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(109, 83, 64, 25);
		frmTracking.getContentPane().add(lblNewLabel_2);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setForeground(new Color(0, 0, 205));
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescription.setBounds(288, 83, 112, 25);
		frmTracking.getContentPane().add(lblDescription);
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setForeground(new Color(0, 0, 205));
		lblPayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayment.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPayment.setBounds(501, 83, 89, 25);
		frmTracking.getContentPane().add(lblPayment);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(0, 0, 255));
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDate.setBounds(702, 83, 64, 25);
		frmTracking.getContentPane().add(lblDate);
	}
}
