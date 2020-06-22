package domaine;

import outils.SystemVigik;

import javax.crypto.spec.PSource;

public class VigikSystem implements System {
    @Override
    public boolean open() {
        return SystemVigik.ouvre();
    }

    @Override
    public boolean close() {
        return SystemVigik.ferme();
    }

}
