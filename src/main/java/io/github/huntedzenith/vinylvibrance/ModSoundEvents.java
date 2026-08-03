package io.github.huntedzenith.vinylvibrance;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;

public class ModSoundEvents {
    private static SoundEvent register(String name){
        SoundEvent soundEvent = SoundEvent.createVariableRangeEvent(
                VinylVibrance.id(name)
        );
        Registry.register(
                BuiltInRegistries.SOUND_EVENT,
                VinylVibrance.id(name),
                soundEvent
        );

        return soundEvent;
    }


    public static final SoundEvent MUSIC_DISC_DREAMS =
            register("music_disc_dreams");

    public static final SoundEvent MUSIC_DISC_SAILS =
            register("music_disc_sails");

    public static final SoundEvent MUSIC_DISC_PURPUR =
            register("music_disc_purpur");


    public static final SoundEvent BLANK_DISC_CRACKLE =
            register("blank_disc_crackle");
}
