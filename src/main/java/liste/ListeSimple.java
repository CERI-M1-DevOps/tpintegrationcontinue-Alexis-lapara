package liste;

public class ListeSimple {
    private long size;
    Noeud tete;
    

    /**
     * renvoie la taille de la liste
     * @return la taille de la liste
    */

    public long getSize() {
        return size;
    }
    /**
     * ajoute un élément en tête de liste
     * @param element element à ajouter
    */
    public void ajout(int element) {
        tete = new Noeud(element, tete);
        size++;
    }
    /**
     * modifie le premier élément de la liste corespondant à l'element passe en paramètre
     * @param element élément à modifier
     * @param nouvelleValeur nouvelle valeur de l'élément
    */
    public void modifiePremier(Object element, Object nouvelleValeur) {
        Noeud courant = tete;
        while (courant != null && courant.getElement() != element)
            courant = courant.getSuivant();
        if (courant != null)
            courant.setElement(nouvelleValeur);
    }
    /**
     * modifie tous les éléments de la liste corespondant à element passe en paramètre
     * @param element élément à modifier
     * @param nouvelleValeur nouvelle valeur des éléments
    */
    public void modifieTous(Object element, Object nouvelleValeur) {
        Noeud courant = tete;
        while (courant != null) {
            if (courant.getElement() == element)
                courant.setElement(nouvelleValeur);
            courant = courant.getSuivant();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListeSimple(");
        Noeud n = tete;
        while (n != null) {
            sb.append(n);
            n = n.getSuivant();
            if (n != null)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }
    /**
     * supprime le premier élément de la liste qui correspond à element passe en paramètre
     * @param element élément à supprimer
    */
    public void supprimePremier(Object element) {
        if (tete != null) {
            if (tete.getElement() == element) {
                tete = tete.getSuivant();
                size--;
                return;
            }
            Noeud precedent = tete;
            Noeud courant = tete.getSuivant();
            while (courant != null && courant.getElement() != element) {
                precedent = precedent.getSuivant();
                courant = courant.getSuivant();
            }
            if (courant != null) {
                precedent.setSuivant(courant.getSuivant());
                size--;
            }
        }
    }
/**
     * supprime tous les éléments de la liste qui correspondent à element passe en paramètre
     * @param element élément à supprimer
    */
    public void supprimeTous(int element) {
       tete = supprimeTousRecurs(element, tete);
    }
/**
 * méthode récursive pour supprimer tous les éléments de la liste qui correspondent à element passe en paramètre
     * @param element élément à supprimer
     * @param tete tête de la liste
     * @return la nouvelle tête de la liste
    */
    public Noeud supprimeTousRecurs(Object element, Noeud tete) {
        if (tete != null) {
            Noeud suiteListe = supprimeTousRecurs(element, tete.getSuivant());
            if (tete.getElement() == element) {
                size--;
                return suiteListe;
            } else {
                tete.setSuivant(suiteListe);
                return tete;
            }
        } else return null;
    }
/**
     * renvoie le dernier élément de la liste
     * @return le dernier élément de la liste et null si la liste est vide ou un seule noeud
    */
    public Noeud getAvantDernier() {
        if (tete == null || tete.getSuivant() == null)
            return null;
        else {
            Noeud courant = tete;
            Noeud suivant = courant.getSuivant();
            while (suivant.getSuivant() != null) {
                courant = suivant;
                suivant = suivant.getSuivant();
            }
            return courant;
        }
    }
/**
     * inverse la liste
    */
    public void inverser() {
        Noeud precedent = null;
        Noeud courant = tete;
        while (courant != null) {
            Noeud next = courant.getSuivant();
            courant.setSuivant(precedent);
            precedent = courant;
            courant = next;
        }
        tete = precedent;
    }
/**
     * renvoie le noeud précédent le noeud r
     * @param r noeud dont on veut le précédent
     * @return le noeud précédent le noeud r
    */
    public Noeud getPrecedent(Noeud r) {
    // la liste n'est pas vide puisqu'on transmet un Node de la liste et le Node existe obligatoirement
        Noeud precedent = tete;
        Noeud courant = precedent.getSuivant();
        while (courant != r) {
            precedent = courant;
            courant = courant.getSuivant();
        }
        return precedent;
    }
/**
     * échange les noeuds r1 et r2 dans la liste
     * @param r1 premier noeud à échanger
     * @param r2 deuxième noeud à échanger
    */
    public void echanger(Noeud r1, Noeud r2) {
        if (r1 == r2)
            return;
        Noeud precedentR1;
        Noeud precedentR2;
        if (r1 != tete && r2 != tete) {
            precedentR1 = getPrecedent(r1);
            precedentR2 = getPrecedent(r2);
            precedentR1.setSuivant(r2);
            precedentR2.setSuivant(r1);
        } else if (r1 == tete) {
            precedentR2 = getPrecedent(r2);
            precedentR2.setSuivant(tete);
            tete = r2;
        }
        else {
            precedentR1 = getPrecedent(r1);
            precedentR1.setSuivant(tete);
            tete = r1;
        }
        Noeud temp = r2.getSuivant();
        r2.setSuivant(r1.getSuivant());
        r1.setSuivant(temp);
    }

}