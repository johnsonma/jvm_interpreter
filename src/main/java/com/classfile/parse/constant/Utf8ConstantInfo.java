package com.classfile.parse.constant;

import com.classfile.constant.Constants;

public class Utf8ConstantInfo extends ConstantInfo {
	private String bytes;
	
	public Utf8ConstantInfo(String bytes, CfConstantPool cp) {
		super(Constants.CONSTANT_UTF8, cp);
		this.bytes = bytes;
	}
	
	public String getValue() {
		return bytes;
	}
}
