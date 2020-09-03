package fr.diginamic.offi.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import fr.diginamic.offi.entity.Produit;
import fr.diginamic.offi.exception.ExceptionTech;

public class ProduitDao extends EntiteDao<Produit> {

	/**
	 * Constructeur
	 * 
	 * @param conn connexion
	 */
	public ProduitDao(Connection conn) {
		super(conn, Produit.class);

		try {
			insertion = conn
					.prepareStatement("INSERT INTO Produit (NOM, GRADE, ID_MRQ, ID_CAT, betaCarotene100g, calcium100g, "
							+ "energie100g, fer100g, fibres100g, graisse100g, iron100g, magnesium100g, "
							+ "presenceHuilePalme, proteines100g, sel100g, sucres100g, vitA100g, "
							+ "vitB1100g, vitB12100g, vitB2100g, vitB6100g, vitB9100g, vitC100g, "
							+ "vitD100g, vitE100g, vitK100g, vitPP100g) "
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		} catch (SQLException e) {
			throw new ExceptionTech(e.getMessage());
		}
	}

	/**
	 * Insère un produit en base de données
	 * 
	 * @param produit produit à insérer
	 */
	public void insert(Produit produit) {
		try {
			insertion.setString(1, produit.getNom());
			insertion.setString(2, produit.getGrade());
			insertion.setLong(3, produit.getMarque().getId());
			insertion.setLong(4, produit.getCategorie().getId());

			insertion.setObject(5, produit.getBetaCarotene100g(), Types.DOUBLE);
			insertion.setObject(6, produit.getCalcium100g(), Types.DOUBLE);
			insertion.setObject(7, produit.getEnergie100g(), Types.DOUBLE);
			insertion.setObject(8, produit.getFer100g(), Types.DOUBLE);
			insertion.setObject(9, produit.getFibres100g(), Types.DOUBLE);
			insertion.setObject(10, produit.getGraisse100g(), Types.DOUBLE);
			insertion.setObject(11, produit.getIron100g(), Types.DOUBLE);
			insertion.setObject(12, produit.getMagnesium100g(), Types.DOUBLE);
			insertion.setString(13, produit.getPresenceHuilePalme());
			insertion.setObject(14, produit.getProteines100g(), Types.DOUBLE);
			insertion.setObject(15, produit.getSel100g(), Types.DOUBLE);
			insertion.setObject(16, produit.getSucres100g(), Types.DOUBLE);
			insertion.setObject(17, produit.getVitA100g(), Types.DOUBLE);
			insertion.setObject(18, produit.getVitB1100g(), Types.DOUBLE);
			insertion.setObject(19, produit.getVitB12100g(), Types.DOUBLE);
			insertion.setObject(20, produit.getVitB2100g(), Types.DOUBLE);
			insertion.setObject(21, produit.getVitB6100g(), Types.DOUBLE);
			insertion.setObject(22, produit.getVitB9100g(), Types.DOUBLE);
			insertion.setObject(23, produit.getVitC100g(), Types.DOUBLE);
			insertion.setObject(24, produit.getVitD100g(), Types.DOUBLE);
			insertion.setObject(25, produit.getVitE100g(), Types.DOUBLE);
			insertion.setObject(26, produit.getVitK100g(), Types.DOUBLE);
			insertion.setObject(27, produit.getVitPP100g(), Types.DOUBLE);

			insertion.executeUpdate();
		} catch (SQLException e) {
			throw new ExceptionTech(e.getMessage());
		}
	}
}
