package fr.diginamic.offi.entity;

public abstract class Entite {

	/** id */
	protected Long id;
	/** nom */
	protected String nom;

	/**
	 * Constructeur
	 * 
	 * @param nom nom de l'entité
	 */
	public Entite(String nom) {
		super();
		this.nom = nom;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Getter
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Setter
	 * 
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
}
