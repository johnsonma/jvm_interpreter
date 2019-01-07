package com.classfile.parse.constant;

import com.classfile.constant.Constants;
import com.vm.data.type.Type;
import com.vm.data.type.Value;

public class IntegerConstantInfo extends ConstantInfo {
	private int bytes;
	
	public IntegerConstantInfo(int bytes, CfConstantPool cp) {
		super(Constants.CONSTANT_INTEGER, cp);
		this.bytes = bytes;
	}
	
	public Value getValue() {
		return new Value(Type.INT, Integer.valueOf(bytes));
	}
}
