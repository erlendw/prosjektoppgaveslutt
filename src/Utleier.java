/**
 * Created with IntelliJ IDEA.
 * User: Vegard
 * Date: 13.04.14
 * Time: 15:40
 * To change this template use File | Settings | File Templates.
 */
public class Utleier extends Person {
    private String firma;
    private Boligregister boligregister;

    public Utleier(String FØDSELSNUMMER, String fornavn, String etternavn, String adresse, String mail, String telefonnummer, String firma) {
        super(FØDSELSNUMMER, fornavn, etternavn, adresse, mail, telefonnummer);
        this.firma = firma;
        boligregister = new Boligregister();
    }

    public String getFirma() {
        return firma;
    }
    public String getNavn(){
        String navn = getFornavn() + " " + getEtternavn();
        return navn;
    }

    public Boligregister getBoligregister() {
        return boligregister;
    }

}
