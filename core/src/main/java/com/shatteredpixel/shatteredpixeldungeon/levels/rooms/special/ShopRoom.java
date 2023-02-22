/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2022 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon.levels.rooms.special;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.CorrosiveGas;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Belongings;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.Mob;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.PrismaticImage;
import com.shatteredpixel.shatteredpixeldungeon.actors.mobs.npcs.Shopkeeper;
import com.shatteredpixel.shatteredpixeldungeon.items.Ankh;
import com.shatteredpixel.shatteredpixeldungeon.items.BrokenSeal;
import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.items.Heap;
import com.shatteredpixel.shatteredpixeldungeon.items.Honeypot;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.MerchantsBeacon;
import com.shatteredpixel.shatteredpixeldungeon.items.Stylus;
import com.shatteredpixel.shatteredpixeldungeon.items.Torch;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.LeatherArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.MailArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.PlateArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.ScaleArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.CapeOfThorns;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.CloakOfShadows;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.LloydsBeacon;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.TimekeepersHourglass;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.Bag;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.MagicalHolster;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.PotionBandolier;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.ScrollHolder;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.VelvetPouch;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.ArcaneBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Bomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Firebomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Flashbang;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.FrostBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Noisemaker;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.RegrowthBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.ShockBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.ShrapnelBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.WoollyBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.food.ChargrilledMeat;
import com.shatteredpixel.shatteredpixeldungeon.items.food.FrozenCarpaccio;
import com.shatteredpixel.shatteredpixeldungeon.items.food.MeatPie;
import com.shatteredpixel.shatteredpixeldungeon.items.food.MysteryMeat;
import com.shatteredpixel.shatteredpixeldungeon.items.food.SmallRation;
import com.shatteredpixel.shatteredpixeldungeon.items.food.StewedMeat;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.AlchemicalCatalyst;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfHealing;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfStrength;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.BlizzardBrew;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.CausticBrew;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.InfernalBrew;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.brews.ShockingBrew;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfAquaticRejuvenation;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfArcaneArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfDragonsBlood;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfHoneyedHealing;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfIcyTouch;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfMight;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfToxicEssence;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfCleansing;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfCorrosiveGas;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfDivineInspiration;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfDragonsBreath;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfEarthenArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfMagicalSight;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfMastery;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfShielding;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfShroudingFog;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfSnapFreeze;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfStamina;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.Embers;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.GooBlob;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.MetalShard;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfIdentify;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfMagicMapping;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfRemoveCurse;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfUpgrade;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfAntiMagic;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfChallenge;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfDivination;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfDread;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfEnchantment;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfForesight;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfMysticalEnergy;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfPassage;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfPrismaticImage;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfPsionicBlast;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfSirensSong;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.Alchemize;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.AquaBlast;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.ArcaneCatalyst;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.BeaconOfReturning;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.CurseInfusion;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.FeatherFall;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.PhaseShift;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.ReclaimTrap;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.Recycle;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.SummonElemental;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.TelekineticGrab;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.WildEnergy;
import com.shatteredpixel.shatteredpixeldungeon.items.stones.StoneOfAugmentation;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.SpiritBow;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.MagesStaff;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.MeleeWeapon;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.darts.TippedDart;
import com.shatteredpixel.shatteredpixeldungeon.levels.Level;
import com.shatteredpixel.shatteredpixeldungeon.levels.Terrain;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ElementalSprite;
import com.watabou.utils.Point;
import com.watabou.utils.Random;

import java.util.ArrayList;
import java.util.HashMap;

public class ShopRoom extends SpecialRoom {

	private ArrayList<Item> itemsToSpawn;
	
	@Override
	public int minWidth() {
		return Math.max(7, (int)(Math.sqrt(itemCount())+3));
	}
	
	@Override
	public int minHeight() {
		return Math.max(7, (int)(Math.sqrt(itemCount())+3));
	}

