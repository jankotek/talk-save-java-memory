import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

import java.util.Map;

/*
 * Shows Map<int,int>, Map<int,Object> etc
 */
public class SpecializedMaps {

    public static void main(String[] args) {
        //  create new map,
        Int2ObjectMap<String> map =
                new Int2ObjectOpenHashMap();

        // put/get method has primitive arg, no unboxing!
        map.put(1, "aa");
        map.get(1);

        //but it also implements full mapdb interface
        Map<Integer, String> map2 = map;

    }
}
