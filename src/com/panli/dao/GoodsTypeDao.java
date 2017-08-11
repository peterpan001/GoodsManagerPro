package com.panli.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.panli.model.GoodsType;
import com.panli.util.StringUtil;

/**
 * 对GoodsType操作进行控制的类
 * @author Peter
 *
 */
public class GoodsTypeDao {
	
	/**
	 * 判断货物类别目录下是否有货物
	 * @param conn
	 * @param goodsTypeId
	 * @return
	 * @throws Exception
	 */
	public static boolean exitGoodsByGoodTypeId(Connection conn, String goodsTypeId) throws Exception{
		String sql = "select * from t_goods where goodsTypeId ="+goodsTypeId;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		return rs.next();
	}
	
	/**
	 * 货物类别删除事件
	 * @param conn
	 * @param goodsType
	 * @return
	 * @throws SQLException
	 */
	public static int deleteGoodsType(Connection conn, GoodsType goodsType) throws SQLException{
		String sql = "delete from t_goodsType where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, goodsType.getId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 货物类别更新事件
	 * @param conn
	 * @param goodsType
	 * @return
	 * @throws Exception
	 */
	public static int updateGoodsType(Connection conn, GoodsType goodsType) throws Exception{
		
		String sql = " update t_goodsType set goodsTypeName=?, goodsTypeDesc=? where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, goodsType.getGoodsTypeName());
		pstmt.setString(2, goodsType.getGoodsTypeDesc());
		pstmt.setInt(3, goodsType.getId());
		return pstmt.executeUpdate();
	}
	
	
	/**
	 * 货物列表查询事件
	 * @param conn
	 * @param goodsType
	 * @return
	 * @throws Exception
	 */
	public static ResultSet listGoodsType(Connection conn, GoodsType goodsType) throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_goodsType");
		if(StringUtil.isNotEmpty(goodsType.getGoodsTypeName())){
			sb.append(" and goodsTypeName like '%"+goodsType.getGoodsTypeName()+"%' ");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	/**
	 *货物类别添加事件 
	 * @param conn
	 * @param goodsType
	 * @return
	 * @throws SQLException
	 */
	public static int addGoodsType(Connection conn, GoodsType goodsType) throws SQLException{
		String sql = "insert into t_goodsType values(null, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, goodsType.getGoodsTypeName());
		pstmt.setString(2, goodsType.getGoodsTypeDesc());
		return pstmt.executeUpdate();
	}
}
