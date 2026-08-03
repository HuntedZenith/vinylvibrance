package io.github.huntedzenith.vinylvibrance;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.function.Function;

public class ModTrimPatterns {
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

    public static Item RECORD =
            register(
                    "record_armor_trim",
                    properties -> SmithingTemplateItem.createArmorTrimTemplate(properties),
                    new Item.Properties()
                            .stacksTo(64)
                            .rarity(Rarity.RARE)
            );


    public static void initialize() {
        VinylVibrance.LOGGER.info("Initializing trims...");
    }
}
