package org.loveyoupeng.patterns.visitor;
final class BTarget implements Target {
  @Override
  public <T, V extends TargetVisitor<T>> T accept(final V visitor) {
    return visitor.visit(this);
  }
}
