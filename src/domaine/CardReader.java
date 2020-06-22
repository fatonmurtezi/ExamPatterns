package domaine;

import outils.SystemKeso;
import outils.SystemStanley;
import outils.SystemVigik;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CardReader implements Runnable {

    private int id;
    private Device device;
    private boolean activated;
    //private String controlSystem;
    private System system;

    public CardReader(int id, Device device, boolean activated, System system/*String controlSystem*/) {
        this.id = id;
        this.device = device;
        this.activated = activated;
        this.system = system;
    }



    public String getDeviceName() {
        return device.getName();
    }

    public boolean isActivated() {
        return activated;
    }
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addObserver(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener("etat", listener);
    }


    public boolean setActivated(boolean activated) {
        boolean done = true;
        if (activated){
            done = system.open();
        }else{
            done = system.close();
        }
       /*
        switch (controlSystem) {
            case "Stanley":
                active =  SystemStanley.lock(!activated);
            case "Keso":
                active =  activated ? SystemKeso.open() : SystemKeso.close();
              case "Vigik" : active = activated ? SystemVigik.ouvre() : SystemVigik.ferme();       // implémentation future éventuelle
        }
        */

        if (done){
            setActivation(activated);
        }
        return done;
    }



    public void setActivation(boolean active){
        boolean oldVal = this.activated;
        this.activated = active;
        pcs.firePropertyChange("etat",oldVal,this);

    }

    @Override
    public String toString() {
        return "CardReader{" + id + ":" + device + "=" + activated + "(" + system + ")";
    }

    @Override
    public void run() {
        setActivated(true);

    }




}