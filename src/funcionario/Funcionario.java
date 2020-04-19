package funcionario;

/**
 *
 * @author Fenias
 */
import java.io.*;
import java.util.Arrays;

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
        
        for (int i = 0; i < salario.length; i++) 
            Med = this.getSomaSalarios() / 12;
        
        return Med;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "codigo= " + codigo + ",\n nome=" + nome + ",\n sexo=" + sexo + ",\n salario="
                + Arrays.toString(salario) + '}';
    }

   
    
    public void duplicaSalario(int m) {
        for (int i = 0; i < this.salario.length; i++) {
            if(this.salario[m] == m && m < 12)
                this.salario[i] *= 2; 
            else
                System.err.println("índice(numero) do mês inexixtente!");
            
            System.out.println("\n Salario duplicado!");
        }
    }
}
