package fr.diginamic.offi.dao;

import java.sql.Connection;

import fr.diginamic.offi.entity.Allergene;

public class LinkProduitAllergeneDao extends LinkDao<Allergene> {

	/**
	 * Constructeur
	 * 
	 * @param conn connexion
	 */
	public LinkProduitAllergeneDao(Connection conn) {
		super(conn, Allergene.class, "COMPOSITION_ALL", "ID_ALL");
	}
}
