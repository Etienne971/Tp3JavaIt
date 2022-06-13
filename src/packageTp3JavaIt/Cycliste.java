package packageTp3JavaIt;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;


public class Cycliste implements Comparable<Cycliste> {
    private String name;
    private int number;
    private boolean estArrive;
    private boolean estDisqualifie;
    private int timer;

    Cycliste (String name, int number, boolean estArrive, boolean estDisqualifie, int timer){
        this.name = name;
        this.number = number;
        this.estArrive = estArrive;
        this.estDisqualifie = estDisqualifie;
        this.timer = timer;
    }

    public void setArrive(boolean estArrive){
        this.estArrive = estArrive;
    }

    public void setDisqualifie(boolean estDisqualifie){
        this.estDisqualifie = estDisqualifie;
    }

    public int getNumber(){
        return this.number;
    }

    public int getTimer(){
        return this.timer;
    }

    public void setTimer(int timer){
        this.timer=timer;
    }

    public void PrintCycliste(){
        System.out.println("name : "  + this.name);
        System.out.println("number : "  + this.number);
        System.out.println("arrived statut "  + this.estArrive);
        System.out.println("qualif statut : "  + this.estDisqualifie);
        System.out.println("timer : "  + this.timer);
    }

    @Override
    public int compareTo(Cycliste cyc) {
        //trions les employés selon leur age dans l'ordre croiddant
        //retroune un entier négative, zéro ou positive si l'age
        //de cet employé est moins que, égale à ou supérieur à l'objet comparé avec
        return (this.timer - cyc.timer);
    }

}
