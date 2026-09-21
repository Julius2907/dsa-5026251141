package lw01.prelab;

public class ColourPrint extends PrintJob{

    //konstruktor 
    public ColourPrint(String id, int pages){
        super(id, pages);
    }

    @Override
    public int calculateCharge() {
        int total = 0;
        int pages = getPages();
        if (pages > 10){
            total += 10 * 1500;
            total += (pages - 10) * 1000;
        } else {
            total += pages * 1500;
        }
        total += 2000;
        return total;
    }

    @Override 
    public String label(){
        return "Colour";
    }
}