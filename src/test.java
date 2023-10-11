public class test {
    public static void main(String[] args){
        ABR a = new ABR(2);
        a.show_prefixe(a);

        System.out.print("\n");

        a = a.add(a, 3);
        a.show_prefixe(a);

        System.out.print("\n");

        a = a.delete(a, 2);
        a.show_prefixe(a);

        System.out.print("\n");
    }
}
