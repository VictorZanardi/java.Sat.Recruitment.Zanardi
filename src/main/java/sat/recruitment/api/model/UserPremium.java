package sat.recruitment.api.model;

import sat.recruitment.api.enums.UserType;

public class UserPremium extends User {

    public UserPremium(String name, String email, String address, String phone, UserType type, Double money) {
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
            Double gif = Double.valueOf(super.getMoney()) * 2;
            super.setMoney(super.getMoney() + gif);
        }
    }
}
