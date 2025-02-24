package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.consumer.LoginCoUI;
import model.Member;
import service.impl.MemberServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginEmUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private JLabel label_1;// 用來顯示時間

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginEmUI frame = new LoginEmUI();
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
	public LoginEmUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("巨匠洗衣會館");
		lblNewLabel.setBounds(167, 34, 186, 41);
		lblNewLabel.setForeground(new Color(0, 128, 64));
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號：");
		lblNewLabel_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		lblNewLabel_1.setBounds(71, 86, 62, 46);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setFont(new Font("微软雅黑", Font.BOLD, 20));
		username.setColumns(10);
		username.setBackground(Color.WHITE);
		username.setBounds(157, 87, 233, 46);
		contentPane.add(username);
		
		JLabel lblNewLabel_2 = new JLabel("密碼：");
		lblNewLabel_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		lblNewLabel_2.setBounds(77, 143, 62, 46);
		contentPane.add(lblNewLabel_2);
		
		password = new JTextField();
		password.setFont(new Font("微软雅黑", Font.BOLD, 20));
		password.setColumns(10);
		password.setBackground(Color.WHITE);
		password.setBounds(159, 144, 233, 46);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username = username.getText();
				String Password = password.getText();
				// 帳號與密碼格式正確後，執行登入驗證
				Member member = new MemberServiceImpl().Login(Username, Password);
				if (member != null) {
				    Tool.save(member, "employeer.txt");
				    LoginEmSuccessUI loginsuccess = new LoginEmSuccessUI();
				    loginsuccess.setVisible(true);
				    dispose();
				} else {
				    LoginEmErrorUI loginerror = new LoginEmErrorUI();
				    loginerror.setVisible(true);
				    dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
		btnNewButton.setBounds(20, 244, 132, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("註冊");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddEmUI addmember = new AddEmUI();
				addmember.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 20));
		btnNewButton_1.setBounds(176, 244, 132, 52);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("離開");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.BOLD, 20));
		btnNewButton_2.setBounds(471, 244, 90, 52);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("客人登入");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginCoUI loginCoUI = new LoginCoUI();
                loginCoUI.setVisible(true);
                dispose();
			}
		});
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setFont(new Font("微软雅黑", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(329, 244, 132, 52);
		contentPane.add(btnNewButton_1_1);
		
		label_1 = new JLabel("");
		label_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 15));
		label_1.setBounds(20, 10, 308, 46);
		contentPane.add(label_1);
		// 啟動時間更新執行緒
				Thread clockThread = new Thread(new ClockRunnable());
				clockThread.start();

			}

			// 格式化數字（補零）
			private static String format(int number) {
				return number < 10 ? "0" + number : "" + number;
			}

			// 獲取當前時間
			private static String getTime() {
				Calendar cal = new GregorianCalendar();
				int Year = cal.get(Calendar.YEAR);
				int Month = cal.get(Calendar.MONTH) + 1; // 修正月份
				int Day = cal.get(Calendar.DAY_OF_MONTH);

				int Hour = cal.get(Calendar.HOUR_OF_DAY);
				int Minute = cal.get(Calendar.MINUTE);
				int Second = cal.get(Calendar.SECOND);
				return format(Year) + "-" + format(Month) + "-" + format(Day) + " " + format(Hour) + ":" + format(Minute) + ":"
						+ format(Second);
			}

			// 定時更新時間的執行緒
			private class ClockRunnable implements Runnable {
				@Override
				public void run() {
					while (true) {
						label_1.setText(getTime());
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
