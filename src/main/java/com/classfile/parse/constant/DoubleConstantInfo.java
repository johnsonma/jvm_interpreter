package com.classfile.parse.constant;

import com.classfile.constant.Constants;
import com.vm.data.type.Type;
import com.vm.data.type.Value;

public class DoubleConstantInfo extends ConstantInfo {
	
	private double bytes;
	
	public DoubleConstantInfo(double bytes, CfConstantPool cp) {
		super(Constants.CONSTANT_DOUBLE, cp);
		this.bytes = bytes;
	}
	
	public Value getValue() {
		return new Value(Type.DOUBLE, bytes);
	}

}
