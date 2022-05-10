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
	

}
