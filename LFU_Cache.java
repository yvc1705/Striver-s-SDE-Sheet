import java.util.HashMap;
import java.util.LinkedHashSet;

class LFUCache {
    private int capacity;
    private int minFrequency;
    private HashMap<Integer, Integer> keyToVal;
    private HashMap<Integer, Integer> keyToFreq;
    private HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.keyToVal = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        updateFrequency(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            updateFrequency(key);
        } else {
            if (keyToVal.size() >= capacity) {
                evict();
            }
            keyToVal.put(key, value);
            keyToFreq.put(key, 1);
            freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
            minFrequency = 1;
        }
    }

    private void updateFrequency(int key) {
        int frequency = keyToFreq.get(key);
        keyToFreq.put(key, frequency + 1);
        freqToKeys.get(frequency).remove(key);
        freqToKeys.computeIfAbsent(frequency + 1, k -> new LinkedHashSet<>()).add(key);
        if (freqToKeys.get(frequency).isEmpty() && frequency == minFrequency) {
            minFrequency++;
        }
    }

    private void evict() {
        int keyToRemove = freqToKeys.get(minFrequency).iterator().next();
        freqToKeys.get(minFrequency).remove(keyToRemove);
        keyToVal.remove(keyToRemove);
        keyToFreq.remove(keyToRemove);
    }
}
