package projekat;

import java.awt.Color;

public class Cetkica {
	private String Naziv;
	private String Namene;
	private Color boje;
	public Cetkica(String naziv, String namene, Color boje) {
		super();
		Naziv = naziv;
		Namene = namene;
		this.boje = boje;
	}
	public String getNaziv() {
		return Naziv;
	}
	public void setNaziv(String naziv) {
		Naziv = naziv;
	}
	

}
