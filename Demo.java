public class Demo{
	public static void main( String[] args ){
		Team team1 = new Team();
		team1.naam = "white walker";
		Team team2 = new Team();
		team2.naam = "Ice Ice Babys";
		Wedstrijd wedstrijd = new Wedstrijd(team1, team2);
		wedstrijd.aankondigen();
		
	}
}
class Wedstrijd{
	Team team1;
	Team team2;
	Team winnaar;
	Wedstrijd(Team thuisteam , Team uitteam){
		team1 = thuisteam;
		team2 = uitteam;
	}
	void aankondigen() {
		System.out.println("Er vind een wedstrijd plaats tussen "+ team1.naam + " en " + team2.naam);
	}
}


class Team{
	String naam;
	int score;
	boolean verloren = false;
}


