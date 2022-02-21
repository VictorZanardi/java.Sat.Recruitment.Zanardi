package sat.recruitment.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sat.recruitment.api.enums.UserType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	public String name;
	public String email;
	public String address;
	public String phone;
	public UserType type;
	public Double money;

	public void increaseMoney(){
	};
}
