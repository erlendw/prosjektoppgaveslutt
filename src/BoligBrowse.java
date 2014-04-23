

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Vegard
 * Date: 13.04.14
 * Time: 14:11
 * To change this template use File | Settings | File Templates.
 * testing
 */
public class BoligBrowse {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setVisible(true);

        Personregister register = new Personregister();
        Sokerregister sregister = new Sokerregister();
        Boligregister bregister = new Boligregister();
        Leilighetregister legister = new Leilighetregister();




        String[] fornavns = {"Ole", "Vetle","Simen","Karl", "Nils","Trine", "Kari", "Tina", "Hamed"};

        String[] etternavns = {"Larsen", "Moradi", "Thommasen", "Kulterud", "Bror", "McFlurry", "Olsen", "Pettersen"};

        String adresses[] = {"Tollbodgata 18", "Pilestredet 45", "Storgata 65", "Ingesteder 12", "Andeby City", "Eventyrdalen 762"};

        String firma = "Ingenting A/S";

        String[] antPersoner = {"0","1","2","3","4","5"};

        String[] sivilstatus = {"Gift","Samboer","Singel"};

        String[] yrke = {"Snekker","Ingeniør","Sykepleier","Lege","Advokat","Økonom","Freakonom","Hobbyelektriker/brannstarter","Sosionom","Arbeidsledig","Student"};

        String[] arbeidsforhold = {"UIO","HIOA","UIB","NTNU","Aker Solutions","Microsoft","Apple Inc.","Monstermasten"};

        int minareal = 0;
        int maksareal = 100;
        int minpris = 0;
        int makspris = 100000;

        Random r = new Random();

        for(int i = 0; i < 1000; i++){
            String fornavn = fornavns[r.nextInt(fornavns.length)];
            String etternavn = etternavns[r.nextInt(etternavns.length)];
            String adresse = adresses[r.nextInt(adresses.length)];
            String mail = fornavn + "@" + etternavn + ".no";

            Utleier utleier = new Utleier(String.valueOf(i+1), fornavn, etternavn, adresse, mail, String.valueOf(i+100), firma);

            register.leggTil(utleier);
        }

        for(int i=0;i<1000; i++){
            String fornavn = fornavns[r.nextInt(fornavns.length)];
            String etternavn = etternavns[r.nextInt(etternavns.length)];
            String adresse = adresses[r.nextInt(adresses.length)];
            String mail = fornavn + "@" + etternavn + ".no";
            String antpersoner = antPersoner[r.nextInt(antPersoner.length)];
            String sivstat = sivilstatus[r.nextInt(sivilstatus.length)];
            String work = yrke[r.nextInt(yrke.length)];
            String arbforhold = arbeidsforhold[r.nextInt(arbeidsforhold.length)];

            Soker soker = new Soker(String.valueOf(i+1),fornavn,etternavn,adresse,mail,String.valueOf(i+100),antpersoner,sivstat,work,arbforhold,minareal,maksareal,minpris,makspris);
            sregister.leggTil(soker);
        }

        new MainFrame(register,bregister,sregister,legister);
        frame.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
    }


}
