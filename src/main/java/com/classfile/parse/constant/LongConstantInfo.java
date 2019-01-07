package com.classfile.parse.constant;

import com.classfile.constant.Constants;
import com.vm.data.type.Type;
import com.vm.data.type.Value;

public class LongConstantInfo extends ConstantInfo {
	
	private long bytes;
	
	public LongConstantInfo(long bytes, CfConstantPool cp) {
		super(Constants.CONSTANT_LONG, cp);
		this.bytes = bytes;
	}
	
	public Value getValue() {
		return new Value(Type.LONG, Long.valueOf(bytes));
	}

}
