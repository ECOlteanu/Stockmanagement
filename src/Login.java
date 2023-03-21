import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

public class Login implements ActionListener {

	public static String userinfo;
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JButton registerButton = new JButton("Register");
	
	JTextField userField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JLabel userLabel = new JLabel("User");
	JLabel passwordLabel = new JLabel("Password:");


	public Login() {
		
		userLabel.setBounds(26, 36, 72, 14);
		passwordLabel.setBounds(27, 83, 78, 14);
		
		userField.setBounds(26, 52, 182, 26);
		passwordField.setBounds(26, 100, 182, 26);
		
		loginButton.setBounds(26, 168, 89, 23);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		resetButton.setBounds(125, 168, 92, 23);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		resetButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		registerButton.setBounds(75, 202, 101, 23);
		registerButton.setFocusable(false);
		registerButton.addActionListener(this);
		registerButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		frame.add(userLabel);
		frame.add(passwordLabel);
		frame.add(userField);
		frame.add(passwordField);
		
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(registerButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 264, 300);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setForeground(SystemColor.window);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Cristi Olteanu\\Desktop\\\u2014Pngtree\u2014user login or authenticate icon_5089976.png"));
		frame.setTitle("Login Page");
		
	}
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == resetButton) {
				userField.setText("");
				passwordField.setText("");
			}
			
			if(e.getSource() == loginButton) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","root");
					Statement stm = con.createStatement();
					String sql="Select * from registration where user='"+userField.getText()+"' and password='"+passwordField.getText().toString()+"'";
					ResultSet rs =stm.executeQuery(sql);
					if(rs.next()){
						frame.dispose();		
						userinfo = userField.getText();

						userframe userframe = new userframe();
					}
						else 
							JOptionPane.showMessageDialog(null, "Incorrect User or Password..");
				
						class user{
							public String user = userField.getText();
						}
							
						
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

			}
			if(e.getSource() == registerButton) {
				frame.dispose();
				Registration frame = new Registration();
		}
	}
		
		}

