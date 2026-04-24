//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Car carWithGasEngine = CarFactory.createCar(EngineType.GAS);

        carWithGasEngine.start();
        System.out.println("Initial speed: " + carWithGasEngine.getCurrentSpeed());
        carWithGasEngine.accelerate();
        System.out.println("Speed after first acceleration: " + carWithGasEngine.getCurrentSpeed());
        for (int i = 0; i < 20; i++) {
            carWithGasEngine.accelerate();
        }
        System.out.println("Speed after 21 accelerations: " + carWithGasEngine.getCurrentSpeed());


        Car carWithHybridEngine = CarFactory.createCar(EngineType.HYBRID);
        carWithHybridEngine.start();
        carWithHybridEngine.accelerate();
        carWithHybridEngine.accelerate();
        System.out.println(carWithHybridEngine.getCurrentSpeed());
        System.out.println("Low speed engine: " + ((HybridEngine)carWithHybridEngine.getEngine()).getCurrentEngine().getClass());
        carWithHybridEngine.accelerate();
        System.out.println(carWithHybridEngine.getCurrentSpeed());
        System.out.println("High speed engine: " + ((HybridEngine)carWithHybridEngine.getEngine()).getCurrentEngine().getClass());

    }
}