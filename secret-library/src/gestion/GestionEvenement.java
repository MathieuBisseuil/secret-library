package gestion;

import classe.Evenement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestionEvenement {

    private Connection connexion;

    public Connection getConnexion() {
        return connexion;
    }

    public void setConnexion(Connection connexion) {
        this.connexion = connexion;
    }

    public GestionEvenement(Connection connexion) {
        this.connexion = connexion;
    }

    public void sqlCreate(Evenement e) {
        try {
            String query = "INSERT INTO "
                    + "Evenement (NomEvenement, PromotionEvenement, LogoEvenement, DateDebutEvenement, DateFinEvenement, CommentaireEvenement) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connexion.prepareStatement(query);
            stmt.setString(1, e.getNomEvenement());
            stmt.setInt(2, e.getPromotionEvenement());
            stmt.setString(3, e.getLogoEvenement());
            stmt.setDate(4, e.getDateDebutEvenement());
            stmt.setDate(5, e.getDateFinEvenement());
            stmt.setString(6, e.getCommentaireEvenement());
            stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(GestionEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sqlRead() {
        try {
            String query = "SELECT * FROM Evenement";
            Statement stmt = connexion.createStatement();
            stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(GestionEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sqlUpdate(Evenement e, int idEvenement) {
        try {
            String query = "UPDATE Evenement SET "
                    + "NomEvenement = ?, "
                    + "PromotionEvenement = ?, "
                    + "LogoEvenement = ?, "
                    + "DateDebutEvenement = ?, "
                    + "DateFinEvenement = ?, "
                    + "CommentaireEvenement = ? "
                    + "WHERE idEvenement = " + idEvenement;
            PreparedStatement stmt = connexion.prepareStatement(query);
            stmt.setString(1, e.getNomEvenement());
            stmt.setInt(2, e.getPromotionEvenement());
            stmt.setString(3, e.getLogoEvenement());
            stmt.setDate(4, e.getDateDebutEvenement());
            stmt.setDate(5, e.getDateFinEvenement());
            stmt.setString(6, e.getCommentaireEvenement());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestionEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sqlDelete (Evenement e, int idEvenement) {
        try {
            String query = "DELETE FROM Evenement WHERE idEvenement = " + idEvenement;
            Statement stmt = connexion.createStatement();
            stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(GestionEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
