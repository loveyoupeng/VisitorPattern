package org.loveyoupeng.patterns.visitor;

public interface Target {
  <T, V extends TargetVisitor<T>> T accept(final V visitor); 
}
