package com.classfile.parse.attr;

public class LocalVariableTableAttribute extends Attribute {
	public class LocalVariableTable {
		int startPc;
		int length;
		int nameIndex;
		int desIndex;
		int index;
		
		public LocalVariableTable(int startPc, int length, int nameIndex, int desIndex, int index) {
			this.startPc = startPc;
			this.length = length;
			this.nameIndex = nameIndex;
			this.desIndex = desIndex;
			this.index = index;
		}
	}
	
	private int tableLength;
	
	private LocalVariableTable[] tables;
	

	public LocalVariableTableAttribute(int nameIndex, int length) {
		super(nameIndex, length);
	}
	
	public void setTableLength(int tableLength) {
		this.tableLength = tableLength;
		tables = new LocalVariableTable[tableLength];
	}
	
	public void setTable(int i, int startPc, int length, int nameIndex, int desIndex, int index) {
		LocalVariableTable table = new LocalVariableTable(startPc, length, nameIndex, desIndex, index);
		tables[i] = table;
	}
	
	

}
