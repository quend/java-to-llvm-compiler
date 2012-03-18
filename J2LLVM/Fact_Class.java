public class Obj_Int{

    int n;

    public Obj_Int(int i)
   {
	n = i;
    }

    public int f() {
	return fact(n);
    }

    int fact(int n) {
	return n > 2 ? n * fact(n -1) : n;
    }

}

public class Test{
    public void main(){
	int n, f;
	Obj_Int t;
	n = 0;
	while(n < 1 || n > 16) { printf ("Enter a number between 1 and 10 ");	
		    			 scanf ("%d", &n);
	}
	t = new Obj_Int(n);
	f = t.f();	
	printf("factorial of %d : %d\n", n, f);
    } 
}
