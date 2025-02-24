package controller.product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import service.ProductService;
import service.impl.ProductServiceImpl;
import model.Product;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProductUI extends JFrame {
    private ProductService productService = new ProductServiceImpl();
    private JTextField txtProductNo, txtProductName, txtPrice;
    private JTable productTable;
    private DefaultTableModel tableModel;

    public ProductUI() {
        setTitle("產品管理");
        setSize(809, 604);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        // 上方輸入區域
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS)); // 使用 Y 軸排列
        inputPanel.add(new JLabel("服務編號:"));
        txtProductNo = new JTextField();
        inputPanel.add(txtProductNo);

        inputPanel.add(new JLabel("服務名稱:"));
        txtProductName = new JTextField();
        inputPanel.add(txtProductName);

        inputPanel.add(new JLabel("價格:"));
        txtPrice = new JTextField();
        inputPanel.add(txtPrice);

        // 按鈕區域
        JPanel buttonPanel = new JPanel();
        JButton btnAdd = new JButton("新增");
        JButton btnUpdate = new JButton("修改");
        JButton btnDelete = new JButton("刪除");
        JButton btnExit = new JButton("離開"); // 新增離開按鈕

        // 設置按鈕外觀和大小
        btnExit.setFont(new Font("微软雅黑", Font.BOLD, 12));
        btnExit.setBounds(600, 10, 150, 40); // 設定按鈕位置和大小

        // 將按鈕加入按鈕區域
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnExit); // 新增離開按鈕

        inputPanel.add(buttonPanel); // 將按鈕區域加入

        getContentPane().add(inputPanel, BorderLayout.NORTH);

        // 表格區域
        tableModel = new DefaultTableModel(new String[]{"ID", "服務編號", "服務名稱", "價格"}, 0);
        productTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(productTable);
        getContentPane().add(scrollPane, BorderLayout.CENTER); // 表格區域使用 JScrollPane

        // 設定表格區域的最大高度
        scrollPane.setPreferredSize(new Dimension(800, 300));  // 限制表格區域高度

        // 設定按鈕事件
        btnAdd.addActionListener(e -> addProduct());
        btnUpdate.addActionListener(e -> updateProduct());
        btnDelete.addActionListener(e -> deleteProduct());
        btnExit.addActionListener(e -> exitApplication()); // 設定離開按鈕的事件

        loadProducts();  // 讀取產品資料
        setVisible(true);
    }

    private void addProduct() {
        String productNo = txtProductNo.getText();
        String productName = txtProductName.getText();
        double price = Double.parseDouble(txtPrice.getText());

        Product product = new Product(0, productNo, productName, price);
        if (productService.addProduct(product)) {
            JOptionPane.showMessageDialog(this, "產品新增成功");
            loadProducts();
        } else {
            JOptionPane.showMessageDialog(this, "新增失敗");
        }
    }

    private void updateProduct() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "請選擇要修改的產品");
            return;
        }
        int id = (int) tableModel.getValueAt(selectedRow, 0);
        String productNo = txtProductNo.getText();
        String productName = txtProductName.getText();
        double price = Double.parseDouble(txtPrice.getText());

        Product product = new Product(id, productNo, productName, price);
        if (productService.updateProduct(product)) {
            JOptionPane.showMessageDialog(this, "產品修改成功");
            loadProducts();
        } else {
            JOptionPane.showMessageDialog(this, "修改失敗");
        }
    }

    private void deleteProduct() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "請選擇要刪除的產品");
            return;
        }
        int id = (int) tableModel.getValueAt(selectedRow, 0);
        if (productService.deleteProduct(id)) {
            JOptionPane.showMessageDialog(this, "產品刪除成功");
            loadProducts();
        } else {
            JOptionPane.showMessageDialog(this, "刪除失敗");
        }
    }

    private void loadProducts() {
        tableModel.setRowCount(0);
        List<Product> products = productService.getAllProducts();
        for (Product product : products) {
            tableModel.addRow(new Object[]{product.getId(), product.getProductno(), product.getProductname(), product.getPrice()});
        }
    }

    // 新增離開應用程式的處理方法
    private void exitApplication() {
        int option = JOptionPane.showConfirmDialog(this, "確定要離開嗎?", "離開", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            System.exit(0);  // 關閉應用程式
        }
    }

    public static void main(String[] args) {
        new ProductUI();
    }
}
