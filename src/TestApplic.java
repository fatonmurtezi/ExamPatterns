import dao.LoadData;
import domaine.CardReader;
import metier.CardReaderManager;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

public class TestApplic  {

    public static void main(String[] args) throws InterruptedException {
        CardReaderManager manager = new CardReaderManager();
        addObs(manager);

        boolean ok;

        //System.out.println(manager);



        System.out.print("ActiveNoWait 224466...");    manager.activateNoWait(224466, true);
        System.out.println();

        System.out.print("On active tout...");    ok = manager.activateAll(true);                   System.out.println(ok);
        System.out.println("active 1");

        System.out.print("Active 112233...");  ok = manager.activate(112233, true); System.out.println(ok);

        System.out.println("desactive 1");
        System.out.print("Désactive 112233...");  ok = manager.activate(112233, false); System.out.println(ok);
        System.out.println("active 2");
        System.out.print("Active 112233...");  ok = manager.activate(112233, true); System.out.println(ok);


       /* System.out.print("Désactive 112233...");  ok = manager.activate(112233, false); System.out.println(ok);
       / System.out.print("Désactive 224466...");  ok = manager.activate(224466, false); System.out.println(ok);
        System.out.print("ActiveNoWait 224466...");    manager.activateNoWait(224466, true);

        System.out.println("Printer B4.18: true ==> false");    // doit être affiché chaque fois qu'un cardReader a été activé ou désactivé
        System.out.println(manager);                            // affiche l'état de tous les cardReaders


        Map<Integer,CardReader> mapReader = LoadData.getCardReaders();
        */
        //System.out.println(manager);

    }

    private static void addObs(CardReaderManager manager) {
        Map<Integer,CardReader> map = manager.getCardReaders();
        for(Integer i : map.keySet()){
            CardReader c = map.get(i);
            c.addObserver(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent e) {
                    CardReader c = (CardReader) e.getNewValue();
                    System.out.println();
                    System.out.println("Modification de " +c.getDeviceName()+" passe de l'état "+e.getOldValue()+" à l'état "+c.isActivated());
                    System.out.println();
                }
            });
        }
    }


}