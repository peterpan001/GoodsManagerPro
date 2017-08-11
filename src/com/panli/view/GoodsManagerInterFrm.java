package com.panli.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.panli.dao.GoodsDao;
import com.panli.dao.GoodsTypeDao;
import com.panli.model.Goods;
import com.panli.model.GoodsType;
import com.panli.util.DbUtil;
import com.panli.util.StringUtil;
/**
 * 货物管理视图层
 * @author Peter
 *
 */
public class GoodsManagerInterFrm extends JInternalFrame {
	private JTable goodsTable;
	private JTextField s_goodsNameTxt;
	private JTextField s_goodsSupplierTxt;
	private JTextField goodsIdTxt;
	private JTextField goodsNameTxt;
	private JTextField priceTxt;
	private JTextField goodsSupplierTxt;
	private JTextArea goodsDescTxt;
	private JComboBox goodsTypeNameJcb;
	private JRadioButton manJrb;
	private JRadioButton femaleJrb;
	private JComboBox s_goodsTypeNameJcbTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private static DbUtil dbUtil = new DbUtil();
	private static GoodsDao goodsDao = new GoodsDao();
	private static GoodsTypeDao goodsTypeDao = new GoodsTypeDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoodsManagerInterFrm frame = new GoodsManagerInterFrm();
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
	public GoodsManagerInterFrm() {
		setTitle("\u8D27\u7269\u7EF4\u62A4\u754C\u9762");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 732, 532);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)))
					.addGap(40))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("\u8D27\u7269\u7F16\u53F7\uFF1A");
		
		goodsIdTxt = new JTextField();
		goodsIdTxt.setEnabled(false);
		goodsIdTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u8D27\u7269\u540D\u79F0\uFF1A");
		
		goodsNameTxt = new JTextField();
		goodsNameTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u4F9B\u8D27\u5546\u6027\u522B\uFF1A");
		
		manJrb = new JRadioButton("\u7537");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);
		
		femaleJrb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJrb);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D27\u7269\u4EF7\u683C\uFF1A");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel label_5 = new JLabel("\u4F9B\u8D27\u5546\uFF1A");
		
		goodsSupplierTxt = new JTextField();
		goodsSupplierTxt.setColumns(10);
		
		JLabel label_6 = new JLabel("\u8D27\u7269\u7C7B\u522B\uFF1A");
		
		goodsTypeNameJcb = new JComboBox();
		
		JLabel label_7 = new JLabel("\u8D27\u7269\u63CF\u8FF0\uFF1A");
		
		goodsDescTxt = new JTextArea();
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modifyGoodsActionPerformed(arg0);
			}
		});
		button_1.setIcon(new ImageIcon(GoodsManagerInterFrm.class.getResource("/images/modify.png")));
		
		JButton button_2 = new JButton("\u91CD\u7F6E");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetValueActionPerformed(arg0);
			}
		});
		button_2.setIcon(new ImageIcon(GoodsManagerInterFrm.class.getResource("/images/reset.png")));
		
		JButton button_3 = new JButton("\u5220\u9664");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteGoodsActionPerformed(arg0);
			}
		});
		button_3.setIcon(new ImageIcon(GoodsManagerInterFrm.class.getResource("/images/delete.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(goodsIdTxt, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(goodsNameTxt, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(label_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(goodsSupplierTxt, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
							.addGap(50)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(manJrb)
									.addGap(18)
									.addComponent(femaleJrb))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_6)
									.addGap(18)
									.addComponent(goodsTypeNameJcb, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))))
						.addComponent(label_7)
						.addComponent(goodsDescTxt, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 518, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(30, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(93)
					.addComponent(button_1)
					.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
					.addComponent(button_2)
					.addGap(112)
					.addComponent(button_3)
					.addGap(69))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(goodsIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(goodsNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(femaleJrb)
						.addComponent(manJrb)
						.addComponent(label_4))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(goodsSupplierTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6)
						.addComponent(goodsTypeNameJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label_7)
						.addComponent(goodsDescTxt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_3)
						.addComponent(button_2))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		goodsTable = new JTable();
		goodsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				MouseClickGoodsTableActionPerformed(arg0);
			}
		});
		goodsTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8D27\u7269\u7F16\u53F7", "\u8D27\u7269\u540D\u79F0", "\u4F9B\u8D27\u5546", "\u6027\u522B", "\u8D27\u7269\u4EF7\u683C", "\u8D27\u7269\u63CF\u8FF0", "\u8D27\u7269\u7C7B\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(goodsTable);
		
		JLabel label = new JLabel("\u8D27\u7269\u540D\u79F0\uFF1A");
		
		s_goodsNameTxt = new JTextField();
		s_goodsNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4F9B\u8D27\u5546\uFF1A");
		
		s_goodsSupplierTxt = new JTextField();
		s_goodsSupplierTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8D27\u7269\u7C7B\u522B\uFF1A");
		
		s_goodsTypeNameJcbTxt = new JComboBox();
		
		JButton button = new JButton("\u641C\u7D22");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchGoodsActionPerformed(arg0);
			}
		});
		button.setIcon(new ImageIcon(GoodsManagerInterFrm.class.getResource("/images/Search.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_goodsNameTxt, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_goodsSupplierTxt, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_goodsTypeNameJcbTxt, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addComponent(button)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_goodsNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(s_goodsSupplierTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(s_goodsTypeNameJcbTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		//填充表单
		this.fillGoodsTable(new Goods());
		this.fillGoodsTypeNameItem("search");
		this.fillGoodsTypeNameItem("modify");
	}
	/**
	 * 货物删除事件
	 * @param arg0
	 */
	private void deleteGoodsActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String id = this.goodsIdTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要删除的货物");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除此货物？");
		Goods goods = new Goods(Integer.parseInt(id));
		if(n==0){
			Connection conn = null;
			try {
				conn = dbUtil.getCon();
				int result = goodsDao.deleteGoods(conn, goods);
				if(result==1){
					JOptionPane.showMessageDialog(null, "货物删除成功!");
					this.resetValue();
					this.fillGoodsTable(new Goods());
				}else{
					JOptionPane.showMessageDialog(null, "货物删除失败!");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "货物删除失败!");
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
	 * 货物修改事件
	 * @param a
	 */
    private void modifyGoodsActionPerformed(Object a) {
		// TODO Auto-generated method stub
		String id = this.goodsIdTxt.getText();
		String goodsName = this.goodsNameTxt.getText();
		String price = this.priceTxt.getText();
		String goodsSupplier = this.goodsSupplierTxt.getText();
		String goodsDesc = this.goodsDescTxt.getText();
		if(StringUtil.isEmpty(id)){
			JOptionPane.showMessageDialog(null, "请选择要修改的货物");
			return;
		}
		if(StringUtil.isEmpty(goodsName)){
			JOptionPane.showMessageDialog(null, "货物名称不能为空!");
			return;
		}
		if(StringUtil.isEmpty(price)){
			JOptionPane.showMessageDialog(null, "货物价格不能为空!");
			return;
		}
		if(StringUtil.isEmpty(goodsSupplier)){
			JOptionPane.showMessageDialog(null, "供货商名称不能为空!");
			return;
		}
		if(StringUtil.isEmpty(goodsDesc)){
			JOptionPane.showMessageDialog(null, "货物描述不能为空!");
			return;
		}
		String sex = "";
		if(manJrb.isSelected()){
			sex = "男";
		}else if(femaleJrb.isSelected()){
			sex = "女";
		}
		GoodsType goodsType = (GoodsType)this.goodsTypeNameJcb.getSelectedItem();
		int goodsTypeId = goodsType.getId();
		Goods goods = new Goods(Integer.parseInt(id), goodsName, goodsSupplier, sex, Double.parseDouble(price), goodsDesc,goodsTypeId);
		Connection conn = null;
		
		try {
			conn = DbUtil.getCon();
			int result = GoodsDao.updateGoods(conn, goods);
			if(result == 1){
				JOptionPane.showMessageDialog(null, "货物修改成功!");
				this.fillGoodsTable(new Goods());
				
			}else{
				JOptionPane.showMessageDialog(null, "货物修改失败!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "货物修改失败!");
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
	 * 货物搜索事件
	 * @param arg0
	 */
	private void searchGoodsActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String goodsName = this.s_goodsNameTxt.getText();
		String goodsSupplier = this.s_goodsSupplierTxt.getText();
		GoodsType goodsType = (GoodsType)this.s_goodsTypeNameJcbTxt.getSelectedItem();
		int goodsTypeId = goodsType.getId();
		Goods goods = new Goods(goodsName, goodsSupplier, goodsTypeId);
		this.fillGoodsTable(goods);
	}

	/**
	 * 填充下拉列表菜单
	 * @param type
	 */
	private void fillGoodsTypeNameItem(String type){
		Connection conn = null;
		GoodsType goodsType = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getCon();
			rs = goodsTypeDao.listGoodsType(conn, new GoodsType());
			if("search".equals(type)){
				goodsType = new GoodsType();
				goodsType.setGoodsTypeName("请选择...");
				goodsType.setId(-1);
				this.s_goodsTypeNameJcbTxt.addItem(goodsType);
			}
			while(rs.next()){
				goodsType = new GoodsType();
				goodsType.setId(rs.getInt("id"));
				goodsType.setGoodsTypeName(rs.getString("goodsTypeName"));
				if("search".equals(type)){
					this.s_goodsTypeNameJcbTxt.addItem(goodsType);
				}else if("modify".equals(type)){
					this.goodsTypeNameJcb.addItem(goodsType);
				}
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
	/**
	 * 填充表单事件
	 * @param goods
	 */
	private void fillGoodsTable(Goods goods){
		DefaultTableModel dtm = (DefaultTableModel)goodsTable.getModel();
		dtm.setRowCount(0);
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getCon();
			rs = goodsDao.listGoods(conn, goods);
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("goodsName"));
				v.add(rs.getString("goodsSupplier"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("price"));
				v.add(rs.getString("goodsDesc"));
				v.add(rs.getString("goodsTypeName"));
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
	/**
	 * 鼠标点击事件
	 * @param arg0
	 */
	private void MouseClickGoodsTableActionPerformed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row = this.goodsTable.getSelectedRow();
		this.goodsIdTxt.setText(goodsTable.getValueAt(row, 0)+"");
		this.goodsNameTxt.setText(goodsTable.getValueAt(row, 1)+"");
		this.goodsSupplierTxt.setText(goodsTable.getValueAt(row, 2)+"");
		String sex = (String)goodsTable.getValueAt(row, 3);
		if("男".equals(sex)){
			this.manJrb.setSelected(true);
		}else if("女".equals(sex)){
			this.femaleJrb.setSelected(true);
		}
		
		this.priceTxt.setText(goodsTable.getValueAt(row, 4)+"");
		this.goodsDescTxt.setText(goodsTable.getValueAt(row, 5)+"");
		String goodsTypeName = (String)this.goodsTable.getValueAt(row, 6);
		int n = this.goodsTypeNameJcb.getItemCount();
		for(int i = 0; i < n; i++){
			GoodsType item = (GoodsType)this.goodsTypeNameJcb.getItemAt(i);
			if(item.getGoodsTypeName().equals(goodsTypeName)){
				this.goodsTypeNameJcb.setSelectedIndex(i);
			}
		}
		
		
		
		
	}

	/**
	 * 重置事件
	 * @param arg0
	 */
	private void resetValueActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.resetValue();
	}
	/**
	 * 重置表单
	 */
	private void resetValue(){
		this.goodsIdTxt.setText("");
		this.goodsNameTxt.setText("");
		this.goodsSupplierTxt.setText("");
		this.priceTxt.setText("");
		this.goodsDescTxt.setText("");
		this.manJrb.setSelected(true);
		//下拉菜单的重置
		if(this.goodsTypeNameJcb.getItemCount()>0){
			this.goodsTypeNameJcb.setSelectedIndex(0);
		}
	}
}
