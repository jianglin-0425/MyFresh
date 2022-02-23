package com.jl.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemVO {
	private Integer ino;
	private String ono;
	private Integer gno;
	private Integer nums;
	private Double price;
	private Integer status;
	private String gname;
	private String weight;
	private String unit ;
	private String pics;
}
