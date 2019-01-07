package com.classfile.parse.constant;

import com.classfile.constant.Constants;

public class StringConstantInfo extends ConstantInfo {

	private int stringIndex;
	
	public StringConstantInfo(int stringIndex, CfConstantPool cp) {
		super(Constants.CONSTANT_STRING, cp);
		this.stringIndex = stringIndex;
	}
	
	public String getValue() {
		Utf8ConstantInfo utf8 = (Utf8ConstantInfo) cp.getConstant(stringIndex, Constants.CONSTANT_UTF8);
		return utf8.getValue();
	}
	
	
}
