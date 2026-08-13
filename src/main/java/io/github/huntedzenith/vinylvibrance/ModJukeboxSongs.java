package io.github.huntedzenith.vinylvibrance;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.JukeboxSong;

public class ModJukeboxSongs {
    public static final ResourceKey<JukeboxSong> DREAMS =
            ResourceKey.create(
                    Registries.JUKEBOX_SONG,
                    VinylVibrance.id("dreams")
            );

    public static final ResourceKey<JukeboxSong> SAILS =
            ResourceKey.create(
                    Registries.JUKEBOX_SONG,
                    VinylVibrance.id("sails")
            );

    public static final ResourceKey<JukeboxSong> PURPUR =
            ResourceKey.create(
                    Registries.JUKEBOX_SONG,
                    VinylVibrance.id("purpur")
            );

    public static final ResourceKey<JukeboxSong> CANNONS =
            ResourceKey.create(
                    Registries.JUKEBOX_SONG,
                    VinylVibrance.id("cannons")
            );

    public static final ResourceKey<JukeboxSong> TREASURE =
            ResourceKey.create(
                    Registries.JUKEBOX_SONG,
                    VinylVibrance.id("treasure")
            );

    public static final ResourceKey<JukeboxSong> BLANK_MUSIC_DISC =
            ResourceKey.create(
                    Registries.JUKEBOX_SONG,
                    VinylVibrance.id("blank_disc_crackle")
            );
}
