package domain;



public class EmployePermanent extends Employe {

    // constantes
    private static final double INDEMNITE_NUIT = 700;
    private boolean isDiurne;
    private int nbJoursAbraseuse;


    // Constructeurs
    public EmployePermanent(String nom, String prenom, int indiceBrut,
            boolean diurne, int nbja) {
        super(nom, prenom, indiceBrut);
        this.isDiurne = diurne;
        nbJoursAbraseuse = nbja;
    }

    public EmployePermanent() {
    }
    
  
    // Accesseurs et Modifieurs des propriétés (attributs) d'un permanent
    public boolean isDiurne() {
        return isDiurne;
    }

    public void setIsDiurne(boolean isDiurne) {
        this.isDiurne = isDiurne;
    }

    public int getNbJoursAbraseuse() {
        return nbJoursAbraseuse;
    }

    public void setNbJoursAbraseuse(int nbJoursAbraseuse) {
        this.nbJoursAbraseuse = nbJoursAbraseuse;
    }

    //--------------------------------------------------------------------------
    // Autres méthodes
    //--------------------------------------------------------------------------
    /** calcule le montant de l'indemnité qui devra étre versée à
     * cet employé pour cause de travail bruyant.
     * @return montant de l'indemnité de travail bruyant.
     */
    public double indemniteBruit() {
        return nbJoursAbraseuse * indiceBrut / 20.0;
    }

    /** calcule le montant de l'indemnité qui devra étre versée à
     * cet employé pour travail nocturne.
     * @return montant de l'indemnité de travail nocturne.
     */
    public double indemniteNuit() {
        if (isDiurne) {
            return 0;
        } else {
            return INDEMNITE_NUIT;
        }
    }

    //------------------------------------------------------
    // définition de la méthode abstraite héritée de Employé
    //------------------------------------------------------
    /** calcule le montant de l'indemnité de travail pénible qui devra étre 
     * versée à cet employé (indemnité bruit + indemnité de travail pénible)
     * @return montant de l'indemnité de travail pénible
     */
    @Override
    public double indemniteTravailPenible() {
        return indemniteBruit() + indemniteNuit();
    }

    //------------------------------------------------------
    // redéfinition des méthodes héritées d'Employé
    //------------------------------------------------------
    @Override
    public String exporter() {
        return "P" + "\t"
                + super.exporter() + "\t"
                + ((isDiurne) ? "diurne" : "nocturne") + "\t"
                + nbJoursAbraseuse;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Permanent");
        System.out.println((isDiurne) ? "diurne" : "nocturne");
        System.out.println("nbre de jours sur abraseuse " + nbJoursAbraseuse);
    }
}
