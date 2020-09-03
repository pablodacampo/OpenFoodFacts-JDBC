package fr.diginamic.offi.dao;

import java.sql.Connection;

import fr.diginamic.offi.entity.Additif;

public class LinkProduitAdditifDao extends LinkDao<Additif> {

	/**
	 * Constructeur
	 * 
	 * @param conn connexion
	 */
	public LinkProduitAdditifDao(Connection conn) {
		super(conn, Additif.class, "COMPOSITION_ADD", "ID_ADD");
	}
}
