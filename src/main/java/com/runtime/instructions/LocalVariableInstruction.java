package com.runtime.instructions;

public abstract class LocalVariableInstruction extends Instruction {
	protected int index;
	
	
	public void fetchOperands(BytesReader reader) {
		this.index = reader.readUnsignedByte();
	}
	
}
