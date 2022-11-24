package luj.game.gateway.internal.luj.cluster;

import luj.game.gateway.internal.boot.plugin.BootInitInvoker;
import luj.net.api.NetContext;

public record GatebeanInLujcluster(
    NetContext lujnet,
    BootInitInvoker.Network netParam) {
  // NOOP
}
