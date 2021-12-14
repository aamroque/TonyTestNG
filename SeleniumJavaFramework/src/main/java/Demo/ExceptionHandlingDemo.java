package Demo;

public class ExceptionHandlingDemo {

//	This is to Demo Exception Handling in Java
//  This is not dependent on any other class
	
	public static void main(String[] args) {
		
		try {
		System.out.println("Sample Exception Handling");
		int i = 1/0;
		System.out.println("Test Completed");
		}
		
		catch(Exception exp) {
			System.out.println("I am inside Catch Block");
			System.out.println("Message is : "+exp.getMessage());
			System.out.println("Cause is : "+exp.getCause());
			exp.printStackTrace();
		}
		
		finally {
			System.out.println("I am inside Finally Block");
			System.out.println("Test Completed");
		}
		
	}
	
}
//		public static void main(String[] args) {
//			try {
//				demo();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//		public static void demo() throws Exception {
//			System.out.println("Sample Exception Handling");
//			//If you want to throw an exception, use below sample syntax
//			//throw new ArithmeticException("not a valid operation");
//			int i = 1/0;
//			System.out.println("Test Completed");
//			
//	}
//}

	
