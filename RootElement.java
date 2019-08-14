import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

@XmlRootElement(name = "RootElement")
public class RootElement extends BranchElement {

    @XmlElementWrapper(name = "Elements")
    @XmlElements({
            @XmlElement(name = "ParagraphElement", type = ParagraphElement.class)
    })
    protected List<TerminalElement> getXmlElements(){
        return elements;
    }

    public static void main(String[] args) throws Exception {

        final JAXBContext jc = JAXBContext.newInstance(RootElement.class);

        final RootElement re = new RootElement();
        final ParagraphElement pe = new ParagraphElement();
        pe.isVirtual = true;
        pe.addAttribute(new IndentAttribute(1000));
        pe.addAttribute(new AlignmentAttribute(AlignmentAttribute.VALUE.CENTER));

        final TextElement te = new TextElement("test!!!");
        pe.addElement(te);
        re.addElement(pe);

        te.addAttribute(new BoldAttribute(Boolean.TRUE));
        te.addAttribute(new ItalicAttribute(Boolean.TRUE));
        te.addAttribute(new ColorAttribute(java.awt.Color.RED));
        te.addAttribute(new FontNameAttribute("Arial"));
        te.addAttribute(new FontSizeAttribute(14));

        final Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(re, new File("resources/test_jaxb.xml"));

        final Unmarshaller unmarshaller = jc.createUnmarshaller();
        final RootElement re2 = (RootElement) unmarshaller.unmarshal(new File("resources/test_jaxb.xml"));
        re2.toString();
    }
}
