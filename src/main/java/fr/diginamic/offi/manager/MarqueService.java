package fr.diginamic.offi.manager;

import java.sql.Connection;

import fr.diginamic.offi.dao.MarqueDao;
import fr.diginamic.offi.entity.Marque;

public class MarqueService extends EntiteService<Marque> {

	/**
	 * Constructeur
	 * 
	 * @param conn connexion à la base de données
	 */
	public MarqueService(Connection conn) {
		super(Marque.class, new MarqueDao(conn));
	}

}
