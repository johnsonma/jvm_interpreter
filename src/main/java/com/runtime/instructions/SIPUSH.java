package com.runtime.instructions;


import com.runtime.Frame;
import com.vm.data.type.Type;
import com.vm.data.type.Value;

public class SIPUSH extends Instruction {
	private short val;

	@Override
	public void fetchOperands(BytesReader reader) {
		val = reader.readShort();
	}

	@Override
	public void execute(Frame frame) {
		frame.getStack().push(new Value(Type.INT, Integer.valueOf(val)));
	}
	
	
}
