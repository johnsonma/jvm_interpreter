package com.classfile;

import com.classfile.constant.Constants;
import com.classfile.parse.attr.Attribute;
import com.classfile.parse.constant.CfConstantPool;
import com.classfile.parse.constant.ClassConstantInfo;
import com.classfile.parse.constant.Field;
import com.classfile.parse.constant.Method;
import com.classfile.parse.constant.Utf8ConstantInfo;

public class JavaClass {
	private int magic;
	
	private int minor;
	
	private int majar;
	
	private int accessFlags;
	
	private int thisClass;
	
	private int superClass;
	
	private int interfaceCount;
	
	private int[] interfaces;
	
	private int fieldCount;
	
	private Field[] fields;
	
	private int methodCount;
	
	private Method[] methods;
	
	private int attrCount;
	
	private Attribute[] attrs;
	
	private CfConstantPool constantPool;
	
	public JavaClass() {
		
	}
	
	
	public CfConstantPool getConstantPool() {
		return constantPool;
	}

	public void setMagic(int magic) {
		this.magic = magic;
	}

	public void setMinor(int minor) {
		this.minor = minor;
	}

	public void setMajar(int majar) {
		this.majar = majar;
	}

	public void setConstantPool(CfConstantPool constantPool) {
		this.constantPool = constantPool;
	}

	public void setAccessFlags(int accessFlags) {
		this.accessFlags = accessFlags;
	}

	public void setThisClass(int thisClass) {
		this.thisClass = thisClass;
	}

	public void setSuperClass(int superClass) {
		this.superClass = superClass;
	}

	public void setInterfaceCount(int interfaceCount) {
		this.interfaceCount = interfaceCount;
		this.interfaces = new int[interfaceCount];
	}
	
	public void setInterface(int index, int constantPoolIndex) {
		interfaces[index] = constantPoolIndex;
	}

	public void setFieldCount(int fieldCount) {
		this.fieldCount = fieldCount;
		fields = new Field[fieldCount];
	}
	
	public void setField(int index, Field field) {
		fields[index] = field;
	}

	public void setMethodCount(int methodCount) {
		this.methodCount = methodCount;
		methods = new Method[methodCount];
	}
	
	public void setMethod(int index, Method method) {
		methods[index] = method;
	}


	public void setAttrCount(int attrCount) {
		this.attrCount = attrCount;
		attrs = new Attribute[attrCount];
	}

	public void setAttr(int index, Attribute attr) {
		attrs[index] = attr;
	}


	public int getMagic() {
		return magic;
	}


	public int getMinor() {
		return minor;
	}


	public int getMajar() {
		return majar;
	}


	public int getAccessFlags() {
		return accessFlags;
	}


	public int getThisClass() {
		return thisClass;
	}


	public int getSuperClass() {
		return superClass;
	}
	
	public String getName() {
		return constantPool.getClassName(thisClass);
	}
	
	public String getSuperClassName() {
		return constantPool.getClassName(superClass);
	}
	
	public String[] getInterfaceNames() {
		String[] interfaceNames = new String[interfaces.length];
		for (int i = 0; i < interfaces.length; i++) {
			interfaceNames[i] = constantPool.getClassName(interfaces[i]);
		}
		return interfaceNames;
	}


	public int getInterfaceCount() {
		return interfaceCount;
	}


	public int[] getInterfaces() {
		return interfaces;
	}


	public int getFieldCount() {
		return fieldCount;
	}


	public Field[] getFields() {
		return fields;
	}


	public int getMethodCount() {
		return methodCount;
	}


	public Method[] getMethods() {
		return methods;
	}


	public int getAttrCount() {
		return attrCount;
	}


	public Attribute[] getAttrs() {
		return attrs;
	}
	
	
	
}
