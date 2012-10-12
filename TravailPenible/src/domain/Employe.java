package domain;



public abstract class Employe {

    // constantes
    public static final int INDICE_BRUT_MIN = 200;
    public static final int INDICE_BRUT_MAX = 800;

    protected String nom;
    protected String prenom;
    protected int indiceBrut;

    // Constructeurs
    protected Employe(String nom, String prenom, int indiceBrut) {
        this.nom = nom;
        this.prenom = prenom;
        this.indiceBrut = indiceBrut;
    }

    public Employe() {
    }

    
    //--------------------------------------------------------------------------
    // Accesseurs et Modifieurs des propriétés (attributs) d'un employé

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getIndiceBrut() {
        return indiceBrut;
    }

    public void setIndiceBrut(int indiceBrut) {
        this.indiceBrut = indiceBrut;
    }

    // Autres méthodes
    /**
     * calcule le montant de l'indemnité de travail pénible qui devra étre 
     * versée é cet employé.
     * @return montant de l'indemnité de travail pénible
     */
    public abstract double indemniteTravailPenible();

    /**
     * affiche sur la sortie standard (<code>System.out</code>) les
     * caractéristiques de l'employé.
     */
    public void afficher() {
        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Indice : " + indiceBrut);
        System.out.println("Idemnité travail pénible : " + indemniteTravailPenible());
    }

    /**
     * fournit un chaéne de caractéres correspondant au format
     * d'enregistrement de l'employé dans un fichier texte.
     * @return la chaéne nom prenom et indiceBrut séparés par des tabulation
     */
    public String exporter() {
        return nom + "\t" + prenom + "\t" + indiceBrut;
        // \t le caractére de tabulation
    }

    @Override
    public boolean equals(Object obj) {
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final Employe other = (Employe) obj;
	if ((this.nom == null) ? (other.nom != null) : !this.nom.equals(other.nom)) {
	    return false;
	}
	if ((this.prenom == null) ? (other.prenom != null) : !this.prenom.equals(other.prenom)) {
	    return false;
	}
	if (this.indiceBrut != other.indiceBrut) {
	    return false;
	}
	return true;
    }



    @Override
    public int hashCode() {
	int hash = 7;
	hash = 53 * hash + (this.nom != null ? this.nom.hashCode() : 0);
	hash = 53 * hash + (this.prenom != null ? this.prenom.hashCode() : 0);
	hash = 53 * hash + this.indiceBrut;
	return hash;
    }
}
