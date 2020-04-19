package funcionario;

/**
 *
 * @author Fenias
 */
import java.util.*;
import java.io.*;

public class SistemaFuncionario {
    
    private ArrayList<Funcionario> a = new ArrayList<>();
    
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
                char sexo = t.next().charAt(0);
                
                if(sexo == 'M' || sexo == 'F')
                    f.sexo = sexo;
                else
                    System.err.println("Sexo invalido!");
           
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
                
                System.out.println("\n Registo feito com sucesso! \n");
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
    
    public void duplicaTodosSal(){
        
        System.out.println("Digite o codigo a ser duplicado todos salarios!");
        int code = t.nextInt();
        double salario = 0;
                
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i).codigo == code){
                for (int j = 0; j < f.salario.length; j++) {
                    salario= f.salario[j] * 2;
                }
            }
        }
        System.out.println("Salarios duplicados: " + salario);
    }
    
    public void visualizarObj(){
        
        do{
            System.out.println("--------FUNCIONARIO---------- \n"
                    + "1-DADOS PESSOAIS... \n"
                    + "2-SALARIOS MENSAIS... \n"
                    + "3-SALARIO DE UM CERTO MES... \n"
                    + "4-VISUALIZAR A MEDIA ARITMETICA DOS SALARIOS MENSAIS... \n");
            
            switch(t.nextInt()){
                
                case 1: f.toString(); break;
                
                case 2: System.out.println("Digite o codigo: ");
                        int code = t.nextInt();
                        
                        for (int i = 0; i < a.size(); i++) 
                            if(a.get(i).codigo == code)
                                System.out.println(Arrays.toString(f.salario)); break;
                        
                case 3: System.out.println("Digite o codigo: ");
                        int code1 = t.nextInt();
                        System.out.println("Digite o mês: [ 0/1/2/3/4/5/6/7/8/9/10/11 ]");
                        int mes = t.nextInt();
                        
                        for (int i = 0; i < a.size(); i++)
                            if(a.get(i).codigo == code1)
                                for (int j = 0; j < f.salario.length; j++) 
                                    if(f.salario[j] == mes && mes < 12)
                                        System.out.println(Arrays.toString(f.salario)); 
                                        else  System.err.println("índice(numero) do mês inexixtente!"); break;
                                        
                case 4: f.getMediaSalarios(); break;
                default: System.err.println("◘Opação invalida!");
            }
        }while(true);
    }
    
    public void lerFichObjecto(){
        
        try{
            File f = new File ("Funcionario.dat");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            a = (ArrayList<Funcionario>) ois.readObject();
            ois.close();
        }catch(Exception e){
            System.err.println("ERROR!");
        }
    }
     
    public void EscFichObjecto(){
        
        try{
            File f = new File ("Funcionario.dat");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(a);
            oos.close();
        }catch(Exception e){
            System.err.println("ERROR!");
        }
    }
    
    public void menu(){
        
        do{
            System.out.println("1.INTRODUZIR DADOS... \n"
                    + "2.DUPLICAR SALARIOS DE UM CERTO MES... \n"
                    + "3.DUPLICA SALARIOS DE TODOS MESES... \n"
                    + "4.VISUALIZAR... \n"
                    + "5.SAIR!");
            
            switch(t.nextInt()){
                
                case 1: Introduzir(); EscFichObjecto(); break;
                case 2: duplicaSal(); EscFichObjecto(); break;
                case 3: duplicaTodosSal(); EscFichObjecto(); break;
                case 4: visualizarObj(); break;
                case 5: System.exit(0);
                default: System.err.println("◘Opação invalida!");
                
            }
        }while(true);
    }
    
    public SistemaFuncionario(){
        lerFichObjecto();
    }
    
    public static void main(String[] args) {
        SistemaFuncionario s = new SistemaFuncionario();
        s.menu();
        
    }
}
