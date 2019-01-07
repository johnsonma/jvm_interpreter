package com.runtime.heap;

import com.vm.data.type.Value;

public class JavaObject {
	private Class klass;
	private Value[] fields;
	
	public JavaObject(Class klass) {
		this.klass = klass;
		fields = new Value[klass.getInstanceCount()];
	}
}
