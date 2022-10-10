package task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

public class FactoryProducer {
    public static enum HumanFactoryType {
        MALE, FEMALE
    }

    public static <T extends AbstractFactory> AbstractFactory getFactory(HumanFactoryType key) {
        if (key == HumanFactoryType.MALE)
            return new MaleFactory();
        else
            return new FemaleFactory();
    }
}
