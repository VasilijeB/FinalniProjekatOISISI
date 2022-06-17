package projekat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Zaposleni {
	private String Ime;
	private String Prezime;
	private String Jmbg;
	private LocalDate Datumrodjenja;
	private String Email;
	private Adresa adrStanovanja;
	private List<Softver> Softveri=new ArrayList<>();
	enum radnoMesto {modelator, riger, animator, ilustrator};
	private radnoMesto radnoM;
	public Zaposleni(String ime, String prezime, String jmbg, LocalDate datumrodjenja, String email, Adresa adrStanovanja) {
		super();
		Ime = ime;
		Prezime = prezime;
		Jmbg = jmbg;
		Datumrodjenja = datumrodjenja;
		Email = email;
		this.adrStanovanja = adrStanovanja;
		
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
	public LocalDate getDatumrodjenja() {
		return Datumrodjenja;
	}
	public void setDatumrodjenja(LocalDate datumrodjenja) {
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
	public void addSoftveri(Softver softveri) {
		Softveri.add(softveri);
	}
	public radnoMesto getRadnoM() {
		return radnoM;
	}
	public void setRadnoM(radnoMesto radnoM) {
		this.radnoM = radnoM;
	}

	@Override
	public String toString() {
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(Datumrodjenja.getDayOfMonth());
		stringBuilder.append(".");
		stringBuilder.append(Datumrodjenja.getMonth());
		stringBuilder.append(".");
		stringBuilder.append(Datumrodjenja.getYear());
		stringBuilder.append(".");
		String dat=stringBuilder.toString();
		return  Ime+" " +  Prezime +" " + Jmbg+" " +  dat
				+" "+  Email+" " + adrStanovanja.toString();
	}
}
