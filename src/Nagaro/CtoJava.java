package Nagaro;

public class CtoJava {
    public static void main(String[] args) {
        String result = "";
        String input = "this_is_a_variable";
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '_') {
                i++;
                char chr = Character.toUpperCase(c[i]);
                result += chr;
            } else {
                result += c[i];
            }
        }
        System.out.println(result); //o/p: thisIsAVariable
        String s = "thisIsAVariable"; //INPUT
        char[] ch = s.toCharArray();

        String str = "";
        for (int i = 0; i < ch.length; i++) {
            if (Character.isUpperCase(ch[i])) {
                str += "_";
                str += ch[i];
            } else
                str += ch[i];
        }
        System.out.println(str.toLowerCase()); //O/P: this_is_a_variable


    }
}
