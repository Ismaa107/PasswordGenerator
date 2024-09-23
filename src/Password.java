import java.util.Random;

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
	public Password (int length, boolean symbolUse) { // Constructor principal.
		
		this.length = length;
		this.password = generatePassword (length, symbolUse);
		
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
	// Método principal del programa que generará una contraseña de forma aleatoria entre 96 caracteres (letras minúsculas, mayúsculas, números y símbolos).
	public String generatePassword (int length, boolean symbolUse) {
		
		String letters = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ"; // 54 characters.
		String numbers = "0123456789"; // 10 characters.
		String symbols = "+-*/%=()[]{}<>\\!|\"@#$~&?'^`,;.:_"; // 32 characters.
		String characters = letters + numbers;
		
		int rng;
		
		Random random = new Random ();
		StringBuilder sb = new StringBuilder ();
		
		if (length < getDEFAULT_LENGTH ()) {
			
			length = getDEFAULT_LENGTH ();
			
		}
		
		if (symbolUse) {
			
			characters += symbols;
			
		}
		
		while (!isStrong (sb, symbolUse)) {
			
			sb = new StringBuilder ();
			
			for (int i = 0; i < length; i++) {
				
				rng = random.nextInt (characters.length ());
				sb.append (characters.charAt (rng));
				
			}
			
		}
		
		return sb.toString ();
		
	}
	
	// Método para conseguir que la contraseña sea más resistente a ataques de fuerza bruta.
	// En caso de que no se soliciten símbolos, que tenga 2 caracteres de cada tipo. En caso de que se soliciten símbolos, un caracter de cada tipo.
	public boolean isStrong (StringBuilder pass, boolean symbolUse) {
		
		char character;
		
		int upperCounter = 0;
		int lowerCounter = 0;
		int numCounter = 0;
		int symbolCounter = 0;
		
		for (int i = 0; i < pass.length (); i++) {
			
			character = pass.charAt (i);
			
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
		
		if (symbolUse) {
			
			if (upperCounter < 1 || lowerCounter < 1 || numCounter < 1 || symbolCounter < 1) {
				
				return false;
				
			}
			
		} else {
			
			if (upperCounter < 2 || lowerCounter < 2 || numCounter < 2) {
				
				return false;
				
			}
			
		}
		
		return true;
		
	}
	
}