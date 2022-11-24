package luj.game.gateway.api;

import luj.game.gateway.internal.boot.node.GateNodeStarter;
import org.springframework.context.ApplicationContext;

public enum JamGate {
  ;

  public static void start(ApplicationContext appContext) {
    new GateNodeStarter(appContext).start();
  }
}
