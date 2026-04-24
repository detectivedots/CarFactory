public abstract class SingularEngine extends Engine{
    private int maxSpeed;
    private int minSpeed; // speed can be negative in reverse (comment by me not AI)
    private int speedPerIncrement;
    private int speedPerDecrement;
    private int currentSpeed;
    private boolean isRunning;

    @Override
    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public int getSpeedPerDecrement() {
        return speedPerDecrement;
    }

    @Override
    public int getSpeedPerIncrement() {
        return speedPerIncrement;
    }

    @Override
    public int getCurrentSpeed() {
        return currentSpeed;
    }

    @Override
    public void increaseSpeed() {
        if (!isRunning) return;
        currentSpeed = Math.min(maxSpeed, currentSpeed + speedPerIncrement);
    }

    @Override
    public void decreaseSpeed() {
        if (!isRunning) return;
        currentSpeed = Math.max(minSpeed, currentSpeed - speedPerDecrement);
    }

    public void brake() {
        currentSpeed = currentSpeed > 0 ? Math.max(0, currentSpeed - speedPerDecrement) : Math.min(0, currentSpeed + speedPerIncrement);
    }

    @Override
    public void start(){
        isRunning = true;
    }

    @Override
    public void stop(){
        while (currentSpeed != 0) brake();
        isRunning = false;
    }

    public void setSpeedPerIncrement(int speedPerIncrement) {
        this.speedPerIncrement = speedPerIncrement;
    }

    public void setSpeedPerDecrement(int speedPerDecrement) {
        this.speedPerDecrement = speedPerDecrement;
    }

    public void setMinSpeed(int minSpeed) {
        this.minSpeed = minSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
