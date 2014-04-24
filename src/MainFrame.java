import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Erlend on 16/04/14.
 */
public class MainFrame extends JFrame implements ActionListener {


    private JPanel mainboard;

    private JPanel vinduer;

    public static final String MAIN_BOARD = "-1";

    private JButton[] knapp;
    private String[] knappenavn = { "Registrer utleier","Vis Utleiere","Register Søker",
            "Vis Søkere","Registrer Bolig", "Vis Boliger",
            "vis kontrakter","Statistikk","BoligBrowse™"};

    private static final int REG_UTLEIER = 0;
    private static final int VIS_UTLEIER = 1;
    private static final int REG_SØKER = 2;
    private static final int VIS_SØKER = 3;
    private static final int REG_BOLIG = 4;
    private static final int VIS_BOLIG = 5;
    private static final int VIS_KONTRAKTER = 6;
    private static final int VIS_STATS = 7;
    private static final int VIS_BOLIGBROWSE = 8;


    private Personregister register;
    private Boligregister bregister;
    private Sokerregister sregister;
    private Leilighetregister legister;


    public MainFrame(Personregister register,Boligregister bregister,Sokerregister sregister,Leilighetregister legister){
        super("Bolig Browse™");
        setLayout(new BorderLayout());

        this.register = register;
        this.sregister = sregister;
        this.bregister = bregister;
        this.legister = legister;

        initialiser();

        vinduer = new JPanel(new CardLayout());
        vinduer.add(mainboard, MAIN_BOARD);

        add(vinduer, BorderLayout.CENTER);

        setVisible(true);
        pack();
    }

    public void initialiser(){

        mainboard = new JPanel(new GridLayout(3,3,5,5));


        knapp = new JButton[knappenavn.length];

        for(int i= 0 ; i < knappenavn.length;i++){

            knapp[i] = new JButton(knappenavn[i]);
            mainboard.add(knapp[i]);
            knapp[i].addActionListener(this);



        }


    }



    public void visPanel(String st){
        CardLayout cl = (CardLayout) vinduer.getLayout();
        cl.show(vinduer,st);
    }







    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == knapp[REG_UTLEIER]){
            vinduer.add(new RegistrerUtleierPANEL(register, this), "REG UTLEIER");
            visPanel("REG UTLEIER");
        }else if(e.getSource()  == knapp[VIS_UTLEIER]){
            vinduer.add(new UtleierOversiktPANEL(register, this), "Oversikt");
            visPanel("Oversikt");
        }
        else if(e.getSource()  == knapp[REG_SØKER]){
        vinduer.add(new RegistrerSokerPANEL(sregister, this), "REG SØKER");
        visPanel("REG SØKER");
        }
        else if(e.getSource()  == knapp[VIS_SØKER]){
        vinduer.add(new SokerOversiktPANEL(sregister, this), "OversiktSøker");
        visPanel("OversiktSøker");
        }
        else if(e.getSource()  == knapp[REG_BOLIG]){
        vinduer.add(new RegistrerBoligPANEL(register,bregister, this), "REG BOLIG");
        visPanel("REG BOLIG");
        }
        else if(e.getSource()  == knapp[VIS_BOLIG]){
        vinduer.add(new BoligOversiktPANEL(bregister,register,legister, this), "VIS BOLIG");
        visPanel("VIS BOLIG");
        }
        else if(e.getSource()  == knapp[VIS_KONTRAKTER]){
        vinduer.add(new UtleierOversiktPANEL(register, this), "Oversikt");
        visPanel("Oversikt");
        }
        else if(e.getSource()  == knapp[VIS_STATS]){
        vinduer.add(new UtleierOversiktPANEL(register, this), "Oversikt");
        visPanel("Oversikt");
        }
        else if(e.getSource()  == knapp[VIS_BOLIGBROWSE]){
        vinduer.add(new UtleierOversiktPANEL(register, this), "Oversikt");
        visPanel("Oversikt");
        }



    }
}
