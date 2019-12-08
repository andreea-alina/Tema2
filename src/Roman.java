public class Roman extends Book implements AudioBook {

    //Roman vine in plus cu variabila "type" de tip String

    private String type;

    // constructorul corespunzator clasei Roman

    public Roman(String nameOfTheBook, String authorName, String editura, String isbn, int pageNumber, double price, String type) {
        super(nameOfTheBook, authorName, editura, isbn, pageNumber, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //am suprascris metoda toString returnand metoda din clasa parinte (super.toStrin()) si adaugand o referire catre variabila noua "type"

    @Override
    public String toString() {
        return super.toString() + ", type = " + type;
    }


    @Override
    public boolean equals(Object obj) {

        if(this == obj){
            return true;
        }

        if(!(obj instanceof Roman)){
            return false;
        }

        Roman romanEq = (Roman)obj;

        return super.equals(obj) && this.type.equals(romanEq.type);

    }

    @Override
    public void play() {

        System.out.println("Roman in versiunea audio!\n Porniti audio book-ul romanului");
    }
}
