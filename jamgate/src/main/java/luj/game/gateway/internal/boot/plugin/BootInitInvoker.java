package luj.game.gateway.internal.boot.plugin;

import luj.game.gateway.api.plugin.JamgateBootInit;

public class BootInitInvoker {

  public interface Result {

    Network network();
  }

  public interface Network {

    int bindPort();
  }

  public BootInitInvoker(JamgateBootInit plugin) {
    _plugin = plugin;
  }

  public Result invoke() {
    var ctx = new ContextImpl();

    var config = (CConfigImpl) _plugin.onInit(ctx);

    var result = new ResultImpl();
    result._config = config;

    return result;
  }

  private final JamgateBootInit _plugin;
}
