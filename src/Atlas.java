
public class Atlas extends Book {

    //clasa Atlas aduce in plus variabila age de tip int

    private int year;

    //constructorul clasei Atlas

    public Atlas(String nameOfTheBook, String authorName, String editura, String isbn, int pageNumber, double price, int year) {
        super(nameOfTheBook, authorName, editura, isbn, pageNumber, price);
        this.year = year;
    }


    //am suprascris metoda toString apeland-o pe cea din clasa parinte (prin super) si adaugand in plus o referire si catre noua variabile "age"

    @Override
    public String toString() {
        return super.toString() + ", year = " + year;
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }


        if (!(obj instanceof Atlas)) {
            return false;
        }

        Atlas atlasEq = (Atlas) obj;


        return super.equals(obj) && this.year == atlasEq.year;


    }

}




