package com.runtime.heap;

import com.classfile.parse.constant.MethodRefConstantInfo;

public class MethodReference extends MemberReference {
	private MethodMember method;

	public MethodReference(ConstantPool cp, MethodRefConstantInfo constantInfo) {
		super(cp, constantInfo);
		// TODO Auto-generated constructor stub
	}

}
