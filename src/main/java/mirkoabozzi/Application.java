package mirkoabozzi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mirkoabozzi.dao.EventDAO;
import mirkoabozzi.dao.LocationDAO;
import mirkoabozzi.dao.PartecipationDAO;
import mirkoabozzi.dao.PersonDAO;
import mirkoabozzi.entities.Event;
import mirkoabozzi.entities.Location;
import mirkoabozzi.entities.Person;
import mirkoabozzi.enums.EventType;
import mirkoabozzi.enums.GenderType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4s3l3"); //verifico connessione con database

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager(); // creo EntityManager da EntityManagerFactory
        EventDAO ed = new EventDAO(em);  // creo un nuovo EventDAO e gli passo come parametro l'EntityManager appena creato in modo da poterlo poi utilizzare nella classe EventDAO
        PersonDAO pd = new PersonDAO(em);
        LocationDAO ld = new LocationDAO(em);
        PartecipationDAO ptd = new PartecipationDAO(em);

        Event summerFest = new Event("summer fest", LocalDate.of(2024, 8, 20), "festa estiva", EventType.PUBBLIC, 50);
        Event matrimonio = new Event("matrimonio", LocalDate.of(2024, 10, 20), "matrimonio mario", EventType.PUBBLIC, 200);
        Event barbiere = new Event("taglio capelli", LocalDate.of(2025, 1, 1), "taglio capelli", EventType.PRIVATE, 1);
        Event piscina = new Event("nuoto", LocalDate.of(2024, 7, 25), "200 metri", EventType.PRIVATE, 2);
        Event tracking = new Event("scalata", LocalDate.of(2024, 11, 13), "scalata in montagna", EventType.PUBBLIC, 100);

        Person mirko = new Person("Mirko", "Abozzi", "mirko.abozzi@gmail.com", LocalDate.of(1990, 9, 12), GenderType.MALE);
        Person giovanni = new Person("Giovanni", "Rossi", "giovanni.rossi@gmail.com", LocalDate.of(1988, 6, 25), GenderType.MALE);
        Person alessandro = new Person("Alessandro", "Bianchi", "alessandro.bianchi@gmail.com", LocalDate.of(1991, 3, 14), GenderType.MALE);
        Person federico = new Person("Federico", "Verdi", "federico.verdi@gmail.com", LocalDate.of(1992, 11, 30), GenderType.MALE);
        Person lorenzo = new Person("Lorenzo", "Esposito", "lorenzo.esposito@gmail.com", LocalDate.of(1989, 8, 10), GenderType.MALE);
        Person marco = new Person("Marco", "Moretti", "marco.moretti@gmail.com", LocalDate.of(1993, 5, 22), GenderType.MALE);

//        pd.save(mirko);
//        pd.save(giovanni);
//        pd.save(alessandro);
//        pd.save(federico);
//        pd.save(lorenzo);
//        pd.save(marco);

        List<Event> listaEventi = new ArrayList<>();
//        listaEventi.add(summerFest);
//        listaEventi.add(matrimonio);
//        listaEventi.add(barbiere);
//        listaEventi.add(piscina);
//        listaEventi.add(tracking);

        Location roma = new Location("Colosseo", "Roma", listaEventi);
        Location milano = new Location("Duomo di Milano", "Milano", listaEventi);
        Location firenze = new Location("Piazza della Signoria", "Firenze", listaEventi);
        Location venezia = new Location("Piazza San Marco", "Venezia", listaEventi);
        Location napoli = new Location("Piazza del Plebiscito", "Napoli", listaEventi);

//        ld.save(roma);
//        ld.save(milano);
//        ld.save(firenze);
//        ld.save(venezia);
//        ld.save(napoli);


//        ed.save(summerFest);
//        ed.save(matrimonio);
//        ed.save(barbiere);
//        ed.save(piscina);
//        ed.save(tracking);

//        try {
//            Event event = ed.getById(152);
//            System.out.println(event);
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        try {
//            ed.delete(54);
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }

        em.close();
        emf.close();
    }
}
