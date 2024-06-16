package nl.teunos.teuns_test_mod.objects.customTest;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.state.BlockState;
import nl.teunos.teuns_test_mod.objects.ModTestBlocks;

public class CustomPoepItem extends Item {

    public CustomPoepItem(Properties properties) {
        super(properties);
    }

    // for the tooltip
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> componentList,
            TooltipFlag tooltipFlag) {
        componentList.add(Component.literal("IEWWWW POEP!"));
        super.appendHoverText(itemStack, tooltipContext, componentList, tooltipFlag);
    }
    

    // For the furnace
    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 200;
    }


    

    @Override
    public InteractionResult useOn(UseOnContext context) {      
        Player player = context.getPlayer();
        if (player == null) {
            return InteractionResult.FAIL;
        }
        
        if (!context.getLevel().isClientSide) {
            BlockPos pos = context.getClickedPos();
            BlockState state = context.getLevel().getBlockState(pos);

            if (!(state.getBlock() == ModTestBlocks.POEPIE_BLOCK.get())) {
                context.getLevel().setBlock(pos, ModTestBlocks.POEPIE_BLOCK.get().defaultBlockState(), 0);

                context.getItemInHand().hurtAndBreak(1, 
                    player,
                    EquipmentSlot.MAINHAND
                );

                // TODO: Not working yet
                // context.getLevel().playSound(context.getPlayer(), pos, SoundEvents.SLIME_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);

                // context.getPlayer().getCooldowns().addCooldown(this, 20);

                return InteractionResult.SUCCESS;
            }

        }
        return InteractionResult.PASS;
        

    }
}
