public class ABR{
    //abre binaire de recherche
    private int elem;
    private ABR FG;
    private ABR FD;

   
    //creation d'un arbre a un element
    public ABR(int e ){
        elem = e;
        this.FD = null;
        this.FG = null;
    }

     //creation d'un arbre a un element
    public ABR(int e , ABR FG, ABR FD){
        elem = e;
        this.FD = FD;
        this.FG = FG;
    }

    //setteur
    public void setFG(ABR f){
        this.FG = f;
    }

    public void setFD(ABR f){
        this.FD = f;
    }

    public void setElt(int e){
        this.elem = e;
    }

    //teste si un abre est vide ou pas
    public boolean empty(ABR a){
        return  (a == null);
    }

    //retourner l'élément à la racine de l'arbre
    public int Elt(ABR a){
        return a.elem;
    }


    //recherche un element dans l'arbre
    public boolean exist(ABR a, int e){
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
    public void show_prefixe(){
        if(!empty(this)){
            System.out.print(this.elem+" ");
            if(FG != null)
                FG.show_prefixe();
            if(FD != null)
                FD.show_prefixe();
        }
    }


    //ajout d'un element dans un abr
    public ABR add(ABR a, int e){
        if(empty(a))
            return new ABR(e, null, null);
        else if(e < a.elem)
            return new ABR(a.elem, add(a.FG, e), a.FD);
            else if(e > a.elem)
                    return new ABR(a.elem, a.FG, add(a.FD,e));
                    else
                        return a; //l'element est déjà dans l'arbre
    }

    //supprimer le maximun de l'arbre
    public ABR suppr_max(ABR a){
        if(empty(a))
            return a.FG;
        else
            return new ABR(a.elem, a.FG, suppr_max(a.FD));
    } 

    //retourn le max de l'arbre a
    public int Max(ABR a){
        if(empty(a.FD))
            return a.elem;
        else 
            return Max(a.FD);
    }

    //suppression d'un element de l'arbre
    public ABR delete(ABR a, int e){
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

    //calcule le max entre deux valeurs
    public  int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
    //calcule de l'hauteur d'un ABR
    public int hauteur_ABR(ABR a){
        if(empty(a))
            return -1;
        else
            return max(hauteur_ABR(a.FG), hauteur_ABR(a.FD)) + 1;
    }

    //calculer le niveau d'un element present dans l'arbre
    public int niveau(int x, int niveau){
        int gauche = -1;
        if(empty(this))
            return -1;
        else{ 
            if(this.elem == x)
                return niveau;
            else{
                if(this.FG != null){
                    gauche = FG.niveau(x, niveau+1);
                    if(gauche == -1 && FD != null)
                        return FD.niveau(x, niveau+1);
                    else
                        return -1;
                }else
                    return -1;      
            }
        }
    }

}