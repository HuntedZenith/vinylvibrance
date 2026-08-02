package io.github.huntedzenith.vinylvibrance;

import net.fabricmc.fabric.api.loot.v3.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;

import io.github.huntedzenith.vinylvibrance.ModItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;

public class ModLootTables {
    private static void addItemToLootTable(
            ResourceKey<LootTable> targetTable,
            ResourceKey<LootTable> currentTable,
            LootTable.Builder tableBuilder,
            Item item,
            float chance

    ) {
        if (!targetTable.equals(currentTable)) {
            return;
        }

        LootPool.Builder poolBuilder = LootPool.lootPool()
                .when(LootItemRandomChanceCondition.randomChance(chance))
                .add(LootItem.lootTableItem(item));

        tableBuilder.withPool(poolBuilder);
    }


    public static void initialize() {
        VinylVibrance.LOGGER.info("Loot Tables Active!");

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (!source.isBuiltin()) {
                return;
            }

            addItemToLootTable(
                    BuiltInLootTables.CAT_MORNING_GIFT,
                    key,
                    tableBuilder,
                    ModItem.DREAMS,
                    0.08f
            );

            addItemToLootTable(
                    BuiltInLootTables.SHIPWRECK_SUPPLY,
                    key,
                    tableBuilder,
                    ModItem.SAILS,
                    0.05f
            );
        });
    }}