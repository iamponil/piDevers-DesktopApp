package services;

import Entity.Museum;
import Entity.Randonnee;
import util.MaConnexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MuseumServices implements ServicesInterface<Museum> {

    Connection c = MaConnexion.getInstance().getCnx();

    @Override
    public void ajouter(Museum museum) {
        try {
            PreparedStatement req = c.prepareStatement("insert into musuem(nomMuseum,locallisationMuseum,createdAt,updatedAt,rating,imageMuseum)values(?,?,?,?,?,?)");
            req.setString(1, museum.getNomMuseum());
            req.setInt(2, museum.getLocalisationMuseum());
            req.setDate(3, new java.sql.Date(museum.getCreatedAt().getTime()));
            req.setDate(4, new java.sql.Date(museum.getUpdatedAt().getTime()));
            req.setInt(5, museum.getRating());
            req.setString(6,museum.getImageMuseum());
            req.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Museum> afficher() {
        List<Museum> listMuseum = new ArrayList<>();
        try {
            PreparedStatement req = c.prepareStatement("select * from musuem  ");
            ResultSet rs = req.executeQuery();
            while (rs.next()) {
                Museum museum = new Museum();
                museum.setMuseumId(rs.getInt("museumId"));
                museum.setNomMuseum(rs.getString("nomMuseum"));
                museum.setLocalisationMuseum(rs.getInt("locallisationMuseum"));
                museum.setCreatedAt(rs.getDate("createdAt"));
                museum.setUpdatedAt(rs.getDate("updatedAt"));
                museum.setRating(rs.getInt("rating"));
                museum.setImageMuseum(rs.getString("imageMuseum")); //We either put image columns as string to save space or as blob .
                listMuseum.add(museum);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listMuseum;
    }

    @Override
    public void modifier(Museum museum) {

        try {
            PreparedStatement req = c.prepareStatement("update musuem set nomMuseum=?,locallisationMuseum=? ,updatedAt=?,rating=?,imageMuseum=? " +
                    "where museumId= '"+museum.getMuseumId()+"'");
            req.setString(1, museum.getNomMuseum());
            req.setInt(2,museum.getLocalisationMuseum());
            req.setDate(3, new java.sql.Date(museum.getUpdatedAt().getTime()));
            req.setInt(4, museum.getRating());
            req.setString(5,museum.getImageMuseum());
            req.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void supprimer(Museum museum) {
            try {
                PreparedStatement req = c.prepareStatement("delete from musuem where museumId = ? ");
                req.setInt(1, museum.getMuseumId());

                req.executeUpdate();

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
}


