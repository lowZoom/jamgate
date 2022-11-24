package luj.game.gateway.internal.boot.plugin;

import java.util.function.Function;
import luj.game.gateway.api.plugin.JamgateBootInit;

final class ContextImpl implements JamgateBootInit.Context {

  @Override
  public JamgateBootInit.Config configure(
      Function<JamgateBootInit.Config, JamgateBootInit.Config> c) {
    c.apply(_config);
    return _config;
  }

  CConfigImpl _config = new CConfigImpl();
}
