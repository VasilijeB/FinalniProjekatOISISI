package projekat;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import projekat.Zaposleni.radnoMesto;

public class GProzor extends JFrame {

	public GProzor() throws HeadlessException {

		setTitle("Glavni Prozor");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// kreira slicice
		ad = new ImageIcon(GProzor.class.getResource("/resources/ad1.jpg"));
		ed = new ImageIcon(GProzor.class.getResource("/resources/ed1.jpg"));
		del = new ImageIcon(GProzor.class.getResource("/resources/del1.jpg"));
		toolbar.setSize(new Dimension(screenSize.width, screenSize.height / 100));
		softverL.setCellRenderer(new SRenderer());
		
		this.populate();

		populateZaposleni();
		populateSoftver();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	ImageIcon ad, ed, del;
	JTabbedPane tabbedPane = new JTabbedPane();

	JComponent panel1 = new JPanel();
	JComponent panel2 = new JPanel();
	JPanel cenpanel = new JPanel();
	JMenuBar meni = new JMenuBar();
	JMenu file, edit, help, open;
	JMenuItem neww, exit, editt, delte, about, zap, sof;
	JToolBar toolbar = new JToolBar();
	
	JRadioButton mod=new JRadioButton("modelator"),anim=new JRadioButton("animator"),il=new JRadioButton("ilustrator"),rig=new JRadioButton("riger");
    ButtonGroup mesta=new ButtonGroup();

    
	JColorChooser izaberiBoju = new JColorChooser();
	JDialog dodajZ;
	JDialog dodSof;
	
	
	JTextField ime, prezime, jmbg, email, ulica, broj, grad;
	JTextField nS, nC, nR, kamere, materijali, objektiv, namena, fajl, alat;
	Color colorCetkica;
	DateFormat date = new SimpleDateFormat("dd.MM.yyyy.");
	JFormattedTextField datum = new JFormattedTextField(date);

	
	JDialog obrisi = new JDialog();
	JLabel im = new JLabel("Ime", JLabel.TRAILING), pr = new JLabel("Prezime", JLabel.TRAILING),
			jmb = new JLabel("JMBG", JLabel.TRAILING), em = new JLabel("Email", JLabel.TRAILING),
			dat = new JLabel("Datum rodjenja", JLabel.TRAILING);
	JLabel ulical = new JLabel("Ulica", JLabel.TRAILING), brojl = new JLabel("Broj", JLabel.TRAILING),
			gradl = new JLabel("Grad", JLabel.TRAILING);

	JLabel nazS = new JLabel("Naziv", JLabel.TRAILING), ff = new JLabel("Fajl Format", JLabel.TRAILING),
			al = new JLabel("Alati za animaciju", JLabel.TRAILING), nazC = new JLabel("Naziv Cetkice", JLabel.TRAILING),
			nam = new JLabel("Namena", JLabel.TRAILING);
	JLabel nazR = new JLabel("Naziv Rendera", JLabel.TRAILING), mat = new JLabel("Materijali", JLabel.TRAILING),
			kam = new JLabel("Kamere", JLabel.TRAILING), obj = new JLabel("Objektiv", JLabel.TRAILING);

	
	List<Zaposleni> zaposleni = new ArrayList<Zaposleni>();
	DefaultListModel modelZ = new DefaultListModel();
	JList zaposleniL = new JList(modelZ);
	List<Softver> softveri = new ArrayList<Softver>();
	DefaultListModel modelS = new DefaultListModel();
	JList softverL = new JList(modelS);
	
	// https://stackoverflow.com/questions/13843325/display-items-in-jlist

	public void populate() {
		
		
		file = new JMenu("File");
		edit = new JMenu("Edit");
		help = new JMenu("Help");
		neww = new JMenuItem("New");
		open = new JMenu("Open");
		zap = new JMenuItem("Zaposleni");
		sof = new JMenuItem("Softver");
		open.add(zap);
		open.add(sof);
		exit = new JMenuItem("Exit");
		editt = new JMenuItem("Edit");
		delte = new JMenuItem("Delete");
		about = new JMenuItem("About");
		file.add(neww);
		file.add(open);
		file.add(exit);
		edit.add(editt);
		edit.add(delte);
		help.add(about);
		meni.add(file);
		meni.add(edit);
		meni.add(help);
		this.setJMenuBar(meni);

		
		JLabel brisanje = new JLabel("Klikom na OK cete obrisati izabranu stavku!");
		
		JPanel dugmici = new JPanel();
		
		obrisi.setSize(500, 500);

		JButton okBrisi = new JButton("OK");
		JButton otkaziBrisanje = new JButton("Cancel");

		zap.addActionListener(ae -> {
			tabbedPane.setSelectedComponent(panel1);
		});
		sof.addActionListener(ae -> {
			tabbedPane.setSelectedComponent(panel2);
		});
		
		about.addActionListener(ae -> {
			JDialog oNama = new JDialog();
			oNama.setSize(500, 500);
			JLabel opis = new JLabel("<html>Grupa studenata koja je radila projekat studira na Fakultetu Tehnickih Nauka"
					+ " u Novom Sadu. Grupu cine Vasilije Blagojevic, Lazar Isailovic, Lidija Nikolic i Anabela Stosic."
					+ " Svi su kreativni i planiraju da se zaposle u gejming ili filmskoj industriji.</html>");
			oNama.add(opis, BorderLayout.NORTH);
			oNama.setVisible(true);
		});
		
		okBrisi.addActionListener(ae -> {
			if (!zaposleniL.isSelectionEmpty()) {
				Zaposleni z = (Zaposleni) zaposleniL.getSelectedValue();
				obrisiZ(z);

			}
			if (!softverL.isSelectionEmpty()) {
				Softver s = (Softver) softverL.getSelectedValue();
				obrisiS(s);

			}
			obrisi.dispose();

		});

		
		otkaziBrisanje.addActionListener(ae -> {
			obrisi.dispose();

		});
		
		dugmici.add(okBrisi);
		dugmici.add(otkaziBrisanje);
		obrisi.add(brisanje, BorderLayout.CENTER);
		obrisi.add(dugmici, BorderLayout.SOUTH);
		
		editt.addActionListener(ae -> {
			if (!zaposleniL.isSelectionEmpty()) {
				Zaposleni zaposl = (Zaposleni) zaposleniL.getSelectedValue();
				ime.setText(zaposl.getIme());
				prezime.setText(zaposl.getPrezime());
				email.setText(zaposl.getEmail());
				jmbg.setText(zaposl.getJmbg());
				DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
				String strDate = dateFormat.format(zaposl.getDatumrodjenja());
				datum.setText(strDate);
				broj.setText(zaposl.getAdrStanovanja().getBroj());
				grad.setText(zaposl.getAdrStanovanja().getGrad());
				ulica.setText(zaposl.getAdrStanovanja().getGrad());
				
			
				String rad=zaposl.getRadnoM().name();
				if(rad.equals("modelator"))mod.setSelected(true);
				else if(rad.equals("animator"))anim.setSelected(true);
				else if(rad.equals("riger"))rig.setSelected(true);
				else il.setSelected(true);
		
				
				dodajZ.setVisible(true);
			}
			if (!softverL.isSelectionEmpty()) {
				Softver s = (Softver) softverL.getSelectedValue();
				nS.setText(s.getNaziv());
				nC.setText(s.getCetkice().getNaziv());
				nR.setText(s.getRender().getNaziv());
				kamere.setText(s.getRender().getKamere());
				materijali.setText(s.getRender().getMaterijali());
				objektiv.setText(s.getRender().getObjekti());
				namena.setText(s.getCetkice().getNamene());
				fajl.setText(s.getFormati());
				alat.setText(s.getAlat());
				dodSof.setVisible(true);
			}
		});

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GProzor.this.dispose();

			}
		});
		
		delte.addActionListener(ae -> {
			obrisi.setVisible(true);

		});

		neww.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dodajZ.setVisible(true);
				dodSof.setVisible(true);

			}
		});
		
		panel1.add(zaposleniL);
		tabbedPane.addTab("Zaposleni", panel1);

		panel2.add(softverL);
		tabbedPane.addTab("Softveri", panel2);

		this.add(tabbedPane);
		ImageIcon img = new ImageIcon("jaa");
		img.paintIcon(dugmici, getGraphics(), EXIT_ON_CLOSE, ABORT);

		
		JButton adact = new JButton(ad);
		JButton edact = new JButton(ed);
		JButton delact = new JButton(del);
		
		JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel datum1 = new JLabel();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		LocalDateTime now = LocalDateTime.now();
		datum1.setText(dtf.format(now));
		statusBar.add(datum1);
		this.add(statusBar, BorderLayout.SOUTH);

		adact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dodajZ.setVisible(true);
				dodSof.setVisible(true);

			}
		});
		
		delact.addActionListener(ae -> {
			obrisi.setVisible(true);
		});
		
		
		edact.addActionListener(ae -> {
			if (!zaposleniL.isSelectionEmpty()) {
				Zaposleni zaposl = (Zaposleni) zaposleniL.getSelectedValue();
				ime.setText(zaposl.getIme());
				prezime.setText(zaposl.getPrezime());
				email.setText(zaposl.getEmail());
				jmbg.setText(zaposl.getJmbg());
				DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
				String strDate = dateFormat.format(zaposl.getDatumrodjenja());
				datum.setText(strDate);
				broj.setText(zaposl.getAdrStanovanja().getBroj());
				grad.setText(zaposl.getAdrStanovanja().getGrad());
				ulica.setText(zaposl.getAdrStanovanja().getGrad());
				

				String rad=zaposl.getRadnoM().name();
				if(rad.equals("modelator"))mod.setSelected(true);
				else if(rad.equals("animator"))anim.setSelected(true);
				else if(rad.equals("riger"))rig.setSelected(true);
				else il.setSelected(true);

				
				dodajZ.setVisible(true);
			}
			if (!softverL.isSelectionEmpty()) {
				Softver s = (Softver) softverL.getSelectedValue();
				nS.setText(s.getNaziv());
				nC.setText(s.getCetkice().getNaziv());
				nR.setText(s.getRender().getNaziv());
				kamere.setText(s.getRender().getKamere());
				materijali.setText(s.getRender().getMaterijali());
				objektiv.setText(s.getRender().getObjekti());
				namena.setText(s.getCetkice().getNamene());
				fajl.setText(s.getFormati());
				alat.setText(s.getAlat());
				dodSof.setVisible(true);
			}

		});
		toolbar.add(adact);
		toolbar.add(edact);
		toolbar.add(delact);
		this.add(toolbar, BorderLayout.NORTH);
	}
	
	public void clearFields() {
		
		
		ime.setText("");
		prezime.setText("");
		jmbg.setText("");
		email.setText("");
		datum.setText("");
		ulica.setText("");
		broj.setText("");
		grad.setText("");
		nS.setText("");
		nC.setText("");
		nR.setText("");
		kamere.setText("");
		materijali.setText("");
		objektiv.setText("");
		namena.setText("");
		fajl.setText("");
		alat.setText("");

	}

	public void populateZaposleni() {
		
		// https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/SpringFormProject/src/layout/SpringForm.java
		
		dodajZ = new JDialog();
		dodajZ.setModal(true);
		dodajZ.setSize(500, 500);
		JPanel p12 = new JPanel(new SpringLayout()), p2 = new JPanel();
		JButton ok = new JButton("OK");
		JButton can = new JButton("Cancel");
		ime = new JTextField(15);
		prezime = new JTextField(15);
		jmbg = new JTextField(13);
		email = new JTextField(20);
		
		// https://stackoverflow.com/questions/13927650/how-to-take-date-in-text-field
		
		DateFormat df = new SimpleDateFormat("dd.mm.yyyy.");
		datum = new JFormattedTextField(df);
		ulica = new JTextField(15);
		broj = new JTextField(10);
		grad = new JTextField(15);
		jmbg.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
				JDialog error = new JDialog();
				error.setSize(500, 500);
				error.setModal(true);
				JLabel lab = new JLabel("Vec postoji osoba sa unetim JMBG-om!");
				lab.setBackground(Color.red);
				error.add(lab, BorderLayout.CENTER);
				String naziv = jmbg.getText();
				for (Zaposleni z : zaposleni) {
					if (z.getJmbg().equals(naziv)) {
						if (zaposleniL.isSelectionEmpty()) {
							error.setVisible(true);
							dodajZ.dispose();

						}

					}
				}

			}

		});
		p12.add(im);
		im.setLabelFor(ime);
		p12.add(ime);
		p12.add(pr);
		pr.setLabelFor(prezime);
		p12.add(prezime);
		p12.add(jmb);
		jmb.setLabelFor(jmbg);
		p12.add(jmbg);
		p12.add(dat);
		dat.setLabelFor(datum);
		p12.add(datum);
		p12.add(em);
		em.setLabelFor(email);
		p12.add(email);
		p12.add(ulical);
		ulical.setLabelFor(ulica);
		p12.add(ulica);
		p12.add(brojl);
		brojl.setLabelFor(broj);
		p12.add(broj);
		p12.add(gradl);
		gradl.setLabelFor(grad);
		p12.add(grad);
		p2.add(ok);
		p2.add(can);
		

		mesta.add(mod);
      	mesta.add(rig);
      	mesta.add(anim);
      	mesta.add(il);
      	
      	JLabel radnom=new JLabel("Radno mesto");
    	JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(2,2));
    	p12.add(radnom);
    	radioPanel.add(mod);
    	radioPanel.add(rig);
    	radioPanel.add(anim);
    	radioPanel.add(il);
    	p12.add(radioPanel);
    	dodajZ.add(p12);
    	dodajZ.add(p2,BorderLayout.SOUTH);
    	
    	new SpringUtilities().makeCompactGrid(p12,
                9, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6); 

    	
    	

		ok.addActionListener(ae -> {
			if (!zaposleniL.isSelectionEmpty()) {
				izmeniZ((Zaposleni) zaposleniL.getSelectedValue());

			} else {
				dodajZ();
			}
			dodajZ.dispose();
		});

		can.addActionListener(ae -> {
			dodajZ.dispose();
			zaposleniL.clearSelection();
			clearFields();
		});
	}

	public void populateSoftver() {
		dodSof = new JDialog();
		dodSof.setModal(true);
		dodSof.setSize(500, 500);
		JPanel p1 = new JPanel(new SpringLayout()), p2 = new JPanel();
		JButton ok = new JButton("OK");
		JButton can = new JButton("Cancel");
		nS = new JTextField(15);
		nC = new JTextField(15);
		nR = new JTextField(13);
		kamere = new JTextField(20);
		materijali = new JTextField(15);
		objektiv = new JTextField(10);
		namena = new JTextField(15);
		fajl = new JTextField(15);
		alat = new JTextField(15);
		p1.add(nazS);
		nazS.setLabelFor(nS);
		p1.add(nS);
		p1.add(ff);
		ff.setLabelFor(fajl);
		p1.add(fajl);
		p1.add(al);
		al.setLabelFor(alat);
		p1.add(alat);
		p1.add(nazC);
		nazC.setLabelFor(nC);
		p1.add(nC);
		p1.add(nam);
		nam.setLabelFor(namena);
		p1.add(namena);
		p1.add(nazR);
		nazR.setLabelFor(nR);
		p1.add(nR);
		p1.add(obj);
		obj.setLabelFor(objektiv);
		p1.add(objektiv);
		p1.add(kam);
		kam.setLabelFor(kamere);
		p1.add(kamere);
		p1.add(mat);
		mat.setLabelFor(materijali);
		p1.add(materijali);
		p2.add(ok);
		p2.add(can);
		dodSof.add(p1);
		dodSof.add(p2, BorderLayout.SOUTH);

		nS.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
				JDialog error = new JDialog();
				error.setSize(500, 500);
				error.setModal(true);
				JLabel lab = new JLabel("Vec postoji softver sa unetim imenom!");
				lab.setBackground(Color.red);
				error.add(lab, BorderLayout.CENTER);
				String naziv = nS.getText();
				for (Softver s : softveri) {
					if (s.getNaziv().equals(naziv)) {
						if (softverL.isSelectionEmpty()) {
							error.setVisible(true);
							dodSof.dispose();

						}

					}
				}

			}

		});
		new SpringUtilities().makeCompactGrid(p1, 9, 2, // rows, cols
				6, 6, // initX, initY
				6, 6);
		
		ok.addActionListener(ae -> {
			if (!softverL.isSelectionEmpty()) {
				izmeniS((Softver) softverL.getSelectedValue());
			} else {
				dodajS();
			}
			dodSof.dispose();

		});
		
		can.addActionListener(ae -> {
			dodSof.dispose();
			softverL.clearSelection();
			clearFields();
		});

	}
	

	public void dodajZ() {
		Adresa a = new Adresa(broj.getText(), ulica.getText(), grad.getText());
		String dat = datum.getText();
		int g = Integer.parseInt(dat.substring(6, 10));
		int m = Integer.parseInt(dat.substring(3, 5));
		int d = Integer.parseInt(dat.substring(0, 2));
		LocalDate dat1 = LocalDate.of(g, m, d);
		Zaposleni z = new Zaposleni(ime.getText(), prezime.getText(), jmbg.getText(), dat1, email.getText(), a);
		zaposleni.add(z);
		modelZ.addElement(z);
		

		if(mod.isSelected()) {
			z.setRadnoM(radnoMesto.modelator);
		}else if(rig.isSelected()) {
			z.setRadnoM(radnoMesto.riger);
		}else if(anim.isSelected()) {
			z.setRadnoM(radnoMesto.animator);
		}else z.setRadnoM(radnoMesto.ilustrator);

		
		clearFields();
		tabbedPane.setSelectedComponent(panel1);
	}

	public void dodajS() {
		Color boja = izaberiBoju.showDialog(dodSof, "Izaberi boju cetkice", colorCetkica);
		Cetkica cetka = new Cetkica(nS.getText(), namena.getText(), boja);
		Render ren = new Render(materijali.getText(), kamere.getText(), objektiv.getText(), nR.getText());
		Softver s = new Softver(nS.getText(), cetka, alat.getText(), fajl.getText(), ren);
		softveri.add(s);
		modelS.addElement(s);
		clearFields();
		tabbedPane.setSelectedComponent(panel2);
	}
	
	public void izmeniZ(Zaposleni z) {
		Zaposleni izmena = zaposleni.get(zaposleni.indexOf(z));
		izmena.setIme(ime.getText());
		izmena.setPrezime(prezime.getText());
		izmena.setJmbg(jmbg.getText());
		izmena.setEmail(email.getText());
		Adresa a = new Adresa(broj.getText(), ulica.getText(), grad.getText());
		String dat = datum.getText();
		int g = Integer.parseInt(dat.substring(6, 10));
		int m = Integer.parseInt(dat.substring(3, 5));
		int d = Integer.parseInt(dat.substring(0, 2));
		LocalDate dat1 = LocalDate.of(g, m, d);
		izmena.setDatumrodjenja(dat1);
		izmena.setAdrStanovanja(a);
		int i1 = zaposleni.indexOf(z);
		int i2 = modelZ.indexOf(z);
		zaposleni.set(i1, izmena);
		modelZ.setElementAt(izmena, i2);
		zaposleniL.clearSelection();
		

		if(mod.isSelected()) {
			z.setRadnoM(radnoMesto.modelator);
		}else if(rig.isSelected()) {
			z.setRadnoM(radnoMesto.riger);
		}else if(anim.isSelected()) {
			z.setRadnoM(radnoMesto.animator);
		}else z.setRadnoM(radnoMesto.ilustrator);

		
		clearFields();
		tabbedPane.setSelectedComponent(panel1);
	}
	
	public void izmeniS(Softver s) {
		Softver izmena = softveri.get(softveri.indexOf(s));
		Color boja = izaberiBoju.showDialog(dodSof, "Izaberi boju cetkice", izmena.getCetkice().getBoje());
		izmena.setCetkice(new Cetkica(nS.getText(), namena.getText(), boja));
		izmena.setRender(new Render(materijali.getText(), kamere.getText(), objektiv.getText(), nR.getText()));
		izmena.setAlat(alat.getText());
		izmena.setFormati(fajl.getText());
		izmena.setNaziv(nS.getText());
		int i1 = softveri.indexOf(s);
		int i2 = modelS.indexOf(s);
		softveri.set(i1, izmena);
		modelS.setElementAt(izmena, i2);
		softverL.clearSelection();
		clearFields();
		tabbedPane.setSelectedComponent(panel2);

	}
	
	public void obrisiZ(Zaposleni z) {
		zaposleni.remove(z);
		modelZ.removeElement(z);
		tabbedPane.setSelectedComponent(panel1);

	}
	
	public void obrisiS(Softver s) {
		softveri.remove(s);
		modelS.removeElement(s);
		tabbedPane.setSelectedComponent(panel2);

	}

	// https://www.codejava.net/java-se/swing/jlist-custom-renderer-example
	
	public class SRenderer extends JLabel implements ListCellRenderer<Softver> {

		@Override
		public Component getListCellRendererComponent(JList<? extends Softver> list, Softver s, int index,
				boolean isSelected, boolean cellHasFocus) {
			ColorIcon ikonica = new ColorIcon(10, 10, s.getCetkice().getBoje());
			setIcon(ikonica);
			setText(s.toString());
			return this;
		}

	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GProzor();
			}
		});

	}

}
