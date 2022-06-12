public class Constants {

    public static final String PLACE_HOLDER_PHRASE = "[BLANK]";


    /*String s1 = "f_name ";
    String s2 = s1 + "m_name ";
    s1.concat("l_name ");
    s2.concat(s1);
    s1 += "s_name";
    System.out.println(s1 + " " + s2);
     */

    /*New objects
    1) String literal "f_name"
    2) String literal "m_name "
    3) Concantenation of s1 and "m_name"
    4) String literal "l_name"
    5) Concatenation of s1 and "l_name"
    6) Concatenation of s2 and s1
    7) String literal "s_name"
    8) Concatenation of s1 and "s_name"
    9) String literal " "
    10) Concatenation of s2 and s2 in println
     */
    void awake() {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder(str1.append("m_name "));
        str1.append("l_name");
        str2.append(str1);
        str1.append("l_name");

        System.out.printf("%s %s", str1, str2);


    }


}
