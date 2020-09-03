package fr.diginamic.offi.entity;

import fr.diginamic.offi.db.Table;

@Table(name = "CATEGORIE")
public class Categorie extends Entite {

	/**
	 * Constructeur
	 * 
	 * @param nom nom de la catégorie
	 */
	public Categorie(String nom) {
		super(nom);
	}

}
