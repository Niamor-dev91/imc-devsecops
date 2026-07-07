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
        return scanner.nextDouble();
    }

    static double getPoids(Scanner scanner) {
        // 1. Demander le poids
        System.out.print("Quel est votre poids (en kg) ? ");
        return scanner.nextDouble();
    }

    static double parseMesure(String saisie) {
        return Double.parseDouble(saisie); // lève NumberFormatException si invalide
    }
}

