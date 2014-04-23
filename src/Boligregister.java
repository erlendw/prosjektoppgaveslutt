import java.util.Map;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: Vegard
 * Date: 13.04.14
 * Time: 13:59
 * To change this template use File | Settings | File Templates.
 */
public class Boligregister extends TreeMap<String, Bolig> implements Register{


    @Override
    public boolean leggTil(Object object) {
        if(object instanceof Enebolig){
            if(!finnes(((Enebolig) object).getBolignr())){

                put(((Enebolig) object).getBolignr(),(Enebolig) object);
                return true;

            }
        }
        return false;
    }


    @Override
    public boolean finnes(String nr) {
        return containsKey(nr);
    }

    @Override
    public boolean fjern(String nr) {
        if(finnes(nr)){
            remove(nr);
            return true;
        }
        return false;
    }

    @Override
    public Object getObject(String nr) {
        if(finnes(nr)){
            return get(nr);
        }
        return null;
    }

    @Override
    public Map getMap() {
        return this;
    }
}
