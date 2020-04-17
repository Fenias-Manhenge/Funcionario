package funcionario;

/**
 *
 * @author Fenias
 */
import java.io.*;

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
        
        for (int i = 0; i < salario.length; i++) {
            somaS += this.salario[i];
        }
        
        return somaS;
    }
    
    public double getMediaSalarios(){
        double Med = 0;
        
        for (int i = 0; i < salario.length; i++) {
            Med = this.getSomaSalarios() / 12;
        }
        
        return Med;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void duplicaSalario(int m){
                
        for (int i = 0; i < salario.length; i++) {
            if(salario[i] == m)
                this.salario[i] *= 2; 
        }
    }
}
