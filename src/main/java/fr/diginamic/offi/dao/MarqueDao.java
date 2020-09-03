package fr.diginamic.offi.dao;

import java.sql.Connection;

import fr.diginamic.offi.entity.Marque;

public class MarqueDao extends EntiteDao<Marque> {

	/**
	 * Constructeur
	 * 
	 * @param conn connexion
	 */
	public MarqueDao(Connection conn) {
		super(conn, Marque.class);
	}
}
