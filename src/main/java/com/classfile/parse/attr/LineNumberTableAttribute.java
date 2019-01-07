package com.classfile.parse.attr;

public class LineNumberTableAttribute extends Attribute {
	
	public class LineNumberTable {
		private int startPc;
		private int lineNumber;
		
		public LineNumberTable(int startPc, int lineNumber) {
			this.startPc = startPc;
			this.lineNumber = lineNumber;
		}
	}
	
	private int tableLength;
	
	private LineNumberTable[] tables;
	

	public LineNumberTableAttribute(int nameIndex, int length) {
		super(nameIndex, length);
		// TODO Auto-generated constructor stub
	}


	public void setTableLength(int tableLength) {
		this.tableLength = tableLength;
		tables = new LineNumberTable[tableLength];
	}


	public void setTable(int index, int startPc, int lineNumber) {
		LineNumberTable table = new LineNumberTable(startPc, lineNumber);
		this.tables[index] = table;
	}

	
}
