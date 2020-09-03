package fr.diginamic.offi.manager;

import java.util.HashMap;
import java.util.Map;

import fr.diginamic.offi.dao.EntiteDao;
import fr.diginamic.offi.entity.Entite;

public abstract class EntiteService<T extends Entite> {

	/** classe */
	protected Class<T> classe;

	/** entiteDao */
	protected EntiteDao<T> entiteDao;

	/** cache mémoire */
	protected Map<String, T> cache = new HashMap<>();

	/**
	 * Constructeur
	 * 
	 * @param classe    classe à traiter
	 * @param entiteDao DAO à utiliser
	 */
	public EntiteService(Class<T> classe, EntiteDao<T> entiteDao) {
		super();
		this.classe = classe;
		this.entiteDao = entiteDao;
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite entité à insérer
	 */
	public void insertionEntite(T entite) {

		T entiteBase = cache.get(entite.getNom());
		if (entiteBase != null) {
			entite.setId(entiteBase.getId());
			return;
		}

		entiteBase = entiteDao.find(entite.getNom());
		if (entiteBase == null) {
			entiteDao.insert(entite);
			entiteBase = entiteDao.find(entite.getNom());
		}
		entite.setId(entiteBase.getId());

		cache.put(entite.getNom(), entite);
	}
}
