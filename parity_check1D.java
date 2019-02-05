	
	// Java program to find parity 
	// of an integerimport java.util.*; 
import java.lang.*; 
import java.io.*; 
import java.math.BigInteger;
public class parity_check1D
{
/* Function to get parity of number n. 
It returns 1 if n has odd parity, and returns 0 if n has even parity */
		static boolean getParity(int n) 
		{ 
			boolean parity = false; 
			while(n != 0) 
			{ 
				parity = !parity; 
				n = n & (n-1); 
			} 
			return parity; 
			
		} 
		public static void main (String[] args) 
		{ 
			int n = 4; 
			System.out.println("Parity of no " + n + " = " + 
							(getParity(n)? "odd": "even")); 
		} 
	} 

