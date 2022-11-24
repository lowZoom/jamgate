package luj.game.gateway.internal.boot.plugin;

import luj.game.gateway.api.plugin.JamgateBootInit;

final class CNetworkImpl implements JamgateBootInit.Network, BootInitInvoker.Network {

  @Override
  public JamgateBootInit.Network bindPort(int port) {
    _port = port;
    return this;
  }

  //////////////////////////////////////////////////

  @Override
  public int bindPort() {
    return _port;
  }

  int _port;
}
