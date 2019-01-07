package com.classfile;

import com.classfile.constant.Constants;
import com.classfile.parse.attr.Attribute;
import com.classfile.parse.attr.CodeAttribute;
import com.classfile.parse.attr.ConstantValueAttibute;
import com.classfile.parse.attr.LineNumberTableAttribute;
import com.classfile.parse.attr.LocalVariableTableAttribute;
import com.classfile.parse.attr.SourceFileAttribute;
import com.classfile.parse.attr.StackMapTableAttribute;
import com.classfile.parse.constant.CfConstantPool;
import com.classfile.parse.constant.ClassConstantInfo;
import com.classfile.parse.constant.ConstantInfo;
import com.classfile.parse.constant.DoubleConstantInfo;
import com.classfile.parse.constant.Field;
import com.classfile.parse.constant.FieldRefConstantInfo;
import com.classfile.parse.constant.FloatConstantInfo;
import com.classfile.parse.constant.IntegerConstantInfo;
import com.classfile.parse.constant.InterfaceMethodConstantInfo;
import com.classfile.parse.constant.LongConstantInfo;
import com.classfile.parse.constant.Method;
import com.classfile.parse.constant.MethodRefConstantInfo;
import com.classfile.parse.constant.NameAndTypeConstantInfo;
import com.classfile.parse.constant.StringConstantInfo;
import com.classfile.parse.constant.Utf8ConstantInfo;

public class ClassReader {

	private byte[] bytes;

	int index = 0;

	private JavaClass klass;

	public ClassReader(byte[] bytes) {
		this.bytes = bytes;
		klass = new JavaClass();
	}

	public JavaClass parse() {
		readMagic();
		readVersion();
		readConstantPool();
		readAccessFlags();
		readThisClass();
		readSuperClass();
		readInterface();
		readFields();
		readMethods();
		readAttributes();
		return klass;
	}

	private void readAccessFlags() {
		klass.setAccessFlags(readUnsignedShort());
	}

	private void readThisClass() {
		klass.setThisClass(readUnsignedShort());
	}

	private void readSuperClass() {
		klass.setSuperClass(readUnsignedShort());
	}

	private void readInterface() {
		int count = readUnsignedShort();
		klass.setInterfaceCount(count);
		for (int i = 0; i < count; i++) {
			klass.setInterface(i, readUnsignedShort());
		}
	}

	private Attribute readAttribute() {
		int attrNameIndex = readUnsignedShort();
		int attrLen = readInt();
		byte tag = Constants.ATTR_UNKNOWN;

		Utf8ConstantInfo c = (Utf8ConstantInfo) klass.getConstantPool().getConstant(
				attrNameIndex, Constants.CONSTANT_UTF8);

		for (byte i = 0; i < Constants.KNOWN_ATTRIBUTES; i++) {
			if (c.getValue().equals(Constants.ATTRIBUTE_NAMES[i])) {
				tag = i;
				break;
			}
		}

		switch (tag) {
		case Constants.ATTR_SOURCE_FILE:
			int sourceFileIndex = readUnsignedShort();
			SourceFileAttribute sourceAttr = new SourceFileAttribute(attrNameIndex, attrLen, sourceFileIndex);
			return sourceAttr;
		case Constants.ATTR_CONSTANT_VALUE:
			int constantValueIndex = readUnsignedShort();
			ConstantValueAttibute constantAttr = new ConstantValueAttibute(attrNameIndex, attrLen, constantValueIndex);
			return constantAttr;
		case Constants.ATTR_CODE:
			CodeAttribute codeAttr = new CodeAttribute(attrNameIndex, attrLen);
			int maxStack = readUnsignedShort();
			int maxLocals = readUnsignedShort();
			int codeLen = readInt();
			byte[] code = readBytes(codeLen);
			int exTableLen = readUnsignedShort();
			codeAttr.setMaxStack(maxStack);
			codeAttr.setMaxLocals(maxLocals);
			codeAttr.setCodeLength(codeLen);
			codeAttr.setCode(code);
			codeAttr.setExceptionTableLength(exTableLen);
			
			for (int i = 0; i < exTableLen; i++) {
				int startPc = readUnsignedShort();
				int endPc = readUnsignedShort();
				int handlerPc = readUnsignedShort();
				int catchType = readUnsignedShort();
				codeAttr.setExceptionTable(i, startPc, endPc, handlerPc, catchType);
			}
			
			int attrCount = readUnsignedShort();
			codeAttr.setAttributeCount(attrCount);
			for (int i = 0; i < attrCount; i++) {
				Attribute subAtrr = readAttribute();
				codeAttr.setAttribute(i, subAtrr);
			}
			return codeAttr;
		case Constants.ATTR_STACK_MAP_TABLE:
			StackMapTableAttribute smtAttr = new StackMapTableAttribute(attrNameIndex, attrLen);
			skipBytes(attrLen);
			return smtAttr;
		case Constants.ATTR_LINE_NUMBER_TABLE:
			LineNumberTableAttribute lntAttr = new LineNumberTableAttribute(attrNameIndex, attrLen);
			int lineNumberTableLen = readUnsignedShort();
			lntAttr.setTableLength(lineNumberTableLen);
			for (int i = 0; i < lineNumberTableLen; i++) {
				int startPc = readUnsignedShort();
				int ln = readUnsignedShort();
				lntAttr.setTable(i, startPc, ln);
			}
			return lntAttr;
		case Constants.ATTR_LOCAL_VARIABLE_TABLE:
			LocalVariableTableAttribute lvtAttr = new LocalVariableTableAttribute(attrNameIndex, attrLen);
			int localVariableTableLen = readUnsignedShort();
			lvtAttr.setTableLength(localVariableTableLen);
			for (int i = 0; i < localVariableTableLen; i++) {
				int startPc = readUnsignedShort();
				int length = readUnsignedShort();
				int nameIndex = readUnsignedShort();
				int desIndex = readUnsignedShort();
				int lvtIndex = readUnsignedShort();
				lvtAttr.setTable(i, startPc, length, nameIndex, desIndex, lvtIndex);
			}
			return lvtAttr;
		default:
			break;
		}

		return null;
	}

