package com.hk.BMSystemView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.hk.BMSystemBusiness.UserBusiness;
import com.hk.user.User;

public class BMSystemLogInPage implements ActionListener {

	private JFrame frame;
	private JTextField mAcccountTextField;
	private JTextField mPasswordTextField;
	private JButton mLoginButton;
	
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
	 */
	public BMSystemLogInPage() {
		this.mUserBusiness = new UserBusiness();
		this.mUserBusiness.initialize();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 355, 154);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel welcomeInfoLable = new JLabel("        HK\u94F6\u884C\u7BA1\u7406\u7CFB\u7EDF");
		welcomeInfoLable.setBounds(0, 0, 253, 36);
		welcomeInfoLable.setFont(new Font("ÀŒÃÂ", Font.BOLD, 16));
		frame.getContentPane().add(welcomeInfoLable);
		
		JLabel accountLable = new JLabel("\u8D26\u53F7\uFF1A ");
		accountLable.setFont(new Font("ÀŒÃÂ", Font.PLAIN, 14));
		accountLable.setBounds(25, 41, 54, 29);
		frame.getContentPane().add(accountLable);
		
		JLabel passwordLable = new JLabel("\u5BC6\u7801\uFF1A ");
		passwordLable.setFont(new Font("ÀŒÃÂ", Font.PLAIN, 14));
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
		
		mLoginButton = new JButton("µ«¬Ω");
		mLoginButton.setFont(new Font("ÀŒÃÂ", Font.PLAIN, 18));
		mLoginButton.setBounds(227, 54, 91, 43);
		frame.getContentPane().add(mLoginButton);
		
		mLoginButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == this.mLoginButton) {
			String accountString = this.mAcccountTextField.getText();
			String passwordString = this.mPasswordTextField.getText();
			
			this.mCurrentUser = this.mUserBusiness.checkPassword(accountString, passwordString);
			if (this.mCurrentUser == null) {
				JOptionPane.showMessageDialog(frame, "√‹¬ÎªÚ’À∫≈¥ÌŒÛ!");
				this.mAcccountTextField.setText("");
				this.mPasswordTextField.setText("");
			} else {
				if (this.mCurrentUser.isAdmin()) {
					frame.setVisible(false);
					this.mAdminPage = new BMSystemAdminPage(frame, mUserBusiness);
					this.mAdminPage.setVisible(true);
				}
			}
		}
	}
}
