import com.google.common.primitives.Chars;
import it.unimi.dsi.fastutil.chars.CharArrays;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenCustomHashMap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Shows how char[] can be used as key in maps
 */
public class CharArrayAsMapKey {

    public static void main(String[] args) {

        //  TreeMap<char[], Integer>

        Comparator<char[]> comparator = Chars.lexicographicalComparator();
        TreeMap<char[], Integer> treeMap = new TreeMap<char[], Integer>(comparator);
        treeMap.put(new char[]{'a','b'}, 111);
        System.out.println("TreeMap get: "+treeMap.get(new char[]{'a','b'}));

        //  HashMap<char[], Integer>
        Map<char[], Integer> hashMap = new Object2ObjectOpenCustomHashMap(CharArrays.HASH_STRATEGY);

        hashMap.put(new char[]{'a','b'}, 111);
        System.out.println("HashMap get: "+hashMap.get(new char[]{'a','b'}));

    }
}
