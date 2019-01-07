package com.classfile.parse.constant;

import com.classfile.constant.Constants;

public class NameAndTypeConstantInfo extends ConstantInfo {
	private int nameIndex;
	private int desIndex;
	
	public NameAndTypeConstantInfo(int nameIndex, int desIndex, CfConstantPool cp) {
		super(Constants.CONSTANT_NAME_AND_TYPE, cp);
		this.nameIndex = nameIndex;
		this.desIndex = desIndex;
	}
	
	public String getName() {
		Utf8ConstantInfo utf8 = (Utf8ConstantInfo) cp.getConstant(nameIndex, Constants.CONSTANT_UTF8);
		return utf8.getValue();
	}
	
	public String getDescription() {
		Utf8ConstantInfo utf8 = (Utf8ConstantInfo) cp.getConstant(desIndex, Constants.CONSTANT_UTF8);
		return utf8.getValue();
	}
	
}
