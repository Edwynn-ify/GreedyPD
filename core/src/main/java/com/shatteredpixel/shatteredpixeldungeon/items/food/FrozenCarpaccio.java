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

package com.shatteredpixel.shatteredpixeldungeon.items.food;

import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Adrenaline;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.AdrenalineSurge;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.AnkhInvulnerability;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.ArcaneArmor;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.ArtifactRecharge;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Barkskin;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Barrier;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Bless;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.BlobImmunity;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.FireImbue;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Foresight;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.FrostImbue;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Haste;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Hunger;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Invisibility;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.MagicalSight;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.MindVision;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Recharging;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.ToxicImbue;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.effects.Speck;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfHealing;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.elixirs.ElixirOfAquaticRejuvenation;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.exotic.PotionOfCleansing;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import com.watabou.utils.Random;

public class FrozenCarpaccio extends Food {

	{
		image = ItemSpriteSheet.CARPACCIO;
		energy = Hunger.HUNGRY/1.5f;
	}
	
	@Override
	protected void satisfy(Hero hero) {
		super.satisfy(hero);
		effect(hero);
	}
	
	public int value() {
		return 10 * quantity;
	}

	public static void effect(Hero hero){
		switch (Random.Int( 19 )) {
			case 0:
				GLog.i( Messages.get(FrozenCarpaccio.class, "invis") );
				Buff.affect( hero, Invisibility.class, Invisibility.DURATION );
				break;
			case 1:
				GLog.i( Messages.get(FrozenCarpaccio.class, "hard") );
				Buff.affect( hero, Barkskin.class ).set( hero.HT , 4 );
				break;
			case 2:
				GLog.i( Messages.get(FrozenCarpaccio.class, "refresh") );
				PotionOfHealing.cure(hero) ;
				break;
			case 3:
				GLog.i( Messages.get(FrozenCarpaccio.class, "refresh") );
				PotionOfHealing.cure(hero) ;
				Buff.affect( hero, FrostImbue.class, FrostImbue.DURATION );
				break;
			case 4:
				GLog.i( Messages.get(FrozenCarpaccio.class, "refresh") );
				PotionOfHealing.cure(hero) ;
				Buff.affect( hero, FireImbue.class, FireImbue.DURATION );
				break;
			case 5:
				GLog.i( Messages.get(FrozenCarpaccio.class, "refresh") );
				PotionOfHealing.cure(hero) ;
				Buff.affect( hero, ToxicImbue.class, ToxicImbue.DURATION );
				break;
			case 6:
				GLog.i( Messages.get(FrozenCarpaccio.class, "refresh") );
				PotionOfHealing.cure(hero) ;
				Buff.affect(hero, ElixirOfAquaticRejuvenation.AquaHealing.class).set(Math.round(hero.HT * 3f));
				break;
			case 7:
				GLog.i( Messages.get(FrozenCarpaccio.class, "refresh") );
				PotionOfHealing.cure(hero) ;
				Buff.affect(hero, ArcaneArmor.class).set(10 + hero.lvl, 160);
				break;
			case 8:
				GLog.i( Messages.get(FrozenCarpaccio.class, "refresh") );
				PotionOfHealing.cure(hero) ;
				Buff.affect(hero, Barkskin.class).set( 8 + hero.lvl, 200 );
				break;
			case 9:
				GLog.i( Messages.get(FrozenCarpaccio.class, "refresh") );
				PotionOfHealing.cure(hero) ;
				Buff.affect( hero, Bless.class, Bless.DURATION );;
				break;
			case 10:
				GLog.i( Messages.get(FrozenCarpaccio.class, "refresh") );
				PotionOfHealing.cure(hero) ;
				Buff.affect( hero, MindVision.class, MindVision.DURATION);
				break;
			case 11:
				GLog.i( Messages.get(FrozenCarpaccio.class, "refresh") );
				PotionOfHealing.cure(hero) ;
				Buff.affect( hero, MagicalSight.class, MagicalSight.DURATION );
				break;
			case 12:
				GLog.i( Messages.get(FrozenCarpaccio.class, "refresh") );
				PotionOfHealing.cure(hero) ;
				Buff.affect( hero, Haste.class, Haste.DURATION );
				break;
			case 13:
				GLog.i( Messages.get(FrozenCarpaccio.class, "refresh") );
				PotionOfHealing.cure(hero) ;
				Buff.affect( hero, Adrenaline.class, Adrenaline.DURATION );
				break;
			case 14:
				GLog.i( Messages.get(FrozenCarpaccio.class, "refresh") );
				PotionOfHealing.cure(hero) ;
				Buff.affect(hero, Barrier.class).setShield((int) (1.2f * hero.HT + 20));
				break;
			case 15:
				GLog.i( Messages.get(FrozenCarpaccio.class, "refresh") );
				PotionOfHealing.cure(hero) ;
				Buff.affect( hero, BlobImmunity.class, BlobImmunity.DURATION );;
				break;
			case 16:
				GLog.i( Messages.get(FrozenCarpaccio.class, "refresh") );
				PotionOfHealing.cure(hero) ;
				Buff.affect( hero, PotionOfCleansing.Cleanse.class, PotionOfCleansing.Cleanse.DURATION);
				break;
			case 17:
				GLog.i( Messages.get(FrozenCarpaccio.class, "refresh") );
				PotionOfHealing.cure(hero) ;
				Buff.affect( hero, AnkhInvulnerability.class, AnkhInvulnerability.DURATION );;
				break;
			case 18:
				GLog.i( Messages.get(FrozenCarpaccio.class, "better") );
				if (hero.HP < hero.HT) {
					hero.HP = Math.min( hero.HP + hero.HT / 2, hero.HT );
					hero.sprite.emitter().burst( Speck.factory( Speck.HEALING ), 1 );
				}
				break;
		}
	}
	
	public static Food cook( MysteryMeat ingredient ) {
		FrozenCarpaccio result = new FrozenCarpaccio();
		result.quantity = ingredient.quantity();
		return result;
	}
}
