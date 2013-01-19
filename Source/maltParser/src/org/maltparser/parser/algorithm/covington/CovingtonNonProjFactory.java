package org.maltparser.parser.algorithm.covington;

import org.maltparser.core.exception.MaltChainedException;
import org.maltparser.parser.Algorithm;
import org.maltparser.parser.TransitionSystem;
import org.maltparser.parser.guide.OracleGuide;
import org.maltparser.parser.history.GuideUserHistory;

/**
 * @author Johan Hall
 *
 */
public class CovingtonNonProjFactory extends CovingtonFactory {

    public CovingtonNonProjFactory(Algorithm algorithm) {
        super(algorithm);
    }

    public TransitionSystem makeTransitionSystem() throws MaltChainedException {
        if (manager.getConfigLogger().isInfoEnabled()) {
            manager.getConfigLogger().info("  Transition system    : Non-Projective\n");
        }
        TransitionSystem ts = new NonProjective();
        ts.setPropagationManager(manager.getPropagationManager());
        return ts;
    }

    public OracleGuide makeOracleGuide(GuideUserHistory history) throws MaltChainedException {
        if (manager.getConfigLogger().isInfoEnabled()) {
            manager.getConfigLogger().info("  Oracle               : Covington\n");
        }
        return new CovingtonOracle(manager, history);
    }
}