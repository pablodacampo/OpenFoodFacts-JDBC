package fr.diginamic.offi.dao;

import java.sql.Connection;

import fr.diginamic.offi.entity.Additif;

public class AdditifDao extends EntiteDao<Additif> {

	/**
	 * Constructeur
	 * 
	 * @param conn connexion
	 */
	public AdditifDao(Connection conn) {
		super(conn, Additif.class);
	}
}
