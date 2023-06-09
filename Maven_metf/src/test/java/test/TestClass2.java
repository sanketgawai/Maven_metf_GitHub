package test;

public class TestClass2 {

	public static void main(String[] args) {
		
		System.out.println("Start");
		
		int a =23;
		int b =2;
		int c =0;
			
		int d [] = {23,54,55};
		
		try {
			System.out.println("try");
			c= a/b;
			System.out.println(d[5]);
		}
		catch(ArithmeticException e){
			System.out.println("catch");
			System.out.println("Alternative code for Arithmetic Exception ");
			 
		}
		finally {
			System.out.println("finally");
			
		}
	
		//Normal Flow
		System.out.println(c);
		System.out.println("END");
		
		//3 stituation
		//Exception is not generated
		//try -> finally -> Nromal Flow
		
		//Exception is generated and get handled
		//try -> catch -> finally -> Normal Flow
		
		//Exception is generated but no handled
		//try -> finally ->-------


	}
	
	
	
}
