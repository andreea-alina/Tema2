import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {


        //crearea unui obiect de tip BookService pentru a putea face legatura cu aceasta clasa

        public static BookService bookService = new BookService();

        public static Scanner sc;


        public static void main(String[] args){

            //instantierea unui obiect de tip File ce va face referire la un txt file in Java

            File txt = new File("E:\\Scoala Informala\\Teme trimise\\Tema 2\\Proiect_BooksOnline\\obiecteCarti.txt");

            //cream un obiect Scanner prin care suntem atentionati ca trebuie sa citim fisierul dat ca argument;
            // Mai departe citirea propriu-zisa o facem cu metoda readFile (metoda ce face procesari in document si identifica fiecare tip de carte);
            //Scanner "contine" fisierul si stie sa faca citirea lui linie cu linie prin metoda readFile() unde am "sc.hasNextLine"
            //Java ma va obliga sa tratez aceasta exceptie de compilare (folosim blocul try-catch)


            try {
                sc = new Scanner(txt);
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }

            //in clasa ServiceBook am metoda readFile care imi returneaza o lista de Carti de tip Book
            // fiind o metoda ce returneaza ceva pot stoca rezultatul intr-o lista avand mai departe nevoie de ea
            //pasez metodei un scanner care stie ca trebuie sa citeasca din acel fisier

            List<Book> listaCarti = bookService.readFile(sc);

            System.out.println("---Printarea listei cu duplicate---");

            bookService.printBookList(listaCarti);


            //doresc ca lista mea sa elimine duplicatele, astfel am definit metoda "removeDuplicates()" in clasa BookService prin care am adaugat intr-o noua lista elementele neduplicate

            List<Book> listaFaraDuplicate = bookService.removeDuplicates(listaCarti);

            System.out.println("---Printarea listei mele fara duplicate---");

            bookService.printBookList(listaFaraDuplicate);


        //doresc ca userul sa vada un meniu de selectare a cartilor dorite

            System.out.println("---Afisare meniu de selectare a tipului de carti--- ");


            bookService.bookMenu(listaFaraDuplicate);








        }

    }



