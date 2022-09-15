package task33.task3308;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Shop {
    @XmlAnyElement
    public Goods goods;

    public int count;

    public double profit;

    public String[] secretData;

    @XmlRootElement
    static class Goods {
        public List<String> names;
    }
}
