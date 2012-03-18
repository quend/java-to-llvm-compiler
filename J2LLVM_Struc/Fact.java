public class EntInt{

    int fact(int n) {
//	if(n < 3) return n;
//	else return n * fact(n - 1);
	return n > 2 ? n * fact(n -1) : n;
    }

    public void main(){
	int n, f;
	n = 0;
	while(n < 1 || n > 16) { printf ("Enter an integer greater than 0 and less than 17: ");	
		    			     scanf ("%d", &n);
	}
	f = fact(n);	
	printf("factorial(%d)= %d\n", n, f);
    } 
}
