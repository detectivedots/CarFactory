public abstract class Engine {
    public abstract int getMaxSpeed();

    public abstract int getSpeedPerDecrement();

    public abstract int getSpeedPerIncrement();

    public abstract int getCurrentSpeed();

    public abstract void increaseSpeed();

    public abstract void decreaseSpeed();

    public abstract void brake();

    public abstract void start();

    public abstract void stop();
}
