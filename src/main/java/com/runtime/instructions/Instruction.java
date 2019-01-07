package com.runtime.instructions;

import com.runtime.Frame;

public abstract class Instruction {
//	protected short length = 1; // Length of instruction in bytes 
//    protected short opcode = -1; // Opcode number
//    
//    public Instruction(short opcode, short length) {
//        this.length = length;
//        this.opcode = opcode;
//    }
	
	public Instruction() {
		
	}
    
    public abstract void fetchOperands(BytesReader reader);
    	

    public abstract void execute(Frame frame);
}
