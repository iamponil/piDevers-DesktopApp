import Entity.Museum;
import Entity.Randonnee;
import services.MuseumServices;
import services.RandonneeServices;
import util.MaConnexion;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        Randonnee r1 = new Randonnee(8,"ab","cd",new java.util.Date(),new java.util.Date(),new java.util.Date(),"ef");
        Museum museum = new Museum(2,"not","encryptedImage",561134,5,new java.util.Date(),new java.util.Date());

        Randonnee r = new Randonnee(6,"my last","kef",new java.util.Date(),new java.util.Date(),new java.util.Date(),"URL");
        RandonneeServices randonnéeServices= new RandonneeServices();
        MuseumServices museumServices = new MuseumServices();
        //museumServices.ajouter(museum);
        System.out.println(museumServices.afficher());
       // museumServices.supprimer(museum);
museumServices.modifier(museum);
        // randonnéeServices.ajouter(r);
       // randonnéeServices.modifier(r);
       System.out.println(randonnéeServices.afficher());
        //randonnéeServices.supprimer(r);

    }
}