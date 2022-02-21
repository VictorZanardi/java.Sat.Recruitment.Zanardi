package sat.recruitment.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import sat.recruitment.api.annotation.ToJsonString;
import sat.recruitment.api.enums.UserType;

@Getter
@Setter
@EqualsAndHashCode
@ToJsonString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    public String name;
    public String email;
    public String address;
    public String phone;
    public UserType type;
    public Double money;

}
