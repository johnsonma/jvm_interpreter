package com.runtime;

import com.runtime.heap.MethodMember;


public class Frame {
	private final LocalVariables locals;
	
	private final OperandStack stack;
	
	private Thread thread;
	
	private MethodMember method;
	
	
	public LocalVariables getLocals() {
		return locals;
	}


	public OperandStack getStack() {
		return stack;
	}


	public Frame(LocalVariables locals, OperandStack stack){
        this.locals = locals;
        this.stack = stack;
    }


	public Thread getThread() {
		return thread;
	}


	public MethodMember getMethod() {
		return method;
	}
	
	
	
}
