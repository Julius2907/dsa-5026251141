package lw01.unguided;

public class LaptopRental extends Rental {

    //konstrutor
    public LaptopRental(String id, int days){
        super(id, days);
    }

    @Override 
    public int calculateCharge(){
        int hari = getDays();
        int total = 0;

        if (hari <= 0){
            throw new IllegalArgumentException("Hari harus lebih dari 0!");
        }

        total += hari * 40000;
        return total;

    }

    @Override 
    public String label(){
        return "Laptop";
    }
    
}
