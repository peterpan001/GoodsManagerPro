package com.panli.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 主页面视图层
 * @author Peter
 *
 */
public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("\u4ED3\u5E93\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u9875\u9762");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrm.class.getResource("/images/goods_logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 348);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u4ED3\u5E93\u7BA1\u7406\u7CFB\u7EDF");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/manager.png")));
		menuBar.add(menu);
		
		JMenu menu_2 = new JMenu("\u8D27\u7269\u7C7B\u578B\u7BA1\u7406");
		menu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/goodmanager.png")));
		menu.add(menu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("\u8D27\u7269\u7C7B\u578B\u6DFB\u52A0");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoodsTypeAddInterFrm goodsTypeAddInterFrm = new GoodsTypeAddInterFrm();
				goodsTypeAddInterFrm.setVisible(true);
				table.add(goodsTypeAddInterFrm);
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menu_2.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u8D27\u7269\u7C7B\u578B\u4FEE\u6539");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoodsTypeManagerInterFrm goodsTypeManagerInterFrm = new GoodsTypeManagerInterFrm();
				goodsTypeManagerInterFrm.setVisible(true);
				table.add(goodsTypeManagerInterFrm);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/modify.png")));
		menu_2.add(menuItem_3);
		
		JMenu menu_3 = new JMenu("\u8D27\u7269\u7269\u54C1\u7BA1\u7406");
		menu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/goods.png")));
		menu.add(menu_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u8D27\u7269\u7269\u54C1\u6DFB\u52A0");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GoodsAddInterFrm goodsAddInterFrm = new GoodsAddInterFrm();
				goodsAddInterFrm.setVisible(true);
				table.add(goodsAddInterFrm);
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menu_3.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u8D27\u7269\u7269\u54C1\u4FEE\u6539");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GoodsManagerInterFrm goodsManagerInterFrm = new GoodsManagerInterFrm();
				goodsManagerInterFrm.setVisible(true);
				table.add(goodsManagerInterFrm);
			}
		});
		menuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/modify.png")));
		menu_3.add(menuItem_5);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitSystemActionPerformed(e);
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u8054\u7CFB\u6211\u4EEC");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/contact.png")));
		menuBar.add(menu_1);
		
		JMenuItem menuItem = new JMenuItem("\u8054\u7CFB\u65B9\u5F0F");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MyContactInterFrm myContactInterFrm = new MyContactInterFrm();
				myContactInterFrm.setVisible(true);
				table.add(myContactInterFrm);
				
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/phnoe.png")));
		menu_1.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		contentPane.add(table, BorderLayout.CENTER);
		
		//最大化处理
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/**
	 * 安全退出系统
	 * @param e
	 */
	private void exitSystemActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int n =  JOptionPane.showConfirmDialog(null, "你确定要离开系统么");
		if(n == 0){
			dispose();
			return;
		}
	}
}
