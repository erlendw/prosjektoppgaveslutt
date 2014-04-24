import com.sun.codemodel.internal.JOp;

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

    //Felter og bokser som bare gjelder enebolig
    private JTextField[] eneboligfelt;
    private final String[] eneboligfeltnavn = {"TomtAreal","antallBad","antallEtasjer"};
    private JCheckBox[] eneboligbokser;
    private final String[] eneboligboksnavn = {"røyker","husdyr","balkong","terasse","TVinkludert","internetInkludert","strømInkludert","parkering","kjeller"};

    //felter og bokser som bare gjelder leilighet
    private JTextField[] leilighetfelt;
    private final String[] leilighetfeltnavn = {"Antall boder","Etasje"};
    private JCheckBox[] leilighetbokser;
    private final String[] leilighetboksnavn = {"røyker","husdyr","balkong","terasse","TVinkludert","internetInkludert","strømInkludert","parkering","kjeller","heis"};




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

    private final int EIER = 0;
    private final int ADRESSE = 1;
    private final int BESKRIVELSE = 2;
    private final int BOLIGNR = 3;
    private final int BOAREAL = 4;
    private final int ANTALLROM = 5;
    private final int BYGGÅR = 6;
    private final int PRIS = 7;
    private final int LEDIGFRA = 8;

    private final int RØYKER = 0;
    private final int HUSDYR = 1;
    private final int BALKONG = 2;
    private final int TERASSE = 3;
    private final int TV = 4;
    private final int INTERNET = 5;
    private final int STRØM = 6;
    private final int PARKERING = 7;
    private final int KJELLER = 8;

    private final int TOMTA = 0;
    private final int ANTBAD = 1;
    private final int ANTETG = 2;

    private JTextArea utskriftsområde;

    private JLabel overskrift;

    private JPanel feltpanel;
    private JPanel boligtypepanel;
    private JPanel overskriftpanel;
    private JPanel toppanel;

    private JPanel tomtpanel;
    private JPanel enebolig;
    private JPanel leilighet;
    private JPanel bydelpanel;
    private JPanel midtpanel;

    private JPanel bokspanel;
    private JPanel feltpanelEnebolig;
    private JPanel eneboligpanel;
    private JPanel leilighetpanel;
    private JPanel feltpanelLeilighet;
    private JPanel bokspanelLeilighet;

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
        eneboligbokser = new JCheckBox[eneboligboksnavn.length];
        eneboligfelt = new JTextField[eneboligfeltnavn.length];

        leilighetbokser = new JCheckBox[leilighetboksnavn.length];
        leilighetfelt = new JTextField[leilighetfeltnavn.length];

        overskrift = new JLabel("Registrer ny Bolig");
        overskrift.setVisible(true);

        //toppanel
        feltpanel = new JPanel(new GridLayout(3, 4, 5, 5));
        boligtypepanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        overskriftpanel= new JPanel(new FlowLayout(FlowLayout.CENTER));
        toppanel = new JPanel(new BorderLayout());

        //midtpanel
        bydelpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tomtpanel = new JPanel();

        enebolig = new JPanel();
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

        for (int i = 0; i < eneboligboksnavn.length; i++) {
            eneboligbokser[i] = new JCheckBox();
            eneboligbokser[i].setText(eneboligboksnavn[i]);
            eneboligbokser[i].setHorizontalAlignment(JCheckBox.CENTER);
        }
        for (int i = 0; i < leilighetboksnavn.length; i++) {
            leilighetbokser[i] = new JCheckBox();
            leilighetbokser[i].setText(leilighetboksnavn[i]);
            leilighetbokser[i].setHorizontalAlignment(JCheckBox.CENTER);
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

        overskriftpanel.add(overskrift);

        toppanel.add(feltpanel,BorderLayout.CENTER);
        toppanel.add(boligtypepanel,BorderLayout.PAGE_END);
        toppanel.add(overskriftpanel,BorderLayout.PAGE_START);

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
        isTom=true;
        isEnebolig=false;
        isLeilighet=false;
        return isTom;
    }
    public boolean visEneboligpanel(){
        midtpanel.removeAll();
        midtpanel.revalidate();
        midtpanel.repaint();
        eneboligpanel = new JPanel(new BorderLayout());
        eneboligpanel.setLayout(new BorderLayout());
        feltpanelEnebolig = new JPanel(new GridLayout(1,3,5,5));
        midtpanel.add(enebolig);
        midtpanel.add(bydelpanel, BorderLayout.PAGE_END);
        bokspanel = new JPanel(new GridLayout(3,3,5,5));
        for (int i = 0; i < eneboligboksnavn.length; i++) {
            bokspanel.add(eneboligbokser[i]);
        }
        for (int i = 0; i < eneboligfeltnavn.length; i++) {
            eneboligfelt[i] = new JTextField(10);
            eneboligfelt[i].setText(eneboligfeltnavn[i]);
            eneboligfelt[i].setHorizontalAlignment(JTextField.CENTER);
            feltpanelEnebolig.add(eneboligfelt[i]);
        }
        eneboligpanel.add(bokspanel, BorderLayout.CENTER);
        eneboligpanel.add(feltpanelEnebolig,BorderLayout.PAGE_END);
        midtpanel.add(eneboligpanel, BorderLayout.CENTER);
        isEnebolig=true;
        isTom=false;
        isLeilighet=false;
        return isEnebolig;


    }
    public boolean visLeilighetpanel(){
        midtpanel.removeAll();
        midtpanel.revalidate();
        midtpanel.repaint();
        leilighetpanel = new JPanel(new BorderLayout());
        leilighetpanel.setLayout(new BorderLayout());
        feltpanelLeilighet = new JPanel(new GridLayout(1,2,5,5));
        midtpanel.add(leilighet);
        midtpanel.add(bydelpanel, BorderLayout.PAGE_END);
        bokspanelLeilighet = new JPanel(new GridLayout(5,2,5,5));
        for (int i = 0; i < leilighetboksnavn.length; i++) {
            bokspanelLeilighet.add(leilighetbokser[i]);
        }
        for (int i = 0; i < leilighetfeltnavn.length; i++) {
            leilighetfelt[i] = new JTextField(10);
            leilighetfelt[i].setText(leilighetfeltnavn[i]);
            leilighetfelt[i].setHorizontalAlignment(JTextField.CENTER);
            feltpanelLeilighet.add(leilighetfelt[i]);
        }
        leilighetpanel.add(bokspanelLeilighet,BorderLayout.CENTER);
        leilighetpanel.add(feltpanelLeilighet,BorderLayout.PAGE_END);
        midtpanel.add(leilighetpanel,BorderLayout.CENTER);
        isLeilighet=true;
        isTom=false;
        isEnebolig=false;
        return isLeilighet;
    }
    public void registrerEnebolig(){
        String adresse = felt[ADRESSE].getText();
        int boareal = Integer.parseInt(felt[BOAREAL].getText());
        int antrom = Integer.parseInt(felt[ANTALLROM].getText());
        int byggår = Integer.parseInt(felt[BYGGÅR].getText());
        String beskrivelse = felt[BESKRIVELSE].getText();
        int pris = Integer.parseInt(felt[PRIS].getText());
        String ledig = felt[LEDIGFRA].getText();
        String bolignr = felt[BOLIGNR].getText();
        String pnr = felt[EIER].getText();
        Utleier utleier = pregister.get(pnr);
        boolean røyker = eneboligbokser[RØYKER].isSelected();
        boolean husdyr = eneboligbokser[HUSDYR].isSelected();
        boolean balkong = eneboligbokser[BALKONG].isSelected();
        boolean terasse = eneboligbokser[TERASSE].isSelected();
        boolean tv = eneboligbokser[TV].isSelected();
        boolean internet = eneboligbokser[INTERNET].isSelected();
        boolean strøm = eneboligbokser[STRØM].isSelected();
        boolean parkering = eneboligbokser[PARKERING].isSelected();
        boolean kjeller = eneboligbokser[KJELLER].isSelected();
        int antetg = Integer.parseInt(eneboligfelt[ANTETG].getText());
        double tomta = Double.parseDouble(eneboligfelt[TOMTA].getText());
        int antbad = Integer.parseInt(eneboligfelt[ANTBAD].getText());


        Enebolig enebolig = new Enebolig(adresse,boareal,antrom,byggår,beskrivelse,pris,ledig,bolignr,utleier,
                            røyker,husdyr,balkong,terasse,tv,internet,strøm,parkering,antetg,kjeller,tomta,antbad);
        bregister.put(bolignr,enebolig);
        System.out.println("Registrert");
    }
    public void registrerLeilighet(){
        System.out.println("Registrer leilighet(not yet supported)");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(isTom){
            if(e.getSource() == registrer){
                JOptionPane.showMessageDialog(null,"Venligst velg boligtype");
            }
            else if(e.getSource() == avbryt){
                parent.visPanel(MainFrame.MAIN_BOARD);
            }
        }
        else if(isEnebolig){
            if(e.getSource()==registrer){
                registrerEnebolig();
                parent.visPanel(MainFrame.MAIN_BOARD);
            }
            else if(e.getSource()==avbryt){
                parent.visPanel(MainFrame.MAIN_BOARD);
            }
        }
        else if(isLeilighet){
            if(e.getSource()==registrer){
                registrerLeilighet();
                parent.visPanel(MainFrame.MAIN_BOARD);
            }
            else if(e.getSource()==avbryt){
                parent.visPanel(MainFrame.MAIN_BOARD);
            }
        }
        else if(e.getSource() == registrer){
            JOptionPane.showMessageDialog(null,"Venligst velg boligtype");
        }
        else if(e.getSource()==avbryt) {
            parent.visPanel(MainFrame.MAIN_BOARD);
        }
        /*if(e.getSource() == registrer){
            System.out.println("Not yet supported");
            //registrer();

        }else if(e.getSource() == avbryt){
            parent.visPanel(MainFrame.MAIN_BOARD);
        }*/
    }
}
