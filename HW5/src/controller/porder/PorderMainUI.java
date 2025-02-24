package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PorderMainUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderMainUI frame = new PorderMainUI();
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
	public PorderMainUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("管理選項");
		lblNewLabel.setForeground(new Color(0, 128, 64));
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.BOLD, 30));
		lblNewLabel.setBounds(101, 10, 135, 65);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(26, 85, 290, 163);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("新增訂單");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPorderUI addporder = new AddPorderUI();
				addporder.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		btnNewButton.setBounds(67, 24, 143, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("管理訂單");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PorderManagerUI pordermanager = new PorderManagerUI();
				pordermanager.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		btnNewButton_1.setBounds(67, 91, 143, 40);
		panel.add(btnNewButton_1);
	}

}
