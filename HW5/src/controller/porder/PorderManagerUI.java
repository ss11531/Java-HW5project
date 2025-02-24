package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.impl.PorderServiceImpl;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PorderManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField water;
	private JTextField dry;
	private JTextField exquisite;
	private JTextField doll;
	private JTextField updateId;
	private JTextField deleteId;
	private JTextField textField;
	private static PorderServiceImpl porderserviceimpl = new PorderServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderManagerUI frame = new PorderManagerUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 private void exportToCSV() {
	        try {
	            // 這裡可以是您的訂單資料，例如從服務中獲得的所有訂單
	            String header = "ID, 水洗服務, 乾洗服務, 精緻清洗, 玩偶清洗, 金額\n";
	            StringBuilder csvContent = new StringBuilder(header);

	            String data = porderserviceimpl.AllPorder();  // 您的 AllPorder 方法需要返回可導出為 CSV 格式的資料
	            csvContent.append(data);

	            // 寫入 CSV 檔案
	            BufferedWriter writer = new BufferedWriter(new FileWriter("orders.csv"));
	            writer.write(csvContent.toString());
	            writer.close();

	            JOptionPane.showMessageDialog(this, "CSV檔案已成功導出！");
	        } catch (IOException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(this, "輸出CSV時發生錯誤！");
	        }
	    }


	/**
	 * Create the frame.
	 */
	public PorderManagerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(248, 160, 196));
		panel.setBounds(10, 28, 399, 324);
		contentPane.add(panel);

		JLabel lblNewLabel_1_1 = new JLabel("水洗服務");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(27, 106, 89, 30);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("乾洗服務");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(25, 152, 128, 30);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_2_1 = new JLabel("管理訂單");
		lblNewLabel_2_1.setForeground(Color.BLUE);
		lblNewLabel_2_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 25));
		lblNewLabel_2_1.setBackground(UIManager.getColor("Button.background"));
		lblNewLabel_2_1.setBounds(126, 10, 109, 31);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_1_3_1 = new JLabel("精緻清洗");
		lblNewLabel_1_3_1.setForeground(Color.BLACK);
		lblNewLabel_1_3_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 18));
		lblNewLabel_1_3_1.setBounds(26, 194, 128, 30);
		panel.add(lblNewLabel_1_3_1);

		water = new JTextField("0");
		water.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		water.setColumns(10);
		water.setBounds(126, 106, 154, 34);
		panel.add(water);

		dry = new JTextField("0");
		dry.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		dry.setColumns(10);
		dry.setBounds(126, 150, 154, 34);
		panel.add(dry);

		exquisite = new JTextField("0");
		exquisite.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		exquisite.setColumns(10);
		exquisite.setBounds(127, 193, 154, 34);
		panel.add(exquisite);

		doll = new JTextField("0");
		doll.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		doll.setColumns(10);
		doll.setBounds(126, 235, 154, 34);
		panel.add(doll);

		JLabel lblNewLabel_1_3 = new JLabel("玩偶清洗");
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("微软雅黑 Light", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(25, 236, 128, 30);
		panel.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_1_1 = new JLabel("ID");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(27, 62, 89, 30);
		panel.add(lblNewLabel_1_1_1);

		updateId = new JTextField();
		updateId.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		updateId.setColumns(10);
		updateId.setBounds(126, 62, 154, 34);
		panel.add(updateId);

		JButton btnNewButton_1_1 = new JButton("修改");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Id = Integer.parseInt(updateId.getText());
				int Water = Integer.parseInt(water.getText());
				int Dry = Integer.parseInt(dry.getText());
				int Exquisite = Integer.parseInt(exquisite.getText());
				int Doll = Integer.parseInt(doll.getText());
				porderserviceimpl.updatePorder(Water, Dry, Exquisite, Doll, Id);

			}
		});
		btnNewButton_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(136, 279, 109, 40);
		panel.add(btnNewButton_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("NT 300");
		lblNewLabel_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 18));
		lblNewLabel_1_1_2.setBounds(290, 106, 89, 30);
		panel.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_2_2 = new JLabel("NT 400");
		lblNewLabel_1_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_1_2_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 18));
		lblNewLabel_1_1_2_2.setBounds(290, 152, 89, 30);
		panel.add(lblNewLabel_1_1_2_2);

		JLabel lblNewLabel_1_1_2_2_1 = new JLabel("NT 600");
		lblNewLabel_1_1_2_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_2_2_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 18));
		lblNewLabel_1_1_2_2_1.setBounds(291, 194, 89, 30);
		panel.add(lblNewLabel_1_1_2_2_1);

		JLabel lblNewLabel_1_1_2_2_1_1 = new JLabel("NT 500");
		lblNewLabel_1_1_2_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_2_2_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 18));
		lblNewLabel_1_1_2_2_1_1.setBounds(290, 235, 89, 30);
		panel.add(lblNewLabel_1_1_2_2_1_1);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(248, 160, 196));
		panel_1.setBounds(419, 28, 579, 324);
		contentPane.add(panel_1);

		JTextArea outputArea = new JTextArea();
		outputArea.setFont(new Font("微软雅黑 Light", Font.PLAIN, 10));
		outputArea.setEditable(false); // 設定為不可編輯
		JScrollPane output = new JScrollPane(outputArea);
		output.setBounds(10, 27, 559, 235);
		panel_1.add(output);

		JButton btnNewButton_1 = new JButton("查詢");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				outputArea.setText(porderserviceimpl.AllPorder()); // 修改這行
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		btnNewButton_1.setBounds(119, 272, 109, 40);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_1_2 = new JButton("列印");
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					outputArea.print();
				} catch (PrinterException e1) {
					e1.printStackTrace();

				}
			}
		});
		btnNewButton_1_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		btnNewButton_1_2.setBounds(304, 272, 128, 44);
		panel_1.add(btnNewButton_1_2);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(248, 160, 196));
		panel_2.setBounds(10, 360, 399, 110);
		contentPane.add(panel_2);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("ID");
		lblNewLabel_1_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_2_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 18));
		lblNewLabel_1_1_2_1.setBounds(35, 6, 52, 30);
		panel_2.add(lblNewLabel_1_1_2_1);

		deleteId = new JTextField();
		deleteId.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		deleteId.setColumns(10);
		deleteId.setBounds(128, 6, 154, 34);
		panel_2.add(deleteId);

		JButton btnNewButton_1_1_1 = new JButton("刪除");
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Id = Integer.parseInt(deleteId.getText());
				porderserviceimpl.deletePorderById(Id);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		btnNewButton_1_1_1.setBounds(138, 50, 109, 40);
		panel_2.add(btnNewButton_1_1_1);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(248, 160, 196));
		panel_1_1.setBounds(419, 360, 579, 186);
		contentPane.add(panel_1_1);

		JTextArea output_1 = new JTextArea();
		output_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		output_1.setBounds(21, 77, 531, 89);
		panel_1_1.add(output_1);

		JLabel lblNewLabel_3 = new JLabel("付款金額");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("微软雅黑 Light", Font.BOLD, 25));
		lblNewLabel_3.setBounds(21, 33, 127, 34);
		panel_1_1.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setFont(new Font("微软雅黑 Light", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(137, 32, 110, 35);
		panel_1_1.add(textField);

		JButton btnNewButton_2_2 = new JButton("找零");
		btnNewButton_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					// 取得產品數量
					int Water = Integer.parseInt(water.getText());
					int Dry = Integer.parseInt(dry.getText());
					int Exquisite = Integer.parseInt(exquisite.getText());
					int Doll = Integer.parseInt(doll.getText());

					int priceWater = 300;
					int priceDry = 400;
					int priceExquisite = 600;
					int priceDoll = 500;

					// 計算總金額
					int totalAmount = (Water * priceWater) + (Dry * priceDry) + (Exquisite * priceExquisite)
							+ (Doll * priceDoll);

					// 取得付款金額
					int paidAmount = Integer.parseInt(textField.getText());

					// 計算找零
					int change = paidAmount - totalAmount;

					// 顯示結果
					if (change < 0) {
						output_1.setText("付款金額不足，請再確認！");
					} else {
						output_1.setText("應付款金額：" + totalAmount + " 元\n" + "實收金額：" + paidAmount + " 元\n" + "找零金額："
								+ change + " 元");
					}
				} catch (NumberFormatException ex) {
					output_1.setText("請輸入有效的數字！");
				}
			}
		});
		btnNewButton_2_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		btnNewButton_2_2.setBounds(275, 23, 128, 44);
		panel_1_1.add(btnNewButton_2_2);
        
		
		JButton btnNewButton_2_2_1 = new JButton("輸出CSV");
		btnNewButton_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 exportToCSV();  // 按下時導出CSV

			}
		});

		btnNewButton_2_2_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		btnNewButton_2_2_1.setBounds(428, 25, 128, 44);
		panel_1_1.add(btnNewButton_2_2_1);

		JButton btnNewButton_2 = new JButton("離開");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		btnNewButton_2.setBounds(281, 502, 128, 44);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_1_1_1_1 = new JButton("回訂單主頁");
		btnNewButton_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PorderMainUI frame = new PorderMainUI();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
		btnNewButton_1_1_1_1.setBounds(10, 504, 209, 40);
		contentPane.add(btnNewButton_1_1_1_1);
	}

}
