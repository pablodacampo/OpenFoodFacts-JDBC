package fr.diginamic.offi.manager;

import java.sql.Connection;

import fr.diginamic.offi.dao.ProduitDao;
import fr.diginamic.offi.entity.Produit;

public class ProduitService extends EntiteService<Produit> {

	/**
	 * Constructeur
	 * 
	 * @param conn connexion à la base de données
	 */
	public ProduitService(Connection conn) {
		super(Produit.class, new ProduitDao(conn));
	}

}
