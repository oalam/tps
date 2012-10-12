package domain;


public class EmployeTemporaire extends Employe {
    
    // constantes
    private static final int INDEM_VAC_NUIT_SEM = 14;
    private static final int INDEM_VAC_JOUR_WE = 10;
    private static final int INDEM_VAC_NUIT_WE = 20;
    
    // Attributs (propriétés) d'un employé temporaire
    private int nbVacJour;
    private int nbVacNuit;
    private int nbVacJourWe;
    private int nbVacNuitWe;
    
    // Constructeurs
    public EmployeTemporaire(String nom, String prenom, int indiceBrut, int nbVJ, 
                               int nbVJWe, int nbVN, int nbVNWe) {
        super(nom,prenom,indiceBrut);
        nbVacJour = nbVJ;
        nbVacJourWe = nbVJWe;
        nbVacNuit = nbVN;
        nbVacNuitWe = nbVNWe;
    }

    //--------------------------------------------------------------------------
    // Accesseurs et Modifieurs des propriétés (attributs) d'un temporaire
    public int getNbVacJour() {
        return nbVacJour;
    }    

    public void setNbVacJour(int nbVacJour) {
        this.nbVacJour = nbVacJour;
    }
    
    public int getNbVacNuit() {
        return nbVacNuit;
    }
    
    public void setNbVacNuit(int nbVacNuit) {
        this.nbVacNuit = nbVacNuit;
    }
    
    public int getNbVacJourWe() {
        return nbVacJourWe;
    }
    
    public void setNbVacJourWe(int nbVacJourWe) {
        this.nbVacJourWe = nbVacJourWe;
    }
    
    public int getNbVacNuitWe() {
        return nbVacNuitWe;
    }
    
    public void setNbVacNuitWe(int nbVacNuitWe) {
        this.nbVacNuitWe = nbVacNuitWe;
    }
    
    //--------------------------------------------------------------------------
    // Autres méthodes
    //--------------------------------------------------------------------------
 
    //------------------------------------------------------
    // définition de la méthode abstraite héritée de Employé
    //------------------------------------------------------

    /** calcule le montant de l'indemnité de travail pénible qui devra être 
     * versée à cet employé.
     * @return montant de l'indemnité de travail pénible
     *
     */
    @Override
    public double indemniteTravailPenible() {
        return INDEM_VAC_JOUR_WE * nbVacJourWe 
               + INDEM_VAC_NUIT_SEM * (nbVacNuit - nbVacNuitWe) 
               + INDEM_VAC_NUIT_WE * nbVacNuitWe;
    }
    
    //------------------------------------------------------
    // redéfinition des méthodes héritées d'Employé
    //------------------------------------------------------
    
    @Override
    public String exporter() {
        return "T" + "\t" +
               super.exporter() + "\t" +
               nbVacJour + "\t" +
               nbVacJourWe + "\t" +
               nbVacNuit +  "\t" +
               nbVacNuitWe;
    }
    
    @Override
    public void afficher() {
        super.afficher();
        System.out.println(" Temporaire");
        System.out.println("nombre total de vacations " + (nbVacJour + nbVacNuit));
        System.out.println("nombre de vacations de jour " + nbVacJour + " dont " + nbVacJourWe + " le week-end");
        System.out.println("nombre de vacations de nuit " + nbVacNuit + " dont " + nbVacNuitWe + " le week-end");
    }
    
}
