package com.runtime.instructions;

import com.runtime.Frame;
import com.runtime.OperandStack;
import com.vm.data.type.Value;

public class SWAP extends Instruction {

	@Override
	public void fetchOperands(BytesReader reader) {
		
	}

	@Override
	public void execute(Frame frame) {
		OperandStack stack = frame.getStack();
		Value val1 = stack.pop();
		Value val2 = stack.pop();
		stack.push(val1);
		stack.push(val2);
	}

}
