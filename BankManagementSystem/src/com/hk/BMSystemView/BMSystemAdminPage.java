package com.hk.BMSystemView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import com.hk.BMSystemBusiness.UserBusiness;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class BMSystemAdminPage extends JFrame implements ActionListener {
	
	private UserBusiness mUserBusiness;
	private JFrame mMainFrame;

	private JPanel contentPane;
	private JButton mRegistUserButton;
	private JButton mModifyUserButton;
	private JButton mDeleteUserButton;
	private JButton mReturnMainPageButton;
	
	private BMSystemRegistUserPage mRegistPage;
	private BMSystemModifyUserInfoPage mModifyPage;
	private BMSystemDeleteUserPage mDeletePage;
	
	/**
	 * Create the frame.
	 */
	public BMSystemAdminPage(JFrame mainFrame, UserBusiness userBusiness) {
		setResizable(false);
		mUserBusiness = userBusiness;
		mMainFrame = mainFrame;
		
		setTitle("管理员");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 215, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.mRegistUserButton = new JButton("注册用户");
		this.mRegistUserButton.setFont(new Font("宋体", Font.BOLD, 18));
		this.mRegistUserButton.setBounds(0, 0, 199, 53);
		contentPane.add(this.mRegistUserButton);
		
		this.mModifyUserButton = new JButton("修改用户信息");
		this.mModifyUserButton.setFont(new Font("宋体", Font.BOLD, 18));
		this.mModifyUserButton.setBounds(0, 51, 199, 53);
		contentPane.add(this.mModifyUserButton);
		
		mDeleteUserButton = new JButton("删除用户");
		mDeleteUserButton.setBounds(0, 101, 199, 54);
		mDeleteUserButton.setFont(new Font("宋体", Font.BOLD, 18));
		contentPane.add(mDeleteUserButton);
		
		mReturnMainPageButton = new JButton("返回主页面");
		mReturnMainPageButton.setBounds(0, 156, 199, 53);
		mReturnMainPageButton.setFont(new Font("宋体", Font.BOLD, 18));
		contentPane.add(mReturnMainPageButton);
		
		mRegistUserButton.addActionListener(this);
		mModifyUserButton.addActionListener(this);
		mDeleteUserButton.addActionListener(this);
		mReturnMainPageButton.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mRegistUserButton) {
			this.setVisible(false);
			mRegistPage = new BMSystemRegistUserPage(this, mUserBusiness);
			mRegistPage.setVisible(true);
			
		} else if (e.getSource() == mModifyUserButton) {
			this.setVisible(false);
			mModifyPage = new BMSystemModifyUserInfoPage();
			mModifyPage.setVisible(true);
			
		} else if (e.getSource() == mDeleteUserButton) {
			this.setVisible(false);
			mDeletePage = new BMSystemDeleteUserPage();
			mDeletePage.setVisible(true);
			
		} else if (e.getSource() == mReturnMainPageButton){
			this.setVisible(false);
			mMainFrame.setVisible(true);
		}
		
	}

}
