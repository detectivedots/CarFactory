public class CarFactory {
    public static Car createCar(EngineType type) {
        return new Car(createEngine(type), 20, 20);
    }

    private static Engine createEngine(EngineType type) {
        return switch (type) {
            case GAS -> new GasEngine(1, 1, -100, 200);
            case ELECTRIC -> new ElectricEngine(1, 1, -100, 200);
            case HYBRID ->
                    new HybridEngine(new EngineBasedOnSpeed(new ElectricEngine(1, 1, -50, 100), new GasEngine(1, 1, -100, 200), 50));
        };
    }

    public static void installEngine(Car car, EngineType type) {
        car.setEngine(createEngine(type));
    }
}
