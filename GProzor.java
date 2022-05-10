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
      
  

}
