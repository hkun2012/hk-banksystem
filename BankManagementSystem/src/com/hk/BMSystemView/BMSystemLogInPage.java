package com.hk.BMSystemView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.hk.BMSystemBusiness.UserBusiness;
import com.hk.model.User;

public class BMSystemLogInPage implements ActionListener {

	private JFrame frame;
	private JTextField mAcccountTextField;
	private JTextField mPasswordTextField;
	private JButton mLoginButton;
	private JButton mExitButton;
	
	private User mCurrentUser = null;
	private UserBusiness mUserBusiness;
	
	private BMSystemAdminPage mAdminPage;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMSystemLogInPage window = new BMSystemLogInPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public BMSystemLogInPage() throws ClassNotFoundException, IOException {
		this.mUserBusiness = new UserBusiness();
		this.mUserBusiness.initialize();
		initialize();
	}
	
	public void setVisible(boolean v) {
		this.frame.setVisible(v);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		
		frame.getContentPane().setFont(new Font("宋体", Font.PLAIN, 14));
		frame.setBounds(100, 100, 355, 154);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel welcomeInfoLable = new JLabel("        HK\u94F6\u884C\u7BA1\u7406\u7CFB\u7EDF");
		welcomeInfoLable.setBounds(0, 0, 253, 36);
		welcomeInfoLable.setFont(new Font("宋体", Font.BOLD, 16));
		frame.getContentPane().add(welcomeInfoLable);
		
		JLabel accountLable = new JLabel("\u8D26\u53F7\uFF1A ");
		accountLable.setFont(new Font("宋体", Font.PLAIN, 14));
		accountLable.setBounds(25, 41, 54, 29);
		frame.getContentPane().add(accountLable);
		
		JLabel passwordLable = new JLabel("\u5BC6\u7801\uFF1A ");
		passwordLable.setFont(new Font("宋体", Font.PLAIN, 14));
		passwordLable.setBounds(25, 80, 54, 25);
		frame.getContentPane().add(passwordLable);
		
		mAcccountTextField = new JTextField();
		mAcccountTextField.setBounds(78, 43, 139, 26);
		frame.getContentPane().add(mAcccountTextField);
		mAcccountTextField.setColumns(10);
		
		mPasswordTextField = new JTextField();
		mPasswordTextField.setBounds(78, 80, 139, 26);
		frame.getContentPane().add(mPasswordTextField);
		mPasswordTextField.setColumns(10);
		
		mLoginButton = new JButton("登陆");
		mLoginButton.setFont(new Font("宋体", Font.PLAIN, 14));
		mLoginButton.setBounds(238, 46, 91, 25);
		frame.getContentPane().add(mLoginButton);
		
		mExitButton = new JButton("退出系统");
		mExitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		mExitButton.setBounds(238, 81, 91, 25);
		frame.getContentPane().add(mExitButton);
		
		mLoginButton.addActionListener(this);
		mExitButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == this.mLoginButton) {
			String accountString = this.mAcccountTextField.getText();
			String passwordString = this.mPasswordTextField.getText();
			
			this.mCurrentUser = this.mUserBusiness.checkPassword(accountString, passwordString);
			if (this.mCurrentUser == null) {
				JOptionPane.showMessageDialog(frame, "密码或账号错误!");
				this.mAcccountTextField.setText("");
				this.mPasswordTextField.setText("");
			} else {
				if (this.mCurrentUser.isAdmin()) {
					frame.setVisible(false);
					this.mAdminPage = new BMSystemAdminPage(frame, mUserBusiness);
					this.mAdminPage.setVisible(true);
				} else {
					
				}
			}
		} else if (ae.getSource() == this.mExitButton) {
			mUserBusiness.userInfoSerialize();
			this.frame.dispose();
		}
	}
}
