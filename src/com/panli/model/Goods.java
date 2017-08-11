package com.panli.model;
/**
 * Goods实体类
 * @author Peter
 *
 */
public class Goods {
	private int id;
	private String goodsName;
	private String goodsSupplier;
	private String sex;
	private double price;
	private String goodsDesc;
	private Integer goodsTypeId;
	private String goodsTypeName;
	/**
	 * 继承父类的构造方法
	 */
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 一个参数的构造方法
	 * @param id
	 */
	public Goods(int id) {
		super();
		this.id = id;
	}

	/**
	 * 3个参数构造方法
	 * @param goodsName
	 * @param goodsSupplier
	 * @param goodsTypeId
	 */
	public Goods(String goodsName, String goodsSupplier, Integer goodsTypeId) {
		super();
		this.goodsName = goodsName;
		this.goodsSupplier = goodsSupplier;
		this.goodsTypeId = goodsTypeId;
	}


	/**
	 * 6个参数的构造方法
	 * @param goodsName
	 * @param goodsSupplier
	 * @param sex
	 * @param price
	 * @param goodsDesc
	 * @param goodsTypeId
	 */
	public Goods(String goodsName, String goodsSupplier, String sex, double price, String goodsDesc, int goodsTypeId) {
		super();
		this.goodsName = goodsName;
		this.goodsSupplier = goodsSupplier;
		this.sex = sex;
		this.price = price;
		this.goodsDesc = goodsDesc;
		this.goodsTypeId = goodsTypeId;
	}
	
	/**
	 * 7个参数的构造方法
	 * @param id
	 * @param goodsName
	 * @param goodsSupplier
	 * @param sex
	 * @param price
	 * @param goodsDesc
	 * @param goodsTypeId
	 */
	public Goods(int id, String goodsName, String goodsSupplier, String sex, double price, String goodsDesc,
			Integer goodsTypeId) {
		super();
		this.id = id;
		this.goodsName = goodsName;
		this.goodsSupplier = goodsSupplier;
		this.sex = sex;
		this.price = price;
		this.goodsDesc = goodsDesc;
		this.goodsTypeId = goodsTypeId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsSupplier() {
		return goodsSupplier;
	}
	public void setGoodsSupplier(String goodsSupplier) {
		this.goodsSupplier = goodsSupplier;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public Integer getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public String getGoodsTypeName() {
		return goodsTypeName;
	}

	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}
	
	
}
