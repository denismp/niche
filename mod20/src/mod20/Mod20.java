/**
 * 
 */
package mod20;

/**
 * @author denisputnam
 *
 */
public class Mod20 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Mod20 myMore = new Mod20();
		// TODO Auto-generated method stub
////		if( myMore.more20( 2 ))
////			System.out.println( "2 is 1 or 2 more than twenty");
//		for( int i = 1; i <= 100; i++) {
//			if( myMore.more20(i) == true ) {
//				System.out.println( i + " is 1 or 2 more than 20.");
//			}
//		}
//		if( myMore.nearTen(12)) {
//			System.out.println( "12 is true");
//		}
//		if( myMore.nearTen(17) == false) {
//			System.out.println("17 is false");
//		}
//		if( myMore.nearTen(19) == true) {
//			System.out.println("19 is true");
//		}
		
		String[] test = {"a", "b", "a"};
		myMore.wordAppend(test);
	}
	
	public boolean more20(int n) {
		if( n % 20 == 1 )
			return true;
		if( n % 20 == 2 )
			return true;
		return false;		  
	}

	public boolean nearTen(int num) {
		if( num % 10 < 3 )
			return true;
		if( num % 10 >= 8 )
			return true;		
		return false;  
	}
	
	public String wordAppend(String[] strings) {
		String rVal = "";	
		return rVal;
	}
}
