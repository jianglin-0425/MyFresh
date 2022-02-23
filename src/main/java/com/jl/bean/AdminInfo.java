package com.jl.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdminInfo implements Serializable{
	//private static final long serialVersionUID=2905747132495005688L;
	private String aid;
	private String aname;
	private String pwd;
	private String tel;
	
}
