package fr.diginamic.offi.manager;

import java.sql.Connection;
import java.sql.SQLException;

import fr.diginamic.offi.db.DbMgr;
import fr.diginamic.offi.entity.Produit;
import fr.diginamic.offi.exception.ExceptionTech;

public class ProduitManager {

	/** Connexion à la base de données */
	private Connection conn;
	/** categorieService */
	private CategorieService categorieService;
	/** marqueService */
	private MarqueService marqueService;
	/** produitService */
	private ProduitService produitService;

	/** linkProduitIngredientService */
	private LinkProduitIngredientService linkProduitIngredientService;
	/** linkProduitAdditifService */
	private LinkProduitAdditifService linkProduitAdditifService;
	/** linkProduitAllergeneService */
	private LinkProduitAllergeneService linkProduitAllergeneService;

	/**
	 * Constructeur
	 * 
	 */
	public ProduitManager() {
		conn = DbMgr.getConnection();

		categorieService = new CategorieService(conn);
		marqueService = new MarqueService(conn);
		produitService = new ProduitService(conn);

		linkProduitIngredientService = new LinkProduitIngredientService(conn);
		linkProduitAdditifService = new LinkProduitAdditifService(conn);
		linkProduitAllergeneService = new LinkProduitAllergeneService(conn);

	}

	/**
	 * Traite un produit: gère la totalité de la persistance du produit et de toutes
	 * ses données associées
	 * 
	 * @param produit produit à insérer en base de données.
	 */
	public void traiteProduit(Produit produit) {

		categorieService.insertionEntite(produit.getCategorie());
		marqueService.insertionEntite(produit.getMarque());

		produitService.insertionEntite(produit);

		linkProduitIngredientService.insertionEntites(produit, produit.getIngredients());
		linkProduitAdditifService.insertionEntites(produit, produit.getAdditifs());
		linkProduitAllergeneService.insertionEntites(produit, produit.getAllergenes());
	}

	/**
	 * Fermeture des ressources ouvertes par la classe
	 */
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new ExceptionTech(e.getMessage());
		}
	}
}
