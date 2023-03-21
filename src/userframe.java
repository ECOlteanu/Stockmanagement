import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.security.auth.login.LoginContext;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;



public class userframe  implements ActionListener {

	ImageIcon stock = new ImageIcon("stock.png");
	Image stk =  stock.getImage();
	Image newstk = stk.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH);
	ImageIcon newStock = new ImageIcon(newstk);
	
	ImageIcon vendor = new ImageIcon("vendors.png");
	Image vnd =  vendor.getImage();
	Image newvend = vnd.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH);
	ImageIcon newVendor = new ImageIcon(newvend);
	
	ImageIcon machinery = new ImageIcon("machinery.png");
	Image mch =  machinery.getImage();
	Image newmch = mch.getScaledInstance(75, 75,  java.awt.Image.SCALE_SMOOTH);
	ImageIcon newMachinery = new ImageIcon(newmch);
	
	ImageIcon logout = new ImageIcon("logout.png");
	Image log =  logout.getImage();
	Image newlog = log.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
	ImageIcon newLogout = new ImageIcon(newlog);
	
	ImageIcon userSettings = new ImageIcon("settings.png");
	Image stt =  userSettings.getImage();
	Image newstt = stt.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
	ImageIcon newUserSettings = new ImageIcon(newstt);

		
	JFrame frame = new JFrame();
	JButton stockButton = new JButton(newStock);
	JButton vendorsButton = new JButton(newVendor);
	JButton machineryButton = new JButton(newMachinery);
	JButton logoutButton = new JButton(newLogout);
	JButton usersettingsButton = new JButton(newUserSettings);
	String userinfo = Login.userinfo;
	JLabel userLabel = new JLabel("Hello "+ userinfo);
	JLabel stockLabel = new JLabel("Items Menu");
	JLabel venodrsLabel = new JLabel("Vendors Menu");
	JLabel machineryLabel = new JLabel("Machinery Menu");

	public userframe() {

		

		userLabel.setBounds(120, 10, 115, 14);
		userLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		stockLabel.setBounds(120, 114, 115, 14);
		stockLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		venodrsLabel.setBounds(120, 214, 150, 14);
		venodrsLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		machineryLabel.setBounds(120, 305, 180, 30);
		machineryLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		stockButton.setBounds(30, 80, 80, 80);
		stockButton.setFocusable(false);
		stockButton.setToolTipText("Views, add, modify and remove itmes");
		stockButton.addActionListener(this);
		stockButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		vendorsButton.setBounds(30, 180, 80, 80);
		vendorsButton.setFocusable(false);
		vendorsButton.setToolTipText("Views, add, modify and remove vendors");
		vendorsButton.addActionListener(this);
		vendorsButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		machineryButton.setBounds(30, 280, 80, 80);
		machineryButton.setFocusable(false);
		machineryButton.setToolTipText("Views, add, modify and remove machinery");
		machineryButton.addActionListener(this);
		machineryButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		logoutButton.setBounds(300, 380, 55, 55);
		logoutButton.setFocusable(false);
		logoutButton.setToolTipText("Logout");
		logoutButton.addActionListener(this);
		logoutButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		usersettingsButton.setBounds(300, 26, 55, 55);
		usersettingsButton.setFocusable(false);
		usersettingsButton.setToolTipText("User settings");
		usersettingsButton.addActionListener(this);;
		usersettingsButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		frame.add(userLabel);
		frame.add(stockLabel);
		frame.add(venodrsLabel);
		frame.add(machineryLabel);
		frame.add(stockButton);
		frame.add(vendorsButton);
		frame.add(machineryButton);
		frame.add(logoutButton);
		frame.add(usersettingsButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 400, 500);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setForeground(SystemColor.window);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Cristi Olteanu\\eclipse-workspace\\Stockmanagement\\src\\PngItem_215083.png"));
		frame.setTitle("Home Page");
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {

			
		if(e.getSource() == logoutButton) {
			frame.dispose();
			Login frame = new Login();
	}
		if(e.getSource() == stockButton) {
			frame.dispose();
			items itmes = new items();
	}
		if(e.getSource() == vendorsButton) {
			frame.dispose();
			vendors vendors = new vendors();
	}
		if(e.getSource() == machineryButton) {
			frame.dispose();
			machinery machinery = new machinery();
	}
		if(e.getSource() == usersettingsButton) {
			frame.dispose();
			items itmes = new items();
	}
		
		
		}
		
	}
	