	public int itemCount(){
		if (itemsToSpawn == null) itemsToSpawn = generateItems();
		return itemsToSpawn.size();
	}
	
	public void paint( Level level ) {
		
		Painter.fill( level, this, Terrain.WALL );
		Painter.fill( level, this, 1, Terrain.EMPTY_SP );

		placeShopkeeper( level );

		placeItems( level );
		
		for (Door door : connected.values()) {
			door.set( Door.Type.REGULAR );
		}

	}

	protected void placeShopkeeper( Level level ) {

		int pos = level.pointToCell(center());

		Mob shopkeeper = new Shopkeeper();
		shopkeeper.pos = pos;
		level.mobs.add( shopkeeper );

	}

	protected void placeItems( Level level ){

		if (itemsToSpawn == null){
			itemsToSpawn = generateItems();
		}

		Point itemPlacement = new Point(entrance());
		if (itemPlacement.y == top){
			itemPlacement.y++;
		} else if (itemPlacement.y == bottom) {
			itemPlacement.y--;
		} else if (itemPlacement.x == left){
			itemPlacement.x++;
		} else {
			itemPlacement.x--;
		}

		for (Item item : itemsToSpawn) {

			if (itemPlacement.x == left+1 && itemPlacement.y != top+1){
				itemPlacement.y--;
			} else if (itemPlacement.y == top+1 && itemPlacement.x != right-1){
				itemPlacement.x++;
			} else if (itemPlacement.x == right-1 && itemPlacement.y != bottom-1){
				itemPlacement.y++;
			} else {
				itemPlacement.x--;
			}

			int cell = level.pointToCell(itemPlacement);

			if (level.heaps.get( cell ) != null) {
				do {
					cell = level.pointToCell(random());
				} while (level.heaps.get( cell ) != null || level.findMob( cell ) != null);
			}

			level.drop( item, cell ).type = Heap.Type.FOR_SALE;
		}

	}
	
