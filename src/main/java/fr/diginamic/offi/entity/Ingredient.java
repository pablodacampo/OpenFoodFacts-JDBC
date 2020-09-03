package fr.diginamic.offi.entity;

import fr.diginamic.offi.db.Table;

@Table(name = "INGREDIENT")
public class Ingredient extends Entite {

	/**
	 * Constructeur
	 * 
	 * @param nom nom de l'ingrédient
	 */
	public Ingredient(String nom) {
		super(nom);
	}
}
