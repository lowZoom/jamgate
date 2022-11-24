package luj.game.gateway.internal.boot.node;

import luj.cluster.api.ClusterSession;
import luj.cluster.api.LujCluster;
import luj.game.gateway.api.plugin.JamgateBootInit;
import luj.game.gateway.internal.boot.inject.GateSBeanCollector;
import luj.game.gateway.internal.boot.plugin.BootInitInvoker;
import luj.game.gateway.internal.luj.cluster.GatebeanInLujcluster;
import luj.net.api.LujNet;
import luj.net.api.NetContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GateNodeStarter {

  public GateNodeStarter(ApplicationContext appContext) {
    _appContext = appContext;
  }

  public void start() {
    try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()) {
      ctx.register(InternalConf.class);
      ctx.refresh();

      ClusterSession lujcluster = LujCluster.start(ctx);
      startCluster(lujcluster, ctx);
    }
  }

  private void startCluster(ClusterSession lujcluster, ApplicationContext internalCtx) {
    GateSBeanCollector.Result staticRoot = new GateSBeanCollector(_appContext).collect();
    JamgateBootInit bootPlugin = staticRoot.bootInitPlugin();

    BootInitInvoker.Result bootCfg = new BootInitInvoker(bootPlugin).invoke();
    NetContext lujnet = LujNet.create(internalCtx);

    var gatebean = new GatebeanInLujcluster(lujnet, bootCfg.network());

    lujcluster.startNode(c -> c
        .startParam(gatebean)
    );
  }

  private final ApplicationContext _appContext;
}
