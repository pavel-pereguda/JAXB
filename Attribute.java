import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.Map;

@XmlAccessorType(XmlAccessType.NONE)
@XmlTransient
public abstract class Attribute<T> {

    protected T value;

    public Attribute(){
        this(null);
    }

    public Attribute(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @XmlElement(name = "Value")
    protected T getXmlValue(){
        return value;
    }

    protected void setXmlValue(T value){
        this.value = value;
    }

    public static class AttributeListAdapter extends AbstractList {
        protected final Map<Class, Attribute> map;

        public AttributeListAdapter(Map<Class, Attribute> map){
            this.map = map;
        }

        @Override
        public boolean add(Object o) {
            if (o == null){
                return false;
            }
            return this.map.put(o.getClass(), (Attribute)o) != null;
        }

        @Override
        public Attribute get(int index) {
            final Iterator iterator = map.values().iterator();
            int n = 0;
            while(iterator.hasNext()){
                final Attribute attribute = (Attribute) iterator.next();
                if(n == index){
                    return attribute;
                }
                n++;
            }
            return null;
        }

        @Override
        public Iterator iterator() {
            return this.map.values().iterator();
        }

        @Override
        public int size() {
            return this.map.values().size();
        }
    }
}
