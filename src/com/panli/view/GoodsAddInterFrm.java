package com.panli.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.panli.dao.GoodsDao;
import com.panli.dao.GoodsTypeDao;
import com.panli.model.Goods;
import com.panli.model.GoodsType;
import com.panli.util.DbUtil;
import com.panli.util.StringUtil;
import javax.swing.ImageIcon;
/**
 * 货物添加视图层
 * @author Peter
 *
 */
public class GoodsAddInterFrm extends JInternalFrame {
	private JTextField goodsNameTxt;
	private JTextField goodsSupplierTxt;
	private JTextField priceTxt;
	private JTextArea goodsDescTxt;
	private JComboBox goodsTypeNameJcb;
	private JRadioButton manJrb;
	private JRadioButton femaleJrb;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	
	private static DbUtil dbUtil = new DbUtil();
	private static GoodsDao goodsDao = new GoodsDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoodsAddInterFrm frame = new GoodsAddInterFrm();
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
	public GoodsAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u8D27\u7269\u6DFB\u52A0\u754C\u9762");
		setBounds(100, 100, 596, 399);
		
		JLabel lblNewLabel = new JLabel("\u8D27\u7269\u540D\u79F0\uFF1A");
		
		goodsNameTxt = new JTextField();
		goodsNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D27\u7269\u4F9B\u8D27\u5546\uFF1A");
		
		goodsSupplierTxt = new JTextField();
		goodsSupplierTxt.setColumns(10);
		
		JLabel label = new JLabel("\u4F9B\u8D27\u5546\u6027\u522B\uFF1A");
		
		manJrb = new JRadioButton("\u7537");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);
		
		femaleJrb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJrb);
		
		JLabel lblNewLabel_2 = new JLabel("\u8D27\u7269\u4EF7\u683C\uFF1A");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8D27\u7269\u7C7B\u522B\uFF1A");
		
		goodsTypeNameJcb = new JComboBox();
		
		JLabel label_2 = new JLabel("\u8D27\u7269\u63CF\u8FF0\uFF1A");
		
		goodsDescTxt = new JTextArea();
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.setIcon(new ImageIcon(GoodsAddInterFrm.class.getResource("/images/add.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addGoodsActionPerformed(arg0);
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.setIcon(new ImageIcon(GoodsAddInterFrm.class.getResource("/images/reset.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addGap(3)
									.addComponent(goodsDescTxt, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(goodsTypeNameJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(goodsNameTxt, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(manJrb)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(femaleJrb)))
									.addGap(65)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(goodsSupplierTxt, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_2)
											.addGap(18)
											.addComponent(priceTxt))))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(149)
							.addComponent(button)
							.addGap(119)
							.addComponent(button_1)))
					.addContainerGap(126, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(goodsNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(goodsSupplierTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(manJrb)
						.addComponent(femaleJrb)
						.addComponent(lblNewLabel_2)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(goodsTypeNameJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(label_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(goodsDescTxt, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addGap(22))
		);
		getContentPane().setLayout(groupLayout);
		
		//填充下拉列表
		this.fillGoodsType();

	}
	
	/**
	 * 货物添加事件
	 * @param arg0
	 */
	private void addGoodsActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String goodsName = this.goodsNameTxt.getText();
		String goodsSupplier = this.goodsSupplierTxt.getText();
		String price = this.priceTxt.getText();
		String goodsDesc = this.goodsDescTxt.getText();
		if(StringUtil.isEmpty(goodsName)){
			JOptionPane.showMessageDialog(null, "货物名称不能为空!");
			return;
		}
		if(StringUtil.isEmpty(goodsSupplier)){
			JOptionPane.showMessageDialog(null, "货物供货商不能为空!");
			return;
		}
		if(StringUtil.isEmpty(goodsDesc)){
			JOptionPane.showMessageDialog(null, "货物描述不能为空!");
			return;
		}
		if(StringUtil.isEmpty(price)){
			JOptionPane.showMessageDialog(null, "货物价格不能为空!");
			return;
		}
		String sex = "";
		if(manJrb.isSelected()){
			sex = "男";
		}else if(femaleJrb.isSelected()){
			sex = "女";
		}
		
		GoodsType goodsTypeName = (GoodsType)this.goodsTypeNameJcb.getSelectedItem();
		int goodsTypeId = goodsTypeName.getId();
		
		Goods goods = new Goods(goodsName, goodsSupplier, sex, Double.parseDouble(price), goodsDesc, goodsTypeId);
		Connection conn = null;
		try {
			conn = DbUtil.getCon();
			int result  = goodsDao.addGoods(conn, goods);
			if(result == 1){
				JOptionPane.showMessageDialog(null, "货物添加成功!");
				this.resetValue();
				
			}else{
				JOptionPane.showMessageDialog(null, "货物添加失败!");
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	/**
	 * 货物表单重置事件
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.resetValue();
	}
	/**
	 * 表单重置事件
	 */
	private void resetValue(){
		this.goodsNameTxt.setText("");
		this.goodsSupplierTxt.setText("");
		this.priceTxt.setText("");
		this.goodsDescTxt.setText("");
		this.manJrb.setSelected(true);
		if(goodsTypeNameJcb.getItemCount()>0){
			goodsTypeNameJcb.setSelectedIndex(0);
		}
		
		
	}

	/**
	 * 填充下拉列表货物类型
	 */
	private void fillGoodsType(){
		Connection conn = null;
		GoodsType goodsType = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getCon();
			rs = GoodsTypeDao.listGoodsType(conn, new GoodsType());
			while(rs.next()){
				goodsType = new GoodsType();
				goodsType.setId(rs.getInt("id"));
				goodsType.setGoodsTypeName(rs.getString("goodsTypeName"));
				this.goodsTypeNameJcb.addItem(goodsType);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DbUtil.close(conn, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
