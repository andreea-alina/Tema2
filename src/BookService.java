import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class BookService {


    private Scanner scan = new Scanner(System.in);

    private List<Atlas> listaObiecteAtlas = new ArrayList<Atlas>();

    private List<Roman> listaObiecteRoman = new ArrayList<Roman>();

    private List<Revista> listaObiecteRevista = new ArrayList<Revista>();

    private List<ArtAlbum> listaObiecteArtAlbum = new ArrayList<ArtAlbum>();


    //metoda ce primeste ca si argument un scanner ce contine un fisier
    //metoda are ca si return tipe o lista de obiecte de tip Book

    public List<Book> readFile(Scanner sc) {


        List<Book> listaCarti = new ArrayList<>();

        while (sc.hasNextLine()) {   //verifica daca in fisier exista o linie care poate fi citita

            //se salveaza linia gasita sub forma de String, dar va trebui sa delimitam/spargem acest String in valori individuale
            //pe care le vom salva intr-un array de tip String (listSplit)
            //parcurgem prima linie, va fi sparta in elemente (dupa demilitatorul ";") cu metoda split(), elemente ce vor fi adaugate apoi array-ului;
            //parcurgerea se va face succesiv - citire linie1, salvare in string, compare prin switch...citire linie 2, salvare in string, compare prin switch etc.

            String line = sc.nextLine();

            String[] listaSplit = line.split(";");

            //in fisierul "obiecteCarti.txt" am adaugat la inceputul fiecarei linii tipul de carte: Book, Atlas, Roman, Revista, ArtAlbum;
            // in acest mod pot delimita care este tipul fiecarui obiect;
            //pentru a sti acest tip trebuie sa fac referire la primul element al liniei (listSplit[0]) urmand ca apoi sa folosesc
            //bucla switch pentru a compara acest element gasit (tipul de carte) cu Atlas, Roman, Revista, ArtAlbum, sau Book
            // in functie de ce identifica voi crea obiecte corespunzatoare;
            //obiectele primesc odata cu apelul constructorului corespunzator, valori pentru variabile, acest valori fiind elementele din array
            //am convertit stringurile la valori de int sau double acolo unde a fost necesara conversia folosint parteInt()/parseDouble();
            //in lista declarata "listaCarti" voi adauga toate obiectele de orice tip, iar in final voi returna aceasta lista;

            switch (listaSplit[0]) {

                case "Atlas":

                    listaCarti.add(new Atlas(listaSplit[1], listaSplit[2], listaSplit[3], listaSplit[4], Integer.parseInt(listaSplit[5]), Double.parseDouble(listaSplit[6]), Integer.parseInt(listaSplit[7])));

                    break;

                case "Roman":

                    listaCarti.add(new Roman(listaSplit[1], listaSplit[2], listaSplit[3], listaSplit[4], Integer.parseInt(listaSplit[5]), Double.parseDouble(listaSplit[6]), listaSplit[7]));
                    break;

                case "Revista":

                    listaCarti.add(new Revista(listaSplit[1], listaSplit[2], listaSplit[3], listaSplit[4], Integer.parseInt(listaSplit[5]), Double.parseDouble(listaSplit[6]), listaSplit[7]));

                    break;

                case "ArtAlbum":

                    listaCarti.add(new ArtAlbum(listaSplit[1], listaSplit[2], listaSplit[3], listaSplit[4], Integer.parseInt(listaSplit[5]), Double.parseDouble(listaSplit[6]), Integer.parseInt(listaSplit[7])));
                    break;

                default:

                    listaCarti.add(new Book(listaSplit[1], listaSplit[2], listaSplit[3], listaSplit[4], Integer.parseInt(listaSplit[5]), Double.parseDouble(listaSplit[6])));

            }

        }

        return listaCarti;
    }

    // am declarat o metoda generica prin care pot pasa ca si argument o lista specifica de obiecte de un anumit fel;
    //m-am folosit de aceasta metoda sa afisez listele de obiecte de orice tip in functie de ce voi indica prin generic;

    public <T> void printBookList(List<T> list) {

        for (T t : list) {

            System.out.println(t);
        }
    }


    //metoda de tip return type prin care doresc sa sterg duplicatele dintr-o lista de obiecte Book

    public static List<Book> removeDuplicates(List<Book> list) {

        List<Book> listaFaraDuplicate = new ArrayList<>();

        // pentru fiecare element de tip Book din lista verific daca este existent in lista noua "listaFaraDuplicate"
        // initial lista nu contine elemente, verifica daca exista primul element - cum nu exista il adauga, apoi compara urmatorul element cu anterioarele existente
        // metoda contains() merge in legatura cu suprascrierea metodei equals(), astfel am suprascris metoda equals in clasa Book si in subclasele mele

        for (Book element : list) {

            if (!listaFaraDuplicate.contains(element)) {

                listaFaraDuplicate.add(element);

            }
        }

        return listaFaraDuplicate;
    }


    //metoda necesara afisarii meniului de selectare a cartilor;
    //userul va putea selecta un tip particular de carti;

    public void bookMenu(List<Book> list) {

        //initializarea listelor de tip Atlas, Roman, Revista, ArtAlbum

        initializareLists(list);

        //dupa ce am initializat listele putem aplica metoda de afisare a meniului pentru comanda cartilor

        orderBook();

    }

    public void orderBook() {

        System.out.println("Ce tip de carti doriti sa vedeti:\n 1. Atlas \n 2. Revista\n 3. Roman \n 4. ArtAlbum");

        int choise = scan.nextInt();

        switch (choise) {

            case 1:
                System.out.println("Avem disponibile urmatoarele atlase: ");

                //scopul acestui map este sa afisez pentru user cartile de un anumit tip, numerotate;
                //am nevoie sa fac referire la metoda map() prin care setez o cheie pentru fiecare obiect de tip Book (Atlas, Revista, Roman, ArtAlbum);
                //metoda map() este de tip return type, astfel rezultatul ei il voi salva intr-un Map.
                //voi printa map-ul cu metoda "printBookMap()" definita in clasa;
                // folosesc metoda "orderBookSubmenu()" pe baza acestui map prin care inregistrez intr-o lista comanda facuta de user;
                // calculez pretul elementelor din lista ce contine selectiile userului;

                Map<Integer, Atlas> mapAtlas = map(listaObiecteAtlas);
                printBookMap(mapAtlas);

                List<Atlas> atlase = orderBookSubmenu(mapAtlas);

                pretComandaCarti(atlase);

                break;


            case 2:

                System.out.println("Avem disponibile urmatoarele reviste: ");

                Map<Integer, Revista> mapRevista = map(listaObiecteRevista);
                printBookMap(mapRevista);

                List<Revista> reviste = orderBookSubmenu(mapRevista);

                pretComandaCarti(reviste);

                break;

            case 3:

                System.out.println("Avem disponibile urmatoarele romane: ");

                Map<Integer, Roman> mapRoman = map(listaObiecteRoman);
                printBookMap(mapRoman);

                List<Roman> romane = orderBookSubmenu(mapRoman);

                pretComandaCarti(romane);

                break;

            case 4:

                System.out.println("Avem disponibile urmatoarele albume: ");

                Map<Integer, ArtAlbum> mapAlbum = map(listaObiecteArtAlbum);
                printBookMap(mapAlbum);

                List<ArtAlbum> albume = orderBookSubmenu(mapAlbum);

                pretAlbumDupaTip(albume);


                break;

            default:
                System.out.println("Selectati una din variantele disponibile!");

        }


    }

    // completarea listelor predefinite la inceputul clasei cu obiecte de acelasi tip;
    //metoda primeste ca si argument o lista de tip Book, apoi verifica tipul fiecarui element si il adauga in lista corespunzatoare;

    private void initializareLists(List<Book> list) {

        //adaugarea elementelor de un anumit tip in lista corespunzatoare
        //"element" reprezinta fiecare element din lista Book, lista care contine obiecte de mai multe tipuri;
        // Pentru fiecare caz in parte vom face downcast catre sub-tipul corespunzator de Book;
        //vom popula listele declarate la inceputul clasei cu obiecte de tipurile corespunzatoare, astfel vom avea liste pentru fiecare tip de obiect;

        for (Book element : list) {

            if (element instanceof Atlas) {

                listaObiecteAtlas.add((Atlas) element);
            } else if (element instanceof Roman) {

                listaObiecteRoman.add((Roman) element);

            } else if (element instanceof Revista) {
                listaObiecteRevista.add((Revista) element);

            } else if (element instanceof ArtAlbum) {

                listaObiecteArtAlbum.add((ArtAlbum) element);
            }
        }
    }


    //avem nevoie de o metoda care sa imi genereze un Map pentru lista mea de obiecte;
    // Map-ul va avea chei de tip Integer si valori in functie de caz;
    //metoda va returna map-ul pe care eu o sa il folosesc in meniul de selectie al cartilor;

    private <T> Map<Integer, T> map(List<T> list) {

        Map<Integer, T> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {

            //metoda prin care asociez o cheie pentru fiecare element/obiect din lista pasata ca argument(put(K key, V value));
            //cheia va incepe de la o valoare de 1, motiv pentru care am indicat i+1 ca si start;

            map.put(i + 1, list.get(i));
        }

        // dupa completarea map-ului cu chei si valori va fi returnat si ulterior folosit in metoda orderBook()
        return map;


    }


    //printarea elementelor din fiecare map/iterarea prin map
    //Map-ul l-am declarat ca find generic pentru valori, deoarece printarea se va face pentru fiecare tip de carti in parte
    /*Forma generala:
        for (Map.Entry<KeyType, ValueType> entry : map.entrySet()) {
        System.out.println(entry.getKey()+" : "+entry.getValue());
    }

    */
    //entry reprezinta o intrare in map. Ea contine o cheie si o valoare (entry.getKey() va lua cheia (1,2,3 etc), iar entry.getValue() va lua valoarea de la cheie (obiectul Atlas, Revista etc.)

    private <T> void printBookMap(Map<Integer, T> map) {

        for (Map.Entry<Integer, T> entry : map.entrySet()) {

            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }


    //metoda necesara alegerii din lista specifica de carti a unor selectii dorite de user;
    //cartile vor fi alese in functie de numerotarea lor;

    public <T> List<T> orderBookSubmenu(Map<Integer, T> map) {

        System.out.println("Doriti sa comandati ceva?\n 1. DA\n 2. NU");

        //declaram o lista pentru cartile ce vor fi comandate de catre un user
        List<T> orderedBooks = new ArrayList<>();

        int raspuns = scan.nextInt();

        if (raspuns == 1) {

            System.out.println("Care din cartile mentionate doriti sa le comandati? Introduceti numerele cu virgula intre ele:");

            //am preluat datele introduse de user sub forma unui String
            String line = scan.next();

            // doresc sa sparg linia dupa delimitatorul "," si sa stochez fiecare element in ArrayList-ul de sus;
            //The asList() method of java.util.Arrays class is used to return a fixed-size list backed by the specified array (este o metoda ce returneaza o lista din array-ul dat)

            List<String> listaSplit = Arrays.asList(line.split(","));


            //vom itera prin lista si prin map (de exemplu: pentru valoarea 1 sa vedem daca exista o cheie in map cu valoarea 1,
            // iar daca exista luam obiectul de la acea cheie si il adaugam lista de carti "orderedBooks";
            //in functie de cerinta userului vom cauta si vom lua din map obiectele corespunzatoare pe care le vom adauga la lista de carti comandate (OrderedBooks);
            //entry reprezinta o intrare in map. Ea contine o cheie si o valoare (entry.getKey() va lua cheia (1,2,3 etc),
            // iar entry.getValue() va lua valoarea de la cheie (obiectul Atlas, Revista etc.)

            for (String element : listaSplit) {
                for (Map.Entry<Integer, T> entry : map.entrySet()) {
                    if (entry.getKey() == Integer.parseInt(element)) {
                        orderedBooks.add(entry.getValue());
                    }
                }

            }

            //se arunca o exceptie daca userul alege o carte care nu se afla in lista afisata

            if(orderedBooks.isEmpty()){
                throw new IllegalArgumentException("Incercati din nou! Introduceti una din cartile afisate!");
            }

            System.out.println("Ati ales urmatoarele carti: ");
            printBookList(orderedBooks);

            //returnez lista de carti comandate
            return orderedBooks;


        } else if (raspuns == 2) {

            System.out.println("Va multumim ca ati accesat pagina noastra! Daca doriti pe viitor o alta comanda va asteptam pe site! ");
        } else {

            throw new IllegalArgumentException("Nu ati introdus un raspuns valid! Incercati din nou!");
        }

        //metoda este de tip return, astfel in final voi returna o lista goala daca userul nu selecteaza elemente pentru comanda;
        return orderedBooks;
    }


    //calculul sumei elementelor din lista

    private <T> void pretComandaCarti(List<T> list) {

        //daca nu avem o lista comandata, exit

        if (list.isEmpty()) {
            return;
        }

        double sum = 0;

        for ( T book : list) {
            sum = sum + ((Book) book).getPrice();

            // am impus o conditie pentru categoria de ArtAlbum unde userul va putea selecta un tip specific de tiparire;
            //sumei finale calculate mai sus i se va adauga pretul specific tiparirii (legatura facuta cu clasa enum PaperType)

            if (book instanceof ArtAlbum && ((ArtAlbum) book).getPaperType() != null) {
                sum += ((ArtAlbum) book).getPaperType().getPriceQuality();
            }
        }

        System.out.println("Suma produselor comandate este de: " + sum + " lei.");
    }



    //metoda necesara selectiei de hartie pentru tiparitea albumelor;
    //am folosit clasa enum PaperType pentru a putea calcula pretul final in functie de tipul ales de hartie;
    //in enum am definit 2 constante (MATTE si GLOSS), iar in functie de ele pretul final pentru selectiile ArtAlbum se schimba;

    private void pretAlbumDupaTip(List<ArtAlbum> list) {

        //daca nu avem carti in lista, exit
        if(list.isEmpty()) {
            return;
        }

        System.out.println("Doriti tiparirea cu un alt tip de hartie?\n Pentru MATTE se percepe un pret in plus de 12 lei pentru fiecare carte selectata, respectiv 15 lei pentru GLOSS.\n Alegeti din variantele:\n 1. NU\n 2. MATTE\n 3. GLOSS");

        int tipPaper = scan.nextInt();

        if (tipPaper == 2) {

            for(ArtAlbum elem: list){
                elem.setPaperType(PaperType.MATTE);
            }

            pretComandaCarti(list);


        } else if (tipPaper == 3) {

            for(ArtAlbum elem: list){
                elem.setPaperType(PaperType.GLOSS);
            }

            pretComandaCarti(list);

        } else if (tipPaper == 1) {

            System.out.println("Tiparirea se va executa in formatul standard! Va multumim!");

            pretComandaCarti(list);

        }

        else {

            //apel catre exceptia mea custom "MyException"

            throw new MyException("Numarul inserat nu este valid!");
        }
    }
}




























