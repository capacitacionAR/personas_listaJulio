import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("personas.txt"));
        Scanner tc = new Scanner(System.in);
        ArrayList<Persona> listaPersonas = new ArrayList<>();

        sc.useDelimiter("[;\\n]");

        int mayoresEdad = 0, cantidadape = 0;

        while(sc.hasNextInt()){
            int docu = sc.nextInt();
            String nom = sc.next();
            String ape = sc.next();
            int eda = sc.nextInt();

            Persona nueva = new Persona(docu,nom,ape,eda);
            listaPersonas.add(nueva);

        }
        sc.close();
       for(Persona p: listaPersonas){
           if(p.getEdad() > 18)
               mayoresEdad++;
       }
        System.out.println("Ingrese un apellido y si quiere salir ponga punto (.)");
       String busca = tc.next();
       while(!busca.equals(".")){
           for (Persona p: listaPersonas){
               if (p.getApellido().equalsIgnoreCase(busca)){
                   System.out.println(p.getNombre()+" "+p.getApellido()+" "+p.getDocumento());
                   cantidadape++;
               }

           }
           System.out.println("Ingrese un apellido y si quiere salir ponga punto (.)");
           busca = tc.next();

       }
        System.out.println("La cantidad de mayores de edad: "+mayoresEdad);
        System.out.println("la cantidad de apellidos segun lo buscado "+cantidadape);
    }
}
