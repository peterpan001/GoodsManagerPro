package com.panli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.panli.model.Goods;
import com.panli.util.StringUtil;

/**
 * 货物控制操作包
 * @author Peter
 *
 */
public class GoodsDao {
	
	
	/**
	 * 货物删除事件
	 * @param conn
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	public static int deleteGoods(Connection conn, Goods goods)throws Exception{
		String sql = "delete from t_goods where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, goods.getId());
		return pstmt.executeUpdate();
	}
	/**
	 * 货物更新事件
	 * @param conn
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	public static int updateGoods(Connection conn, Goods goods)throws Exception{
		String sql = "update t_goods set goodsName=?, goodsSupplier=?, sex=?,"
				+ " price=?, goodsDesc=? , goodsTypeId = ? where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, goods.getGoodsName());
		pstmt.setString(2, goods.getGoodsSupplier());
		pstmt.setString(3, goods.getSex());
		pstmt.setDouble(4, goods.getPrice());
		pstmt.setString(5, goods.getGoodsDesc());
		pstmt.setInt(6, goods.getGoodsTypeId());
		pstmt.setInt(7, goods.getId());
		return pstmt.executeUpdate();
	}
	
	
	/**
	 * 货物查询事件
	 * @param conn
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	public static ResultSet listGoods(Connection conn, Goods goods) throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_goods t_g, t_goodsType t_gt where t_g.goodsTypeId=t_gt.id");
		if(StringUtil.isNotEmpty(goods.getGoodsName())){
			sb.append(" and t_g.goodsName like '%"+goods.getGoodsName()+"%'");
		}
		if(StringUtil.isNotEmpty(goods.getGoodsSupplier())){
			sb.append(" and t_g.goodsSupplier like '%"+goods.getGoodsSupplier()+"%'");
		}
		if(goods.getGoodsTypeId()!=null && goods.getGoodsTypeId()!=-1){
			sb.append(" and t_g.goodsTypeId like '%"+goods.getGoodsTypeId()+"%'");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	/**
	 * 添加货物
	 * @param conn
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	public static int addGoods(Connection conn, Goods goods)throws Exception{
		String sql = "insert into t_goods values(null, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, goods.getGoodsName());
		pstmt.setString(2, goods.getGoodsSupplier());
		pstmt.setString(3, goods.getSex());
		pstmt.setDouble(4, goods.getPrice());
		pstmt.setString(5, goods.getGoodsDesc());
		pstmt.setInt(6, goods.getGoodsTypeId());
		return pstmt.executeUpdate();
	}
}
