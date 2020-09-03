package fr.diginamic.offi.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.diginamic.offi.dao.LinkDao;
import fr.diginamic.offi.entity.Entite;
import fr.diginamic.offi.entity.Produit;

/**
 * Classe de service générique qui propose des traitements génériques pour
 * traiter la problématique des liens entre produits et ingrédients, produits et
 * additifs, produits et allergènes
 */
public class LinkService<T extends Entite> {

	/** classe: Ingredient, Additif ou Allergene */
	protected Class<T> classe;

	/** DAO de lien à utiliser */
	private LinkDao<T> linkDao;

	/** cache mémoire */
	protected Map<String, T> cache = new HashMap<>();

	/**
	 * Constructeur
	 * 
	 * @param classe  classe à traiter (Ingredient, Additif ou Allergene)
	 * @param linkDao DAO à utiliser
	 */
	public LinkService(Class<T> classe, LinkDao<T> linkDao) {
		super();
		this.classe = classe;
		this.linkDao = linkDao;
	}

	/**
	 * Insère les entités associées au produit en base de données
	 * 
	 * @param produit produit
	 * @param entités entités à insérer
	 */
	public void insertionEntites(Produit produit, List<T> entites) {

		entites.forEach(ent -> insertionEntite(produit, ent));
	}

	/**
	 * Insère une entité associée à un produit en base de données
	 * 
	 * @param produit produit
	 * @param entité  entité à insérer
	 */
	private void insertionEntite(Produit produit, T entite) {

		T entiteBase = cache.get(entite.getNom());
		if (entiteBase != null) {
			entite.setId(entiteBase.getId());
		} else {
			entiteBase = linkDao.find(entite.getNom());
			if (entiteBase == null) {
				linkDao.insert(entite);
				entiteBase = linkDao.find(entite.getNom());
			}
			entite.setId(entiteBase.getId());
			cache.put(entite.getNom(), entite);
		}

		boolean lienExiste = linkDao.exist(produit, entite);
		if (!lienExiste) {
			linkDao.insert(produit, entite);
		}
	}
}
