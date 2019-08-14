import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
public abstract class BranchElement extends TerminalElement {

    public BranchElement(){
    }

    protected List<TerminalElement> elements = new ArrayList<TerminalElement>();

    public void addElement(TerminalElement element){
        elements.add(element);
    }

    public List<TerminalElement> getElements(){
        return elements;
    }
}