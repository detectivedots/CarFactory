public class ElectricEngine extends SingularEngine{
    public ElectricEngine(int speedPerIncrement, int speedPerDecrement, int minSpeed, int maxSpeed){
        setMaxSpeed(maxSpeed);
        setMinSpeed(minSpeed);
        setSpeedPerIncrement(speedPerIncrement);
        setSpeedPerDecrement(speedPerDecrement);
    }
}
