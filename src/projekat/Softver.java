package projekat;

import java.util.ArrayList;
import java.util.List;
//test
public class Softver {
	

	private String Naziv;
	private Cetkica cetkice;
	private String Alat;
	public String getNaziv() {
		return Naziv;
	}
	public void setNaziv(String naziv) {
		Naziv = naziv;
	}
	public Cetkica getCetkice() {
		return cetkice;
	}
	public void setCetkice(Cetkica cetkice) {
		this.cetkice = cetkice;
	}
	public String getAlat() {
		return Alat;
	}
	public void setAlat(String alat) {
		Alat = alat;
	}
	public String getFormati() {
		return Formati;
	}
	public void setFormati(String formati) {
		Formati = formati;
	}
	public Render getRender() {
		return render;
	}
	public void setRender(Render render) {
		this.render = render;
	}
	public Softver(String naziv, Cetkica cetkice, String alat, String formati, Render render) {
		super();
		Naziv = naziv;
		this.cetkice = cetkice;
		Alat = alat;
		Formati = formati;
		this.render = render;
	}
	private String Formati;
	private Render render;
	@Override
	public String toString() {
		return Naziv +" "+ Formati+" " + Alat+" "+cetkice.toString()+" " +render.toString();
	}

	

}