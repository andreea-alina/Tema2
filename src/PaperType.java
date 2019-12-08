
    //clasa de tip Enum in care am definit 2 constante ce imi vor fi necesare la selectarea tipului de hartie pentru ArtAlbum;
    //in clasa BookService am definit metoda pretAlbumDupaTip() care va afisa in meniul de selectie pentru obiectele de tip ArtAlbum varianta de tiparire a hartiei;

   public enum PaperType {


    //am considerat o calitate diferita a foilor tiparite in cazul clasei obiectelor de tip album;
    //userul va alege tipul de hartie, iar in functie de acest aspect pretul final va fi pretul de lista al albumului + 12 lei pentru MATTE, sau pret lista + 15 lei pentru GLOSS
    //am definit 2 variabile: MATTE, GLOSS

    MATTE(12), GLOSS(15);

    double priceQualityPaper;


    //am creat un contructor cu ajutorul caruia am setat valori pentru constante

    private PaperType(double price) {

        this.priceQualityPaper = price;

    }

    public double getPriceQuality() {

        return priceQualityPaper;
    }

}







