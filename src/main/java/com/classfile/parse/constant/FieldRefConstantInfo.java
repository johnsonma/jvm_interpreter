package com.classfile.parse.constant;

import com.classfile.constant.Constants;

public class FieldRefConstantInfo extends CPRefConstantInfo {
	
	private int classIndex;
	private int nameAndTypeIndex;
	
	
	public FieldRefConstantInfo(int classIndex, int nameAndTypeIndex, CfConstantPool cp) {
		super(Constants.CONSTANT_FIELD_REF, classIndex, nameAndTypeIndex, cp);
	}

}
