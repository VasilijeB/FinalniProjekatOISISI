package projekat;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;





public class GProzor extends JFrame {
	
	  public GProzor() throws HeadlessException {
		  setTitle("Glavni Prozor");
		  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		  pack();
		  setSize(screenSize.width*3/4,screenSize.height*3/4);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       ad = new ImageIcon(GProzor.class.getResource("/resources/ad1.jpg"));
           ed = new ImageIcon(GProzor.class.getResource("/resources/ed1.jpg"));
           del = new ImageIcon(GProzor.class.getResource("/resources/del1.jpg"));
           toolbar.setSize(new Dimension(screenSize.width,screenSize.height/100));
	      this.populate();
	      setLocationRelativeTo(null); 
	      setVisible(true);
	      
	}
	  ImageIcon ad,ed,del;
	  JTabbedPane tabbedPane = new JTabbedPane();
	  JPanel cenpanel = new JPanel(); 
	  JMenuBar  meni=new JMenuBar();
	  JMenu file, edit,help,open;  
      JMenuItem neww, exit, editt, delte,about,zap,sof;  
      JToolBar toolbar=new JToolBar();
      
      JDialog dodajZ;
      JDialog izmeniZ=new JDialog(this,true);
      JDialog obrisiZ=new JDialog(this,true);
      
      JDialog dodajS=new JDialog(this,true);
      JDialog izmeniS=new JDialog(this,true);
      JDialog obrisiS=new JDialog(this,true);
      JTextField ime,prezime,jmbg,softv,email,adresa,radnom;  
      JLabel im=new JLabel("Ime"),pr=new JLabel("Prezime"),jmb=new JLabel("JMBG"),em=new JLabel("Email"),rad=new JLabel("Radno Mesto");
      
     public void populate() {
    	 ime=new JTextField(20);
    	 prezime=new JTextField(20);
    	 
    	 
    	 
    	  file=new JMenu("File");
    	  edit=new JMenu("Edit");
    	  help=new JMenu("Help");
    	  neww=new JMenuItem("New");
    	  open=new JMenu("Open");
    	  zap=new JMenuItem("Zaposleni");
    	  sof=new JMenuItem("Softver");
    	  open.add(zap);
    	  open.add(sof);
    	  exit=new JMenuItem("Exit");
    	  editt=new JMenuItem("Edit");
    	  delte=new JMenuItem("Delete");
    	  about=new JMenuItem("About");
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
    	  
    	exit.addActionListener(new 	ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	    	GProzor.this.dispose();
    	       
    	    }
    	});
    	
    	neww.addActionListener(new 	ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	    	
    	    	dodajZ=new JDialog();
    	    	dodajZ.setModal(true);
    	    	dodajZ.setLayout(new GridBagLayout());
    	    	dodajZ.setSize(500, 500);
    	    	dodajZ.add(im);
    	    	dodajZ.add(ime);
    	    	dodajZ.add(pr);
    	    	dodajZ.add(prezime);
    	    	dodajZ.setVisible(true);
    	       
    	    }
    	});
    	  
    	  JComponent panel1 = new JPanel();
    	  tabbedPane.addTab("Zaposleni", panel1);
    	  JComponent panel2 = new JPanel();
    	  tabbedPane.addTab("Softver", panel2);
    	  this.add(tabbedPane);
    	  

    	  
    	  JButton adact=new JButton(ad);
    	  JButton edact=new JButton(ed);
    	  JButton delact=new JButton(del);
   
    	  JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    	   JLabel datum = new JLabel();
    	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");  
    	   LocalDateTime now = LocalDateTime.now();  
    	   datum.setText(dtf.format(now));
    	   statusBar.add(datum);
    	   this.add(statusBar,BorderLayout.SOUTH);
    	

          toolbar.add(adact);  
          toolbar.add(edact); 
          toolbar.add(delact);
          this.add(toolbar,BorderLayout.NORTH);
          
    	  
    	
      }

     public void entiteti() {
    	 
     }
     
     public class SRenderer extends JLabel implements ListCellRenderer<Softver> {

 		@Override
 		public Component getListCellRendererComponent(JList<? extends Softver> list, Softver s, int index,
 				boolean isSelected, boolean cellHasFocus) {
 			ColorIcon ikonica = new ColorIcon(10, 10, s.getCetkice().getBoje());
 			setIcon(ikonica);
 			setText(s.toString());

 			return this;
 		}
     
      public static void  main(String[] args) {
  		new GProzor();
  	}


}
