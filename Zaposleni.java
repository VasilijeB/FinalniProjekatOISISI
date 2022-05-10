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

}
