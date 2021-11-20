package org.loveyoupeng.patterns.visitor;

import org.junit.*;
import static org.junit.Assert.*;

public class VisitorTest {
  @Test
  public void test_visitor_pattern() {
    final TargetVisitor<String> stringVisitor = new TargetVisitor<String>() {
      @Override
      public String visit(final ATarget target) {
        return "ATarget";
      }

      @Override
      public String visit(final BTarget target) {
        return "BTarget";
      }
    };

    final Target target = new ATarget();
    final String stringValue = target.accept(stringVisitor);
    assertEquals("ATarget", stringValue);
    
    final TargetVisitor<Integer> integerVisitor = new TargetVisitor<Integer>() {
      @Override
      public Integer visit(final ATarget target) {
        return 100;
      }

      @Override
      public Integer visit(final BTarget target) {
        return 200;
      }
    };
    final Integer integerValue = target.accept(integerVisitor);

    assertEquals(Integer.valueOf(100), integerValue);

    final Target bTarget = new BTarget();
    assertEquals("BTarget", bTarget.accept(stringVisitor));
  }
}


