

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
        Personregister register = new Personregister();
        Sokerregister sregister = new Sokerregister();
        Boligregister bregister = new Boligregister();
        Leilighetregister legister = new Leilighetregister();

        MainFrame frame;


        String[] fornavns = {"Ole", "Vetle","Simen","Karl", "Nils","Trine", "Kari", "Tina", "Hamed","Per-Arne","Mads","Erlend","Christoffer"};

        String[] etternavns = {"Larsen", "Moradi", "Thommasen", "Kulterud", "Bror", "McFlurry", "Olsen", "Pettersen","Baggins","Lannister","Targaryen"};

        String adresses[] = {"Tollbodgata 18", "Pilestredet 45", "Storgata 65", "Ingesteder 12", "Andeby City", "Eventyrdalen 762","King's Landing, The Red Keep","The Shire 43B"};

        String[] firma = {"","Illuminati","Monstermasten","Überkul A/S","Pilen Dytt og Flytt Inc."};

        String[] antPersoner = {"0","1","2","3","4","5"};

        String[] sivilstatus = {"Gift","Samboer","Singel"};

        String[] yrke = {"Snekker","Ingeniør","Sykepleier","Lege","Advokat","Økonom","Freakonom","Hobbyelektriker/brannstarter","Sosionom","Arbeidsledig","Student"};

        String[] arbeidsforhold = {"UIO","HIOA","UIB","NTNU","Aker Solutions","Microsoft","Apple Inc.","Monstermasten","Illuminati"};

        String[] domene = {"hotmail.com","me.com","gmail.com","yahoo.com","live.no","hotmail.no"};

        int[] boareal = {20,30,40,50,60,70,80};
        int[] antrom = {1,2,3,4,5,6};
        int[] byggår = {1970,1980,1990,2000,2010};
        String[] beskrivelse = {"Flott enebolig!","Nyoppusset enebolig","Lys og fin enebolig","Gammel herskapelig enebolig"};
        int[] pris = {5000,6000,6500,7000,7499,7999,8750,10899};
        String[] ledigfra = {"Snarest","01.08.14","01.07.14","01.09.14","01.10.14","01.11.14"};
        boolean[] røyke = {true,false};
        boolean[] husdyr ={true,false};
        boolean[] balkong ={true,false};
        boolean[] terasse ={true,false};
        boolean[] tv ={true,false};
        boolean[] nett ={true,false};
        boolean[] strøm ={true,false};
        boolean[] parkering ={true,false};
        int[] antetg = {1,2,3,4,5,6};
        boolean[] kjeller ={true,false};
        double[] tomt = {90,100,110,120,130,140,150};
        int[] antbad = {1,2,3,4};

        int minareal = 0;
        int maksareal = 100;
        int minpris = 0;
        int makspris = 100000;

        Random r = new Random();

        for(int i = 0; i < 1000; i++){
            String fornavn = fornavns[r.nextInt(fornavns.length)];
            String etternavn = etternavns[r.nextInt(etternavns.length)];
            String adresse = adresses[r.nextInt(adresses.length)];
            String mail = fornavn.toLowerCase() + "."+etternavn.toLowerCase()+ "@" + domene[r.nextInt(domene.length)];
            String firm = firma[r.nextInt(firma.length)];

            Utleier utleier = new Utleier(String.valueOf(i+1), fornavn, etternavn, adresse, mail, String.valueOf(i+100), firm);

            register.leggTil(utleier);
        }

        for(int i=0;i<1000; i++){
            String fornavn = fornavns[r.nextInt(fornavns.length)];
            String etternavn = etternavns[r.nextInt(etternavns.length)];
            String adresse = adresses[r.nextInt(adresses.length)];
            String mail = fornavn.toLowerCase() + "." + etternavn.toLowerCase() + "@" + domene[r.nextInt(domene.length)];
            String antpersoner = antPersoner[r.nextInt(antPersoner.length)];
            String sivstat = sivilstatus[r.nextInt(sivilstatus.length)];
            String work = yrke[r.nextInt(yrke.length)];
            String arbforhold = arbeidsforhold[r.nextInt(arbeidsforhold.length)];

            Soker soker = new Soker(String.valueOf(i+1),fornavn,etternavn,adresse,mail,String.valueOf(i+100),antpersoner,sivstat,work,arbforhold,minareal,maksareal,minpris,makspris);
            sregister.leggTil(soker);
        }

        for(int i=0;i<500; i++){
            int bareal = boareal[r.nextInt(boareal.length)];
            String adresse = adresses[r.nextInt(adresses.length)];
            int rom = antrom[r.nextInt(antrom.length)];
            int år = byggår[r.nextInt(byggår.length)];
            int price = pris[r.nextInt(pris.length)];
            String pnr = String.valueOf(i+1);
            Utleier utleier = register.get(pnr);
            boolean smoke = røyke[r.nextInt(røyke.length)];
            boolean dyr = husdyr[r.nextInt(husdyr.length)];
            boolean balk = balkong[r.nextInt(balkong.length)];
            boolean ter = terasse[r.nextInt(terasse.length)];
            boolean TV = tv[r.nextInt(tv.length)];
            boolean internet = nett[r.nextInt(nett.length)];
            boolean s = strøm[r.nextInt(strøm.length)];
            boolean park = parkering[r.nextInt(parkering.length)];
            int etg = antetg[r.nextInt(antetg.length)];
            boolean kj = kjeller[r.nextInt(kjeller.length)];
            double tmt = tomt[r.nextInt(tomt.length)];
            int bad = antbad[r.nextInt(antbad.length)];
            String ledig = ledigfra[r.nextInt(ledigfra.length)];
            String beskriv = beskrivelse[r.nextInt(beskrivelse.length)];

            Enebolig enebolig = new Enebolig(adresse,bareal,rom,år,beskriv,price,ledig,String.valueOf(i+1),utleier,smoke,dyr,balk,ter,
                    TV,internet,s,park,etg,kj,tmt,bad);
            bregister.leggTil(enebolig);
        }

        frame = new MainFrame(register,bregister,sregister,legister);
        frame.setVisible(true);

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
