package Priestory;

public interface Uprac {
    default public void upratanieDielne(Dielna dielna){
        if(dielna.getUpratane()<=50){
            dielna.setUpratane(100);
        }
    }
}
