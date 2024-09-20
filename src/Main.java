import java.util.Scanner;

/**@author
 * Isma
 */
public class Main {
	
	public static void main (String [] args) {
		
		Scanner input = new Scanner (System.in);
		
		int length = 0;
		boolean symbolUse = false;
		boolean validLength = false;
		boolean validSymbol = false;
		
		String userInput;
		Password pass;
		
		do {
			
			try {
				
				System.out.print ("Longitud de contraseña, 8 por defecto. / Password length, 8 by default: ");
				length = input.nextInt ();
				
				if (length > 0) {
					
					validLength = true;
					
				}
				
			} catch (NumberFormatException e) {
				
				System.out.println ("Introduce un número entero.");
				input.nextLine ();
				
			}
			
		} while (!validLength);
		
		input.nextLine ();
		
		do {
			
			try {
				
				System.out.print ("Añadir símbolos: [si / s] letras, números y símbolos, [no / n] letras y números. " +
						"/ Add symbols: [yes / y] letters, numbers and symbols, [no / n] letters and numbers: ");
				userInput = input.nextLine ().trim ().toLowerCase ();
				
				if (userInput.equals ("si") || userInput.equals ("s") || userInput.equals ("yes") || userInput.equals ("y")) {
					
					symbolUse = true;
					validSymbol = true;
					
				} else if (userInput.equals ("no") || userInput.equals ("n")) {
					
					validSymbol = true;
					
				}
					
			} catch (IllegalArgumentException e) {
				
				System.out.println (e.getMessage ());
				input.nextLine ();
				
			}
			
		} while (!validSymbol);
		
		pass = new Password (length, symbolUse);
		System.out.println (pass.getPassword ());
	
	}
	
}