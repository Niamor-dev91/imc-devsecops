import java.util.Scanner;

public class Imc {

    public static void main(String[] args) {
        // Scanner pour lire ce que l'utilisateur tape dans la console
        Scanner scanner = new Scanner(System.in);

        // 1. Demander le poids
        System.out.print("Quel est votre poids (en kg) ? ");
        double poids = scanner.nextDouble();

        // 2. Demander la taille
        System.out.print("Quelle est votre taille (en cm) ? ");
        double tailleCm = scanner.nextDouble();

        // 3. Calculer l'IMC : poids / (taille en mètres)^2
        double tailleM = tailleCm / 100.0;
        double imc = poids / (tailleM * tailleM);

        // 4. Afficher le résultat (arrondi à 1 décimale)
        System.out.printf("Votre IMC est de %.1f%n", imc);

        // Fermer le scanner
        scanner.close();
    }
}

