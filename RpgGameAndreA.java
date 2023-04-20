//V 5.1
//By: Andre Arcaina
//due 2021-09-23 @ 2:30 PM

//additional features done:
//HUD (Heads Up Display)
//battle animation
//giving hero and enemy stats
//damage and defence calculations
//hero can carry items that give damage or defence or HP
//smooth drawing

import java.awt.*;
import java.awt.image.*;

public class RpgGameAndreA{
	public static void main(String[] args){
		Console con = new Console("Charizard Adventures!", 600, 900);		
		//boolean variable to make the game keep going
		boolean blnPlay = true;
		//char variable for user to input if they want to play or need help
		char chrKey;
		
		while(blnPlay){
			//menu screen
			con.setDrawColor(Color.WHITE);
			con.fillRect(0, 600, 600, 400);
			con.fillRect(0, 0, 600, 600);
			con.setDrawColor(Color.RED);
			con.drawString("Charizard Adventures!", 150, 5);
			con.fillRect(0, 40, 600, 10);
			con.drawString("Press (p) to play the game.", 80, 50);
			con.drawString("Press (h) for help on the game.", 80, 100);
			BufferedImage CharizardHero = con.loadImage("CharizardHero.gif");
			con.drawImage(CharizardHero, 60, 300);
			con.repaint();
	
			chrKey = con.getChar();
			
			//play screen
			if(chrKey == 'p'){
				con.clear();
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 600, 600, 400);
				con.fillRect(0, 0, 600, 600);
				con.println("Makeshift Story:\n");
				con.println("Long ago in a far away land where pokemon and \nhumans alike lived together.. But, \ncatastrophy striked and the humans went extinct!\n");
				con.println("You as the hero, Charizard, have to navigate \nthrough the daunted bridge of death and the ruined \nforest to defeat the corrupted king of this land!\n\n\n\n\n");
				int i = 10;
				while (i > 0) {
					con.print(i);
					i -= 1;
					con.sleep(1000);
					con.clear();
					con.println("Makeshift Story:\n");
					con.println("Long ago in a far away land where pokemon and \nhumans alike lived together.. But, \ncatastrophy striked and the humans went extinct!\n");
					con.println("You as the hero, Charizard, have to navigate \nthrough the daunted bridge of death and the ruined \nforest to defeat the corrupted king of this land!\n\n\n\n\n");
				}
				con.clear();
				
				String strMap[][];
				//method to read the csv file
				strMap = rpgtools.ReadCSV(con); 
				
				//loads all the images from file
				BufferedImage grassimage = con.loadImage("grass.gif");
				BufferedImage groundimage = con.loadImage("ground.gif");
				BufferedImage bridgeimage = con.loadImage("bridge.gif");
				BufferedImage sandimage = con.loadImage("sand.gif");
				BufferedImage heroimage = con.loadImage("hero.gif");
				BufferedImage item1image = con.loadImage("ITEM_IRON_DEFENCE.gif");
				BufferedImage item2image = con.loadImage("ITEM_SPECTRAL_BEAM.gif");
				BufferedImage item3image = con.loadImage("ITEM_FIRE_BOOST.gif");
				BufferedImage item4image = con.loadImage("ITEM_POTION.gif");
				BufferedImage treeimage = con.loadImage("tree.gif");
				BufferedImage fenceimage = con.loadImage("fence.gif");
				BufferedImage waterimage = con.loadImage("water.gif");
				BufferedImage buildingimage = con.loadImage("building.gif");
				BufferedImage enemy1image = con.loadImage("enemy1.gif");
				BufferedImage enemy2image = con.loadImage("enemy2.gif");
				BufferedImage enemy3image = con.loadImage("enemy3.gif");
				BufferedImage bossimage = con.loadImage("boss.gif");
				
				int intRow;
				int intCol;
				
				//draws the entire map
				for(intRow = 0; intRow < 20; intRow++){
					for(intCol = 0; intCol < 20; intCol++){
						if(strMap[intRow][intCol].equals("tree")){
							con.drawImage(treeimage, intCol*30, intRow*30);
						}else if(strMap[intRow][intCol].equals("fence")){
							con.drawImage(fenceimage, intCol*30, intRow*30);					
						}else if(strMap[intRow][intCol].equals("ground")){
							con.drawImage(groundimage, intCol*30, intRow*30);					
						}else if(strMap[intRow][intCol].equals("bridge")){
							con.drawImage(bridgeimage, intCol*30, intRow*30);
						}else if(strMap[intRow][intCol].equals("sand")){
							con.drawImage(sandimage, intCol*30, intRow*30);
						}else if(strMap[intRow][intCol].equals("water")){
							con.drawImage(waterimage, intCol*30, intRow*30);
						}else if(strMap[intRow][intCol].equals("building")){
							con.drawImage(buildingimage, intCol*30, intRow*30);
						}else if(strMap[intRow][intCol].equals("grass")){
							con.drawImage(grassimage, intCol*30, intRow*30);
						}else if(strMap[intRow][intCol].equals("enemy1")){
							con.drawImage(enemy1image, intCol*30, intRow*30);
						}else if(strMap[intRow][intCol].equals("enemy2")){
							con.drawImage(enemy2image, intCol*30, intRow*30);
						}else if(strMap[intRow][intCol].equals("enemy3")){
							con.drawImage(enemy3image, intCol*30, intRow*30);
						}else if(strMap[intRow][intCol].equals("boss")){
							con.drawImage(bossimage, intCol*30, intRow*30);
						}else if(strMap[intRow][intCol].equals("ITEM_IRON_DEFENCE")){
							con.drawImage(item1image, intCol*30, intRow*30);
						}else if(strMap[intRow][intCol].equals("ITEM_SPECTRAL_BEAM")){
							con.drawImage(item2image, intCol*30, intRow*30);
						}else if(strMap[intRow][intCol].equals("ITEM_FIRE_BOOST")){
							con.drawImage(item3image, intCol*30, intRow*30);
						}else if(strMap[intRow][intCol].equals("ITEM_POTION")){
							con.drawImage(item4image, intCol*30, intRow*30);
						}
					}
				}
				
				//Charizard coordinates at the beginning
				int intHeroCol = 0;
				int intHeroRow = 9;
				int intPrevHeroCol = 0;
				int intPrevHeroRow = 9;
				con.drawImage(heroimage, intHeroCol*30, intHeroRow*30);
				
				//Charizard Stats
				int intHeroHP = 200;
				int intHeroSTR = 20;
				int intHeroDEF = 10;
				
				//Enemy 1 Stats
				int intEnemy1HP = 80;
				int intEnemy1STR = 15;
				int intEnemy1DEF = 5;
				
				//Enemy 2 Stats
				int intEnemy2HP = 100;
				int intEnemy2STR = 20;
				int intEnemy2DEF = 5;
				
				//Enemy 3 Stats
				int intEnemy3HP = 45;
				int intEnemy3STR = 40;
				int intEnemy3DEF = 0;
				
				//Boss Stats
				int intBossHP = 150;
				int intBossSTR = 60;
				int intBossDEF = 20;
				
				//variable for W A S D function
				char chrKeyInput;
				
				con.setDrawColor(Color.WHITE);
				con.drawString("HERO HP: "+intHeroHP, 5, 600);
				con.drawString("HERO ATK: "+intHeroSTR, 5, 620);
				con.drawString("HERO DEF: "+intHeroDEF, 5, 640);		
				con.repaint();
				
				//loop to do everything (actually play the game)
				while(intHeroHP > 0){
					chrKeyInput = con.getChar();
					con.setDrawColor(Color.BLACK);
					con.fillRect(0, 600, 600, 400);
					con.setDrawColor(Color.WHITE);
					con.drawString("HERO HP: "+intHeroHP, 5, 600);
					con.drawString("HERO ATK: "+intHeroSTR, 5, 620);
					con.drawString("HERO DEF: "+intHeroDEF, 5, 640);
					
					//inputting W A S D to move the Hero
					if(chrKeyInput == 'w'){
						intHeroRow = intHeroRow -1;
					}else if(chrKeyInput == 'a' && intHeroCol != 0){
						intHeroCol = intHeroCol -1;
					}else if(chrKeyInput == 's' ){
						intHeroRow = intHeroRow +1;
					}else if(chrKeyInput == 'd'){
						intHeroCol = intHeroCol +1;
					}
					
					//repaints the entire map again everytime Charizard/hero moves 
					for(intRow = 0; intRow < 20; intRow++){
						for(intCol = 0; intCol < 20; intCol++){
							if(strMap[intRow][intCol].equals("tree")){
								con.drawImage(treeimage, intCol*30, intRow*30);
							}else if(strMap[intRow][intCol].equals("fence")){
								con.drawImage(fenceimage, intCol*30, intRow*30);					
							}else if(strMap[intRow][intCol].equals("ground")){
								con.drawImage(groundimage, intCol*30, intRow*30);					
							}else if(strMap[intRow][intCol].equals("bridge")){
								con.drawImage(bridgeimage, intCol*30, intRow*30);
							}else if(strMap[intRow][intCol].equals("sand")){
								con.drawImage(sandimage, intCol*30, intRow*30);
							}else if(strMap[intRow][intCol].equals("water")){
								con.drawImage(waterimage, intCol*30, intRow*30);
							}else if(strMap[intRow][intCol].equals("building")){
								con.drawImage(buildingimage, intCol*30, intRow*30);
							}else if(strMap[intRow][intCol].equals("grass")){
								con.drawImage(grassimage, intCol*30, intRow*30);
							}else if(strMap[intRow][intCol].equals("enemy1")){
								con.drawImage(enemy1image, intCol*30, intRow*30);
							}else if(strMap[intRow][intCol].equals("enemy2")){
								con.drawImage(enemy2image, intCol*30, intRow*30);
							}else if(strMap[intRow][intCol].equals("enemy3")){
								con.drawImage(enemy3image, intCol*30, intRow*30);
							}else if(strMap[intRow][intCol].equals("boss")){
								con.drawImage(bossimage, intCol*30, intRow*30);
							}else if(strMap[intRow][intCol].equals("ITEM_IRON_DEFENCE")){
								con.drawImage(item1image, intCol*30, intRow*30);
							}else if(strMap[intRow][intCol].equals("ITEM_SPECTRAL_BEAM")){
								con.drawImage(item2image, intCol*30, intRow*30);
							}else if(strMap[intRow][intCol].equals("ITEM_FIRE_BOOST")){
								con.drawImage(item3image, intCol*30, intRow*30);
							}else if(strMap[intRow][intCol].equals("ITEM_POTION")){
							con.drawImage(item4image, intCol*30, intRow*30);
							}
						}
					}
						
					//Statement that basically asks where the hero is on the map, and if it equals the water tile
					//the hero dies
					//once the hero dies the loop resets and goes back to main menu screen
					if(strMap[intHeroRow][intHeroCol].equals("water")){
						intHeroHP = 0;
						con.clear();
						con.setDrawColor(Color.BLACK);
						con.fillRect(0, 600, 600, 200);
						con.setDrawColor(Color.WHITE);
						con.drawString("HP: "+intHeroHP, 5, 600);
						con.setDrawColor(Color.WHITE);
						con.drawString("Charizard can't swim. RIP.", 5, 650); 
						con.drawString("Going Back to main menu in 3 seconds.", 5, 700);
						con.repaint();
						con.sleep(3000);
					}
					
					//stops the hero going into the tree and fence that is on the bridge
					if(strMap[intHeroRow][intHeroCol].equals("tree") || strMap[intHeroRow][intHeroCol].equals("fence")){
						if(chrKeyInput == 'w'){
							intHeroRow = intHeroRow +1;
							con.setDrawColor(Color.WHITE);
							con.drawString("You cannot go into that!", 5, 700);
						}else if(chrKeyInput == 'a'){
							intHeroCol = intHeroCol +1;
							con.setDrawColor(Color.WHITE);
							con.drawString("You cannot go into that!", 5, 700);
						}else if(chrKeyInput == 's'){
							intHeroRow = intHeroRow -1;
							con.setDrawColor(Color.WHITE);
							con.drawString("You cannot go into that!", 5, 700);
						}else if(chrKeyInput == 'd'){
							intHeroCol = intHeroCol -1;
							con.setDrawColor(Color.WHITE);
							con.drawString("You cannot go into that!", 5, 700);
						}
					}
					
					//adds health by 10 when going into the building (my building is a cave)
					if(strMap[intHeroRow][intHeroCol].equals("building")){
						intHeroHP = intHeroHP +10;
						con.setDrawColor(Color.WHITE);
						con.drawString("Charizard has rested! +10 HP.", 5, 700);
						con.repaint();
					}
					//replaces the building with ground tile
					if(strMap[intPrevHeroRow][intPrevHeroCol].equals("building")){
						strMap[intPrevHeroRow][intPrevHeroCol] = "ground";
						con.drawImage(groundimage, intPrevHeroCol*30, intPrevHeroRow*30);				
					}
					//item Fire Boost
					if(strMap[intHeroRow][intHeroCol].equals("ITEM_FIRE_BOOST")){
						intHeroSTR = intHeroSTR+5;
						con.setDrawColor(Color.WHITE);
						con.drawString("Charizard has equipped FIRE BOOST! +5 ATK!", 5, 700);
						con.repaint();
					}
					//replaces the item with grass tile
					if(strMap[intPrevHeroRow][intPrevHeroCol].equals("ITEM_FIRE_BOOST")){
						strMap[intPrevHeroRow][intPrevHeroCol] = "grass";
						con.drawImage(grassimage, intPrevHeroCol*30, intPrevHeroRow*30);				
					}
					//item Spectral Beam 
					if(strMap[intHeroRow][intHeroCol].equals("ITEM_SPECTRAL_BEAM")){
						intHeroSTR = intHeroSTR+20;
						con.setDrawColor(Color.WHITE);
						con.drawString("Charizard has equipped SPECTRAL BEAM! +20 ATK!", 5, 700);
						con.repaint();
					}
					//replaces the item with grass tile
					if(strMap[intPrevHeroRow][intPrevHeroCol].equals("ITEM_SPECTRAL_BEAM")){
						strMap[intPrevHeroRow][intPrevHeroCol] = "grass";
						con.drawImage(grassimage, intPrevHeroCol*30, intPrevHeroRow*30);				
					}
					//item Iron Defence
					if(strMap[intHeroRow][intHeroCol].equals("ITEM_IRON_DEFENCE")){
						intHeroDEF = intHeroDEF+15;
						con.setDrawColor(Color.WHITE);
						con.drawString("Charizard has equipped IRON DEFENCE! +15 DEF!", 5, 700);
						con.repaint();
					}
					//replaces the item with grass tile
					if(strMap[intPrevHeroRow][intPrevHeroCol].equals("ITEM_IRON_DEFENCE")){
						strMap[intPrevHeroRow][intPrevHeroCol] = "grass";
						con.drawImage(grassimage, intPrevHeroCol*30, intPrevHeroRow*30);				
					}
					//item potion
					if(strMap[intHeroRow][intHeroCol].equals("ITEM_POTION")){
						intHeroHP = intHeroHP+215;
						con.setDrawColor(Color.WHITE);
						con.drawString("Charizard has DRANK POTION! +215 HP!", 5, 700);
						con.repaint();
					}
					//replaces the item with grass tile
					if(strMap[intPrevHeroRow][intPrevHeroCol].equals("ITEM_POTION")){
						strMap[intPrevHeroRow][intPrevHeroCol] = "grass";
						con.drawImage(grassimage, intPrevHeroCol*30, intPrevHeroRow*30);				
					}
					
					//make the previous hero coordinates = current hero coordinates to replace previous tile
					intPrevHeroCol = intHeroCol;
					intPrevHeroRow = intHeroRow;
					//redraws each hero everytime
					con.drawImage(heroimage, intHeroCol*30, intHeroRow*30);
					con.repaint();
					
					//enemy1
					if(strMap[intHeroRow][intHeroCol].equals("enemy1")){
						intHeroHP = rpgtools.BattleEnemyOne(intHeroHP, intHeroSTR, intHeroDEF, intEnemy1HP, intEnemy1STR, intEnemy1DEF, con);
					}
					//once you kill the enemy you replace it with the tile it was on
					if(strMap[intPrevHeroRow][intPrevHeroCol].equals("enemy1")){
						strMap[intPrevHeroRow][intPrevHeroCol] = "bridge";
						con.drawImage(bridgeimage, intPrevHeroCol*30, intPrevHeroRow*30);				
					}
					
					//enemy2
					if(strMap[intHeroRow][intHeroCol].equals("enemy2")){
						intHeroHP = rpgtools.BattleEnemyTwo(intHeroHP, intHeroSTR, intHeroDEF, intEnemy2HP, intEnemy2STR, intEnemy2DEF, con);
					}
					//once you kill the enemy you replace it with the tile it was on
					if(strMap[intPrevHeroRow][intPrevHeroCol].equals("enemy2")){
						strMap[intPrevHeroRow][intPrevHeroCol] = "bridge";
						con.drawImage(bridgeimage, intPrevHeroCol*30, intPrevHeroRow*30);				
					}
					
					//enemy3
					if(strMap[intHeroRow][intHeroCol].equals("enemy3")){
						intHeroHP = rpgtools.BattleEnemyThree(intHeroHP, intHeroSTR, intHeroDEF, intEnemy3HP, intEnemy3STR, intEnemy3DEF, con);
					}
					//once you kill the enemy you replace it with the tile it was on
					if(strMap[intPrevHeroRow][intPrevHeroCol].equals("enemy3")){
						strMap[intPrevHeroRow][intPrevHeroCol] = "grass";
						con.drawImage(grassimage, intPrevHeroCol*30, intPrevHeroRow*30);				
					}
					
					//boss
					if(strMap[intHeroRow][intHeroCol].equals("boss")){
						rpgtools.BattleBoss(intHeroHP, intHeroSTR, intHeroDEF, intBossHP, intBossSTR, intBossDEF, con);
						con.setDrawColor(Color.BLACK);
						con.fillRect(0, 600, 600, 400);
						con.fillRect(0, 0, 600, 600);
						con.setDrawColor(Color.WHITE);
						con.println("YOU HAVE BEATEN THE BOSS OF THIS WORLD!\nWELL PLAYED!!\n Going back to main menu in 5 seconds.");
						con.repaint();
						con.sleep(5000);
						con.clear();
						intHeroHP = 0;
					}
				}
			}else if(chrKey == 'h'){
				//method to show help screen
				rpgtools.HelpScreen(con);
				//asks user to input c to leave help screen
				chrKey = con.readChar();
				while(chrKey != 'c'){		
					if(chrKey != 'c'){
						con.clear();
						con.print("Input correct character (c): ");
						System.out.println("Inputted Wrong Character: "+chrKey);
						chrKey = con.readChar(); 
						con.clear();
					}
				}
				con.clear();
			}	
		}
	}	
}
