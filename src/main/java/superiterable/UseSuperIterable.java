package superiterable;

import java.util.List;

public class UseSuperIterable {

    public static void main(String[] args) {
        SuperIterable<String> sis = new SuperIterable<>(List.of("Fred","Jim","Sheila"));
        for(String s : sis) {
            System.out.println(" > " + s);
        }
    }
}
