package com.runtime;

import com.vm.data.type.Value;

public class LocalVariables {
	private final Value[] locals;
	
	public LocalVariables(int maxLocals) {
		locals = new Value[maxLocals];
		for (int i = 0; i < maxLocals; i++) {
			locals[i] = Value.NULL;
		}
	}
	
	public Value get(int i) {
		return locals[i];
	}
	
	public void set(Value type, int i) {
		locals[i] = type;
	}

}
