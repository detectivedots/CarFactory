public class Car {
    // The speed is controlled by engine not car which is more reaslitic
    private Engine engine;
    private int accelerationUnit;
    private int decelerationUnit;

    public Car(Engine engine, int accelerationUnit, int decelerationUnit){
        this.engine = engine;
        this.accelerationUnit = accelerationUnit;
        this.decelerationUnit = decelerationUnit;
    }

    public void setAccelerationUnit(int accelerationUnit) {
        this.accelerationUnit = accelerationUnit;
    }

    public void setDecelerationUnit(int decelerationUnit) {
        this.decelerationUnit = decelerationUnit;
    }

    public int getAccelerationUnit() {
        return accelerationUnit;
    }

    public int getDecelerationUnit() {
        return decelerationUnit;
    }

    public Engine getEngine() {
        return engine;
    }

    public void start(){
        this.engine.start();
    }

    public void stop(){
        this.engine.stop();
    }

    public void accelerate(){
        int unit = this.engine.getSpeedPerIncrement();
        int incrementsNeeded = (accelerationUnit + unit - 1) / unit;
        for (int i = 0; i < incrementsNeeded; i++) {
            engine.increaseSpeed();
        }
    }

    public void brake(){
        int unit = this.engine.getSpeedPerDecrement();
        int decrementsNeeded = (decelerationUnit + unit - 1) / unit;
        for (int i = 0; i < decrementsNeeded; i++) {
            engine.brake();
        }
    }

    public void reverse(){
        int unit = this.engine.getSpeedPerDecrement();
        int decrementsNeeded = (decelerationUnit + unit - 1) / unit;
        for (int i = 0; i < decrementsNeeded; i++) {
            engine.decreaseSpeed();
        }
    }

    public void setEngine(Engine engine){
        stop();
        this.engine = engine;
    }

    public int getCurrentSpeed(){
        return engine.getCurrentSpeed();
    }
}
