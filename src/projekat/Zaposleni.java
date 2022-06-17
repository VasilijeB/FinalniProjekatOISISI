package projekat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Zaposleni {
	private String Ime;
	private String Prezime;
	private String Jmbg;
	private Date Datumrodjenja;
	private String Email;
	private Adresa adrStanovanja;
	private List<Softver> Softveri=new ArrayList<>();
	enum radnoMesto {modelator, riger, animator, ilustrator};
	private radnoMesto radnoM;
	public Zaposleni(String ime, String prezime, String jmbg, Date datumrodjenja, String email, Adresa adrStanovanja,
			List<Softver> softveri, radnoMesto radnoM) {
		super();
		Ime = ime;
		Prezime = prezime;
		Jmbg = jmbg;
		Datumrodjenja = datumrodjenja;
		Email = email;
		this.adrStanovanja = adrStanovanja;
		Softveri = softveri;
		this.radnoM = radnoM;
	}
	public String getIme() {
		return Ime;
	}
	public void setIme(String ime) {
		Ime = ime;
	}
	public String getPrezime() {
		return Prezime;
	}
	public void setPrezime(String prezime) {
		Prezime = prezime;
	}
	public String getJmbg() {
		return Jmbg;
	}
	public void setJmbg(String jmbg) {
		Jmbg = jmbg;
	}
	public Date getDatumrodjenja() {
		return Datumrodjenja;
	}
	public void setDatumrodjenja(Date datumrodjenja) {
		Datumrodjenja = datumrodjenja;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Adresa getAdrStanovanja() {
		return adrStanovanja;
	}
	public void setAdrStanovanja(Adresa adrStanovanja) {
		this.adrStanovanja = adrStanovanja;
	}
	public List<Softver> getSoftveri() {
		return Softveri;
	}
	public void setSoftveri(List<Softver> softveri) {
		Softveri = softveri;
	}
	public radnoMesto getRadnoM() {
		return radnoM;
	}
	public void setRadnoM(radnoMesto radnoM) {
		this.radnoM = radnoM;
	}

}
