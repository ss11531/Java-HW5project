package controller.consumer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.member.LoginEmUI;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddCoSuccessUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCoSuccessUI frame = new AddCoSuccessUI();
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
	public AddCoSuccessUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("註冊成功");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 25));
		lblNewLabel_1.setBounds(71, 46, 120, 30);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("重新登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginCoUI login=new LoginCoUI();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		btnNewButton.setBounds(61, 103, 142, 40);
		contentPane.add(btnNewButton);
	}

}
