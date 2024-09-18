/**
 *
 * @author Isma
 */
public class Password {
	
	// Constantes.
	private final int DEFAULT_LENGTH = 8; // Valor por defecto de la longitud de la contraseña.
	
	// Variables.
	private int length; // Variable con la longitud.
	private String password; // Variable con la contraseña.
	
	// Constructores.
	public Password (int length, int type) { // Constructor principal.
		
		this.length = length;
		
		if (type == 1) {
			
			this.password = generatePassword1 (length);
			
		} else {
			
			this.password = generatePassword2 (length);
			
		}
		
	}
	
	public Password () { // Constructor vacío usando la variable de la longitud por defecto.
		
		this.length = this.DEFAULT_LENGTH;
	
	}
	
	// Getters y Setters.
	public int getDEFAULT_LENGTH () {
		
		return DEFAULT_LENGTH;
		
	}
	
	public int getLength () {
		
		return length;
		
	}
	
	public void setLength (int length) {
		
		this.length = length;
		
	}
	
	public String getPassword () {
		
		return password;
		
	}
	
	public void setPassword (String password) {
		
		this.password = password;
		
	}
	
	// Métodos.
	public void validateNumber (int number) throws InvalidNumberException {
		
		if (number != 1 && number != 2) {
			
			throw new InvalidNumberException ("Sólo se puede introducir 1 o 2. / Only 1 or 2 can be introduced...");
			
		}
		
	}
	
	public String generatePassword1 (int length) {
		
		/*Upper case letters: A to Z (26 characters)
    	Lower case letters: a to z (26 characters)
    	Numbers: 0 to 9 (10 characters)
    	Symbols: (space) ! " # $ % & ' ( ) * + , - . / : ; < = > ? @ [ \ ] ^ _` { | } ~ (33 characters)*/
		
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String pass = "";
		
		if (length < getDEFAULT_LENGTH ()) {
			
			length = getDEFAULT_LENGTH ();
			
		}
		
		while (!isStrong1 (pass)) {
			
			pass = "";
			
			for (int i = 0; i < length; i++) {
				
				pass += characters.charAt ((int) (Math.random () * characters.length ())) ;
				
			}
			
		}
		
		return pass;
	
	}
	
	public String generatePassword2 (int length) {
		
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
		String pass = "";
		
		if (length < getDEFAULT_LENGTH ()) {
			
			length = getDEFAULT_LENGTH ();
			
		}
		
		while (!isStrong2 (pass)) {
			
			pass = "";
			
			for (int i = 0; i < length; i++) {
				
				pass += characters.charAt ((int) (Math.random () * characters.length ())) ;
				
			}
			
		}
		
		return pass;
		
	}
	
	public boolean isStrong1 (String pass) {
		
		int upperCounter = 0;
		int lowerCounter = 0;
		int numCounter = 0;
		
		for (int i = 0; i < pass.length (); i++) {
			
			char character = pass.charAt (i);
		
			if (Character.isUpperCase (character)) {
				
				upperCounter++;
				
			} else if (Character.isLowerCase (character)) {
				
				lowerCounter++;
				
			} else {
				
				numCounter++;
				
			}
		
		}
		
		if (upperCounter < 2 || lowerCounter < 2 || numCounter < 2) {
			
			return false;
			
		}
		
		return true;
		
	}
	
	public boolean isStrong2 (String pass) {
		
		int upperCounter = 0;
		int lowerCounter = 0;
		int numCounter = 0;
		int symbolCounter = 0;
		
		for (int i = 0; i < pass.length (); i++) {
			
			char character = pass.charAt (i);
			
			if (Character.isUpperCase (character)) {
				
				upperCounter++;
				
			} else if (Character.isLowerCase (character)) {
				
				lowerCounter++;
				
			} else if (Character.isDigit (character)) {
				
				numCounter++;
				
			} else {
				
				symbolCounter++;
				
			}
			
		}
		
		if (upperCounter < 1 || lowerCounter < 1 || numCounter < 1 || symbolCounter < 1) {
			
			return false;
			
		}
		
		return true;
		
	}
	
}