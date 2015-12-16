package masterSpring.profile;

import masterSpring.date.ReLocalDateFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;


@Controller

public class ProfileController {
    @RequestMapping("/profile")
    public String displayProfile() {
        return "profile/profilePage";
    }


    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String saveProfile(@Valid ProfileForm profileForm , BindingResult    bindingResult) {
        if(bindingResult.hasErrors()){
            return "profile/profilePage";
        }
        System.out.println("Your Profile has saved" + profileForm);
        return "redirect:/profile";
    }


    @ModelAttribute("dateFormat")
    public String localeFormat(Locale locale) {
    return ReLocalDateFormat.getPattern(locale);
    }


    @RequestMapping(value = "/profile", params = {"addtaste"})
    public String addRow(ProfileForm profileForm) {
        profileForm.getTastes();
        return "profile/profilePage";
    }
    @RequestMapping(value = "/profile", params = {"removetaste"})
    public String removeRow(ProfileForm profileForm,
                            HttpServletRequest req) {
        Integer rowId = Integer.valueOf(req.getParameter("removeTaste"));
        profileForm.getTastes().remove(rowId.intValue());
        return "profile/profilePage";
    }

}