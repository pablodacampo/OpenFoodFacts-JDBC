package fr.diginamic.offi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.diginamic.offi.entity.Entite;
import fr.diginamic.offi.entity.Produit;
import fr.diginamic.offi.exception.ExceptionTech;

public abstract class LinkDao<T extends Entite> extends EntiteDao<T> {

	/**
	 * PreparedStatement qui permet de stocker la requête permettant de retrouver un
	 * lien entre un produit et une entité en base de données
	 */
	protected PreparedStatement findLink;

	/**
	 * PreparedStatement qui permet de stocker la requête permettant d'insérer un
	 * lien entre un produit et une entité en base de données
	 */
	protected PreparedStatement insertionLink;

	/**
	 * Constructeur
	 * 
	 * @param conn         connexion
	 * @param classe       classe à traiter
	 * @param nomTableLien nom de la table de lien
	 * @param nomColonne   nom de la colonne
	 */
	public LinkDao(Connection conn, Class<T> classe, String nomTableLien, String nomColonne) {
		super(conn, classe);
		try {
			insertionLink = conn
					.prepareStatement("INSERT INTO " + nomTableLien + " (ID_PRD, " + nomColonne + ") VALUES (?,?)");
			findLink = conn
					.prepareStatement("SELECT * FROM " + nomTableLien + " WHERE ID_PRD=? AND " + nomColonne + "=?");
		} catch (SQLException e) {
			throw new ExceptionTech(e.getMessage());
		}
	}

	/**
	 * Insère un lien entre un produit et une entité
	 * 
	 * @param produit produit
	 * @param entite  entité
	 */
	public void insert(Produit produit, T entite) {
		try {
			insertionLink.setLong(1, produit.getId());
			insertionLink.setLong(2, entite.getId());
			insertionLink.executeUpdate();
		} catch (SQLException e) {
			throw new ExceptionTech(e.getMessage());
		}
	}

	/**
	 * Retourne true si le lien entre le produit et l'entité passés en paramètres
	 * existe, retourne false dans le cas contraire.
	 * 
	 * @param produit produit
	 * @param entite  entité
	 * @return boolean
	 */
	public final boolean exist(Produit produit, T entite) {

		ResultSet res = null;
		try {
			findLink.setLong(1, produit.getId());
			findLink.setLong(2, entite.getId());
			res = findLink.executeQuery();
			if (res.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			throw new ExceptionTech(e.getMessage());
		} finally {
			try {
				if (res != null) {
					res.close();
				}
			} catch (SQLException e) {
				throw new ExceptionTech("Impossible de fermer les ressources SQL.");
			}
		}
	}

}
