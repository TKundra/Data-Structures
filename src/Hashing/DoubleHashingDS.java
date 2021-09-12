package Hashing;

class Value {
    String key;
    int value;
    Value(String key, int value){
        this.key = key;
        this.value = value;
    }
}

public class DoubleHashingDS {
    private int HASH_TABLE_SIZE;
    private int size;
    private Value[] table;
    private int totalPrimeSize;

    public DoubleHashingDS(int ts){
        size = 0;
        HASH_TABLE_SIZE = ts;
        table = new Value[HASH_TABLE_SIZE];
        // initialize by null
        for (int i=0; i<HASH_TABLE_SIZE; i++)
            table[i] = null;
        totalPrimeSize = getPrime();
    }

    // get prime
    public int getPrime() {
        // reverse
        for (int i=HASH_TABLE_SIZE; i>=1; i--){
            int count = 0;
            for (int j=2; j*j<=i; j++){
                // if number is divisible means not prime
                if (i%j == 0)
                    // so simply move to next number
                    count++;
            }
            // by now number os not divisible, hence count holds 0
            if (count == 0)
                // it means it is prime
                return i;
        }
        // else return a prime number
        return 3;
    }

    // get size
    public int getSize(){
        return size;
    }

    // is empty
    public boolean isEmpty(){
        return size == 0;
    }

    // make table empty
    public void makeEmpty(){
        size = 0;
        for (int i=0; i<HASH_TABLE_SIZE; i++)
            table[i] = null;
    }

    // gives hash value for given string, basically it is linear probing
    private int hashOne(String y){
        int hashValue = y.hashCode();
        hashValue %= HASH_TABLE_SIZE;
        if (hashValue<0)
            hashValue += HASH_TABLE_SIZE;
        return hashValue;
    }

    // get value of key
    //public int getKey(String key){}

}
