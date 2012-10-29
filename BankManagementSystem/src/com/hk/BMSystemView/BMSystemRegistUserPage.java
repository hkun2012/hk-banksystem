package com.hk.BMSystemView;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.hk.BMSystemBusiness.UserBusiness;
import com.hk.user.User;

public class BMSystemRegistUserPage extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private UserBusiness mUserBusiness;
	private JFrame mAdminFrame;
	
	private JPanel contentPane;
	private JTextField mAccountTextField;
	private JTextField mUserNameTextField;
	private JTextField mAgeTextField;
	private JPasswordField mPasswordField;
	private JPasswordField mComfirmPasswordField;
	private JRadioButton mMaleRadioButton;
	private JRadioButton mFemaleRadioButton;
	private JButton mResetButton;
	private JButton mOKButton;
	private JLabel lblNewLabel;
	private JRadioButton mFrontRadioButton;
	private JRadioButton mManagerRadioButton;
	private JRadioButton mControllerRadioButton;
	private ButtonGroup mGenderButtonGroup = new ButtonGroup();
	private ButtonGroup mTypeButtonGroup = new ButtonGroup();
	/**
	 * Create the frame.
	 */
	public BMSystemRegistUserPage(JFrame adminFrame, UserBusiness userBusiness) {
		setResizable(false);
		mUserBusiness = userBusiness;
		mAdminFrame = adminFrame;
		
		setTitle("用户注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 283, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel accountLabel = new JLabel("账    号: ");
		accountLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		accountLabel.setBounds(10, 37, 80, 26);
		contentPane.add(accountLabel);
		
		mAccountTextField = new JTextField();
		mAccountTextField.setEditable(false);
		mAccountTextField.setBounds(100, 37, 157, 26);
		contentPane.add(mAccountTextField);
		mAccountTextField.setColumns(10);
		
		JLabel passwordLable = new JLabel("密    码: ");
		passwordLable.setFont(new Font("宋体", Font.PLAIN, 16));
		passwordLable.setBounds(10, 73, 80, 26);
		contentPane.add(passwordLable);
		
		JLabel comfirmPasswordLable = new JLabel("确认密码: ");
		comfirmPasswordLable.setFont(new Font("宋体", Font.PLAIN, 16));
		comfirmPasswordLable.setBounds(10, 109, 80, 26);
		contentPane.add(comfirmPasswordLable);
		
		JLabel nameLabel = new JLabel("用户姓名: ");
		nameLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		nameLabel.setBounds(10, 145, 80, 26);
		contentPane.add(nameLabel);
		
		mUserNameTextField = new JTextField();
		mUserNameTextField.setBounds(100, 145, 157, 26);
		contentPane.add(mUserNameTextField);
		mUserNameTextField.setColumns(10);
		
		JLabel ageLabel = new JLabel("年    龄: ");
		ageLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		ageLabel.setBounds(10, 181, 80, 26);
		contentPane.add(ageLabel);
		
		mAgeTextField = new JTextField();
		mAgeTextField.setBounds(99, 181, 158, 26);
		contentPane.add(mAgeTextField);
		mAgeTextField.setColumns(10);
		
		JLabel genderLabel = new JLabel("性    别: ");
		genderLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		genderLabel.setBounds(10, 217, 80, 28);
		contentPane.add(genderLabel);
		
		
		
		mMaleRadioButton= new JRadioButton("男");
		mMaleRadioButton.setFont(new Font("宋体", Font.PLAIN, 14));
		mMaleRadioButton.setBounds(100, 221, 65, 23);
		contentPane.add(mMaleRadioButton);
		
		mFemaleRadioButton = new JRadioButton("女");
		mFemaleRadioButton.setFont(new Font("宋体", Font.PLAIN, 14));
		mFemaleRadioButton.setBounds(189, 221, 65, 23);
		contentPane.add(mFemaleRadioButton);
		
		mGenderButtonGroup.add(mFemaleRadioButton);
		mGenderButtonGroup.add(mMaleRadioButton);
		
		mPasswordField = new JPasswordField();
		mPasswordField.setBounds(100, 76, 157, 26);
		contentPane.add(mPasswordField);
		
		mComfirmPasswordField = new JPasswordField();
		mComfirmPasswordField.setBounds(100, 112, 157, 26);
		contentPane.add(mComfirmPasswordField);
		
		mResetButton = new JButton("重置");
		mResetButton.setBounds(20, 256, 104, 23);
		contentPane.add(mResetButton);
		mResetButton.addActionListener(this);
		
		mOKButton = new JButton("确认注册");
		mOKButton.setBounds(140, 256, 104, 23);
		contentPane.add(mOKButton);
		mOKButton.addActionListener(this);
		
		lblNewLabel = new JLabel(" 身  份: ");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 9, 80, 23);
		contentPane.add(lblNewLabel);
		
		mFrontRadioButton = new JRadioButton("前台");
		mFrontRadioButton.setBounds(87, 6, 54, 27);
		contentPane.add(mFrontRadioButton);
		
		mManagerRadioButton = new JRadioButton("经理");
		mManagerRadioButton.setBounds(150, 6, 54, 27);
		contentPane.add(mManagerRadioButton);
		
		mControllerRadioButton = new JRadioButton("总管");
		mControllerRadioButton.setBounds(208, 6, 53, 27);
		contentPane.add(mControllerRadioButton);
		
		mTypeButtonGroup.add(mFrontRadioButton);
		mTypeButtonGroup.add(mManagerRadioButton);
		mTypeButtonGroup.add(mControllerRadioButton);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mResetButton) {
			reset();
		} else if (e.getSource() == mOKButton) {
			String password = String.valueOf(mPasswordField.getPassword());
			String comfirmPassword = String.valueOf(mComfirmPasswordField.getPassword());
			int choice = WhichTypeSelected();
			int gender = whichGenderSelected();
			
			if (password.length() == 0 || comfirmPassword.length() == 0
					|| mUserNameTextField.getText().equals("") || mAgeTextField.getText().equals("")
					|| choice == 0 || gender == 3) {
				JOptionPane.showMessageDialog(this, "各项信息不能为空!");
				return;
			}
			if (!password.equals(comfirmPassword)) {
				mPasswordField.setText("");
				mComfirmPasswordField.setText("");
				JOptionPane.showMessageDialog(this, "两次输入的密码不同，请重新输入!");
				return;
			}
			
			User newUser = mUserBusiness.registUser(choice, comfirmPassword);
			mUserBusiness.modifyUserInfo(newUser, mUserNameTextField.getText(), mAgeTextField.getText()
					, choice, gender);
			
			if (newUser == null) {
				reset();
				JOptionPane.showMessageDialog(this, "注册失败，请重试！");
				return;
			}
			
			JOptionPane.showMessageDialog(this, "您的账号为: " + newUser.getUserId());
			mAccountTextField.setText(newUser.getUserId());
			mAdminFrame.setVisible(true);
			this.dispose();
		}
	}
	
	private int whichGenderSelected() {
		if (mMaleRadioButton.isSelected())
			return 1;
		if (mFemaleRadioButton.isSelected())
			return 2;
		return 3;
	}
	
	private int WhichTypeSelected() {
		if (mFrontRadioButton.isSelected())
			return 1;
		if (mManagerRadioButton.isSelected())
			return 2;
		if (mControllerRadioButton.isSelected())
			return 3;
		return 0;
	}
	
	private void reset(){
		mGenderButtonGroup.clearSelection();
		mTypeButtonGroup.clearSelection();
		mPasswordField.setText("");
		mComfirmPasswordField.setText("");
		mUserNameTextField.setText("");
		mAgeTextField.setText("");
	}
 }
