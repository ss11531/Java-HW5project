package controller.consumer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.porder.PorderMainUI;
import controller.porder.PorderManagerUI;
import controller.product.ProductUI;
import model.Consumer;
import util.Tool;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginCoSuccessUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Consumer consumer=(Consumer)Tool.read("consumer.txt");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCoSuccessUI frame = new LoginCoSuccessUI();
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
	public LoginCoSuccessUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("登入成功");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 25));
		lblNewLabel_1.setBounds(152, 41, 120, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel showMember = new JLabel("");
		showMember.setForeground(Color.BLACK);
		showMember.setFont(new Font("微软雅黑 Light", Font.BOLD, 25));
		showMember.setBounds(66, 105, 291, 30);
		contentPane.add(showMember);
		showMember.setText(consumer.getName()+"  歡迎光臨");
		
		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PorderMainUI pordermain=new PorderMainUI();
				pordermain.setVisible(true);
				dispose();
			}
		});
		btnOk.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		btnOk.setBounds(148, 170, 147, 40);
		contentPane.add(btnOk);
	}
}
