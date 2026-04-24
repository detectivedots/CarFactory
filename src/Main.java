//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // I'm not sure whether by factory we mean physical factory or factory design patten
        // Here I assumed the first, if it was a factory design pattern the only thing we need
        // to change is instead of using the new keyword we just write CarFactory.createCar("Gas") for example
        /// and inside the car factory class we check (using if or switch) for the passed parameter

        Car carWithGasEngine = new Car(new GasEngine(1, 1, -100, 200),
                20, 20);

        carWithGasEngine.start();
        System.out.println("Initial speed: " + carWithGasEngine.getCurrentSpeed());
        carWithGasEngine.accelerate();
        System.out.println("Speed after first acceleration: " + carWithGasEngine.getCurrentSpeed());
        for (int i = 0; i < 20; i++) {
            carWithGasEngine.accelerate();
        }
        System.out.println("Speed after 21 accelerations: " + carWithGasEngine.getCurrentSpeed());



        HybridEngine gasElectricHybridEngine = new HybridEngine(
                new EngineBasedOnSpeed(new ElectricEngine(1, 1, -50, 100),
                        new GasEngine(1, 1, -100, 200), 50)
        );

        Car carWithHybridEngine = new Car(gasElectricHybridEngine, 20, 20);
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