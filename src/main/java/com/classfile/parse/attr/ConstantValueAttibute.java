package com.classfile.parse.attr;

public class ConstantValueAttibute extends Attribute {
	private int constantValueIndex;

	public ConstantValueAttibute(int nameIndex, int length, int constantValueIndex) {
		super(nameIndex, length);
		this.constantValueIndex = constantValueIndex;
	}

}
