import java.io.Serializable;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Vegard
 * Date: 13.04.14
 * Time: 14:00
 * To change this template use File | Settings | File Templates.
 */
public interface Register extends Serializable{

    public boolean leggTil(Object object);
    public boolean finnes(String nr);
    public boolean fjern(String nr);

    public Object getObject(String nr);

    public Map getMap();




}
