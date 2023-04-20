import arc.*;
import java.awt.*;
import java.awt.image.*;

public class rpgUtilities{
//---------------------------------------------------------READING CSV FILE---------------------------------------------------------------------//	
	public static String[][] ReadCSV(Console con){
		//opening CSV file to read
		TextInputFile mapfile = new TextInputFile("maps/rpgmap1.csv");
		int intRow;
		int intColumn;
		String strLine;
		String strComma[];
		String strReadingMap[][];
		strReadingMap = new String[20][20];
		//reads the CSV file, removes the comma, and puts it into a 2d array
		for(intRow = 0; intRow < 20; intRow++){
			strLine = mapfile.readLine();
			strComma = strLine.split(",");
			for(intColumn = 0; intColumn < 20; intColumn++){
			strReadingMap[intRow][intColumn] = strComma[intColumn];
			}
		}
		mapfile.close();
		return strReadingMap; 
	}
//---------------------------------------------------------Battle Enemy One Tile---------------------------------------------------------------------//		
	public static int BattleEnemyOne(int intHeroHP, int intHeroSTR, int intHeroDEF, int intEnemy1HP, int intEnemy1STR, int intEnemy1DEF, Console con){
		con.clear();
		//char variable for key input on which animation and damage they want to do/deal
		char chrKeyAbility;
		//for animation
		int intCount;  
		boolean blnAnimation = true;
		//making variables for all images
		BufferedImage background1image = con.loadImage("Background1.gif");
		BufferedImage CharizardBattleHero = con.loadImage("CharizardBattle.png");
		BufferedImage MelmetalBattleEnemy1 = con.loadImage("MelmetalBattleEnemy1.gif");
		BufferedImage AnimationATK = con.loadImage("fireball.gif"); 
		BufferedImage EnemyAnimationATK = con.loadImage("IronIngot.gif");
		con.drawImage(background1image, 0, 0); 				
		con.repaint();
		
		//animation and damage runs off of this 
		while(blnAnimation){
			//draws charizard and enemy one
			con.drawImage(CharizardBattleHero, 30, 280);
			con.drawImage(MelmetalBattleEnemy1, 300, 260);
			
			//HUD for fighting 
			con.setDrawColor(Color.BLACK);
			con.fillRect(0, 600, 600, 400);
			con.setDrawColor(Color.WHITE);
			con.fillRect(280, 600, 10, 300);
			con.setDrawColor(Color.WHITE);
			con.drawString("HERO HP: "+intHeroHP, 5, 600);
			con.drawString("HERO ATK: "+intHeroSTR, 5, 620);
			con.drawString("HERO DEF: "+intHeroDEF, 5, 640);
			//different animation and same damage
			con.drawString("Press (q) to fight", 5, 680);
			//different animation and increased damage
			con.drawString("Press (e) to fight", 5, 710);
			
			con.drawString("ENEMY HP: "+intEnemy1HP, 305, 600);
			con.drawString("ENEMY ATK: "+intEnemy1STR, 305, 620);
			con.drawString("ENEMY DEF: "+intEnemy1DEF, 305, 640);
			con.repaint();
			
			chrKeyAbility = con.currentChar();
			//press q to do damage
			if(chrKeyAbility == 'q'){
				//enemy hp + enemy def = total enemy hp - hero atk = new total hp
				//adds enemy hp and enemy def to get a new total hp, then subtracts it by the hero's strength to get the new total hp 
				con.drawString("Fireball!", 5, 740);
				//calculates damage
				intEnemy1HP = intEnemy1HP + intEnemy1DEF - intHeroSTR; 
				//then shows an animation
				for(intCount = 0; intCount < 200; intCount++){
					con.drawImage(background1image, 0, 0);
					con.drawImage(CharizardBattleHero, 30, 280);
					con.drawImage(MelmetalBattleEnemy1, 300, 260);
					con.drawImage(AnimationATK, 60+intCount, 280);
					con.repaint();
					con.sleep(4);
				}
				//when animation is over, draws the backgruond again so the image doesnt stay when it hits the target
				con.drawImage(background1image, 0, 0);
				con.sleep(200);
				
				con.drawString("Double Iron Bash!", 305, 740);
				//calculates damage
				intHeroHP = intHeroHP + intHeroDEF - intEnemy1STR;
				//then shows the enemy animation
				for(intCount = 0; intCount < 200; intCount++){
					con.drawImage(background1image, 0, 0);
					con.drawImage(CharizardBattleHero, 30, 280);
					con.drawImage(MelmetalBattleEnemy1, 300, 260);
					con.drawImage(EnemyAnimationATK, 280-intCount, 280);
					con.repaint();
					con.sleep(4);
				}
				//draws the background again so the image doesnt stay when it hits the target
				con.drawImage(background1image, 0, 0); 
				//once everything is done, shows how much damage you've dealt and how much damage you've taken
				con.drawString("You have dealt: "+(intHeroSTR-intEnemy1DEF)+" DMG!", 5, 780);			
				con.drawString("You have taken: "+(intEnemy1STR-intHeroDEF)+" DMG!", 5, 820);
				con.drawImage(CharizardBattleHero, 30, 280);
				con.drawImage(MelmetalBattleEnemy1, 300, 260);
				con.repaint();
				//wait 2 seconds until pressing next attack
				con.sleep(2000);
			
			}else if(chrKeyAbility == 'e'){
				con.drawString("DOUBLE Fireball!", 5, 740);
				intEnemy1HP = intEnemy1HP + intEnemy1DEF - (intHeroSTR + 5); 
				for(intCount = 0; intCount < 200; intCount++){
					con.drawImage(background1image, 0, 0);
					con.drawImage(CharizardBattleHero, 30, 280);
					con.drawImage(MelmetalBattleEnemy1, 300, 260);
					con.drawImage(AnimationATK, 60+intCount, 280);
					con.drawImage(AnimationATK, 60+intCount, 250);
					con.repaint();
					con.sleep(4);
				}
				con.drawImage(background1image, 0, 0);
				con.sleep(200);
				
				con.drawString("QUADRUPLE Iron Bash!", 305, 740);
				intHeroHP = intHeroHP + intHeroDEF - (intEnemy1STR + 5);
				for(intCount = 0; intCount < 200; intCount++){
					con.drawImage(background1image, 0, 0);
					con.drawImage(CharizardBattleHero, 30, 280);
					con.drawImage(MelmetalBattleEnemy1, 300, 260);
					con.drawImage(EnemyAnimationATK, 280-intCount, 280);
					con.repaint();
					con.sleep(4);
				}
				con.drawImage(background1image, 0, 0);
				con.drawString("You have dealt: "+((intHeroSTR + 5)-intEnemy1DEF)+" DMG!", 5, 780);			
				con.drawString("You have taken: "+((intEnemy1STR + 5)-intHeroDEF)+" DMG!", 5, 820); 
				con.drawImage(CharizardBattleHero, 30, 280);
				con.drawImage(MelmetalBattleEnemy1, 300, 260);
				con.repaint();
				con.sleep(2000);			
			}
			con.sleep(200);
			
			//once the animation and damage calculation is done, you either:
			//kill the enemy and stops the while loop
			//die and it closes the game  
			if(intEnemy1HP <= 0){
				blnAnimation = false;
			}
			
			if(intHeroHP <= 0){
				con.clear();
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 600, 600, 400);
				con.fillRect(0, 0, 600, 600);
				con.repaint();
				con.println("YOU DIED!");
				con.println("Closing Game in 2 seconds");
				con.sleep(2000);
				con.closeConsole();
			}
		}
		//if you win it prompts the user to go back to the map area
		con.setDrawColor(Color.BLACK);
		con.fillRect(0, 600, 600, 400);
		con.setDrawColor(Color.WHITE);
		con.drawString("You have won!", 5, 600);
		con.drawString("Press (r) to leave.", 5, 620);
		con.repaint();
		chrKeyAbility = con.getChar();
		if(chrKeyAbility == 'r'){
			blnAnimation = false;
		}  
		return intHeroHP;
	}
