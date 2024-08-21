package mirkoabozzi.entities;

import jakarta.persistence.*;
import mirkoabozzi.enums.EventType;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "event_data", nullable = false)
    private LocalDate eventData;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "event_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column(name = "max_people")
    private int maxPeople;

    @OneToMany(mappedBy = "event")
    private List<Partecipation> partecipationList;

    public Event() {
    }

    public Event(String title, LocalDate eventData, String description, EventType eventType, int maxPeople) {
        this.title = title;
        this.eventData = eventData;
        this.description = description;
        this.eventType = eventType;
        this.maxPeople = maxPeople;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEventData() {
        return eventData;
    }

    public void setEventData(LocalDate eventData) {
        this.eventData = eventData;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", eventData=" + eventData +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                ", maxPeople=" + maxPeople +
                '}';
    }
}
