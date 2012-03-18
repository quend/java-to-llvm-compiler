package backend.symboltable.objects;

import java.util.*;
import backend.symboltable.*;

public class Type {
	public static final int CHARACTER = 1;
	public static final int INTEGER = 2;
	public static final int FLOATING = 3;
	public static final int BOOL = 4;
	public static final int VOIDTYPE = 5;
	public static final int ERRORTYPE = 6;
 	public static final int NAME = 7;
	public static final int ARRAY = 8;
	public static final int REFERENCE = 90;
	public static final int PRODUCT = 91;
	public static final int CONSTRUCTOR = 92;
	public static final int METHOD = 93;

	static HashMap types = new HashMap();

	int tag;
	int width = 0;
	String code;

	protected Type(int t, int w, String c) {
		tag = t;
		width = w;
		if(c.equals("%struct.i8*")) code = "i8*";
		else code = c;
	}

	public int getWidth() {
		return width;
	}

	public String getCode() {
		return code;
	}

	public void putWidth(int w) {
		width = w;
		System.out.println("   UPDATED WIDTH: "+this+" (WIDTH: "+width+")");
	}

	public static void initTypes(){
		types.put(INTEGER+"", new Type(INTEGER, 4, "i32"));
		types.put(FLOATING+"", new Type(FLOATING, 4, "double"));
		types.put(CHARACTER+"", new Type(CHARACTER, 1, "i8"));
		types.put(BOOL+"", new Type(BOOL, 1, "i1"));
		types.put(VOIDTYPE+"", new Type(VOIDTYPE, 0, "void"));
		types.put(ERRORTYPE+"", new Type(ERRORTYPE, 0, "error"));
	}

	public static Type integer() {
		return (Type)types.get(""+INTEGER);
	}

	public boolean isInteger() {
		if (tag == INTEGER) return true;
		else return false;
	}

	public static Type floating() {
		return (Type)types.get(""+FLOATING);
	}

	public boolean isFloating() {
		if (tag == FLOATING) return true;
		else return false;
	}

	public static Type character() {
		return (Type)types.get(""+CHARACTER);
	}

	public boolean isCharacter() {
		if (tag == CHARACTER) return true;
		else return false;
	}

	public boolean isNumber() {
		if ((tag == INTEGER) || (tag == FLOATING) || (tag == CHARACTER)) return true;
		else return false;
	}

	public static Type max(Type t1, Type t2) {
		if (t1.tag > t2.tag) return t1;
		else return t2;
	}

	public static Type bool() {
		return (Type)types.get(""+BOOL);
	}

	public boolean isBool() {
		if (tag == BOOL) return true;
		else return false;
	}

	public static Type voidtype() {
		return (Type)types.get(""+VOIDTYPE);
	}

	public boolean isVoidtype() {
		if (tag == VOIDTYPE) return true;
		else return false;
	}

	public static Type errortype() {
		return (Type)types.get(""+ERRORTYPE);
	}

	public boolean isErrortype() {
		if (tag == ERRORTYPE) return true;
		else return false;
	}

	public static Array array(int size, Type base) {
		Array a = (Array)types.get(""+ARRAY+base);
		if(a != null) return a;
		a = new Array(size, base);
		types.put(a.toString(), a);
		return a;
	}

	public boolean isArray() {
		if (tag == ARRAY) return true;
		else return false;
	}

	public static Name putName(String name, String supername, Env e) {
		Name n = (Name)types.get(""+NAME+name);
		String code = name.equals("String")? "i8" : name;
		n = new Name(name, supername, e, code);
		types.put(n.toString(), n);
		return n; 
	}

	public static Name forwardName(String name, String lexeme) {
		Name n = (Name)types.get(""+NAME+name);
		if(n != null) return n;
		String code = name.equals("String")? "i8" : name;
		n = new Name(name, lexeme, code);
		types.put(n.toString(), n);
		return n; 
	}

	public boolean isName() {
		if (tag == NAME) return true;
		else return false;
	}

	public static Name getName(String name) {
		return (Name)types.get(""+NAME+name); 
	}

	public static Product product(Type left, Type right) {
		Product p = (Product)types.get(""+PRODUCT+left+right);
		if(p != null) return p;
		p = new Product(left, right);
		types.put(p.toString(), p);
		return p;
	}

	public static Constructor constructor(Type domain, Type range) {
		Constructor c = (Constructor)types.get(""+CONSTRUCTOR+domain+range);
		if(c != null) return c;
		c = new Constructor(domain, range);
		types.put(c.toString(), c);
		return c;
	}

	public boolean isConstructor() {
		if (tag == CONSTRUCTOR) return true;
		else return false;
	}

	public static Method method(Type domain, Type range) {
		Method m = (Method)types.get(""+METHOD+domain+range);
		if(m != null) return m;
		m = new Method(domain, range);
		types.put(m.toString(), m);
		return m;
	}

	public boolean isMethod() {
		if (tag == METHOD) return true;
		else return false;
	}

	public static Reference reference(Type referred) {
		Reference r = (Reference)types.get(""+REFERENCE+referred);
		if(r != null) return r;
		r = new Reference(referred);
		types.put(r.toString(), r);
		return r;
	}
	
	public boolean isReference() {
		if (tag == REFERENCE) return true;
		else return false;
	}

	public String toString(){
		return ""+tag;
	}

	protected String typeString(){
		String t = "";
		switch(tag) { case CHARACTER: case INTEGER: case FLOATING: case BOOL: case VOIDTYPE: case ERRORTYPE: t = code;
		}
		return t;
	}

	public static void printTypes(){
		TreeMap tm = new TreeMap(types);
		Set tMap = tm.entrySet();
		Iterator it = tMap.iterator();
		System.out.println("\nTypes: ");
		while(it.hasNext()) { Map.Entry entry = (Map.Entry)it.next();
					    String key = (String)entry.getKey();
					    Type value = (Type)entry.getValue();
					    System.out.println("      "+key+" = "+value.typeString());
		}		
	}
}
