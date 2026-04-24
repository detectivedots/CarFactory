public class GasEngine extends SingularEngine{
    public GasEngine(int speedPerIncrement, int speedPerDecrement, int minSpeed, int maxSpeed){
        setMaxSpeed(maxSpeed);
        setMinSpeed(minSpeed);
        setSpeedPerIncrement(speedPerIncrement);
        setSpeedPerDecrement(speedPerDecrement);
    }
}
