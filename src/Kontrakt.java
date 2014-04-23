import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Vegard
 * Date: 13.04.14
 * Time: 16:07
 * To change this template use File | Settings | File Templates.
 */
public class Kontrakt implements Serializable {
    /*utleieboligen
utleier
leietager
leiepris pr måned
leieavtalens varighet (tidrom)*/
    private Bolig bolig;
    private Utleier utleier;
    private Soker leietager;
    private int pris;
    private Date fra;
    private Date til;


    public Kontrakt(Bolig bolig, Utleier utleier, Soker leietager, int pris, Date fra, Date til) {
        this.bolig = bolig;
        this.utleier = utleier;
        this.leietager = leietager;
        this.pris = pris;
        this.fra = fra;
        this.til = til;

    }

    public Bolig getBolig() {
        return bolig;
    }

    public Utleier getUtleier() {
        return utleier;
    }

    public Soker getLeietager() {
        return leietager;
    }

    public int getPris() {
        return pris;
    }

    public Date getFra() {
        return fra;
    }

    public Date getTil() {
        return til;
    }

    @Override
    public String toString() {
        return "Kontrakt{" +
                "bolig=" + bolig +
                ", utleier=" + utleier +
                ", leietager=" + leietager +
                ", pris=" + pris +
                ", fra=" + fra +
                ", til=" + til +
                '}';
    }
}
