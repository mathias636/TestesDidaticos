package TestesDidaticos.src;

/**
 * TesteToStringNull
 */
public class TesteToStringNull {

    public static void main(String[] args) {
        String[] v = {null, "a"};

        // for (String string : v) {
        //     if(string == null){
        //         System.out.println(string);
        //     }
        // }

        if(v[0] == null){
            v[0] = "aa";
            System.out.println(
                v[0]
            );
        }
    }
}