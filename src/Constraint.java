public class Constraint<T extends Comparable>{
    private T lowerLimit;
    private T upperLimit;

    public Constraint(T lower_limit, T upper_limit) {
        this.lowerLimit = lower_limit;
        this.upperLimit = upper_limit;
    }

    public T getLower_limit() {
        return  lowerLimit;
    }

    public T getUpper_limit() {
        return upperLimit;
    }

    public void setLowerLimit(T newLowLimit) {
        this.lowerLimit = lowerLimit;
    }

    public void setUpperLimit(T newUpperLimit) {
        this.upperLimit = upperLimit;
    }

    public boolean isValueBetween(T value) {
        if (upperLimit == null && lowerLimit == null) {
            return true;
        }
            if (upperLimit == null && lowerLimit != null) {
            if(value.compareTo(lowerLimit) >= 0)
                return true;
        }
        if (lowerLimit == null && upperLimit != null) {
            if(value.compareTo(upperLimit) <= 0)
                return true;
        }
        if (value.compareTo(lowerLimit) >= 0 && value.compareTo(upperLimit) <= 0)
            return true;
        else
            return false;
    }
}
