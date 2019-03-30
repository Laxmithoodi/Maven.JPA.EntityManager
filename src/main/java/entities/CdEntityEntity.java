package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CdEntity", schema = "jpaentity")
public class CdEntityEntity {

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = ArtistEntityEntity.class)
    @JoinTable(name = "artist_cd",
            joinColumns = @JoinColumn(name = "cd_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id"))
     public Set<ArtistEntityEntity> artistSet;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column
    private String description;
    @Basic
    @Column
    private String price;
    @Basic
    @Column
    private String title;
    @Basic
    @Column
    private String year;


    public CdEntityEntity() {
        this.artistSet = new HashSet<>();
    }

    public CdEntityEntity(String title, String description, String year,  String price,Set<ArtistEntityEntity> artist){
        this.title= title;
        this.description = description;
        this.year = year;
        this.price= price;
        this.setArtist(artist);

    }

    public void setArtist(Set<ArtistEntityEntity> artist) {
        this.artistSet = artist;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CdEntityEntity that = (CdEntityEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CdEntityEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", artist=" + artistSet +
                '}';
    }
}
