import org.example.Banque;
import org.example.Jeu;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

public class JeuTest {

    @Test
    public void testFermetureDuJeu() {
        Banque banqueMock = mock(Banque.class);
        Jeu jeu = new Jeu(banqueMock);

        jeu.fermer();

        assertFalse(jeu.estOuvert());
    }
}