//---------------------------------------------------------Battle Enemy Two Tile---------------------------------------------------------------------//	
	public static int BattleEnemyTwo(int intHeroHP, int intHeroSTR, int intHeroDEF, int intEnemy2HP, int intEnemy2STR, int intEnemy2DEF, Console con){
		con.clear();
		char chrKeyAbility;
		int intCount;  
		boolean blnAnimation = true;
		BufferedImage background1image = con.loadImage("Background1.gif");
		BufferedImage CharizardBattleHero = con.loadImage("CharizardBattle.png");
		BufferedImage TapuBuluBattleEnemy2 = con.loadImage("TapuBuluBattleEnemy2.gif");
		BufferedImage AnimationATK = con.loadImage("fireball.gif"); 
		BufferedImage EnemyAnimationATK = con.loadImage("leafstorm.gif");
		con.drawImage(background1image, 0, 0); 				
		con.repaint();
		
		while(blnAnimation){
			con.drawImage(CharizardBattleHero, 30, 280);
			con.drawImage(TapuBuluBattleEnemy2, 300, 240);
			
			con.setDrawColor(Color.BLACK);
			con.fillRect(0, 600, 600, 400);
			con.setDrawColor(Color.WHITE);
			con.fillRect(280, 600, 10, 300);
			con.setDrawColor(Color.WHITE);
			con.drawString("HERO HP: "+intHeroHP, 5, 600);
			con.drawString("HERO ATK: "+intHeroSTR, 5, 620);
			con.drawString("HERO DEF: "+intHeroDEF, 5, 640);
			//different animation and same damage
			con.drawString("Press (q) to fight", 5, 680);
			//different animation and increased damage
			con.drawString("Press (e) to fight", 5, 710);
			
			con.drawString("ENEMY HP: "+intEnemy2HP, 305, 600);
			con.drawString("ENEMY ATK: "+intEnemy2STR, 305, 620);
			con.drawString("ENEMY DEF: "+intEnemy2DEF, 305, 640);
			con.repaint();
			
			chrKeyAbility = con.currentChar();
			if(chrKeyAbility == 'q'){
				//enemy hp + enemy def = total enemy hp - hero atk = new total hp
				//adds enemy hp and enemy def to get a new total hp, then subtracts it by the hero's strength to get the new total hp 
				con.drawString("Fireball!", 5, 740);
				//calculates damage
				intEnemy2HP = intEnemy2HP + intEnemy2DEF - intHeroSTR; 
				//plays animation
				for(intCount = 0; intCount < 200; intCount++){
					con.drawImage(background1image, 0, 0);
					con.drawImage(CharizardBattleHero, 30, 280);
					con.drawImage(TapuBuluBattleEnemy2, 300, 240);
					con.drawImage(AnimationATK, 60+intCount, 280);
					con.repaint();
					con.sleep(4);
				}
				//when animation is over, draws the backgruond again so the image doesnt stay when it hits the target
				con.drawImage(background1image, 0, 0);
				con.sleep(200);
				
				con.drawString("Leaf Storm!", 305, 740);
				//calculates enemy damage
				intHeroHP = intHeroHP + intHeroDEF - intEnemy2STR;
				//plays enemy animation
				for(intCount = 0; intCount < 200; intCount++){
					con.drawImage(background1image, 0, 0);
					con.drawImage(CharizardBattleHero, 30, 280);
					con.drawImage(TapuBuluBattleEnemy2, 300, 240);
					con.drawImage(EnemyAnimationATK, 280-intCount, 260);
					con.repaint();
					con.sleep(4);
				}
				//when animation is over, draws the backgruond again so the image doesnt stay when it hits the target
				con.drawImage(background1image, 0, 0);
				//prints the damage dealt and damage taken
				con.drawString("You have dealt: "+(intHeroSTR-intEnemy2DEF)+" DMG!", 5, 780);			
				con.drawString("You have taken: "+(intEnemy2STR-intHeroDEF)+" DMG!", 5, 820);
				con.drawImage(CharizardBattleHero, 30, 280);
				con.drawImage(TapuBuluBattleEnemy2, 300, 240);
				con.repaint(); 				
				con.sleep(2000);
			
			}else if(chrKeyAbility == 'e'){
				con.drawString("DOUBLE Fireball!", 5, 740);
				intEnemy2HP = intEnemy2HP + intEnemy2DEF - (intHeroSTR + 5); 
				for(intCount = 0; intCount < 200; intCount++){
					con.drawImage(background1image, 0, 0);
					con.drawImage(CharizardBattleHero, 30, 280);
					con.drawImage(TapuBuluBattleEnemy2, 300, 240);
					con.drawImage(AnimationATK, 60+intCount, 280);
					con.drawImage(AnimationATK, 60+intCount, 250);
					con.repaint();
					con.sleep(4);
				}
				con.drawImage(background1image, 0, 0);
				con.sleep(200);
				
				con.drawString("Leaf MAELSTORM!", 305, 740);
				intHeroHP = intHeroHP + intHeroDEF - (intEnemy2STR + 5);
				for(intCount = 0; intCount < 200; intCount++){
					con.drawImage(background1image, 0, 0);
					con.drawImage(CharizardBattleHero, 30, 280);
					con.drawImage(TapuBuluBattleEnemy2, 300, 240);
					con.drawImage(EnemyAnimationATK, 280-intCount, 260);
					con.repaint();
					con.sleep(4);
				}
				con.drawImage(background1image, 0, 0); 
				con.drawString("You have dealt: "+((intHeroSTR + 5)-intEnemy2DEF)+" DMG!", 5, 780);			
				con.drawString("You have taken: "+((intEnemy2STR + 5)-intHeroDEF)+" DMG!", 5, 820); 
				con.drawImage(CharizardBattleHero, 30, 280);
				con.drawImage(TapuBuluBattleEnemy2, 300, 240);
				con.repaint();
				con.sleep(2000);			
			}
			con.sleep(200);
			
			//once the animation and damage calculation is done, you either:
			//kill the enemy and stops the while loop
			//die and it closes the game
			if(intEnemy2HP <= 0){
				blnAnimation = false;
			}
			
			if(intHeroHP <= 0){
				con.clear();
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 600, 600, 400);
				con.fillRect(0, 0, 600, 600);
				con.repaint();
				con.println("YOU DIED!");
				con.println("Closing Game in 2 seconds");
				con.sleep(2000);
				con.closeConsole();
			}
		}
		//if you win it prompts the user to go back to the map area
		con.setDrawColor(Color.BLACK);
		con.fillRect(0, 600, 600, 400);
		con.setDrawColor(Color.WHITE);
		con.drawString("You have won!", 5, 600);
		con.drawString("Press (r) to leave.", 5, 620);
		con.repaint();
		chrKeyAbility = con.currentChar();
		if(chrKeyAbility == 'r'){
			blnAnimation = false;
		}
	return intHeroHP;
	}
