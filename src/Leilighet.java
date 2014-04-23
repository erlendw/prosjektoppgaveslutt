import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Vegard
 * Date: 13.04.14
 * Time: 15:29
 * To change this template use File | Settings | File Templates.
 */
public class Leilighet extends Bolig {
    private int antallBoder;
    private int etasje;
    private boolean heis;

    public Leilighet(String adresse, int boareal, int antallRom, int byggeår, String beskrivelse, int pris, Date ledigFra, String bolignummer, Person eier, boolean røyke, boolean husdyr, boolean balkong, boolean terasse, boolean tvInkludert, boolean internettInkludert, boolean strømInkludert, boolean parkering, int antallBoder, int etasje, boolean heis) {
        super(adresse, boareal, antallRom, byggeår, beskrivelse, pris, ledigFra, bolignummer, eier, røyke, husdyr, balkong, terasse, tvInkludert, internettInkludert, strømInkludert, parkering);
        this.antallBoder = antallBoder;
        this.etasje = etasje;
        this.heis = heis;
    }

    public int getAntallBoder() {
        return antallBoder;
    }

    public int getEtasje() {
        return etasje;
    }

    public boolean isHeis() {
        return heis;
    }
}
