package controller.consumer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.member.AddEmUI;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddCoErrorUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCoErrorUI frame = new AddCoErrorUI();
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
	public AddCoErrorUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 312, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("重新註冊");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddCoUI addmember=new AddCoUI();
				addmember.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		btnNewButton.setBounds(74, 104, 142, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("帳號有重疊");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 25));
		lblNewLabel_1.setBounds(74, 38, 131, 34);
		contentPane.add(lblNewLabel_1);
	}

}
