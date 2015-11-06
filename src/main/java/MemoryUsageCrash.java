import java.util.Arrays;
import java.util.HashMap;

/**
 * Allocates objects until JVM crashes.
 * Than it calculates memory consumption.
 */
public class MemoryUsageCrash {

    static Object allocate(){
        return new HashMap();
    }

    public static void main(String[] args) {
        Object[] array = new Object[10000];
        int arrayPos =0;
        long counter=0;
        long maxMemory = Runtime.getRuntime().maxMemory();

        while(true) try{
            //add new entry
            array[arrayPos++] = allocate();
            counter++;

            //if array is too big allocate new array
            if(arrayPos==array.length){
                //start new array
                Object[] array2 = new Object[array.length];
                array2[0] = array;
                array = array2;
                //and put old array at start, so it is still referenced
                array[0] = array2;
                arrayPos=1;
            }

        }catch(OutOfMemoryError e){
            long memoryUsage = maxMemory/counter;
            System.out.println("Single object uses "+memoryUsage+" bytes");
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            System.out.println(Arrays.deepHashCode(array));
            return;
        }

    }
}
