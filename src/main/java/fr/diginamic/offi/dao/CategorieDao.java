package fr.diginamic.offi.dao;

import java.sql.Connection;

import fr.diginamic.offi.entity.Categorie;

public class CategorieDao extends EntiteDao<Categorie> {

	/**
	 * Constructeur
	 * 
	 * @param conn connexion
	 */
	public CategorieDao(Connection conn) {
		super(conn, Categorie.class);
	}
}
