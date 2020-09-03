package fr.diginamic.offi.manager;

import java.sql.Connection;

import fr.diginamic.offi.dao.LinkProduitIngredientDao;
import fr.diginamic.offi.entity.Ingredient;

public class LinkProduitIngredientService extends LinkService<Ingredient> {

	/**
	 * Constructeur
	 * 
	 * @param conn connexion à la base de données
	 */
	public LinkProduitIngredientService(Connection conn) {
		super(Ingredient.class, new LinkProduitIngredientDao(conn));
	}

}
