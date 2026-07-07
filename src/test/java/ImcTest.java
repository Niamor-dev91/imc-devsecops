import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ImcTest {

    @Test
    void testImcNormal() {
        // Un adulte de 70 kg mesurant 180 cm
        // IMC attendu = 70 / (1.80 * 1.80) = 21.6
        double imc = Imc.getImc(180.0, 70.0);
        assertEquals(21.6, imc, 0.1); // tolérance de 0.1
    }

    @Test
    void testImcSurpoids() {
        // 90 kg pour 170 cm → IMC = 90 / (1.70²) = 31.1
        double imc = Imc.getImc(170.0, 90.0);
        assertEquals(31.1, imc, 0.1);
    }

    @Test
    void testImcMaigreur() {
        // 50 kg pour 175 cm → IMC = 50 / (1.75²) = 16.3
        double imc = Imc.getImc(175.0, 50.0);
        assertEquals(16.3, imc, 0.1);
    }

    @Test
    void testImcCalculExact() {
        // Cas simple vérifiable à la main :
        // 100 kg pour 200 cm (2m) → 100 / (2*2) = 25.0 pile
        double imc = Imc.getImc(200.0, 100.0);
        assertEquals(25.0, imc, 0.001);
    }

    @Test
    void testPoidsAvecCaractereAlphanumerique() {
        // On simule un utilisateur qui tape "abc" au clavier
        String saisieSimulee = "abc";
        Scanner scanner = new Scanner(new ByteArrayInputStream(saisieSimulee.getBytes()));

        // On s'attend à ce que le programme gère l'erreur proprement.
        // ACTUELLEMENT : scanner.nextDouble() lève InputMismatchException
        // => ce test est KO car l'exception n'est PAS gérée par ton code
        assertThrows(IllegalArgumentException.class, () -> {
            Imc.getPoids(scanner);
        });
    }

    @Test
    void testCaracteresInterdits() {
        // On s'attend à ce qu'une entrée invalide soit REJETÉE proprement
        // avec une exception métier claire (ex: IllegalArgumentException)
        assertThrows(IllegalArgumentException.class, () -> {
            Imc.parseMesure("abc");
        });
    }
}
