package luj.game.gateway.internal.luj.cluster;

import luj.cluster.api.node.NodeStartListener;
import luj.game.gateway.internal.boot.plugin.BootInitInvoker;
import luj.game.gateway.internal.luj.cluster.actor.network.NetConfig;
import luj.game.gateway.internal.luj.cluster.actor.network.NetRootActor;
import luj.spring.anno.Internal;

@Internal
final class OnNodeStart implements NodeStartListener {

  /**
   * @see luj.game.gateway.internal.boot.node.GateNodeStarter#startCluster
   */
  @Override
  public void onStart(Context ctx) {
    GatebeanInLujcluster param = ctx.getStartParam();

    NetRootActor netActor = makeNetActor(param);
    ctx.createApplicationActor(netActor);
  }

  private NetRootActor makeNetActor(GatebeanInLujcluster param) {
    BootInitInvoker.Network netParam = param.netParam();
    var config = new NetConfig(netParam.bindPort());

    return new NetRootActor(config, param.lujnet());
  }
}
