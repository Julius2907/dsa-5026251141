package lw01.unguided;

public class ProjectorRental extends Rental {
    //konstrutor

    public ProjectorRental(String id, int days){
        super(id, days);
    }

    @Override 
    public int calculateCharge(){
        int total = 0;
        int hari = getDays();

        if (hari <= 0){
            throw new IllegalArgumentException("Jumlah hari harus lebih dari 0!");
        } else {
            if (hari > 3){
                total += 3 * 60000;
                total += (hari - 3) * 45000;
            } else {
                total += 3 * 60000;
            }
            total += 20000;
            return total;
        }
    }

    @Override 
    public String label(){
        return "Projector";
    }
    
}
