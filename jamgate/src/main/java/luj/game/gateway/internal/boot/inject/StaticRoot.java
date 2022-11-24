package luj.game.gateway.internal.boot.inject;

import luj.game.gateway.api.plugin.JamgateBootInit;
import org.springframework.beans.factory.annotation.Autowired;

final class StaticRoot implements GateSBeanCollector.Result {

  @Override
  public JamgateBootInit bootInitPlugin() {
    return _bootInitPlugin;
  }

  @Autowired
  JamgateBootInit _bootInitPlugin;
}
