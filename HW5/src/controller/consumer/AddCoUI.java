package controller.consumer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.member.AddEmErrorUI;
import controller.member.AddEmSuccessUI;
import model.Consumer;
import service.impl.ConsumerServiceImpl;
import service.impl.MemberServiceImpl;

import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AddCoUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField mobile;
	private JTextField consumerno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCoUI frame = new AddCoUI();
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
	public AddCoUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setLayout(null);
		panel.setBounds(10, 10, 548, 61);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("新增會員資料");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 25));
		lblNewLabel_1.setBounds(193, 10, 157, 34);
		panel.add(lblNewLabel_1);
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 87, 548, 418);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("姓名");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(57, 75, 52, 30);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("帳號");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 25));
		lblNewLabel_1_1_1.setBounds(56, 129, 52, 30);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("密碼");
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 25));
		lblNewLabel_1_1_1_1.setBounds(57, 183, 52, 30);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("地址");
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 25));
		lblNewLabel_1_1_1_1_1_1.setBounds(58, 243, 52, 30);
		panel_1.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("電話");
		lblNewLabel_1_1_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 25));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(58, 293, 52, 30);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1);
		
		name = new JTextField();
		name.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		name.setColumns(10);
		name.setBounds(159, 75, 286, 34);
		panel_1.add(name);
		
		username = new JTextField();
		username.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		username.setColumns(10);
		username.setBounds(158, 129, 286, 34);
		panel_1.add(username);
		
		password = new JTextField();
		password.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		password.setColumns(10);
		password.setBounds(159, 183, 286, 34);
		panel_1.add(password);
		
		address = new JTextField();
		address.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		address.setColumns(10);
		address.setBounds(160, 239, 286, 34);
		panel_1.add(address);
		
		mobile = new JTextField();
		mobile.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		mobile.setColumns(10);
		mobile.setBounds(160, 293, 286, 34);
		panel_1.add(mobile);
		
		JButton btnNewButton = new JButton("註冊");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username = username.getText();
		        String Password = password.getText();
		        // 帳號與密碼格式驗證

		        if (!Username.matches("^[a-zA-Z0-9]{6,15}$")) {
		            JOptionPane.showMessageDialog(null, "帳號格式錯誤！\n請使用 6-15 位英數字。");
		            return;
		        }
		        
		        if (!Password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$")) {
		            JOptionPane.showMessageDialog(null, "密碼格式錯誤！\n密碼需包含 8-15 位，至少一個英文字母、一個數字及一個特殊符號。");
		            return;
		        }

		        {
		            if (new ConsumerServiceImpl().isUsernameBeenUse(Username)) {
		                AddCoErrorUI addConsumerError = new AddCoErrorUI();
		                addConsumerError.setVisible(true);
		                dispose();
		            } else {
		                String Consumerno = consumerno.getText();
		                String Name = name.getText();
		                String Address = address.getText();
		                String Mobile = mobile.getText();

		                Consumer consumer = new Consumer(Consumerno, Name, Username, Password, Address, Mobile);
		                
		                new ConsumerServiceImpl().addConsumer(consumer);

		                AddCoSuccessUI addConsumerSuccess = new AddCoSuccessUI();
		                addConsumerSuccess.setVisible(true);
		                dispose();
		            }
		        }
		    }
		});

		btnNewButton.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		btnNewButton.setBounds(199, 362, 142, 40);
		panel_1.add(btnNewButton);
		
		consumerno = new JTextField();
		consumerno.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		consumerno.setColumns(10);
		consumerno.setBounds(157, 19, 286, 34);
		panel_1.add(consumerno);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("編號");
		lblNewLabel_1_1_1_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 25));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(55, 19, 52, 30);
		panel_1.add(lblNewLabel_1_1_1_1_1_1_1_1);
	}
}
