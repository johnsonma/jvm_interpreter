package com.classfile.parse.constant;

import com.classfile.constant.Constants;

public class ClassConstantInfo extends ConstantInfo {
	
	private int nameIndex;
	
	public ClassConstantInfo(int nameIndex, CfConstantPool cp) {
		super(Constants.CONSTANT_CLASS, cp);
		this.nameIndex = nameIndex;
	}
	
	public String getClassName() {
		Utf8ConstantInfo utf8 = (Utf8ConstantInfo) cp.getConstant(nameIndex, Constants.CONSTANT_UTF8);
		return utf8.getValue();
	}
	

}
