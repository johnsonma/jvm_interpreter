package com.runtime;

import java.util.Stack;

public class VMStack {
	
	private Stack<Frame> frames;
	
	public VMStack() {
		frames = new Stack<Frame>();
	}
	
	public Frame pop() {
		if (frames.size() == 0) {
			throw new RuntimeException("stack is empty");
		}
		return frames.pop();
	}
	
	
	public Frame top() {
		if (frames.size() == 0) {
			throw new RuntimeException("stack is empty");
		}
		return frames.peek();
	}
	
	public void Push(Frame frame) {
		frames.push(frame);
	}

}