//---------------------------------------------------------Battle Enemy Three Tile---------------------------------------------------------------------//	
	public static int BattleEnemyThree(int intHeroHP, int intHeroSTR, int intHeroDEF, int intEnemy3HP, int intEnemy3STR, int intEnemy3DEF, Console con){
		con.clear();
		char chrKeyAbility;
		int intCount;  
		boolean blnAnimation = true;
		BufferedImage background2image = con.loadImage("Background2.gif");
		BufferedImage CharizardBattleHero = con.loadImage("CharizardBattle.png");
		BufferedImage ZacianBattleEnemy3 = con.loadImage("ZacianBattleEnemy3.gif");
		BufferedImage AnimationATK = con.loadImage("fireball.gif"); 
		BufferedImage EnemyAnimationATK = con.loadImage("swordthrow.gif");
		con.drawImage(background2image, 0, 0); 					
		con.repaint();
		
		while(blnAnimation){
			con.drawImage(CharizardBattleHero, 30, 400);
			con.drawImage(ZacianBattleEnemy3, 300, 380);
			
			con.setDrawColor(Color.BLACK);
			con.fillRect(0, 600, 600, 400);
			con.setDrawColor(Color.WHITE);
			con.fillRect(280, 600, 10, 300);
			con.setDrawColor(Color.WHITE);
			con.drawString("HERO HP: "+intHeroHP, 5, 600);
			con.drawString("HERO ATK: "+intHeroSTR, 5, 620);
			con.drawString("HERO DEF: "+intHeroDEF, 5, 640);
			//different animation and same damage
			con.drawString("Press (q) to fight", 5, 680);
			//different animation and increased damage
			con.drawString("Press (e) to fight", 5, 710);
			
			con.drawString("ENEMY HP: "+intEnemy3HP, 305, 600);
			con.drawString("ENEMY ATK: "+intEnemy3STR, 305, 620);
			con.drawString("ENEMY DEF: "+intEnemy3DEF, 305, 640);
			con.repaint();
			
			chrKeyAbility = con.currentChar();
			if(chrKeyAbility == 'q'){
				//enemy hp + enemy def = total enemy hp - hero atk = new total hp
				//adds enemy hp and enemy def to get a new total hp, then subtracts it by the hero's strength to get the new total hp 
				con.drawString("Fireball!", 5, 740);
				intEnemy3HP = intEnemy3HP + intEnemy3DEF - intHeroSTR; 
				for(intCount = 0; intCount < 200; intCount++){
					con.drawImage(background2image, 0, 0);
					con.drawImage(CharizardBattleHero, 30, 400);
					con.drawImage(ZacianBattleEnemy3, 300, 380);
					con.drawImage(AnimationATK, 60+intCount, 400);
					con.repaint();
					con.sleep(4);
				}
				con.drawImage(background2image, 0, 0);
				con.sleep(200);
				
				con.drawString("MASTER SWORD THROW!", 305, 740);
				intHeroHP = intHeroHP + intHeroDEF - intEnemy3STR;
				for(intCount = 0; intCount < 200; intCount++){
					con.drawImage(background2image, 0, 0);
					con.drawImage(CharizardBattleHero, 30, 400);
					con.drawImage(ZacianBattleEnemy3, 300, 380);
					con.drawImage(EnemyAnimationATK, 280-intCount, 400);
					con.repaint();
					con.sleep(4);
				}
				con.drawImage(background2image, 0, 0);
				con.drawString("You have dealt: "+(intHeroSTR-intEnemy3DEF)+" DMG!", 5, 780);			
				con.drawString("You have taken: "+(intEnemy3STR-intHeroDEF)+" DMG!", 5, 820);
				con.drawImage(CharizardBattleHero, 30, 400);
				con.drawImage(ZacianBattleEnemy3, 300, 380);
				con.repaint(); 				
				con.sleep(2000);
			
			}else if(chrKeyAbility == 'e'){
				con.drawString("DOUBLE Fireball!", 5, 740);
				intEnemy3HP = intEnemy3HP + intEnemy3DEF - (intHeroSTR + 5); 
				for(intCount = 0; intCount < 200; intCount++){
					con.drawImage(background2image, 0, 0);
					con.drawImage(CharizardBattleHero, 30, 400);
					con.drawImage(ZacianBattleEnemy3, 300, 380);
					con.drawImage(AnimationATK, 60+intCount, 400);
					con.drawImage(AnimationATK, 60+intCount, 370);
					con.repaint();
					con.sleep(4);
				}
				con.drawImage(background2image, 0, 0);
				con.sleep(200);
				
				con.drawString("ULTRA SWORD COMBAT!", 305, 740);
				intHeroHP = intHeroHP + intHeroDEF - (intEnemy3STR + 5);
				for(intCount = 0; intCount < 200; intCount++){
					con.drawImage(background2image, 0, 0);
					con.drawImage(CharizardBattleHero, 30, 400);
					con.drawImage(ZacianBattleEnemy3, 300, 380);
					con.drawImage(EnemyAnimationATK, 280-intCount, 400);
					con.repaint();
					con.sleep(4);
				}
				con.drawImage(background2image, 0, 0); 
				con.drawString("You have dealt: "+((intHeroSTR + 5)-intEnemy3DEF)+" DMG!", 5, 780);			
				con.drawString("You have taken: "+((intEnemy3STR + 5)-intHeroDEF)+" DMG!", 5, 820); 
				con.drawImage(CharizardBattleHero, 30, 400);
				con.drawImage(ZacianBattleEnemy3, 300, 380);
				con.repaint();
				con.sleep(2000);			
			}
			con.sleep(200);
			
			if(intEnemy3HP <= 0){
				blnAnimation = false;
			}
			
			if(intHeroHP <= 0){
				con.clear();
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 600, 600, 400);
				con.fillRect(0, 0, 600, 600);
				con.repaint();
				con.println("YOU DIED!");
				con.println("Closing Game in 2 seconds");
				con.sleep(2000);
				con.closeConsole();
			}
		}
		con.setDrawColor(Color.BLACK);
		con.fillRect(0, 600, 600, 400);
		con.setDrawColor(Color.WHITE);
		con.drawString("You have won!", 5, 600);
		con.drawString("Press (r) to leave.", 5, 620);
		con.repaint();
		chrKeyAbility = con.currentChar();
		if(chrKeyAbility == 'r'){
			blnAnimation = false;
		}	
	return intHeroHP;
	}
