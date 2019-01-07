package com.runtime.instructions;

import com.runtime.Frame;
import com.vm.data.type.Value;

public class DUP extends Instruction {

	@Override
	public void fetchOperands(BytesReader reader) {
		
	}

	@Override
	public void execute(Frame frame) {
		Value val = frame.getStack().pop();
		frame.getStack().push(val);
		frame.getStack().push(val);
	}

}
