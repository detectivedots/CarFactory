import java.util.List;

public interface EngineControlStrategy {
    public Engine getCurrentEngine();
    public List<Engine> getAllEngines();
    public void increaseSpeed();
    public void decreaseSpeed();
    public void brake();
    public void start();
    public void stop();
}
