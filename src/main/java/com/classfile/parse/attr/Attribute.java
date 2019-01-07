package com.classfile.parse.attr;

abstract public class Attribute {
	private int nameIndex;
	
	private int length;
	
	public Attribute(int nameIndex, int length) {
		this.nameIndex = nameIndex;
		this.length = length;
	}

	public int getNameIndex() {
		return nameIndex;
	}

	public int getLength() {
		return length;
	}
	
	

}
