package masterSpring.profile;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sang on 12/15/2015.
 */
public class ProfileForm {
    @Size(min = 2)
    private String  twitterHandle;

    @Email
    @NotEmpty
    private String email;

    @NotNull
    private LocalDate   birthDate;

    @NotEmpty
    private List<String>    tastes = new ArrayList<>();
}