	private Field readField() {
		int accessFlags = readUnsignedShort();
		int nameIndex = readUnsignedShort();
		int desIndex = readUnsignedShort();
		int attrCount = readUnsignedShort();
		Field field = new Field(accessFlags, nameIndex, desIndex, attrCount, klass.getConstantPool());
		for (int i = 0; i < attrCount; i++) {
			Attribute attr = readAttribute();
			field.setAttribute(i, attr);
		}
		return field;
	}
	
	private Method readMethod() {
		int accessFlags = readUnsignedShort();
		int nameIndex = readUnsignedShort();
		int desIndex = readUnsignedShort();
		int attrCount = readUnsignedShort();
		Method method = new Method(accessFlags, nameIndex, desIndex, attrCount, klass.getConstantPool());
		for (int i = 0; i < attrCount; i++) {
			Attribute attr = readAttribute();
			method.setAttribute(i, attr);
		}
		return method;
	}
	
	private void readAttributes() {
		int attrCount = readUnsignedShort();
		klass.setAttrCount(attrCount);
		for (int i = 0; i < attrCount; i++) {
			klass.setAttr(i, readAttribute());
		}
	}

	private void readFields() {
		int count = readUnsignedShort();
		klass.setFieldCount(count);
		for (int i = 0; i < count; i++) {
			klass.setField(i, readField());
		}
	}
	
	private void readMethods() {
		int count = readUnsignedShort();
		klass.setMethodCount(count);
		for (int i = 0; i < count; i++) {
			klass.setMethod(i, readMethod());
		}
	}
	
	
	
	
	
	

	private void readMagic() {
		int magic = readInt();
		if (magic != 0xCAFEBABE) {
			throw new RuntimeException("magic number is not right");
		}
		klass.setMagic(magic);
	}

	private void readVersion() {
		int minor = readUnsignedShort();
		int major = readUnsignedShort();
		klass.setMinor(minor);
		klass.setMajar(major);
	}

