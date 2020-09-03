package fr.diginamic.offi.manager;

import java.sql.Connection;

import fr.diginamic.offi.dao.LinkProduitAllergeneDao;
import fr.diginamic.offi.entity.Allergene;

public class LinkProduitAllergeneService extends LinkService<Allergene> {

	/**
	 * Constructeur
	 * 
	 * @param conn connexion à la base de données
	 */
	public LinkProduitAllergeneService(Connection conn) {
		super(Allergene.class, new LinkProduitAllergeneDao(conn));
	}

}
