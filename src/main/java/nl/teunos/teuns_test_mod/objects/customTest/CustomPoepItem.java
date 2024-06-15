package nl.teunos.teuns_test_mod.objects.customTest;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import nl.teunos.teuns_test_mod.objects.ModTestBlocks;

public class CustomPoepItem extends Item {
    public CustomPoepItem(Properties properties) {
        super(properties);
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
                return InteractionResult.SUCCESS;
            }

        }
        return InteractionResult.PASS;

    }
}
