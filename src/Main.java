import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Book> stock = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        //Scanner cs = new Scanner(System.in);
        int choix;
        do{

            System.out.println("--GESTION DE LIVERS--");
            System.out.println("1-Ajouter UN liver");
            System.out.println("5-QUITER");
            System.out.print("votre choix : ");
            choix = input.nextInt();
            switch ( choix){
                case 1:
                    Add();
                    break;

                case 5:
                    System.out.println("BYEE");
                    break;
                default:
                    System.out.println("choix invalide !!!!!");
            }
        }while (choix != 5);

    }
    public static void Add(){
        System.out.print("Entrez le titre du livre : ");
        String titre = input.next();
        System.out.print("Entrez l'auteur du livre : ");
        String auteur = input.next();
        System.out.print("Entrez l'ISBN du livre   : ");
        String isbn = input.next();
        System.out.print("Disponible (true/false)  : ");
        boolean dispo = input.nextBoolean();
        stock.add(new Book(titre,auteur,isbn,dispo));
    }


}