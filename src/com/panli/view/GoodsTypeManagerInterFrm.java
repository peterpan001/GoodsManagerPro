package com.panli.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.panli.dao.GoodsTypeDao;
import com.panli.model.GoodsType;
import com.panli.util.DbUtil;
import com.panli.util.StringUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * 货物类别管理视图层
 * @author Peter
 *
 */
public class GoodsTypeManagerInterFrm extends JInternalFrame {
	private JTable goodsTypeTable;
	private JTextField s_goodsTypeNameTxt;
	private JTextField goodsTypeIdTxt;
	private JTextField goodsTypeNameTxt;
	private JTextArea goodsTypeDescTxt;
	
	private static DbUtil dbUtil = new DbUtil();
	private static GoodsTypeDao goodsTypeDao = new GoodsTypeDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoodsTypeManagerInterFrm frame = new GoodsTypeManagerInterFrm();
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
	public GoodsTypeManagerInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u8D27\u7269\u7C7B\u578B\u7EF4\u62A4\u9875\u9762");
		setBounds(100, 100, 548, 475);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u8D27\u7269\u7C7B\u578B\u540D\u79F0\uFF1A");
		
		s_goodsTypeNameTxt = new JTextField();
		s_goodsTypeNameTxt.setColumns(10);
		
		JButton button = new JButton("\u641C\u7D22");
		button.setIcon(new ImageIcon(GoodsTypeManagerInterFrm.class.getResource("/images/Search.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchbookTypeActionPerformed(e);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_goodsTypeNameTxt, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(button))
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_goodsTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel label_1 = new JLabel("\u8D27\u7269\u7C7B\u522B\u7F16\u53F7\uFF1A");
		
		goodsTypeIdTxt = new JTextField();
		goodsTypeIdTxt.setEditable(false);
		goodsTypeIdTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8D27\u7269\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		goodsTypeNameTxt = new JTextField();
		goodsTypeNameTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u8D27\u7269\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		
		goodsTypeDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateGoodsTypeActionPerformed(arg0);
			}
		});
		btnNewButton.setIcon(new ImageIcon(GoodsTypeManagerInterFrm.class.getResource("/images/modify.png")));
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteGoodsTypeActionPerformed(arg0);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(GoodsTypeManagerInterFrm.class.getResource("/images/delete.png")));
		
		JButton btnNewButton_2 = new JButton("\u91CD\u7F6E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodsTypeResetActionPerformed(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(GoodsTypeManagerInterFrm.class.getResource("/images/reset.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(goodsTypeDescTxt))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(goodsTypeIdTxt, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(goodsTypeNameTxt, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(34, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(46)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(29)
					.addComponent(btnNewButton_2)
					.addGap(54))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(goodsTypeIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(goodsTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3)
						.addComponent(goodsTypeDescTxt, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1)))
		);
		panel.setLayout(gl_panel);
		
		goodsTypeTable = new JTable();
		goodsTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				clickMouseGoodsTypeTable(arg0);
			}
		});
		goodsTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8D27\u7269\u7C7B\u578B\u7F16\u53F7", "\u8D27\u7269\u7C7B\u578B\u540D\u79F0", "\u8D27\u7269\u7C7B\u578B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		goodsTypeTable.getColumnModel().getColumn(0).setPreferredWidth(96);
		goodsTypeTable.getColumnModel().getColumn(1).setPreferredWidth(124);
		scrollPane.setViewportView(goodsTypeTable);
		getContentPane().setLayout(groupLayout);
		//填充表单
		this.fillGoodsTypeTable(new GoodsType());

	}
	/**
	 * 货物类别删除事件
	 * @param arg0
	 */
	private void deleteGoodsTypeActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String goodsTypeId = goodsTypeIdTxt.getText();
		if(StringUtil.isEmpty(goodsTypeId)){
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除此货物类别记录么?");
		if(n==0){
			Connection conn = null;
			try {
				conn = dbUtil.getCon();
				if(!goodsTypeDao.exitGoodsByGoodTypeId(conn, goodsTypeId)){

					GoodsType goodsType = new GoodsType(Integer.parseInt(goodsTypeId));
					int result = goodsTypeDao.deleteGoodsType(conn, goodsType);
					if(result==1){
						JOptionPane.showMessageDialog(null, "货物类别记录删除成功!");
						this.fillGoodsTypeTable(new GoodsType());
						this.resetValue();
					}else{
						JOptionPane.showMessageDialog(null, "货物类别记录删除失败!");
					}
				}else{
					JOptionPane.showMessageDialog(null, "货物目录下面有货物不能删除!");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "货物类别记录删除失败!");
			}finally{
				try {
					dbUtil.close(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

	/**
	 * 货物类别更新事件
	 * @param arg0
	 */
	private void updateGoodsTypeActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String goodsTypeId = goodsTypeIdTxt.getText();
		String goodsTypeName = goodsTypeNameTxt.getText();
		String goodsTypeDesc = goodsTypeDescTxt.getText();
		if(StringUtil.isEmpty(goodsTypeId)){
			JOptionPane.showMessageDialog(null, "请选择要修改的记录!");
			return;
		}
		if(StringUtil.isEmpty(goodsTypeName)){
			JOptionPane.showMessageDialog(null, "货物类别名称不能为空!");
			return;
		}
		if(StringUtil.isEmpty(goodsTypeDesc)){
			JOptionPane.showMessageDialog(null, "货物描述不能为空!");
			return;
		}
		GoodsType goodsType = new GoodsType(Integer.parseInt(goodsTypeId), goodsTypeName, goodsTypeDesc);
		Connection conn = null;
		try {
			conn = dbUtil.getCon();
			int result = goodsTypeDao.updateGoodsType(conn, goodsType);
			if(result==1){
				JOptionPane.showMessageDialog(null, "货物类别修改成功!");
				this.fillGoodsTypeTable(new GoodsType());
			}else{
				JOptionPane.showMessageDialog(null, "货物类别修改失败!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "货物类别修改失败!");
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
	 * 查询表单
	 * @param e
	 */
	private void searchbookTypeActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String goodsTypeName = s_goodsTypeNameTxt.getText();
		GoodsType goodsType = new GoodsType(goodsTypeName);
		this.fillGoodsTypeTable(goodsType);
	}

	/**
	 * 货物类型重置事件
	 * @param e
	 */
	private void goodsTypeResetActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.resetValue();
	}

	/**
	 * 重置表单
	 */
	private void resetValue(){
		this.goodsTypeIdTxt.setText("");
		this.goodsTypeNameTxt.setText("");
		this.goodsTypeDescTxt.setText("");
	}
	//鼠标点击事件
	private void clickMouseGoodsTypeTable(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row = goodsTypeTable.getSelectedRow();
		goodsTypeIdTxt.setText((String)goodsTypeTable.getValueAt(row, 0));
		goodsTypeNameTxt.setText((String)goodsTypeTable.getValueAt(row, 1));
		goodsTypeDescTxt.setText((String)goodsTypeTable.getValueAt(row, 2));
		
	}

	/**
	 * 填充表单事件
	 * @param goodsType
	 */
	private void fillGoodsTypeTable(GoodsType goodsType){
		DefaultTableModel dtm = (DefaultTableModel)goodsTypeTable.getModel();
		dtm.setRowCount(0);
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getCon();
			rs = goodsTypeDao.listGoodsType(conn, goodsType);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("goodsTypeName"));
				v.add(rs.getString("goodsTypeDesc"));
				dtm.addRow(v);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dbUtil.close(conn, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
