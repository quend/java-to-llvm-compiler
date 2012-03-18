package backend.symboltable.objects;

import java.util.*;
import backend.symboltable.*;

public class Name extends Type {

	static Name current;
	static Hashtable forwards = new Hashtable();

	String name;
	String supername;
	Env env;		

	protected Name(String n, String s, Env e, String code) {
		super(NAME, 0, code);
		name = n;
		supername = s;
		env = e;
		current = this;
		System.out.println("   NEW CLASS: "+this+" (NAME: "+name+", SUPER: "+supername+", ENV: e"+env.getCounter()+")");
	}

	protected Name(String n, String lexeme, String code) {
		super(NAME, 0, code);
		name = n;
		supername = null;
		env = null;
		forwards.put(n, lexeme);
		System.out.println("   FORWARD REFERENCE: "+this+" (NAME: "+name+", SUPER: "+supername+", ENV: e"+env+")");
	}

	public static Name getCurrentClass(){
		return current;
	}

	public static void putCurrentClass(Name c){
		current = c;
		String n = c.getName();
		String s = c.getSuper();
		Env e = c.getEnv();
		System.out.println("   CURRENT CLASS: "+c+" (NAME: "+n+", SUPER: "+s+", ENV: e"+e.getCounter()+")");
	}

	public static boolean isForward(String n){
		return (forwards.remove(n) != null);
	}

	public static Hashtable ForwardHashtable(){
		return forwards;
	}

	public boolean isSubclass(Name sup){
		Name c = this;
		while(c != null) if(c == sup) return true;
				     else { String s = c.getSuper();
						if(s == null) c = null;
						else c = (Name)Env.get(s, Env.getRoot()).getType();					  
				     }
		return false;
	}

	public Env getEnv(){
		return env;
	}

	public String getName(){
		return name;
	}

	public String getSuper(){
		return supername;
	}

	public String toString(){
		return ""+tag+name;
	}

	protected String typeString(){
		return name;
	}
}
