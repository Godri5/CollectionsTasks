package task2613;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        currencyCode = currencyCode.toUpperCase();
        if (!map.containsKey(currencyCode)) {
            CurrencyManipulator manipulator = new CurrencyManipulator(currencyCode);
            map.put(manipulator.getCurrencyCode(), manipulator);
        }
        return map.get(currencyCode);
    }

    private CurrencyManipulatorFactory() {
    }
    
    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return map.values();
    }
}
