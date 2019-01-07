package com.classfile.parse.attr;

public class CodeAttribute extends Attribute {
	public class ExceptionTable {
		private int startPc;
		private int endPc;
		private int handlerPc;
		private int catchType;
		
		public ExceptionTable(int startPc, int endPc, int handlerPc, int catchType) {
			this.startPc = startPc;
			this.endPc = endPc;
			this.handlerPc = handlerPc;
			this.catchType = catchType;
		}
	}
	
	private int maxStack;
	
	private int maxLocals;
	
	private int codeLength;
	
	private byte[] code;
	
	private int exceptionTableLength;
	
	private ExceptionTable[] exceptionTables;
	
	private int attributeCount;
	
	private Attribute[] attributes;
	

	public CodeAttribute(int nameIndex, int length) {
		super(nameIndex, length);
	}

	

	public int getMaxStack() {
		return maxStack;
	}



	public int getMaxLocals() {
		return maxLocals;
	}



	public int getCodeLength() {
		return codeLength;
	}



	public byte[] getCode() {
		return code;
	}



	public int getExceptionTableLength() {
		return exceptionTableLength;
	}



	public ExceptionTable[] getExceptionTables() {
		return exceptionTables;
	}



	public int getAttributeCount() {
		return attributeCount;
	}



	public Attribute[] getAttributes() {
		return attributes;
	}



	public void setMaxStack(int maxStack) {
		this.maxStack = maxStack;
	}


	public void setMaxLocals(int maxLocals) {
		this.maxLocals = maxLocals;
	}


	public void setCodeLength(int codeLength) {
		this.codeLength = codeLength;
	}


	public void setCode(byte[] code) {
		this.code = code;
	}


	public void setExceptionTableLength(int exceptionTableLength) {
		this.exceptionTableLength = exceptionTableLength;
		this.exceptionTables = new ExceptionTable[exceptionTableLength];
	}


	public void setExceptionTable(int index, int startPc, int endPc, int handlerPc, int catchType) {
		ExceptionTable table = new ExceptionTable(startPc, endPc, handlerPc, catchType);
		exceptionTables[index] = table;
	}


	public void setAttributeCount(int attributeCount) {
		this.attributeCount = attributeCount;
		attributes = new Attribute[attributeCount];
	}


	public void setAttribute(int index, Attribute attribute) {
		attributes[index] = attribute;
	}
	

	
}
