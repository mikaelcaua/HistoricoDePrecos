package Model;

import java.util.ArrayList;
import java.util.Hashtable;

public class Produto {
    private String nome;
    Hashtable <String, Site > sites;

    public Produto(String nome) {
        this.nome = nome;
        sites = new Hashtable<>();
    }

    public String getNome() {
        return nome;
    }

    public Hashtable<String, Site> getSites() {
        return sites;
    }
}
