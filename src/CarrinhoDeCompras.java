import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras{
    private List<Item> ItemList;

    public CarrinhoDeCompras(){
        this.ItemList = new ArrayList<>();
    }
    
    public void adicionarItem(String nome, double preco, int quantidade){
        ItemList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> ItensParaRemover = new ArrayList<>();
        for(Item i : ItemList) {
            if(i.getNome() .equalsIgnoreCase(nome)){
                ItensParaRemover.add(i);
            }
        }
        ItemList.removeAll(ItensParaRemover);
    }
    
    public double calcularValorTotal() {
        double total = 0.0;
        for(Item item : ItemList) {
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }

    public void exibirItens() {
        System.out.println(ItemList);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        carrinho.adicionarItem("Sabonete", 10.0, 4);
        carrinho.adicionarItem("Feijão", 8.50, 2);
        carrinho.adicionarItem("Arroz", 4.50, 3);
        carrinho.adicionarItem("Shampoo", 13.0, 1);

        carrinho.exibirItens();

        carrinho.removerItem("Sabonete");

        carrinho.exibirItens();

        System.out.println("Valor total do carrinho: R$ " + carrinho.calcularValorTotal());
    }
}