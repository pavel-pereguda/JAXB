import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@XmlAccessorType(XmlAccessType.NONE)
public abstract class TerminalElement {

    public TerminalElement(){
    }

    protected Map<Class, Attribute> attributes = new LinkedHashMap<Class, Attribute>();

    public List<Attribute> getAttributes() {
        return new ArrayList<Attribute>(attributes.values());
    }

    public void addAttribute(Attribute attribute){
        if (attribute == null){
            return;
        }
        attributes.put(attribute.getClass(), attribute);
    }
}
