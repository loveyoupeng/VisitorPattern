package org.loveyoupeng.patterns.visitor;

interface TargetVisitor<T> {
  T visit(final ATarget target);
  T visit(final BTarget target);
}
