package luj.game.gateway.internal.boot.plugin;

final class ResultImpl implements BootInitInvoker.Result {

  @Override
  public BootInitInvoker.Network network() {
    return _config._network;
  }

  CConfigImpl _config;
}