	protected static ArrayList<Item> generateItems() {

		ArrayList<Item> itemsToSpawn = new ArrayList<>();

		MeleeWeapon w;
		switch (Dungeon.depth) {
		case 6: default:
			w = (MeleeWeapon) Generator.random(Generator.wepTiers[1]);
			itemsToSpawn.add( Generator.random(Generator.misTiers[1]).quantity(5).identify(false) );
			itemsToSpawn.add( new LeatherArmor().identify(false) );
			break;
			
		case 11:
			w = (MeleeWeapon) Generator.random(Generator.wepTiers[2]);
			itemsToSpawn.add( Generator.random(Generator.misTiers[2]).quantity(5).identify(false) );
			itemsToSpawn.add( new MailArmor().identify(false) );
			break;
			
		case 16:
			w = (MeleeWeapon) Generator.random(Generator.wepTiers[3]);
			itemsToSpawn.add( Generator.random(Generator.misTiers[3]).quantity(5).identify(false) );
			itemsToSpawn.add( new ScaleArmor().identify(false) );
			break;

		case 20: case 21:
			w = (MeleeWeapon) Generator.random(Generator.wepTiers[4]);
			itemsToSpawn.add( Generator.random(Generator.misTiers[4]).quantity(5).identify(false) );
			itemsToSpawn.add( new PlateArmor().identify(false) );
			itemsToSpawn.add( new Torch() );
			itemsToSpawn.add( new Torch() );
			itemsToSpawn.add( new Torch() );
			break;
		}
		w.enchant(null);
		w.cursed = false;
		w.level(0);
		w.identify(false);
		itemsToSpawn.add(w);
		
		itemsToSpawn.add( TippedDart.randomTipped(5) );

		itemsToSpawn.add( new Alchemize().quantity(Random.IntRange(2, 5)));

		itemsToSpawn.add(ChooseBag(Dungeon.hero.belongings));


		itemsToSpawn.add( new PotionOfHealing() );
		itemsToSpawn.add( new PotionOfHealing() );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.POTION ) );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.POTION ) );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.EXOTIC_POTION ) );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.EXOTIC_POTION ) );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.ELIXIR) );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.RANDOM_ITEM ) );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.RANDOM_ITEM ) );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.RANDOM_ITEM) );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.BREW ) );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.ELIXIR) );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.BREW ) );

		itemsToSpawn.add( new ScrollOfIdentify() );
		itemsToSpawn.add( new ScrollOfRemoveCurse() );
		itemsToSpawn.add( new ScrollOfMagicMapping() );
		itemsToSpawn.add( new ScrollOfIdentify() );
		itemsToSpawn.add( new ScrollOfRemoveCurse() );
		itemsToSpawn.add( new ScrollOfMagicMapping() );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.SCROLL ) );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.SCROLL ) );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.EXOTIC_SCROLL ) );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.EXOTIC_SCROLL ) );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.SPELL ) );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.SPELL ) );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.BOMB ) );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.BOMB ) );


		for (int i=0; i < 2; i++)
			itemsToSpawn.add( Random.Int(2) == 0 ?
					Generator.randomUsingDefaults( Generator.Category.POTION ) :
					Generator.randomUsingDefaults( Generator.Category.SCROLL ) );

		itemsToSpawn.add( new SmallRation() );
		itemsToSpawn.add( new SmallRation() );
		
		switch (Random.Int(57)){
			case 0:
				itemsToSpawn.add( new Bomb() );
				itemsToSpawn.add( new Bomb() );
				break;
			case 1:
				itemsToSpawn.add( new Noisemaker() );
				itemsToSpawn.add( new Noisemaker() );
				break;
			case 2:
				itemsToSpawn.add( new Flashbang() );
				itemsToSpawn.add( new Flashbang() );
				break;
			case 3:
				itemsToSpawn.add( new ShrapnelBomb() );
				itemsToSpawn.add( new ShrapnelBomb() );
				break;
			case 4:
				itemsToSpawn.add( new ArcaneBomb() );
				itemsToSpawn.add( new ArcaneBomb() );
				break;
			case 5:
				itemsToSpawn.add( new FrostBomb() );
				itemsToSpawn.add( new FrostBomb() );
				break;
			case 6:
				itemsToSpawn.add( new Firebomb() );
				itemsToSpawn.add( new Firebomb() );
				break;
			case 7:
				itemsToSpawn.add( new RegrowthBomb() );
				itemsToSpawn.add( new RegrowthBomb() );
				break;
			case 8:
				itemsToSpawn.add( new ShockBomb() );
				itemsToSpawn.add( new ShockBomb() );
				break;
			case 9:
				itemsToSpawn.add( new WoollyBomb() );
				itemsToSpawn.add( new WoollyBomb() );
				break;
			case 10:
				itemsToSpawn.add( new PotionOfShielding() );
				itemsToSpawn.add( new PotionOfShielding() );
				break;
			case 11:
				itemsToSpawn.add( new PotionOfDragonsBreath() );
				itemsToSpawn.add( new PotionOfDragonsBreath() );
				break;
			case 12:
				itemsToSpawn.add( new PotionOfSnapFreeze() );
				itemsToSpawn.add( new PotionOfSnapFreeze() );
				break;
			case 13:
				itemsToSpawn.add( new PotionOfCorrosiveGas() );
				itemsToSpawn.add( new PotionOfCorrosiveGas() );
				break;
			case 14:
				itemsToSpawn.add( new ElixirOfAquaticRejuvenation() );
				itemsToSpawn.add( new ElixirOfAquaticRejuvenation() );
				break;
			case 15:
				itemsToSpawn.add( new ElixirOfHoneyedHealing() );
				itemsToSpawn.add( new ElixirOfHoneyedHealing() );

				//Imbuements sell 3 instead of 2.
			case 16:
				itemsToSpawn.add( new ElixirOfDragonsBlood() );
				itemsToSpawn.add( new ElixirOfDragonsBlood() );
				itemsToSpawn.add( new ElixirOfDragonsBlood() );
				break;
			case 17:
				itemsToSpawn.add( new ElixirOfIcyTouch() );
				itemsToSpawn.add( new ElixirOfIcyTouch() );
				itemsToSpawn.add( new ElixirOfIcyTouch() );
				break;
			case 18:
				itemsToSpawn.add( new ElixirOfToxicEssence() );
				itemsToSpawn.add( new ElixirOfToxicEssence() );
				itemsToSpawn.add( new ElixirOfToxicEssence() );
				break;
			case 19:
				itemsToSpawn.add( new PotionOfEarthenArmor() );
				itemsToSpawn.add( new PotionOfEarthenArmor() );
				break;
			case 20:
				itemsToSpawn.add( new ElixirOfArcaneArmor() );
				itemsToSpawn.add( new ElixirOfArcaneArmor() );
				break;
			case 21:
				itemsToSpawn.add( new BlizzardBrew() );
				itemsToSpawn.add( new BlizzardBrew() );
			case 22:
				itemsToSpawn.add( new InfernalBrew() );
				itemsToSpawn.add( new InfernalBrew() );
			case 23:
				itemsToSpawn.add( new ShockingBrew() );
				itemsToSpawn.add( new ShockingBrew() );
			case 24:
				itemsToSpawn.add( new CausticBrew() );
				itemsToSpawn.add( new CausticBrew() );
				break;
			case 25:
				itemsToSpawn.add( new PotionOfMagicalSight() );
				itemsToSpawn.add( new PotionOfMagicalSight() );
				break;
			case 26:
				itemsToSpawn.add( new PotionOfStamina() );
				itemsToSpawn.add( new PotionOfStamina() );
				break;
			case 27:
				itemsToSpawn.add( new PotionOfCleansing() );
				itemsToSpawn.add( new PotionOfCleansing() );
				break;
			case 28:
				itemsToSpawn.add( new PotionOfShroudingFog() );
				itemsToSpawn.add( new PotionOfShroudingFog() );
				break;
			case 29:
				itemsToSpawn.add( new Bomb.DoubleBomb() );
				break;
			case 30:
				itemsToSpawn.add( new Honeypot() );
				itemsToSpawn.add( new Honeypot() );
				break;
			case 31:
				itemsToSpawn.add( new ScrollOfDivination() );
				itemsToSpawn.add( new ScrollOfDivination() );

				break;
			case 32:
				itemsToSpawn.add( new ScrollOfAntiMagic() );
				itemsToSpawn.add( new ScrollOfAntiMagic() );
				break;
			case 33:
				itemsToSpawn.add( new ScrollOfChallenge() );
				itemsToSpawn.add( new ScrollOfChallenge() );
				break;
			case 34:
				itemsToSpawn.add( new ScrollOfDread() );
				itemsToSpawn.add( new ScrollOfDread() );
				break;
			case 35:
				itemsToSpawn.add( new ScrollOfForesight() );
				itemsToSpawn.add( new ScrollOfForesight() );
			case 36:
				itemsToSpawn.add( new ScrollOfMysticalEnergy() );
				itemsToSpawn.add( new ScrollOfMysticalEnergy() );
			case 37:
				itemsToSpawn.add( new ScrollOfPassage() );
				itemsToSpawn.add( new ScrollOfPassage() );
			case 38:
				itemsToSpawn.add( new ScrollOfPrismaticImage() );
				itemsToSpawn.add( new ScrollOfPrismaticImage() );
				break;
			case 39:
				itemsToSpawn.add( new ScrollOfPsionicBlast() );
				itemsToSpawn.add( new ScrollOfPsionicBlast() );
				break;
			case 40:
				itemsToSpawn.add( new ScrollOfSirensSong() );
				itemsToSpawn.add( new ScrollOfSirensSong() );
				break;
			case 41:
				itemsToSpawn.add( new AlchemicalCatalyst() );
				itemsToSpawn.add( new AlchemicalCatalyst() );
				itemsToSpawn.add( new AlchemicalCatalyst() );
				break;
			case 42:
				itemsToSpawn.add( new ArcaneCatalyst() );
				itemsToSpawn.add( new ArcaneCatalyst() );
				itemsToSpawn.add( new ArcaneCatalyst() );
				break;
			case 43:
				itemsToSpawn.add( new GooBlob() );
				itemsToSpawn.add( new GooBlob() );
				itemsToSpawn.add( new GooBlob() );
				break;
			case 44:
				itemsToSpawn.add( new MetalShard() );
				itemsToSpawn.add( new MetalShard() );
				itemsToSpawn.add( new MetalShard() );
				break;
			case 45:
				itemsToSpawn.add( new Embers() );
				itemsToSpawn.add( new Embers() );
				itemsToSpawn.add( new Embers() );
				break;
			case 46:
				itemsToSpawn.add( new TelekineticGrab() );
				itemsToSpawn.add( new TelekineticGrab() );
				itemsToSpawn.add( new TelekineticGrab() );
				break;
			case 47:
				itemsToSpawn.add( new AquaBlast() );
				itemsToSpawn.add( new AquaBlast() );
				itemsToSpawn.add( new AquaBlast() );
				break;
			case 48:
				itemsToSpawn.add( new PhaseShift() );
				itemsToSpawn.add( new PhaseShift() );
				itemsToSpawn.add( new PhaseShift() );
				break;
			case 49:
				itemsToSpawn.add( new BeaconOfReturning() );
				itemsToSpawn.add( new BeaconOfReturning() );
				itemsToSpawn.add( new BeaconOfReturning() );
				break;
			case 50:
				itemsToSpawn.add( new SummonElemental() );
				itemsToSpawn.add( new SummonElemental() );
				itemsToSpawn.add( new SummonElemental() );
				break;
			case 51:
				itemsToSpawn.add( new FeatherFall() );
				itemsToSpawn.add( new FeatherFall() );
				itemsToSpawn.add( new FeatherFall() );
				break;
			case 52:
				itemsToSpawn.add( new ReclaimTrap() );
				itemsToSpawn.add( new ReclaimTrap() );
				itemsToSpawn.add( new ReclaimTrap() );
				break;
			case 53:
				itemsToSpawn.add( new Recycle() );
				itemsToSpawn.add( new Recycle() );
				itemsToSpawn.add( new Recycle() );
				break;
			case 54:
				itemsToSpawn.add( new CurseInfusion() );
				itemsToSpawn.add( new CurseInfusion() );
				itemsToSpawn.add( new CurseInfusion() );
				break;
			case 55:
				itemsToSpawn.add( new WildEnergy() );
				itemsToSpawn.add( new WildEnergy() );
				itemsToSpawn.add( new WildEnergy() );
				break;
			case 56:
				itemsToSpawn.add( new Honeypot() );
				itemsToSpawn.add( new Honeypot() );
				break;
		}

		itemsToSpawn.add( new Ankh() );
		itemsToSpawn.add( new StoneOfAugmentation() );

		TimekeepersHourglass hourglass = Dungeon.hero.belongings.getItem(TimekeepersHourglass.class);
		if (hourglass != null && hourglass.isIdentified() && !hourglass.cursed){
			int bags = 0;
			//creates the given float percent of the remaining bags to be dropped.
			//this way players who get the hourglass late can still max it, usually.
			switch (Dungeon.depth) {
				case 6:
					bags = (int)Math.ceil(( 5-hourglass.sandBags) * 0.20f ); break;
				case 11:
					bags = (int)Math.ceil(( 5-hourglass.sandBags) * 0.25f ); break;
				case 16:
					bags = (int)Math.ceil(( 5-hourglass.sandBags) * 0.50f ); break;
				case 20: case 21:
					bags = (int)Math.ceil(( 5-hourglass.sandBags) * 0.80f ); break;
			}

			for(int i = 1; i <= bags; i++){
				itemsToSpawn.add( new TimekeepersHourglass.sandBag());
				hourglass.sandBags ++;
			}
		}

		Item rare;
		switch (Random.Int(10)){
			case 0:
				rare = Generator.random( Generator.Category.WAND );
				rare.level( 1 );
				break;
			case 1:
				rare = Generator.random(Generator.Category.RING);
				rare.level( 1 );
				break;
			case 2:
				rare = Generator.random( Generator.Category.ARTIFACT );
				break;
			case 3:
				rare = new ScrollOfUpgrade();
				break;
			case 4:
				rare = new ScrollOfEnchantment();
				break;
			case 5:
				rare = new PotionOfStrength();
				break;
			case 6:
				rare = new PotionOfDivineInspiration();
				break;
			case 7:
				rare = new PotionOfMastery();
				break;
			case 8:
				rare = new MeatPie();
				break;
			case 9:
				rare = new BrokenSeal();
				break;
			case 10:
				rare = new MagesStaff();
				break;
				case 11:
				rare = new CloakOfShadows();
				break;
				case 12:
				rare = new SpiritBow();
				break;
			case 13:
				rare = new ElixirOfMight();
				break;
			case 14:
				rare = new LloydsBeacon();
				break;
				case 15:
				rare = new CapeOfThorns();
				break;


			default:
				rare = new Stylus();
		}
		rare.cursed = false;
		rare.cursedKnown = true;
		itemsToSpawn.add( rare );

		//hard limit is 63 items + 1 shopkeeper, as shops can't be bigger than 8x8=64 internally
		if (itemsToSpawn.size() > 63) {
			throw new RuntimeException("Shop attempted to carry more than 63 items!");
		}

		//use a new generator here to prevent items in shop stock affecting levelgen RNG (e.g. sandbags)
		//we can use a random long for the seed as it will be the same long every time
		Random.pushGenerator(Random.Long());
			Random.shuffle(itemsToSpawn);
		Random.popGenerator();

		return itemsToSpawn;
	}

	protected static Bag ChooseBag(Belongings pack){

		//generate a hashmap of all valid bags.
		HashMap<Bag, Integer> bags = new HashMap<>();
		if (!Dungeon.LimitedDrops.VELVET_POUCH.dropped()) bags.put(new VelvetPouch(), 1);
		if (!Dungeon.LimitedDrops.SCROLL_HOLDER.dropped()) bags.put(new ScrollHolder(), 0);
		if (!Dungeon.LimitedDrops.POTION_BANDOLIER.dropped()) bags.put(new PotionBandolier(), 0);
		if (!Dungeon.LimitedDrops.MAGICAL_HOLSTER.dropped()) bags.put(new MagicalHolster(), 0);

		if (bags.isEmpty()) return null;

		//count up items in the main bag
		for (Item item : pack.backpack.items) {
			for (Bag bag : bags.keySet()){
				if (bag.canHold(item)){
					bags.put(bag, bags.get(bag)+1);
				}
			}
		}

		//find which bag will result in most inventory savings, drop that.
		Bag bestBag = null;
		for (Bag bag : bags.keySet()){
			if (bestBag == null){
				bestBag = bag;
			} else if (bags.get(bag) > bags.get(bestBag)){
				bestBag = bag;
			}
		}

		if (bestBag instanceof VelvetPouch){
			Dungeon.LimitedDrops.VELVET_POUCH.drop();
		} else if (bestBag instanceof ScrollHolder){
			Dungeon.LimitedDrops.SCROLL_HOLDER.drop();
		} else if (bestBag instanceof PotionBandolier){
			Dungeon.LimitedDrops.POTION_BANDOLIER.drop();
		} else if (bestBag instanceof MagicalHolster){
			Dungeon.LimitedDrops.MAGICAL_HOLSTER.drop();
		}

		return bestBag;

	}

}
