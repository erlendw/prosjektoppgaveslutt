import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Vegard
 * Date: 16.04.14
 * Time: 16:54
 * To change this template use File | Settings | File Templates.
 */
public class UtleierOversiktPANEL extends JPanel implements ActionListener, DocumentListener {
    private JPanel overskriftpanel;
    private JPanel tabellpanel;
    private JPanel søkpanel;
    private JPanel knapppanel;

    private JLabel overskrift;
    private JTextField søkfelt;
    private JTable tabell;
    private JScrollPane scroll;
    private Utleiermodell modell;
    private final String[] kolonner = {"Fødselsnummer", "Fornavn", "Etternavn", "Adresse", "Mail", "Telefonnummer", "Firma"};

    private JButton visInfo;
    private JButton endre;
    private JButton fjern;
    private JButton tilbake;

    private LinkedList<Utleier> utleierliste;
    private LinkedList<Utleier> temp;//listen som omfatter søket vårt


    private Personregister register;
    private MainFrame parent;

    public UtleierOversiktPANEL(Personregister register, MainFrame parent) {

        super(new BorderLayout());
        this.register = register;
        this.parent = parent;

        initialiser();
        lagGUI();



    }

    public void initialiser() {
        overskriftpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        søkpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tabellpanel = new JPanel(new BorderLayout());
        knapppanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        overskrift = new JLabel("Antall utleiere: " + register.size());
        søkfelt = new JTextField(10);
        tabell = new JTable();

        søkfelt.getDocument().addDocumentListener(this);

        Iterator it = register.entrySet().iterator();


        utleierliste = new LinkedList<Utleier>();



        for(Map.Entry<String,Person> entry : register.entrySet()) {
            utleierliste.add((Utleier) entry.getValue());

        }







        modell = new Utleiermodell(kolonner, utleierliste);

        tabell.setModel(modell);

        scroll = new JScrollPane(tabell);

        visInfo = new JButton("Vis info");
        endre = new JButton("Endre");
        fjern = new JButton("Slett");
        tilbake = new JButton("Tilbake");

        visInfo.addActionListener(this);
        endre.addActionListener(this);
        fjern.addActionListener(this);
        tilbake.addActionListener(this);




    }

    public void visAlle(){



        overskriftpanel.remove(overskrift);
        tabellpanel.remove(scroll);
        scroll.remove(tabell);
        revalidate();

        modell = new Utleiermodell(kolonner, utleierliste);

        tabell = new JTable(modell);

        scroll = new JScrollPane(tabell);
        tabellpanel.add(scroll, BorderLayout.CENTER);

        overskrift = new JLabel("Antall utleire: " + utleierliste.size());
        overskriftpanel.add(overskrift);

        revalidate();
        repaint();



    }


    public void lagGUI(){
        overskriftpanel.add(overskrift);

        søkpanel.add(søkfelt);






        tabellpanel.add(søkpanel, BorderLayout.PAGE_START);
        tabellpanel.add(scroll, BorderLayout.CENTER);


        knapppanel.add(visInfo);
        knapppanel.add(fjern);
        knapppanel.add(tilbake);
        knapppanel.add(endre);


        add(overskriftpanel, BorderLayout.PAGE_START);
        add(tabellpanel, BorderLayout.CENTER);
        add(knapppanel, BorderLayout.PAGE_END);







    }

    public void søk(){

        temp = new LinkedList<Utleier>();


        søkfelt.setBackground(Color.WHITE);


        String søk = søkfelt.getText().toUpperCase();

       try{

           if (søk.substring(0,søk.length() - 1).matches("[0-9]+") && søk.substring(søk.length() - 1).equals(".")){

               String fødselsnummer = søk.substring(0,søk.length() - 1);

               Utleier utleier = (Utleier) register.getObject(fødselsnummer);

               if(utleier != null){

                   temp.add(utleier);
                   overskriftpanel.remove(overskrift);
                   tabellpanel.remove(scroll);
                   scroll.remove(tabell);
                   revalidate();

                   modell = new Utleiermodell(kolonner, temp);

                   tabell = new JTable(modell);

                   scroll = new JScrollPane(tabell);
                   tabellpanel.add(scroll, BorderLayout.CENTER);

                   overskrift = new JLabel("Søk etter: " + søkfelt.getText() + ", ga " + temp.size() + " resultater");
                   overskriftpanel.add(overskrift);

                   revalidate();
                   repaint();

                   return;

               }


           }
       }

       catch (IndexOutOfBoundsException x){

       }



        if(søk.length()== 0){
            visAlle();
            return;
        }



        Iterator it = utleierliste.iterator();

        while(it.hasNext()){

            Utleier utleier = (Utleier) it.next();

            String fødselsnummer = utleier.getFødselsnummer().toUpperCase();
            String fornavn = utleier.getFornavn().toUpperCase();
            String etternavn = utleier.getEtternavn().toUpperCase();
            String adresse = utleier.getAdresse().toUpperCase();
            String mail = utleier.getMail().toUpperCase();
            String telfonnummer = utleier.getTelefonnummer().toUpperCase();
            String firma = utleier.getFirma().toUpperCase();
            String navn = utleier.getNavn().toUpperCase();

            if(fødselsnummer.startsWith(søk) || fornavn.startsWith(søk) || etternavn.startsWith(søk) || adresse.startsWith(søk) || mail.startsWith(søk) ||
                    telfonnummer.startsWith(søk) ||
                    firma.startsWith(søk) || navn.startsWith(søk)){

                temp.add(utleier);

            }


        }

        if(temp.isEmpty()){

            søkfelt.setBackground(Color.decode("#fd6d6d"));
        }

        overskriftpanel.remove(overskrift);
        tabellpanel.remove(scroll);
        scroll.remove(tabell);
        revalidate();

        modell = new Utleiermodell(kolonner, temp);

        tabell = new JTable(modell);

        scroll = new JScrollPane(tabell);
        tabellpanel.add(scroll, BorderLayout.CENTER);

        overskrift = new JLabel("Søk etter: " + søkfelt.getText() + ", ga " + temp.size() + " resultater");
        overskriftpanel.add(overskrift);

        revalidate();
        repaint();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tilbake){
            parent.visPanel(MainFrame.MAIN_BOARD);
        }
    }

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
        søk();
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {
        søk();
    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent) {
        søk();
    }
}
