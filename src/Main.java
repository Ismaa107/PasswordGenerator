import java.util.InputMismatchException;
import java.util.Scanner;

/**@author
 * Isma
 */
public class Main {
	
	public static void main (String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		Password pass = new Password ();
		
		int length = 0;
		int type = 0;
		boolean valid = false;
		boolean valid2 = false;
		
		do {
			
			try {
				
				System.out.println ("Tipo de contraseña: [1] letras y números, [2] letras, números y símbolos. " +
						"/ Password type: [1] letters and numbers, [2] letters, numbers and symbols.");
				type = input.nextInt ();
				
				if (type == 1 || type == 2) {
					
					valid = true;
					
				}
				
				pass.validateNumber (type);
				
			} catch (InputMismatchException | InvalidNumberException e) {
				
				System.out.println ("Sólo se puede introducir 1 o 2. / Only 1 or 2 can be introduced.");
				input.nextLine ();
				
			}
			
		} while (!valid);
		
		do {
			
			try {
				
				System.out.println ("Longitud de contraseña, 8 por defecto. / Password length, 8 by default.");
				length = input.nextInt ();
				
				if (length > 0) {
					
					valid2 = true;
					
				}
				
			} catch (InputMismatchException e) {
				
				System.out.println ("Introduce un número");
				input.nextLine ();
				
			}
			
		} while (!valid2);
		
		switch (type) {
			
			case 1 -> pass = new Password (length, type);
			
			case 2 -> pass = new Password (length, type);
			
		}
		
		System.out.println (pass.getPassword ());
	
	}
	
}