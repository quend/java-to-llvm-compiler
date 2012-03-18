package backend.symboltable;

import java.util.*;
import backend.symboltable.objects.*;

public class Symb {

	Type type;
	Name ownerClass;
	boolean pub = false;
	String locT;
	String locN;

	public Symb(Type t, Name c, boolean p){
		type = t;
		ownerClass = c;
		pub = p;
	}

	public Symb(Type t, Name c, boolean p, String lt, String ln){
		type = t;
		ownerClass = c;
		pub = p;
		locT = lt;
		locN = ln;
	}

	public Type getType(){
		return type;
	}

	public Name getOwner(){
		return ownerClass;
	}

	public String getLocT(){
		return locT;
	}

	public String getLocN(){
		return locN;
	}

	public String getLoc(){
		String s = locT+" "+locN;
		return s;
	}

	public void putLocT(String s){
		locT = s;
	}

	public void putLocN(String s){
		locN = s;
	}

	public boolean isPublic(){
		return pub;
	}

	public String toString(){
		return "("+type+", "+ownerClass+", "+pub+", "+getLoc()+")";
	}
}
