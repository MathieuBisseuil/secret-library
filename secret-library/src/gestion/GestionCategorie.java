package gestion;

import classe.Categorie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestionCategorie {

    private Connection connexion;

    public Connection getConnexion() {
        return connexion;
    }

    public void setConnexion(Connection connexion) {
        this.connexion = connexion;
    }

    public GestionCategorie(Connection connexion) {
        this.connexion = connexion;
    }

    public void sqlCreate(Categorie cat) {
        try {
            String query = "INSERT INTO Categorie VALUES (?)";
            PreparedStatement stmt = connexion.prepareStatement(query);
            stmt.setString(1, cat.getNomCategorie());
            stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(GestionCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet sqlRead() {
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Categorie";
            Statement stmt = connexion.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(GestionEditeur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public void sqlUpdate(Categorie cat, String nomCategorie) {
        try {
            String query = "UPDATE Categorie SET nomCAtegorie = ? "
                    + "WHERE nomCategorie = " + nomCategorie;
            PreparedStatement stmt = connexion.prepareStatement(query);
            stmt.setString(1, cat.getNomCategorie());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sqlDelete(Categorie cat, String nomCategorie) {
        try {
            String query = "DELETE FROM Categorie WHERE nomCategorie = " + nomCategorie;
            Statement stmt = connexion.createStatement();
            stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(GestionCategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
