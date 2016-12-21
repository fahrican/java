package bwi.prog1B.WS1617.wi16b027_Can.ShoeShop;

import bwi.prog.utils.TextIO;
	public class Schuhshop {

		public static void main(String[] args) {
			
			Schuhmodell[] produktkatalog = new Schuhmodell[100];
			Kunde[] kundenkartei = new Kunde[100];
			Schuhmodell[] verkaufteSchuhe = new Schuhmodell[100];		
			
			initialisierung(produktkatalog, kundenkartei);
			
			TextIO.putln("Willkommen im Schuhshop!");
			while(true){
				TextIO.putln("Operationscodes: \n"
						+ "1 Neues Modell hinzufügen \n"
						+ "2 Neuen Kunden hinzufügen \n"
						+ "3 Produktkatalog anzeigen \n"
						+ "4 Kundenkartei anzeigen \n"
						+ "5 Schuh verkaufen \n"					
						+ "6 Bisherige Tageseinnahmen \n"
						+ "7 Besten Kunden anzeigen \n"
						+ "0 Programm beenden");
				int operation = TextIO.getlnInt();
				
				
				switch(operation){
					case 1:
						TextIO.putln("Modell hinzufügen");
						TextIO.putln("modellName:");
						String modellName = TextIO.getln();
						TextIO.putln("Hersteller:");
						String hersteller = TextIO.getln();
						TextIO.putln("preis:");
						float preis = TextIO.getlnFloat();
						
						modellHinzufuegen(produktkatalog, modellName, hersteller, preis);
						break;
						
					case 2:					
						// TODO einlesen der Parameter für den neuen Kunden.
						TextIO.putln("Kunde hinzufügen");
						TextIO.putln("Kundenname:");
						String name = TextIO.getln();
						
						kundenHinzufuegen(kundenkartei, name);
						break;
						
					case 3:
						ausgabeSchuhmodelle(produktkatalog);
						break;
						
					case 4:
						ausgabeKunden(kundenkartei);
						break;
						
					case 5:
						// TODO einlesen welches Modell ausgewählt wurde und an welchen Kunden verkauft wird.
						TextIO.putln("Welches Modell wurde verkauft?");
						ausgabeSchuhmodelle(produktkatalog);
						TextIO.putln("Bitte geben Sie eine Nummer ein: ");
						int modellIndex = TextIO.getlnInt();
						
						TextIO.putln("An welchen Kunden wurde " + produktkatalog[modellIndex].modellName + " verkauft?");
						ausgabeKunden(kundenkartei);
						TextIO.put("Bitte geben Sie die Nummer ein: ");
						int kundenIndex = TextIO.getlnInt()
;						
						schuhVerkauf(produktkatalog[modellIndex], kundenkartei[kundenIndex], verkaufteSchuhe);
						break;
						
					case 6:
						ausgabeEinnahmen(verkaufteSchuhe);
						break;
						
					case 7:
						ausgabeBesterKunde(kundenkartei);
						break;
						
					case 0:
						return;
						
				}
			}
		}

		private static void initialisierung(Schuhmodell[] produktkatalog, Kunde[] kundenkartei) {
			modellHinzufuegen(produktkatalog, "Runners 13", "Nike", 110.90F);
			modellHinzufuegen(produktkatalog, "All Star 60011", "Converse", 69.90F);
			modellHinzufuegen(produktkatalog, "Imperiali 11", "Manolo Blahnik", 490F);

			kundenHinzufuegen(kundenkartei, "Mickey Maus");
			kundenHinzufuegen(kundenkartei, "Arnold Schwarzenegger");
			kundenHinzufuegen(kundenkartei, "Arya Stark");
			kundenHinzufuegen(kundenkartei, "Walter White");
			kundenHinzufuegen(kundenkartei, "Marie Curie");
		}

		public static void modellHinzufuegen(Schuhmodell[] produktkatalog, String modellName, String hersteller,
				float preis) {
			Schuhmodell modell = new Schuhmodell();
			modell.modellName = modellName;
			modell.herstellerMarke = hersteller;
			modell.preis = preis;			
			
			for(int i=0; i<produktkatalog.length; i++){
				if(produktkatalog[i] == null){
					produktkatalog[i] = modell;
					return;
				}
			}
		}
		
		public static void kundenHinzufuegen(Kunde[] kundenkartei, String kundenname){
			// TODO erstellen eines neuen Kunden und hinzufügen zu der Kundenkartei.
			Kunde kunde = new Kunde();
			kunde.name = kundenname;
			
			//Array "Schuhmodell" muss initialisiert werden.
			kunde.gekaufteSchuhe = new Schuhmodell[100];
			
			for(int i=0; i<kundenkartei.length; i++) {
				if (kundenkartei[i] == null) {
					kundenkartei[i] = kunde;
					return;
				}
			}
		}
		
		public static void ausgabeSchuhmodelle(Schuhmodell[] produktkatalog) {
			// TODO Ausgabe aller Schuhmodelle des Produktkatalogs in der Console.
			for (int i=0; i<produktkatalog.length; i++) {
				if (produktkatalog[i] == null) {
					return;
				}
				TextIO.putf("ID: %d, modellName: %s, herstellerMarke:%s, preis: %.2f\n", i, produktkatalog[i].modellName, 
						produktkatalog[i].herstellerMarke, produktkatalog[i].preis);
			}
		}
		
		public static void ausgabeKunden(Kunde[] kundenkartei) {
			// TODO Ausgabe aller Kunden der Kundenkartei in der Console.
			for (int i=0; i<kundenkartei.length; i++) {
				if (kundenkartei[i] == null) {
				return;
				}
				float ausgaben = 0;
				for (int j=0; j<kundenkartei[i].gekaufteSchuhe.length; j++) {
					if (kundenkartei[i].gekaufteSchuhe[j] == null) {
					break;
				}
				ausgaben += kundenkartei[i].gekaufteSchuhe[j].preis;
			}
			
			//Ausgabe mit ID (Index in Kundenkartei), Kundenname, gesamtAusgaben (Summe der Kosten aller gekauften Schuhe)
			TextIO.putf("ID: %d, Kundenname: %s, Gesamte Ausgaben: %.2f\n", i, kundenkartei[i].name, ausgaben);
			}
		}

		public static void schuhVerkauf(Schuhmodell modell, Kunde kunde, Schuhmodell[] verkaufteSchuhe){
			// TODO das Schuhmodell soll den gekauften Schuhen des Kunden und den verkauften Schuhen hinzugefügt werden.
			for (int i=0; i<kunde.gekaufteSchuhe.length; i++) {
				if (kunde.gekaufteSchuhe[i] == null) {
				kunde.gekaufteSchuhe[i] = modell;
				break;
				}
			}
			for (int i=0; i<verkaufteSchuhe.length; i++) {
				if (verkaufteSchuhe[i] == null) {
					verkaufteSchuhe[i] = modell;
					break;
				}
			}
		}

		public static void ausgabeEinnahmen(Schuhmodell[] verkaufteSchuhe) {
			// TODO Ausgabe aller Einnahmen aller verkauften Schuhe.
			float einnahmen = 0;
			for (int i=0;i<verkaufteSchuhe.length; i++) {
				if (verkaufteSchuhe[i] == null) {
					break;
				}
				einnahmen += verkaufteSchuhe[i].preis;
			}
			TextIO.putf("Einnahmen aller verkauften Schuhe: %.2f EUR\n", einnahmen);
		}

		public static void ausgabeBesterKunde(Kunde[] kundenkartei) {
			// TODO Ausgabe des Kunden der am meisten Geld ausgegeben hat.
			float maxAusgaben = 0;
			Kunde besterKunde = null;
			for (int i=0; i<kundenkartei.length; i++) {
				if (kundenkartei[i] == null) {
					break;
				}
				float ausgaben = 0;
				for (int j=0; j<kundenkartei[i].gekaufteSchuhe.length; j++) {
					if (kundenkartei[i].gekaufteSchuhe[j] == null) {
						break;
					}
				ausgaben += kundenkartei[i].gekaufteSchuhe[j].preis;
			}
			if(ausgaben >= maxAusgaben) {
				maxAusgaben = ausgaben;
				besterKunde = kundenkartei[i];
			}
		}
		TextIO.putf("Kunde mit den meisten Ausgaben: %s, %.2f EUR\n", besterKunde.name, maxAusgaben);
	}
}

	
