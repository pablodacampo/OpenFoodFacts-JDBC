package fr.diginamic.offi.dao;

import java.sql.Connection;

import fr.diginamic.offi.entity.Ingredient;

public class IngredientDao extends EntiteDao<Ingredient> {

	/**
	 * Constructeur
	 * 
	 * @param conn connexion
	 */
	public IngredientDao(Connection conn) {
		super(conn, Ingredient.class);
	}
}
