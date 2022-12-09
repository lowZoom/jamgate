package luj.game.gateway.internal.luj.cluster.actor.network;

import luj.net.api.NetContext;
import luj.spring.anno.Internal;

@Internal
final class OnPrestart implements NetRootActor.PreStart {

  @Override
  public void onHandle(Context ctx) {
    NetRootActor self = ctx.getActorState(this);

    NetContext lujnet = self.getLujnet();
    NetConfig cfg = self.getInitConfig();

    java.lang.System.out.println("TODO: 启动一个网络服务器 - " + cfg);
    lujnet.createServer().bind("0.0.0.0", cfg.bindPort(), null);
  }
}
