//clasa de baza (super clasa)

public class Book {

    private String nameOfTheBook;
    private String authorName;
    private String editura;
    private String isbn;
    private int pageNumber;
    private double price;

    //constructor fara parametrii

    public Book(){

    }

    //constructor cu parametrii

    public Book(String nameOfTheBook, String authorName, String editura, String isbn, int pageNumber, double price) {
        this.nameOfTheBook = nameOfTheBook;
        this.authorName = authorName;
        this.editura = editura;
        this.isbn = isbn;
        this.pageNumber = pageNumber;
        this.price = price;
    }

    //suprascrierea metodei toString()

    @Override
    public String toString() {
        return "Titlul cartii: " + nameOfTheBook + ", autorul = " + authorName + ", editura = " + editura + ", ISBN = " + isbn + ", pageNumber = " + pageNumber + ", price = " + price;
    }

    /* am generat metode de get() & set() pentru variabilele private. Variabilele private vor fi accesate prin aceste metode;
     * prin get accesez variabila, iar prin set setez o valoare dorita;
     * THIS = aceasta variabila din obiectul curent;
     */

    // getters & setters for variable "nameOfTheBook"

    public String getNameOfTheBook() {

        return nameOfTheBook;
    }

    public void setNameOfTheBook(String nameOfTheBook) {
        this.nameOfTheBook = nameOfTheBook;
    }

    //setters & setters for variable "autorName"

    public String getAuthorName() {

        return authorName;
    }

    public void setAuthorName(String name) {

        this.authorName = name;
    }

    // getters & setters for variable "editura"

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    //getters & setters for variable "isbn"

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    // getters & setters for variable "nrPagini"

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int nrPagini) {
        this.pageNumber = nrPagini;
    }


    // getters & setters for variable "price"
    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }


    @Override
    public boolean equals(Object obj) {

        //daca primul obiect si cel pasat metodei au aceeasi adresa de memorie (asta face "==") imi returneaza true,
        // deci sunt egale si se iese din metoda;
        //in cazul nostru sunt doua obiecte diferite, practic conditia nu este verificata si se merge mai departe in metoda

        if(this == obj){
            return true;  // return true inseamna ca obiectele sunt egale si ne-am indeplinit scopul
        }


        // daca obiectul pasat metodei nu este instanta de Book voi primi un return de false,
        // nu pot compara obiecte de tipuri diferite si se iese din metoda;
        // daca aceasa conditie este indeplinita inseamna ca obj nu este instanta de Book;

        if(!(obj instanceof Book)){

            return false;
        }

        //se ajunge la aceasta linie daca obiectul meu este de tip Book
        //facem downcast la Book deoarece in stadiul initial obj este de tip Object
        Book bookEq = (Book)obj;

        // folosim equals pentru compareul de Stringuri si "==" pentru primitive

        return this.nameOfTheBook.equals(bookEq.nameOfTheBook) && this.authorName.equals ((bookEq.authorName))
                && this.editura.equals(bookEq.editura) && this.isbn.equals(bookEq.isbn) && this.pageNumber == bookEq.pageNumber
                && this.price == bookEq.price;

    }

}
