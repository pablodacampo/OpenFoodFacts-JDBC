package fr.diginamic.offi.manager;

import java.sql.Connection;

import fr.diginamic.offi.dao.LinkProduitAdditifDao;
import fr.diginamic.offi.entity.Additif;

public class LinkProduitAdditifService extends LinkService<Additif> {

	/**
	 * Constructeur
	 * 
	 * @param conn connexion à la base de données
	 */
	public LinkProduitAdditifService(Connection conn) {
		super(Additif.class, new LinkProduitAdditifDao(conn));
	}

}
