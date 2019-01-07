package com.classfile.parse.constant;

import com.classfile.constant.Constants;
import com.vm.data.type.Type;
import com.vm.data.type.Value;

public class FloatConstantInfo extends ConstantInfo {
	
	private float bytes;
	
	public FloatConstantInfo(float bytes, CfConstantPool cp) {
		super(Constants.CONSTANT_FLOAT, cp);
		this.bytes = bytes;
	}
	
	
	public Value getValue() {
		return new Value(Type.FLOAT, Float.valueOf(bytes));
	}

}
