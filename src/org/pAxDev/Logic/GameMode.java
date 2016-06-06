package org.pAxDev.Logic;

import org.pAxDev.ObjectFactory.Map;
import org.pAxDev.ObjectFactory.Player;

/**
 * Created by Lance on 4/17/2016.
 */
public class GameMode {

    public void init(Player player) {
        Map.getInstance().init();
        Controller.getInstance().init(player);
    }

    public void update(int delta) {
        Controller.getInstance().update(delta);
        Map.getInstance().render();
    }
}


