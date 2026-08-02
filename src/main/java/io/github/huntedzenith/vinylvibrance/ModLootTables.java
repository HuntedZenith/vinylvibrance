package io.github.huntedzenith.vinylvibrance;

import net.fabricmc.fabric.api.loot.v3.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;

import io.github.huntedzenith.vinylvibrance.ModItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;

public class ModLootTables {
    public static void initialize() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (source.isBuiltin() && BuiltInLootTables.CAT_MORNING_GIFT.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .when(LootItemRandomChanceCondition.randomChance(0.05f))
                        .add(
                                LootItem.lootTableItem(ModItem.DREAMS)
                        );

                tableBuilder.withPool(poolBuilder);
            }
        });
    }
}
