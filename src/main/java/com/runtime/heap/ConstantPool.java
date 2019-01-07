package com.runtime.heap;

import com.classfile.constant.Constants;
import com.classfile.parse.constant.CfConstantPool;
import com.classfile.parse.constant.ClassConstantInfo;
import com.classfile.parse.constant.DoubleConstantInfo;
import com.classfile.parse.constant.FieldRefConstantInfo;
import com.classfile.parse.constant.FloatConstantInfo;
import com.classfile.parse.constant.IntegerConstantInfo;
import com.classfile.parse.constant.InterfaceMethodConstantInfo;
import com.classfile.parse.constant.LongConstantInfo;
import com.classfile.parse.constant.MethodRefConstantInfo;

public class ConstantPool {
	private Class klass;
	
	private RTConstant[] constants;
	
	
	public ConstantPool(Class klass, CfConstantPool cp) {
		constants = new ConstantValue[cp.getCount()];
		this.klass = klass;
		for (int i = 0; i < cp.getCount(); i++) {
			byte tag = cp.getConstant(i).getTag();
			
			if (tag == Constants.CONSTANT_CLASS) {
				constants[i] = new ClassReference(this, (ClassConstantInfo) cp.getConstant(i));
			} else if (tag == Constants.CONSTANT_INTEGER) {
				constants[i] = new ConstantValue(((IntegerConstantInfo)cp.getConstant(i)).getValue());
			} else if (tag == Constants.CONSTANT_LONG) {
				constants[i] = new ConstantValue(((LongConstantInfo)cp.getConstant(i)).getValue());
				i++;
			} else if (tag == Constants.CONSTANT_FLOAT) {
				constants[i] = new ConstantValue(((FloatConstantInfo)cp.getConstant(i)).getValue());
			} else if (tag == Constants.CONSTANT_DOUBLE) {
				constants[i] = new ConstantValue(((DoubleConstantInfo)cp.getConstant(i)).getValue());
				i++;
			} else if (tag == Constants.CONSTANT_STRING)  {
//				constants[i] = new ConstantValue(((StringConstantInfo)cp.getConstant(i)).getValue());
			}
			else if (tag == Constants.CONSTANT_FIELD_REF) {
				constants[i] = new FieldReference(this, (FieldRefConstantInfo) cp.getConstant(i));
			} else if (tag == Constants.CONSTANT_METHOD_REF) {
				constants[i] = new MethodReference(this, (MethodRefConstantInfo) cp.getConstant(i));
			} else if (tag == Constants.CONSTANT_INTERFACE_METHOD_REF) {
				constants[i] = new InterfaceMethodReference(this, (InterfaceMethodConstantInfo) cp.getConstant(i));
			}
		}
	}
	
	public RTConstant getConstant(int index) {
		if (constants[index] != null) {
			return constants[index];
		}
		throw new RuntimeException("No constants at index " + index);
	}
	
	public Class getKlass() {
		return klass;
	}
}
