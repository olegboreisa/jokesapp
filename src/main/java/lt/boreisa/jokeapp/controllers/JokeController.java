package lt.boreisa.jokeapp.controllers;

import lt.boreisa.jokeapp.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private JokeService jokeService;

    // This is a Constructor Autowired (@Autowired is looking for a bean (or spring object that is in Spring Container)
    // Since we have only one @Service @Compound @Repository?? BEAN in other word, it know that we are instantiating JokeServiceImpl, and then we are
    //using it is method. If we had JokeServiceImp2 (for example) we would have to use @Qualifier or @Primary
    // [WE DO NOT NEED TO WRITE this.jokeService = new jokeService (DEPENDENCY INJECTION)]
    @Autowired
    public JokeController (JokeService jokeService){
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})
    public String showJoke(Model model) {

        model.addAttribute("joke", jokeService.getJoke());

        return "chuck";
    }
}