//---------------------------------------------------------Battle Boss Tile---------------------------------------------------------------------//	
	public static void BattleBoss(int intHeroHP, int intHeroSTR, int intHeroDEF, int intBossHP, int intBossSTR, int intBossDEF, Console con){
		con.clear();
		char chrKeyAbility;
		int intCount;  
		boolean blnAnimation = true;
		BufferedImage background2image = con.loadImage("Background2.gif");
		BufferedImage CharizardBattleHero = con.loadImage("CharizardBattle.png");
		BufferedImage BossBattleEnemy = con.loadImage("BossBattleEnemy.gif");
		BufferedImage AnimationATK = con.loadImage("fireball.gif"); 
		BufferedImage EnemyAnimationATK = con.loadImage("plasmaball.gif");
		BufferedImage EnemyAnimationTwoATK = con.loadImage("dracometeor.gif");
		con.drawImage(background2image, 0, 0); 					
		con.repaint();
		
		while(blnAnimation){
			con.drawImage(CharizardBattleHero, 30, 400);
			con.drawImage(BossBattleEnemy, 300, 230);
			
			con.setDrawColor(Color.BLACK);
			con.fillRect(0, 600, 600, 400);
			con.setDrawColor(Color.WHITE);
			con.fillRect(280, 600, 10, 300);
			con.setDrawColor(Color.WHITE);
			con.drawString("HERO HP: "+intHeroHP, 5, 600);
			con.drawString("HERO ATK: "+intHeroSTR, 5, 620);
			con.drawString("HERO DEF: "+intHeroDEF, 5, 640);
			//different animation and same damage
			con.drawString("Press (q) to fight", 5, 680);
			//different animation and increased damage
			con.drawString("Press (e) to fight", 5, 710);
			
			con.drawString("ENEMY HP: "+intBossHP, 305, 600);
			con.drawString("ENEMY ATK: "+intBossSTR, 305, 620);
			con.drawString("ENEMY DEF: "+intBossDEF, 305, 640);
			con.repaint();
			
			chrKeyAbility = con.currentChar();
			if(chrKeyAbility == 'q'){
				//enemy hp + enemy def = total enemy hp - hero atk = new total hp
				//adds enemy hp and enemy def to get a new total hp, then subtracts it by the hero's strength to get the new total hp 
				con.drawString("DOUBLE FIREBALL!", 5, 740);
				intBossHP = intBossHP + intBossDEF - intHeroSTR; 
				for(intCount = 0; intCount < 200; intCount++){
					con.drawImage(background2image, 0, 0);
					con.drawImage(CharizardBattleHero, 30, 400);
					con.drawImage(BossBattleEnemy, 300, 230);
					con.drawImage(AnimationATK, 60+intCount, 400);
					con.drawImage(AnimationATK, 60+intCount, 370);
					con.repaint();
					con.sleep(5);
				}
				con.drawImage(background2image, 0, 0);
				con.sleep(200);
				
				con.drawString("PLASMA BALL!", 305, 740);
				intHeroHP = intHeroHP + intHeroDEF - intBossSTR;
				for(intCount = 0; intCount < 270; intCount++){
					con.drawImage(background2image, 0, 0);
					con.drawImage(CharizardBattleHero, 30, 400);
					con.drawImage(BossBattleEnemy, 300, 230);
					con.drawImage(EnemyAnimationATK, 300-intCount, 280);
					con.repaint();
					con.sleep(5);
				}
				con.drawImage(background2image, 0, 0);
				con.drawString("You have dealt: "+(intHeroSTR-intBossDEF)+" DMG!", 5, 780);			
				con.drawString("You have taken: "+(intBossSTR-intHeroDEF)+" DMG!", 5, 820);
				con.drawImage(CharizardBattleHero, 30, 400);
				con.drawImage(BossBattleEnemy, 300, 230);
				con.repaint(); 				
				con.sleep(2000);
			
			}else if(chrKeyAbility == 'e'){
				con.drawString("TRI-FIRE!", 5, 740);
				intBossHP = intBossHP + intBossDEF - (intHeroSTR+5); 
				for(intCount = 0; intCount < 200; intCount++){
					con.drawImage(background2image, 0, 0);
					con.drawImage(CharizardBattleHero, 30, 400);
					con.drawImage(BossBattleEnemy, 300, 230);
					con.drawImage(AnimationATK, 60+intCount, 400);
					con.drawImage(AnimationATK, 60+intCount, 370);
					con.drawImage(AnimationATK, 60+intCount, 340);
					con.repaint();
					con.sleep(5);
				}
				con.drawImage(background2image, 0, 0);
				con.sleep(200);
				
				con.drawString("DRACO METEOR!", 305, 740);
				intHeroHP = intHeroHP + intHeroDEF - (intBossSTR + 5);
				for(intCount = 0; intCount < 340; intCount++){
					con.drawImage(background2image, 0, 0);
					con.drawImage(CharizardBattleHero, 30, 400);
					con.drawImage(BossBattleEnemy, 300, 230);
					con.drawImage(EnemyAnimationTwoATK, 30, 0+intCount);
					con.repaint();
					con.sleep(3);
				}
				con.drawImage(background2image, 0, 0); 
				con.drawString("You have dealt: "+((intHeroSTR + 5)-intBossDEF)+" DMG!", 5, 780);			
				con.drawString("You have taken: "+((intBossSTR + 5)-intHeroDEF)+" DMG!", 5, 820); 
				con.drawImage(CharizardBattleHero, 30, 400);
				con.drawImage(BossBattleEnemy, 300, 230);
				con.repaint();
				con.sleep(2000);			
			}
			con.sleep(200);
			
			if(intBossHP <= 0){
				blnAnimation = false;
			}
			
			if(intHeroHP <= 0){
				con.clear();
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 600, 600, 400);
				con.fillRect(0, 0, 600, 600);
				con.repaint();
				con.println("YOU DIED!");
				con.println("Closing Game in 2 seconds");
				con.sleep(2000);
				con.closeConsole();
			}
		}
	}
