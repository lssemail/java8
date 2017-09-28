package part03.chapt10.model;

import java.util.Optional;

/**
 * Created by lssemail on 2017/9/28.
 */
public class Car {

    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }
}
