package com.runtime.heap;

public abstract class SymbolReference implements RTConstant {
	protected ConstantPool cp;
	protected String klassName;
	protected Class klass;

	public SymbolReference() {

	}

	public SymbolReference(ConstantPool cp, String klassName) {
		this.cp = cp;
		this.klassName = klassName;
	}
	
	protected Class getBelongClass() {
		return cp.getKlass();
	}

	public Class resolveClassReferece() {
		if (klass == null) {
			Class belongClass = getBelongClass();
			Class referClass = belongClass.getLoader().loadClass(klassName);
			if (!referClass.isAccessibleTo(belongClass)) {
				throw new RuntimeException("java.lang.IllegalAccessException");
			}
			this.klass = referClass;
		}
		return klass;
	}

}
