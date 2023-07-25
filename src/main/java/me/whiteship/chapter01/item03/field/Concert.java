package me.whiteship.chapter01.item03.field;

public class Concert { // IElvis의 클라이언트 코드

    private boolean lightsOn;

    private boolean mainStateOpen;

    /*
    private Elvis elvis;

    public Concert(Elvis elvis) {
        this.elvis = elvis;
    }
     */
    // => 인터페이스 기반으로 코드 개선.
    private IElvis elvis;

    public Concert(IElvis elvis) {
        this.elvis = elvis;
    }

    public void perform() {
        mainStateOpen = true;
        lightsOn = true;
        elvis.sing();
    }

    public boolean isLightsOn() {
        return lightsOn;
    }

    public boolean isMainStateOpen() {
        return mainStateOpen;
    }
}
