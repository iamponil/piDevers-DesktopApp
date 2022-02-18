package services;

import Entity.Randonnee;
import util.MaConnexion;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RandonneeServices implements ServicesInterface<Randonnee> {
    Connection c = MaConnexion.getInstance().getCnx();

    @Override
    public void ajouter(Randonnee randonnee) {

        try {
            PreparedStatement req = c.prepareStatement("insert into randonnee(nomRandonnee,paysRandonnee,dateRandonnee,created_at,updated_at,imageEndroitRandonnee)values(?,?,?,?,?,?)");
            req.setString(1, randonnee.getNomRandonnee());
            req.setString(2, randonnee.getPaysRandonnee());
            req.setDate(3, new java.sql.Date(randonnee.getDateRandonnee().getTime()));
            req.setDate(4, new java.sql.Date(randonnee.getCreated_at().getTime()));
            req.setDate(5, new java.sql.Date(randonnee.getUpdated_at().getTime()));
            req.setString(6, randonnee.getImageEndroitRandonnee());
            req.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Randonnee> afficher() {
        List<Randonnee> listRandonnees = new ArrayList<>();
        try {
            PreparedStatement req = c.prepareStatement("select * from randonnee  ");
            ResultSet rs = req.executeQuery();
            while (rs.next()) {
                Randonnee randonnee1 = new Randonnee();
                randonnee1.setIdRandonnee(rs.getInt("IdRandonnee"));
                randonnee1.setNomRandonnee(rs.getString("nomRandonnee"));
                randonnee1.setPaysRandonnee(rs.getString("paysRandonnee"));
                randonnee1.setDateRandonnee(rs.getDate("dateRandonnee"));
                randonnee1.setCreated_at(rs.getDate("created_at"));
                randonnee1.setUpdated_at(rs.getDate("updated_at"));
                randonnee1.setImageEndroitRandonnee(rs.getString("imageEndroitRandonnee")); //We either put image columns as string to save space or as blob .
                listRandonnees.add(randonnee1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listRandonnees;
    }

    @Override
    public void modifier(Randonnee randonnee) {
        try {
            PreparedStatement req = c.prepareStatement("update randonnee set nomRandonnee=?,paysRandonnee=? ,dateRandonnee=?,created_at=?,updated_at=?,imageEndroitRandonnee=? " +
                    "where idRandonnee= '"+randonnee.getIdRandonnee()+"'");
            req.setString(1, randonnee.getNomRandonnee());
            req.setString(2,randonnee.getPaysRandonnee());
            req.setDate(3, new java.sql.Date( randonnee.getDateRandonnee().getTime()));
            req.setDate(4, new java.sql.Date(randonnee.getCreated_at().getTime()));
            req.setDate(5, new java.sql.Date(randonnee.getUpdated_at().getTime()));
            req.setString(6, randonnee.getImageEndroitRandonnee());
            req.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void supprimer(Randonnee randonnee) {
        try {
            PreparedStatement req = c.prepareStatement("delete from Randonnee where idRandonnee = ? ");
            req.setInt(1, randonnee.getIdRandonnee());

            req.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}

