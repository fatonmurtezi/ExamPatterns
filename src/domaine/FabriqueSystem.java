package domaine;

public abstract class FabriqueSystem {

    public static System nouveauSystem(String data){
        System sys = null;
        switch (data){
            case "Keso" : sys = new KesoSystem(); break;
            case "Stanley" : sys = new StanleySystem(); break;
            case "Vigik" : sys = new VigikSystem(); break;

        }
        return sys;
    }

}
