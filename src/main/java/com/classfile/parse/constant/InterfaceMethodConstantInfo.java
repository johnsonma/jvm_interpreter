package com.classfile.parse.constant;

import com.classfile.constant.Constants;

public class InterfaceMethodConstantInfo extends CPRefConstantInfo {
	
	public InterfaceMethodConstantInfo(int classIndex, int nameAndTypeIndex, CfConstantPool cp) {
		super(Constants.CONSTANT_INTERFACE_METHOD_REF, classIndex, nameAndTypeIndex, cp);
	}

}
