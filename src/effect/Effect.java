package effect;

import characters.Dude;

/**
 * Created by HansDaniel on 10.03.2016.
 */
public interface Effect {
    void onHit(Dude target);
    void beforeTurn(Dude target);
    void afterTurn(Dude target);
    boolean isExpired();
}
