package metier;

import dao.LoadData;
import domaine.CardReader;

import java.awt.font.FontRenderContext;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class CardReaderManager  {
    private Map<Integer, CardReader> cardReaders;

    public CardReaderManager() {
        cardReaders = LoadData.getCardReaders();
    }



    public boolean activate(int cardReaderId, boolean active) {
        CardReader cardReader = cardReaders.get(cardReaderId);
        if (cardReader != null) {
            System.out.println(cardReader);
            return cardReader.setActivated(active);
        }
        return false;
    }

    public void activateNoWait(int cardReaderId, boolean active)  {
        CardReader cardReader = cardReaders.get(cardReaderId);
        if (cardReader != null) {

            //cardReader.setActivated(active);
            Thread t = new Thread(cardReader);
            t.start();


        }

    }

    public boolean activateAll(boolean active) throws InterruptedException {
        System.out.println(cardReaders.size());
        List<Thread> lstThreads = new ArrayList<>();

        for (Integer i : cardReaders.keySet()){

            //cardReaders.get(i).setActivation(active);
            CardReader c = cardReaders.get(i);
            Thread t = new Thread(c);

            lstThreads.add(t);
            t.start();
        }

        for (int i = 0; i<cardReaders.size();i++){
            lstThreads.get(i).join();
        }

        return true;
    }

    public Map<Integer, CardReader> getCardReaders() {
        return cardReaders;
    }

    @Override
    public String toString() {
        return cardReaders.toString();
    }




}