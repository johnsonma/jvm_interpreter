package com.runtime.heap;
import com.classfile.parse.constant.CPRefConstantInfo;

public abstract class MemberReference extends SymbolReference {
	protected String name;
	protected String description;

	public MemberReference(ConstantPool cp, CPRefConstantInfo constantInfo) {
		super(cp, constantInfo.getClassName());
		String[] nameAndDes = constantInfo.getNameAndDes();
		this.name = nameAndDes[0];
		this.description = nameAndDes[1];
	}
	
}
