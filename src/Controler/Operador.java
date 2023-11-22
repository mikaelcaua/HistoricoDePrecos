package Controler;

import Model.PrecoData;
import Model.Produto;
import Model.Site;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class Operador {
    Hashtable<String,Produto> produtos;

    public Operador() {
        produtos = new Hashtable<>();
    }

//    public void addProduto(Produto produto, Site site, Float preco, String data){
//        produto.getSites().get(site.getNome()).getPrecoDatas().add(new PrecoData(preco,data));
//        produtos.put(produto.getNome(), produto);
//    }

    public void addProduto(String produtoNome, String siteNome, Float preco, String data) {
        if ((produtos.containsKey(produtoNome)==false)) {
            Produto produto = new Produto(produtoNome);
            produtos.put(produto.getNome(), produto);
        }

        if ((produtos.get(produtoNome).getSites().containsKey(siteNome)==false)) {
            Site site = new Site(siteNome);
            produtos.get(produtoNome).getSites().put(siteNome, site);
        }

        produtos.get(produtoNome).getSites().get(siteNome).getPrecoDatas().add(new PrecoData(preco, data));
    }


    public PrecoData menorPrecoProduto(String produto, String dataAtual) {
        PrecoData menorPrecoData = null;

        for (Site site : produtos.get(produto).getSites().values()) {
            for (PrecoData precoData : site.getPrecoDatas()) {
                if (precoData.getData().equals(dataAtual) && (menorPrecoData == null || precoData.getPreco() < menorPrecoData.getPreco())) {
                    menorPrecoData = precoData;
                    menorPrecoData.setSite(site);
                }
            }
        }

        return menorPrecoData;
    }

    public void obterHistoricoCompleto(String produto){
        System.out.println("\n--------------------"+produto+"--------------------");
        for(String siteNome:produtos.get(produto).getSites().keySet()){
            System.out.println("\n----------"+siteNome+"----------");
            for(PrecoData precoData:produtos.get(produto).getSites().get(siteNome).getPrecoDatas()){
                System.out.println("Preço:"+precoData.getPreco()+" -- Data:"+precoData.getData());
            }
        }
        System.out.println("\n-------------------------------------------------------------\n");
    }
    //to printando aqui, mas sei q é errado, foi só pra facilitar o serviço

    public void lerProdutosBanco(){
        try{
            BufferedReader leitor = new BufferedReader(new FileReader("Banco.txt"));
            String linha;
            while ((linha = leitor.readLine())!=null){
                String[] quebrada = linha.split(";");
                this.addProduto(quebrada[0], quebrada[1], Float.parseFloat(quebrada[2]), quebrada[3]);
            }
            leitor.close();
        }
        catch (IOException e){
            System.out.println("Não foi possível ler o arquivo");
            e.printStackTrace();
        }
    }

}
