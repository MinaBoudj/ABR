
public class test {
    public static void main(String[] args){
        ABR a = new ABR(2);
        System.out.print("la hauteur de l'arbre est = "+a.hauteur_ABR(a)+"\n");
        a.show_ABR();

        System.out.print("\n");

        a = a.add(a, 3);
        System.out.print("la hauteur de l'arbre est = "+a.hauteur_ABR(a)+"\n");
        a.show_ABR();

        System.out.print("\n");

        a = a.delete(a, 2);
        a.show_ABR();

        System.out.print("\n");
    }

    
}
