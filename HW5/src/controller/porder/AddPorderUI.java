package controller.porder;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Porder;
import service.impl.PorderServiceImpl;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class AddPorderUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField water;
    private JTextField dry;
    private JTextField exquisite;
    private JTextField doll;
    private static PorderServiceImpl porderServiceImpl = new PorderServiceImpl(); // 修正變數名稱

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddPorderUI frame = new AddPorderUI();
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
    public AddPorderUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 510);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("新增訂單");
        lblNewLabel.setForeground(new Color(0, 128, 64));
        lblNewLabel.setFont(new Font("微软雅黑 Light", Font.BOLD, 30));
        lblNewLabel.setBounds(143, 10, 135, 65);
        contentPane.add(lblNewLabel);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(192, 192, 192));
        panel.setBounds(42, 85, 353, 357);
        contentPane.add(panel);
        
        JLabel lblNewLabel_1_1 = new JLabel("水洗服務");
        lblNewLabel_1_1.setForeground(Color.BLACK);
        lblNewLabel_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 25));
        lblNewLabel_1_1.setBounds(48, 24, 104, 30);
        panel.add(lblNewLabel_1_1);
        
        water = new JTextField();
        water.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
        water.setColumns(10);
        water.setBounds(175, 24, 130, 34);
        panel.add(water);
        
        dry = new JTextField();
        dry.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
        dry.setColumns(10);
        dry.setBounds(175, 80, 130, 34);
        panel.add(dry);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("乾洗服務");
        lblNewLabel_1_1_1.setForeground(Color.BLACK);
        lblNewLabel_1_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 25));
        lblNewLabel_1_1_1.setBounds(48, 80, 104, 30);
        panel.add(lblNewLabel_1_1_1);
        
        exquisite = new JTextField();
        exquisite.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
        exquisite.setColumns(10);
        exquisite.setBounds(175, 137, 130, 34);
        panel.add(exquisite);
        
        JLabel lblNewLabel_1_1_2 = new JLabel("精緻清洗");
        lblNewLabel_1_1_2.setForeground(Color.BLACK);
        lblNewLabel_1_1_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 25));
        lblNewLabel_1_1_2.setBounds(48, 137, 104, 30);
        panel.add(lblNewLabel_1_1_2);
        
        doll = new JTextField();
        doll.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
        doll.setColumns(10);
        doll.setBounds(175, 197, 130, 34);
        panel.add(doll);
        
        JLabel lblNewLabel_1_1_3 = new JLabel("玩偶清洗");
        lblNewLabel_1_1_3.setForeground(Color.BLACK);
        lblNewLabel_1_1_3.setFont(new Font("微软雅黑 Light", Font.BOLD, 25));
        lblNewLabel_1_1_3.setBounds(48, 197, 104, 30);
        panel.add(lblNewLabel_1_1_3);
        
        JButton btnNewButton_1_1_1_1_1 = new JButton("確定");
        btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 錯誤處理
                try {
                    String Name = JOptionPane.showInputDialog("請輸入訂單名稱："); // 讓用戶輸入訂單名稱
                    int Water = Integer.parseInt(water.getText());
                    int Dry = Integer.parseInt(dry.getText());
                    int Exquisite = Integer.parseInt(exquisite.getText());
                    int Doll = Integer.parseInt(doll.getText());
                    
                    Porder m = new Porder(Name, Water, Dry, Exquisite, Doll);
                    porderServiceImpl.addPorder(m);  // 確保這個方法實現正確
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "請輸入有效的數字！");
                }
            }
        });
        btnNewButton_1_1_1_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
        btnNewButton_1_1_1_1_1.setBounds(100, 257, 157, 35);
        panel.add(btnNewButton_1_1_1_1_1);
        
        JButton btnNewButton_1_1_1_1_1_1 = new JButton("離開");
        btnNewButton_1_1_1_1_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
        btnNewButton_1_1_1_1_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
        btnNewButton_1_1_1_1_1_1.setBounds(10, 312, 157, 35);
        panel.add(btnNewButton_1_1_1_1_1_1);
        
        JButton btnNewButton_1_1_1_1 = new JButton("回主頁");
        btnNewButton_1_1_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	PorderMainUI frame = new PorderMainUI();
                frame.setVisible(true);
                dispose();
            }
        });
        btnNewButton_1_1_1_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 20));
        btnNewButton_1_1_1_1.setBounds(186, 312, 157, 35);
        panel.add(btnNewButton_1_1_1_1);
    }
    
    // 前往主頁UI的方法
    private void gotoPorderMainUI() {
        // 在這裡實現返回主頁的邏輯
    }
}
