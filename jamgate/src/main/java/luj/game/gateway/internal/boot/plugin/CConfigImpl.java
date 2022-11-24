package luj.game.gateway.internal.boot.plugin;

import java.util.function.Function;
import luj.game.gateway.api.plugin.JamgateBootInit;

final class CConfigImpl implements JamgateBootInit.Config {

  @Override
  public JamgateBootInit.Config network(
      Function<JamgateBootInit.Network, JamgateBootInit.Network> val) {
    val.apply(_network);
    return this;
  }

  CNetworkImpl _network = new CNetworkImpl();
}
