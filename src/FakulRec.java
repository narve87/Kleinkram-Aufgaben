import java.util.Scanner;
public class FakulRec {
	
	public static long fib(long c) {
		if (c==0) {
			return 0;
		}
		if (c==1) {
			return 1;
		}
	//	if (c==10) { return 55;}
		return (fib(c-1)+fib(c-2));
	}
	
	public static int fac(int a){
		if (a==1){
			return 1;
		}
		else {
			return a*fac(a-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long f=sc.nextLong();
		sc.close();
		//System.out.println(fac(f));
		long a=0;
		long b=1;
		long res=0;
		System.out.println(fib(f));
		while (f>1) {
			res=a+b;
			a=b;
			b=res;
			f--;
		}
		System.out.println(res);
	}

}