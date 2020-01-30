package Rps;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Rps {

    private Rules play;
    private String player_name;

        @RequestMapping("/index")
        public String index() {
            return "index.html";
        }

    @RequestMapping(value = "/names", method = RequestMethod.POST)
    public String getNames(@RequestParam(name="name") String name) {
            this.player_name = name;
        return "redirect:/play";
    }


    @GetMapping("/play")
    public String play(Model model) {
        model.addAttribute("name", player_name);
        return "play.html";
    }

    @RequestMapping(value = "/play-choice", method = RequestMethod.POST)
    public String getChoice(@RequestParam(name="choice") String choice) {
        this.play = new Rules(new Computer(), choice);
        return "redirect:/game";
    }

    @GetMapping("/game")
    public String game(Model model) {
        model.addAttribute("name", player_name);
        model.addAttribute("play", play.match());
        return "game.html";
    }

    @GetMapping("/end")
    public String end(Model model) {
        model.addAttribute("name", player_name);
        return "end.html";
    }

}
