package com.runtime.heap;

import com.classfile.constant.Constants;

public abstract class AccessFlags {
	protected int accessFlags;

	public final boolean isPublic() {
		return (accessFlags & Constants.ACC_PUBLIC) != 0;
	}

	public final boolean isPrivate() {
		return (accessFlags & Constants.ACC_PRIVATE) != 0;
	}

	public final boolean isProtected() {
		return (accessFlags & Constants.ACC_PROTECTED) != 0;
	}

	public final boolean isStatic() {
		return (accessFlags & Constants.ACC_STATIC) != 0;
	}

	public final boolean isFinal() {
		return (accessFlags & Constants.ACC_FINAL) != 0;
	}

	public final boolean isSynchronized() {
		return (accessFlags & Constants.ACC_SYNCHRONIZED) != 0;
	}

	public final boolean isVolatile() {
		return (accessFlags & Constants.ACC_VOLATILE) != 0;
	}

	public final boolean isTransient() {
		return (accessFlags & Constants.ACC_TRANSIENT) != 0;
	}

	public final boolean isNative() {
		return (accessFlags & Constants.ACC_NATIVE) != 0;
	}

	public final boolean isInterface() {
		return (accessFlags & Constants.ACC_INTERFACE) != 0;
	}

	public final boolean isAbstract() {
		return (accessFlags & Constants.ACC_ABSTRACT) != 0;
	}

	public final boolean isStrictfp() {
		return (accessFlags & Constants.ACC_STRICT) != 0;
	}

	public final boolean isSynthetic() {
		return (accessFlags & Constants.ACC_SYNTHETIC) != 0;
	}

	public final boolean isAnnotation() {
		return (accessFlags & Constants.ACC_ANNOTATION) != 0;
	}

	public final boolean isEnum() {
		return (accessFlags & Constants.ACC_ENUM) != 0;
	}

}
