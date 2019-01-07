package com.runtime.instructions;

import com.runtime.Frame;
import com.vm.data.type.Type;
import com.vm.data.type.Value;

public class ACONST_NULL extends Instruction {

//	public ACONST_NULL(short opcode, short length) {
//		super(opcode, length);
//	}

	@Override
	public void fetchOperands(BytesReader reader) {
		
	}

	@Override
	public void execute(Frame frame) {
		frame.getStack().push(new Value(Type.NULL, null));
	}
	

}
