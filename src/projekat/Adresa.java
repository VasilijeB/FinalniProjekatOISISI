package projekat;

public class Adresa {
	private int Broj;
	private String Ulica;
	private String Grad;
	public Adresa(int broj, String ulica, String grad) {
		super();
		Broj = broj;
		Ulica = ulica;
		Grad = grad;
	}
	public int getBroj() {
		return Broj;
	}
	public void setBroj(int broj) {
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
	

}
