package com.runtime.heap;

import com.classfile.parse.constant.FieldOrMethod;

public class FieldMember extends Member {
	private int constantValueIndex;
	
	private int index;
	
	public FieldMember(FieldOrMethod fieldOrMethod) {
		super(fieldOrMethod);
		if (fieldOrMethod.getConstantAttribute() != null) {
			this.constantValueIndex = fieldOrMethod.getConstantAttribute().getNameIndex(); 
		}
	}
	
	public void setIndex(int index) {
		this.index = index;
	}

}
