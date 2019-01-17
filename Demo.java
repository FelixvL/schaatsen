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
		Team teamGoud = wedstrijd3.winnaar;
		Team teamZilver = wedstrijd3.verliezerGeven();
		Wedstrijd wedstrijd4 = new Wedstrijd(wedstrijd.verliezerGeven(), wedstrijd2.verliezerGeven());
		wedstrijd4.aankondigen();
		wedstrijd4.spelen();
		wedstrijd4.winnaarBekendMaken();
		Team teamBrons = wedstrijd4.winnaar;
		Ceremonie c = new Ceremonie(teamGoud, teamZilver, teamBrons);
		c.uitkeren();
		//Team teamZilver = 
		
		
	}
}
class Wedstrijd{
	Team teama;
	Team teamb;
	Team winnaar;
	Wedstrijd(Team thuisteam , Team uitteam){
		teama = thuisteam;
		teamb = uitteam;
	}
	public void winnaarBekendMaken() {
		if(teama.score > teamb.score) {
			System.out.println(teamb.naam+" heeft gewonnen met de score"+teamb.score);
			winnaar = teamb;
		}else if(teama.score < teamb.score){
			System.out.println(teama.naam+" heeft gewonnen met de score"+teama.score);			
			winnaar = teama;
		}else if(teama.score == teamb.score) {
			System.out.println("Iedereen heeft gewonnen.");
			spelen();
			winnaarBekendMaken();
		}
		
	}
	public Team verliezerGeven() {
		if(winnaar == teama) {
			return teamb;
		}
		return teama;
	}
	public void spelen() {
		Random random = new Random();
		int wedstrijdtijd = random.nextInt(3);
		teama.score = wedstrijdtijd;
		Random random2 = new Random();
		int wedstrijdtijd2 = random2.nextInt(3);
		teamb.score = wedstrijdtijd2;		
	}
	void aankondigen() {
		System.out.println("Er vind een wedstrijd plaats tussen "+ teama.naam + " en " + teamb.naam);
	}
}

class Ceremonie{
	private Team teamGoud;
	private Team teamZilver;
	private Team teamBrons;
	Ceremonie(Team teama, Team teamb, Team teamc){
		teamGoud = teama;
		teamZilver = teamb;
		teamBrons = teamc;
	}
	void uitkeren() {
		System.out.println("Goud voor:"+teamGoud.naam);
		System.out.println("Zilver voor:"+teamZilver.naam);
		System.out.println("Brons voor:"+teamBrons.naam);
	}
	
}

class Team{
	String naam;
	int score;
	boolean verloren = false;
}


