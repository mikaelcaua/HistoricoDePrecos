package Model;

import java.util.ArrayList;

public class Site {
    private String nome;
    ArrayList <PrecoData> precoDatas;

    public Site(String nome) {
        this.nome = nome;
        precoDatas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<PrecoData> getPrecoDatas() {
        return precoDatas;
    }
}
