package fr.diginamic.offi.entity;

import fr.diginamic.offi.db.Table;

@Table(name = "ALLERGENE")
public class Allergene extends Entite {

	/**
	 * Constructeur
	 * 
	 * @param nom nom de l'allergène
	 */
	public Allergene(String nom) {
		super(nom);
	}
}
