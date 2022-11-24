package luj.game.gateway.internal.boot.node;


import luj.spring.anno.Internal;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "luj.game.gateway.internal",
    includeFilters = @ComponentScan.Filter(Internal.class))
final class InternalConf {
  // NOOP
}
