package com.runtime.heap;

import com.vm.data.type.Value;

public class ConstantValue implements RTConstant {
	private Value value;
	public ConstantValue(Value value) {
		this.value = value;
	}
}
