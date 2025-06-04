package cleancode.studycafe.tobe2.model;

import java.util.Set;

public class StudyCafePass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;
    private final double discountRate;

    private StudyCafePass(StudyCafePassType passType, int duration, int price, double discountRate) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
        this.discountRate = discountRate;
    }

    public static StudyCafePass of(StudyCafePassType passType, int duration, int price, double discountRate) {
        return new StudyCafePass(passType, duration, price, discountRate);
    }

    public boolean isSamePassType(StudyCafePassType studyCafePassType) {
        return this.passType == studyCafePassType;
    }

    public boolean isSameDurationType(StudyCafeLockerPass lockerPass) {
        return this.passType == lockerPass.getPassType()
                && this.duration == lockerPass.getDuration(); // getPassType() 대신 lockerPass에 또 한번 메서드를 만들어서 물어봐도 됨
    }

    public StudyCafePassType getPassType() {
        return passType;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public String display() {
        if (passType == StudyCafePassType.HOURLY) {
            return String.format("%s시간권 - %d원", duration, price);
        }
        if (passType == StudyCafePassType.WEEKLY) {
            return String.format("%s주권 - %d원", duration, price);
        }
        if (passType == StudyCafePassType.FIXED) {
            return String.format("%s주권 - %d원", duration, price);
        }
        return "";
    }

    public boolean cannotUseLocker() {
        return this.passType.isNotLockerType();
    }
}
