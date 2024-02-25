import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

public class Registration implements ActionListener {

	JFrame frame = new JFrame();
	JButton registerButton = new JButton("Register");
	JButton resetButton = new JButton("Reset");
	JButton backButton = new JButton("Back to Login");
	JRadioButton genderMale = new JRadioButton("Male");
	JRadioButton genderFemale = new JRadioButton("Female");
	ButtonGroup buttonGroup = new ButtonGroup();
	
	JTextField fNameField = new JTextField();
	JTextField LNameField = new JTextField();
	JTextField emailField = new JTextField();
	JTextField phoneField = new JTextField();
	JTextField adressField = new JTextField();
	JTextField userField = new JTextField();
	JPasswordField PasswordField = new JPasswordField();

	
	JLabel fNameLabel = new JLabel("First Name:");
	JLabel LNameLabel = new JLabel("Last Name:");
	JLabel emailLabel = new JLabel("Email:");
	JLabel phoneLabel = new JLabel("Phone No:");
	JLabel adressLabel = new JLabel("Adress:");
	JLabel genderLabel = new JLabel("Gender:");
	JLabel userLabel = new JLabel("User");
	JLabel PasswordLabel = new JLabel("Password:");
	


	public Registration() {
		fNameField.setBounds(170, 57, 232, 20);
		LNameField.setBounds(170, 82, 232, 20);
		emailField.setBounds(170, 167, 232, 20);
		phoneField.setBounds(170, 192, 232, 20);
		PasswordField.setBounds(170, 321, 168, 20);
		adressField.setBounds(170, 107, 232, 20);
		userField.setBounds(170, 296, 168, 20);
		
		fNameLabel.setBounds(26, 58, 115, 14);
		LNameLabel.setBounds(26, 83, 115, 14);
		emailLabel.setBounds(26, 168, 115, 14);
		phoneLabel.setBounds(26, 193, 115, 14);
		PasswordLabel.setBounds(26, 321, 78, 14);
		adressLabel.setBounds(26, 108, 115, 14);
		userLabel.setBounds(26, 297, 115, 14);
		genderLabel.setBounds(26, 258, 115, 14);
		
		genderMale.setBounds(128, 254, 67, 23);
		buttonGroup.add(genderMale);
		genderFemale.setBounds(197, 254, 73, 23);
		buttonGroup.add(genderFemale);
		
		registerButton.setBounds(26, 384, 115, 41);
		registerButton.setFocusable(false);
		registerButton.addActionListener(this);
		registerButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		resetButton.setBounds(152, 384, 115, 41);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		resetButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		backButton.setBounds(278, 384, 145, 41);
		backButton.setFocusable(false);
		backButton.addActionListener(this);
		backButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		

		frame.add(fNameField);
		frame.add(LNameField);
		frame.add(emailField);
		frame.add(phoneField);
		frame.add(emailField);
		frame.add(PasswordField);
		frame.add(adressField);
		frame.add(userField);

		frame.add(fNameLabel);
		frame.add(LNameLabel);
		frame.add(emailLabel);
		frame.add(phoneLabel);
		frame.add(emailLabel);
		frame.add(PasswordLabel);
		frame.add(adressLabel);
		frame.add(userLabel);
		frame.add(genderLabel);
		frame.add(genderMale);
		frame.add(genderFemale);
		frame.add(registerButton);
		frame.add(resetButton);
		frame.add(backButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 461, 495);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setForeground(SystemColor.window);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Cristi Olteanu\\Downloads\\PngItem_771530.png"));
		frame.setTitle("Registration Page");
		
	}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == resetButton) {
				fNameField.setText("");
				LNameField.setText("");
				adressField.setText("");
				emailField.setText("");
				phoneField.setText("");
				userField.setText("");
				PasswordField.setText("");
				buttonGroup.clearSelection();
			}
			
		if(e.getSource() == registerButton) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","root");
					Statement stm = con.createStatement();
					String query="insert into registration values(?,?,?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, fNameField.getText());
					ps.setString(2, LNameField.getText());
					ps.setString(3, adressField.getText());
					ps.setString(4, emailField.getText());
					ps.setString(5, phoneField.getText());
					if(genderMale.isSelected()) 
						ps.setString(6, genderMale.getText());
					else 
						ps.setString(6, genderFemale.getText());
					ps.setString(7, userField.getText());
					ps.setString(8, PasswordField.getText());
					
					
					
					
					int i=ps.executeUpdate();
					JOptionPane.showMessageDialog(registerButton, i+ " User successfully created!");
					ps.close();
					con.close();

	

					
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
			}
				}
			if(e.getSource() == backButton) {
				frame.dispose();
				Login frame = new Login();
		}
			}
			
	}

