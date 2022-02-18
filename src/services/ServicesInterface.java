package services;

import java.util.List;

public interface ServicesInterface<T> {
    void ajouter(T t);
    List<T> afficher();
    void modifier(T t);
    void supprimer(T t);
}
