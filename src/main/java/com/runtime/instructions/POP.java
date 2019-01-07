package com.runtime.instructions;

import com.runtime.Frame;

public class POP extends Instruction {

	@Override
	public void fetchOperands(BytesReader reader) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(Frame frame) {
		frame.getStack().pop();
	}

}
