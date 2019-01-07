package com.classfile.parse.constant;

public abstract class ConstantInfo {
	protected byte tag;
	protected CfConstantPool cp;
	
	public ConstantInfo(byte tag, CfConstantPool cp) {
		this.tag = tag;
		this.cp = cp;
	}
	
	public byte getTag() {
		return tag;
	}
	

}
