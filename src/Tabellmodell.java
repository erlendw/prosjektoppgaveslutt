import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Vegard
 * Date: 16.04.14
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 */
public abstract class Tabellmodell<T> extends AbstractTableModel {

    private String[] kolonnenavn;
    private LinkedList<T> data;

    public Tabellmodell(String[] kolonnenavn, LinkedList<T> data) {
        this.kolonnenavn = kolonnenavn;
        this.data = data;
    }

    public String getColumnName(int kol) {
        return kolonnenavn[kol];
    }

    public int getRowCount() {
        return data.size();
    }

    public T getRow(int rad) {
        return data.get(rad);
    }

    public int getColumnCount() {
        return kolonnenavn.length;
    }

    public LinkedList<T> getData() {
        return data;
    }

    @Override
    public abstract Object getValueAt(int rad, int kol);

    /**
     * Setter inn et objekt i en rad i tabellen og oppdaterer modellen.
     *
     * @param obj Objektetsom skal settes inn.
     */
    public void addRow(T obj) {
        data.add(obj);
        this.fireTableDataChanged();
    }

    /**
     * Fjerner en rad fra tabellen og oppdaterer modellen.
     *
     * @param rad Indeksen til den raden som skal fjernes.
     */
    public void delRow(int rad) {
        data.remove(rad);
        this.fireTableDataChanged();
    }

    /**
     * Sletter all data og oppdaterer modellen.
     */
    public void delTabledata() {
        data.clear();
        this.fireTableDataChanged();
    }

    /**
     * Sletter all data, setter inn ny og oppdaterer modellen.
     *
     * @param d Den nye listen med data.
     */
    public void setTabledata(LinkedList<T> d) {
        data.clear();
        data.addAll(d);
        this.fireTableDataChanged();
    }

}//tabellModell klasse feridg

class Utleiermodell extends Tabellmodell<Utleier> {

    private final int FØDSELSNUMMER = 0;
    private final int FORNAVN = 1;
    private final int ETTERNAVN = 2;
    private final int ADRESSE = 3;
    private final int MAIL = 4;
    private final int TELEFONUMMER = 5;
    private final int FIRMA = 6;

    public Utleiermodell(String[] kolonnenavn, LinkedList<Utleier> data) {
        super(kolonnenavn, data);
    }

    public Object getValueAt(int rad, int kol) {
        Utleier utleier = (Utleier) super.getData().get(rad);

        switch (kol) {
            case FØDSELSNUMMER:
                return utleier.getFødselsnummer();
            case FORNAVN:
                return utleier.getFornavn();
            case ETTERNAVN:
                return utleier.getEtternavn();
            case ADRESSE:
                return utleier.getAdresse();
            case MAIL:
                return utleier.getMail();
            case TELEFONUMMER:
                return utleier.getTelefonnummer();
            case FIRMA:
                return utleier.getFirma();
            default:
                return null;
        }

    }

    public Utleier getValueAt(int rad) {
        return (Utleier) super.getData().get(rad);

    }

}
