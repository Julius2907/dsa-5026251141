package lw01.prelab;

public abstract class PrintJob implements Chargeable{

    //variabel
    private String id;
    private int pages;

    //Kontruktor
    protected PrintJob(String id, int pages){
        if (pages <= 0){
            throw new IllegalArgumentException ("Jumlah halaman harus lebih dari 0");
        }
        this.id = id;
        this.pages = pages;
    }
    
    //method getter id
    public String getId(){
        return id;
    }

    //method getter pages
    public int getPages(){
        return pages;
    }

    //method dari interface
    @Override 
    public abstract int calculateCharge();
    
    public int calculateCharge (int copies){
        if (copies <= 0){
            throw new IllegalArgumentException ("Jumlah copies harus lebih dari 0");
        }
        return copies * calculateCharge();
    }

    public String label(){
        return "Print";
    }

    public String summary(){
       return id + " | " + label() + " | " + calculateCharge();
    }
}
