package fr.diginamic.offi.db;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface Table {

	/**
	 * Permet de valoriser l'attribut name de l'annotation
	 * 
	 * @return String
	 */
	String name();
}
