package Rps;

public class Rules {

    String computer_choice;
    String player_choice;

    public Rules(Computer computer, String player){
        computer_choice = computer.weapon();
        player_choice = player;
    }

    public String tie(){
        return "Tie! no one wins";
    }
    public String com_wins(){
        return "Computer wins";
    }
    public String pla_wins(){
        return "Player wins";
    }


    public String rock(){
        switch(computer_choice) {
            case "rock":
                return tie();
            case "scissors":
                return pla_wins();
            case "paper":
                return com_wins();
        }
        return "";
    }

    public String paper(){
        switch(computer_choice) {
            case "rock":
                return tie();
            case "paper":
                return com_wins();
            case "scissors":
                return pla_wins();
        }
        return "";
    }

    public String scissors(){
        switch(computer_choice) {
            case "rock":
                return tie();
            case "paper":
                return pla_wins();
            case "scissors":
                return com_wins();
        }
        return "";
    }

    public String match() {
        switch (player_choice) {
            case "rock":
                return rock();
            case "paper":
                return paper();
            case "scissors":
                return scissors();
        }
        return "";
    }
}
