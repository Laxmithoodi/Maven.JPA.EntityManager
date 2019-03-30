package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ArtistEntity", schema = "jpaentity")
public class ArtistEntityEntity {

    @ManyToMany(mappedBy = "artistSet", cascade = CascadeType.ALL)
    public Set<CdEntityEntity> cds= new HashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column
    private String firstName;
    @Basic
    @Column
    private String instrument;
    @Basic
    @Column
    private String lastName;

    public ArtistEntityEntity() {}

    public ArtistEntityEntity(String firstName, String lastName, String instrument){

        this.firstName = firstName;
        this.lastName = lastName;
        this.instrument = instrument;
    }


    public Set<CdEntityEntity> getCds() {
        return cds;
    }

    public void setCds(Set<CdEntityEntity> cds) {
        this.cds = cds;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }



    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArtistEntityEntity that = (ArtistEntityEntity) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (instrument != null ? !instrument.equals(that.instrument) : that.instrument != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (instrument != null ? instrument.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ArtistEntityEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", instrument='" + instrument + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cds=" + cds +
                '}';
    }
}
