package Diary;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.*;
import javax.swing.*;
//import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmLogin;
	//private JTextField value1;
	private JTextField tuname;
	private JTextField value1;
	private JLabel lblUserName;
	private JLabel lblPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		//actionEvent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\vikram\\Desktop\\img\\profit.png"));
		frmLogin.getContentPane().setBackground(new Color(240, 255, 240));
		frmLogin.setBackground(Color.CYAN);
		frmLogin.setBounds(100, 100, 536, 377);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel title = new JLabel("Login");
		title.setBounds(245, 25, 97, 33);
		title.setForeground(Color.red);
		title.setFont(new Font("Tahoma", Font.BOLD, 26));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		//JPasswordField value = new JPasswordField(); 
		value1 = new JTextField();
		frmLogin.getContentPane().setLayout(null);
		frmLogin.getContentPane().add(title);
		
		tuname = new JTextField();
		tuname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tuname.setBounds(369, 99, 116, 30);
		frmLogin.getContentPane().add(tuname);
		tuname.setColumns(10);
		
		value1 = new JTextField();
		
		JPasswordField value1 = new JPasswordField(); 
		value1.setColumns(10);
		value1.setBounds(369, 181, 116, 30);
		frmLogin.getContentPane().add(value1);
		
		lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUserName.setBounds(215, 95, 116, 33);
		frmLogin.getContentPane().add(lblUserName);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(215, 177, 116, 33);
		frmLogin.getContentPane().add(lblPassword);
		
		JButton blogin = new JButton("Login");
		blogin.setSelectedIcon(null);
		blogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = tuname.getText();
                String password = value1.getText();
                try {
                	//----
                	String Driver = "com.mysql.jdbc.Driver";
			        String url = "jdbc:mysql://localhost:3307/diary";
			        String uName ="root";
			        String pwd = "@Root@111";
			        Connection connection=null;

		            Class.forName("com.mysql.jdbc.Driver");
		            connection = DriverManager.getConnection(url, uName, pwd);
                	 PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select tuname, tpass from login where tuname=? and tpass=?");
                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                    	Nexpenses exp=new Nexpenses();
                    	frmLogin.hide();
        				exp.home1();
                    	 
                    } else {
                    	 JOptionPane.showMessageDialog(null,"Please Enter Valid UserName and PassWord");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                } catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
            }
				
			
		});
		blogin.setBackground(Color.GREEN);
		blogin.setFont(new Font("Tahoma", Font.BOLD, 17));
		blogin.setBounds(226, 265, 89, 33);
		frmLogin.getContentPane().add(blogin);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tuname.setText("");
				value1.setText("");
			}
		});
		reset.setBackground(Color.RED);
		reset.setFont(new Font("Tahoma", Font.BOLD, 16));
		reset.setBounds(405, 265, 89, 33);
		frmLogin.getContentPane().add(reset);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vikram\\Desktop\\img\\Admin.png"));
		lblNewLabel.setBounds(10, 48, 195, 219);
		frmLogin.getContentPane().add(lblNewLabel);
		
		
	}
}
