package domaine;

import outils.SystemKeso;

public class KesoSystem implements System {
    @Override
    public boolean open() {
        return SystemKeso.open();
    }

    @Override
    public boolean close() {
        return SystemKeso.close();
    }
}
