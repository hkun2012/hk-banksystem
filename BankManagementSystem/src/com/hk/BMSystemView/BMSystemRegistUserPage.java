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
		
		setTitle("�û�ע��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 283, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel accountLabel = new JLabel("��    ��: ");
		accountLabel.setFont(new Font("����", Font.PLAIN, 16));
		accountLabel.setBounds(10, 37, 80, 26);
		contentPane.add(accountLabel);
		
		mAccountTextField = new JTextField();
		mAccountTextField.setEditable(false);
		mAccountTextField.setBounds(100, 37, 157, 26);
		contentPane.add(mAccountTextField);
		mAccountTextField.setColumns(10);
		
		JLabel passwordLable = new JLabel("��    ��: ");
		passwordLable.setFont(new Font("����", Font.PLAIN, 16));
		passwordLable.setBounds(10, 73, 80, 26);
		contentPane.add(passwordLable);
		
		JLabel comfirmPasswordLable = new JLabel("ȷ������: ");
		comfirmPasswordLable.setFont(new Font("����", Font.PLAIN, 16));
		comfirmPasswordLable.setBounds(10, 109, 80, 26);
		contentPane.add(comfirmPasswordLable);
		
		JLabel nameLabel = new JLabel("�û�����: ");
		nameLabel.setFont(new Font("����", Font.PLAIN, 16));
		nameLabel.setBounds(10, 145, 80, 26);
		contentPane.add(nameLabel);
		
		mUserNameTextField = new JTextField();
		mUserNameTextField.setBounds(100, 145, 157, 26);
		contentPane.add(mUserNameTextField);
		mUserNameTextField.setColumns(10);
		
		JLabel ageLabel = new JLabel("��    ��: ");
		ageLabel.setFont(new Font("����", Font.PLAIN, 16));
		ageLabel.setBounds(10, 181, 80, 26);
		contentPane.add(ageLabel);
		
		mAgeTextField = new JTextField();
		mAgeTextField.setBounds(99, 181, 158, 26);
		contentPane.add(mAgeTextField);
		mAgeTextField.setColumns(10);
		
		JLabel genderLabel = new JLabel("��    ��: ");
		genderLabel.setFont(new Font("����", Font.PLAIN, 16));
		genderLabel.setBounds(10, 217, 80, 28);
		contentPane.add(genderLabel);
		
		
		
		mMaleRadioButton= new JRadioButton("��");
		mMaleRadioButton.setFont(new Font("����", Font.PLAIN, 14));
		mMaleRadioButton.setBounds(100, 221, 65, 23);
		contentPane.add(mMaleRadioButton);
		
		mFemaleRadioButton = new JRadioButton("Ů");
		mFemaleRadioButton.setFont(new Font("����", Font.PLAIN, 14));
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
		
		mResetButton = new JButton("����");
		mResetButton.setBounds(20, 256, 104, 23);
		contentPane.add(mResetButton);
		mResetButton.addActionListener(this);
		
		mOKButton = new JButton("ȷ��ע��");
		mOKButton.setBounds(140, 256, 104, 23);
		contentPane.add(mOKButton);
		mOKButton.addActionListener(this);
		
		lblNewLabel = new JLabel(" ��  ��: ");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 9, 80, 23);
		contentPane.add(lblNewLabel);
		
		mFrontRadioButton = new JRadioButton("ǰ̨");
		mFrontRadioButton.setBounds(87, 6, 54, 27);
		contentPane.add(mFrontRadioButton);
		
		mManagerRadioButton = new JRadioButton("����");
		mManagerRadioButton.setBounds(150, 6, 54, 27);
		contentPane.add(mManagerRadioButton);
		
		mControllerRadioButton = new JRadioButton("�ܹ�");
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
				JOptionPane.showMessageDialog(this, "������Ϣ����Ϊ��!");
				return;
			}
			if (!password.equals(comfirmPassword)) {
				mPasswordField.setText("");
				mComfirmPasswordField.setText("");
				JOptionPane.showMessageDialog(this, "������������벻ͬ������������!");
				return;
			}
			
			User newUser = mUserBusiness.registUser(choice, comfirmPassword);
			mUserBusiness.modifyUserInfo(newUser, mUserNameTextField.getText(), mAgeTextField.getText()
					, choice, gender);
			
			if (newUser == null) {
				reset();
				JOptionPane.showMessageDialog(this, "ע��ʧ�ܣ������ԣ�");
				return;
			}
			
			JOptionPane.showMessageDialog(this, "�����˺�Ϊ: " + newUser.getUserId());
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
