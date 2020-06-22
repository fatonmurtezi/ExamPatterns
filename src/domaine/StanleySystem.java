package domaine;

import outils.SystemStanley;

public class StanleySystem implements System {



    @Override
    public boolean open() {
        return SystemStanley.lock(true);
    }

    @Override
    public boolean close() {
        return SystemStanley.lock(false);
    }
}
