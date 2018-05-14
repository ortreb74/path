package bundle.schema.main;

import home.file.HomeUri;
import bundle.schema.schema.Schema;
import bundle.schema.schema.SchemaStudio;
import bundle.schema.schema.basics.Point;
import bundle.schema.schema.object.SchemaFirstList;
import log.LogFile;

import java.net.URISyntaxException;


public class Command {

	public static void main(String[] args) {
		System.out.println("Début du programme (main.Command)");

		LogFile logFile = new LogFile("file:/c:/log/");

		Schema schema = null;
		boolean defaut = false;
		String fileName = "default.xml";
		if (args.length > 1) {
			fileName = args[0];
			SchemaStudio scs;
			switch (args[1]) {				
			
				case ("firstList") :
	
						SchemaFirstList sfl = new SchemaFirstList();
						
						sfl.firstStone("prog.lig");
						sfl.addPartner("init-vars.bash");
						sfl.addPartner("ExtractGuides-int -extract");
						sfl.addPartner("Sgml2XmlVerbatim-int -out ...");
						
						schema = sfl;
						break;
				case ("jeudi11") :
					System.out.println(args[1]);
				
					SchemaStudio gwd = new SchemaStudio();
				
					gwd.place("3", new Point(250,50));
					gwd.setRState();
					gwd.next("copier une bu");
					gwd.next("lien bu programme");				
					
					schema = gwd;
					
					break;
					
				case ("vendredi12") :
					System.out.println(args[1]);
				
					scs = new SchemaStudio();
				
					scs.place("3", new Point(250,50));
			
					
					schema = scs;
					
					break;
										
					
				case ("CheckBU") :
					System.out.println(args[1]);
				
					scs= new SchemaStudio();
				
					scs.place("CheckBU.bal", new Point(250,50));					
					scs.next("V�rification des guides");
					scs.next("V�rification des base de connaissances");				
					scs.next("V�rification des fichiers BU");
					
					schema = scs;
					
					break;
					
				case ("1264") :

					System.out.println(args[1]);
				
					scs= new SchemaStudio();
				
					scs.place("ValidXml", "step", new Point(250,50));					
					scs.next("CorrigeIdDoublon", "step");
					scs.next("CheckInclude", "step");
					
					schema = scs;
					
					break;
					
				case ("intro") :

					System.out.println(args[1]);
				
					scs= new SchemaStudio();
				
					scs.place("structure.xsl", new Point(250,50));					
					scs.next("tablegroup.xsl");
					
					schema = scs;
					
					break;
					
				case ("dalow1") :

					System.out.println(args[1]);
				
					scs= new SchemaStudio();
				
					scs.place("step-code.log", new Point(400,50));
					scs.place("file short", "step", new Point(400,250));
					scs.next("file tra", "step");
					scs.next("normalize_named_entities_to_utf8", "step");
					scs.next("normalize_code_dalloz", "step");
										
					scs.setRState();
					scs.next("normalise-code.xsl", "step");
					scs.next("ajoute-prefixe-id-commentaire.xsl", "step");				
					
					
					schema = scs;
					
					break;		
					
				case ("block") :
					System.out.println(args[1]);
				
					scs= new SchemaStudio();	
					
					scs.place("malformed Xml : missing start tag", "step", new Point(400,50));
					
					scs.setRState();
					scs.next("�crire un ruby", "step");
					scs.next("convertir le fichier", "step");				

					
					schema = scs;
					break;					

				case ("20150709") :
					System.out.println(args[1]);
				
					scs= new SchemaStudio();	
					
					scs.place("le nom est pass� en minuscule", "step", new Point(400,50));					
	
					scs.next("le nom est chang� en tra", "step");
					scs.near("renommage du fichier baux en dbaux", "step");		
					
					scs.next("normalize_named_entities_to_utf8", "step");
					scs.near("TALPHA.DTD : TALPHADLZ.DTD", "step");
					
					scs.next("normalize_code_dalloz (2 xsl)", "step");

					
					schema = scs;
					break;
                case ("list") :
                    System.out.println(args[1]);

                    scs = new SchemaStudio();
                    scs.place("c:", "disc", new Point (100,100));
					schema = scs;

                    break;
				case ("160728") :
					System.out.println(args[1]);
					scs = new SchemaStudio();
					scs.place("a path", "disc", new Point (100,100));
					scs.next("from ij", "disc");
					scs.next("to schema", "disc");
					schema = scs;
					break;
				default:
					String parameter = args[1];
					System.out.println(parameter);

					scs = new SchemaStudio();

					if (parameter.contains("/")) {
						System.out.println("liste");

						String[] words;

						HomeUri url = null;
						try {
							url = new HomeUri(parameter);
						} catch (URISyntaxException e) {
							e.printStackTrace();
						}

						scs = new SchemaStudio();
						boolean start = true;
						for (String word : url.getWords()) {
							if (start) scs.place(word, "disc", new Point (100,100)); else scs.next(word, "disc") ;
								scs.setRState();
							start = false;
						}
					} else defaut = true;

					schema = scs;

			}
		} else defaut = true;
				
		
		if (defaut) {
			System.out.println("Traitement par défaut : " + args.length);
		
			SchemaStudio gwd = new SchemaStudio();
			
			gwd.place("prog.lib (32-37)", new Point(250,50));
			gwd.next("init-vars.bash (38)");
			gwd.next("getArgs (401)");
			
			gwd.setRState();
			gwd.next("exec_is_seal (410, [207-237])");
			gwd.next("check_db_xml (416)");
			gwd.next("gen_coll_unindented");
			gwd.next("ExtractGuide");
			
			schema = gwd;
		}
		schema.toSvg(fileName);

	}

}
