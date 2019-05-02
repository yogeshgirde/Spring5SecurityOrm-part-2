package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//JPA 
@Entity
@Table(name="prodtabs")
public class Product {
	@Id
	@GeneratedValue
	@Column(name="pid")
	private int prodId;
	@Column(name="pcode")
	private String prodCode;
	@Column(name="pname")
	private String prodName;
	@Column(name="ptype")
	private String prodType;
	@Column(name="pcost")
	private Double prodCost;
	
	
	public Product() {
		super();
	}
	public Product(int prodId) {
		super();
		this.prodId = prodId;
	}
	public Product(int prodId, String prodCode, String prodName, String prodType, Double prodCost) {
		super();
		this.prodId = prodId;
		this.prodCode = prodCode;
		this.prodName = prodName;
		this.prodType = prodType;
		this.prodCost = prodCost;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public Double getProdCost() {
		return prodCost;
	}
	public void setProdCost(Double prodCost) {
		this.prodCost = prodCost;
	}
	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodCode=" + prodCode + ", prodName=" + prodName + ", prodType="
				+ prodType + ", prodCost=" + prodCost + "]";
	}
	
	
}
