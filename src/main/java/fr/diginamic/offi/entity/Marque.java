package fr.diginamic.offi.entity;

import fr.diginamic.offi.db.Table;

@Table(name = "MARQUE")
public class Marque extends Entite {

	/**
	 * Constructeur
	 * 
	 * @param nom nom de la marque
	 */
	public Marque(String nom) {
		super(nom);
	}
}
