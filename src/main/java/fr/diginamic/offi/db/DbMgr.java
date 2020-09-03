package fr.diginamic.offi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.diginamic.offi.config.Constantes;
import fr.diginamic.offi.exception.ExceptionTech;

public class DbMgr {

	/**
	 * Retourne la connexion
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(Constantes.CONF.getUrl(), Constantes.CONF.getUser(),
					Constantes.CONF.getPassword());
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new ExceptionTech(
					"Impossible de créer une connexion. Veuillez vérifier les paramètres de connexion dans le fichier de configuration.");
		}
		return conn;
	}

}
