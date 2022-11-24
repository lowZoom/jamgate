package luj.game.gateway.internal.luj.cluster.actor.network;

import luj.cluster.api.actor.ActorPreStartHandler;
import luj.net.api.NetContext;

public class NetRootActor {

  public interface PreStart extends ActorPreStartHandler<NetRootActor> {
    // NOOP
  }

  public NetRootActor(NetConfig initConfig, NetContext lujnet) {
    _initConfig = initConfig;
    _lujnet = lujnet;
  }

  public NetConfig getInitConfig() {
    return _initConfig;
  }

  public NetContext getLujnet() {
    return _lujnet;
  }

  private final NetConfig _initConfig;

  private final NetContext _lujnet;
}
