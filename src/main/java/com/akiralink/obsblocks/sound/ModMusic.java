package com.akiralink.obsblocks.sound;

import net.minecraft.sound.MusicSound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModMusic {
    /*
    static SoundEvent ancientlandsound = new SoundEvent(new Identifier("obsblocks", "ancientland_sound.ogg"));
    public static MusicSound ancientlandmusic = new MusicSound(ancientlandsound,0,0,true);
     */

    public static final Identifier ANCIENTLANDSOUND = new Identifier("obsblocks:ancientlandsound");
    public static SoundEvent ANCIENTLANDMUSIC = new SoundEvent(ANCIENTLANDSOUND);
    public static MusicSound ancientlandmusic = new MusicSound(ANCIENTLANDMUSIC,0,0,true);


}
