package projekat;

public class Adresa {
	private String Broj;
	private String Ulica;
	private String Grad;
	public Adresa(String broj, String ulica, String grad) {
		super();
		Broj = broj;
		Ulica = ulica;
		Grad = grad;
	}
	public String getBroj() {
		return Broj;
	}
	public void setBroj(String broj) {
		Broj = broj;
	}
	public String getUlica() {
		return Ulica;
	}
	public void setUlica(String ulica) {
		Ulica = ulica;
	}
	public String getGrad() {
		return Grad;
	}
	public void setGrad(String grad) {
		Grad = grad;
	}
	@Override
	public String toString() {
		return "Adresa: "+Ulica+" "+Broj+" "+Grad;
	}
	

}
