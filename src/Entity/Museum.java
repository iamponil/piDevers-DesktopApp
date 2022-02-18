package Entity;

import java.util.Date;
import java.util.Objects;

public class Museum {
    int museumId;
    String nomMuseum, imageMuseum;
    int localisationMuseum, rating;
    Date createdAt ,updatedAt;
public Museum(){}

    public Museum(String nomMuseum, String imageMuseum, int localisationMuseum, int rating, Date createdAt, Date updatedAt) {
        this.nomMuseum = nomMuseum;
        this.imageMuseum = imageMuseum;
        this.localisationMuseum = localisationMuseum;
        this.rating = rating;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Museum(int museumId, String nomMuseum, String imageMuseum, int localisationMuseum, int rating, Date createdAt, Date updatedAt) {
        this.museumId = museumId;
        this.nomMuseum = nomMuseum;
        this.imageMuseum = imageMuseum;
        this.localisationMuseum = localisationMuseum;
        this.rating = rating;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getMuseumId() {
        return museumId;
    }

    public void setMuseumId(int museumId) {
        this.museumId = museumId;
    }

    public String getNomMuseum() {
        return nomMuseum;
    }

    public void setNomMuseum(String nomMuseum) {
        this.nomMuseum = nomMuseum;
    }

    public String getImageMuseum() {
        return imageMuseum;
    }

    public void setImageMuseum(String imageMuseum) {
        this.imageMuseum = imageMuseum;
    }

    public int getLocalisationMuseum() {
        return localisationMuseum;
    }

    public void setLocalisationMuseum(int localisationMuseum) {
        this.localisationMuseum = localisationMuseum;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Museum{" +
                "museumId=" + museumId +
                ", nomMuseum='" + nomMuseum + '\'' +
                ", imageMuseum='" + imageMuseum + '\'' +
                ", localisationMuseum=" + localisationMuseum +
                ", rating=" + rating +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Museum museum = (Entity.Museum) o;
        return museumId == museum.museumId && localisationMuseum == museum.localisationMuseum && rating == museum.rating && Objects.equals(nomMuseum, museum.nomMuseum) && Objects.equals(imageMuseum, museum.imageMuseum) && Objects.equals(createdAt, museum.createdAt) && Objects.equals(updatedAt, museum.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(museumId, nomMuseum, imageMuseum, localisationMuseum, rating, createdAt, updatedAt);
    }
}
