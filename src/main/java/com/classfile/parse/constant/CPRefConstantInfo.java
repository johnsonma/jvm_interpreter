package com.classfile.parse.constant;

import com.classfile.constant.Constants;

public abstract class CPRefConstantInfo extends ConstantInfo {
	
	private int classIndex;
	private int nameAndTypeIndex;
	
	public CPRefConstantInfo(byte tag, int classIndex, int nameAndTypeIndex, CfConstantPool cp) {
		super(tag, cp);
		this.classIndex = classIndex;
		this.nameAndTypeIndex = nameAndTypeIndex;
	}
	
	public String getClassName() {
		Utf8ConstantInfo utf8 = (Utf8ConstantInfo) cp.getConstant(classIndex, Constants.CONSTANT_UTF8);
		return utf8.getValue();
	}
	
	
	public String[] getNameAndDes() {
		NameAndTypeConstantInfo constantInfo = (NameAndTypeConstantInfo) cp.getConstant(nameAndTypeIndex, Constants.CONSTANT_NAME_AND_TYPE);
		return new String[]{constantInfo.getName(), constantInfo.getDescription()};
	}

}
