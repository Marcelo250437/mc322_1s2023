
import java.util.ArrayList;

public class Frota {
    private String code;
    private ArrayList<Veiculo> listaVeiculos;

    //construtor
    public Frota(String code, Veiculo veiculo) {
        this.code = code;
        listaVeiculos = new ArrayList<Veiculo>();
        listaVeiculos.add(veiculo);
    }

    public String toString() {
        String dados = ""; 
        dados += "Code: " + this.code + "\nLista de Veiculos da Frota:\n" + this.listaVeiculos + "\n";

        return dados;
    }
    
    
    public boolean cadastrarVeiculo(Veiculo veiculo){
        if(!listaVeiculos.contains(veiculo)){
            listaVeiculos.add(veiculo);
            return true;
        }
        return false;
    }

    
    public boolean removerVeiculo(Veiculo veiculo){
        if(listaVeiculos.contains(veiculo)){
            listaVeiculos.remove(veiculo);
            return true;
        }
        return false;
    }

    
    public boolean removerVeiculo(String placaVeiculo){
        for(Veiculo v : listaVeiculos){
            if(v.getPlaca().equals(placaVeiculo)){
                listaVeiculos.remove(v);
                return true;
            }
        }
        return false;
    }

    //getters e setters
    public String getCode() {
        return code;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    
    
}