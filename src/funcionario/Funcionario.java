package funcionario;

/**
 *
 * @author Fenias
 */
import java.io.*;
import java.util.*;

public class Funcionario implements Serializable{

    public int codigo;
    public String nome;
    public char sexo;
    public double salario[] = new double[12];

    public Funcionario() {
    }

    public Funcionario(int codigo, String nome, char sexo, double salario[]) {
        this.codigo = codigo;
        this.nome = nome;
        this.sexo = sexo;
        for (int i = 0; i < salario.length; i++) {
            salario[i] = 0;
        }
    }
    
    public double getSomaSalarios(){
        double somaS = 0;
        
        for (int i = 0; i < salario.length; i++) 
            somaS += this.salario[i];
        
        return somaS;
    }
    
    public double getMediaSalarios(){
        double Med = 0;

        Med = this.getSomaSalarios() / 12;
        
        System.out.println("Media Aritmética do salario do Funcionario: " + Med);
        
        return Med;
    }
    
    public String imprimir() {
        return "\n Funcionario{\n" + " codigo= " + codigo + ",\n nome=" + nome + ",\n sexo=" + sexo + ",\n salario="
                + Arrays.toString(salario) + "\n" + '}' + "\n";
    }
    
    /*
        Duplicar salario do indice de um certo Mês!
    */
    public void duplicaSalario(int m) {
        
        double dup = this.salario[m] * 2;
        
        this.salario[m] = dup;
        
        if(m >= 12)
           System.err.println("índice(numero) do mês inexixtente!");
        
        System.out.println("\n Salario duplicado pra: " + dup + "! \n");
    }
    
    /*
        Duplica todos salarios no Array salario
    */
    public void dupTodosSal(){
        double dup;
        
        for (int i = 0; i < salario.length; i++) {
            dup = this.salario[i] * 2;
            this.salario[i] = dup;
        }    
    }
  
    public static void main(String[] args) {
        Funcionario j = new Funcionario();
        j.getSomaSalarios();
    }
}
