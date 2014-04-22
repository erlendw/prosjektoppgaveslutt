import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Vegard
 * Date: 13.04.14
 * Time: 14:08
 * To change this template use File | Settings | File Templates.
 */

public abstract class Bolig implements Hjem {
    private String adresse;
    private int boareal;
    private int antallRom;
    private int byggeår;
    private String beskrivelse;
    private int pris;
    private Date ledigFra;
    private String bolignummer;
    private Person eier;

    private boolean røyke;
    private boolean husdyr;
    private boolean balkong;
    private boolean terasse;

    private boolean tvInkludert;
    private boolean internettInkludert;
    private boolean strømInkludert;
    private boolean parkering;


    public Bolig(String adresse, int boareal, int antallRom, int byggeår, String beskrivelse, int pris, Date ledigFra, String bolignummer, Person eier, boolean røyke, boolean husdyr, boolean balkong, boolean terasse, boolean tvInkludert, boolean internettInkludert, boolean strømInkludert, boolean parkering) {
        this.adresse = adresse;
        this.boareal = boareal;
        this.antallRom = antallRom;
        this.byggeår = byggeår;
        this.beskrivelse = beskrivelse;
        this.pris = pris;
        this.ledigFra = ledigFra;
        this.bolignummer = bolignummer;
        this.eier = eier;
        this.røyke = røyke;
        this.husdyr = husdyr;
        this.balkong = balkong;
        this.terasse = terasse;
        this.tvInkludert = tvInkludert;
        this.internettInkludert = internettInkludert;
        this.strømInkludert = strømInkludert;
        this.parkering = parkering;
    }

    @Override
    public String getAdresse() {
        return adresse;
    }

    @Override
    public String getBeskrivelse() {
        return beskrivelse;
    }

    @Override
    public int getBoareal() {
        return boareal;
    }

    @Override
    public int getAntallRom() {
        return antallRom;
    }

    @Override
    public int getByggår() {

        return byggeår;
    }

    @Override
    public String getBolignr() {
        return bolignummer;
    }

    @Override
    public int getPris() {
        return pris;
    }

    @Override
    public Date getLedigDato() {
        return ledigFra;
    }
    @Override
    public Person getEier(){
        return eier;
    }
    public void setEier(Person eier){
        this.eier = eier;
    }

    @Override
    public boolean røyke() {
        return røyke;
    }

    @Override
    public boolean husdyr() {
        return husdyr;
    }

    @Override
    public boolean balkong() {
        return balkong;
    }

    @Override
    public boolean terasse() {
        return terasse;
    }

    @Override
    public boolean tvInkludert() {
        return tvInkludert;
    }

    @Override
    public boolean internettInkludert() {
        return internettInkludert;
    }

    @Override
    public boolean strømInkludert() {
        return strømInkludert;
    }
    @Override
    public boolean parkering(){
        return parkering;
    }

}
