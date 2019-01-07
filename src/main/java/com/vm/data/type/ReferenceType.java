package com.vm.data.type;

public class ReferenceType extends Type {

	public ReferenceType(int type, String signature) {
		super(type, signature);
		// TODO Auto-generated constructor stub
	}
	
	
	public ReferenceType() {
        super(Constants.T_OBJECT, "<null object>");
    }

}
