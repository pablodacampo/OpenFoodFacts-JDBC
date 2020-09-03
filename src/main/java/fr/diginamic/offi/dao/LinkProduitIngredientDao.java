package fr.diginamic.offi.dao;

import java.sql.Connection;

import fr.diginamic.offi.entity.Ingredient;

public class LinkProduitIngredientDao extends LinkDao<Ingredient> {

	/**
	 * Constructeur
	 * 
	 * @param conn connexion
	 */
	public LinkProduitIngredientDao(Connection conn) {
		super(conn, Ingredient.class, "COMPOSITION_ING", "ID_ING");
	}
}
