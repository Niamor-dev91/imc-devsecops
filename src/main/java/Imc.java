import java.util.InputMismatchException;
import java.util.Scanner;

public class Imc {

    public static void main(String[] args) {
        // Scanner pour lire ce que l'utilisateur tape dans la console
        Scanner scanner = new Scanner(System.in);

        double poids = getPoids(scanner);

        double tailleCm = getTailleCm(scanner);

        double imc = getImc(tailleCm, poids);

        displayImc(imc);

        // Fermer le scanner
        scanner.close();
    }

    static void displayImc(double imc) {
        // 4. Afficher le résultat (arrondi à 1 décimale)
        System.out.printf("Votre IMC est de %.1f%n", imc);
    }

    static double getImc(double tailleCm, double poids) {
        // 3. Calculer l'IMC : poids / (taille en mètres)^2
        double tailleM = tailleCm / 100.0;
        return poids / (tailleM * tailleM);
    }

    static double getTailleCm(Scanner scanner) {
        // 2. Demander la taille
        System.out.print("Quelle est votre taille (en cm) ? ");
        try {
            double taille = scanner.nextDouble();
            // On vérifie que la taille est cohérente (pas négative, pas nulle)
            if (taille <= 0) {
                throw new IllegalArgumentException("La taille doit être un nombre positif.");
            }
            return taille;
        } catch (InputMismatchException e) {
            // La saisie n'est pas un nombre (ex: "abc")
            throw new IllegalArgumentException("La taille saisie n'est pas un nombre valide.", e);
        }
    }


    static double getPoids(Scanner scanner) {
        // 1. Demander le poids
        System.out.print("Quel est votre poids (en kg) ? ");
        try {
            double poids = scanner.nextDouble();
            // On vérifie aussi que le poids est cohérent (pas négatif, pas nul)
            if (poids <= 0) {
                throw new IllegalArgumentException("Le poids doit être un nombre positif.");
            }
            return poids;
        } catch (InputMismatchException e) {
            // La saisie n'est pas un nombre (ex: "abc")
            throw new IllegalArgumentException("Le poids saisi n'est pas un nombre valide.", e);
        }
    }


    static double parseMesure(String saisie) {
        return Double.parseDouble(saisie); // lève NumberFormatException si invalide
    }
}

