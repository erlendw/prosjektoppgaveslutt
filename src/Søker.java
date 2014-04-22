/**
 * Created with IntelliJ IDEA.
 * User: Vegard
 * Date: 13.04.14
 * Time: 15:47
 * To change this template use File | Settings | File Templates.
 */
public class Søker extends Person{
    private int antallPersoner;
    private String sivilstatus;
    private String yrke;
    private String arbeidsfohold_studiested;
    private String beliggenhetsønske1;
    private String beliggenhetsønske2;
    private String beliggenhetsønske3;
    private String beliggenhetsønske4;
    private String beliggenhetsønske5;
    private String beliggenhetsønske6;
    private String beliggenhetsønske7;
    private String beliggenhetsønske8;
    private String beliggenhetsønske9;
    private String beliggenhetsønske10;
    private String beliggenhetsønske11;
    private String beliggenhetsønske12;

    private String bolygtypeønske1;
    private String bolygtypeønske2;

    private int minAreal;
    private int maksAreal;

    private int minPris;
    private int maksPris;

    public Søker(String FØDSELSNUMMER, String fornavn, String etternavn, String adresse, String mail, String telefonnummer, int antallPersoner, String sivilstatus, String yrke, String arbeidsfohold_studiested, String beliggenhetsønske1, String beliggenhetsønske2, String beliggenhetsønske3, String beliggenhetsønske4, String beliggenhetsønske5, String beliggenhetsønske6, String beliggenhetsønske7, String beliggenhetsønske8, String beliggenhetsønske9, String beliggenhetsønske10, String beliggenhetsønske11, String beliggenhetsønske12, String bolygtypeønske1, String bolygtypeønske2, int minAreal, int maksAreal, int minPris, int maksPris) {
        super(FØDSELSNUMMER, fornavn, etternavn, adresse, mail, telefonnummer);
        this.antallPersoner = antallPersoner;
        this.sivilstatus = sivilstatus;
        this.yrke = yrke;
        this.arbeidsfohold_studiested = arbeidsfohold_studiested;
        this.beliggenhetsønske1 = beliggenhetsønske1;
        this.beliggenhetsønske2 = beliggenhetsønske2;
        this.beliggenhetsønske3 = beliggenhetsønske3;
        this.beliggenhetsønske4 = beliggenhetsønske4;
        this.beliggenhetsønske5 = beliggenhetsønske5;
        this.beliggenhetsønske6 = beliggenhetsønske6;
        this.beliggenhetsønske7 = beliggenhetsønske7;
        this.beliggenhetsønske8 = beliggenhetsønske8;
        this.beliggenhetsønske9 = beliggenhetsønske9;
        this.beliggenhetsønske10 = beliggenhetsønske10;
        this.beliggenhetsønske11 = beliggenhetsønske11;
        this.beliggenhetsønske12 = beliggenhetsønske12;
        this.bolygtypeønske1 = bolygtypeønske1;
        this.bolygtypeønske2 = bolygtypeønske2;
        this.minAreal = minAreal;
        this.maksAreal = maksAreal;
        this.minPris = minPris;
        this.maksPris = maksPris;
    }

    public int getAntallPersoner() {
        return antallPersoner;
    }

    public String getSivilstatus() {
        return sivilstatus;
    }

    public String getYrke() {
        return yrke;
    }

    public String getArbeidsfohold_studiested() {
        return arbeidsfohold_studiested;
    }

    public String getBeliggenhetsønske1() {
        return beliggenhetsønske1;
    }

    public String getBeliggenhetsønske2() {
        return beliggenhetsønske2;
    }

    public String getBeliggenhetsønske3() {
        return beliggenhetsønske3;
    }

    public String getBeliggenhetsønske4() {
        return beliggenhetsønske4;
    }

    public String getBeliggenhetsønske5() {
        return beliggenhetsønske5;
    }

    public String getBeliggenhetsønske6() {
        return beliggenhetsønske6;
    }

    public String getBeliggenhetsønske7() {
        return beliggenhetsønske7;
    }

    public String getBeliggenhetsønske8() {
        return beliggenhetsønske8;
    }

    public String getBeliggenhetsønske9() {
        return beliggenhetsønske9;
    }

    public String getBeliggenhetsønske10() {
        return beliggenhetsønske10;
    }

    public String getBeliggenhetsønske11() {
        return beliggenhetsønske11;
    }

    public String getBeliggenhetsønske12() {
        return beliggenhetsønske12;
    }

    public String getBolygtypeønske1() {
        return bolygtypeønske1;
    }

    public String getBolygtypeønske2() {
        return bolygtypeønske2;
    }

    public int getMinAreal() {
        return minAreal;
    }

    public int getMaksAreal() {
        return maksAreal;
    }

    public int getMinPris() {
        return minPris;
    }

    public int getMaksPris() {
        return maksPris;
    }

}
