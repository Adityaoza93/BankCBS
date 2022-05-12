package com.mycompany.bank_cbs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;

@SuppressWarnings("unused")
public class Login_Final extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Final frame = new Login_Final();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_Final() {
		setTitle("FinVerse PSB - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 900);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(-22, 0, 1588, 802);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-65, 0, 495, 394);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vibod\\OneDrive\\Desktop\\202-2021100_feather-pen-png-logo-transparent-png-removebg-preview.png"));
		
		JLabel lblNewLabel_4 = new JLabel("About Us");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(1229, 273, 280, 25);
		panel.add(lblNewLabel_4);
		
		JTextPane txtpnThisSoftwareIs = new JTextPane();
		txtpnThisSoftwareIs.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtpnThisSoftwareIs.setText("This software is developed as a part of project for JAVA mini-project by Vibodh Bhosure, Aditya Oza and Siddhesh Varpe under the guidance of Prof. Indu Anoop");
		txtpnThisSoftwareIs.setBounds(192, 346, -179, 130);
		panel.add(txtpnThisSoftwareIs);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "FinVerse Bank", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(416, 163, 759, 500);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(275, 5, 208, 206);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\vibod\\OneDrive\\Desktop\\Avatar-Face-Transparent (1).png"));
		
		JLabel lblNewLabel_2 = new JLabel("User ID");
		lblNewLabel_2.setBounds(298, 246, 169, 25);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		username = new JTextField();
		username.setBounds(298, 281, 169, 25);
		panel_1.add(username);
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setFont(new Font("Tahoma", Font.BOLD, 18));
		username.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(298, 331, 169, 25);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		password = new JPasswordField();
		password.setBounds(298, 378, 169, 25);
		panel_1.add(password);
		password.setFont(new Font("Tahoma", Font.BOLD, 18));
		password.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(298, 430, 169, 46);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
    				//Class.forName("com.mysql.jdbc.Driver");
    				Class.forName("com.mysql.cj.jdbc.Driver");
    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root123");
    				Statement stmt=con.createStatement();
    				String sql="Select * from login_details where username='"+username.getText()+"' and Pin='"+password.getText().toString()+"'";
    				ResultSet rs=stmt.executeQuery(sql);
    				if(rs.next())
    					{
    				JOptionPane.showMessageDialog(null, "          Login Sucessful");
    				new Dashboard().setVisible(true);
    				setVisible(false);
    				dispose();
    				}else {
    					JOptionPane.showMessageDialog(null, "     !!!UnAuthorized Access!!!\nCheck Credentials and Try Again");
    					username.setText("");
    					password.setText("");
    					}
    				
    			} catch (Exception e1) {
    				// TODO Auto-generated catch block
    				JOptionPane.showMessageDialog(null, "Database Connectivity Failed\nContact System Admin");
    				e1.printStackTrace();
    			}
        	
			}

			
		});
		
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
			
			JButton btnNewButton_1 = new JButton("Forgot Password");
			btnNewButton_1.setBackground(Color.ORANGE);
			btnNewButton_1.setBounds(715, 715, 166, 25);
			panel.add(btnNewButton_1);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Forgot_Password().setVisible(true);
				}
			});
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JTextPane txtpnThisSoftwareIs_1 = new JTextPane();
			txtpnThisSoftwareIs_1.setBounds(1222, 308, 334, 168);
			panel.add(txtpnThisSoftwareIs_1);
			txtpnThisSoftwareIs_1.setEditable(false);
			txtpnThisSoftwareIs_1.setFont(new Font("Tahoma", Font.BOLD, 17));
			txtpnThisSoftwareIs_1.setBackground(Color.BLUE);
			txtpnThisSoftwareIs_1.setForeground(Color.BLACK);
			txtpnThisSoftwareIs_1.setText("This   software   is developed   as a part of JAVA mini project by Vibodh Bhosure, Aditya Oza   and    Siddhesh Varpe   under   the guidance of       Prof. Indu Anoop");
			
			JLabel lblNewLabel_5 = new JLabel("FinVerse");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblNewLabel_5.setBounds(86, 387, 224, 40);
			panel.add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("Public Sector Bank");
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel_6.setBounds(98, 437, 214, 25);
			panel.add(lblNewLabel_6);
	}
}
