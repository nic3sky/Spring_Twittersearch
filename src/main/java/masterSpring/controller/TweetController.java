package masterSpring.controller;

import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class TweetController {

    private Twitter twitter ;

    @RequestMapping("/")

    public String Hello(@RequestParam(defaultValue = "SpringMVC") String search , Model model){
        SearchResults searchResult = twitter.searchOperations().search(search);

        List<String> tweets = searchResult.getTweets()
                .stream().map(Tweet::getText)
                .collect(Collectors.toList());

        model.addAttribute("tweets", tweets);

        return "resultPage";
    }

}
