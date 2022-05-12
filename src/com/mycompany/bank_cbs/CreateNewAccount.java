package com.mycompany.bank_cbs;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import com.email.durgesh.Email;
import javax.mail.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.util.*;
import java.util.Date;

import com.email.durgesh.Email;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class CreateNewAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateNewAccount frame = new CreateNewAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CreateNewAccount() throws ParseException {
		setTitle("New Customer - FinVerse PSB");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(165, 30, 1368, 796);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Random random = new Random();
		String generatePin = String.format("%04d", random.nextInt(1000000));     
		
		Random random_ac = new Random();
		String generateac = String.format("%04d", random_ac.nextInt(10000000));
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(1035, 278, 176, 21);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		contentPane.add(dateChooser);
		dateChooser.setDateFormatString("dd/MM/yyyy");
	
		JLabel lblNewLabel_3 = new JLabel("Account Number");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(309, 222, 160, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Aadhar Number");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(309, 284, 160, 24);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Account Type");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setBounds(309, 353, 160, 24);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Gender");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_7.setBounds(309, 426, 160, 24);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Address");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_8.setBounds(309, 492, 160, 24);
		contentPane.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBackground(Color.BLUE);
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setBounds(519, 227, 176, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Verify");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String otp = textField_9.getText();
				if(otp.equals(generatePin)) {
					JOptionPane.showMessageDialog(null, "OTP Verified Successfully\nPlease Submit the Form");
				}
			}
		});
		btnNewButton_4.setBackground(Color.ORANGE);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setBounds(1035, 596, 176, 21);
		contentPane.add(btnNewButton_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Indian", "NRI"}));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setBounds(1035, 356, 176, 21);
		contentPane.add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setBounds(519, 290, 176, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_3.setBounds(519, 359, 176, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_4.setBounds(519, 483, 176, 50);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton.setBounds(519, 406, 176, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female\r\n\r\n");
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton_1.setForeground(new Color(0, 0, 0));
		rdbtnNewRadioButton_1.setBounds(519, 445, 176, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		
		
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					 String gend = null;
					
				    if(rdbtnNewRadioButton.isSelected()&&rdbtnNewRadioButton_1.isSelected()) {
							JOptionPane.showMessageDialog(null, "Select one gender option");
						}
					 
					if(rdbtnNewRadioButton.isSelected()) {
						gend = "Male";
					}
					
					if(rdbtnNewRadioButton_1.isSelected()) {
						gend = "Female";
					}
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root123");
					Statement stmt_up=con.createStatement();
					DateFormat df = new SimpleDateFormat("dd/MM/yyy");
					String sql_acr="INSERT INTO acc_details (acc_no,aadhar_number,account_type,email,phone_number,address,balance,name,nationality,dob,gender) VALUES ('"+textField.getText()+"','"+textField_2.getText()+"','"+textField_3.getText()+"','"+textField_8.getText()+"','"+textField_1.getText()+"','"+textField_4.getText()+"','0','"+textField_5.getText()+"','"+comboBox.getSelectedItem().toString()+"','"+df.format(dateChooser.getDate())+"','"+gend+"')";
					if(textField_8.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Enter Email and complete verification ");
					}
					else
					{
					boolean b_up = stmt_up.execute(sql_acr);
					JOptionPane.showMessageDialog(null, "Account Successfully Created");
					dispose();}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Database Connectivity Failed\nContact System Admin");
					dispose();
					
				}
				
				
			}
		});
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(474, 668, 170, 25);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_9 = new JLabel("Name");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_9.setBounds(845, 222, 160, 24);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Date of Birth");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_10.setBounds(845, 273, 160, 24);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Nationality");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_11.setBounds(845, 353, 160, 24);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_13 = new JLabel("Email");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_13.setBounds(845, 426, 160, 24);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("OTP");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_14.setBounds(845, 545, 160, 24);
		contentPane.add(lblNewLabel_14);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_5.setBounds(1035, 227, 176, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_8.setBounds(1035, 429, 176, 21);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		
		
		textField.setText(generateac);
		
		JButton btnNewButton_3 = new JButton("Get OTP");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Email email=new Email("cmpn.20102a0032@gmail.com","Vibodh@2003");
				try {
					email.setFrom("cmpn.20102a0032@gmail.com", "FinVerse PSB");
					email.setSubject("Welcome to FinVerse PSB");
					email.setContent("<h1>Thank you for onboarding FinVerse PSB. Please share code "+generatePin+" with the executive to complete the process. Your Account Number is "+textField.getText()+"</h1>", "text/html");
					email.addRecipient(textField_8.getText());
					email.send();
					JOptionPane.showMessageDialog(null, "Check your E-Mail for code");
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_3.setBackground(Color.ORANGE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(1035, 495, 176, 21);
		contentPane.add(btnNewButton_3);
		
		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_9.setBounds(1035, 551, 176, 21);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		
	
		
		JButton btnNewButton_5 = new JButton("Clear");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_8.setText("");
				textField_9.setText("");				
			}
		});
		btnNewButton_5.setBackground(Color.ORANGE);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_5.setBounds(999, 668, 170, 25);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vibod\\OneDrive\\Desktop\\WhatsApp Image 2021-11-09 at 9.22.53 AM.jpeg"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(712, 41, 135, 145);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\vibod\\OneDrive\\Desktop\\202-2021100_feather-pen-png-logo-transparent-png-removebg-preview.png"));
		lblNewLabel_1.setBounds(495, 178, 559, 480);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New Customer Onboarding");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(34, 78, 435, 57);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Disclaimer: \r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_4.setBounds(34, 145, 230, 24);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_12 = new JLabel("Proceed after approval");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_12.setBounds(34, 184, 403, 75);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_12_1 = new JLabel("from Sr. Manager");
		lblNewLabel_12_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_12_1.setBounds(34, 222, 403, 75);
		contentPane.add(lblNewLabel_12_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Phone Number");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6_1.setBounds(309, 554, 160, 24);
		contentPane.add(lblNewLabel_6_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(519, 554, 176, 21);
		contentPane.add(textField_1);
		
		
	}
}
