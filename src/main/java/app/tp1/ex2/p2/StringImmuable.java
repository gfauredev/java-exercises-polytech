public class StringImmuable {
    public static void main(String[] args) {
        String s1 = "Bonjour";
        String s2 = "Bonjour";
        System.out.println("Comparaison ==");
        System.out.println("s1 == s2 : " + (s1 == s2));
        String s3 = new String("Bonjour");
        System.out.println("s1 == s3 : " + (s1 == s3));
        System.out.println();
        System.out.println("Comparaison equals()");
        System.out.println("s1.equals(s2) : " + s1.equals(s2));
        System.out.println("s1.equals(s3) : " + s1.equals(s3));
    }
}