	private void readConstantPool() {
		int constantPoolCount = readUnsignedShort();
		CfConstantPool pool = new CfConstantPool(constantPoolCount);
		klass.setConstantPool(pool);

		for (int i = 1; i < constantPoolCount; i++) {
			byte tag = readByte();
			if (tag == Constants.CONSTANT_CLASS) {
				int nameIndex = readUnsignedShort();
				ConstantInfo classContant = new ClassConstantInfo(nameIndex, pool); 
				pool.setConstant(i, classContant);
			} else if (tag == Constants.CONSTANT_UTF8) {
				int len = readUnsignedShort();
				char[] buf = new char[len];
				String value = readUtf8(len, buf);
				ConstantInfo utf8Constant = new Utf8ConstantInfo(value, pool);
				pool.setConstant(i, utf8Constant);
			} else if (tag == Constants.CONSTANT_INTEGER) {
				int value = readInt();
				ConstantInfo integerConstant = new IntegerConstantInfo(value, pool);
				pool.setConstant(i, integerConstant);
			} else if (tag == Constants.CONSTANT_LONG) {
				long value = readLong();
				ConstantInfo longConstant = new LongConstantInfo(value, pool);
				pool.setConstant(i, longConstant);
				i++;
			} else if (tag == Constants.CONSTANT_FLOAT) {
				int value = readInt();
				ConstantInfo floatConstant = new FloatConstantInfo(
						Float.intBitsToFloat(value), pool);
				pool.setConstant(i, floatConstant);
			} else if (tag == Constants.CONSTANT_DOUBLE) {
				long value = readLong();
				ConstantInfo doubleConstant = new DoubleConstantInfo(
						Double.longBitsToDouble(value), pool);
				pool.setConstant(i, doubleConstant);
				i++;
			} else if (tag == Constants.CONSTANT_FIELD_REF) {
				int classIndex = readUnsignedShort();
				int nameAndTypeIndex = readUnsignedShort();
				ConstantInfo ref = new FieldRefConstantInfo(classIndex,
						nameAndTypeIndex, pool);
				pool.setConstant(i, ref);
			} else if (tag == Constants.CONSTANT_METHOD_REF) {
				int classIndex = readUnsignedShort();
				int nameAndTypeIndex = readUnsignedShort();
				ConstantInfo ref = new MethodRefConstantInfo(classIndex,
						nameAndTypeIndex, pool);
				pool.setConstant(i, ref);
			} else if (tag == Constants.CONSTANT_INTERFACE_METHOD_REF) {
				int classIndex = readUnsignedShort();
				int nameAndTypeIndex = readUnsignedShort();
				ConstantInfo ref = new InterfaceMethodConstantInfo(classIndex,
						nameAndTypeIndex, pool);
				pool.setConstant(i, ref);
			} else if (tag == Constants.CONSTANT_STRING) {
				int stringIndex = readUnsignedShort();
				ConstantInfo stringConstant = new StringConstantInfo(stringIndex, pool);
				pool.setConstant(i, stringConstant);
			} else if (tag == Constants.CONSTANT_NAME_AND_TYPE) {
				int nameIndex = readUnsignedShort();
				int desIndex = readUnsignedShort();
				ConstantInfo ntConstant = new NameAndTypeConstantInfo(nameIndex,
						desIndex, pool);
				pool.setConstant(i, ntConstant);
			}
		}
	}

	public String readUtf8(int len, char[] buf) {
		int endIndex = index + len;
		int strlen = 0;
		int c;
		int st = 0;
		char cc = 0;
		while (index < endIndex) {
			c = bytes[index++];
			switch (st) {
			case 0:
				c = c & 0xff;
				// 0xxxxxxx
				if (c < 0x80) {
					buf[strlen++] = (char) c;
				}
				// 110x xxxx 10xx xxxx
				else if (c < 0xE0 && c > 0xBF) {
					cc = (char) (c & 0x1F);
					st = 1;
				} else {
					// 1110 xxxx 10xx xxxx 10xx xxxx
					cc = (char) (c & 0x0F);
					st = 2;
				}
				break;
			case 1:
				buf[strlen++] = (char) ((cc << 6) | (c & 0x3F));
				st = 0;
				break;
			case 2:
				cc = (char) ((cc << 6) | (c & 0x3F));
				st = 1;
				break;

			}
		}
		return new String(buf, 0, len);
	}
	
	public void skipBytes(int length) {
		index += length;
	}

	public byte readByte() {
		return bytes[index++];
	}

	public short readShort() {
		return (short) (((bytes[index++] & 0xFF) << 8) | ((bytes[index++] & 0xFF)));
	}

	public int readUnsignedShort() {
		return ((bytes[index++] & 0xFF) << 8) | ((bytes[index++] & 0xFF));
	}
	
	public byte[] readBytes(int length) {
		byte[] val = new byte[length];
		for (int i = 0; i < length; i++) {
			val[i] = bytes[index++];
		}
		return val;
	}

	public int readInt() {
		return ((bytes[index++] & 0xFF) << 24)
				| ((bytes[index++] & 0xFF) << 16)
				| ((bytes[index++] & 0xFF)) << 8 | ((bytes[index++] & 0xFF));
	}

	public long readLong() {
		long l0 = readInt();
		long l1 = readInt();
		return l0 << 32 | l1;
	}

	public long readLong1() {
		return ((long) (bytes[index++] & 0xFF) << 56)
				| ((long) (bytes[index++] & 0xFF) << 48)
				| ((long) (bytes[index++] & 0xFF) << 32)
				| ((long) (bytes[index++] & 0xFF) << 32)
				| ((long) (bytes[index++] & 0xFF) << 24)
				| ((long) (bytes[index++] & 0xFF) << 16)
				| ((long) (bytes[index++] & 0xFF) << 8)
				| ((long) (bytes[index++] & 0xFF));
	}

	public int readInt1() {
		return ((bytes[index++] & 0xFF) << 24)
				| ((bytes[index++] & 0xFF) << 16)
				| ((bytes[index++] & 0xFF) << 8) | (bytes[index++] & 0xFF);
	}

}
