

import javax.swing.*;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Vegard
 * Date: 13.04.14
 * Time: 14:11
 * To change this template use File | Settings | File Templates.
 */
public class BoligBrowse {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setVisible(true);

        Personregister register = new Personregister();




        String[] fornavns = {"Ole", "Vetle","Simen","Karl", "Nils","Trine", "Kari", "Tina", "Hamed"};

        String[] etternavns = {"Larsen", "Moradi", "Thommasen", "Kulterud", "Bror", "McFlurry", "Olsen", "Pettersen"};

        String adresses[] = {"Tollbodgata 18", "Pilestredet 45", "Storgata 65", "Ingesteder 12", "Andeby City", "Eventyrdalen 762"};

        String firma = "Ingenting A/S";

        Random r = new Random();



        for(int i = 0; i < 100000; i++){
            String fornavn = fornavns[r.nextInt(fornavns.length)];
            String etternavn = etternavns[r.nextInt(etternavns.length)];
            String adresse = adresses[r.nextInt(adresses.length)];
            String mail = fornavn + "@" + etternavn + ".no";

            Utleier utleier = new Utleier(String.valueOf(i+1), fornavn, etternavn, adresse, mail, String.valueOf(i+100), firma);

            register.leggTil(utleier);
        }



        //JPanel panel = new UtleierOversiktPANEL(register, this);

       // frame.getContentPane().add(panel);

        new MainFrame(register);

    }


}
