package com.panli.model;
/**
 * GoodsType实体类
 * @author Peter
 *
 */
public class GoodsType {
	
	private int id;
	private String goodsTypeName;
	private String goodsTypeDesc;
	/**
	 *继承自父类的构造方法
	 */
	public GoodsType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 一个参数的构造方法
	 * @param goodsTypeName
	 */
	public GoodsType(String goodsTypeName) {
		super();
		this.goodsTypeName = goodsTypeName;
	}
	

	/**
	 * 一个参数的构造方法
	 * @param id
	 */
	public GoodsType(int id) {
		super();
		this.id = id;
	}

	/**
	 * 2个参数的构造方法
	 * @param goodsTypeName
	 * @param goodsTypeDesc
	 */
	public GoodsType(String goodsTypeName, String goodsTypeDesc) {
		super();
		this.goodsTypeName = goodsTypeName;
		this.goodsTypeDesc = goodsTypeDesc;
	}
	
	/**
	 * 3个参数构造方法
	 * @param id
	 * @param goodsTypeName
	 * @param goodsTypeDesc
	 */
	public GoodsType(int id, String goodsTypeName, String goodsTypeDesc) {
		super();
		this.id = id;
		this.goodsTypeName = goodsTypeName;
		this.goodsTypeDesc = goodsTypeDesc;
	}

	
	@Override
	public String toString() {
		return goodsTypeName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodsTypeName() {
		return goodsTypeName;
	}
	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}
	public String getGoodsTypeDesc() {
		return goodsTypeDesc;
	}
	public void setGoodsTypeDesc(String goodsTypeDesc) {
		this.goodsTypeDesc = goodsTypeDesc;
	}
}
