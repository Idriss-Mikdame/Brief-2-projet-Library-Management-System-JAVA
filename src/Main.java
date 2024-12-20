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
            System.out.println("2-Afficher les livres");
            System.out.println("3-Supprimer un livre");
            System.out.println("5-QUITER");
            System.out.print("votre choix : ");
            choix = input.nextInt();
            switch ( choix){
                case 1:
                    Add();
                    break;
                case 2:
                    Aff();
                    break;
                case 3:
                    Supprimer();
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
    public static void Aff(){
        if (stock.isEmpty()){
            System.out.println("aucun liver :(");
        }else {
            for (int i = 0; i<stock.size();i++){
                System.out.println("Titre de liver est   : "+stock.get(i).titre);
                System.out.println("Auteur de liver est  : "+stock.get(i).auteur);
                System.out.println("L'ISBN de liver est  : "+stock.get(i).isbn);
                System.out.println("la disponibilte est  : "+stock.get(i).dispo);
                System.out.println("---------------------------------------------");
            }
        }
    }
    public static void Supprimer() {
        System.out.print("Entrez l'ISBN du livre à supprimer : ");
        String isbn = input.next();
        boolean supprimer = false;
        for (int i = 0; i < stock.size(); i++) {
            if (stock.get(i).isbn.equals(isbn)) {
                stock.remove(i);
                supprimer = true;
                break;
            }}
        if (supprimer  == false ){
            System.out.println("Aucun livre trouvé avec cet ISBN :(");
        }
    }

}