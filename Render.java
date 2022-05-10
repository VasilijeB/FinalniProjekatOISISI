package projekat;

public class Render {
	private String Materijali;
	private String Kamere;
	private String Objekti;
	private String Naziv;
	public Render(String materijali, String kamere, String objekti, String naziv) {
		super();
		Materijali = materijali;
		Kamere = kamere;
		Objekti = objekti;
		Naziv = naziv;
	}
	public String getMaterijali() {
		return Materijali;
	}
	public void setMaterijali(String materijali) {
		Materijali = materijali;
	}
	public String getKamere() {
		return Kamere;
	}
	public void setKamere(String kamere) {
		Kamere = kamere;
	}
	public String getObjekti() {
		return Objekti;
	}
	public void setObjekti(String objekti) {
		Objekti = objekti;
	}
	public String getNaziv() {
		return Naziv;
	}
	public void setNaziv(String naziv) {
		Naziv = naziv;
	} 


}
