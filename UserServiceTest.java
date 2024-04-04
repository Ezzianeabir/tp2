import org.example.ServiceException;
import org.example.UserService;
import org.example.Utilisateur;
import org.example.UtilisateurApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    
/* exo2
    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Test
    public void testCreerUtilisateur() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");

        // Configuration du comportement du mock pour la méthode creerUtilisateur
        doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);

        // Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);

        // Appel de la méthode à tester
        try {
            userService.creerUtilisateur(utilisateur);
        } catch (ServiceException e) {
            // Gestion de l'exception (non nécessaire pour ce test)
        }

        // Vérification de l'appel à l'API
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
*/




//exo3


        @Mock
        private UtilisateurApi utilisateurApiMock;

        @InjectMocks
        private UserService userService;

        @Captor
        private ArgumentCaptor<Utilisateur> utilisateurCaptor;

        
        @Test
        public void testCreerUtilisateur_WhenApiThrowsException() throws ServiceException {
            Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
            // Configuration du mock pour lancer une exception lors de la création de l'utilisateur
            doThrow(new ServiceException("Echec de la création de l'utilisateur")).when(utilisateurApiMock).creerUtilisateur(utilisateur);
            // Appel de la méthode à tester
            userService.creerUtilisateur(utilisateur);
        }

    @Test
    public void testCreerUtilisateur_WhenApiReturnsFalse() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        // Configuration du mock pour retourner false lors de la création de l'utilisateur
        doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);
        // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);
    }

    @Test
    public void testCreerUtilisateur_WhenApiReturnsTrue() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        // Configuration du mock pour retourner true lors de la création de l'utilisateur
        doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);
        // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);
    }

    @Test
    public void testCreerUtilisateur_WhenApiArgumentCaptured() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        // Configuration du mock pour retourner true lors de la création de l'utilisateur
        doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);
        // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);
    }

}

