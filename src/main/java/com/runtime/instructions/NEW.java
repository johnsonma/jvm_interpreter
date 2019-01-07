package com.runtime.instructions;

import com.runtime.Frame;
import com.runtime.heap.ClassReference;
import com.runtime.heap.ConstantPool;
import com.runtime.heap.JavaObject;
import com.vm.data.type.ReferenceType;
import com.vm.data.type.Value;

public class NEW extends Instruction {
	private int index;
	
	@Override
	public void fetchOperands(BytesReader reader) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(Frame frame) {
		ConstantPool cp = frame.getMethod().getKlass().getConstantPool();
		ClassReference classRef = (ClassReference)cp.getConstant(index);
		com.runtime.heap.Class klass = classRef.resolveClassReferece();
		if (klass.isInterface() || klass.isAbstract()) {
			throw new RuntimeException("java.lang.InstantiationError");
		}
		JavaObject ob = new JavaObject(klass);
		frame.getStack().push(new Value(new ReferenceType(), ob));
	}

}
