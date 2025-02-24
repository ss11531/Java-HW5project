package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.product.ProductUI;
import model.Member;
import util.Tool;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginEmSuccessUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Member member=(Member)Tool.read("employeer.txt");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginEmSuccessUI frame = new LoginEmSuccessUI();
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
	public LoginEmSuccessUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("登入成功");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 25));
		lblNewLabel_1.setBounds(141, 49, 120, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel showMember = new JLabel("");
		showMember.setForeground(Color.BLACK);
		showMember.setFont(new Font("微软雅黑 Light", Font.BOLD, 25));
		showMember.setBounds(55, 113, 291, 30);
		contentPane.add(showMember);
		showMember.setText(member.getName()+"  歡迎光臨");
		
		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProductUI pordermain=new ProductUI();
				pordermain.setVisible(true);
				dispose();
			}
		});
		btnOk.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		btnOk.setBounds(137, 178, 147, 40);
		contentPane.add(btnOk);
	}

}
