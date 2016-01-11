package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.access.Constants;
import DB.access.LieuAccess;
import DB.Entite.CriminelEntite;
import DB.Entite.LieuEntite;

public class LieuServices {
	private LieuAccess lieuAccess;

	public LieuServices() {
		this.lieuAccess = new LieuAccess();
	}

	public void setLieu(LieuEntite lieu) {

		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			lieuAccess.setLieu(Lieu, conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<LieuEntite> getAllLieux() {
		ArrayList<LieuEntite> allIntentions = null;

		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			allIntentions = lieuAccess.selectAll(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allIntentions;
	}
}
