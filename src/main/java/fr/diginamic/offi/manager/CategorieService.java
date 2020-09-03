package fr.diginamic.offi.manager;

import java.sql.Connection;

import fr.diginamic.offi.dao.CategorieDao;
import fr.diginamic.offi.entity.Categorie;

public class CategorieService extends EntiteService<Categorie> {

	/**
	 * Constructeur
	 * 
	 * @param conn connexion à la base de données
	 */
	public CategorieService(Connection conn) {
		super(Categorie.class, new CategorieDao(conn));
	}

}
