package fr.diginamic.offi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AbstractDao {

	/** conn */
	protected Connection conn;

	/**
	 * PreparedStatement qui permet de gérer les requêtes d'insertion des DAO filles
	 */
	protected PreparedStatement insertion;

	/**
	 * PreparedStatement qui permet de gérer les requêtes d'extraction des DAO
	 * filles
	 */
	protected PreparedStatement find;

	/**
	 * Constructeur
	 * 
	 * @param conn connexion
	 */
	public AbstractDao(Connection conn) {
		super();
		this.conn = conn;
	}
}
