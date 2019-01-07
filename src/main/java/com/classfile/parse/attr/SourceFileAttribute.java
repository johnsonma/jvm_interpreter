package com.classfile.parse.attr;

public class SourceFileAttribute extends Attribute {
	
	private int sourceFileIndex;

	public SourceFileAttribute(int nameIndex, int length, int sourceFileIndex) {
		super(nameIndex, length);
		this.sourceFileIndex = sourceFileIndex;
	}

}
