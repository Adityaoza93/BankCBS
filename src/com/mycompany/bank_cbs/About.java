package com.mycompany.bank_cbs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setTitle("About - FinVerse PSB");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(165, 30, 1368, 796);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vibod\\OneDrive\\Desktop\\202-2021100_feather-pen-png-logo-transparent-png-removebg-preview.png"));
		lblNewLabel.setBounds(692, 116, 608, 405);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("FinVerse PSB");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 80));
		lblNewLabel_3.setBounds(702, 505, 547, 114);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Developers:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(55, 60, 196, 121);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Vibodh Bhosure");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(55, 151, 290, 37);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Aditya Oza");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(55, 191, 290, 37);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Siddhesh Varpe");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_2.setBounds(55, 233, 290, 37);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Guide:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(55, 280, 196, 121);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Prof. Indu Anoop");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_2_1.setBounds(55, 364, 290, 37);
		contentPane.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_3 = new JLabel("20102A0032");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_3.setBounds(355, 151, 290, 37);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("20102A0031");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_1_1.setBounds(355, 191, 290, 37);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("20102A0023");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_2_2.setBounds(355, 233, 290, 37);
		contentPane.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("-");
		lblNewLabel_2_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_2_2_1.setBounds(176, 233, 290, 37);
		contentPane.add(lblNewLabel_2_2_2_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("-");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_1_1_1.setBounds(176, 191, 290, 37);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("-");
		lblNewLabel_2_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_3_1.setBounds(176, 151, 290, 37);
		contentPane.add(lblNewLabel_2_3_1);
	}
}
