package View;

import Controler.Operador;
import Model.PrecoData;
import Model.Produto;
import Model.Site;

public class Main {



    public static void main(String[] args) {
        Operador operador = new Operador();

        operador.lerProdutosBanco();

        operador.obterHistoricoCompleto("Playstation 5");

        PrecoData novo;
        novo = operador.menorPrecoProduto("Playstation 5", "17/12/2023");
        System.out.println("Menor preço na data "+ novo.getData()+": "+novo.getPreco()+ "R$  -->  Site: "+novo.getSite().getNome());

    }
}