import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import java.util.List;

public class TextElement extends TerminalElement {

    private String text;

    public TextElement(String text){
        this.text = text;
    }

    public TextElement(){
        this(null);
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    @XmlElement(name = "Text")
    protected String getXmlText(){
        return text;
    }

    protected void setXmlText(String text){
        this.text = text;
    }

    @XmlElementWrapper(name = "Attributes")
    @XmlElements({
            @XmlElement(name = "Bold", type = BoldAttribute.class),
            @XmlElement(name = "Italic", type = ItalicAttribute.class),
            @XmlElement(name = "Color", type = ColorAttribute.class),
            @XmlElement(name = "FontName", type = FontNameAttribute.class),
            @XmlElement(name = "FontSize", type = FontSizeAttribute.class)
    })
    protected List<Attribute> getXmlAttributes() {
        return new Attribute.AttributeListAdapter(attributes);
    }
}
