package metier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit, Long> {
    private List<Produit> produits;

    public MetierProduitImpl() {
        this.produits = new ArrayList<>();
    }

    @Override
    public void add(Produit o) {
        this.produits.add(o);
    }

    @Override
    public List<Produit> getAll() {
        return this.produits;
    }

    @Override
    public Produit findById(Long id) {
        if (id == null) {
            return null;
        }

        for (Produit produit : this.produits) {
            if (produit.getId().equals(id)) {
                return produit;
            }
        }
        return null;
    }


    // using iterator to avoid ConcurrentModificationException / could use removeIf too
    @Override
    public void delete(Long id) {
        Iterator<Produit> produitIterator = this.produits.iterator();

        while (produitIterator.hasNext()) {
            Produit produit = produitIterator.next();
            if (produit.getId().equals(id)) {
                produitIterator.remove();
            }
        }

    }
}
