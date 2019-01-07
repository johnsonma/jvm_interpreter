package com.vm.data.type;



public abstract class Type {
	
	protected int type;
	protected String signature;
	
	public static Type UNKNOWN = new Type(-1, "<unknown object>") {
	};
	
	public static final ReferenceType NULL = new ReferenceType() {
    };
    
    public static final BasicType VOID = new BasicType(Constants.T_VOID, "");
    public static final BasicType BOOLEAN = new BasicType(Constants.T_BOOLEAN, "");
    public static final BasicType INT = new BasicType(Constants.T_INT, "");
    public static final BasicType SHORT = new BasicType(Constants.T_SHORT, "");
    public static final BasicType BYTE = new BasicType(Constants.T_BYTE, "");
    public static final BasicType LONG = new BasicType(Constants.T_LONG, "");
    public static final BasicType DOUBLE = new BasicType(Constants.T_DOUBLE, "");
    public static final BasicType FLOAT = new BasicType(Constants.T_FLOAT, "");
    public static final BasicType CHAR = new BasicType(Constants.T_CHAR, "");
			
	protected Type(int type, String signature) {
		this.type = type;
		this.signature = signature;
	} 
	
	
	public int getSize() {
        switch (type) {
            case Constants.T_DOUBLE:
            case Constants.T_LONG:
                return 2;
            case Constants.T_VOID:
                return 0;
            default:
                return 1;
        }
    }

	
}
