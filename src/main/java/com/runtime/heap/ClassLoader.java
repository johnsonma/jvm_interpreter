package com.runtime.heap;

import java.util.HashMap;
import java.util.Map;

import com.classfile.ClassPath;
import com.classfile.ClassReader;
import com.classfile.JavaClass;

public class ClassLoader {
	private ClassPath classPath;
	private Map<String, Class> klassMap = new HashMap<>();
	
	public Class loadClass(String name) {
		Class klass = klassMap.get(name);
		if (klass != null) {
			return klass;
		}
		return loadNonArrayClass(name);
	}
	
	private Class loadNonArrayClass(String name) {
		byte[] data = classPath.readClass(name);
		return defineClass(data);
	}
	
	public Class defineClass(byte[] data) {
		JavaClass jclass = new ClassReader(data).parse();
		return new Class(jclass, this);
	}
	
	public void initStaticVars(Class klass) {
		FieldMember[] fields = klass.getFields();
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].isStatic() && fields[i].isFinal()) {
				
			}
		}
	}
	
	
	
	
	
}
