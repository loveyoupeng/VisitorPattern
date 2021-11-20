public class Test {
  public static void main(final String[] args) {
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

    System.out.println(stringValue + " " + integerValue);

    final Target bTarget = new BTarget();
    System.out.println(bTarget.accept(stringVisitor)+ " " + bTarget.accept(integerVisitor));
  }
}


interface TargetVisitor<T> {
  T visit(final ATarget target);
  T visit(final BTarget target);
}

interface Target {
  <T, V extends TargetVisitor<T>> T accept(final V visitor); 
}

final class ATarget implements Target {
  @Override
  public <T, V extends TargetVisitor<T>> T accept(final V visitor) {
    return visitor.visit(this);
  }
}

final class BTarget implements Target {
  @Override
  public <T, V extends TargetVisitor<T>> T accept(final V visitor) {
    return visitor.visit(this);
  }
}
