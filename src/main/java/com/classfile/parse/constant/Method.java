package com.classfile.parse.constant;

import com.classfile.constant.Constants;
import com.classfile.parse.attr.Attribute;
import com.classfile.parse.attr.CodeAttribute;

public class Method extends FieldOrMethod {

	public Method(int accessFlags, int nameIndex, int desIndex, int attrCount, CfConstantPool cp) {
		super(accessFlags, nameIndex, desIndex, attrCount, cp);
	}
	
	public CodeAttribute getCodeAttribute() {
		for (Attribute attr : attributes) {
			Utf8ConstantInfo utf8 = (Utf8ConstantInfo) cp.getConstant(attr.getNameIndex(), Constants.CONSTANT_UTF8);
			if (utf8.getTag() == Constants.ATTR_CODE) {
				return (CodeAttribute) attr;
			}
		}
		return null;
	}

}
