package com.mycompany.bank_cbs;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.mail.MessagingException;

import com.email.durgesh.Email;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

@SuppressWarnings("unused")
public class Forgot_Password extends JFrame {

	/**
	 * 
	 */
	
	private JPanel contentPane;
	private JTextField userid;
	private JLabel lblNewLabel_1;
	private JTextField emailbox;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forgot_Password frame = new Forgot_Password();
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
	public Forgot_Password() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Username");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(124, 41, 182, 22);
		contentPane.add(lblNewLabel);
		
		userid = new JTextField();
		userid.setHorizontalAlignment(SwingConstants.CENTER);
		userid.setFont(new Font("Tahoma", Font.BOLD, 10));
		userid.setBounds(124, 73, 182, 25);
		contentPane.add(userid);
		userid.setColumns(10);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root123");
					Statement stmt=con.createStatement();
					String sql="Select * from login_details where username='"+userid.getText()+"' and email='"+emailbox.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
						{
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root123");
							Statement stmt1=con.createStatement();
					        String sql1="Select pin FROM login_details where username='"+userid.getText()+"'";
							ResultSet sql1_result=stmt1.executeQuery(sql1);
							while(sql1_result.next()) {
								String pin = rs.getString("Pin");
								Email email=new Email("cmpn.20102a0032@gmail.com","Vibodh@2003");
								email.setFrom("cmpn.20102a0032@gmail.com", "FinVerse PSB");
								email.setSubject("Forgot Password");
								email.setContent("<h1>The Password is:"+pin+"</h1>", "text/html");
								email.addRecipient(emailbox.getText());
								email.send();
							}
								
						} catch (UnsupportedEncodingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (MessagingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
					JOptionPane.showMessageDialog(null, "Check your E-Mail for password");
					setVisible(false);
					dispose();}
					else {
						JOptionPane.showMessageDialog(null, "     !!!No User Found!!!\n  For the Entered Details");
						userid.setText("");
						emailbox.setText("");
						}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Database Connectivity Failed\nContact System Admin");
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(172, 195, 85, 21);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Enter Registered Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(108, 120, 223, 22);
		contentPane.add(lblNewLabel_1);
		
		emailbox = new JTextField();
		emailbox.setHorizontalAlignment(SwingConstants.CENTER);
		emailbox.setFont(new Font("Tahoma", Font.BOLD, 10));
		emailbox.setBounds(120, 152, 186, 25);
		contentPane.add(emailbox);
		emailbox.setColumns(10);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\vibod\\OneDrive\\Desktop\\202-2021100_feather-pen-png-logo-transparent-png-removebg-preview.png"));
		lblNewLabel_2.setBounds(-83, 0, 509, 289);
		contentPane.add(lblNewLabel_2);
	}
}