//---------------------------------------------------------Help Screen---------------------------------------------------------------------//	
	public static void HelpScreen(Console con){
		con.clear();
		con.setDrawColor(Color.BLACK);
		con.fillRect(0, 600, 600, 400);
		con.fillRect(0, 0, 600, 600);
		con.println("        Help Screen");
		con.println("\n1. There are two different abilities in battle \nscreen, you either press Q or Press E.\n");
		con.println("2. When you press Q, Damage Calculations are \nbased off of your Hero ATK - Enemy DEF.\n");
		con.println("3. When you press Q, The enemy damage will be \nbased off of Enemy ATK - Hero DEF.\n");
		con.println("4. When you press E, Damage Calculations are \nbased off of your (Hero ATK + 5) - Enemy DEF.\n");
		con.println("5. When you press E, The enemy damage will be \nbased off of (Enemy ATK + 5) - Hero DEF.\n");
		con.println("6. Running into the tree or the fences on the \nbridge will stop you from moving.\n");
		con.println("7. If you run into water, you die.\n");
		con.println("8. If you go into a cave (a building), \nit will heal you or increase your HP by 10.\n"); 
		con.println("9. Items can give you a range of stats, from ATK \nincrease or DEF increase or even an HP increase, \nit will depend on which item it looks like.\n");  
		con.println("   The red disk will give you +5 ATK. The rainbow \ndisk will give you +20 ATK. The greyish blue disk \nwill give you +15 DEF.\n"); 
		con.println("10. Beat all the enemies. Get all the items. \nYou can win the game if you play correctly.\n");
		con.print("Press (c) to go back to Menu: ");
	}
}
