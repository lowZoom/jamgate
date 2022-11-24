package luj.game.gateway.api.plugin;

import java.util.function.Function;

public interface JamgateBootInit {

  interface Context {

    Config configure(Function<Config, Config> c);
  }

  interface Config {

    Config network(Function<Network, Network> val);
  }

  interface Network {

    Network bindPort(int port);
  }

  Config onInit(Context ctx);
}
