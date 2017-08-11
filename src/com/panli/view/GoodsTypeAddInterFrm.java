package com.panli.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.panli.dao.GoodsTypeDao;
import com.panli.model.GoodsType;
import com.panli.util.DbUtil;
import com.panli.util.StringUtil;
/**
 * goodsType视图层货物类别添加
 * @author Peter
 *
 */
public class GoodsTypeAddInterFrm extends JInternalFrame {
	private JTextField goodsTypeNameTxt;
	private JTextArea goodsTypeDescTxt;

	
	private DbUtil dbUtil = new DbUtil();
	private GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoodsTypeAddInterFrm frame = new GoodsTypeAddInterFrm();
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
	public GoodsTypeAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u8D27\u7269\u7C7B\u522B\u6DFB\u52A0\u754C\u9762");
		setBounds(100, 100, 528, 392);
		
		JLabel lblNewLabel = new JLabel("\u8D27\u7269\u7C7B\u522B\u540D\u79F0\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(GoodsTypeAddInterFrm.class.getResource("/images/goods.png")));
		
		JLabel label = new JLabel("\u8D27\u7269\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		label.setIcon(new ImageIcon(GoodsTypeAddInterFrm.class.getResource("/images/goods.png")));
		
		goodsTypeNameTxt = new JTextField();
		goodsTypeNameTxt.setColumns(10);
		
		goodsTypeDescTxt = new JTextArea();
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodsTypeAddActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(GoodsTypeAddInterFrm.class.getResource("/images/add.png")));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodsTypeResetValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(GoodsTypeAddInterFrm.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(goodsTypeDescTxt))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(goodsTypeNameTxt, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(144, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(91)
					.addComponent(button)
					.addGap(153)
					.addComponent(button_1)
					.addContainerGap(154, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(goodsTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(goodsTypeDescTxt, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(44))
		);
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * 货物类型添加事件
	 * @param e
	 */
	private void goodsTypeAddActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String goodsTypeName = this.goodsTypeNameTxt.getText();
		String goodsTypeDesc = this.goodsTypeDescTxt.getText();
		if(StringUtil.isEmpty(goodsTypeName)){
			JOptionPane.showMessageDialog(null, "货物类型名称不能为空!");
			return;
		}
		if(StringUtil.isEmpty(goodsTypeDesc)){
			JOptionPane.showMessageDialog(null, "货物类型描述不能为空!");
			return;
		}
		GoodsType goodsType = new GoodsType(goodsTypeName, goodsTypeDesc);
		Connection conn = null;
		try {
			conn = dbUtil.getCon();
			int result = goodsTypeDao.addGoodsType(conn, goodsType);
			if(result==1){
				JOptionPane.showMessageDialog(null, "货物类别添加成功!");
				this.resetValue();//添加成功，重置表单
			}else{
				JOptionPane.showMessageDialog(null, "货物类别添加失败!");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "货物类别添加失败!");
		}finally{
			try {
				dbUtil.close(conn);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}

	/**
	 * 重置事件
	 * @param e
	 */
	private void goodsTypeResetValueActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.resetValue();
	}

	/**
	 * 重置表单
	 */
	private void resetValue(){
		this.goodsTypeNameTxt.setText("");
		this.goodsTypeDescTxt.setText("");
	}
	
	
}
