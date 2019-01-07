package com.classfile.parse.constant;

import com.classfile.constant.Constants;

public class MethodRefConstantInfo extends CPRefConstantInfo {
	
	public MethodRefConstantInfo(int classIndex, int nameAndTypeIndex, CfConstantPool cp) {
		super(Constants.CONSTANT_METHOD_REF, classIndex, nameAndTypeIndex, cp);
	}

}
