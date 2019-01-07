package com.classfile.constant;

public class Constants {

	public final static short ACC_PUBLIC = 0x0001;

	/**
	 * One of the access flags for fields, methods, or classes.
	 * 
	 * @see #ACC_PUBLIC
	 */
	public final static short ACC_PRIVATE = 0x0002;

	/**
	 * One of the access flags for fields, methods, or classes.
	 * 
	 * @see #ACC_PUBLIC
	 */
	public final static short ACC_PROTECTED = 0x0004;

	/**
	 * One of the access flags for fields, methods, or classes.
	 * 
	 * @see #ACC_PUBLIC
	 */
	public final static short ACC_STATIC = 0x0008;

	/**
	 * One of the access flags for fields, methods, or classes.
	 * 
	 * @see #ACC_PUBLIC
	 */
	public final static short ACC_FINAL = 0x0010;

	/**
	 * One of the access flags for fields, methods, or classes.
	 * 
	 * @see #ACC_PUBLIC
	 */
	public final static short ACC_SYNCHRONIZED = 0x0020;

	/**
	 * One of the access flags for fields, methods, or classes.
	 * 
	 * @see #ACC_PUBLIC
	 */
	public final static short ACC_VOLATILE = 0x0040;

	/**
	 * One of the access flags for fields, methods, or classes.
	 * 
	 * @see #ACC_PUBLIC
	 */
	public final static short ACC_BRIDGE = 0x0040;

	/**
	 * One of the access flags for fields, methods, or classes.
	 * 
	 * @see #ACC_PUBLIC
	 */
	public final static short ACC_TRANSIENT = 0x0080;

	/**
	 * One of the access flags for fields, methods, or classes.
	 * 
	 * @see #ACC_PUBLIC
	 */
	public final static short ACC_VARARGS = 0x0080;

	/**
	 * One of the access flags for fields, methods, or classes.
	 * 
	 * @see #ACC_PUBLIC
	 */
	public final static short ACC_NATIVE = 0x0100;

	/**
	 * One of the access flags for fields, methods, or classes.
	 * 
	 * @see #ACC_PUBLIC
	 */
	public final static short ACC_INTERFACE = 0x0200;

	/**
	 * One of the access flags for fields, methods, or classes.
	 * 
	 * @see #ACC_PUBLIC
	 */
	public final static short ACC_ABSTRACT = 0x0400;

	/**
	 * One of the access flags for fields, methods, or classes.
	 * 
	 * @see #ACC_PUBLIC
	 */
	public final static short ACC_STRICT = 0x0800;

	/**
	 * One of the access flags for fields, methods, or classes.
	 * 
	 * @see #ACC_PUBLIC
	 */
	public final static short ACC_SYNTHETIC = 0x1000;

	/**
	 * One of the access flags for fields, methods, or classes.
	 * 
	 * @see #ACC_PUBLIC
	 */
	public final static short ACC_ANNOTATION = 0x2000;

	/**
	 * One of the access flags for fields, methods, or classes.
	 * 
	 * @see #ACC_PUBLIC
	 */
	public final static short ACC_ENUM = 0x4000;

	/**
	 * One of the access flags for fields, methods, or classes.
	 * 
	 * @see #ACC_PUBLIC
	 */
	public final static short ACC_MANDATED = (short) 0x8000;

	// Applies to classes compiled by new compilers only
	/**
	 * One of the access flags for fields, methods, or classes.
	 * 
	 * @see #ACC_PUBLIC
	 */
	public final static short ACC_SUPER = 0x0020;

	/**
	 * One of the access flags for fields, methods, or classes.
	 * 
	 * @see #ACC_PUBLIC
	 */
	public final static short MAX_ACC_FLAG = ACC_ENUM;

	public static byte CONSTANT_UTF8 = 1;
	public static byte CONSTANT_INTEGER = 3;
	public static byte CONSTANT_FLOAT = 4;
	public static byte CONSTANT_LONG = 5;
	public static byte CONSTANT_DOUBLE = 6;
	public static byte CONSTANT_CLASS = 7;
	public static byte CONSTANT_STRING = 8;
	public static byte CONSTANT_FIELD_REF = 9;
	public static byte CONSTANT_METHOD_REF = 10;
	public static byte CONSTANT_INTERFACE_METHOD_REF = 11;
	public static byte CONSTANT_NAME_AND_TYPE = 12;
	public static byte CONSTANT_METHOD_HANDLE = 15;
	public static byte CONSTANT_METHOD_TYPE = 16;
	public static byte CONSTANT_INVOKE_DYNAMIC = 18;

	public static final String[] ATTRIBUTE_NAMES = { "SourceFile",
			"ConstantValue", "Code", "Exceptions", "LineNumberTable",
			"LocalVariableTable", "InnerClasses", "Synthetic", "Deprecated",
			"PMGClass", "Signature", "StackMap", "RuntimeVisibleAnnotations",
			"RuntimeInvisibleAnnotations",
			"RuntimeVisibleParameterAnnotations",
			"RuntimeInvisibleParameterAnnotations", "AnnotationDefault",
			"LocalVariableTypeTable", "EnclosingMethod", "StackMapTable",
			"BootstrapMethods", "MethodParameters" };

	public static final int KNOWN_ATTRIBUTES = 22;

	public static final byte ATTR_UNKNOWN = -1;
	public static final byte ATTR_SOURCE_FILE = 0;
	public static final byte ATTR_CONSTANT_VALUE = 1;
	public static final byte ATTR_CODE = 2;
	public static final byte ATTR_EXCEPTIONS = 3;
	public static final byte ATTR_LINE_NUMBER_TABLE = 4;
	public static final byte ATTR_LOCAL_VARIABLE_TABLE = 5;
	public static final byte ATTR_INNER_CLASSES = 6;
	public static final byte ATTR_SYNTHETIC = 7;
	public static final byte ATTR_DEPRECATED = 8;
	public static final byte ATTR_PMG = 9;
	public static final byte ATTR_SIGNATURE = 10;
	public static final byte ATTR_STACK_MAP = 11;
	public static final byte ATTR_RUNTIME_VISIBLE_ANNOTATIONS = 12;
	public static final byte ATTR_RUNTIME_INVISIBLE_ANNOTATIONS = 13;
	public static final byte ATTR_RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS = 14;
	public static final byte ATTR_RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS = 15;
	public static final byte ATTR_ANNOTATION_DEFAULT = 16;
	public static final byte ATTR_LOCAL_VARIABLE_TYPE_TABLE = 17;
	public static final byte ATTR_ENCLOSING_METHOD = 18;
	public static final byte ATTR_STACK_MAP_TABLE = 19;
	public static final byte ATTR_BOOTSTRAP_METHODS = 20;
	public static final byte ATTR_METHOD_PARAMETERS = 21;

}
