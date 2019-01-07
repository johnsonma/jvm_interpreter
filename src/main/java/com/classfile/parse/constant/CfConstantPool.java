package com.classfile.parse.constant;

import com.classfile.constant.Constants;

public class CfConstantPool {
	private ConstantInfo[] cp;
	
	private int count;
	
	public CfConstantPool(int count) {
		cp = new ConstantInfo[count];
	}
	
	public ConstantInfo getConstant(int index) {
		return cp[index];
	}
	
	public void setConstant(int index, ConstantInfo constant) {
		cp[index] = constant;
	}
	
	public ConstantInfo getConstant(int index, byte tag) {
		ConstantInfo constant = cp[index];
		if (constant.getTag() != tag) {
			throw new RuntimeException("Not the right tag");
		}
		return constant;
	}

	public int getCount() {
		return count;
	}
	
	public String getClassName(int classIndex) {
		if (classIndex > 0) {
			ClassConstantInfo constantInfo = (ClassConstantInfo) getConstant(classIndex, Constants.CONSTANT_CLASS);
			return constantInfo.getClassName();
		}
		return "";
	}

}
