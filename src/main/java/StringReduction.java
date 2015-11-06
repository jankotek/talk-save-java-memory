/**
 * Reduce memory usage with Strings.
 */
public class StringReduction {

    public static void main(String[] args) {

        // use interned strings
        String name = "Java Days".intern();

        System.out.println("Intern strings are the same: "+(
                name.toLowerCase().intern() == name.toLowerCase().intern()));

        System.out.println("Normal strings are the same: "+(
                name.toLowerCase() == name.toLowerCase()));

    }


    static class Person{

        private char[] name;

        public String getName(){
            return new String(name);
        }

        public void setName(String name){
            this.name = name.toCharArray();
        }
    }
}
