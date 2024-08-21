package mirkoabozzi.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "participation")
public class Partecipation {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne()
    @JoinColumn(name = "event_id")
    private Event event;

    public Partecipation(Person person, Event event) {
        this.person = person;
        this.event = event;
    }

    public UUID getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Partecipation{" +
                "id=" + id +
                ", person=" + person +
                ", event=" + event +
                '}';
    }
}
