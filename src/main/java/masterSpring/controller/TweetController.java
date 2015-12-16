package masterSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class TweetController {

    @Autowired
    private Twitter twitter;

    @RequestMapping("/")
    public String Home() {
        return "searchPage";
    }

    @RequestMapping("/result")

    public String Hello(@RequestParam(defaultValue = "OverWatch") String search, Model model) {
        SearchResults searchResult = twitter.searchOperations().search(search);

        List<Tweet> tweets = searchResult.getTweets();

        model.addAttribute("search", search);
        model.addAttribute("tweets", tweets);

        return "resultPage";
    }

    @RequestMapping(value = "/postSearch", method = RequestMethod.POST)
    public String postSearch(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String search = request.getParameter("search");
        if (search.toLowerCase().contains("sex")) {
            redirectAttributes.addFlashAttribute("error", "Try using another word");
            return "redirect:/";
        }
        redirectAttributes.addAttribute("search", search);
        return "redirect:result";
    }


}

