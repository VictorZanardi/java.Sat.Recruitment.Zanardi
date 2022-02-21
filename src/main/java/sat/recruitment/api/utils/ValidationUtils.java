package sat.recruitment.api.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ValidationUtils {

    public static void validateBodyErrors(String name, String email, String address, String phone, String errors) {
        if (name == null)
            // Validate if Name is null
            errors = "The name is required";
        if (email == null)
            // Validate if Email is null
            errors = errors + " The email is required";
        if (address == null)
            // Validate if Address is null
            errors = errors + " The address is required";
        if (phone == null)
            // Validate if Phone is null
            errors = errors + " The phone is required";

        if (errors != null && errors != "") {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors);
        }
    }
}
