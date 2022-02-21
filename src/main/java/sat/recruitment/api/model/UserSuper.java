package sat.recruitment.api.model;

import sat.recruitment.api.enums.UserType;

public class UserSuper extends User{

    public UserSuper(String name, String email, String address, String phone, UserType type, Double money) {
        super.setName(name);
        super.setEmail(email);
        super.setAddress(address);
        super.setPhone(phone);
        super.setType(type);
        super.setMoney(money);
    }

    @Override
    public void increaseMoney() {

        if (Double.valueOf(this.getMoney()) > 100) {
            Double percentage = Double.valueOf("0.20");
            Double gif = Double.valueOf(super.getMoney()) * percentage;
            super.setMoney(super.getMoney() + gif);
        }
    }
}
