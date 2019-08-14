import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import java.util.List;

public class ParagraphElement extends BranchElement {

    @XmlAttribute(name = "isVirtual")
    public boolean isVirtual;

    @XmlElementWrapper(name = "Attributes")
    @XmlElements({
            @XmlElement(name = "Indent", type = IndentAttribute.class),
            @XmlElement(name = "Alignment", type = AlignmentAttribute.class)
    })
    protected List<Attribute> getXmlAttributes() {
        return new Attribute.AttributeListAdapter(attributes);
    }

    @XmlElementWrapper(name = "Elements")
    @XmlElements({
            @XmlElement(name = "TextElement", type = TextElement.class)
    })
    protected List<TerminalElement> getXmlElements(){
        return elements;
    }
}