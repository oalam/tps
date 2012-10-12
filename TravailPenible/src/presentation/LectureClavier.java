package presentation;

import java.io.*;

/**
 *
 * Cette classe a pour rôle de faciliter la lecture de données à partir du
 * clavier. <BR> Elle definit une méthode de lecture pour les types de base les
 * plus courramment utilisés (int, float, double, boolean, String).<BR> <BR> La
 * lecture d'une valeur au clavier se fait en tapant celle-ci suivie d'un retour
 * chariot. <BR> En cas d'erreur de lecture (par exemple un caractère a été tapé
 * lors de la lecture d'un entier) un message d'erreur est affiché sur la
 * console et l'exécution du programme est interrompue. <BR><BR><BR> <B>exemples
 * d'utilisation de cette classe</B><BR>
 * <PRE>
 *      System.out.print("entrez un entier : ");
 *      System.out.flush();
 *      int i = LectureClavier.lireEntier();
 *      System.out.println("entier lu : " + i);
 *
 *      System.out.print("entrez une chaine :");
 *      System.out.flush();
 *      String s = LectureClavier.lireChaine();
 *      System.out.println("chaine lue : " + s);
 *
 *      System.out.print("entrez une réel (float) : ");
 *      System.out.flush();
 *      float f = LectureClavier.lireFloat();
 *      System.out.println("réel (float) lu : " + f);
 *
 *      System.out.print("entrez une réel (double) : ");
 *      System.out.flush();
 *      double d = LectureClavier.lireDouble();
 *      System.out.println("réel (double) lu : " + d);
 *
 *      System.out.print("entrez une réposne O/N : ");
 *      System.out.flush();
 *      boolean b = LectureClavier.lireOuiNon();
 *      System.out.println("booleen lu : " + b);
 * </PRE>
 * 
*/
public class LectureClavier {

    private static BufferedReader stdin = new BufferedReader(
	    new InputStreamReader(System.in));

    /**
     * lecture au clavier d'un entier simple precision (int)
     *
     * @return l'entier lu
     */
    public static int lireEntier() {

	try {
	    return (Integer.parseInt(stdin.readLine()));
	} catch (Exception e) {
	    erreurEntree(e, "entier");
	    return 0;    // m�me si on passe jamais ici il faut un return !!
	}
    }

    /**
     * lecture au clavier d'une chaine de caract�res
     *
     * @return la chaine lue
     */
    public static String lireChaine() {
	try {
	    return (stdin.readLine());
	} catch (Exception e) {
	    erreurEntree(e, "chaine de caractères");

	    return null;
	}
    }

    /**
     * lecture au clavier d'un réel simple précision (float)
     *
     * @return le float lu
     */
    public static float lireFloat() {

	try {
	    return (Float.valueOf(stdin.readLine()).floatValue());
	} catch (Exception e) {
	    erreurEntree(e, "réel (float)");

	    return (float) 0.0;
	}
    }

    /**
     * lecture au clavier d'un re�l double pr�cision (double) le double lu
     */
    public static double lireDouble() {
	try {
	    return (Double.valueOf(stdin.readLine()).doubleValue());
	} catch (Exception e) {
	    erreurEntree(e, "r�el (double)");
	    return 0.0;
	}
    }

    /**
     * lecture au clavier d'une r�ponse de type oui/non. Si la valeur tap�e est
     * "o" ou "O" cette m�thode renvoie
     * <code>true</code>, sinon elle renvoie
     * <code>false</code>.
     *
     * @return <code>true</code> si la chaine lue est "o" ou "O",
     * <code>false</code> sinon
     */
    public static boolean lireOuiNon() {
	String ch;
	ch = lireChaine();
	return (ch.equals("o") || ch.equals("O"));
    }

    /**
     * lecture au clavier d'une r�ponse de type oui/non. Si la valeur tap�e est
     * "o" ou "O" cette m�thode renvoie
     * <code>true</code>, sinon elle renvoie
     * <code>false</code>.
     *
     * @return <code>true</code> si la chaine lue est "o" ou "O",
     * <code>false</code> sinon
     */
    public static char lireChar() {
	String ch;
	ch = lireChaine();
	return ch.charAt(0);
    }

    /**
     * en cas d'erreur lors d'une lecture, affiche sur la sortie standard
     * (System.out) un message indiquant le type de l'erreur ainsi que la la
     * pile des appels de m�thodes ayant conduit � cette erreur.
     *
     * @param e l'exception d�crivant l'erreur.
     * @param message le message d'erreur � afficher.
     */
    private static void erreurEntree(Exception e, String message) {
	System.out.println("Erreur lecture " + message);
	System.out.println(e);
	e.printStackTrace();
	System.exit(1);
    }
} // LectureClavier
