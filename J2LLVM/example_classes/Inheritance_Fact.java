public class Number 
{
    float f;
    boolean b;

    public Number(float x)
    {
	f = x;
    }
}

public class Int extends Number {
    int n;

    public Int(int i)
   {
	super(3.5);
	n = i;
    }
}

public class Fact extends Int {
    int m;

    public Fact(int i){
	super(i);
	m = 2;
    }

    public int f() {
	return fact(n);
    }

    int fact(int n) {
	return n > 2 ? n * fact(n -1) : n;
    }
}

public class Inheritance_Fact 
{
    public void main(){
	int n, f;
	Fact t;
	n = 0;
	while(n < 1 || n > 16) 
	{ 
		printf ("Enter a number between 1 to 10 : ");	
	        scanf ("%d", &n);
	}
	t = new Fact(n);
	f = t.f();	
	printf("factorial of %d : %d\n", n, f);
    } 
}
