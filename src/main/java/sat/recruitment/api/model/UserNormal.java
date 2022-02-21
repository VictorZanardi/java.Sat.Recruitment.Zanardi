package sat.recruitment.api.model;

import sat.recruitment.api.enums.UserType;

public class UserNormal extends User {

    public UserNormal(String name, String email, String address, String phone, UserType type, Double money) {
        super.setName(name);
        super.setEmail(email);
        super.setAddress(address);
        super.setPhone(phone);
        super.setType(type);
        super.setMoney(money);
    }

    @Override
    public void increaseMoney() {

        if (Double.valueOf(super.getMoney()) > 100) {
            Double percentage = Double.valueOf("0.12");
            // If new user is normal and has more than USD100
            var gif = Double.valueOf(super.getMoney()) * percentage;
            super.setMoney(super.getMoney() + gif);
        }
        if (Double.valueOf(super.getMoney()) < 100) {
            if (Double.valueOf(super.getMoney()) > 10) {
                var percentage = Double.valueOf("0.8");
                var gif = Double.valueOf(super.getMoney()) * percentage;
                super.setMoney(this.getMoney() + gif);
            }
        }
    }
}
