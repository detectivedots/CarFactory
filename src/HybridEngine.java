public class HybridEngine extends Engine{
    private final EngineControlStrategy engineControlStrategy;

    public HybridEngine(EngineControlStrategy engineControlStrategy){
        this.engineControlStrategy = engineControlStrategy;
    }

    @Override
    public int getMaxSpeed(){
        int maxSpeed = 0;
        for (Engine engine: engineControlStrategy.getAllEngines()) maxSpeed = Math.max(maxSpeed, engine.getMaxSpeed());
        return maxSpeed;
    }

    @Override
    public int getSpeedPerDecrement() {
        return engineControlStrategy.getCurrentEngine().getSpeedPerDecrement();
    }

    @Override
    public int getSpeedPerIncrement() {
        return engineControlStrategy.getCurrentEngine().getSpeedPerIncrement();
    }

    @Override
    public int getCurrentSpeed() {
        return engineControlStrategy.getCurrentEngine().getCurrentSpeed();
    }

    @Override
    public void increaseSpeed(){
        engineControlStrategy.increaseSpeed();
    }

    @Override
    public void decreaseSpeed() {
        engineControlStrategy.decreaseSpeed();
    }

    @Override
    public void brake() {
        engineControlStrategy.brake();
    }

    @Override
    public void start() {
        engineControlStrategy.start();
    }

    @Override
    public void stop() {
        engineControlStrategy.stop();
    }

    public Engine getCurrentEngine(){
        return engineControlStrategy.getCurrentEngine();
    }
}
