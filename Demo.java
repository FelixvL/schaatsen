import java.util.Random;

public class Demo{
	public static void main( String[] args ){
		Team team1 = new Team();
		team1.naam = "white walker";
		Team team2 = new Team();
		team2.naam = "Ice Ice Babys";
		Team team3 = new Team();
		team3.naam = "IceCreamers";
		Team team4 = new Team();
		team4.naam = "BladeRunners";
		Wedstrijd wedstrijd = new Wedstrijd(team1, team2);
		wedstrijd.aankondigen();
		wedstrijd.spelen();
		wedstrijd.winnaarBekendMaken();
		Wedstrijd wedstrijd2 = new Wedstrijd(team3, team4);
		wedstrijd2.aankondigen();
		wedstrijd2.spelen();
		wedstrijd2.winnaarBekendMaken();
		System.out.println("Finale gaat beginnen");
		Wedstrijd wedstrijd3 = new Wedstrijd(wedstrijd.winnaar,wedstrijd2.winnaar);
		wedstrijd3.aankondigen();
		wedstrijd3.spelen();
		wedstrijd3.winnaarBekendMaken();
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
	public void winnaarBekendMaken() {
		if(team1.score > team2.score) {
			System.out.println(team2.naam+" heeft gewonnen met de score"+team2.score);
			winnaar = team2;
		}else if(team1.score < team2.score){
			System.out.println(team1.naam+" heeft gewonnen met de score"+team1.score);			
			winnaar = team1;
		}else if(team1.score == team2.score) {
			System.out.println("Iedereen heeft gewonnen.");
			spelen();
		}
		
	}
	public void spelen() {
		Random random = new Random();
		int wedstrijdtijd = random.nextInt(1000);
		team1.score = wedstrijdtijd;
		Random random2 = new Random();
		int wedstrijdtijd2 = random2.nextInt(1000);
		team2.score = wedstrijdtijd2;		
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


