package io.github.huntedzenith.vinylvibrance.mixin;

import io.github.huntedzenith.vinylvibrance.VinylVibrance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
import net.minecraft.tags.DamageTypeTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import io.github.huntedzenith.vinylvibrance.ModItem;

@Mixin(EndCrystal.class)
public class EndCrystalMixin {

    @Inject(
            method = "hurtServer",
            at = @At("TAIL")
    )
    private void vinylVibrance$onCrystalDestroyed(
            ServerLevel level,
            DamageSource source,
            float damage,
            CallbackInfoReturnable<Boolean> cir
    ) {
        if (!source.is(DamageTypeTags.IS_EXPLOSION)) {
            if (level.getRandom().nextFloat() < 0.05f) {
                ItemStack stack = new ItemStack(ModItem.CANNONS);

                ItemEntity itemEntity = new ItemEntity(
                        level,
                        ((EndCrystal) (Object) this).getX(),
                        ((EndCrystal) (Object) this).getY(),
                        ((EndCrystal) (Object) this).getZ(),
                        stack
                );

                level.addFreshEntity(itemEntity);
            }
        }
    }
}