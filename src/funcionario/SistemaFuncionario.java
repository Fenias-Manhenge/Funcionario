package funcionario;

/**
 *
 * @author Fenias
 */
import java.util.*;
import java.io.*;

public class SistemaFuncionario implements Serializable{
    
    private ArrayList<Funcionario> a = new ArrayList<>();
    
    private final Scanner t = new Scanner(System.in);
    
    private boolean hasCode = false;
    /*
        Introduz os objectos no ArrayList
    */
    public void Introduzir(){
    Funcionario f;
    
        int codigo = 0;
        
        do{
            System.out.println("\n Introduza o codigo: ");
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
           
                System.out.println("\n Introduza o salario do Mês: \n 0-JANEIRO \n "
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
    
    /*
        Metodo que verifica se existe codigo de um funcionario no ArrayList
    */
    private boolean existe(int codigo){
        boolean hascode = false;
        
        for (Funcionario s : a) 
            if(s.codigo == codigo){
                hascode = true;
                System.err.println("\n Codigo existente, digite outro codigo! \n");
            }    
        return hascode;
    }
    
    /*
        Duplica salario de um certo mês
    */
    public void duplicaSal(){
        System.out.println("\n Digite o codigo a ser duplicado todos salarios!");
        int code = t.nextInt();
        System.out.println("Digite o mês: [ 0/1/2/3/4/5/6/7/8/9/10/11 ]");
        int mes = t.nextInt();
        
        for (Funcionario r : a) {
            if(r.codigo == code && mes < 12)
                r.duplicaSalario(mes); // Metodo da classe funcionario, "duplica salario" .
            else   
                System.err.println("índice(numero) do mês inexixtente! \n"
                        + "Indices validos [ 0/1/2/3/4/5/6/7/8/9/10/11 ]... ou codigo inexistente!");
        }    
    }
    
    /*
        Duplica todos salarios do Array
    */
    public void duplicaTodosSal(){
        System.out.println("\n Digite o codigo a ser duplicado todos salarios!");
        int code = t.nextInt(); 
        boolean hasCode = false;
        
        for (Funcionario x : a) 
            if(x.codigo == code){
                hasCode = true;
                x.dupTodosSal(); // Metodo da classe Funcionario que duplica todos salarios no Array funcionario
            } if(! hasCode) System.err.println("Codigo inexistente!");    
    }
    
    /*
        Imprime o método toString
    */
    public void imprimir(){
        System.out.println("Digite o codigo: ");
        int code = t.nextInt();
        boolean hasCode = false;
        
        for (Funcionario h : a) {
            if(h.codigo == code ){
                hasCode = true; 
                System.out.println(h.imprimir());
            } 
        } if(! hasCode) System.err.println("Codigo inexistente!");
    }
    
    /*
        Imprimir nome do funcionario e a soma dos salarios do mês de Janeiro e Dezembro!
    */
    public void immprimeNomESoma(){
        System.out.println("Digite o codigo: ");
        int code = t.nextInt();
        boolean hasCode = false;
        
        for (Funcionario b : a) {
            if(b.codigo == code ){
                hasCode = true; 
                b.imprimeNome();
            } 
        } if(! hasCode) System.err.println("Codigo inexistente!");
    }
    
    /*
        Imprime objectos do ArrayList!
    */
    public void imprimirTodosFun(){
        System.out.println("Digite o codigo de Administrador: ");
        
        for(Funcionario s : a) // Metodo foreach para imprimir tudo no ArrayList
            if (t.nextInt() == 11255){ // Codigo do Administrador
                System.out.println(s.imprimir());
            } else 
                System.err.println("Codigo inexistente! \n");    
    }
    
    /*
        imprime salarios mensais de Funcionario
    */
    public void salMensais(){
        boolean hasCode = false;
        
        System.out.println("Digite o codigo: "); // Codigo para encotrar o Funcionario!
        int code = t.nextInt(); 

        for(Funcionario b : a) // ciclo forEach
            if(b.codigo == code){
                hasCode = true;
                System.out.println(Arrays.toString(b.salario));
            }    
        if(! hasCode) System.err.println("\n Codigo inexistente!");
    }
    
    /*
        Imprime salario de um certo indice do Array salario
    */
    public void salDeCertoMes(){
        
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
        
        a.forEach((m) -> {
            if(m.codigo == code1 && mes < 12){
                System.out.println("Salario do mês de " + mes + ": " + m.salario[mes]); // Imprimido indice do Array
            }else   
                System.err.println("índice(numero) do mês inexixtente! \n"
                        + "Indices validos [ 0/1/2/3/4/5/6/7/8/9/10/11 ]... ou codigo inexistente!");
        });
    }
    
    /*
        Media Aritmetica dos salarios de um funcionario
    */
    public void MedAritmetica(){
        boolean hasCode = false;
        
        System.out.println("Digite o codigo: ");
        int code = t.nextInt();
        
        for (Funcionario z : a) 
            if(z.codigo == code){ 
                hasCode = true;
                z.getMediaSalarios();
            }   
        if(! hasCode) System.err.println("\n Codigo inexistente!");
    }
    
    /*
        Soma salarios do Mês de Janeiro e Dezembro
    */
    public void somaSalDoMesJanEDez(){
        boolean hasCode = false;
        
        System.out.println("\n Digite o codigo: ");
        int code = t.nextInt();
        
        for (Funcionario l : a) 
            if(l.codigo == code){ 
                hasCode = true;
                l.somaSalJanEDez();
            }
        if(! hasCode) System.err.println("\n Codigo inexistente!");
    }
    
    public void visualizarObj(){
        
        do{
            System.out.println("\n --------FUNCIONARIO---------- \n"
                    + "1-DADOS PESSOAIS... \n"
                    + "2-IMPRIME NOME DO FUNCIONARIO... \n"
                    + "3-DADOS DE TODOS FUNCIONARIOS... \n"
                    + "4-SALARIOS MENSAIS... \n"
                    + "5-SALARIO DE UM CERTO MES... \n"
                    + "6-VISUALIZAR A MEDIA ARITMETICA DOS SALARIOS MENSAIS... \n"
                    + "7-MENU... \n");
            
            switch(t.nextInt()){
                
                case 1: imprimir(); break;
                case 2: immprimeNomESoma(); break;
                case 3: imprimirTodosFun(); break;
                case 4: salMensais(); break;
                case 5: salDeCertoMes(); break;
                case 6: MedAritmetica(); break;
                case 7: this.menu(); break;
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
    
    public final void lerFichObjecto(){
        
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
            System.out.println("\n 1.INTRODUZIR DADOS... \n"
                    + "2.DUPLICAR SALARIOS DE UM CERTO MES... \n"
                    + "3.DUPLICA SALARIOS DE TODOS MESES... \n"
                    + "4.SOMA DO SALARIO DO MES DE JANEIRO E FEVEREIRO... \n"
                    + "5.VISUALIZAR... \n"
                    + "6.SAIR!");
            
            switch(t.nextInt()){
                
                case 1: Introduzir(); EscFichObjecto(); break;
                case 2: duplicaSal(); EscFichObjecto(); break;
                case 3: duplicaTodosSal(); EscFichObjecto(); break;
                case 4: somaSalDoMesJanEDez(); EscFichObjecto(); break;
                case 5: visualizarObj(); break;
                case 6: System.exit(0);
                default: System.err.println("◘Opação invalida!");
                
            }
        }while(true);
    }
    
    public SistemaFuncionario(){
        lerFichObjecto();
        EscFichObjecto();
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        SistemaFuncionario d = new SistemaFuncionario();
        d.menu();
    }
}
