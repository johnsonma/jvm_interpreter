package com.classfile.parse.constant;

import com.classfile.constant.Constants;
import com.classfile.parse.attr.Attribute;
import com.classfile.parse.attr.ConstantValueAttibute;

public abstract class FieldOrMethod {
	protected int accessFlags;
	
	protected int nameIndex;
	
	protected int desIndex;
	
	protected int attrCount;
	
	protected Attribute[] attributes;
	
	protected CfConstantPool cp;
	
	public FieldOrMethod(int accessFlags, int nameIndex, int desIndex, int attrCount, CfConstantPool cp) {
		this.accessFlags = accessFlags;
		this.nameIndex = nameIndex;
		this.desIndex = desIndex;
		this.attrCount = attrCount;
		this.attributes = new Attribute[attrCount];
		this.cp = cp;
	}
	
	public void setAttribute(int index, Attribute attribute) {
		attributes[index] = attribute;
	}

	public int getAccessFlags() {
		return accessFlags;
	}

	public String getName() {
		Utf8ConstantInfo utf8 = (Utf8ConstantInfo) cp.getConstant(nameIndex, Constants.CONSTANT_UTF8);
		return utf8.getValue();
	}

	public String getDes() {
		Utf8ConstantInfo utf8 = (Utf8ConstantInfo) cp.getConstant(desIndex, Constants.CONSTANT_UTF8);
		return utf8.getValue();
	}

	public int getAttrCount() {
		return attrCount;
	}

	public Attribute[] getAttributes() {
		return attributes;
	}
	
	public ConstantValueAttibute getConstantAttribute() {
		for (Attribute attr : attributes) {
			Utf8ConstantInfo utf8 = (Utf8ConstantInfo) cp.getConstant(attr.getNameIndex(), Constants.CONSTANT_UTF8);
			if (utf8.getTag() == Constants.ATTR_CONSTANT_VALUE) {
				return (ConstantValueAttibute) attr;
			}
		}
		return null;
	}
	
}
