package dao;

import domaine.*;
import domaine.System;
import outils.FileToStr;

import java.util.HashMap;
import java.util.Map;

public class LoadData {
    public static Map<Integer, CardReader> getCardReaders() {
        Map<Integer, CardReader> cardReaders = new HashMap<>();
        for (String[] data : FileToStr.lireCsv("LstDevices.csv")) {
            System system = FabriqueSystem.nouveauSystem(data[4]);
            cardReaders.put(Integer.parseInt(data[0]), new CardReader(Integer.parseInt(data[0]), new Device(data[1], data[2]), data[3].equalsIgnoreCase("true"), system));
        }
        return cardReaders;
    }
}