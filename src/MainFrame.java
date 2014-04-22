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
            "vis kontrakter","Statistikk","BoligBrowse"};

    private static final int REG_UTLEIER = 0;
    private static final int UTLEIER = 1;


    private Personregister register;


    public MainFrame(Personregister register){
        super("Bolig G* Browse");
        setLayout(new BorderLayout());

        this.register = register;


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
        }else if(e.getSource()  == knapp[UTLEIER]){
            vinduer.add(new UtleierOversiktPANEL(register, this), "Oversikt");
            visPanel("Oversikt");
        }


    }
}
