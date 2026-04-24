import java.util.List;

public class EngineBasedOnSpeed implements EngineControlStrategy{
    private final Engine lowSpeedEngine;
    private final Engine highSpeedEngine;
    private int speedSwitchThreshold;
    private Engine currentEngine;

    public EngineBasedOnSpeed(Engine lowSpeedEngine, Engine highSpeedEngine, int speedSwitchThreshold){
        this.lowSpeedEngine = lowSpeedEngine;
        this.highSpeedEngine = highSpeedEngine;
        this.speedSwitchThreshold = speedSwitchThreshold;
        currentEngine = lowSpeedEngine;
    }

    @Override
    public Engine getCurrentEngine(){
        return this.currentEngine;
    }

    @Override
    public List<Engine> getAllEngines() {
        return List.of(lowSpeedEngine, highSpeedEngine);
    }

    @Override
    public void increaseSpeed() {
        int newSpeed = currentEngine.getCurrentSpeed() + currentEngine.getSpeedPerIncrement();
        if (currentEngine == lowSpeedEngine && (newSpeed > speedSwitchThreshold || newSpeed > currentEngine.getMaxSpeed())){
            highSpeedEngine.start();
            while (highSpeedEngine.getCurrentSpeed() < newSpeed) highSpeedEngine.increaseSpeed();
            lowSpeedEngine.stop();
            currentEngine = highSpeedEngine;
        } else {
            currentEngine.increaseSpeed();
        }
    }

    @Override
    public void decreaseSpeed() {
        int newSpeed = currentEngine.getCurrentSpeed() - currentEngine.getSpeedPerDecrement();
        if (currentEngine == highSpeedEngine && newSpeed < speedSwitchThreshold){
            lowSpeedEngine.start();
            while (lowSpeedEngine.getCurrentSpeed() < newSpeed) lowSpeedEngine.increaseSpeed();
            highSpeedEngine.stop();
            currentEngine = lowSpeedEngine;
        } else {
            currentEngine.decreaseSpeed();
        }
    }

    @Override
    public void brake() {
        int newSpeed = currentEngine.getCurrentSpeed() - currentEngine.getSpeedPerDecrement();
        if (currentEngine == highSpeedEngine && newSpeed < speedSwitchThreshold){
            lowSpeedEngine.start();
            while (lowSpeedEngine.getCurrentSpeed() < newSpeed) lowSpeedEngine.increaseSpeed();
            highSpeedEngine.stop();
            currentEngine = lowSpeedEngine;
        } else {
            currentEngine.brake();
        }
    }

    @Override
    public void start() {
        this.currentEngine = lowSpeedEngine;
        this.currentEngine.start();
    }

    @Override
    public void stop(){
        this.currentEngine.stop();
    }

    public void setSpeedSwitchThreshold(int speedSwitchThreshold) {
        this.speedSwitchThreshold = speedSwitchThreshold;
    }

    public int getSpeedSwitchThreshold() {
        return speedSwitchThreshold;
    }
}
