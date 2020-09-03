package fr.diginamic.offi.dao;

import java.sql.Connection;

import fr.diginamic.offi.entity.Allergene;

public class AllergeneDao extends EntiteDao<Allergene> {

	/**
	 * Constructeur
	 * 
	 * @param conn connexion
	 */
	public AllergeneDao(Connection conn) {
		super(conn, Allergene.class);
	}
}
