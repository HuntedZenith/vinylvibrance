package io.github.huntedzenith.vinylvibrance;

import io.github.huntedzenith.vinylvibrance.item.VinylDiscItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import java.util.function.Function;

import static io.github.huntedzenith.vinylvibrance.ModSoundEvents.MUSIC_DISC_DREAMS;

public class ModItem {

    private static <T extends Item> T register(
            String name,
            Function<Item.Properties, T> factory,
            Item.Properties properties
    ) {
        ResourceKey<Item> key =
                ResourceKey.create(
                        Registries.ITEM,
                        VinylVibrance.id(name)
                );

        T item = factory.apply(properties.setId(key));
        Registry.register(BuiltInRegistries.ITEM, key, item);
        return item;
    }

    public static final Item DREAMS =
            register(
                    "music_disc_dreams",
                    VinylDiscItem::new,
                    new Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.UNCOMMON)
                            .jukeboxPlayable(ModJukeboxSongs.DREAMS)
            );

    public static final Item SAILS =
            register(
               "music_disc_sails",
               VinylDiscItem::new,
               new Item.Properties()
                       .stacksTo(1)
                       .rarity(Rarity.UNCOMMON)
                       .jukeboxPlayable(ModJukeboxSongs.SAILS)
            );

    public static void initialize() {
        VinylVibrance.LOGGER.info("Initializing items...");
    }
}


