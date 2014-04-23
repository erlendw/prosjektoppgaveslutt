import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Vegard
 * Date: 13.04.14
 * Time: 16:14
 * To change this template use File | Settings | File Templates.
 */
public class Kontraktregister extends LinkedList {

    public void registrerKontrakt(Kontrakt kontrakt){
        add(kontrakt);
    }
    public LinkedList getKontrakter(){
        return this;
    }


}
