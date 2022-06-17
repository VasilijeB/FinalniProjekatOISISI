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
	public String getNamene() {
		return Namene;
	}
	public void setNamene(String namene) {
		Namene = namene;
	}
	public Color getBoje() {
		return boje;
	}
	public void setBoje(Color boje) {
		this.boje = boje;
	}
	@Override
	public String toString() {
		return  "Cetkica: "+Naziv + " "+ Namene;
	}
	

}
