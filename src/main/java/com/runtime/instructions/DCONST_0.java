package com.runtime.instructions;

import com.runtime.Frame;
import com.vm.data.type.Type;
import com.vm.data.type.Value;

public class DCONST_0 extends Instruction{

	@Override
	public void fetchOperands(BytesReader reader) {
		
	}

	@Override
	public void execute(Frame frame) {
		frame.getStack().push(new Value(Type.DOUBLE, Double.valueOf(0.0)));
	}

}
