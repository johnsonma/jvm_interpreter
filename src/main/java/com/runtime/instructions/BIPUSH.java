package com.runtime.instructions;

import com.runtime.Frame;
import com.vm.data.type.Type;
import com.vm.data.type.Value;

public class BIPUSH extends Instruction {
	private byte val;

	@Override
	public void fetchOperands(BytesReader reader) {
		val = reader.readByte();
	}

	@Override
	public void execute(Frame frame) {
		frame.getStack().push(new Value(Type.INT, Integer.valueOf(val)));
	}
	
	
}
