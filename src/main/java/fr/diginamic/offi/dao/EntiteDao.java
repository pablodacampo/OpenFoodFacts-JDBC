package fr.diginamic.offi.dao;

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.diginamic.offi.db.Table;
import fr.diginamic.offi.entity.Entite;
import fr.diginamic.offi.exception.ExceptionTech;

public abstract class EntiteDao<T extends Entite> extends AbstractDao {

	/** Classe de l'entité */
	protected Class<T> classe;

	/**
	 * Constructeur
	 * 
	 * @param conn   connexion
	 * @param classe classe
	 */
	public EntiteDao(Connection conn, Class<T> classe) {
		super(conn);
		this.classe = classe;

		String nomTable = ((Table) classe.getAnnotation(Table.class)).name();

		try {
			insertion = conn.prepareStatement("INSERT INTO " + nomTable + " (NOM) VALUES (?)");
			find = conn.prepareStatement("SELECT * FROM " + nomTable + " WHERE NOM=?");
		} catch (SQLException e) {
			throw new ExceptionTech(e.getMessage());
		}
	}

	/**
	 * Insère une nouvelle entité en base de données
	 * 
	 * @param entite additif
	 */
	public void insert(T entite) {
		try {
			insertion.setString(1, entite.getNom());
			insertion.executeUpdate();
		} catch (SQLException e) {
			throw new ExceptionTech(e.getMessage());
		}
	}

	/**
	 * Extrait une entité de la base en fonction de son nom, ou retourne null si
	 * l'additif n'existe pas.
	 * 
	 * @param nom nom de l'additif
	 * @return Additif
	 */
	public T find(String nom) {

		ResultSet res = null;
		try {
			find.setString(1, nom);
			res = find.executeQuery();
			T entite = null;
			if (res.next()) {

				Constructor<T> constructor = classe.getConstructor(String.class);
				entite = constructor.newInstance(res.getString("nom"));
				entite.setId(res.getLong("id"));
			}
			return entite;
		} catch (SQLException | ReflectiveOperationException e) {
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
