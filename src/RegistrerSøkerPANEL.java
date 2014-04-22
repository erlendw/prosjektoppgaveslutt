import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Erlend on 22/04/14.
 */
public class RegistrerSøkerPANEL extends JPanel implements ActionListener {
    private JTextField[] felt;
    private final String[] feltnavn = {"Fødselsnummer", "Fornavn", "Etternavn", "Adresse","Mail","Telefonnr", "AntallPers", "Sivilstatus", "Yrke",
            "Arbeidsforhold/Studiested","MinAreal","MaxAreal","MinPris","MaxPris"};
    private JCheckBox boligtype;
    private JComboBox<String> område;

    private final int FØDSELSNUMMER = 0;
    private final int FORNAVN = 1;
    private final int ETTERNAVN = 2;
    private final int ADRESSE = 3;
    private final int MAIL = 4;
    private final int TELEFONNUMMER = 5;
    private final int ATPERS = 6;
    private final int SIVILSTATUS = 7;
    private final int YRKE = 8;
    private final int ARBFORHOLD = 9;
    private final int MINAREAL = 10;
    private final int MAXAREAL = 11;
    private final int MINPRIS = 12;
    private final int MAXPRIS = 13;

    private JPanel feltpanel;
    private JPanel knapppanel;


    private JButton registrer;
    private JButton avbryt;

    private Personregister register;
    private MainFrame parent;

    public RegistrerSøkerPANEL(Personregister register, MainFrame parent) {
        super(new BorderLayout());
        this.register = register;
        this.parent = parent;
        initialiser();
        lagGUI();

        add(feltpanel, BorderLayout.CENTER);
        add(knapppanel, BorderLayout.SOUTH);


    }

    public void initialiser() {

        feltpanel = new JPanel(new GridLayout(7, 1, 5, 5));
        knapppanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        felt = new JTextField[feltnavn.length];

        for (int i = 0; i < feltnavn.length; i++) {
            felt[i] = new JTextField(10);
            felt[i].setText(feltnavn[i]);
            felt[i].setHorizontalAlignment(JTextField.CENTER);

        }
        registrer = new JButton("Registrer");
        avbryt = new JButton("Avbryt");

        registrer.addActionListener(this);
        avbryt.addActionListener(this);

    }

    public void lagGUI() {



        for (int i = 0; i < felt.length; i++) {
            feltpanel.add(felt[i]);
        }
        knapppanel.add(registrer);
        knapppanel.add(avbryt);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == registrer){

            //registrer();

        }else if(e.getSource() == avbryt){
            parent.visPanel(MainFrame.MAIN_BOARD);
        }
    }
}