package com.runtime.heap;

import com.classfile.parse.constant.ClassConstantInfo;

public class ClassReference extends SymbolReference {

	public ClassReference(ConstantPool cp, ClassConstantInfo constantInfo) {
		super(cp, constantInfo.getClassName());
	}

}
