package com.vm.data.type;

public class Value {
	private final Type type;
	private final Object val;
	
	public static Value NULL = new Value(Type.NULL, null);
	
	public Value(Type type, Object val) {
		this.type = type;
		this.val = val;
	}

	public Type getType() {
		return type;
	}

	public Object getVal() {
		return val;
	}
	
}
