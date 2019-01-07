package com.runtime.heap;

import com.classfile.parse.constant.FieldOrMethod;

public abstract class Member extends AccessFlags {
	private String name;
	
	private String description;
	
	private Class klass;
	
	public Member(FieldOrMethod fieldOrMethod) {
		this.accessFlags = fieldOrMethod.getAccessFlags();
		this.name = fieldOrMethod.getName();
		this.description = fieldOrMethod.getDes();
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Class getKlass() {
		return klass;
	}
	
	public boolean isAccessibleTo(Class tclass) {
		if (isPublic() || klass == tclass) {
			return true;
		}
		if (isProtected()) {
			return tclass.isSubClassOf(klass) || klass.getPackageName().equals(tclass.getPackageName());
		}	
		if (!isPrivate()) {
			return klass.getPackageName().equals(tclass.getPackageName());
		}
		return false;	
	}
	
	
}
