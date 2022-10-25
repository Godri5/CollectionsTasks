package task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations; //Мапа ≤номинал, количество≥

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
        this.denominations = new TreeMap<>();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)){
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount() {
        int result = 0;
        for (Map.Entry cash : denominations.entrySet()) {
            result += ((int) cash.getKey()) * ((int) cash.getValue());
        }
        return result;
    }
    
    public boolean hasMoney() {
        return !denominations.isEmpty();
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return expectedAmount <= getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException{
        HashMap<Integer, Integer> copyMap = new HashMap<>(denominations);
        ArrayList<Integer> keys = new ArrayList<>(this.denominations.keySet());
        
        Collections.sort(keys);
        Collections.reverse(keys);
        
        TreeMap<Integer, Integer> resultMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        
        for (Integer denomination : keys) {
            int value = copyMap.get(denomination);
            while (true) {
                if (expectedAmount < denomination || value == 0) {
                    copyMap.put(denomination, value);
                    break;
                }
                expectedAmount -= denomination;
                value--;
                
                if (resultMap.containsKey(denomination))
                    resultMap.put(denomination, resultMap.get(denomination) + 1);
                else 
                    resultMap.put(denomination, 1);
            }
        }
        
        if (expectedAmount > 0) 
            throw new NotEnoughMoneyException();
        else {
            this.denominations.clear();
            this.denominations.putAll(copyMap);
        }
        return resultMap;
    }
}
