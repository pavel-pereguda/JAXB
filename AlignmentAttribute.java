import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

public class AlignmentAttribute extends Attribute<AlignmentAttribute.VALUE> {

    @XmlType(namespace = "AlignmentAttribute")
    public enum VALUE {
        NONE, LEFT, RIGHT, CENTER
    }

    public AlignmentAttribute() {
        super(VALUE.NONE);
    }

    public AlignmentAttribute(VALUE value) {
        super(value);
    }

    @XmlElement(name = "Value")
    @Override
    protected VALUE getXmlValue() {
        return value;
    }

    @Override
    protected void setXmlValue(VALUE value) {
        this.value = value;
    }
}