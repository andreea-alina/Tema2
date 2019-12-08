public class ArtAlbum extends Book implements Illustrations {

    //am daugat o noua variabila sub denumirea de "papaer_quality"

    int paper_quality;

    //camp de tip enum pentru care vom defini getters & setters. Va fi initializat atunci cand user-ul alege tipul de hartie.

    PaperType paperType;

    public PaperType getPaperType() {
        return paperType;
    }

    public void setPaperType(PaperType paperType) {
        this.paperType = paperType;
    }

// constructorul corespunzator clasei

    public ArtAlbum(String nameOfTheBook, String authorName, String editura, String isbn, int pageNumber, double price, int paper_quality) {
        super(nameOfTheBook, authorName, editura, isbn, pageNumber, price);
        this.paper_quality = paper_quality;
    }

    public int getPaper_quality() {
        return paper_quality;
    }

    public void setPaper_quality(int paper_quality) {
        this.paper_quality = paper_quality;
    }


    // fiecare clasa ce extinde Book are metoda toString() suprascrisa;
    // Aceasta metoda se apeleaza automat in momentul cand doresc sa printez un obiect;

    @Override
    public String toString() {
        return super.toString() + ", paper_quality = " + paper_quality;
    }


    //suprascrierea metodei equals din clasa parinte Book ce ma va ajuta la identificarea duplicatelor din lista mea

    @Override
    public boolean equals(Object obj) {

        if(this == obj){
            return true;
        }

        if(!(obj instanceof ArtAlbum)){
            return false;
        }

            ArtAlbum artAlbumEq = (ArtAlbum)obj;

        return super.equals(obj) && this.paper_quality == artAlbumEq.paper_quality;

    }

    @Override
    public void drow() {

   // if this is an online verison you can offer the reader the possibility to drow his own illustration
        System.out.println("Here you can drow you own illustration");

    }
}


