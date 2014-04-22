import java.util.Map;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: Vegard
 * Date: 13.04.14
 * Time: 15:00
 * To change this template use File | Settings | File Templates.
 */
public class Personregister extends TreeMap<String, Person> implements Register{

    @Override
    public boolean leggTil(Object object) {
        if(object instanceof Person){
            if(!finnes(((Person) object).getFødselsnummer())){

                put(((Person) object).getFødselsnummer(),(Person) object);
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
