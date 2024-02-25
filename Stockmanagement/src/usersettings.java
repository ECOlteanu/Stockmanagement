import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class usersettings implements ActionListener  {
	

	public static String userinfo;
	JFrame frame = new JFrame();
	JButton backButton = new JButton("Back");
	JButton saveButton = new JButton("Save ");
	JButton searchButton = new JButton("Search User");
	
	JTextField fNameField = new JTextField();
	JTextField LNameField = new JTextField();
	JTextField emailField = new JTextField();
	JTextField phoneField = new JTextField();
	JTextField adressField = new JTextField();
	JTextField userField = new JTextField();
	JPasswordField PasswordField = new JPasswordField();
	JPasswordField NewPasswordField = new JPasswordField();
	JPasswordField ConfirmNewPasswordField = new JPasswordField();
	JTextField genderField = new JTextField();
	
	JLabel fNameLabel = new JLabel("First Name:");
	JLabel LNameLabel = new JLabel("Last Name:");
	JLabel emailLabel = new JLabel("Email:");
	JLabel phoneLabel = new JLabel("Phone No:");
	JLabel adressLabel = new JLabel("Adress:");
	JLabel genderLabel = new JLabel("Gender:");
	JLabel userLabel = new JLabel("User");
	JLabel PasswordLabel = new JLabel("Password:");
	JLabel NewPasswordLabel = new JLabel("New Password:");
	JLabel ConfirmNewPasswordLabel = new JLabel("Confirm Password:");
	JLabel messageLable = new JLabel ("");
	
	
	
	 public usersettings(){
		 
		NewPasswordField.setText("");
		ConfirmNewPasswordField.setText("");
		 
		//Labels
		fNameLabel.setBounds(26, 58, 115, 14);
		LNameLabel.setBounds(26, 83, 115, 14);
		adressLabel.setBounds(26, 108, 115, 14);
		emailLabel.setBounds(26, 168, 115, 14);
		phoneLabel.setBounds(26, 193, 115, 14);
		genderLabel.setBounds(26, 258, 115, 14); 
		messageLable.setBounds(172, 416, 368, 20);
		messageLable.setFocusable(false);
		messageLable.setVisible(false);
		
		userLabel.setBounds(26, 296, 115, 14);
		PasswordLabel.setBounds(26, 321, 78, 14);
		NewPasswordLabel.setBounds(26, 366, 178, 14);
		ConfirmNewPasswordLabel.setBounds(26, 391, 178, 14);
		 
		//Fields
		fNameField.setBounds(170, 57, 232, 20);
		LNameField.setBounds(170, 82, 232, 20);
		adressField.setBounds(170, 107, 232, 20);
		emailField.setBounds(170, 167, 232, 20);
		phoneField.setBounds(170, 192, 232, 20);
		genderField.setBounds(170, 254, 67, 23);
		
		userField.setBounds(170, 296, 168, 20);
		userField.setFocusable(false);
		PasswordField.setBounds(170, 321, 168, 20);
		PasswordField.setFocusable(false);
		NewPasswordField.setBounds(170, 366, 168, 20);
		ConfirmNewPasswordField.setBounds(170, 391, 168, 20);
		
		//Buttons
		backButton.setBounds(16, 550, 145, 41);
		backButton.setFocusable(false);
		backButton.addActionListener(this);
		backButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		saveButton.setBounds(172, 550, 145, 41);
		saveButton.setFocusable(false);
		saveButton.addActionListener(this);
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		 
		searchButton.setBounds(328, 550, 145, 41);
		searchButton.setFocusable(false);
		searchButton.addActionListener(this);
		searchButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		frame.add(NewPasswordLabel);
		frame.add(ConfirmNewPasswordLabel);
		frame.add(NewPasswordField);
		frame.add(ConfirmNewPasswordField);
		frame.add(fNameField);
		frame.add(LNameField);
		frame.add(emailField);
		frame.add(phoneField);
		frame.add(emailField);
		frame.add(genderField);
		frame.add(PasswordField);
		frame.add(adressField);
		frame.add(userField);

		frame.add(messageLable);
		frame.add(fNameLabel);
		frame.add(LNameLabel);
		frame.add(emailLabel);
		frame.add(phoneLabel);
		frame.add(emailLabel);
		frame.add(PasswordLabel);
		frame.add(adressLabel);
		frame.add(userLabel);
		frame.add(genderLabel); 
		
		frame.add(backButton);
		frame.add(saveButton);
	

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 700);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setForeground(SystemColor.window);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("settings.png"));
		frame.setTitle("User Settings");
		
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_management_database","root","root");
            String query = "SELECT user_name , first_name, last_name, address, email, phone, gender, password, user_level, user_status " +
                           "FROM users WHERE user_name = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, Login.userinfo);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) 
                {
                	String userName = resultSet.getString("user_name");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String address = resultSet.getString("address");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    String gender = resultSet.getString("gender");
                    String passwordResult = resultSet.getString("password");
                    int userLevel = resultSet.getInt("user_level");
                    int userStatus = resultSet.getInt("user_status");
                    
            		fNameField.setText(firstName);
            		LNameField.setText(lastName);
            		adressField.setText(address);
            		emailField.setText(email);
            		phoneField.setText(phone); 
            		genderField.setText(gender);
            		userField.setText(userName);
            		PasswordField.setText(passwordResult);
            		
            		if (userLevel == 0) {
            			frame.add(searchButton);
            			}
                }
                resultSet.close();
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backButton) {
			frame.dispose();
			userframe userframe = new userframe();
	}
		if(e.getSource() == saveButton) {
			
				//Change pass
				if (NewPasswordField.getText().equals(ConfirmNewPasswordField.getText() )&& !PasswordField.getText().equals(NewPasswordField.getText()))
				{
					PasswordField.setText(NewPasswordField.getText()); 
					messageLable.setFocusable(true);
					messageLable.setVisible(true);
					messageLable.setForeground(Color.green);
					messageLable.setText("Password successfully changed");
					NewPasswordField.setText("");
					ConfirmNewPasswordField.setText("");
				}else if(NewPasswordField.getText().equals(ConfirmNewPasswordField.getText() )&& PasswordField.getText().equals(NewPasswordField.getText())) 
				{
					messageLable.setFocusable(true);
					messageLable.setVisible(true);
					messageLable.setForeground(Color.RED);
					messageLable.setText("New password the same as old password!!");
					
				}			
				//new pass and confirm pass are different
				else if (!NewPasswordField.getText().equals(ConfirmNewPasswordField.getText()))
				{
					//JOptionPane.showMessageDialog(null, "New password and confirm password are not the same!!");
					messageLable.setFocusable(true);
					messageLable.setVisible(true);
					messageLable.setForeground(Color.RED);
					messageLable.setText("New / confirm password don't match!!!!");
				
				}
				
			
	}
		
		
		
	}
}
  

