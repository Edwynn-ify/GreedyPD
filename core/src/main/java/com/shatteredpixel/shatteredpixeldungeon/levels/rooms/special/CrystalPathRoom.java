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
import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.items.Gold;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.keys.CrystalKey;
import com.shatteredpixel.shatteredpixeldungeon.items.keys.IronKey;

import com.shatteredpixel.shatteredpixeldungeon.levels.Level;
import com.shatteredpixel.shatteredpixeldungeon.levels.Terrain;
import com.shatteredpixel.shatteredpixeldungeon.levels.painters.Painter;
import com.shatteredpixel.shatteredpixeldungeon.levels.rooms.Room;
import com.shatteredpixel.shatteredpixeldungeon.levels.rooms.standard.EmptyRoom;
import com.watabou.utils.Point;
import com.watabou.utils.Random;

public class CrystalPathRoom extends SpecialRoom {

	@Override
	public int minWidth() { return 7; }
	public int minHeight() { return 7; }

	@Override
	public void paint(Level level) {

		Painter.fill( level, this, Terrain.WALL );
		Painter.fill( level, this, 1, Terrain.EMPTY_SP );

		Door entrance = entrance();

		Point center;
		do {
			center = center();
		} while (center.x == entrance.x || center.y == entrance.y);

		//draw walls between internal rooms
		Painter.drawLine(level, new Point(center.x, top+1), new Point(center.x, bottom-1), Terrain.WALL);
		Painter.drawLine(level, new Point(left+1, center.y), new Point(right-1, center.y), Terrain.WALL);

		Point door = new Point(entrance);

		//determine if the door and loot order should be clockwise or counterclockwise
		boolean clockwise;
		if (entrance.x == left || entrance.x == right){
			door.x = center.x;
			clockwise = entrance.y < center.y;
			if (entrance.x  == right) clockwise = !clockwise;
		} else {
			door.y = center.y;
			clockwise = entrance.x > center.x;
			if (entrance.y == bottom) clockwise = !clockwise;
		}

		//define the four sub-rooms. clockwise from top-left
		Room[] rooms = new EmptyRoom[4];
		rooms[0] = new EmptyRoom();
		rooms[0].set(left+1, top+1, center.x-1, center.y-1);
		rooms[1] = new EmptyRoom();
		rooms[1].set(center.x+1, top+1, right-1, center.y-1);
		rooms[2] = new EmptyRoom();
		rooms[2].set(center.x+1, center.y+1, right-1, bottom-1);
		rooms[3] = new EmptyRoom();
		rooms[3].set(left+1, center.y+1, center.x-1, bottom-1);

		//place 3 crystal doors in the center between rooms,
		// forming a clockwise or counterclockwise pattern
		for (int i = 0; i < 3; i++){
			if (door.x == center.x){
				if (door.y < center.y){
					door.y = rooms[0].center().y;
				} else {
					door.y = rooms[2].center().y;
				}
			} else {
				if (door.x < center.x){
					door.x = rooms[0].center().x;
				} else {
					door.x = rooms[1].center().x;
				}
			}
			Painter.set(level, door, Terrain.CRYSTAL_DOOR);
			door.x -= center.x;
			door.y -= center.y;
			int tmp = door.x;
			door.x = door.y;
			door.y = tmp;
			if (clockwise)  door.x = -door.x;
			else            door.y = -door.y;
			door.x += center.x;
			door.y += center.y;
		}

		//figure out room order for loot, and start generating it!
		int idx = 0;
		for (int i = 0; i < rooms.length; i++){
			rooms[i].set(rooms[i].shrink(-2)); //we grow/shrink the room to increase intersection bounds
			if (rooms[i].inside(entrance)){
				idx = i;
			}
			rooms[i].set(rooms[i].shrink(2));
		}

		for (int i = 0; i < 17; i++){
			int pos = level.pointToCell(rooms[idx].center());
			Item item;
			switch (i) {
				case 0:
				default:
					item = new Gold().random();
					break;
				case 1:
					item = Generator.random(Generator.Category.POTION);
					break;
				case 2:
					item = Generator.random(Generator.Category.SCROLL);
					break;
				case 3:
					item = Generator.random(Generator.Category.RING);
					break;
				case 4:
					item = Generator.random(Generator.Category.WEAPON);
					break;
				case 5:
					item = Generator.random(Generator.Category.ARMOR);
					break;
				case 6:
					item = Generator.random(Generator.Category.ARTIFACT);
					break;
				case 7:
					item = Generator.random(Generator.Category.STONE);
					break;
				case 8:
					item = Generator.random(Generator.Category.FOOD);
					break;
				case 9:
					item = Generator.random(Generator.Category.SEED);
					break;
				case 10:
					item = Generator.random(Generator.Category.EXOTIC_POTION);
					break;
				case 11:
					item = Generator.random(Generator.Category.EXOTIC_SCROLL);
					break;
				case 12:
					item = Generator.random(Generator.Category.BREW);
					break;
				case 13:
					item = Generator.random(Generator.Category.ELIXIR);
					break;
				case 14:
					item = Generator.random(Generator.Category.SPELL);
					break;
				case 15:
					item = Generator.random(Generator.Category.BOMB);
					break;
				case 16:
					item = Generator.random(Generator.Category.WAND);
					break;

			}
			level.drop(item, pos);
			if (clockwise){
				idx++;
				if (idx > 3) idx = 0;
			} else {
				idx--;
				if (idx < 0) idx = 3;
			}
		}

		level.addItemToSpawn( new CrystalKey( Dungeon.depth ) );
		level.addItemToSpawn( new CrystalKey( Dungeon.depth ) );
		level.addItemToSpawn( new CrystalKey( Dungeon.depth ) );

		entrance().set( Door.Type.LOCKED );
		level.addItemToSpawn( new IronKey( Dungeon.depth ) );

	}

	@Override
	public boolean canConnect(Point p) {
		if (!super.canConnect(p)){
			return false;
		}
		//don't place door in the exact center, if that exists
		if (width() % 2 == 1 && p.x == center().x){
			return false;
		}
		if (height() % 2 == 1 && p.y == center().y){
			return false;
		}
		return true;
	}

}
