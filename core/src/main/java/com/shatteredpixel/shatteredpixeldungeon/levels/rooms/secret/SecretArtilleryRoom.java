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

package com.shatteredpixel.shatteredpixeldungeon.levels.rooms.secret;

import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.ArcaneBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Bomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Firebomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Flashbang;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.FrostBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.HolyBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.Noisemaker;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.RegrowthBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.ShockBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.ShrapnelBomb;
import com.shatteredpixel.shatteredpixeldungeon.items.bombs.WoollyBomb;
import com.shatteredpixel.shatteredpixeldungeon.levels.Level;
import com.shatteredpixel.shatteredpixeldungeon.levels.Terrain;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;

public class SecretArtilleryRoom extends SecretRoom {
	
	@Override
	public void paint(Level level) {
		Painter.fill(level, this, Terrain.WALL);
		Painter.fill(level, this, 1, Terrain.EMPTY_SP);
		
		Painter.set(level, center(), Terrain.STATUE_SP);
		
		for (int i = 0; i < 10; i++){
			int itemPos;
			do{
				itemPos = level.pointToCell(random());
			} while ( level.map[itemPos] != Terrain.EMPTY_SP
					|| level.heaps.get(itemPos) != null);
			
			if( i == 0 ){
				level.drop(new Bomb.DoubleBomb(), itemPos);
				level.drop(new ArcaneBomb(), itemPos);
				level.drop(new ArcaneBomb(), itemPos);
				level.drop(new Firebomb(), itemPos);
				level.drop(new Flashbang(), itemPos);
				level.drop(new FrostBomb(), itemPos);
				level.drop(new HolyBomb(), itemPos);
				level.drop(new Noisemaker(), itemPos);
				level.drop(new RegrowthBomb(), itemPos);
				level.drop(new ShockBomb(), itemPos);
				level.drop(new ShrapnelBomb(), itemPos);
				level.drop(new WoollyBomb(), itemPos);

			} else {
				level.drop(Generator.randomMissile(), itemPos);
				level.drop(new ArcaneBomb(), itemPos);
				level.drop(new ArcaneBomb(), itemPos);
				level.drop(new Firebomb(), itemPos);
				level.drop(new Flashbang(), itemPos);
				level.drop(new FrostBomb(), itemPos);
				level.drop(new HolyBomb(), itemPos);
				level.drop(new Noisemaker(), itemPos);
				level.drop(new RegrowthBomb(), itemPos);
				level.drop(new ShockBomb(), itemPos);
				level.drop(new ShrapnelBomb(), itemPos);
				level.drop(new WoollyBomb(), itemPos);
			}
		}
		
		entrance().set(Door.Type.HIDDEN);
	}
}
