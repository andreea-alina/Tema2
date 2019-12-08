public class Revista extends Book{

    //mosteneste toate variabilele din clasa Book, iar pe langa ele adauga variabila "modelRevista" de tip String

    private String modelRevista;

    //constructorul corespunzator clasei Revista

    public Revista(String nameOfTheBook, String authorName, String editura, String isbn, int pageNumber, double price, String modelRevista) {
        super(nameOfTheBook, authorName, editura, isbn, pageNumber, price);
        this.modelRevista = modelRevista;
    }

    public String getModel() {

        return modelRevista;
    }

    public void setModel(String model) {

        this.modelRevista = model;
    }


    @Override
    public String toString() { return super.toString() + ", modelRevista = " + modelRevista;
    }

    @Override
    public boolean equals(Object obj) {

        // daca obiecte au aceeasi adresa de memorie ("==" compara pentru doua obiecte adresele din memorie)
        // atunci sunt unul si acelasi obiect si se iese din metoda;
        if(this == obj){
            return true;
        }

        // nu pot compara doua obiecte de tipuri diferite, astfel daca obj nu este o instanta de tip Revista nu se merge mai departe cu compare-ul

        if(!(obj instanceof Revista)){
            return false;
        }

        Revista objRevistaEq = (Revista)obj;

        return super.equals(obj) && this.modelRevista.equals(objRevistaEq.modelRevista);



    }
}
