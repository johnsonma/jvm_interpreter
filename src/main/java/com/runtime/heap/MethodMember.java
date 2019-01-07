package com.runtime.heap;

import com.classfile.parse.attr.CodeAttribute;
import com.classfile.parse.constant.FieldOrMethod;
import com.classfile.parse.constant.Method;

public class MethodMember extends Member {
	private int maxStack;
	
	private int maxLocals;
	
	private byte[] code;
	

	public MethodMember(FieldOrMethod fieldOrMethod) {
		super(fieldOrMethod);
		CodeAttribute attr = ((Method) fieldOrMethod).getCodeAttribute();
		if (attr != null) {
			this.maxStack = attr.getMaxStack();
			this.maxLocals = attr.getMaxLocals();
			this.code = attr.getCode();
		}
	}

}
