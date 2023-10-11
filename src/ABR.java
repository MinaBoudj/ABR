public class ABR{
    //abre binaire de recherche
    private int elem;
    private ABR FG;
    private ABR FD;

   
    //creation d'un arbre a un element
    ABR(int e ){
        elem = e;
        this.FD = null;
        this.FG = null;
    }

     //creation d'un arbre a un element
    ABR(int e , ABR FG, ABR FD){
        elem = e;
        this.FD = FD;
        this.FG = FG;
    }

    //setteur
    void setFG(ABR f){
        this.FG = f;
    }

    void setFD(ABR f){
        this.FD = f;
    }

    void setElt(int e){
        this.elem = e;
    }

    //teste si un abre est vide ou pas
    boolean empty(ABR a){
        return  (a == null);
    }

    //retourner l'élément à la racine de l'arbre
    int Elt(ABR a){
        return a.elem;
    }


    //recherche un element dans l'arbre
    boolean exist(ABR a, int e){
        if(empty(a))
            return false;
        if(a.elem == e)
            return true;
        if(e <= a.elem)
            return exist(a.FG, e);
        else
            return exist(a.FD, e);
    }

    //afficher les elements d'un arbre
    void show_prefixe(ABR a){
        if(!empty(a)){
            System.out.print(a.elem);
            show_prefixe(a.FG);
            show_prefixe(a.FD);
        }
    }

    //ajout d'un element dans un abr
    ABR add(ABR a, int e){
        if(empty(a))
            return new ABR(e, null, null);
        else if(e < a.elem)
            return new ABR(a.elem, add(a.FG, e), a.FD);
            else if(e > a.elem)
                    return new ABR(a.elem, a.FG, add(a.FD,e));
                    else
                        return a; //l'element est déjà dans l'arbre
    }

    ABR suppr_max(ABR a){
        if(empty(a))
            return a.FG;
        else
            return new ABR(a.elem, a.FG, suppr_max(a.FD));
    } 

    int Max(ABR a){
        if(empty(a.FD))
            return a.elem;
        else 
            return Max(a.FD);
    }

    //suppression d'un element de l'arbre
    ABR delete(ABR a, int e){
        if(empty(a))
            return a;
        else if(e < a.elem)
                return new ABR(a.elem, delete(a.FG, e), a.FD);
            else if(e > a.elem)
                return new ABR(a.elem, a.FG, delete(a.FD, e));
                else if(empty(a.FG))
                        return a.FD;
                    else if(empty(a.FD))
                            return a.FG;
                            else
                                return  new ABR(Max(a.FG), suppr_max(a.FG), a.FD);
    }

}