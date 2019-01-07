package com.runtime;

import java.util.ArrayList;
import java.util.List;

import com.vm.data.type.Value;

public class OperandStack {
	private final List<Value> stack = new ArrayList<>();
	
	private final int maxSlots;
	
	private int slots;
	
	public OperandStack(int maxSlots) {
		this.maxSlots = maxSlots;
	}
	
	public void push(Value value) {
		if (slots >= maxSlots) {
			throw new RuntimeException("exceed the max slots");
		}
		stack.add(value);
		slots += value.getType().getSize();
	}
	
	public Value pop() {
		Value value = stack.remove(stack.size() - 1);
		slots -= value.getType().getSize();
		return value;
	}
	
}
