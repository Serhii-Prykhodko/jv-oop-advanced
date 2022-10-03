package core.basesyntax;

import java.util.Random;

public class FigureSupplier {
    private static final int FIGURES_COUNT = 100;
    private static final int CIRCLE_RADIUS = 10;
    private static final String CIRCLE_COLOR = "WHITE";
    private final ColorSupplier colorSupplier;
    private Random random;

    public FigureSupplier(ColorSupplier colorSupplier, Random random) {
        this.colorSupplier = colorSupplier;
        this.random = random;
    }

    private int getRandomValues() {
        int random = new Random().nextInt(FIGURES_COUNT);
        return random;
    }

    public Figure getRandomFigure() {

        switch (random.nextInt(FIGURES_COUNT)) {
            case 0:
                return new Circle(getRandomValues(), colorSupplier.getRandomColor());
            case 1:
                return new RightTriangle(getRandomValues(), getRandomValues(),
                        colorSupplier.getRandomColor());
            case 2:
                return new IsoscelesTrapezoid(getRandomValues(), getRandomValues(),
                        getRandomValues(), colorSupplier.getRandomColor());
            case 3:
                return new Rectangle(getRandomValues(),getRandomValues(),
                        colorSupplier.getRandomColor());
            default:
                return new Square(getRandomValues(), colorSupplier.getRandomColor());
        }
    }

    public Figure getDefaultFigure() {
        Figure defaultCircle = new Circle(CIRCLE_RADIUS, CIRCLE_COLOR);
        return defaultCircle;
    }
}