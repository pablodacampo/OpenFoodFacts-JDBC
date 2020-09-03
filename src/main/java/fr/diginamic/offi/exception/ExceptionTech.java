package fr.diginamic.offi.exception;

public class ExceptionTech extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 8941017661900975583L;

	/**
	 * Constructeur
	 * 
	 * @param message message associé à l'exception
	 */
	public ExceptionTech(String message) {
		super(message);
	}
}
