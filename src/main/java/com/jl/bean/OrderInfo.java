package com.jl.bean;

import lombok.Data;

@Data
public class OrderInfo {
	private String ono;
	private String odate;
	private String ano;
	private String sdate;
	private String rdate;
	private Integer status;  //0未付款  1 支付宝支付  2微信支付  3货到付款
	private Double  price;
	private Integer invoice;
	private Integer mno;

	
}
