import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Vegard
 * Date: 13.04.14
 * Time: 14:15
 * To change this template use File | Settings | File Templates.
 */
public interface Hjem extends Serializable {


    public String getAdresse();

    public String getBeskrivelse();

    public int getBoareal();

    public int getAntallRom();

    public int getByggår();

    public String getBolignr();

    public int getPris();


    public Date getLedigDato();

    public Person getEier();

    public void setEier(Person eier);

    public boolean røyke();
    public boolean husdyr();
    public boolean balkong();
    public boolean terasse();
    public boolean tvInkludert();
    public boolean internettInkludert();
    public boolean strømInkludert();

    public boolean parkering();


}
