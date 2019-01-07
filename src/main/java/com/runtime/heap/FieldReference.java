package com.runtime.heap;

import com.classfile.parse.constant.FieldRefConstantInfo;

public class FieldReference extends MemberReference {
	
	private FieldMember field;

	public FieldReference(ConstantPool cp, FieldRefConstantInfo constantInfo) {
		super(cp, constantInfo);
		// TODO Auto-generated constructor stub
	}
	
	public FieldMember resolveFieldReference() throws IllegalAccessException, NoSuchFieldException {
		if (field == null) {
			Class belongClass = getBelongClass();
			Class referClass = resolveClassReferece();
			FieldMember field = lookupField(referClass, name, description);
			if (field == null) {
				throw new NoSuchFieldException();
			}
			if (!field.isAccessibleTo(belongClass)) {
				throw new IllegalAccessException();
			}
		}
		
		return field;
	}
	
	
	public FieldMember lookupField(Class klass, String name, String desc) {
		for (FieldMember field : klass.getFields()) {
			if (field.getName().equals(name) && field.getDescription().equals(desc)) {
				return field;
			}
		}
		
		for (Class intf : klass.getInterfaces()) {
			FieldMember field = lookupField(intf, name, desc);
			
			if (field != null) {
				return field;
			}
		}
		if (klass.getSuperClass() != null) {
			return lookupField(klass.getSuperClass(), name, desc);
		}
		return null;
	}

}
