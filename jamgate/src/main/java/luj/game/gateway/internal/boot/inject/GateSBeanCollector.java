package luj.game.gateway.internal.boot.inject;

import luj.game.gateway.api.plugin.JamgateBootInit;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GateSBeanCollector {

  public interface Result {

    JamgateBootInit bootInitPlugin();
  }

  public GateSBeanCollector(ApplicationContext externalCtx) {
    _externalCtx = externalCtx;
  }

  public Result collect() {
    try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()) {
      ctx.setParent(_externalCtx);

      ctx.register(StaticRoot.class);
      ctx.refresh();

      return ctx.getBean(StaticRoot.class);
    }
  }

  private final ApplicationContext _externalCtx;
}
