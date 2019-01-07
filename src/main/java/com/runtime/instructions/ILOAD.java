package com.runtime.instructions;

import com.runtime.Frame;
import com.vm.data.type.Value;

public class ILOAD extends LocalVariableInstruction {

	@Override
	public void execute(Frame frame) {
		iload(frame, index);
	}
	
	private void iload(Frame frame, int index) {
		Value val = frame.getLocals().get(index);
		frame.getStack().push(val);
	}
	
}
