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
            System.out.println("4-Rechercher un livre");
            System.out.println("5-Modifier un livre");
            System.out.println("6-QUITER");
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
                case 4:
                    Rechercher();
                    break;
                case 5:
                    Modifier();
                    break;
                case 6:
                    System.out.println("BYEE");
                    break;
                default:
                    System.out.println("choix invalide !!!!!");
            }
        }while (choix != 6);

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
                System.out.println("--------------------------------------------->"+(i+1));
                System.out.println("Titre de liver est   : "+stock.get(i).titre);
                System.out.println("Auteur de liver est  : "+stock.get(i).auteur);
                System.out.println("L'ISBN de liver est  : "+stock.get(i).isbn);
                System.out.println("la disponibilité est  : "+stock.get(i).dispo);
                System.out.println("<--------------------------------------------->");
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
                System.out.println("la suppression est success :)");
                supprimer = true;
                break;
            }}
        if (supprimer  == false ){
            System.out.println("Aucun livre trouvé avec cet ISBN :(");
        }
    }
    public static void Rechercher(){
        System.out.print("Entrez l'ISBN du livre à rechercher : ");
        String isbn = input.next();
        boolean rechercher = false;
        for (int i = 0 ;i<stock.size();i++){
            if (stock.get(i).isbn.equals(isbn)){
                System.out.println("Titre de liver est   : "+stock.get(i).titre);
                System.out.println("Auteur de liver est  : "+stock.get(i).auteur);
                System.out.println("L'ISBN de liver est  : "+stock.get(i).isbn);
                System.out.println("la disponibilte est  : "+stock.get(i).dispo);
                System.out.println("la Rechercher  est success :)");
                rechercher = true;
                break;
            }
        }
        if (rechercher==false){
            System.out.println("aucune liver :(");
        }
    }
    public static void Modifier(){
        System.out.print("Entrerz l'ISBN du livre a modifier : ");
        String isbn = input.next();
        boolean modifier = false;
        for (int i = 0 ;i<stock.size();i++) {
            System.out.println("Livre trouvé ! Que voulez-vous modifier ?"+i);
            System.out.println("1. Titre");
            System.out.println("2. Auteur");
            System.out.println("3. Disponibilité");
            System.out.println("4. Annuler");
            System.out.print("Votre choix : ");
            int choix = input.nextInt();
            if (stock.get(i).isbn.equals(isbn)) {
                switch (choix) {
                    case 1:
                    System.out.print("Nouveau Titre : ");
                    stock.get(i).titre = input.next();
                    System.out.println("la modification est success :)");
                    break;
                    case 2:
                    System.out.print("Nouveau Auteur : ");
                    stock.get(i).auteur = input.next();
                    System.out.println("la modification est success :)");
                    break;
                    case 3:
                    System.out.print("Nouveau Disponibilité : ");
                    stock.get(i).dispo = input.nextBoolean();
                    System.out.println("la modification est success :)");
                    break;
                    case 4:
                   System.out.println("annule !");
                   break;
                }
                modifier = true;
                break;
            }
        }
        if (modifier == false){
            System.out.println("ucun livre trouvé avec cet ISBN :(");
        }
    }
}