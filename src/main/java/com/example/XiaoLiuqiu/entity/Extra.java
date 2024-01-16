package com.example.XiaoLiuqiu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "extra")
public class Extra {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "extra_id")
	private int extraId;
	
	@Column(name = "extra_name")
	private String extraName;
	
	@Column(name = "extra_price")
	private int extraPrice;

	public Extra() {
		super();
	}

	

	public Extra(String extraName, int extraPrice) {
		super();
		this.extraName = extraName;
		this.extraPrice = extraPrice;
	}



	public int getExtraId() {
		return extraId;
	}

	public void setExtraId(int extraId) {
		this.extraId = extraId;
	}

	public String getExtraName() {
		return extraName;
	}

	public void setExtraName(String extraName) {
		this.extraName = extraName;
	}

	public int getExtraPrice() {
		return extraPrice;
	}

	public void setExtraPrice(int extraPrice) {
		this.extraPrice = extraPrice;
	}

	
}
