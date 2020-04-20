package funcionario;

/**
 *
 * @author Fenias
 */
import java.util.*;
import java.io.*;

public class SistemaFuncionario {
    
    private ArrayList<Funcionario> a = new ArrayList<>();
    
    private final Scanner t = new Scanner(System.in);
    
    public void Introduzir(){
    Funcionario f;
    
        int codigo = 0;
        
        do{
            System.out.println("Introduza o codigo: ");
            codigo = t.nextInt();
            
            if(codigo > 0 && existe(codigo) == false){
                
                f = new Funcionario();
                f.codigo = codigo;
                System.out.println("Digite o nome: ");
                f.nome = t.next();
                
                System.out.println("Introduza o sexo: \"M/F\" ");
                char sexo = t.next().charAt(0);
                char sexo1;
                
                if(sexo == 'M' || sexo == 'F')
                    f.sexo = sexo;
                else{
                    System.err.println("Sexo invalido! \n");
                    System.out.println("Introduza o sexo Valido: \"M/F\" ");
                    sexo1 = t.next().charAt(0);
                    f.sexo = sexo1;
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
        Funcionario r;
        
        System.out.println("\n Digite o codigo a ser duplicado todos salarios!");
        int code = t.nextInt();
        System.out.println("Digite o mês: [ 0/1/2/3/4/5/6/7/8/9/10/11 ]");
        int mes = t.nextInt();
                
        for (int i = 0; i < a.size(); i++){ 
            r = a.get(i);
            if(r.codigo == code)
                r.duplicaSalario(mes);
        }    
    }
    
    /*
        Duplica todos salarios do Array
    */
    public void duplicaTodosSal(){
        Funcionario x;
        
        System.out.println("Digite o codigo a ser duplicado todos salarios!");
        int code = t.nextInt();
                
        for (int i = 0; i < a.size(); i++) {
            x = a.get(i);
            if(x.codigo == code)
                x.dupTodosSal(); // Metodo da classe Funcionario que duplica todos salarios no Array funcionario
        }
        
        System.out.println("Salarios duplicados! ");
    }
    
    public void imprimir(){
        Funcionario h;
        
        System.out.println("Digite o codigo: ");
        int code = t.nextInt();

        for (int i = 0; i < a.size(); i++) {
            h = a.get(i);
            if(h.codigo == code)
                System.out.println(h.imprimir());
        }    
    }
    
    public void imprimirTodosFun(){
        for(Funcionario s : a) // Metodo foreach para imprimir tudo no ArrayList
            System.out.println(s.imprimir());
    }
    
    /*
        imprime salarios mensais de Funcionario
    */
    public void salMensais(){
        Funcionario b;
        
        System.out.println("Digite o codigo: "); // Codigo para encotrar o Funcionario!
        int code = t.nextInt();
        
        for (int i = 0; i < a.size(); i++) {
            b = a.get(i);
            if(b.codigo == code)
               System.out.println(Arrays.toString(b.salario));
        }    
    }
    
    public void salDeCertoMes(){
        Funcionario m;
        
        System.out.println("Digite o codigo: ");
        int code1 = t.nextInt();
        System.out.println("Digite o mês: [ 0/1/2/3/4/5/6/7/8/9/10/11 ]");
        int mes = t.nextInt();
        
        switch(mes){
            
            case 0: System.out.println("\n Janeiro: "); break;
            case 1: System.out.println("\n Fevereiro: "); break; 
            case 2: System.out.println("\n Março: "); break; 
            case 3: System.out.println("\n Abril: "); break; 
            case 4: System.out.println("\n Maio: "); break; 
            case 5: System.out.println("\n Junho: "); break; 
            case 6: System.out.println("\n Julho: "); break; 
            case 7: System.out.println("\n Agosto: "); break; 
            case 8: System.out.println("\n Setembro: "); break; 
            case 9: System.out.println("\n Outubro: "); break; 
            case 10: System.out.println("\n Novembro: "); break; 
            case 11: System.out.println("\n Dezembro: "); break; 
            
        }
        
        for (int i = 0; i < a.size(); i++){
            m = a.get(i);
            if(m.codigo == code1){
                System.out.println("Salario do mês de " + mes + ": " + m.salario[mes]); // Imprimido indice do Array  
            }    
            if(m.salario[mes] >= 12)
               System.err.println("índice(numero) do mês inexixtente!");
        }    
    }
    
    public void MedAritmetica(){
        Funcionario z;
        
        System.out.println("Digite o codigo: ");
        int code = t.nextInt();
        
        for (int i = 0; i < a.size(); i++) {
            z = a.get(i);
            if(z.codigo == code) 
               z.getMediaSalarios();
        }    
    }
    
    public void visualizarObj(){
        
        do{
            System.out.println("\n --------FUNCIONARIO---------- \n"
                    + "1-DADOS PESSOAIS... \n"
                    + "2-DADOS DE TODOS FUNCIONARIOS... \n"
                    + "3-SALARIOS MENSAIS... \n"
                    + "4-SALARIO DE UM CERTO MES... \n"
                    + "5-VISUALIZAR A MEDIA ARITMETICA DOS SALARIOS MENSAIS... \n"
                    + "6-MENU... \n");
            
            switch(t.nextInt()){
                
                case 1: imprimir(); break;
                case 2: imprimirTodosFun(); break;
                case 3: salMensais(); break;
                case 4: salDeCertoMes(); break;
                case 5: MedAritmetica(); break;
                case 6: this.menu(); break;
                default: System.err.println("◘Opação invalida!");
                
            }
        }while(true);
    }
     
    public void EscFichObjecto(){
        
        try{
            File F = new File ("Funcionario.Dat");
            FileOutputStream fos = new FileOutputStream(F);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(a);
            oos.close();
        }catch(Exception e){
            System.err.println("ERROR NA ESCRITA DO FICHEIRO! " + e.getMessage());
        }
    }
    
    public void lerFichObjecto(){
        
        try{
            File F = new File ("Funcionario.Dat");
            FileInputStream fis = new FileInputStream(F);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            a = (ArrayList<Funcionario>) ois.readObject();
            ois.close();
        }catch(Exception e){
            System.err.println("ERRO NA LEITURA DO FICHEIRO! " + e.getMessage());
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
        SistemaFuncionario d = new SistemaFuncionario();
        d.menu();
    }
}
