import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by Erlend on 22/04/14.
 */
public class RegistrerBoligPANEL extends JPanel implements ActionListener {
    private JTextField[] felt;
    private final String[] feltnavn = {"eiersFødselsnummer","adresse","beskrivelse","bolignummer","boareal","antallRom","byggeår","pris","ledigFra"};

    private JCheckBox[] bokser;
    private final String[] boksnavn = {"røyker","husdyr","balkong","terasse","TVinkludert","internetInkludert","strømInkludert","parkering"};

    private JComboBox<String> beliggenhet;

    private Person eier;

    private Boligregister bregister;
    private Personregister pregister;

    String [] bydeler = { "Velg bydel", "Alna", "Bjerke", "Frogner", "Gamle Oslo", "Grorud",
            "Grünerløkka", "Nordre Aker", "Nordstrand", "Sagene", "St. Hanshaugen",
            "Stovner", "Søndre Nordstrand", "Ullern", "Vestre Aker", "Østensjø"};

    private final int ADRESSE = 0;
    private final int BOAREAL = 1;
    private final int ANTALLROM = 2;
    private final int BYGGEÅR = 3;
    private final int BESKRIVELSE = 4;
    private final int PRIS = 5;
    private final int LEDIGFRA = 6;
    private final int BOLIGNR = 7;
    private final int EIER = 8;

    private JPanel feltpanel;
    private JPanel knapppanel;
    private JPanel bokspanel;

    private JButton registrer;
    private JButton avbryt;

    private MainFrame parent;

    public RegistrerBoligPANEL(Personregister pregister,Boligregister bregister, MainFrame parent) {
        super(new BorderLayout());
        this.pregister = pregister;
        this.bregister = bregister;
        this.parent = parent;
        initialiser();
        lagGUI();

        add(feltpanel, BorderLayout.PAGE_START);
        add(knapppanel, BorderLayout.PAGE_END);
        add(bokspanel,BorderLayout.CENTER);
    }

    public void initialiser() {

        feltpanel = new JPanel(new GridLayout(3, 3, 5, 5));
        bokspanel = new JPanel(new GridLayout(2,4));
        knapppanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        felt = new JTextField[feltnavn.length];
        bokser = new JCheckBox[boksnavn.length];

        for (int i = 0; i < feltnavn.length; i++) {
            felt[i] = new JTextField(10);
            felt[i].setText(feltnavn[i]);
            felt[i].setHorizontalAlignment(JTextField.CENTER);
        }

        for (int i = 0; i < boksnavn.length; i++) {
            bokser[i] = new JCheckBox();
            bokser[i].setText(feltnavn[i]);
            bokser[i].setHorizontalAlignment(JCheckBox.CENTER);
        }
        beliggenhet = new JComboBox<String>(bydeler);
        registrer = new JButton("Registrer");
        avbryt = new JButton("Avbryt");

        registrer.addActionListener(this);
        avbryt.addActionListener(this);


    }

    public void lagGUI() {
        for (int i = 0; i < felt.length; i++) {
            feltpanel.add(felt[i]);
        }
        for(int i = 0; i<bokser.length; i++){
            bokspanel.add(bokser[i]);
        }
        bokspanel.add(beliggenhet);
        knapppanel.add(registrer);
        knapppanel.add(avbryt);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == registrer){
            System.out.println("Not yet supported");
            //registrer();

        }else if(e.getSource() == avbryt){
            parent.visPanel(MainFrame.MAIN_BOARD);
        }
    }
}
