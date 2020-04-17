package funcionario;

/**
 *
 * @author Fenias
 */
import java.util.*;

public class SistemaFuncionario {
    
    private final ArrayList<Funcionario> a = new ArrayList<>();
    
    private final Funcionario f = new Funcionario();
    
    private final Scanner t = new Scanner(System.in);
    
    public void Introduzir(){
        
        int codigo = 0;
        
        do{
            System.out.println("Introduza o codigo: ");
            codigo = t.nextInt();
            
            if(codigo > 0 && existe(codigo) == false){
                
                f.codigo = codigo;
                System.out.println("Digite o nome: ");
                f.nome = t.next();
                
                System.out.println("Introduza o sexo: \"M/F\" ");
                char sexo[] = {'M','F'};
                for (int i = 0; i < sexo.length; i++) {
                    char sexo1 = t.next().charAt(0);
                    if(sexo[i] == sexo1){
                        f.sexo = sexo1;
                    }else{
                        System.err.println("Sexo invalido!");
                    }
                }
                
                System.out.println("Introduza o salario do Mês: \n 0-JANEIRO \n "
                        + "1-FEVEREIRO \n"
                        + "2-MARÇO \n"
                        + "3-ABRIL \n"
                        + "4-MAIO \n"
                        + "5-JUNHO \n"
                        + "6-JULHO \n"
                        + "7-AGOSTO \n"
                        + "8-SETEMBRO \n"
                        + "9-OUTUBRO \n"
                        + "10-NOVEMBRO \n"
                        + "11-DEZEMBRO \n");

                for (int i = 0; i < f.salario.length; i++) {
                    System.out.println("Digite o salario do " + i + "º mês:");
                    f.salario[i] = t.nextDouble();
                }
        
                a.add(f);
                
                System.out.println("\n Registo feito com sucesso!");
            }
            
        }while(codigo != 0);
    }
    
    public boolean existe(int codigo){
        boolean hascode = false;
        
        for (int i = 0; i < a.size(); i++) 
            if(a.get(i).codigo == codigo)
                hascode = true;
        
        return hascode;
    }
    
    public void duplicaSal(){
        System.out.println("Digite o mês: [ 0/1/2/3/4/5/6/7/8/9/10/11 ]");
        int mes = t.nextInt();
     
        f.duplicaSalario(mes);
    }
}
