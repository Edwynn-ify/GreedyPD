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

import com.shatteredpixel.shatteredpixeldungeon.actors.blobs.Foliage;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.WandOfRegrowth;
import com.shatteredpixel.shatteredpixeldungeon.levels.Level;
import com.shatteredpixel.shatteredpixeldungeon.levels.Terrain;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;
import com.shatteredpixel.shatteredpixeldungeon.plants.BlandfruitBush;
import com.shatteredpixel.shatteredpixeldungeon.plants.Blindweed;
import com.shatteredpixel.shatteredpixeldungeon.plants.Earthroot;
import com.shatteredpixel.shatteredpixeldungeon.plants.Fadeleaf;
import com.shatteredpixel.shatteredpixeldungeon.plants.Firebloom;
import com.shatteredpixel.shatteredpixeldungeon.plants.Icecap;
import com.shatteredpixel.shatteredpixeldungeon.plants.Mageroyal;
import com.shatteredpixel.shatteredpixeldungeon.plants.Rotberry;
import com.shatteredpixel.shatteredpixeldungeon.plants.Sorrowmoss;
import com.shatteredpixel.shatteredpixeldungeon.plants.Starflower;
import com.shatteredpixel.shatteredpixeldungeon.plants.Stormvine;
import com.shatteredpixel.shatteredpixeldungeon.plants.Sungrass;
import com.shatteredpixel.shatteredpixeldungeon.plants.Swiftthistle;
import com.watabou.utils.Random;

public class GardenRoom extends SpecialRoom {

	public void paint( Level level ) {
		
		Painter.fill( level, this, Terrain.WALL );
		Painter.fill( level, this, 1, Terrain.HIGH_GRASS );
		Painter.fill( level, this, 2, Terrain.GRASS );
		
		entrance().set( Door.Type.REGULAR );

		int bushes = Random.Int(3);
		if (bushes == 0) {
			level.plant(new WandOfRegrowth.Dewcatcher.Seed(), plantPos( level ));
		} else if (bushes == 1) {
			level.plant(new BlandfruitBush.Seed(), plantPos( level ));
		} else if (bushes == 2) {
			level.plant(new Blindweed.Seed(), plantPos( level ));
		} else if (bushes == 3) {
			level.plant(new Earthroot.Seed(), plantPos( level ));
		} else if (bushes == 4) {
			level.plant(new Fadeleaf.Seed(), plantPos( level ));
		} else if (bushes == 5) {
			level.plant(new Firebloom.Seed(), plantPos( level ));
		} else if (bushes == 6) {
			level.plant(new Icecap.Seed(), plantPos( level ));
		} else if (bushes == 7) {
			level.plant(new Mageroyal.Seed(), plantPos( level ));
		} else if (bushes == 8) {
			level.plant(new Rotberry.Seed(), plantPos( level ));
		} else if (bushes == 9) {
			level.plant(new Sorrowmoss.Seed(), plantPos( level ));
		} else if (bushes == 10) {
			level.plant(new Starflower.Seed(), plantPos( level ));
		} else if (bushes == 11) {
			level.plant(new Stormvine.Seed(), plantPos( level ));
		} else if (bushes == 12) {
			level.plant(new Sungrass.Seed(), plantPos( level ));
		} else if (bushes == 13) {
			level.plant(new Swiftthistle.Seed(), plantPos( level ));
		} else if (bushes == 14) {
			level.plant(new WandOfRegrowth.Seedpod.Seed(), plantPos( level ));


		} else if (Random.Int(5) == 0) {
			level.plant(new Sungrass.Seed(), plantPos( level ));
			level.plant(new BlandfruitBush.Seed(), plantPos( level ));
			level.plant(new Mageroyal.Seed(), plantPos( level ));
		}


		
		Foliage light = (Foliage)level.blobs.get( Foliage.class );
		if (light == null) {
			light = new Foliage();
		}
		for (int i=top + 1; i < bottom; i++) {
			for (int j=left + 1; j < right; j++) {
				light.seed( level, j + level.width() * i, 1 );
			}
		}
		level.blobs.put( Foliage.class, light );
	}
	
	private int plantPos( Level level ){
		int pos;
		do{
			pos = level.pointToCell(random());
		} while (level.plants.get(pos) != null);
		return pos;
	}
}
