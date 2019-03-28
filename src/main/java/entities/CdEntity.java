package entities;

import javax.persistence.*;

@Entity
@Table(name = "cd", schema = "jpaentity")
public class CdEntity {
    @Id
    @GeneratedValue()
    private int id;
    private String title;
    private String description;
    private String year;
    private String artist;
    private String price;

    public CdEntity() { }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 200)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "year", nullable = false, length = 4)
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Basic
    @Column(name = "artist", nullable = true, length = 30)
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Basic
    @Column(name = "price", nullable = true, length = 5)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CdEntity cdEntity = (CdEntity) o;

        if (id != cdEntity.id) return false;
        if (title != null ? !title.equals(cdEntity.title) : cdEntity.title != null) return false;
        if (description != null ? !description.equals(cdEntity.description) : cdEntity.description != null)
            return false;
        if (year != null ? !year.equals(cdEntity.year) : cdEntity.year != null) return false;
        if (artist != null ? !artist.equals(cdEntity.artist) : cdEntity.artist != null) return false;
        if (price != null ? !price.equals(cdEntity.price) : cdEntity.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
