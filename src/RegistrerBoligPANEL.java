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
    private final String[] feltnavn = {"eiersFødselsnummer","adresse","beskrivelse","bolignummer","boareal","antallRom","byggeår","pris","ledigFra","TomtAreal","antallBad","antallEtasjer"};

    private JCheckBox[] bokser;
    private final String[] boksnavn = {"røyker","husdyr","balkong","terasse","TVinkludert","internetInkludert","strømInkludert","parkering","kjeller",""};

    private JComboBox<String> beliggenhet;
    private JComboBox<String> boligtype;

    private Person eier;

    private Boligregister bregister;
    private Personregister pregister;

    boolean isTom;
    boolean isEnebolig;
    boolean isLeilighet;

    String[] boligtypevalg = {"Velg boligtype","Enebolig","Leilighet"};
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

    private JTextArea utskriftsområde;

    private JPanel feltpanel;
    private JPanel boligtypepanel;
    private JPanel toppanel;

    private JPanel tomtpanel;
    private JPanel enebolig;
    private JPanel leilighet;
    private JPanel bydelpanel;
    private JPanel midtpanel;

    private JPanel knapppanel;
    private JPanel bunnpanel;

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

    }

    public void initialiser() {

        setLayout(new BorderLayout());

        utskriftsområde = new JTextArea();

        felt = new JTextField[feltnavn.length];
        bokser = new JCheckBox[boksnavn.length];

        //toppanel
        feltpanel = new JPanel(new GridLayout(3, 4, 5, 5));
        boligtypepanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        toppanel = new JPanel(new BorderLayout());

        //midtpanel
        bydelpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tomtpanel = new JPanel();

        enebolig = new JPanel();
        enebolig.setBackground(Color.yellow);
        leilighet = new JPanel();
        leilighet.setBackground(Color.blue);
        midtpanel = new JPanel(new BorderLayout());

        //bunnpanel
        knapppanel = new JPanel(new GridLayout(1,2,5,5));
        bunnpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        for (int i = 0; i < feltnavn.length; i++) {
            felt[i] = new JTextField(10);
            felt[i].setText(feltnavn[i]);
            felt[i].setHorizontalAlignment(JTextField.CENTER);
        }

        for (int i = 0; i < boksnavn.length; i++) {
            bokser[i] = new JCheckBox();
            bokser[i].setText(boksnavn[i]);
            bokser[i].setHorizontalAlignment(JCheckBox.CENTER);
        }
        beliggenhet = new JComboBox<String>(bydeler);
        boligtype = new JComboBox<String>(boligtypevalg);

        boligtype.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> boligtype = (JComboBox) e.getSource();
                int n = boligtype.getSelectedIndex();
                String boligtypevalg = boligtype.getItemAt(n);
                if(n == 1){
                    visEneboligpanel();

                }
                else if(n == 2){

                    visLeilighetpanel();
                }
                else if(n==0){
                    visTomtpanel();
                }
            }
        });
        registrer = new JButton("Registrer");
        avbryt = new JButton("Avbryt");


        registrer.addActionListener(this);
        avbryt.addActionListener(this);


    }

    public void lagGUI() {
        for (int i = 0; i < felt.length; i++) {
            feltpanel.add(felt[i]);
        }
        //legger til kombobokser
        boligtypepanel.add(boligtype);
        bydelpanel.add(beliggenhet);

        knapppanel.add(registrer);
        knapppanel.add(avbryt);

        toppanel.add(feltpanel,BorderLayout.CENTER);
        toppanel.add(boligtypepanel,BorderLayout.PAGE_END);

        //midtpanel.add(tomtpanel, BorderLayout.CENTER);
        midtpanel.add(bydelpanel, BorderLayout.PAGE_END);


        bunnpanel.add(knapppanel);




        add(toppanel, BorderLayout.PAGE_START);
        add(midtpanel,BorderLayout.CENTER);
        add(bunnpanel,BorderLayout.PAGE_END);


    }
   /* public boolean tomtErValgt(){
        boolean b = true;
        visTomtpanel(b);
        return true;
    }
    public boolean eneboligErValgt(){

    }
    public boolean leiligetErValgt(){

    }*/
    public boolean visTomtpanel(){
        midtpanel.removeAll();
        midtpanel.revalidate();
        midtpanel.repaint();
        tomtpanel.add(utskriftsområde);
        midtpanel.add(bydelpanel, BorderLayout.PAGE_END);
        isTom=true;
        isEnebolig=false;
        isLeilighet=false;
        return isTom;
    }
    public boolean visEneboligpanel(){
        midtpanel.removeAll();
        midtpanel.revalidate();
        midtpanel.repaint();
        midtpanel.add(enebolig);
        midtpanel.add(bydelpanel, BorderLayout.PAGE_END);
        isEnebolig=true;
        isTom=false;
        isLeilighet=false;
        return isEnebolig;
    }
    public boolean visLeilighetpanel(){
        midtpanel.removeAll();
        midtpanel.revalidate();
        midtpanel.repaint();
        midtpanel.add(leilighet);
        midtpanel.add(bydelpanel, BorderLayout.PAGE_END);
        isLeilighet=true;
        isTom=false;
        isEnebolig=false;
        return isLeilighet;
    }
    public void registrerEnebolig(){
        System.out.println("Registrer enebolig(not yet supported)");
    }
    public void registrerLeilighet(){
        System.out.println("Registrer leilighet(not yet supported)");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(isTom){
            if(e.getSource() == registrer){
                System.out.println("Venligst velg boligtype");
            }
            else if(e.getSource() == avbryt){
                parent.visPanel(MainFrame.MAIN_BOARD);
            }
        }
        else if(isEnebolig){
            if(e.getSource()==registrer){
                registrerEnebolig();
            }
            else if(e.getSource()==avbryt){
                parent.visPanel(MainFrame.MAIN_BOARD);
            }
        }
        else if(isLeilighet){
            if(e.getSource()==registrer){
                registrerLeilighet();
            }
            else if(e.getSource()==avbryt){
                parent.visPanel(MainFrame.MAIN_BOARD);
            }
        }
        /*if(e.getSource() == registrer){
            System.out.println("Not yet supported");
            //registrer();

        }else if(e.getSource() == avbryt){
            parent.visPanel(MainFrame.MAIN_BOARD);
        }*/
    }
}
