package com.runtime.heap;

import com.classfile.JavaClass;
import com.vm.data.type.Value;

public class Class extends AccessFlags {
	private String name;

	private String superClassName;

	private String[] interfaceNames;

	private ConstantPool cp;

	private FieldMember[] fields;

	private MethodMember[] methods;

	private ClassLoader loader;

	private Class superClass;

	private Class[] interfaces;

	private int instanceCount;

	private int staticCount;

	private Value[] staicVars;

	public Class(JavaClass jclass, ClassLoader loader) {
		this.loader = loader;
		this.accessFlags = jclass.getAccessFlags();
		this.name = jclass.getName();
		this.superClassName = jclass.getSuperClassName();
		this.interfaceNames = jclass.getInterfaceNames();
		this.cp = new ConstantPool(this, jclass.getConstantPool());
		fields = new FieldMember[fields.length];
		for (int i = 0; i < fields.length; i++) {
			fields[i] = new FieldMember(jclass.getFields()[i]);
		}
		for (int i = 0; i < methods.length; i++) {
			methods[i] = new MethodMember(jclass.getMethods()[i]);
		}
	}

	public void resolveSuperClass() {
		if (!name.equals("java/lang/Object")) {
			superClass = loader.loadClass(superClassName);
		}
	}

	public void resolveInterfaces() {
		if (interfaceNames.length > 0) {
			interfaces = new Class[interfaceNames.length];
			for (int i = 0; i < interfaceNames.length; i++) {
				interfaces[i] = loader.loadClass(interfaceNames[i]);
			}
		}
	}

	public FieldMember[] getFields() {
		return fields;
	}

	public String getName() {
		return name;
	}

	public ClassLoader getLoader() {
		return loader;
	}

	public boolean isAccessibleTo(Class other) {
		String otherName = other.getName();
		return isPublic()
				|| isSamePackage(name, otherName);
	}
	
	public Class getSuperClass() {
		return superClass;
	}

	public Class[] getInterfaces() {
		return interfaces;
	}
	
	public ConstantPool getConstantPool() {
		return cp;
	}
	
	public boolean isAssignableFrom(Class klass) {
		if (klass == this) {
			return true;
		}
		if (!isInterface()) {
			return isSubClassOf(klass);
		} else {
			return implementsInf(klass);
		}
	}
	
	public boolean isSubClassOf(Class klass) {
		for (Class c = superClass; c != null; c = c.superClass) {
			if (c == klass) {
				return true;
			}
		}
		return false;
	}
	
	public boolean implementsInf(Class klass) {
		for (Class c = this; c != null; c = c.superClass) {
			for (Class superInterface : c.interfaces) {
				if (superInterface == klass || superInterface.isSubInterfaceOf(klass)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isSubInterfaceOf(Class klass) {
		for (Class superInterface : interfaces) {
			if (superInterface == klass || superInterface.isSubInterfaceOf(klass)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isSamePackage(String name, String otherName) {
		return name.substring(name.lastIndexOf("/")).equals(
				otherName.substring(otherName.lastIndexOf("/")));
	}
	
	public String getPackageName() {
		return name.substring(name.lastIndexOf("/"));
	}

	public int getInstanceCount() {
		return instanceCount;
	}
	
	
}
