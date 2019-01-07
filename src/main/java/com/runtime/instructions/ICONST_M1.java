package com.runtime.instructions;

import com.runtime.Frame;
import com.vm.data.type.Type;
import com.vm.data.type.Value;

public class ICONST_M1 extends Instruction {

	@Override
	public void fetchOperands(BytesReader reader) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(Frame frame) {
		frame.getStack().push(new Value(Type.INT, Integer.valueOf(-1)));
	}

}
