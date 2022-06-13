package packageTp3JavaIt;

import java.awt.*;
import java.security.PolicySpi;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Cycliste> classement = new ArrayList<>();
        boolean isArrived = false;
        boolean isDisqualified = false;
        int choix = 0;
        boolean run = true;

        while (run){

            System.out.println("Veuillez choisir une option : 1.quitter le programme, 2.Enregistrer les coureurs, 3.Afficher les coureurs et leurs classement, 4.Enregistrer une arrivé, 6.Enregistrer une disqualification, 7.Enregistrer le temps d'arrivée d'un cycliste, 8.Obtenir le temps d'un coureur, 9.Obtenir le temps d'écart entre deux coureurs donnés (non implemente)");
            String ch = sc.nextLine();
            choix = Integer.valueOf(ch);

            switch (choix){
                case 1 :
                    run = false;
                    System.out.println("Vous avez quitté le programme");
                    break;
                case 2 :
                    boolean runList = true;
                    while (runList){
                        System.out.println("entrer le nom du coureur");
                        String name = sc.nextLine();
                        System.out.println("entrer le numero du cycliste");
                        String nb = sc.nextLine();
                        Integer number = Integer.valueOf(nb);
                        System.out.println("est il arrivée ? : 1 for yes, 0 for  no");
                        String isAr = sc.nextLine();
                        Integer isArrive = Integer.valueOf(isAr);
                        if (isArrive == 1){
                            isArrived = true;
                        }
                        else if (isArrive == 0){
                            isArrived = false;
                        }
                        System.out.println("est il disqualifié ? : 1 for yes, 0 for  no");
                        String isDi = sc.nextLine();
                        Integer isDisqualifie = Integer.valueOf(isDi);
                        if (isDisqualifie == 1){
                            isDisqualified = true;
                        }
                        else if (isDisqualifie == 0){
                            isDisqualified = false;
                        }
                        System.out.println("entrer le temps de course : ");
                        String tim = sc.nextLine();
                        Integer timer = Integer.valueOf(tim);

                        classement.add(new Cycliste(name, number, isArrived, isDisqualified, timer));

                        System.out.println("Prochain coureur : 1, Plus de coureur supplémentaire : 0.");
                        String rl = sc.nextLine();
                        Integer runL = Integer.valueOf(rl);
                        if (runL == 0){
                            runList = false;
                        };
                    };
                    break;
                case  3 :
                    //classement par ordre d'arrivée
                    Collections.sort(classement);

                    System.out.println("Affichage du classement en cours et des infos des coureurs");
                    for (Cycliste coureur : classement){
                        coureur.PrintCycliste();
                        System.out.println("----- ------ -----");
                    }
                    break;
                case 4 :
                    System.out.println("Enregistrement d'une arrivée d'un coureur ");
                    System.out.println("Numero du coureur : ");
                    String nb4 = sc.nextLine();
                    Integer numb4 = Integer.valueOf(nb4);
                    System.out.println("1.Arrivé, 0.Non arrivé");
                    String ar = sc.nextLine();
                    Integer arriv = Integer.valueOf(ar);
                    if(arriv == 1){
                        isArrived = true;
                    }
                    else if(arriv == 0){
                        isArrived = false;
                    }

                    for(Cycliste coureur : classement) {
                        if (coureur.getNumber() == (numb4)) {
                            coureur.setArrive(isArrived);
                            break;
                        }
                    }
                case 6 :
                    System.out.println("Enregistrement d'une disqualification d'un coureur ");
                    System.out.println("Numero du coureur : ");
                    String nbc = sc.nextLine();
                    Integer numbc = Integer.valueOf(nbc);
                    System.out.println("1.Disqualifié, 0.Non Disqualifié");
                    String di = sc.nextLine();
                    Integer disq = Integer.valueOf(di);
                    if(disq == 1){
                        isDisqualified = true;
                    }
                    else if(disq == 0){
                        isDisqualified = false;
                    }

                    for(Cycliste coureur : classement) {
                        if (coureur.getNumber() == (numbc)) {
                            coureur.setDisqualifie(isDisqualified);
                            break;
                        }
                    }
                case 7 :
                    System.out.println("Enrigistrement du timer d'un coureur ");
                    System.out.println("Numero du coureur : ");
                    String nb7 = sc.nextLine();
                    Integer nume7 = Integer.valueOf(nb7);
                    System.out.println("Timer : ");
                    String tm = sc.nextLine();
                    Integer tim = Integer.valueOf(tm);

                    for(Cycliste coureur : classement) {
                        if (coureur.getNumber() == (nume7)) {
                            coureur.setTimer(tim);
                            break;
                        }
                    }
                case 8 :
                    System.out.println("Affichage du temps d'un coureur ");
                    System.out.println("Numero du coureur : ");
                    String nb8 = sc.nextLine();
                    Integer nume8 = Integer.valueOf(nb8);

                    for(Cycliste coureur : classement) {
                        if (coureur.getNumber() == (nume8)) {
                            int temps = coureur.getTimer();
                            System.out.println("Timer du coureur " + nume8 + " : " + temps + " secondes.");
                            break;
                        }
                    }
            }
        }

    }
}
