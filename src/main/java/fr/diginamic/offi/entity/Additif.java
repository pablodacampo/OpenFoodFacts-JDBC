package fr.diginamic.offi.entity;

import fr.diginamic.offi.db.Table;

@Table(name = "ADDITIF")
public class Additif extends Entite {

	/**
	 * Constructeur
	 * 
	 * @param nom nom de l'additif
	 */
	public Additif(String nom) {
		super(nom);
	}
}
